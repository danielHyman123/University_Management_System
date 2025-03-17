package com.example.project;

public class Student {
    private int studentID;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String academicLevel;
    private int currentSemester;

    public Student(int studentID, String name, String address, String phone, String email, String academicLevel, int currentSemester) {
        this.studentID = studentID;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.academicLevel = academicLevel;
        this.currentSemester = currentSemester;
    }

    public int getStudentID() { return studentID; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public String getAcademicLevel() { return academicLevel; }
    public int getCurrentSemester() { return currentSemester; }
}