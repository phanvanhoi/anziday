<%@tag import="com.bo.TypeOfMedicBO"%>
<%@attribute name="idkho" required="true" rtexprvalue="true" type="java.lang.String"%>
<% 
	TypeOfMedicBO bo = new TypeOfMedicBO();


	request.setAttribute("listtypeofmedic", bo.getTypeOfMedic(idkho));
%>