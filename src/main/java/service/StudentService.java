package service;

import connection.ConnectionJDBC;
import model.Student;

import java.sql.Connection;
import java.util.List;

public class StudentService implements IStudentService<Student>{

    private Connection connection = ConnectionJDBC.getConnection();
    private static final String INSERT_STUDENT = "INSERT INTO student VALUE (?,?,?,?,?,?,?);";
    private static final String SELECT_STUDENT_BY_ID = "SELECT * FROM student WHERE id =?";
    private static final String SELECT_STUDENT_BY_NAME = "SELECT * FROM student WHERE name LIKE ?;";
    private static final String SELECT_ALL_STUDENT = "SELECT * FROM student ";
    private static final String DELETE_STUDENT = "DELETE FROM student WHERE id = ?;";
    private static final String UPDATE_STUDENT = "UPDATE student SET name = ?,dateOfBirth = ?, address =?, phone =?, email =?, class_id =? where id = ?;";

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public void insert(Student student) {

    }

    @Override
    public Student selectById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(Student student) {
        return false;
    }

    @Override
    public List<Student> selectByName(String name) {
        return null;
    }
}
