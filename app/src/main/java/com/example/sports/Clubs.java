package com.example.sports;


public class Clubs {

    String name;
    String add;
    String image;


    public Clubs() {
    }

    public Clubs(String name, String add, String image) {
        this.name = name;
        this.add = add;
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getAdd() {
        return add;
    }
}
