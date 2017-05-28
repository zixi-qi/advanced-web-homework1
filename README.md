# Advanced Web Homework2
###Introduction

This homework is about web backend technology,I have built a set of Restful APIs of a student management system 
using spring boot and mybatis. The functionality of this project is quite simple:
just the create,update,delete,retrieve of a student.The purpose of this project 
is to try out different aspects of backend technology. 

###Project Structure
the structure of this project is:

entity->mapper->service->controller

###Data level
the database I use in this project is MySQL

table name:student

| id | age | name | address |
|----|-----|------|---------|

I use MyBatis to do O/R mapping from student table to Student entity

###Logging

I add a logging aspect to this project using AOP feature of Spring 
Framework to log the request url,ip,arguments and response contents

###Testing
I add testing for Spring controller using JUnit4 and testing for Restful
API using Mockito

