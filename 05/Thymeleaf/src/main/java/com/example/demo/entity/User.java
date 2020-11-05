package com.example.demo.entity;

import lombok.Data;

@Data
public class User {

    private long id;

    private String name;

    public User(long id,String name){
        this.id=id;
        this.name=name;
    }


}
