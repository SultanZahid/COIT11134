package com.mycompany.assessment1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Sultan
 */
public class Student {
    // Instance variables
    private int studentID;
    private String fullName;
    private String campus;
    private String courseCode;
    private int unitsCompleted;
    private float gpa;

    public Student(int studentID, String fullName, String campus, String courseCode, int unitsCompleted, float gpa) {
        this.studentID = studentID;
        this.fullName = fullName;
        this.campus = campus;
        this.courseCode = courseCode;
        this.unitsCompleted = unitsCompleted;
        this.gpa = gpa;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCampus() {
        return campus;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public int getUnitsCompleted() {
        return unitsCompleted;
    }

    public float getGpa() {
        return gpa;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setUnitsCompleted(int unitsCompleted) {
        this.unitsCompleted = unitsCompleted;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID +
               "\nName: " + fullName +
               "\nCampus: " + campus +
               "\nCourse Code: " + courseCode +
               "\nUnits Completed: " + unitsCompleted +
               "\nGPA: " + gpa;
    }
}
