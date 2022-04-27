<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
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
<legend align="top" style="color: blue;">UPDATE MOVIE DETAILS</legend>
<form action="MyController?C12" method="post">
<table>
<tr><td>UPDATE LEAD ACTOR</td><td>:</td><td><input type="text" name="actor" /></td></tr>
<tr><td>UPDATE OTHER ACTOR</td><td>:</td><td><input type="text" name="other_actor" /></td></tr>
<tr><td>UPDATE LANGUAGE</td><td>:</td><td><input type="text" name="lang" /></td></tr>
<tr><td>UPDATE DETAILS</td><td>:</td><td><textarea name="details" rows="3" cols="20"></textarea></td></tr>
<tr><td>UPDATE GENRE</td><td>:</td>
<td>
<select name="genre">
<option>ACTION</option>
<option>ADVENTURE</option>
<option>ANIMATION</option>
<option>BIOGRAPHY</option>
<option>COMEDY</option>
<option>CRIME</option>
<option>DOCUMENTARY</option>
<option>DRAMA</option>
<option>FAMILY</option>
<option>FANTASY</option>
<option>HISTORY</option>
<option>HORROR</option>
<option>MUSICAL</option>
<option>MYSTERY</option>
<option>ROMANCE</option>
<option>SCI-FI</option>
<option>SPORTS</option>
<option>THIRLLER</option>
<option>WAR</option>
<option>WESTERN</option>
</select>
</td>
</tr>
<tr><td>UPDATE MOVIE-PATH</td><td>:</td><td><input type="file" name="file" size="50"/></td></tr>

<tr>
<td><input type="submit" value="Update" /></td>
</tr>
</table>
</form>
</fieldset>
<br><br>
<fieldset>
<legend align="top" style="color: blue;">UPDATE MOVIE-COVER</legend>
<form action="MyController?C13" method="post" enctype="multipart/form-data">
<table>
<tr>
<td>UPDATE MOVIE COVER</td><td>:</td><td><input type="file" name="file" size="50"/></td>
</tr>
<tr>
<td><input type="submit" value="Update" /></td>
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