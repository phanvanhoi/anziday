<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="en">
<!--<![endif]-->

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Sufee Admin - HTML5 Admin Template</title>
<meta name="description" content="Sufee Admin - HTML5 Admin Template">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="apple-touch-icon" href="apple-icon.png">
<link rel="shortcut icon" href="favicon.ico">


<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/public/vendors/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/public/vendors/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/public/vendors/themify-icons/css/themify-icons.css">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/public/vendors/flag-icon-css/css/flag-icon.min.css">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/public/vendors/selectFX/css/cs-skin-elastic.css">

<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/public/assets/css/style.css">

<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800'
	rel='stylesheet' type='text/css'>

</head>
<body class="bg-dark">
	<div class="sufee-login d-flex align-content-center flex-wrap">
		<div class="container">
			<div class="login-content">
				<div class="login-logo">
					<a href="index.html"> <img class="align-content"
						src="images/logo.png" alt="">
					</a>
				</div>
				<div class="login-form">
					<html:form action="/login" method="post">
						<div class="form-group">
							<label>Tên đăng nhập</label> <input type="text"
								class="form-control" placeholder="zxcqwe" name="username" required>
						</div>
						<div class="form-group">
							<label>Mật khẩu</label> <input type="password"
								class="form-control" placeholder="******" name="password" required>
						</div>
						<div class="form-group">
							<p style="color: red;"><html:errors property="loginFailMSG"/></p>
						</div>
						<div class="checkbox">
							<label> <input type="checkbox"> Ghi nhớ
							</label> <label class="pull-right"> <a href="#">Quên mật
									khẩu?</a>
							</label>

						</div>
						<button type="submit" name="submit" value="submit"
							class="btn btn-success btn-flat m-b-30 m-t-30"
							>Đăng nhập</button>
					</html:form>
				</div>
			</div>
		</div>
	</div>


	<script
		src="${pageContext.servletContext.contextPath}/public/vendors/jquery/dist/jquery.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/public/vendors/popper.js/dist/umd/popper.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/public/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/public/assets/js/main.js"></script>

</body>
</html>
