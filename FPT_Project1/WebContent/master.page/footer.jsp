<script
	src="${pageContext.servletContext.contextPath}/public/vendors/jquery/dist/jquery.min.js"></script>
<script
	src="${pageContext.servletContext.contextPath}/public/vendors/popper.js/dist/umd/popper.min.js"></script>

<script
	src="${pageContext.servletContext.contextPath}/public/vendors/jquery-validation/dist/jquery.validate.min.js"></script>
<script
	src="${pageContext.servletContext.contextPath}/public/vendors/jquery-validation-unobtrusive/src/jquery.validate.unobtrusive.js"></script>

<script
	src="${pageContext.servletContext.contextPath}/public/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script
	src="${pageContext.servletContext.contextPath}/public/assets/js/main.js"></script>

<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/public/assets/js/modal/modal-notification.js"></script>
	
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/public/assets/js/modal/modal-user.js"></script>

<script
	src="${pageContext.servletContext.contextPath}/public/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
<script
	src="${pageContext.servletContext.contextPath}/public/vendors/datatables.net-bs4/js/dataTables.bootstrap4.min.js"></script>
<script
	src="${pageContext.servletContext.contextPath}/public/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
<script
	src="${pageContext.servletContext.contextPath}/public/vendors/datatables.net-buttons-bs4/js/buttons.bootstrap4.min.js"></script>
<script
	src="${pageContext.servletContext.contextPath}/public/vendors/jszip/dist/jszip.min.js"></script>
<script
	src="${pageContext.servletContext.contextPath}/public/vendors/pdfmake/build/pdfmake.min.js"></script>
<script
	src="${pageContext.servletContext.contextPath}/public/vendors/pdfmake/build/vfs_fonts.js"></script>
<script
	src="${pageContext.servletContext.contextPath}/public/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
<script
	src="${pageContext.servletContext.contextPath}/public/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
<script
	src="${pageContext.servletContext.contextPath}/public/vendors/datatables.net-buttons/js/buttons.colVis.min.js"></script>
<script
	src="${pageContext.servletContext.contextPath}/public/assets/js/init-scripts/data-table/datatables-init.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.9/dist/css/bootstrap-select.min.css">


<script>
	var rowNone = document.getElementsByClassName("dataTables_length");
	for (let i = 0; i < rowNone.length; i++) {
		rowNone[i].style.display = "none";
	}

	var rowNone = document.getElementsByClassName("dataTables_info_none");
	for (let i = 0; i < rowNone.length; i++) {
		rowNone[i].style.display = "none";
	}
	var searchInput = document.querySelectorAll(".form-control-sm")[1].style.width = "437px";
</script>

<script src="https://www.gstatic.com/firebasejs/5.10.1/firebase.js"></script>
<script>
  // Initialize Firebase
  var config = {
    apiKey: "AIzaSyCNZESET-o-q04K7e2VlDNESpxY0eTCqoM",
    authDomain: "anziday1.firebaseapp.com",
    databaseURL: "https://anziday1.firebaseio.com",
    projectId: "anziday1",
    storageBucket: "anziday1.appspot.com",
    messagingSenderId: "287966994864"
  };
  firebase.initializeApp(config);
</script>
</body>

</html>
