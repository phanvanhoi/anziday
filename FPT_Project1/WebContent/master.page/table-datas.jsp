<%@page import="com.bean.Account"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<div class="animated fadeIn">
	<div class="row">
		<div class="col-md-12">
			<div class="card">
				<div class="card-header">
					<strong class="card-title">Data Table</strong>
				</div>
				<div class="card-body">
					<table id="bootstrap-data-table-export"
						class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Mã nhân viên</th>
								<th>Tên tài khoản</th>
								<th>Mật khẩu</th>
								<th>Loại chức vụ</th>
								<th>Trạng thái</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<logic:iterate name="accountForm" property="listaccount" id="sv">
								<tr>
									<th scope="row"><bean:write name="sv" property="userid" />	</th>
									<td><bean:write name="sv" property="username" /></td>
									<td><bean:write name="sv" property="password" /></td>
									<td><bean:write name="sv" property="typeid" /></td>
									<td><bean:write name="sv" property="status" /></td>
									<td>
									
										<!-- cua hoi -->
										<!-- <button style="font-size: 15px; margin-left: 11%;"
											type="button" class="btn btn-info btn-lg" data-toggle="modal"
											data-target="#${sv.userid}">Detail</button>  -->
											
										<button style="font-size: 15px; margin-left: 11%;"
											type="button" class="btn btn-secondary " data-toggle="modal"
											data-target="#chitiet-account"
											data-userid="<bean:write name="sv" property="userid" />"
											data-username="<bean:write name="sv" property="username" />"
											data-password="<bean:write name="sv" property="password" />"
											data-typeid="<bean:write name="sv" property="typeid" />"
											data-status="<bean:write name="sv" property="status" />"
											>Xem</button>
											<!-- Modal --> 
									</td>
								</tr>
							</logic:iterate>
						</tbody>
					</table>
				</div>
			</div>
		</div>




	<%-- 	<div class="col-lg-12">
			<div class="card">
				<div class="card-body">
					<h4 class="mb-3">Danh Sách Người Sử Dụng</h4>
					<canvas id="sales-chart"></canvas>
				</div>
			</div>
		</div>
		<!-- /# column --> --%>

	</div>
