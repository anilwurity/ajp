<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, test.DBUtils" %>
<%
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String email = request.getParameter("email");

    try (Connection connection = DBUtils.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(
                 "INSERT INTO student (first_name, last_name, email) VALUES (?, ?, ?)")) {

        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, lastName);
        preparedStatement.setString(3, email);
        preparedStatement.executeUpdate();
        response.sendRedirect("viewStudents.jsp");
    } catch (SQLException e) {
        e.printStackTrace();
        out.println("Failed to add student. Please try again.");
    }
%>
