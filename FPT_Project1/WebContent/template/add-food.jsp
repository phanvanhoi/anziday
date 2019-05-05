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
								<strong>Thêm món ăn</strong>
							</div>
							<div class="card-body card-block">
								<form action="">
									<table>
										<tr>
											<td><div class="form-group">
													<label for="nf-email" class=" form-control-label">Tên
														món ăn <span class="request-input" style="color: red">(*)</span>
													</label>
												</div></td>
											<td class="data-input"><input type="text" id="food-name"
												name="medicname" placeholder="tên món ăn.."
												required="required" class="form-control"></td>
										</tr>
										<tr>
											<td><div class="form-group">
													<label for="nf-email" class=" form-control-label">
														Thành phần nguyên liệu <span class="request-input"
														style="color: red">(*)</span>
													</label>
												</div></td>
											<td class="data-input" id="suggest-input"><input type="text" 
												name="color" placeholder=""
												required="required" title="Không được để trống"
												class="form-control"></td>
										</tr>
										<tr>
											<td><div class="form-group">
													<label for="nf-email" class=" form-control-label">Mô
														Tả <span class="request-input" style="color: red">(*)</span>
													</label>
												</div></td>
											<td class="data-input"><textarea placeholder="Mô tả.."
													class="form-control" required="required"
													title="Không được để trống!" rows="5" id="comment"
													name="decription" id="decription"></textarea></td>
										</tr>
										<tr>
											<td><div class="form-group">
													<label for="nf-email" class=" form-control-label">
														Hình thức <span class="request-input" style="color: red">(*)</span>
													</label>
												</div></td>
											<td class="data-input"><input type="text" id="fommatly"
												name="quantity" placeholder="hình thức" required="required"
												title="Không được để trống" class="form-control"></td>
										</tr>
										<tr>
											<td><div class="form-group">
													<label for="nf-email" class=" form-control-label">
														Chống chỉ định <span class="request-input"
														style="color: red">(*)</span>
													</label>
												</div></td>
											<td class="data-input"><input type="text" id="illness"
												name="quantity" placeholder="chống chỉ định.."
												required="required" title="Không được để trống"
												class="form-control"></td>
										</tr>
										<tr>
											<td><div class="form-group">
													<label for="nf-email" class=" form-control-label">
														Thích hợp với đối tượng <span class="request-input"
														style="color: red">(*)</span>
													</label>
												</div></td>
											<td class="data-input"><input type="text"
												id="group-person" name="quantity"
												placeholder="thích hợp với người" required="required"
												title="Không được để trống" class="form-control"></td>
										</tr>
										<tr>
											<td><div class="form-group">
													<label for="nf-email" class=" form-control-label">Khu
														vực phù hợp <span class="request-input" style="color: red">(*)</span>
													</label>
												</div></td>
											<td>
												<div class="form-group">
													<select id="location-drop"
														class="form-control selectpicker"  multiple
														data-live-search="true">
														<option value="0">Miền Bắc</option>
														<option value="1">Miền Trung</option>
														<option value="2">Miền Nam</option>
													</select>
												</div>
											</td>

										</tr>
										<tr>
											<td><div class="form-group">
													<label for="nf-email" class=" form-control-label">Mùa
														phù hợp <span class="request-input" style="color: red">(*)</span>
													</label>
												</div></td>
											<td>
												<div class="form-group">
													<select id="session-drop" class="form-control selectpicker" multiple
														data-live-search="true">
														<option value="0">Mùa nóng</option>
														<option value="1">Lạnh</option>
													</select>
												</div>
											</td>

										</tr>
										<tr>
											<th>
												<div class="form-group">
													<label for="nf-email" class=" form-control-label">Hình
														ảnh<span class="request-input" style="color: red">(*)</span>
													</label>
												</div>
											</th>
											<td><input type="file" name="image"
												value="${forms.image}" accept="image/*" id="image" /></td>
										</tr>
									</table>




									<div class="card-footer">
										<button type="submit" class="btn btn-primary btn-sm"
											name="submit" value="submit" id="add-btn">
											<i class="fa fa-dot-circle-o"></i> Thêm
										</button>
										<button type="reset" class="btn btn-danger btn-sm">
											<i class="fa fa-ban"></i> Trở về
										</button>
									</div>
								</form>
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
  <script type="text/javascript" src="jquery.amsify.suggestags.js"></script>
  
	<script type="text/javascript">
	
	var td2 = document.getElementsByClassName('data-input');
	for(let i = 0; i<td2.length;i++){
		td2[i].style.width = "700px";
	}

	var db = firebase.firestore();

	var loaibenh = document.getElementById('illness');
	var nhomnguoi = document.getElementById('group-person');

	

	function callSomeSyns(){
		return new Promise(function(resolve,reject){
			
			db.collection("matirial").get().then(function(querySnapshot) {
				var dataFirebase = [];
	    		querySnapshot.forEach(function(doc) {
	        		dataFirebase.push(doc.data().name);
	    		});	
	    	resolve(dataFirebase);
			});
		});
	};

	async function loadAutoComplete(){
		let result = await callSomeSyns();
		console.log(result);
		$('input[name="color"]').amsifySuggestags({
			suggestions: result,
			tagLimit: 5
		});
	};

	loadAutoComplete();


	function getDataloadUp(item){
		return new Promise(function(resolve,reject){
			db.collection("matirial").where("name","==",item).get().then(function(querySnapshot) {
				var illnesss = [];
				var groupPersons = [];
		    	querySnapshot.forEach(function(doc) {
		        	illnesss.push(doc.data().illness);
		        	groupPersons.push(doc.data().groupPerson);
		    	});
		    	resolve({ill :illnesss, grp :groupPersons});

		    });
		});
	};
	
	
	var gupPerson = [];
	var illnejt = [];
	
	
	
	
	$("#suggest-input").bind("DOMNodeInserted DOMNodeRemoved",function(){
		loaibenh.innerText ="";
    	nhomnguoi.innerText ="";
		var illnesssList = new Set();
		var groupPersonsList = new Set(); 
		setTimeout(function(){
			dataSelected.forEach(function(item){
				getDataloadUp(item)
				.then(function(data){
					if(data.ill!=""){
						data.ill.forEach(function(item){
							item.forEach(function(value){
								illnesssList.add(value);
							});
						});
					}
					if(data.grp!=""){
						data.grp.forEach(function(item){
							item.forEach(function(value){
									groupPersonsList.add(value);
							});
						});
					}
				});
    		});
    		setTimeout(function(){
    			let groper = Array.from(groupPersonsList);
    			let illnes = Array.from(illnesssList);
    			gupPerson = groper;
    			illnejt = illnes;
    			console.log(groper,illnes);
 				loaibenh.value = illnes.join();   			
 				nhomnguoi.value = groper.join();  	

    		},1000);

		}, 1000);
	});
	
	
	
	
		/* khai bao bien de xuong khi onclikc lay du lieu */
		 var sessionSelected = [];  
	     var locationSelected = [];
	     
	     	/* session-drop bat su kien muti select	 */
		 
		        $('#session-drop').multiselect({
		          onChange: function(element, checked) {
		              var session = $('#session-drop option:selected');
		              sessionSelected = [];
		              $(session).each(function(index, brand){
		            	  
		            	  sessionSelected.push([$(this).val()]);  
		              });
		              
		              console.log(sessionSelected);
		             
		          }
		        });
		        /* location-drop bat su kien muti select */
		        $('#location-drop').multiselect({
			         onChange: function(element, checked) {
			        	  var location = $('#location-drop option:selected');
			        	  locationSelected = [];
			        	  $(location).each(function(index, brand){
			        		  
			            	  locationSelected.push([$(this).val()]);  
			              });
			          
		       		 console.log(locationSelected);
		        
		    	}
		   	});
		   
/* 			var btn = document.getElementById('add-btn');
			btn.addEventListener('click', function() {
				var foodName = document.getElementById('food-name');
				var matirial = document.getElementById('matirial');
				var decription = document.getElementById('decription');
				var groupPerson = document.getElementById('group-person');
				var fommatly = document.getElementById('fommatly');
				var illness = document.getElementById('illness');
				var location = document.getElementById('location-drop');
				var image = document.getElementById('image');
				
				var slipstrImage = image.substring(image.lastIndexOf(""),);
				var docdata = {
						nameFood : foodName.value,
						matirial : dataSelected,
						illness	 : illnejt,
						groupPerson : gupPerson,
						formatly : fommatly.value,
						location : locationSelected,
						decription : sessionSelected,
						image : 
						link	 : 
						rating 	 : 0
				}
				
			});
			 */
		</script>