<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
<link rel="stylesheet" type="text/css" href="CSS/GenStyle.css" />
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
<fieldset style="width:500PX">
<legend align="top" style="color: blue;">ENTER YOUR MOVIE-DETAILS</legend>
<form action="MyController?C7" method="post">
<table>
<tr>
<td>ENTER MOVIE NAME</td><td>:</td><td><input type="text" name="movie_name" /></td>
</tr>
<tr>
<td>ENTER LEAD ACTOR</td><td>:</td><td><input type="text" name="actor" /></td>
</tr>
<tr>
<td>ENTER OTHER ACTOR</td><td>:</td><td><input type="text" name="other_actor" /></td>
</tr>
<tr>
<td>ENTER MOVIE DETAILS</td><td>:</td><td><textarea name="details" rows="3" cols="20"></textarea></td>
</tr>
<tr>
<td>ENTER SPOKEN LANGUAGE</td><td>:</td><td><input type="text" name="lang" size="10" /></td>
</tr>
<tr>
<td>SELECT GENRE</td><td>:</td>
<td >
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
<tr>
<td>PUT RATING</td><td>:</td>
<td>
<select name="rating">
<option>1</option>
<option>2</option>
<option>3</option>
<option>4</option>
<option>5</option>
<option>6</option>
<option>7</option>
<option>8</option>
<option>9</option>
<option>10</option>
</select>
</td>
</tr>
<tr>
<td><input type="submit" value="Add" /></td>
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