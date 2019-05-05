<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../master.page/header.jsp"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
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
								<strong class="card-title">Danh Sách Thuốc</strong>
							</div>
							<!-- <div id="search">
								<div style="display:inherit" id="search-box">
									<i class="fa fa-search" style="padding: 7px 3px 0px 4px"></i>
									<input type="text"  name="medicname" placeholder="tìm thuốc .."
									class="form-control" id="search-input">
								</div>
								<select id="drop-medic">
									<option value="">Tất Cả</option>
									<option value="Medic.TypeOfMedicID">Theo Mã</option>
									<option value="MedicName">Theo Tên</option>
									<option value="WareHouse.WareHouseName">Theo Kho</option>
								</select>
								<button type="button" class="btn btn-secondary" id="searchBtn">Search</button>
							</div> -->
							<div class="card-body">
								<table id="bootstrap-data-table-export"
									class="table table-striped table-bordered">
									<thead>
										<tr>
											<th style="width: 8%">Mã Loại Thuốc</th>
											<th style="width: 20%">Tên Thuốc</th>
											<th style="width: 5%">Số Lượng</th>
											<th style="width: 20%">Mô Tả</th>
											<th style="width: 15%">Kho</th>
											<th style="width: 25%">Chức năng</th>
										</tr>
									</thead>
									<tbody id="data-table">
										<logic:iterate id="medic" name="creNewMedicForm"
											property="listmedic">
											<tr class="data-row">
												<td><bean:write name="medic" property="typeofmedicid" /></td>
												<td><a style="color: #0377f3" href="#"
													data-toggle="modal" data-target="#view-detail-medic"
													data-medicid="<bean:write name="medic" property="medicid" />"
													data-typemedic="<bean:write name="medic" property="typeofmedicid" />"
													data-medicname="<bean:write name="medic" property="medicname" />"
													data-quantity="<bean:write name="medic" property="quantity" />"
													data-decription="<bean:write name="medic" property="decription" />"
													data-warehousename="<bean:write name="medic" property="warehousename" />"><bean:write
															name="medic" property="medicname" /></a></td>
												<td><bean:write name="medic" property="quantity" /></td>
												<td><bean:write name="medic" property="decription" /></td>
												<td><bean:write name="medic" property="warehousename" /></td>
												<td>
													<button  type="button" class="btn btn-secondary update-btn"
														data-toggle="modal" data-target="#update-medic"
														data-medicid="<bean:write name="medic" property="medicid" />"
														data-typemedic="<bean:write name="medic" property="typeofmedicid" />"
														data-medicname="<bean:write name="medic" property="medicname" />"
														data-quantity="<bean:write name="medic" property="quantity" />"
														data-decription="<bean:write name="medic" property="decription" />"
														data-warehousename="<bean:write name="medic" property="warehousename" />"
														data-warehouseid="<bean:write name="medic" property="warehouseid" />">Cập
														nhập</button>
													<button type="button" class="btn btn-secondary delete-btn" 
														data-toggle="modal" data-target="#deletee-medic"
														data-medicname="<bean:write name="medic" property="medicname" />"
														data-medicid="<bean:write name="medic" property="medicid" />"
														>Xóa</button>
												</td>
											</tr>
										</logic:iterate>
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


	<%@ include file="../modal/ViewdetailMedic.jsp"%>
 	<%@ include file="../modal/UpdateMedic.jsp"%>
	<%@ include file="../modal/DeleteMedic.jsp"%>
	<%@ include file="../master.page/footer.jsp"%>


	<script type="text/javascript">
		document.getElementById("bootstrap-data-table-export_length").style.display = "none";
		document.querySelectorAll(".form-control-sm")[1].style.width = "390px";

		document.getElementById("bootstrap-data-table-export_info").style.display = "none";
	</script>
	<script type="text/javascript">
		var warehouseDrop = document.getElementById("warehouse-drop");
		$('#view-detail-medic').on('show.bs.modal', function(event) {
			var button = $(event.relatedTarget) // Button that triggered the modal
			var typeofmedic = button.data('typemedic')
			var name = button.data('medicname')
			var quantity = button.data('quantity')
			var decription = button.data('decription')
			var warehousename = button.data('warehousename')
			console.log(warehousename + '-' + typeofmedic + '-' + quantity)
			// Extract info from data-* attributes
			var modal = $(this)
			modal.find('.modal-body #ma-loai-thuoc').text(typeofmedic)
			modal.find('.modal-body #ten-thuoc').text(name)
			modal.find('.modal-body #so-luong').text(quantity)
			modal.find('.modal-body #mo-ta').text(decription)
			modal.find('.modal-body #ten-kho').text(warehousename)
		});

			$('#update-medic').on('show.bs.modal', function(event) {
			var button = $(event.relatedTarget) // Button that triggered the modal
			var typeofmedic = button.data('typemedic')
			var medicid = button.data('medicid')
			var name = button.data('medicname')
			var quantity = button.data('quantity')
			var decription = button.data('decription')
			var warehousename = button.data('warehousename')
			var warehouseid = button.data('warehouseid')
			
			console.log(medicid + '-' + typeofmedic + '-' + quantity)
			// Extract info from data-* attributes
			var modal = $(this)
			$('#medicid').val(medicid)
			$('#ima-loai-thuoc').val(typeofmedic)
			$('#iten-thuoc').val(name)
			$('#iso-luong').val(quantity)
			$('#imo-ta').val(decription)
			$('#ikho-thuoc').val(warehousename)
			
			warehouseDrop.value= warehouseid;
			$.ajax({
				url : "template/loaithuoc.jsp",
				data : {warehouseId: warehouseid},
				method: "POST",
				success: function(data){
					$("#typemedic-drop").html(data);
				}
				
			});
			
			console.log(typeofmedic);
			document.querySelector('.modal-body #typemedic-drop').value = typeofmedic;
			
			
		});
			/* var updatebtn = document.getElementsByClassName("update-btn");
			for(let i = 0;i < updatebtn.length ;i++){
				updatebtn[i].addEventListener('click', function(){
					var value = warehouseDrop.value;
					$.ajax({
						url : "template/loaithuoc.jsp",
						data : {warehouseId: value},
						method: "POST",
						success: function(data){
							$("#typemedic-drop").html(data);
						}
						
					});
					console.log(value);
				})
			}
			console.log() */
			
			
	 		$('#deletee-medic').on('show.bs.modal', function(event) {
			var button = $(event.relatedTarget) // Button that triggered the modal
			var name = button.data('medicname')
			var medicid =button.data('medicid')
			console.log(name+medicid)
			// Extract info from data-* attributes
			var modal = $(this)
			$('#thong-bao').text("Bạn có muốn xóa "+"\""+name+"\"")
			$('#dmedicid').val(medicid)
		});

	 		
	 		
			warehouseDrop.addEventListener("change", function(){
				var value = warehouseDrop.value;
				$.ajax({
					url : "template/loaithuoc.jsp",
					data : {warehouseId: value},
					method: "POST",
					success: function(data){
						$("#typemedic-drop").html(data);
					}
					
				});
				console.log(value);
			});
		// bat su kien on click

		/* document.addEventListener("DOMContentLoaded", function(event) {
			var dataRow = document.getElementsByClassName("data-row");
			for(let i = 0 ; i < dataRow.length ; i++){
				dataRow[i].addEventListener("click", function(){
					$('#view-detail-medic').modal('show');
					var dataTd = dataRow[i].getElementsByTagName("td");
					var id = dataTd[0].innerText;
					var name = dataTd[1].innerText;
					var soluong = dataTd[2].innerText;
					var mota = dataTd[3].innerText;
					var tenkho = dataTd[4].innerText;
					console.log(soluong+"-"+id);
					modal.find('.modal-body #ma-loai-thuoc').text(typeofmedic)
					modal.find('.modal-body #ten-thuoc').text(name)
					modal.find('.modal-body #so-luong').text(quantity)
					modal.find('.modal-body #mo-ta').text(decription)
					modal.find('.modal-body #ten-kho').text(warehousename)
				});
			}
		 }); */
	</script>
