package com.advancedweb.mapper;

import com.advancedweb.entity.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * Created by Alex on 2017/5/28.
 */
@Mapper
@Component
public interface StudentMapper {

    @Select("SELECT * FROM student WHERE ID = #{id}")
    @Results({
            @Result(property = "studentId",  column = "id"),
            @Result(property = "studentAge",column = "age"),
            @Result(property = "studentName", column = "name"),
            @Result(property = "studentAddress",column = "address"),

    })
    Student getStudentById(@Param("id") Integer id);

    @Insert("INSERT INTO student(id,age,name,address) VALUES(#{studentId},#{studentAge},#{studentName},#{studentAddress})")
    @Results({
            @Result(property = "studentId",  column = "id"),
            @Result(property = "studentAge",column = "age"),
            @Result(property = "studentName", column = "name"),
            @Result(property = "studentAddress",column = "address"),

    })
    void addStudent(Student student);

    @Delete("DELETE FROM student WHERE ID = #{id}")
    void deleteStudentById(@Param("id") Integer id);

    @Update("UPDATE STUDENT SET age = #{studentAge},name = #{studentName},address = #{studentAddress} WHERE id = #{studentId}" )
    void updateStudent(Student student);

}