package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLExample1 {

    private static final String URL = "jdbc:mysql://localhost:3306/web_student_tracker";
    private static final String USERNAME = "webstudent";
    private static final String PASSWORD = "webstudent";

    public static void main(String[] args) {
        // Read operation
        //readStudents();
        
        // Create operation
       
        //createStudent("tunny","wurity","tunny@gmail.com");
        // Read operation after creation
        readStudents();
        
        System.out.println("***********************************");
        
        // Update operation
        updateStudentEmail(4, "ssss@example.com");
        
        // Read operation after update
        readStudents();
        System.out.println("*************************************");
        // Delete operation
        deleteStudent(1);
        deleteStudent(2);
        deleteStudent(3);
        deleteStudent(4);
        deleteStudent(5);
        deleteStudent(6);
        deleteStudent(7);
        deleteStudent(8);
        deleteStudent(9);
        deleteStudent(10);
        
        // Read operation after deletion
        readStudents();
    }

    private static void readStudents() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM student");

            while (resultSet.next()) {
                String email = resultSet.getString("email");
                System.out.println("Email: " + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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

    private static void createStudent(String firstName, String lastName, String email) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            preparedStatement = connection.prepareStatement("INSERT INTO student (first_name, last_name, email) VALUES (?, ?, ?)");
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, email);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void updateStudentEmail(int studentId, String newEmail) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            preparedStatement = connection.prepareStatement("UPDATE student SET email = ? WHERE id = ?");
            preparedStatement.setString(1, newEmail);
            preparedStatement.setInt(2, studentId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void deleteStudent(int studentId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            preparedStatement = connection.prepareStatement("DELETE FROM student WHERE id = ?");
            preparedStatement.setInt(1, studentId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
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

