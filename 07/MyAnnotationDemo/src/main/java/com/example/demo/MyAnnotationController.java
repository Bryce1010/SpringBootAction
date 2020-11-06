package com.example.demo;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAspectJAutoProxy
public class MyAnnotationController {

    @RequestMapping("/")
    @MyTestAnnotation("xyang")
    public void testAnnotation(){
        System.err.println("测试自定义注解");
    }
}
