<%@ page import="java.sql.*" %>
<html>
<head>
    <title>JSP with MySQL Example</title>
</head>
<body>
    <h2>Student List</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Grade</th>
        </tr>

        <%
            // JDBC Configuration
            String url = "jdbc:mysql://localhost:3306/SchoolDB";
            String user = "root";  // Your MySQL username
            String password = "12345678"; // Your MySQL password

            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;

            try {
                // Load MySQL JDBC Driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Establish Connection
                conn = DriverManager.getConnection(url, user, password);

                // Create Statement
                stmt = conn.createStatement();

                // Execute Query
                String sql = "SELECT * FROM Students";
                rs = stmt.executeQuery(sql);

                // Iterate through results
                while (rs.next()) {
        %>
                    <tr>
                        <td><%= rs.getInt("id") %></td>
                        <td><%= rs.getString("name") %></td>
                        <td><%= rs.getInt("age") %></td>
                        <td><%= rs.getString("grade") %></td>
                    </tr>
        <%
                }
            } catch (Exception e) {
                out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
            } finally {
                // Close resources
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            }
        %>
    </table>
</body>
</html>
