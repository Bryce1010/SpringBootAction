package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PropertiesTest {

    @Autowired
    private PropertiesExample propertiesExample;

    @Test
    public void getName(){
        System.out.println(propertiesExample.getName());
    }

    @Test
    public void getAge(){
        System.out.println(propertiesExample.getAge());
    }

    @Test
    public void getNameAddress(){
        System.out.println(propertiesExample.getAddress());
    }
}
