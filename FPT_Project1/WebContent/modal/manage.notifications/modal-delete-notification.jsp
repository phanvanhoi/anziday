<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<div class="modal fade" id="deletenotification" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Xóa thông báo</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<html:form action="/manage-delete-notification" method="post">
				<div class="modal-body">
					<html:hidden property="notificationid" styleClass="form-control" styleId="notificationid"/>
					<p>Bạn có muốn xóa thông báo này không?</p>
				</div>
				<div class="modal-footer">
					<html:submit styleClass="btn btn-success" property="submit" value="submit">Đồng ý</html:submit>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Hủy</button>
				</div>
			</html:form>
		</div>
	</div>
</div>