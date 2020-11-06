package com.example.demo.config;

import com.example.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class IocTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testIoc(){
        User user = (User)applicationContext.getBean("user1");
        System.out.println(user);
    }
}
