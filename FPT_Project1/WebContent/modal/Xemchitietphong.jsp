
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="mytags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="modal fade" id="viewcs-detail" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">New message</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Mã phòng:</label>
           <strong id="ma-phong"></strong>
          </div>
           <div class="form-group" >
            <label for="recipient-name" class="col-form-label">Khu điều trị:</label>
            <strong id="khu-dieu-tri"></strong>
          </div>
           <div class="form-group">
            <label for="recipient-name" class="col-form-label">Diện tích:</label>
			<strong id="area"></strong>
          </div>
           <div class="form-group">
            <label for="recipient-name" class="col-form-label">Tình trạng phòng:</label>
            <strong id="stateroom"></strong>
          </div>
           <div class="form-group">
            <label for="recipient-name" class="col-form-label">Số giường:</label>
          <strong id="numberofbeds"></strong>
          </div>
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Mô tả khu vực:</label>
         <strong id="decristion"></strong>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>