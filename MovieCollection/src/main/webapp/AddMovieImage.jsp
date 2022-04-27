<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
<link rel="stylesheet" type="text/css" href="CSS/GenStyle.css" />
<style type="text/css">

</style>
</head>
<body>
<%if(session.isNew())
	{
	 response.sendRedirect("ExpiredAdminLogIn.jsp?Session Expired !! ");
    } 
  else
  {%>
<jsp:include page="AdminHome.jsp"></jsp:include>
<div class="pos_adminform">
<fieldset>
<table>
<tr><td><label style="color: red; font-size: 12px; font-weight: bold;">MOVIE PROFILE CREATED !!</label></td></tr>
</table>
</fieldset>
<fieldset style="width:500PX">
<legend align="top" style="color: blue;">UPLOAD MOVIE-COVER</legend>
<form action="MyController?C8" method="post" enctype="multipart/form-data">
<table>
<tr>
<td><input type="file" name="file" size="50"/></td>
</tr>
<tr>
<td><input type="submit" value="Upload" /></td>
</tr>
</table>
</form>  
</fieldset>
</div>
<%} 
response.setHeader("Cache-Control", "no-cache"); 
response.setHeader("Pragma", "no-cache"); 
response.setDateHeader("Expires", 0); 
session.setMaxInactiveInterval(15*60);
%>  
</body>
</html>