<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="mytags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="modal fade" id="viewcs-InfoUsers1" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
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
            <label for="recipient-name" class="col-form-label">Họ và tên:</label>
           <strong id="hovaten"></strong>
          </div>
           <div class="form-group" >
            <label for="recipient-name" class="col-form-label">Mã nhân viên:</label>
            <strong id="manv"></strong>
          </div>
           <div class="form-group">
            <label for="recipient-name" class="col-form-label">Chức vụ:</label>
			<strong id="chucvu"></strong>
          </div>
           <div class="form-group">
            <label for="recipient-name" class="col-form-label">Ngày sinh:</label>
            <strong id="ngaysinh"></strong>
          </div>
           <div class="form-group">
            <label for="recipient-name" class="col-form-label">Giới tính:</label>
          <strong id="gioitinh"></strong>
          </div>
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Địa chỉ:</label>
         <strong id="diachi"></strong>
          </div>
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">CMND:</label>
         <strong id="cmnd"></strong>
          </div>
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Mail:</label>
         <strong id="mails"></strong>
          </div>
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Số Đt:</label>
         <strong id="sodt"></strong>
          </div>
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Trình độ vh:</label>
         <strong id="trinhdo"></strong>
          </div>
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Tài khoản:</label>
         <strong id="taikhoan"></strong>
          </div>
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Hệ số lương:</label>
         <strong id="hesoluong"></strong>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>