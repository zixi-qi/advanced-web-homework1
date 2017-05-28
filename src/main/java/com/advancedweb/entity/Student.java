package com.advancedweb.entity;

import java.io.Serializable;

/**
 * Created by Alex on 2017/5/28.
 */
public class Student implements Serializable {
    private Integer studentId;
    private Integer studentAge;
    private String studentName;
    private String studentAddress;

    public Student(){

    }

    public Student(Integer studentId, String studentName, Integer studentAge, String studentAddress) {
        this.studentId = studentId;
        this.studentAge = studentAge;
        this.studentName = studentName;
        this.studentAddress = studentAddress;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    @Override
    public String toString(){
        return "student"+ studentName;
    }
}