package com.example.sports;


public class Clubs {

    String title, desc;
    String add, sportname, price;
    String[] comments;
    int icon;

    public Clubs(String title, String desc, int icon) {
        this.title = title;
        this.desc = desc;
        this.icon = icon;
    }

    public String getTitle(){
        return this.title;
    }

    public String getDesc(){
        return this.desc;
    }

    public int getIcon(){
        return this.icon;
    }
}
