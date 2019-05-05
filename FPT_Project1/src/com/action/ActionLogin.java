package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.form.LoginForm;

public class ActionLogin extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		LoginForm login = (LoginForm) form;
		HttpSession session = request.getSession();
		if(login.getUsername().equals("hung") && login.getPassword().equals("123")) {
			session.setAttribute("username", login.getUsername());
			return mapping.findForward("success");
		}
		else return mapping.findForward("fail");
	}		
}
