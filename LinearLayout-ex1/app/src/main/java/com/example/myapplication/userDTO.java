package com.example.myapplication;

import java.io.Serializable;

public class userDTO implements Serializable {
    private String id;
    private String password;
    private String name;
    private String birth;

    public userDTO(String id,String password, String name, String birth) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.birth = birth;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }







}
