<%@page import="in.myproject.model.DBconnection"%>
<%@page import="in.myproject.model.FunctionalDBconnection"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
</head>
<body>
<table>
<tr style="background-color:#A3E0FF" height="40px"><td style="width:60px;" align="center"><b>INDEX</b></td><td style="width:300px;" align="center"><b>USER-ID</b></td><td style="width:200px;" align="center"><b>FIRST NAME</b></td><td style="width:200px;" align="center"><b>LAST NAME</b></td><td style="width:200px;" align="center"><b>E-MAIL</b></td><td style="width:200px;" align="center"><b>SEX</b></td><td style="width:200px;" align="center"><b>DATE OF BIRTH</b></td></tr>
<%
if(session.isNew())
{
 response.sendRedirect("ExpiredAdminLogIn.jsp?Session Expired !! ");
} 
else
{
Statement s=null;
ResultSet rs=null;
Connection con=DBconnection.connect();
try
{
	int index=1;
	s=con.createStatement();
	s.executeQuery("SELECT username,id,f_name,l_name,email_id,sex,dob FROM UserData");
	rs=s.getResultSet();
while(rs.next())
{ 
%>
<tr style="background-color:#DDDDDD" height="20px"><td align="center" style="width:60px;"><%=index%></td><td style="width:300px;" align="center"><%=rs.getString("username").toUpperCase()+rs.getInt("id")%></td><td style="width:200px;" align="center"><%=rs.getString("f_name").toUpperCase() %></td><td style="width:200px;" align="center"><%=rs.getString("l_name").toUpperCase() %></td><td style="width:200px;" align="center"><%=rs.getString("email_id").toLowerCase() %></td><td style="width:200px;" align="center"><%=rs.getString("sex").toUpperCase() %></td><td style="width:200px;" align="center"><%=rs.getString("dob").toUpperCase() %></td></tr>
<%
index++;
}
}
catch(Exception e)
{
	out.println(e);
}
con.close();
} 
response.setHeader("Cache-Control", "no-cache"); 
response.setHeader("Pragma", "no-cache"); 
response.setDateHeader("Expires", 0); 
session.setMaxInactiveInterval(15*60);
%>
</table>
</body>
</html>