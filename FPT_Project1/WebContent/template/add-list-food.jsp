<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../master.page/header.jsp"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<body>
	<%@ include file="../master.page/left-panel.jsp"%>

	<div id="right-panel" class="right-panel">

		<%@ include file="../master.page/header-right-panel.jsp"%>
		<div class="content mt-3">
			<div class="animated fadeIn">
				<div class="row">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-header">
								<strong>Thêm thực đơn</strong>
							</div>
							<div class="card-body card-block">
								<form action="">

									<div class="container">
										<h3>Bữa sáng</h3>
										<div class="panel panel-default">
											<div class="panel-body">
												<table>
													<tr>
														<td><div class="form-group">
																<label for="nf-email" class=" form-control-label">Tên
																	món ăn <span class="request-input" style="color: red">(*)</span>
																</label>
															</div></td>
														<td class="data-input"><input type="text"
															id="bua-sang" name="medicname"
															placeholder="tên món ăn.." required="required"
															class="form-control"></td>
													</tr>
												</table>
											</div>
										</div>
										<h3>Bữa Trưa</h3>
										<div class="panel panel-default">
											<div class="panel-body">
												<table>
													<tr>
														<td><div class="form-group">
																<label for="nf-email" class=" form-control-label">Tên
																	món ăn <span class="request-input" style="color: red">(*)</span>
																</label>
															</div></td>
														<td class="data-input"><input type="text"
															id="bua-trua" name="medicname"
															placeholder="tên món ăn.." required="required"
															class="form-control"></td>
													</tr>
												</table>
											</div>
										</div>
										<h3>Buổi Tối</h3>
										<div class="panel panel-default">
											<div class="panel-body">
												<table>
													<tr>
														<td><div class="form-group">
																<label for="nf-email" class=" form-control-label">Tên
																	món ăn <span class="request-input" style="color: red">(*)</span>
																</label>
															</div></td>
														<td class="data-input"><input type="text"
															id="bua-toi" name="medicname"
															placeholder="tên món ăn.." required="required"
															class="form-control"></td>
													</tr>
												</table>
											</div>
										</div>
									</div>

									<div class="card-footer">
										<button type="submit" class="btn btn-primary btn-sm"
											name="submit" value="submit">
											<i class="fa fa-dot-circle-o"></i> Thêm
										</button>
										<button type="reset" class="btn btn-danger btn-sm">
											<i class="fa fa-ban"></i> Trở về
										</button>
									</div>
								</form>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
		<%@ include file="../master.page/footer.jsp"%>
	<script type="text/javascript">
			
	
	
	</script>
	