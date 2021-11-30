package com.example.sports;


public class Clubs {

    String name;
    String address;
    int price;
    String sport;
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }


    public Clubs(String name, String address, int price, String sport,String id) {
        this.name = name;
        this.address = address;
        this.price = price;
        this.sport = sport;
        this.id = id;
    }

    public Clubs() {
    }

    public Clubs(String name, String address) {
        this.name = name;
        this.address = address;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
