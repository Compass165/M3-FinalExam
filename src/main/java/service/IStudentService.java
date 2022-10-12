package service;

import model.Student;

import java.util.List;

public interface IStudentService <Student>{

    List<Student> findAll();
    void insert(Student student);
    Student selectById(int id);
    boolean delete(int id);
    boolean update(Student student);
    List<Student> selectByName(String name);


}
