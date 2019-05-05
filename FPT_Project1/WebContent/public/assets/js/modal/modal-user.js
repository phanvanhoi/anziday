$('#viewdetailuser').on('show.bs.modal', function(event) {
	var button = $(event.relatedTarget) // Button that triggered the modal
	var dateCreate = button.data('datecreate') // Extract info from data-*
	// attributes
	
	var userid = button.data('userid')
	var username = button.data('username')
	var fullname = button.data('fullname')
	var typename = button.data('typename')
	var birthday = button.data('birthday')
	var gender = button.data('gender')
	var adress = button.data('adress')
	var cmnd = button.data('cmnd')
	var mail = button.data('mail')
	var phonenumber = button.data('phonenumber')
	var coefficientsalary = button.data('coefficientsalary')
	var educationlevel = button.data('educationlevel')
	var modal = $(this)
	modal.find('.modal-body #fullname').text(fullname)
	modal.find('.modal-body #userid').text(userid)
	modal.find('.modal-body #typename').text(typename)
	modal.find('.modal-body #birthday').text(birthday)
	modal.find('.modal-body #gender').text(gender)
	modal.find('.modal-body #address').text(adress)
	modal.find('.modal-body #cmnd').text(cmnd)
	modal.find('.modal-body #mail').text(mail)
	modal.find('.modal-body #phonenumber').text(phonenumber)
	modal.find('.modal-body #salary').text(coefficientsalary)
	modal.find('.modal-body #eduction').text(educationlevel)
	modal.find('.modal-body #username').text(username)
});