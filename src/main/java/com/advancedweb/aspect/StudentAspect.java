package com.advancedweb.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by Alex on 2017/5/28.
 */
@Aspect
@Component
public class StudentAspect {

    private final static Logger logger = LoggerFactory.getLogger(StudentAspect.class);

    @Pointcut("execution(public * com.advancedweb.controller.StudentController.*(..))")
    public void log(){}

    @Before("log()")
    public void logRequest(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes==null){
            //happens when testing
            return;
        }
        HttpServletRequest request = attributes.getRequest();
        //log url
        logger.info("url={}",request.getRequestURL());
        //log method
        logger.info("url={}",request.getMethod());
        //log ip
        logger.info("ip={}",request.getRemoteAddr());
        //log method
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //log arguments
        logger.info("args={}",joinPoint.getArgs());

    }

    @AfterReturning(pointcut = "log()",returning = "object")
    public void logResponse(Object object){
        String msg = object==null?"null":object.toString();
        logger.info("response={}",msg);
    }


}
