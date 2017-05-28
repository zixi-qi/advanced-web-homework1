package com.advancedweb.controller;

import com.advancedweb.entity.Student;
import com.advancedweb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Alex on 2017/5/28.
 */
@RestController
@RequestMapping(value = "/student")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @RequestMapping(value = "",method = RequestMethod.GET)
    public Student getStudentById(@RequestParam("id") Integer studentId){
        return studentService.getStudentById(studentId);
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @RequestMapping(value = "",method = RequestMethod.DELETE)
    public void deleteStudentById(int id){
        studentService.deleteStudentById(id);
    }

    @RequestMapping(value = "",method = RequestMethod.PUT)
    public void updateStudent(Student student){
        studentService.updateStudent(student);
    }
}
