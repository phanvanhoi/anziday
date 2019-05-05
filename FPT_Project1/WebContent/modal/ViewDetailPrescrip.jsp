<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="modal fade bd-example-modal-lg" id="view-detail-prescrip"
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
				<div id="table-data"></div>
					<table id="bootstrap-data-table-export"
									class="table table-striped table-bordered">
									<thead>
										<tr>
											<th style="width: 30%">Tên Thuốc</th>
											<th style="width: 30%">Liều dùng</th>
											<th style="width: 40%">Cách dùng</th>
										</tr>
									</thead>
									<tbody id="data-tables">
										

									</tbody>
								</table>
			</div>
		</div>

	</div>
</div>
