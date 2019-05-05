<%@page import="com.bo.MedicBO"%>
<%@page import="com.bean.Medic"%>
<%@page import="com.bo.InforMedicBO"%>
<%@page import="com.bean.InforMedic"%>
<%@page import="com.bean.Prescrip"%>
<%@page import="java.util.List"%>
<%@page import="com.bo.PrescripBO"%>
<%
	String prescripid = request.getParameter("prescripid");
	InforMedicBO informedicBo = new  InforMedicBO();
	MedicBO mebo = new  MedicBO();
	List<InforMedic> listinfo = informedicBo.getAllMedicInPrescrip(prescripid);
	for( InforMedic medicinfo : listinfo){
		
		%>
		<tr class="data-row">
			<td><%=mebo.MedicName(Integer.valueOf(medicinfo.getMedicid()))%></td>
			<td><%=medicinfo.getNumpertime()%></td>
			<td><%=medicinfo.getGuideline()%></td>
			
		</tr>
		<%
		
		System.out.print(medicinfo.getMedicid());
	} 

%>
