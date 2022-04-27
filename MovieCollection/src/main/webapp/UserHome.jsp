<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.Locale"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome User</title>
<link rel="stylesheet" type="text/css" href="CSS/GenStyle.css" />
</head>
<body>
<%if(session.isNew())
	{
	 response.sendRedirect("ExpiredUserLogIn.jsp?Session Expired !! ");
    } 
  else
  {%>
<jsp:include page="Frame.jsp"></jsp:include>
<div class="pos_welcome">
<h1 style="color: blue;">WELCOME&nbsp;&nbsp;<%=session.getAttribute("f_name").toString().toUpperCase()%></h1>
</div>
<div class="pos_imgLogo">
<%if(session.getAttribute("sex").toString().equals("MALE") && session.getAttribute("imgStatus").toString().equals("false")) 
{%>
<img src="Images/MaleUser.jpg" /><br/><br/>
<%}
else if(session.getAttribute("imgStatus").toString().equals("true"))
{%>
<img src="Temp/<%=session.getAttribute("id")%>.jpg" width="250px" height="250px"/><br/><br/>	
<%}
else if(session.getAttribute("sex").toString().equals("FEMALE") && session.getAttribute("imgStatus").toString().equals("false"))
{%>
<img src="Images/FemaleUser.jpg"/><br/><br/>
<%} 
else
{%>
<img src="Temp/<%=session.getAttribute("id")%>.jpg" width="250px" height="250px"/><br/><br/>
<%}%>
<table>
<tr>
<td align="center" style="width:250px;" ><a href="ChangePhoto.jsp">CHANGE PHOTO</a></td>
</tr>
<tr>
<td align="center"style=" width:250px;"><a href="EditProfile.jsp">EDIT PROFILE</a></td>
</tr>
<tr><td style="height: 50px;"></td></tr>
<tr><td align="center"style=" width:250px;"><a href="UserHome.jsp">HOME</a></td></tr>
<tr><td align="center"style=" width:250px;"><a href="UserProfile.jsp">VIEW PROFILE</a></td></tr>
</table>
</div>
<div class="pos_TimeLog">
<table>
<tr>
<td align="center"><label style="color: red; font-weight: bold;">LAST LOGIN</label></td>
</tr>
<tr>
<td align="center"><label><%=session.getAttribute("timeLog").toString().toUpperCase() %></label></td>
</tr>
</table>
</div>
<%}
response.setHeader("Cache-Control", "no-cache"); 
response.setHeader("Pragma", "no-cache"); 
response.setDateHeader("Expires", 0); 
session.setMaxInactiveInterval(15*60);
%>
</body>
</html> 