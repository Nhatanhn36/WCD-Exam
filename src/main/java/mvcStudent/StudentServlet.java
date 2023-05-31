package mvcStudent;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import mvcStudent.Student;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/student")
public class StudentServlet extends HttpServlet{
    private List<Student> studentList;
    @Override
    public void init() throws ServletException{
        super.init();
        studentList = new ArrayList<>();
        studentList.add(new Student(1, "Nguyen Nhat Anh", "nhatanhn36@gmail.com", 20,"A",8.75));
        studentList.add(new Student(2, "Nguyen Hoai Nam", "HoaiNamNguyen@gmail.com", 20,"A",9.25));
        studentList.add(new Student(3, "Do Hoang Anh", "HoangAnh1803@gmail.com", 20,"B",6.75));
        studentList.add(new Student(4, "Pham Phuong Linh", "pLinh0904@gmail.com", 20,"A",9.0));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
            action = "list";
        }

        switch (action) {
            case "new":
                showNewForm(request, response);
                break;
            case "create":
                createStudent(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateStudent(request, response);
                break;
            case "delete":
                deleteStudent(request, response);
                break;
            default:
                listStudent(request, response);
                break;
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void listStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute("studentList", studentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
        dispatcher.forward(request, response);
    }

    private void createStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String studentName = request.getParameter("studentName");
        String email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));
        String grade = request.getParameter("grade");
        double examScore = Double.parseDouble(request.getParameter("examScore"));
        int studentID = studentList.size() + 1;

        Student newStudent = new Student(studentID, studentName, email, age, grade, examScore);
        studentList.add(newStudent);

        response.sendRedirect("student");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int studentID = Integer.parseInt(request.getParameter("studentID"));
        Student student = getStudentByID(studentID);

        request.setAttribute("student", student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
        dispatcher.forward(request, response);
    }

    public void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int studentID = Integer.parseInt(request.getParameter("studentID"));
        String studentName = request.getParameter("studentName");
        String email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));
        String grade = request.getParameter("grade");
        double examScore = Double.parseDouble(request.getParameter("examScore"));

        Student student = getStudentByID(studentID);
        student.setStudentName(studentName);
        student.setEmail(email);
        student.setAge(age);
        student.setGrade(grade);
        student.setExamScore(examScore);

        response.sendRedirect("student");
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int studentID = Integer.parseInt(request.getParameter("studentID"));
        Student student = getStudentByID(studentID);
        studentList.remove(student);
        response.sendRedirect("student");
    }

    private Student getStudentByID(int studentID){
        for(Student student: studentList){
            if(student.getStudentID() == studentID){
                return student;
            }
        }
        return null;
    }
}
