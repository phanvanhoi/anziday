<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<div class="modal fade" id="updatenotification" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Thêm thông báo</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<html:form action="/manage-update-notification" method="post">
				<div class="modal-body">
					<input type="hidden" id="notificationid" name="notificationid">
					<div class="form-group">
						<label for="recipient-name" class="col-form-label">Tên
							thông báo<span style="color: red;">(*)</span>
						</label> <input type="text" class="form-control" id="title" name="title"
							placeholder="thông báo xyz">
					</div>
					<div class="form-group">
						<label for="recipient-name" class="col-form-label">Ngày<span
							style="color: red;">(*)</span></label> <input type="text"
							class="form-control" id="datecreate" name="datecreate"
							placeholder="1/1/2011">
					</div>
					<div class="form-group">
						<label for="recipient-name" class="col-form-label">Nội
							dung<span style="color: red;">(*)</span>
						</label>
						<textarea class="form-control" id="content" name="content"></textarea>
					</div>


				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Hủy</button>
					<button type="submit" name="submit" class="btn btn-success"
						value="submit">Cập nhật</button>
				</div>
			</html:form>
		</div>
	</div>
</div>