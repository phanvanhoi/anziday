<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="mytags"%>
<div class="modal fade" id="update-medic" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Cập nhập thuốc</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<!-- <span aria-hidden="true">&times;</span> -->
				</button>
			</div>
			<div class="modal-body">
				<html:form action="update-medic" method="post" >
					<div class="form-group">
						<input type="hidden" id="medicid" name="medicid">
						<label for="recipient-name" class="col-form-label"
							style="display: flex"> Mã Loại Thuốc : 
						</label>
						<!-- <input type="text"
							class="form-control" id="ima-loai-thuoc" class="data-collect" name="typeofmedicid">  -->
							
							<select id="typemedic-drop" name="typeofmedicid" class="form-control" required>
							     
							</select>
					</div>
					<div class="form-group">
						<label for="recipient-name" class="col-form-label"
							style="display: flex"> Tên Thuốc : </label> <input
							type="text" id="iten-thuoc" class="form-control"
							class="data-collect" name="medicname" required="required">
					</div>
					<div class="form-group">
						<label for="recipient-name" class="col-form-label"
							style="display: flex"> Số Lượng : </label> <input type="text"
							id="iso-luong" class="form-control" class="data-collect" name="quantity" required="required" pattern="\d*">
					</div>
					<div class="form-group">
						<label for="recipient-name" class="col-form-label"
							style="display: flex"> Mô tả : </label> <textarea
							id="imo-ta" class="form-control" class="data-collect" name="decription" required="required"></textarea>
					</div>
					<div class="form-group">
						<html:select styleId="warehouse-drop" property="warehouseid"
													styleClass="form-control" >
													<html:optionsCollection name="creNewMedicForm"
														property="listwarehouse" label="warehousename"
														value="warehouseid" />
												</html:select>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-secondary" data-tagert="">Cập
							Nhập</button>
						<button type="button" class="btn btn-secondary" data-tagert=""
							data-dismiss="modal">Trở về</button>
					</div>
					
				</html:form>
			</div>
			<!--modal-body -->
		</div>
		<!-- modal-content -->
	</div>
</div>
