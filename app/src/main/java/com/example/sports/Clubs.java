package com.example.sports;


public class Clubs {

    String name;
    String address;


    public Clubs() {
    }

    public Clubs(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdd(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
