<%@page import="com.bean.AcountUserTypeOfPeople"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Ăn gì đây </title>
    <meta name="description" content="Sufee Admin - HTML5 Admin Template">
    <meta name="viewport" content="width=device-width, initial-scale=1">

	<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>

    <link rel="apple-touch-icon" href="${pageContext.servletContext.contextPath}/public/apple-icon.png">
    <link rel="shortcut icon" href="${pageContext.servletContext.contextPath}/public/favicon.ico">


    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/public/vendors/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/public/vendors/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/public/vendors/themify-icons/css/themify-icons.css">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/public/vendors/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/public/vendors/selectFX/css/cs-skin-elastic.css">

    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/public/assets/css/style.css">
	<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/public/assets/css/stylecustom.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-multiselect/0.9.13/css/bootstrap-multiselect.css">
	
	

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/public/assets/css/amsify.suggestags.css">

<!-- Amsify Plugin -->
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
	
	
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>
    <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
	<%
		AcountUserTypeOfPeople acountUserTypeOfPeople = new AcountUserTypeOfPeople();
		acountUserTypeOfPeople = (AcountUserTypeOfPeople)session.getAttribute("userInfo");
		if(acountUserTypeOfPeople == null){
			response.sendRedirect(request.getContextPath()+"/login.do");
		}/*else{
			if(acountUserTypeOfPeople.getTypeid().toString().endsWith("1") && request.getRequestURI().toString().equals("/FPT_Project/template/manage-notifications.jsp")){
				response.sendRedirect("/FPT_Project/home.html");
			}
		}*/
		/*System.out.println(request.getRequestURI().toString());
		System.out.println(request.getRequestURL().toString());
		System.out.println(acountUserTypeOfPeople.getTypeid().toString());*/
	%>








<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script
	src="https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core"></script>

<script
	src="https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core"></script>
</head>