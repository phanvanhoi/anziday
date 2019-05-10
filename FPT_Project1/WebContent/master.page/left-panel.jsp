
<!-- Left Panel -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<aside id="left-panel" class="left-panel">
	<nav class="navbar navbar-expand-sm navbar-default">
		<%
			if (session.getAttribute("userInfo") != null) {
		%>
		<input type="hidden" name="typeid" value="${userInfo.typeid}"
			id="typeid" />
		<%
			}
		%>
		<div class="navbar-header">
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#main-menu" aria-controls="main-menu"
				aria-expanded="false" aria-label="Toggle navigation">
				<i class="fa fa-bars"></i>
			</button>
			<a class="navbar-brand" href="./"><img
				src="${pageContext.servletContext.contextPath}/public/images/logo.png"
				alt="Logo"></a> <a class="navbar-brand hidden" href="./"><img
				src="${pageContext.servletContext.contextPath}/public/images/logo2.png"
				alt="Logo"></a>
		</div>

		<div id="main-menu" class="main-menu collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<h3 class="menu-title">Quản lý hệ thống </h3>
				<!-- /.menu-title -->
				<li class="menu-item-has-children dropdown"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <i class="menu-icon fa fa-laptop"></i>Quản
						lý tài khoản
				</a>
					<ul class="sub-menu children dropdown-menu">
						<li><i class="fa fa-id-card-o"></i><a
							href="${pageContext.servletContext.contextPath}/view-user.do">Xem
								danh sách tài khoản người dùng </a></li>
					</ul></li>
				<li class="menu-item-has-children dropdown"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <i class="menu-icon fa fa-tasks"></i>Quản
						lý món ăn 
				</a>
					<ul class="sub-menu children dropdown-menu">
						<li><i class="menu-icon fa fa-fort-awesome"></i><a
							href="${pageContext.request.contextPath}/template/add-food.jsp">Thêm
								món ăn</a></li>
						<li><i class="menu-icon ti-themify-logo"></i><a
							href="${pageContext.request.contextPath}/template/add-matirial.jsp">Thêm nguyên liệu</a></li>
						<li><i class="menu-icon ti-themify-logo"></i><a
							href="${pageContext.request.contextPath}/template/add-list-food.jsp">Thêm danh sách món ăn
							</a></li>
						<li><i class="menu-icon ti-themify-logo"></i><a
							href="${pageContext.request.contextPath}/template/view-list-food.jsp">Xem danh sách
								món ăn</a></li>
					</ul>
				<li class="menu-item-has-children dropdown"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <i class="menu-icon fa fa-tasks"></i>Quản
						lý bài đăng
				</a>
					<ul class="sub-menu children dropdown-menu">
						<li><i class="menu-icon fa fa-fort-awesome"></i><a
							href="${pageContext.request.contextPath}/add-post.do">Đăng lên app
							</a></li>
					</ul>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</nav>
</aside>
<script type="text/javascript">
</script>
