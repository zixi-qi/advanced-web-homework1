package com.advancedweb;

import com.advancedweb.controller.StudentController;
import com.advancedweb.entity.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertTrue;

/**
 * Created by Alex on 2017/5/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Homework2Application.class, webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerTest {

    @Autowired
    private StudentController studentController;

    private Student student1 = new Student(1,"alex",15,"dalian");
    private Student student2 = new Student(2,"jack",18,"beijing");
    private Student student3 = new Student(3,"john",21,"shanghai");
    private Student student4 = new Student(3,"john",24,"shanghai");

    private List<Student> students = null;

    private boolean sameStudent(Student studentX,Student studentY){
        if (studentX==null||studentY==null){
            return false;
        }
        if (!Objects.equals(studentX.getStudentId(), studentY.getStudentId())){
            return false;
        }
        if (!Objects.equals(studentX.getStudentAge(),studentY.getStudentAge())){
            return false;
        }
        if (!Objects.equals(studentX.getStudentAddress(),studentY.getStudentAddress())){
            return false;
        }
        if (!Objects.equals(studentX.getStudentName(),studentY.getStudentName())){
            return false;
        }
        return true;
    }

    @Before
    public void setUp(){
        students = new ArrayList<>();
        students.add(new Student(1,"alex",15,"dalian"));
        students.add(new Student(2,"jack",18,"beijing"));
        students.add(new Student(3,"john",21,"shanghai"));
        students.add(new Student(4,"john",24,"shanghai"));
        for (Student s:students) {
            studentController.addStudent(s);
        }
    }

    @Test
    public void testFindStudentById() {
        for (Student s:students) {
            assertTrue(sameStudent(s,studentController.getStudentById(s.getStudentId())));
        }
    }

    @Test
    public void testUpdateStudent(){
        for (Student s:students){
            s.setStudentAge(s.getStudentAge()+1);
            s.setStudentName(s.getStudentName()+"a");
            s.setStudentAddress(s.getStudentAddress()+"a");
            studentController.updateStudent(s);
            assertTrue(sameStudent(s,studentController.getStudentById(s.getStudentId())));
        }
    }

    @After
    public void tearDown(){
        for (Student s:students) {
            studentController.deleteStudentById(s.getStudentId());
        }
    }

}