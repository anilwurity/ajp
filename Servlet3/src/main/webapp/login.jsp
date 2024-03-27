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
String name=request.getParameter("name"); 
String pass=request.getParameter("pass");
out.println("hello"+name);
session.setAttribute("name", name);
%>
<a href="home.jsp">home</a>
</body>
</html>