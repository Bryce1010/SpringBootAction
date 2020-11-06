package com.example.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class TestAnnotationAspect {
    @Pointcut("@annotation(com.example.demo.MyTestAnnotation)")
    public void myAnnotationPointCut(){

    }

    @Before("myAnnotationPointCut()")
    public void before(JoinPoint joinPoint)throws Throwable{
        MethodSignature sign = (MethodSignature)joinPoint.getSignature();
        Method method = sign.getMethod();
        MyTestAnnotation annotation = method.getAnnotation(MyTestAnnotation.class);
        System.out.println("TestAnnotation参数:"+annotation.value());
    }
}
