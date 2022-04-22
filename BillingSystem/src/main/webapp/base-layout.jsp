<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
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

	<div id="wrapper">
		<table id="container">
			<tr>
				<td id="header-container"><tiles:insertAttribute name="header" />
				</td>
			</tr>
			<tr>
				<td id="body-container">
					<table id="body">
						<tr>
							<td id="sidebar-container"><tiles:insertAttribute
									name="sidebar" /></td>
							<td id="content-container"><tiles:insertAttribute
									name="body" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	<div id="footer">
		<tiles:insertAttribute name="footer" />
	</div>

</body>
</html>