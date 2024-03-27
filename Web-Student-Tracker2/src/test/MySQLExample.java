package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLExample {
    public static void main(String[] args) {
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/web_student_tracker";
        String username = "webstudent";
        String password = "webstudent";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish connection
            connection = DriverManager.getConnection(url, username, password);

            // Step 3: Create statement
            statement = connection.createStatement();

            // Step 4: Execute query
            String query = "SELECT * FROM student";
            resultSet = statement.executeQuery(query);

            // Step 5: Process results
            while (resultSet.next()) {
                // Process each row in the result set
                String column1Value = resultSet.getString("first_name");
                // Process other columns similarly
                System.out.println("Value of column1: " + column1Value);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close resources in reverse order
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}