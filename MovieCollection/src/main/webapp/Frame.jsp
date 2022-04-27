<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" type="text/css" href="CSS/HomeStyle.css" />
</head>
<body>
<table  width = "1340px">
<tr>
<td colspan="2" style="background-color:#A3E0FF; height:130px;">
<h1>&nbsp;&nbsp;MOVIE COLLECTION TOOL</h1>
<div class="pos1">
<img  src="Images/SpidermanMenu.png" width="120px" height="145px"/>
</div>
<div class="pos2">
<%if(session.getAttribute("user")!=null || session.getAttribute("admin")!=null )
	{
		if(session.getAttribute("user")==null)
   	      {%>
     		 <a href="AdminLogOut.jsp">LOGOUT</a>
   	    <%}
   	    else
		{%>
   		     <a href="UserLogOut.jsp">LOGOUT</a>
 	  <%}
	}
  else if(session.getAttribute("user")==null || session.getAttribute("admin")==null )
  {%>
	<a href="UserRegister.jsp">REGISTER</a>
<%}%>
</div>
<div class="pos2_1">
&nbsp;&nbsp;|&nbsp;&nbsp;
</div>
<div class="pos2_2">
<a href="Help.jsp">HELP</a>
</div>
<form action="" method="get">
<div class="pos3">
<input type="text" size="50" name="movie">
</div>
<div class="pos4">
<input type="submit" value="Search Movies">
</div>
</form>
</td>
</tr>
<tr valign="top">
<td style="background-color:#C0C6CC; width: 334px; height:870px;"></td>
<td style="background-color: white; height:870px;">

</td>
</tr>
<tr>
<td colspan="2" style="background-color:#B3DAEE; height:20px;">
<label>Created and Designed by :</label>&nbsp;&nbsp;
<label style="color: blue;"><i>Krishanu Chakraborty</i></label>
</td>
</tr>
</table>
</body>
</html>