<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3> Welcome to JSP programming</h3>
<%! 
String name= "hunny";
int len=name.length();
int square()
{
	return len*len;
}

%>
<%=len %>
<%=square() %>

</body>
</html>