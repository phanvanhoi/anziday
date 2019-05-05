<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		
	<script type="text/javascript">
		
		$(document).ready(function () {
			var searchBtn = document.getElementById("searchBtn");
			searchBtn.addEventListener("click", function(){
				var typeofmedic = document.getElementById("drop-medic").value;
				var data = document.getElementById("search-input").value;
 				$.ajax({
					url : "template/TimThuoc.jsp",
					data : {type: typeofmedic,data: data},
					method: "POST",
					success: function(data){
						$("#data-table").html(data);
					}
					
				}); 
			});
			
		});
	
	</script>
</body>
</html>