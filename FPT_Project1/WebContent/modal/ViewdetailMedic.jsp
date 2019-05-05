<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<div class="modal fade bd-example-modal-lg" id="view-detail-medic"
	tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
	aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Chi Tiết thuốc</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<html:form>
					<div class="form-group">
						<label for="recipient-name" class="col-form-label"
							style="display: flex"> Mã Loại Thuốc :
							<h6 id="ma-loai-thuoc" class="data-collect"></h6>
						</label>
					</div>
					<div class="form-group">
						<label for="recipient-name" class="col-form-label"
							style="display: flex"> Tên Thuốc :
							<h6 id="ten-thuoc" class="data-collect"></h6>
						</label>
					</div>
					<div class="form-group">
						<label for="recipient-name" class="col-form-label"
							style="display: flex"> Số Lượng :
							<h6 id="so-luong" class="data-collect"></h6>
						</label>
					</div>
					<div class="form-group">
						<label for="recipient-name" class="col-form-label"
							style="display: flex"> Mô tả :
							<h6 id="mo-ta" class="data-collect"></h6>
						</label>
					</div>
					<div class="form-group">
						<label for="recipient-name" class="col-form-label"
							style="display: flex"> Kho Thuốc :
							<h6 id="ten-kho" class="data-collect"></h6>
						</label>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-tagert="" data-dismiss="modal">Trở về</button>
					</div>
				</html:form>

			</div>
		</div>

	</div>
</div>
