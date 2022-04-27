<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Profile</title>
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
<fieldset style="width: 400px;">
<legend align="top" style="color: blue;">FIXED PROFILE</legend>
<table>
<tr><td>FIRST NAME</td><td>:</td><td><%=session.getAttribute("f_name").toString().toUpperCase()%></td></tr>
<tr><td>LAST NAME</td><td>:</td><td><%=session.getAttribute("l_name").toString().toUpperCase()%></td></tr>
<tr><td>DATE OF BIRTH</td><td>:</td><td><%=session.getAttribute("dob").toString().toUpperCase()%></td></tr>
<tr><td>SEX</td><td>:</td><td><%=session.getAttribute("sex").toString().toUpperCase()%></td></tr>
<tr><td>USER-ID</td><td>:</td><td><%=session.getAttribute("user").toString().toUpperCase()%></td></tr>
</table>
</fieldset>
<br/><br/><br/><br/>
<fieldset style="width:400px;">
<legend align="top" style="color: blue;" >CHANGE YOUR E-MAIL ID</legend>
<form action="MyController?C6" method="post">
<table>
<tr>
<td>ENTER YOUR NEW E-MAIL ID</td><td>:</td><td><input type="text" name="newEmail" /></td>
</tr>
<tr>
<td><input type="submit" value="Confirm"/></td>
</tr>
</table>
</form>
</fieldset>
<br/><br/><br/><br/>
<fieldset style="width:400px;">
<legend align="top" style="color: blue;" >CHANGE YOUR PASSWORD</legend>
<form action="MyController?C6" method="post">
<table>
<tr>
<td>OLD PASSWORD</td><td>:</td><td><input type="password" name="oldpswd" /></td>
</tr>
<tr>
<td>NEW PASSWORD</td><td>:</td><td><input type="password" name="newpswd" /></td>
</tr>
<tr>
<td>RETYPE NEW PASSWORD</td><td>:</td><td><input type="password" name="connewpswd" /></td>
</tr>
<tr>
<td><input type="submit" value="Confirm" /></td>
</tr>
</table>
</form>
</fieldset>
<br/><br/>
<label style="color: red; font-size: 12px; font-weight: bold;">PASSWORD UPDATED SUCCESSFULLY !!</label>
</div>
<%}
response.setHeader("Cache-Control", "no-cache"); 
response.setHeader("Pragma", "no-cache"); 
response.setDateHeader("Expires", 0); 
session.setMaxInactiveInterval(15*60);
%>
</body>
</html>