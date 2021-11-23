package com.example.sports;


public class Clubs {

    String name;
    String add, sportname, price;
    String[] comments;
    int logo;
    String imageurl;

    public Clubs(String name, String add, int logo) {
        this.name = name;
        this.add = add;
        this.logo = logo;
    }

    public String getImageurl() {
        return imageurl;
    }

    public Clubs(String name, String add, String sportname, String price, String[] comments, int logo, String imageurl) {
        this.name = name;
        this.add = add;
        this.sportname = sportname;
        this.price = price;
        this.comments = comments;
        this.logo = logo;
        this.imageurl = imageurl;
    }

    public String getName() {
        return name;
    }

    public String getAdd() {
        return add;
    }

    public String getSportname() {
        return sportname;
    }

    public String getPrice() {
        return price;
    }

    public String[] getComments() {
        return comments;
    }

    public int getLogo() {
        return logo;
    }
}
