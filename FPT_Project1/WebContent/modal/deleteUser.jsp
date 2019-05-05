
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="mytags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="modal fade" id="delete-User" tabindex="-1" role="dialog"
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
			<html:form action="action-DeleteUser.do" method="post">
				<div class="modal-body">
					<div class="form-group">
						<label for="recipient-name" class="col-form-label">Bạn có muốn xóa nhân viên:</label> 
						<strong id="useridd"></strong>
						<input type="hidden" name="userid" id="userid"> 		
					</div>
					<div style="text-align: right;">
						<button type="submit" name="submit" value="submit"
						class="btn btn-secondary">Yes</button>
						<button type="button"
						class="btn btn-secondary">No</button>
					</div>
					</div>
			</html:form>
		</div>
	</div>
</div>