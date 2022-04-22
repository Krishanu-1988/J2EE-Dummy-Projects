<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by Developers Hut ©

Name       : Billing System
Description: Retail application for invoicing
Version    : 1.0
-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta name="description" content="" />
<meta name="keywords" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />

<link rel="stylesheet" type="text/css" href="css/layout.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />

<script src="script/functions.js"></script>

<title><jsp:include page="title.txt" /></title>
</head>
<body>
	<div class="login-wrapper"
		style="position: relative; top: 50px; left: 31.5%;">
		<s:form id="loginForm" action="loginUser" namespace="/" method="post">
			<table>
				<tr>
					<td colspan="3"><div class="login-logo"></div></td>
				</tr>
				<tr>
					<td align="left">Enter Username</td>
					<td align="left">:</td>
					<td align="left"><s:textfield name="userName" /></td>
				</tr>
				<tr>
					<td align="left">Enter Password</td>
					<td align="left">:</td>
					<td align="left"><s:password name="passWord" /></td>
				</tr>
				<tr>
					<td colspan="3"><s:submit value="LOG IN"
							class="affermative-button"
							style="position: relative; top: 15px; left: 40.1%;" /></td>
				</tr>
			</table>
		</s:form>
	</div>
	<s:if test="hasActionErrors()">
		<div class="login-error-wrapper" style="position: relative; top: 60px; left: 31.5%;"><s:actionerror /></div>
	</s:if>
</body>
</html>