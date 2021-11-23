package com.example.sports;

public class Users {

    String name,gender,email,pass,id;
    int age;

    public Users(String name, String gender, String email, String pass, String id, int age) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.pass = pass;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public String getGender() {
        return this.gender;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPass() {
        return this.pass;
    }

    public String getId() {
        return this.id;
    }

    public int getAge() {
        return this.age;
    }
}
