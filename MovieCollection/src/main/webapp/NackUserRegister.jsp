<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<link type="text/css" rel="stylesheet" href="CSS/GenStyle.css" />
</head>
<body>
<jsp:include page="Frame.jsp"></jsp:include>
<div class="pos_imgReg">
<img src="Images/Registration.jpg" />
</div>
<div class="pos_form">
<fieldset style="width: 315px;">
<legend align="top" style="color: blue;">REGISTRATION</legend>
<form action="MyController?C3" method="post">
<table>
<tr>
<td>FIRST NAME</td><td>:</td><td><input type="text" name="f_name" /></td>
</tr>
<tr>
<td>LAST NAME</td><td>:</td><td><input type="text" name="l_name" /></td>
</tr>
<tr>
<td>PASSWORD</td><td>:</td><td><input type="password" name="pswd" /></td>
</tr>
<tr>
<td>RETYPE PASSWORD</td><td>:</td><td><input type="password" name="conpswd" /></td>
</tr>
<tr>
<td>E-MAIL ID</td><td>:</td><td><input type="text" name="email" /></td>
</tr>
<tr>
<td>DATE OF BIRTH</td><td>:</td><td><input type="text" name="dob" /></td>
</tr>
<tr>
<td>SEX</td><td>:</td>
<td>
<select name="sex">
<option>MALE</option>
<option>FEMALE</option>
</select>
</td>
</tr>
<tr>
<td><input type="submit" value="Register"></td>
</tr>
<tr>
<td colspan="3"><label style="color: red; font-size: 12px; font-weight: bold;">REGISTRATION FAILED!! DATABASE ERROR !!</label></td>
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