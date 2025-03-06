package com.example.engg1420facultymanagement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.engg1420facultymanagement.DatabaseManager;

public class Faculty {

    String facultyId;
    String facultyName;
    String degree;
    String researchInterest;
    String email;
    String officeLocation;
    String courses;
    String password;

    public Faculty(String facultyId, DatabaseManager db) throws SQLException {
        List<String> facultyMember = db.getRow("Faculties", "Faculty ID", facultyId);
        this.facultyId = facultyMember.get(0);
        this.facultyName = facultyMember.get(1);
        this.degree = facultyMember.get(2);
        this.researchInterest = facultyMember.get(3);
        this.email = facultyMember.get(4);
        this.officeLocation = facultyMember.get(5);
        this.courses = facultyMember.get(6);
        this.password = facultyMember.get(7);
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }
    public String getFacultyName() {
        return facultyName;
    }
    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }
    public String getDegree() {
        return degree;
    }
    public void setDegree(String degree) {
        this.degree = degree;
    }
    public String getResearchInterest() {
        return researchInterest;
    }
    public void setResearchInterest(String researchInterest) {
        this.researchInterest = researchInterest;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getOfficeLocation() {
        return officeLocation;
    }
    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }
    public String getCourses() {
        return courses;
    }
    public void setCourses(String courses) {
        this.courses = courses;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }



}
