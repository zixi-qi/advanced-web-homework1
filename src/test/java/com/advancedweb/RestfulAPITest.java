package com.advancedweb;

import com.advancedweb.controller.StudentController;
import com.advancedweb.entity.Student;
import com.advancedweb.service.StudentService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Alex on 2017/5/28.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
public class RestfulAPITest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    private Student student = null;

    @Before
    public void setUp(){
        student = new Student(1,"jack",20,"shanghai");
        studentService.addStudent(student);
    }

    @Test
    public void testGetStudentById() throws Exception {
        given(this.studentService.getStudentById(1)).willReturn(student);
        this.mockMvc.perform(get("/student?id=1").accept(MediaType.ALL_VALUE)).andExpect(status().isOk()).andExpect(content().string("{\"studentId\":1,\"studentAge\":20,\"studentName\":\"jack\",\"studentAddress\":\"shanghai\"}"));
    }

    @After
    public void tearDown(){
        studentService.deleteStudentById(student.getStudentId());
    }

}
