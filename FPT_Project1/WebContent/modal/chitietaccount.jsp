<div class="modal" id="chitiet-account">
	<div class="modal-dialog">
		<div class="modal-content">
			<!-- Modal Header -->
			<div class="modal-header">
				<h4 id="title" class="modal-title" style="color: black;"></h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Modal body -->
			<div class="modal-body">
				<form action="update-account.do" method="post">
					<div class="form-group" style="display: none;">
						<label for="userid">Mã nhân viên:</label> <input type="text"
							class="form-control" id="userid" value="" name="userid">
					</div>
					<div class="form-group">
						<label for="username">Tên tài khoản:</label> <input type="text"
							class="form-control" id="username" value="" name="username">
					</div>
					<div class="form-group">
						<label for="password">Mật khẩu:</label> <input type="password"
							class="form-control" id="password" value="" name="password">
					</div>
					<div class="form-group">
						<label for="typeid">Loại chức vụ:</label> <input type="text"
							class="form-control" id="typeid" value="" name="typeid">
					</div>
					<div class="form-group">
						<label for="status">Trạng thái:</label> <input type="text"
							class="form-control" id="status" value="" name="status">
					</div>
					<button type="submit" class="btn btn-secondary ">Cập nhật</button>
					<button name="block" value="" type="submit" class="btn btn-secondary">Khóa</button>
				</form>
			</div>
			<!-- Modal footer -->
			<div class="modal-footer">
				<button type="button" class="btn btn-danger" data-dismiss="modal">Đóng</button>
			</div>

		</div>
	</div>
</div>
