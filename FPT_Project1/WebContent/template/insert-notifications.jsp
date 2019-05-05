<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../master.page/header.jsp"%>

<body>
	<%@ include file="../master.page/left-panel.jsp"%>

	<div id="right-panel" class="right-panel">

		<%@ include file="../master.page/header-right-panel.jsp"%>

		<div class="content mt-3">
			<html:messages id="insertNotifySuccessMSG" message="true">
				<div
					class="sufee-alert alert with-close alert-success alert-dismissible fade show">
					<span class="badge badge-pill badge-success">Success</span>
					<bean:write name="insertNotifySuccessMSG" />
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			</html:messages>

			<div class="animated fadeIn">
				<div class="row">

					<div class="col-md-12">
						<div class="card">
							<div class="card-header">
								<strong class="card-title">Thêm thông báo</strong>
							</div>
							<div class="card-body">
								<html:form action="/manage-insert-notification" method="post">
									<table>
										<tr>
											<td><div class="form-group">
													<label for="nf-email" class=" form-control-label">Tên
														Thông báo <span class="request-input" style="color: red">(*)</span>
													</label>
												</div></td>
											<td class="data-input"><input type="text" id="nf-email"
												name="title" placeholder="Tên Thông báo.."
												required="required" class="form-control"></td>
										</tr>

										<tr>
											<td><div class="form-group">
													<label for="nf-email" class=" form-control-label">Ngày
														<span class="request-input" style="color: red">(*)</span>
													</label>
												</div></td>
											<td class="data-input"><input type="date" id="nf-email"
												name="datecreate" placeholder="Ngày.." required="required"
												class="form-control"></td>
										</tr>

										<tr>
											<td><div class="form-group">
													<label for="nf-email" class=" form-control-label">Nội
														dung <span class="request-input" style="color: red">(*)</span>
													</label>
												</div></td>
											<td class="data-input"><textarea name="content"
													required="required" class="form-control"
													placeholder="Nhập nội dung..."></textarea></td>
										</tr>
									</table>
									<div class="card-footer">
										<button type="submit" class="btn btn-primary btn-sm"
											name="submit" value="submit">
											<i class="fa fa-dot-circle-o"></i> Thêm
										</button>
										<button type="reset" class="btn btn-danger btn-sm"
											onclick="visitPage()">
											<i class="fa fa-ban"></i> Trở về
										</button>
									</div>
								</html:form>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- .animated -->
		</div>
		<!-- .content -->
	</div>
	<script type="text/javascript">
		function visitPage() {
			window.location = '${pageContext.servletContext.contextPath}/manage-notification.do';
		}
	</script>
	<%@ include
		file="../modal/view.notifications/modal-detail-notification.jsp"%>
	<%@ include file="../master.page/footer.jsp"%>