<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../master.page/header.jsp"%>

<body>
	<%@ include file="../master.page/left-panel.jsp"%>

	<div id="right-panel" class="right-panel">

		<%@ include file="../master.page/header-right-panel.jsp"%>

		<div class="content mt-3">
			<html:messages id="changePasswordSuccessMSG" message="true">
				<div
					class="sufee-alert alert with-close alert-success alert-dismissible fade show">
					<span class="badge badge-pill badge-success">Success</span>
					<bean:write name="changePasswordSuccessMSG" />
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			</html:messages>
			<div class="animated fadeIn">

				<div class="ui-typography">
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="card-header">
									<strong class="card-title" v-if="headerText">Thông tin
										chi tiết người dùng</strong>
								</div>
								<div class="card-body">
									<div class="vue-misc">
										<div class="row">
											<div class="col-md-6">
												<address class="mt-3">
													<html:form action="/change-password" method="post">
														<table style="width: 890px;">
															<tr>
																<td><div class="form-group">
																		<label for="nf-email" class=" form-control-label">Mật
																			khẩu cũ <span class="request-input"
																			style="color: red">(*)</span>
																		</label>
																	</div></td>
																<td class="data-input"><input type="password"
																	id="nf-email" name="password"
																	placeholder="nhập vào mật khẩu cũ.."
																	required="required" class="form-control"></td>
																<td></td>
															</tr>
															<tr>
																<td><div class="form-group">
																		<label for="nf-email" class=" form-control-label">Mật
																			khẩu mới <span class="request-input"
																			style="color: red">(*)</span>
																		</label>
																	</div></td>
																<td class="data-input"><input type="password"
																	id="nf-email" name="newpassword"
																	placeholder="nhập vào mật khẩu mới.."
																	required="required" class="form-control"></td>
																<td></td>
															</tr>
															<tr>
																<td><div class="form-group">
																		<label for="nf-email" class=" form-control-label">Nhập
																			lại mật khẩu mới <span class="request-input"
																			style="color: red">(*)</span>
																		</label>
																	</div></td>
																<td class="data-input"><input type="password"
																	id="nf-email" name="newpasswordagain"
																	placeholder="nhập vào mật khẩu mới.."
																	required="required" class="form-control"></td>
																<td></td>
															</tr>
															<tr>
																<td></td>
																<td></td>
																<td style="text-align: right;">
																	<button type="submit" class="btn btn-primary btn-sm"
																		name="submit" value="submit">
																		<i class="fa fa-dot-circle-o"></i> Đổi mật khẩu
																	</button>
																	<button type="reset" class="btn btn-danger btn-sm"
																		onclick="visitPage()">
																		<i class="fa fa-ban"></i> Trở về
																	</button>
																</td>
															</tr>
														</table>
													</html:form>
												</address>
											</div>
										</div>
									</div>
								</div>
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
			window.location = '${pageContext.servletContext.contextPath}/home.html';
		}
	</script>
	<%@ include file="../master.page/footer.jsp"%>