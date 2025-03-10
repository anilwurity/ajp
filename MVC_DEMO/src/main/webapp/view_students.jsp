<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>

	<c:forEach var="tempStudent" items="${student_list}">
	
		${tempStudent} <br/>
	
	</c:forEach>

</body>
</html>