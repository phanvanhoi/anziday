<%@tag import="com.bo.StateRoomBO"%>
<%@attribute name="items" required="true" type="java.lang.String"%>
<%
	StateRoomBO sBo = new StateRoomBO();
	request.setAttribute("stateNames", sBo.stateName(items));
%>