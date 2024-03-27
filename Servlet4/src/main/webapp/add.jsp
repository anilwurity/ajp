<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="">
Enter First no<input type="text" name="n1">
Enter Second no<input type="text" name="n2">
<input type="submit" name="b1">
<%
if(request.getParameter("b1")!=null)
{
int no1=Integer.parseInt(request.getParameter("n1"));
int no2=Integer.parseInt(request.getParameter("n2"));

out.println("the sum is "+(no1+no2));
}


%>


</form>

</body>
</html>