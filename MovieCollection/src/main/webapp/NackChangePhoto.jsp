<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Photo Upload</title>
</head>
<body>
<jsp:include page="UserHome.jsp"></jsp:include>
<%if(session.isNew())
	{
	 response.sendRedirect("ExpiredUserLogIn.jsp?Session Expired !! ");
    } 
  else
  {%>
<div class="pos_userform">
<fieldset style="width:420px;">
<legend align="top" style="color: blue;" >UPLOAD YOUR IMAGE</legend>
<form action="MyController?C4" method="post" enctype="multipart/form-data">
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
<br/>
<label style="color: red; font-size: 12px; font-weight: bold;">PHOTO UPLOAD FAILED !!</label>
<br/><br/><br/>
<fieldset style="width:420px;">
<legend align="top" style="color: blue;" >DELETE YOUR IMAGE</legend>
<form action="MyController?C5" method="post" enctype="multipart/form-data">
<table>
<tr><td><label style="font-size:12px;">ARE YOU SURE THAT YOU WANT TO DELETE YOUR PHOTO :</label></td></tr>
<tr>
<td><input type="submit" value="Delete" />
</tr>
</table>
</form>
</fieldset>
<br/><br/>
</div>
<%}
response.setHeader("Cache-Control", "no-cache"); 
response.setHeader("Pragma", "no-cache"); 
response.setDateHeader("Expires", 0); 
session.setMaxInactiveInterval(15*60);
%>
</body>
</html>