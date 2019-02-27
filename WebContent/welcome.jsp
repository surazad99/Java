<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");// for HTTP 1.1
	 
	response.setHeader("Pragma", "no-cache"); // for HTTP 1.0
	
	response.setHeader("Expires", "0"); // for proxy servers
	
	if(session.getAttribute("username")==null)
	{
		response.sendRedirect("login.jsp");
	}
%>

Welcome here ${username} <br>
<a href="videos.jsp">Videos</a>

<form action="Logout">
	<input type ="submit" value="logout">
</form>

</body>
</html>