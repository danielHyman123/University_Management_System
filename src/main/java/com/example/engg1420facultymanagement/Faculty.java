package com.example.engg1420facultymanagement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.engg1420facultymanagement.DatabaseManager;

public class Faculty {

    private DatabaseManager dbm;
    private List<String> facultyMember = new ArrayList<>();

    public Faculty(String facultyId, DatabaseManager dbm) throws SQLException {
        this.dbm = dbm;
        this.facultyMember = dbm.getRow("Faculties", "Faculty ID", facultyId);
        System.out.println("Courses: " + facultyMember.get(6));
        for(String value : facultyMember) {
            System.out.println(value);
        }
    }

    public String getFacultyId() {
        return this.facultyMember.get(0);
    }

    public String getFacultyName() {
        return this.facultyMember.get(1);
    }

    public String getDegree() {
        return this.facultyMember.get(2);
    }

    public String getResearchInterest() {
        return this.facultyMember.get(3);
    }

    public String getEmail() {
        return this.facultyMember.get(4);
    }

    public String getOfficeLocation() {
        return this.facultyMember.get(5);
    }

    public String getCourses() {
        return this.facultyMember.get(6);
    }

    public String getPassword() {
        return this.facultyMember.get(7);
    }

    public void setFacultyId(String facultyId) {
        this.facultyMember.set(0, facultyId);
    }

    public void setFacultyName(String facultyName) {
        this.facultyMember.set(1, facultyName);
    }

    public void setDegree(String degree) {
        this.facultyMember.set(2, degree);
    }

    public void setResearchInterest(String researchInterest) {
        this.facultyMember.set(3, researchInterest);
    }

    public void setEmail(String email) {
        this.facultyMember.set(4, email);
    }

    public void setOfficeLocation(String officeLocation) {
        this.facultyMember.set(5, officeLocation);
    }

    public void setCourses(String courses) {
        this.facultyMember.set(6, courses);
    }

    public void addCourses(List<String> courses) {
        String newcourses = "";

        for(int i = 0; i < courses.size(); i++) {
            newcourses += "," + courses.get(i);
        }
        setCourses(newcourses);
    }

    public void setPassword(String password) {
        this.facultyMember.set(7, password);
    }

    public void updateInfo() {
        try {
            this.dbm.updateRowInTable("Faculties", "Faculty ID", this.facultyMember.get(0), this.facultyMember);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
