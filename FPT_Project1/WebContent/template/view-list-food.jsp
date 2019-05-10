<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../master.page/header.jsp"%>

<body>
	<%@ include file="../master.page/left-panel.jsp"%>

	<div id="right-panel" class="right-panel">

		<%@ include file="../master.page/header-right-panel.jsp"%>

		<div class="content mt-3">
			<div class="animated fadeIn">
				<div class="row">

					<div class="col-md-12">
						<div class="card">
							<div class="card-header">
								<strong class="card-title">Danh sách người sử dụng</strong>
							</div>
							<div class="card-body">

								<table id="bootstrap-data-table-export"
									class="table table-striped table-bordered">
									<thead>
										<tr>
											<th width="10%">Tên món</th>
											<th width="20%">Thành phần</th>
											<th width="10%">Mô tả</th>
											<th width="20%">Tiền sử bệnh</th>
											<th width="20%">Nhóm người</th>
											<th width="20%">Hình thức</th>
										</tr>
									</thead>
									<tbody id="content">	
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- .animated -->
		</div>
		<!-- .content -->
	</div>
	<%@ include
		file="../modal/view.user/modal-detail-user.jsp"%>
	<%@ include file="../master.page/footer.jsp"%>
	
	<script type="text/javascript">
	
	$('#viewdetailuser').on('show.bs.modal', function(event) {
		var button = $(event.relatedTarget) // Button that triggered the modal
		var userid = button.data('userid')
		var username = button.data('username')
		var fullname = button.data('fullname')
		var typename = button.data('typename')
		var birthday = button.data('birthday')
		var gender = button.data('gender')
		var adress = button.data('adress')
		var cmnd = button.data('cmnd')
		var mail = button.data('mail')
		var phonenumber = button.data('phonenumber')
		var coefficientsalary = button.data('coefficientsalary')
		var educationlevel = button.data('educationlevel')
		
		
		$('#fullname').text(fullname)
		$('#userid').text(userid)
		$('#typename').text(typename)
		$('#birthday').text(birthday)
		$('#gender').text(gender)
		$('#address').text(adress)
		$('#cmnd').text(cmnd)
		$('#mail').text(mail)
		$('#phonenumber').text(phonenumber)
		$('#eduction').text(educationlevel)
		$('#username').text(username)
		$('#salary').text(coefficientsalary)
		
		
	})
	</script>
	
 <script>
	var db = firebase.firestore();
	content = '';
	db.collection("foods").get().then(function(querySnapshot) {
	    querySnapshot.forEach(function(doc) {
	    	content +='<tr role="row">'
	    				+'<td>' + doc.data().nameFood +'</td>'
	    				+'<td>' + doc.data().material + '</td>'
	    				+'<td>' + doc.data().decription + '</td>'
	    				+'<td>' + doc.data().illness + '</td>'
	    				+'<td>' + doc.data().groupPerson + '</td>'
	    				+'<td>' + doc.data().formatly + '</td>'+
	    			   '</tr>'
	    });
	    document.getElementById('content').innerHTML = content;
	});
</script>