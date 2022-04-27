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
<div class="pos_viewList">
<iframe src="MovieList.jsp" width="900px" height="500px"></iframe>
</div>    
<%} 
response.setHeader("Cache-Control", "no-cache"); 
response.setHeader("Pragma", "no-cache"); 
response.setDateHeader("Expires", 0); 
session.setMaxInactiveInterval(15*60);
%>        
</body>
</html>