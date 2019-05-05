<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../master.page/header.jsp"%>

<body>
	<%@ include file="../master.page/left-panel.jsp"%>

	<div id="right-panel" class="right-panel">

		<%@ include file="../master.page/header-right-panel.jsp"%>

		<div class="content mt-3">
			<html:messages id="changeUserInfoSuccessMSG" message="true">
				<div
					class="sufee-alert alert with-close alert-success alert-dismissible fade show">
					<span class="badge badge-pill badge-success">Success</span>
					<bean:write name="changeUserInfoSuccessMSG" />
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
								<strong class="card-title">Chỉnh sửa thông tin các nhân</strong>
							</div>
							<div class="card-body">
								<form>
									<table>
										<tr>
											<td><div class="form-group">
													<label for="nf-email" class=" form-control-label">Họ
														và tên <span class="request-input" style="color: red">(*)</span>
													</label>
												</div></td>
											<td class="data-input"><input type="text" id="nf-email"
												name="fullname" placeholder="Hãy nhập họ và tên.."
												required="required" class="form-control"
												value="${userInfo.fullname}"></td>
										</tr>

										<tr>
											<td><div class="form-group">
													<label for="nf-email" class=" form-control-label">Giới
														tính <span class="request-input" style="color: red">(*)</span>
													</label>
												</div></td>
											<td class="data-input"><input type="radio"
												id="radio-gender" name="gender" required="required"
												value="1"> Nam <input type="radio" id="radio-gender"
												name="gender" required="required" value="0"> Nữ</td>
										</tr>

										<tr>
											<td><div class="form-group">
													<label for="nf-email" class=" form-control-label">Ngày
														sinh <span class="request-input" style="color: red">(*)</span>
													</label>
												</div></td>
											<td class="data-input"><input type="date"
												id="nf-birthday" name="birthday"
												placeholder="Hãy nhập ngày sinh.." required="required"
												class="form-control" value="${userInfo.birthday}"></td>
										</tr>

										<tr>
											<td><div class="form-group">
													<label for="nf-email" class=" form-control-label">Địa
														chỉ <span class="request-input" style="color: red">(*)</span>
													</label>
												</div></td>
											<td class="data-input"><input type="text" id="nf-email"
												name="address" placeholder="Hãy nhập địa chỉ.."
												required="required" class="form-control"
												value="${userInfo.adress}"></td>
										</tr>

										<tr>
											<td><div class="form-group">
													<label for="nf-email" class=" form-control-label">CMND
														<span class="request-input" style="color: red">(*)</span>
													</label>
												</div></td>
											<td class="data-input"><input type="text" id="nf-email"
												name="cmnd" placeholder="Hãy nhập CMND.."
												required="required" class="form-control"
												value="${userInfo.cmnd}"></td>
										</tr>

										<tr>
											<td><div class="form-group">
													<label for="nf-email" class=" form-control-label">Mail
														<span class="request-input" style="color: red">(*)</span>
													</label>
												</div></td>
											<td class="data-input"><input type="text" id="nf-email"
												name="mail" placeholder="Hãy nhập mail.."
												required="required" class="form-control"
												value="${userInfo.mail}"></td>
										</tr>

										<tr>
											<td><div class="form-group">
													<label for="nf-email" class=" form-control-label">Số
														điện thoại <span class="request-input" style="color: red">(*)</span>
													</label>
												</div></td>
											<td class="data-input"><input type="text" id="nf-email"
												name="phonenumber" placeholder="Hãy nhập số điện thoại.."
												required="required" class="form-control"
												value="${userInfo.phonenumber}"></td>
										</tr>

										<tr>
											<td><div class="form-group">
													<label for="nf-email" class=" form-control-label">Trình
														độ học vấn <span class="request-input" style="color: red">(*)</span>
													</label>
												</div></td>
											<td class="data-input"><select class="form-control"
												id="education-drop" name="education">
													<option value="THPT">THPT</option>
													<option value="Cử nhân">Cử nhân</option>
													<option value="Thạc sĩ">Thạc sĩ</option>
													<option value="Tiến sĩ">Tiến sĩ</option>
													<option value="Phó giáo sư">Phó giáo sư</option>
													<option value="Giáo sư">Giáo sư</option>
											</select></td>
										</tr>
									</table>
									<div class="card-footer">
										<button type="submit" class="btn btn-primary btn-sm"
											name="submit" value="submit">
											<i class="fa fa-dot-circle-o"></i> Đồng ý
										</button>
										<button type="reset" class="btn btn-danger btn-sm"
											onclick="visitPage()">
											<i class="fa fa-ban"></i> Trở về
										</button>
									</div>
								</form>
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
			window.location = '${pageContext.servletContext.contextPath}/manage-notification.html';
		}
		document.getElementById('education-drop').value = "${userInfo.educationlevel}";
	</script>
	<script type="text/javascript">
		$(function() {
			var $radios = $('input:radio[name=gender]');
			if ($radios.is(':checked') === false) {
				$radios.filter('[value=${userInfo.gender}]').prop('checked',
						true);
			}
		});
	</script>
	<%@ include
		file="../modal/view.notifications/modal-detail-notification.jsp"%>
	<%@ include file="../master.page/footer.jsp"%>