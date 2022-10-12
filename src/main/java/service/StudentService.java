package service;

import connection.ConnectionJDBC;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
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
        List<Student> students = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_STUDENT);) {

            System.out.println(statement);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String dateOfBirth = resultSet.getString("dateOfBirth");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                int classroom_id = resultSet.getInt("classroom_id");
                students.add(new Student(id, name, LocalDate.parse(dateOfBirth), address, phone, email, classroom_id));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
            return students;
    }

    @Override
    public void insert(Student student) {
        System.out.println(INSERT_STUDENT);

        try {
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT);
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getDateOfBirth());
            preparedStatement.setString(4, student.getAddress());
            preparedStatement.setString(5, student.getPhone());
            preparedStatement.setString(6, student.getEmail());
            preparedStatement.setInt(7, student.getClassroom_id());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();

            connection.commit();
        } catch (SQLException throwAbles) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Student selectById(int id) {
        Student student = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID);){

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String dateOfBirth = resultSet.getString("dateOfBirth");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                int class_id = resultSet.getInt("class_id");
                student = new Student(id, name, LocalDate.parse(dateOfBirth), address, phone, email, class_id);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }

    @Override
    public boolean delete(int id) {
        boolean rowDeleted;
        try (PreparedStatement statement = connection.prepareStatement(DELETE_STUDENT);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDeleted;
    }

    @Override
    public boolean update(Student student) {
        boolean rowUpdate = false;
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENT);) {
            connection.setAutoCommit(false);

            statement.setString(1, student.getName());
            statement.setString(2, student.getDateOfBirth());
            statement.setString(3, student.getAddress());
            statement.setString(4, student.getPhone());
            statement.setString(5, student.getEmail());
            statement.setInt(6, student.getClassroom_id());
            statement.setInt(7, student.getId());
            rowUpdate = statement.executeUpdate() > 0;

            connection.commit();
        } catch (SQLException throwAbles) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rowUpdate;
    }

    @Override
    public List<Student> selectByName(String superName) {
        List<Student> students = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_NAME);) {

            preparedStatement.setString(1, "%"+superName+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String dateOfBirth = resultSet.getString("dateOfBirth");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                int class_id = resultSet.getInt("class_id");
                students.add(new Student(id, name, LocalDate.parse(dateOfBirth), address, phone, email, class_id));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

}
