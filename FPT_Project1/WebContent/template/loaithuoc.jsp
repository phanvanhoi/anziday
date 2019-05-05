<%@page import="java.util.ArrayList"%>
<%@page import="com.bean.TypeOfMedic"%>
<%@page import="java.util.List"%>
<%@page import="com.bo.TypeOfMedicBO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

 <% 
 	response.setCharacterEncoding("UTF-8");
 	List<TypeOfMedic> listTypeofmedic = new ArrayList<>();
 	if(request.getParameter("warehouseId")!=null){
 		String makho = request.getParameter("warehouseId");
 		TypeOfMedicBO typeofBO = new TypeOfMedicBO();
 		listTypeofmedic =typeofBO.getTypeOfMedic(makho);
 	
 	}
	for(TypeOfMedic typemedic : listTypeofmedic){
		%> <option value="<%=typemedic.getTypeofmedicid()%>"><%=typemedic.getTypeofmedic()%></option>
		<%
	}
	
 %>
 	