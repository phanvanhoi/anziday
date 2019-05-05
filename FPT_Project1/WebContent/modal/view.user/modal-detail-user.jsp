<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade" id="viewdetailuser" tabindex="-1" role="dialog"
	aria-labelledby="myLargeModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Chi tiết thông
					tin người dùng</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<table style="width: 700px;">
					<tr>
						<td><strong>Họ và tên: </strong></td>
						<td ><p id="fullname"  style="margin: 0px;"></p></td>
					</tr>

					<tr>
						<td><strong>Mã nhân viên: </strong></td>
						<td ><p id="userid"  style="margin: 0px;"></p></td>
					</tr>

					<tr>
						<td><strong>Chức vụ: </strong></td>
						<td ><p id="typename"  style="margin: 0px;"></p></td>
					</tr>

					<tr>
						<td><strong>Ngày sinh: </strong></td>
						<td ><p id="birthday"  style="margin: 0px;"></p></td>
					</tr>

					<tr>
						<td><strong>Giới tính: </strong></td>
						<td> <p id="gender"  style="margin: 0px;"></p></td>
					</tr>

					<tr>
						<td><strong>Địa chỉ: </strong></td>
						<td ><p id="address"  style="margin: 0px;"></p></td>
					</tr>

					<tr>
						<td><strong>CMND: </strong></td>
						<td ><p id="cmnd"  style="margin: 0px;"></p></td>
					</tr>

					<tr>
						<td><strong>Mail: </strong></td>
						<td><p id="mail"  style="margin: 0px;"></p></td>
					</tr>

					<tr>
						<td><strong>Số điện thoại: </strong></td>
						<td ><p id="phonenumber"  style="margin: 0px;"></p></td>
					</tr>

					<tr>
						<td><strong>Trình độ: </strong></td>
						<td><p id="eduction" style="margin: 0px;"></p></td>
					</tr>

					<tr>
						<td><strong>Tài khoản: </strong></td>
						<td><p  id="username" style="margin: 0px;"></p></td>
					</tr>

					<tr>
						<td><strong>Hệ số lương: </strong></td>
						<td><p  id="salary" style="margin: 0px;"></p></td>
					</tr>
				</table>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
