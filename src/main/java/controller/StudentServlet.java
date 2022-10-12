package controller;

import model.Classroom;
import model.Student;
import service.ClassService;
import service.IClassService;
import service.IStudentService;
import service.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;


@WebServlet (name = "StudentServlet", value ="/students")
public class StudentServlet extends HttpServlet {

   private IStudentService studentService;
   private IClassService classService;
   public void init() {
       studentService = new StudentService();
       classService = new ClassService();
   }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
               showCreate(request, response);
                break;
            case "edit":
                showEdit(request, response);
                break;
            case "delete":
                deleteStudent(request, response);
                break;
//            case "find":
//                findByName(request, response);
//                break;
            default:
                listStudent(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                create(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
            case "find":
               findByName(request, response);
                break;
            default:
                listStudent(request, response);
                break;
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       int id = Integer.parseInt(request.getParameter("id"));
       String name = new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8");
       LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateOfBirth"));
       String address = new String(request.getParameter("address").getBytes("iso-8859-1"),"utf-8");
       String phone = new String(request.getParameter("phone").getBytes("iso-8859-1"),"utf-8");
       String email = new String(request.getParameter("email").getBytes("iso-8859-1"),"utf-8");
       int class_id = Integer.parseInt(request.getParameter("classroom_id"));
       Student newStudent = new Student(id, name, dateOfBirth, address, phone, email, class_id);

       studentService.update(newStudent);

       request.setAttribute("message", "Sửa thông tin học viên thành công!");
       RequestDispatcher dispatcher = request.getRequestDispatcher("student/edit.jsp");
       dispatcher.forward(request, response);

    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String name = new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8");
       LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateOfBirth"));
       String address = new String(request.getParameter("address").getBytes("iso-8859-1"),"utf-8");
       String phone = new String(request.getParameter("phone").getBytes("iso-8859-1"),"utf-8");
       String email = new String(request.getParameter("email").getBytes("iso-8859-1"),"utf-8");
       int class_id = Integer.parseInt(request.getParameter("classroom_id"));
       Student newStudent = new Student(name, dateOfBirth, address, phone, email, class_id);

       studentService.insert(newStudent);
       request.setAttribute("message", "Thêm học viên mới thành công!");
       RequestDispatcher dispatcher = request.getRequestDispatcher("student/create.jsp");
       dispatcher.forward(request, response);
    }

    private void listStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       List<Student> students = studentService.findAll();
       request.setAttribute("students", students);
       RequestDispatcher dispatcher = request.getRequestDispatcher("student/list.jsp");
       dispatcher.forward(request,response);
    }

    private void findByName(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = new String(request.getParameter("search").getBytes("iso-8859-1"),"utf-8");
        List<Student> students = (List<Student>) studentService.selectByName(name);
        request.setAttribute("students",students);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/list.jsp");
        dispatcher.forward(request,response);
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentService.delete(id);

        List<Student> students = studentService.findAll();
        request.setAttribute("students", students);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Classroom> classes = classService.selectAllClasses();
        request.setAttribute("classes", classes);
       int id = Integer.parseInt(request.getParameter("id"));
       Student student = (Student) studentService.selectById(id);
       RequestDispatcher dispatcher;

       if (student == null) {
           dispatcher = request.getRequestDispatcher("student/fail.jsp");
       } else {
           request.setAttribute("student", student);
           dispatcher = request.getRequestDispatcher("student/edit.jsp");
       }
       dispatcher.forward(request, response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       List<Classroom> classes = classService.selectAllClasses();
       request.setAttribute("classes", classes);
       RequestDispatcher dispatcher = request.getRequestDispatcher("student/create.jsp");
        dispatcher.forward(request, response);
    }


}
