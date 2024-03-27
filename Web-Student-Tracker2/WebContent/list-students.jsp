<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,test.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Tracker App</title>
</head>
<% List<Student> theStudents=(List<Student>)request.getAttribute("STUDENT_LIST"); %>
<body>
<%=theStudents %>
</body>
</html>