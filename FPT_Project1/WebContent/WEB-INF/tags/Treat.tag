<%@tag import="com.bo.TreatmentAreaFormBO"%>
<%@attribute name="items" required="true" type="java.lang.String"%>
<% 
	TreatmentAreaFormBO areaFormBO = new TreatmentAreaFormBO();
	request.setAttribute("treatNames", areaFormBO.TreaName(items));
%>