</div>
<%@ include file="../modal/chitietaccount.jsp"%>
<!-- <script type="text/javascript">
	//Sales chart
	$(window).on('load', function () {
		dataType = new Array();
		var ctx = document.getElementById("sales-chart");
		$.getJSON("${pageContext.servletContext.contextPath}/public/account.json", function(json) {
			console.log("JSON Data: " + json + " : "
					+ json.length);
					for (let i = 0; i < json.length; i++) {
						dataType.push(json[i].password);
					}
					var myChart = new Chart(ctx, {
						type : 'line',
						data : {
							labels : [ "1", "2", "3", "4", "5",
									"6", "7", "8", "9", "10", "11",
									"12" ],
							type : 'line',
							defaultFontFamily : 'Montserrat',
							datasets : [ {
								label : "Số cán bộ",
								data : [ 0, dataType[1], dataType[2], 
										 dataType[3], dataType[4], 
										 dataType[2], dataType[4],
										 dataType[1], dataType[2], 
										 dataType[3], dataType[4], 
										 dataType[2] ],
								backgroundColor : 'transparent',
								borderColor : 'rgba(220,53,69,0.75)',
								borderWidth : 3,
								pointStyle : 'circle',
								pointRadius : 5,
								pointBorderColor : 'transparent',
								pointBackgroundColor : 'rgba(220,53,69,0.75)',
							}, {
								label : "Số bệnh nhân",
								data : [ 0, 6, 12, 18, 24, 30, 36, 42, 48, 54 ,60, 64 ],
								backgroundColor : 'transparent',
								borderColor : 'rgba(40,167,69,0.75)',
								borderWidth : 3,
								pointStyle : 'circle',
								pointRadius : 5,
								pointBorderColor : 'transparent',
								pointBackgroundColor : 'rgba(40,167,69,0.75)',
							}, {
								label : "Số giường bệnh",
								data : [ 0, 5, 10, 15, 20, 25, 30, 35, 40, 45 ,50, 55 ],
								backgroundColor : 'transparent',
								borderColor : 'rgb(153, 234, 251)',
								borderWidth : 3,
								pointStyle : 'circle',
								pointRadius : 5,
								pointBorderColor : 'transparent',
								pointBackgroundColor : 'rgb(153, 234, 251)',
							} , {
								label : "Số phòng điều trị",
								data : [ 0, 4, 8, 12, 16, 20, 24, 28, 32, 36 ,40, 44 ],
								backgroundColor : 'transparent',
								borderColor : 'rgb(153, 77, 251)',
								borderWidth : 3,
								pointStyle : 'circle',
								pointRadius : 5,
								pointBorderColor : 'transparent',
								pointBackgroundColor : 'rgb(153, 77, 251)',
							} , {
								label : "Số thuốc",
								data : [ 0, 3, 6, 9, 12, 15, 18, 21, 24, 27 ,30, 33 ],
								backgroundColor : 'transparent',
								borderColor : 'rgb(131, 21, 18)',
								borderWidth : 3,
								pointStyle : 'circle',
								pointRadius : 5,
								pointBorderColor : 'transparent',
								pointBackgroundColor : 'rgb(131, 21, 18)',
							} , {
								label : "Số đơn thuốc",
								data : [ 0, 2, 4, 6, 8, 10, 12, 14, 16, 18 ,20, 22 ],
								backgroundColor : 'transparent',
								borderColor : 'rgb(18, 21, 18)',
								borderWidth : 3,
								pointStyle : 'circle',
								pointRadius : 5,
								pointBorderColor : 'transparent',
								pointBackgroundColor : 'rgb(18, 21, 18)',
							} , {
								label : "Số thông báo",
								data : [ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 ,10, 11 ],
								backgroundColor : 'transparent',
								borderColor : 'rgb(254, 1, 210)',
								borderWidth : 3,
								pointStyle : 'circle',
								pointRadius : 5,
								pointBorderColor : 'transparent',
								pointBackgroundColor : 'rgb(254, 1, 210)',
							}  ]
						},
						options : {
							responsive : true,

							tooltips : {
								mode : 'index',
								titleFontSize : 12,
								titleFontColor : '#000',
								bodyFontColor : '#000',
								backgroundColor : '#fff',
								titleFontFamily : 'Montserrat',
								bodyFontFamily : 'Montserrat',
								cornerRadius : 3,
								intersect : false,
							},
							legend : {
								display : false,
								labels : {
									usePointStyle : true,
									fontFamily : 'Montserrat',
								},
							},
							scales : {
								xAxes : [ {
									display : true,
									gridLines : {
										display : false,
										drawBorder : false
									},
									scaleLabel : {
										display : false,
										labelString : 'Month'
									}
								} ],
								yAxes : [ {
									display : true,
									gridLines : {
										display : false,
										drawBorder : false
									},
									scaleLabel : {
										display : true,
										labelString : 'Value'
									}
								} ]
							},
							title : {
								display : false,
								text : 'Normal Legend'
							}
						}
					});
				});
 	});
	// console.log("chart: " + myChart.data.datasets[0].data);
</script> -->

<script type="text/javascript">

document.addEventListener("DOMContentLoaded", function(event) {
	$('#chitiet-account').on('show.bs.modal', function(event) {
		var button = $(event.relatedTarget) // Button that triggered the modal
		var userid = button.data('userid') // Extract info from data-* attributes
		var username = button.data('username')
		var typeid = button.data('typeid')
		var status = button.data('status')
		var modal = $(this)
		 $('#title').html(userid)
		 $('#userid').val(userid)
		 $('#username').val(username)
		 $('#password').val(password)
		 $('#typeid').val(typeid)
		 $('#status').val(status)
	})
  });
	
</script>
