package Controller;

import model.StudentDAO;
import model.Student;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/students")
public class StudentController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Fetch student list from DAO
        StudentDAO studentDAO = new StudentDAO();
        List<Student> studentList = studentDAO.getAllStudents();

        // Set student data as request attribute
        request.setAttribute("students", studentList);

        // Forward request to the JSP view
        request.getRequestDispatcher("students.jsp").forward(request, response);
    }
}