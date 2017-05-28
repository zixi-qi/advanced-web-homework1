package com.advancedweb.service;

import com.advancedweb.entity.Student;
import com.advancedweb.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by Alex on 2017/5/28.
 */
@Service
@ComponentScan(basePackages = {"com.ooad.mapper",})
public class StudentService implements Serializable {

    private StudentMapper studentMapper;

    @Autowired
    public StudentService(StudentMapper studentMapper){
        this.studentMapper = studentMapper;
    }

    public Student getStudentById(int id){
        return studentMapper.getStudentById(id);
    }

    public void deleteStudentById(int id){
        studentMapper.deleteStudentById(id);
    }

    public void addStudent(Student student){
        studentMapper.addStudent(student);
    }

    public void updateStudent(Student student){
        studentMapper.updateStudent(student);
    }


}
