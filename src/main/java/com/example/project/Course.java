package com.example.project;

public class Course {
    private String courseName;
    private int courseCode;
    private String subjectName;
    private int sectionNumber;
    private String teacherName;
    private int capacity;
    private String lectureTime;
    private String location;
    private String finalExamDateTime;

    public Course(String courseName, int courseCode, String subjectName, int sectionNumber, String teacherName, int capacity, String lectureTime, String location, String finalExamDateTime) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.subjectName = subjectName;
        this.sectionNumber = sectionNumber;
        this.teacherName = teacherName;
        this.capacity = capacity;
        this.lectureTime = lectureTime;
        this.location = location;
        this.finalExamDateTime = finalExamDateTime;
    }

    // Getters
    public String getCourseName() { return courseName; }
    public int getCourseCode() { return courseCode; }
    public String getSubjectName() { return subjectName; }
    public int getSectionNumber() { return sectionNumber; }
    public String getTeacherName() { return teacherName; }
    public int getCapacity() { return capacity; }
    public String getLectureTime() { return lectureTime; }
    public String getLocation() { return location; }
    public String getFinalExamDateTime() { return finalExamDateTime; }

    // **SETTERS (NEWLY ADDED)**
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public void setCourseCode(int courseCode) { this.courseCode = courseCode; }
    public void setSubjectName(String subjectName) { this.subjectName = subjectName; }
    public void setSectionNumber(int sectionNumber) { this.sectionNumber = sectionNumber; }
    public void setTeacherName(String teacherName) { this.teacherName = teacherName; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public void setLectureTime(String lectureTime) { this.lectureTime = lectureTime; }
    public void setLocation(String location) { this.location = location; }
    public void setFinalExamDateTime(String finalExamDateTime) { this.finalExamDateTime = finalExamDateTime; }

    @Override
    public String toString() {
        return subjectName + courseCode;
    }
}