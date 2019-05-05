
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="mytags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="modal fade" id="update-rooms" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">New message</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<html:form action="update-room.do" method="post">
				<div class="modal-body">

					<div class="form-group">
						<label for="recipient-name" class="col-form-label">Mã
							phòng:</label> <input style="font-weight: 600; width: 100px" type="text"
							class="form-control" id="maphongroom" name="roomid">
					</div>
					<div class="form-group">
						<label for="recipient-name" class="col-form-label">Khu
							điều trị:</label> <input style="font-weight: 600; width: 100px"
							type="text" class="form-control" id="khu-dieu-tri-room"
							name="treatmentid">
					</div>
					<div class="form-group">
						<label for="recipient-name" class="col-form-label">Diện
							tích:</label> <input style="font-weight: 600; width: 100px" type="text"
							class="form-control" id="area-room" name="area">
					</div>
					<div class="form-group">
						<label for="recipient-name" class="col-form-label">Tình
							trạng phòng:</label> <input style="font-weight: 600; width: 100px"
							type="text" class="form-control" id="stateroom-room"
							name="stateid">
					</div>
					<div class="form-group">
						<label for="recipient-name" class="col-form-label">Số
							giường:</label> <input style="font-weight: 600; width: 100px" type="text"
							class="form-control" id="numberofbeds-room" name="numberofbeds">
					</div>
					<div class="form-group">
						<label for="recipient-name" class="col-form-label">Mô tả
							khu vực:</label>
						<textarea rows="4" cols="50" id="decristion-room"
							name="decristion"></textarea>
					</div>
				</div>
				<div class="modal-footer">
					<button type="submit" name="submit" value="submit"
						class="btn btn-secondary">Cập nhật</button>
				</div>
			</html:form>
		</div>
	</div>
</div>