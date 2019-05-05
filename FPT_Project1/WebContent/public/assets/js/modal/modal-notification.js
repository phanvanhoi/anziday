$('#viewdetailnotify').on('show.bs.modal', function(event) {
	var button = $(event.relatedTarget) // Button that triggered the modal
	var dateCreate = button.data('datecreate') // Extract info from data-*
	// attributes
	var title = button.data('title')
	var content = button.data('content')
	var modal = $(this)
	modal.find('.modal-body #datecreate-notify').text('Ngày: ' + dateCreate)
	modal.find('.modal-body #title-notify').text('Tiêu đề: ' + title)
	modal.find('.modal-body #content-notify').text(content)
});

$('#deletenotification').on('show.bs.modal', function(event) {
	var button = $(event.relatedTarget) // Button that triggered the modal
	var notificationid = button.data('notificationid')
	var modal = $(this)
	modal.find('.modal-body #notificationid').val(notificationid)
});

$('#updatenotification').on('show.bs.modal', function(event) {
	var button = $(event.relatedTarget) // Button that triggered the modal
	var notificationid = button.data('notificationid')
	var dateCreate = button.data('datecreate') // Extract info from data-*
	// attributes
	var title = button.data('title')
	var content = button.data('content')
	var modal = $(this)

	modal.find('.modal-body #notificationid').val(notificationid)
	modal.find('.modal-body #datecreate').val(dateCreate)
	modal.find('.modal-body #title').val(title)
	modal.find('.modal-body #content').val(content)
	
	console.log(content)
});