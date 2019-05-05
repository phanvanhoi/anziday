<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Modal -->
<div class="modal fade" id="viewModal" role="dialog">
	<div class="modal-dialog modal-lg">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">Thông tin bệnh nhân</h4>
			</div>
			<div class="modal-body">
				<p style="font-weight: bold;" id="adictid"></p>
				<p id="addictname"></p>
				<p id="birthday"></p>
				<p id="gender"></p>
				<p id="addresses"></p>
				<p id="relativesname"></p>
				<p id="relationship"></p>
				<p id="fullname"></p>
				<p id="roomid"></p>
				<p id="status"></p>
				
			</div>
			<div class="modal-footer">
			 <button class="btn btn-default" style="padding: 0px;">
				<a id="xembenhan" class="btn btn-default" >Xem bệnh án</a></button>
				<button class="btn btn-default" style="padding: 0px;">
					<a id="updateaddict" class="btn btn-default">Sửa</a>
				</button>
				<button class="btn btn-default" style="padding: 0px;"><a id="deleteaddict" class="btn btn-default"  onclick ="return confirm('Xóa thằng nghiện này? ');">Xóa</a></button>
				<button class="btn btn-default" data-dismiss="modal">Trở về</button>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$('#viewModal').on('show.bs.modal', function(event) {
		var button = $(event.relatedTarget) // Button that triggered the modal
		var id = button.data('addictsid') // Extract info from data-* attributes
		var name = button.data('addictname')
		var birthday = button.data('birthday')
		var gender = button.data('gender')
		var addresses = button.data('addresses')
		var relativesname = button.data('relativesname')
		var relationship = button.data('relationship')
		var fullname = button.data('fullname')
		var roomid = button.data('roomid')
		var status = button.data('status')
		// If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
		// Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
		// var modal = $(this)
		$("#adictid").text("Mã số: " + id)
		$("#addictname").text("Họ tên: " + name)
		$("#birthday").text("Ngày sinh: " + birthday.substring(8, 10) +"/"+birthday.substring(5,7)+"/"+birthday.substring(0,4))
		$("#gender").text("Giới tính: " + gender)
		$("#addresses").text("Địa chỉ: " + addresses)
		$("#relativesname").text("Người thân: " + relativesname)
		$("#relationship").text("Quan hệ: " + relationship)
		$("#fullname").text("Bác sĩ: " + fullname)
		$("#roomid").text("Phòng: " + roomid)
		$("#status").text("Tình trạng: " + status)
		document.getElementById("updateaddict").href= "<%=request.getContextPath()%>/updateAddict.do?addictsid="+id
		document.getElementById("deleteaddict").href= "<%=request.getContextPath()%>/deleteAddict.do?addictsid="+id
		document.getElementById("xembenhan").href= "<%=request.getContextPath()%>/quanlybenhan.do?addictsid="+id
		
	})
</script>