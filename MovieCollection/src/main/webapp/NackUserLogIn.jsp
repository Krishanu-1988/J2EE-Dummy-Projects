<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<link type="text/css" rel="stylesheet" href="CSS/GenStyle.css" />
<link type="text/css" rel="stylesheet" href="CSS/HomeStyle.css" />
</head>
<body>
<jsp:include page="Frame.jsp"></jsp:include>
<div class="pos_imgUser">
<img src="Images/UserLogin.gif" />
</div>
<div class="pos_form">
<fieldset style="width: 260px;">
<legend align="top" style="color: blue;">USER LOG-IN</legend>
<form action="MyController?C2" method="post">
<table>
<tr>
<td>USER ID</td><td>:</td><td><input type="text" name="user"></td>
</tr>
<tr>
<td>PASSWORD</td><td>:</td><td><input type="password" name="pswd"></td>
</tr>
<tr>
<td><input type="submit" value="Submit"></td>
</tr>
<tr>
<td colspan="3"><label style="color: red; font-size: 12px; font-weight: bold;">INVALID USER ID OR PASSWORD !!</label></td>
</tr>
</table>
</form>
</fieldset>
</div>
<div class="pos5">
<table>
<tr>
<td>
<form action="Home.jsp">
<input type="image" src="Images/ButtonHome.jpg">
</form>
<br/>
</td>
</tr>
<tr>
<td>
<form action="AdminLogIn.jsp">
<input type="image" src="Images/Button1.jpg">
</form>
<br/>
</td>
</tr>
<tr>
<td>
<form action="UserLogIn.jsp">
<input type="image" src="Images/Button2.jpg">
</form>
<br/>
</td>
</tr>
</table>
</div>
</body>
</html>