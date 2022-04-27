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
<div class="pos_logout">
<table>
<tr>
<td align="center">
<h3 style="color: red;">YOU HAVE REGISTERED SUCCESSFULLY</h3>
</td>
</tr>
<tr>
<td align="center">
<h3 style="color: red;">USER ID : <label style="color: black;"><%=session.getAttribute("userID").toString().toUpperCase()%></label></h3>
</td>
</tr>
</table>
</div>
</body>
</html>