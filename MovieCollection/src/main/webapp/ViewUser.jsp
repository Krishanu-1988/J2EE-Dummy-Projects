<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Admin</title>
<link rel="stylesheet" type="text/css" href="CSS/GenStyle.css" />
<style type="text/css">
.box
{
position:absolute;
top:270px;
left:348px;
width:967px;
height:722px;
padding:10px;
border:2px solid #C0C6CC;
margin:0px;
}
.menu
{
position:absolute;
top:202px;
left:345px;
}
</style>
</head>
<body>
<%if(session.isNew())
	{
	 response.sendRedirect("ExpiredAdminLogIn.jsp?Session Expired !! ");
    } 
  else
  {%>
<jsp:include page="Frame.jsp"></jsp:include>
<div class="pos_welcome">
<h1 style="color: blue;">WELCOME ADMINISTRATOR</h1>
</div>
<div class="pos_imgLogo">
<img alt="Administrator" src="Images/AdminImage.jpg"/>
</div>
<div class="pos_AdminTimeLog">
<table>
<tr>
<td align="center"><label style="color: red; font-weight: bold;">LAST LOGIN</label></td>
</tr>
<tr>
<td align="center"><label><%=session.getAttribute("timeLog").toString().toUpperCase() %></label></td>
</tr>
</table>
</div>
<div class="pos_Admin_menu">
<table>
<tr>
<td align="center"><a href="AdminHome.jsp">HOME</a></td>
</tr>
<tr>
<td align="center"><a href="AdminUserControl.jsp">HANDLE USER ACCOUNTS</a></td>
</tr>
</table>
</div>
<div class="menu">
<table>
<tr>
<td  style="width: 180px;"><form action="ViewUser.jsp"><input type="image" src="Images/Button_3.1.png"/></form></td>
<td></td>
<td style="width: 180px;"><form action="DelUser.jsp"><input type="image" src="Images/Button_3.2.png" /></form></td>
</tr>
</table>
</div>
<div class="box">
</div>
<div class="pos_viewList">
<iframe src="UserList.jsp" width="900px" height="500px"></iframe>
</div>  
<%} 
response.setHeader("Cache-Control", "no-cache"); 
response.setHeader("Pragma", "no-cache"); 
response.setDateHeader("Expires", 0); 
session.setMaxInactiveInterval(15*60);
%>
</body>
</html> 