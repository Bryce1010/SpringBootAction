package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetPersonInfoController {
    @Value("${name}")
    private String name;

    @Value("${age}")
    private int age;

    @GetMapping("/getage")
    public int getAge(){
        return age;
    }

    @GetMapping("/getname")
    public String getName(){
        return name;
    }

    @Autowired
    private GetPersonInfoProperties getPersonInfoProperties;

    @GetMapping("/getPersonProperties")
    public String getPersonProperties(){
        return getPersonInfoProperties.getName()+ getPersonInfoProperties.getAge();
    }


}
