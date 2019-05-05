<script src="https://www.gstatic.com/firebasejs/5.8.4/firebase.js"></script>
<script>
	// Initialize Firebase
	var config = {
		apiKey : "AIzaSyDn5dAYlaCqKJfdDMlW_jq9H-O7CoI_vzc",
		authDomain : "fptproject-1819.firebaseapp.com",
		databaseURL : "https://fptproject-1819.firebaseio.com",
		projectId : "fptproject-1819",
		storageBucket : "fptproject-1819.appspot.com",
		messagingSenderId : "572735629267"
	};
	firebase.initializeApp(config);
</script>
<!-- Header-->
<header id="header" class="header">

	<div class="header-menu">

		<div class="col-sm-7">
			<a id="menuToggle" class="menutoggle pull-left"><i
				class="fa fa fa-tasks"></i></a>
			<div class="header-left">
				<button class="search-trigger">
					<i class="fa fa-search"></i>
				</button>
				<div class="form-inline">
					<form class="search-form">
						<input class="form-control mr-sm-2" type="text"
							placeholder="Search ..." aria-label="Search">
						<button class="search-close" type="submit">
							<i class="fa fa-close"></i>
						</button>
					</form>
				</div>

				<div class="dropdown for-notification">
					<button class="btn btn-secondary dropdown-toggle" type="button"
						id="notification" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">
						<i class="fa fa-bell"></i> <span id="count-val" class="count bg-danger"></span>
					</button>
					<div id="notification-drop" class="dropdown-menu" aria-labelledby="notification">
						<p class="red">You have Notification</p>
						
					</div>
				</div>
				
			</div>
		</div>

		<div class="col-sm-5">
			<div class="user-area dropdown float-right">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> <img
					class="user-avatar rounded-circle"
					src="${pageContext.servletContext.contextPath}/public/images/admin.jpg"
					alt="User Avatar"> <%
 	if (session.getAttribute("userInfo") != null) {
 %>
					<p>
						<strong>${userInfo.fullname}</strong>
					</p> <%
 	}
 %>

				</a>

				<div class="user-menu dropdown-menu">
					<a class="nav-link" href="#"><i class="fa fa-user"></i> My
						Profile</a> <a class="nav-link" href="#"><i class="fa fa-user"></i>
						Notifications <span class="count">13</span></a> <a class="nav-link"
						href="#"><i class="fa fa-cog"></i> Settings</a> <a
						class="nav-link"
						href="${pageContext.servletContext.contextPath}/logout.do"><i
						class="fa fa-power-off"></i> Logout</a>
				</div>
			</div>

			<div class="language-select dropdown" id="language-select">
				<a class="dropdown-toggle" href="#" data-toggle="dropdown"
					id="language" aria-haspopup="true" aria-expanded="true"> <i
					class="flag-icon flag-icon-us"></i>
				</a>
				<div class="dropdown-menu" aria-labelledby="language">
					<div class="dropdown-item">
						<span class="flag-icon flag-icon-fr"></span>
					</div>
					<div class="dropdown-item">
						<i class="flag-icon flag-icon-es"></i>
					</div>
					<div class="dropdown-item">
						<i class="flag-icon flag-icon-us"></i>
					</div>
					<div class="dropdown-item">
						<i class="flag-icon flag-icon-it"></i>
					</div>
				</div>
			</div>

		</div>
	</div>

</header>
<!-- /header -->
<!-- Header-->

<div class="breadcrumbs">
	<div class="col-sm-4">
		<div class="page-header float-left">
			<div class="page-title">
				<h1>Dashboard</h1>
			</div>
		</div>
	</div>
	<div class="col-sm-8">
		<div class="page-header float-right">
			<div class="page-title">
				<ol class="breadcrumb text-right">
					<li><a href="#">Dashboard</a></li>
					<li><a href="#">Forms</a></li>
					<li class="active">Basic</li>
				</ol>
			</div>
		</div>
	</div>
</div>
