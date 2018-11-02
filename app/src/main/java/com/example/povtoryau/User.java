package com.example.povtoryau;

import java.io.InputStream;

/**
 * Created by Администратор on 02.11.2018.
 */

public class User {
    private String name;
    private String date;
    private String phone;
    private Integer id;

    public User(String name, String date, String phone, Integer id) {
        this.name = name;
        this.date = date;
        this.phone = phone;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getPhone() {
        return phone;
    }

    public Integer getId() {
        return id;
    }
}
