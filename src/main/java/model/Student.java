package model;

import java.time.LocalDate;

public class Student {

    private int id;
    private String name;
    private LocalDate dateOfBirth;
    private String address;

    private String phone;
    private String email;

    private String classroom_name;

    private int classroom_id;
    public Student () {
    }

    public Student(String name, LocalDate dateOfBirth, String address, String phone, String email, String classroom_name, int classroom_id) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.classroom_name = classroom_name;
        this.classroom_id = classroom_id;
    }

    public Student(int id, String name, LocalDate dateOfBirth, String address, String phone, String email, String classroom_name, int classroom_id) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.classroom_name = classroom_name;
        this.classroom_id = classroom_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClassroom_name() {
        return classroom_name;
    }

    public void setClassroom_name(String classroom_name) {
        this.classroom_name = classroom_name;
    }

    public int getClassroom_id() {
        return classroom_id;
    }

    public void setClassroom_id(int classroom_id) {
        this.classroom_id = classroom_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

