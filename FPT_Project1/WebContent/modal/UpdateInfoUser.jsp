<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="mytags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="modal fade" id="update-User" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content" style="width: 550px;">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">New message</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		<html:form action="action-UpdateUser.do" method="post">
					<div class="col-lg-12">
						<div class="card">
							<input type="hidden" name="userid" id="userid"> 
							<div class="card-body card-block" style="width: 1005px;">
									<table class="table table-borderless"  style="width: 1105px;">
										<tbody>
											<tr>
												<th scope="row" style="width: 180px"><label
													for="nf-email" class=" form-control-label">Họ và tên<span
														style="color: red">(*)</span></label></th>
													<td>
													<div class="form-group">
														<input style="width: 280px" id="hovanten" type="text" name="fullname"
															 class="form-control" required> 
													</div>
												</td>
											</tr>
														
											<tr>
												<th>
													<div class="form-group">
														<label for="nf-email" class=" form-control-label">Giới tinh <span class="request-input" style="color: red">(*)</span>
														</label>
													</div>
												</th>
												<td>
													<input type="radio" id="nam" name="gender" value="1"> Nam
  													<input style="margin-left: 4rem" id="nu" class="gender" value="0" type="radio" name="gender"> Nữ
												</td>
											</tr>
											<tr>
												<th>
													<div class="form-group">
														<label for="nf-email" class=" form-control-label">Ngày sinh<span class="request-input" style="color: red">(*)</span>
														</label>
													</div>
												</th>
												<td>
													<input type="date" id="ngaysinhnv" name="birthday">
												</td>
											</tr>
											<tr>
												<th scope="row" style="width: 180px"><label
													for="nf-email" class=" form-control-label">Địa chỉ</label> <span style="color: red">(*)</span></th>
												<td>
													<div class="form-group">
														<input  style="width: 280px" type="text" value="${forms.adress}" id="diachinv" name="adress"  class="form-control">
													</div>
												</td>
											</tr>
											
											
											<tr>
												<th scope="row" style="width: 180px"><label
													for="nf-email" class=" form-control-label">CMND</label><span style="color: red">(*)</span></th>
												<td><div class="form-group">
														<input  style="width: 280px"  type="text" id="cmndnv" name="cmnd" class="form-control">
													</div></td>

											</tr>
											
											<tr>
												<th scope="row" style="width: 180px"><label
													for="nf-email" class=" form-control-label">Mail</label><span style="color: red">(*)</span></th>
												<td><div class="form-group">
														<input  style="width: 280px" type="text" id="mailnv" name="mail"
															 class="form-control">
													</div></td>
											</tr>
											<tr>
												<th scope="row" style="width: 180px"><label
													for="nf-email" class=" form-control-label">Chức vụ</label> <span style="color: red">(*)</span></th>
												<td>
													<div class="form-group">
														<input  style="width: 280px" type="text" id="chucvunv" name="position" required class="form-control">
													</div>	
												</td>
											</tr>
											
										
											<tr>
												<th scope="row" style="width: 180px"><label
													for="nf-email" class=" form-control-label">Số ĐT</label><span style="color: red">(*)</span></th>
												<td><div class="form-group">
														<input style="width: 280px" type="text" id="phonenumbernv" name="phonenumber"
															   class="form-control">
													</div></td>
											</tr>
											
											<tr>
												<th scope="row" style="width: 180px"><label
													for="nf-email" class=" form-control-label">Trình độ VH</label><span style="color: red">(*)</span></th>
												<td><div class="form-group">
													<select class="form-control" id="sel1" name="educationlevel" style="width: 200px;color: black;">
														<option value="THPT">THPT</option>
														<option value="Đại Học">Đại Học</option>
														<option value="Thạc sĩ">Thạc Sĩ</option>
														<option value="Tiến sĩ">Tiến sĩ</option>
													</select>
													</div></td>
											</tr>
												<tr>
												<th scope="row" style="width: 180px"><label
													for="nf-email" class=" form-control-label">Tài khoản</label><span style="color: red">(*)</span></th>
												<td><div class="form-group">
														<input style="width: 280px" type="text" id="usernamenv" name="username"
															class="form-control">
													</div></td>
											</tr>
											<tr>
												<th scope="row" style="width: 180px"><label
													for="nf-email" class=" form-control-label">Hệ số lương</label><span style="color: red">(*)</span></th>
												<td><div class="form-group">
														<input style="width: 280px" type="text" id="coefficientsalarynv" name="coefficientsalary"
															required class="form-control">
													</div>
												</td>
											</tr>
											<tr>
												<th scope="row" style="width: 180px"><label
													for="nf-email" class=" form-control-label">Quyền</label><span style="color: red">(*)</span></th>
												<td>
													<select name="typeid" class="form-control" id="mySelect" style="width: 200px;color: black;">
														<option id="op1" value="1">Doctor</option>
														<option id="op2" value="2">Manager</option>
														<option id="op3" value="3">Staff</option>
													</select>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
							<div class="card-footer">
								<button type="submit" value="submit" name="submit" class="btn btn-primary btn-sm">
									<i class="fa fa-dot-circle-o"></i> Submit
								</button>
							</div>
						</div>
						</html:form>
		</div>
	</div>
</div>