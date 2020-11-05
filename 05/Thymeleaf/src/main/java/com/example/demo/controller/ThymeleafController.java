package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("thymeleaf")
public class ThymeleafController {
    @GetMapping("/variable")
    public ModelAndView variable(){
        ModelAndView modelAndView = new ModelAndView("thymeleaf");
        String name="xyang";
        int age=18;
        modelAndView.addObject("name",name);
        modelAndView.addObject("age",age);
        return modelAndView;
    }

    @GetMapping("/")
    public ModelAndView index(){
        List<Object> list = new ArrayList<Object>();
        list.add("beijing");
        list.add("shanghai");
        list.add("xian");
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("list",list);
        return modelAndView;
    }

    @GetMapping("/list2")
    public ModelAndView list2(){
        List<Object> list = new ArrayList<>();
        list.add(new User(1,"long"));
        list.add(new User(2,"xyang"));
        list.add(new User(3,"bryce1010"));
        ModelAndView modelAndView = new ModelAndView("list2");
        modelAndView.addObject("list",list);
        return modelAndView;
    }

    @GetMapping("/map")
    public ModelAndView map(){
        Map user = new HashMap();
        user.put("name","姓名");
        user.put("sex","male");
        ModelAndView modelAndView = new ModelAndView("map");
        modelAndView.addObject("map",user);
        return modelAndView;
    }

}
