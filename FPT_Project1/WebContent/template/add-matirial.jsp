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
					<div class="col-lg-12">
						<div class="card">
							<div class="card-header">
								<strong>Thêm nguyên liệu</strong>
							</div>
							<div class="card-body card-block">
									<div class="container">
										<table>
											<tr>
												<td><div class="form-group">
														<label for="nf-email" class=" form-control-label">Tên nguyên liệu 
															 <span class="request-input" style="color: red">(*)</span>
														</label>
													</div></td>
												<td class="data-input"><input type="text" id="matirial-name"
													name="medicname" placeholder="tên nguyên liệu .."
													required="required" class="form-control"></td>
											</tr>
											<tr>
											<td><div class="form-group">
													<label for="nf-email" class=" form-control-label">Chống chỉ định <span class="request-input" style="color: red">(*)</span>
													</label>
												</div></td>
											<td>
												<div class="form-group">
													<select id="illness-drop"
														class="form-control selectpicker"  multiple
														data-live-search="true">
														<option value="Tiểu đường">Tiểu đường</option>
														<option value="Gout">Gout</option>
														<option value="Mỡ Máu">Mỡ Máu</option>
														<option value="Huyết áp cao">Huyết áp cao</option>
														<option value="Tim mạch">Tim mạch</option>
														<option value="Viêm gan">Viêm gan </option>

													</select>
												</div>
											</td>

										</tr>
										<tr>
											<td><div class="form-group">
													<label for="nf-email" class=" form-control-label">Thích hợp với đối tượng <span class="request-input" style="color: red">(*)</span>
													</label>
												</div></td>
											<td>
												<div class="form-group">
													<select id="group-drop"
														class="form-control selectpicker"  multiple
														data-live-search="true">
														<option value="Tiểu đường">Tiểu đường</option>
														<option value="Gout">Gout</option>
														<option value="Mỡ Máu">Mỡ Máu</option>
														<option value="Huyết áp cao">Huyết áp cao</option>
														<option value="Tim mạch">Tim mạch</option>
														<option value="Viêm gan">Viêm gan </option>
														<option value="Tăng cân">Tăng cân</option>
														<option value="Giảm cân">Giảm cân</option>
														<option value="Ăn chay">Ăn chay</option>
													</select>
												</div>
											</td>

										</tr>
										</table>
										<button  id="add-btn" class="btn btn-primary btn-sm"
										>
											<i class="fa fa-dot-circle-o"></i> Thêm
										</button>
										<button type="reset" class="btn btn-danger btn-sm">
											<i class="fa fa-ban"></i> Trở về
										</button>
									</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
		<%@ include file="../master.page/footer.jsp"%>
		  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.js"></script>
  <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-multiselect/0.9.13/js/bootstrap-multiselect.js"></script>
		<script type="text/javascript">
		
		var db = firebase.firestore();
		 var illnessSelected = [];  
	     var groupSelected = [];
	     
	     	/* session-drop bat su kien muti select	 */
		 
		        $('#illness-drop').multiselect({
		          onChange: function(element, checked) {
		              var illness = $('#illness-drop option:selected');
		              illnessSelected = [];
		              $(illness).each(function(index, brand){
		            	  
		            	  illnessSelected.push($(this).val());  
		              });
		              
		              console.log(illnessSelected);
		             
		          }
		        });
		        /* location-drop bat su kien muti select */
		        $('#group-drop').multiselect({
			         onChange: function(element, checked) {
			        	  var group = $('#group-drop option:selected');
			        	  groupSelected = [];
			        	  $(group).each(function(index, brand){
			        		  
			        		  groupSelected.push($(this).val());  
			              });
			          
		       		 console.log(groupSelected);
		        
		    	}
		   	});
		    var nameMatirial = document.getElementById('matirial-name');
		    var addbtn = document.getElementById("add-btn");
		    addbtn.addEventListener('click', function(){
		    	var matirial = {
		    			name : nameMatirial.value,
		    			groupPerson : groupSelected,
		    			illness : illnessSelected
		    	}
		    	console.log(matirial);
		    	if(matirial.name == null){
		    		alert("Nguyên liệu không được bỏ trống")
		    	} else {
		    	 	db.collection("matirial").add(matirial).then(function() {
					   	alert("Thêm dữ liệu thành công");
					   	nameMatirial.value = "";	
					});
		    	}
		    });
		        
		</script>