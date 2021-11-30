package com.example.sports;

public class booking {
    String clubname,clubaddress,clubprice,clubsport;
    int cost,count;
    String date,email,id,time;

    public booking(){
    }

    public booking(String clubname, String clubaddress, String clubprice, String clubsport, int cost, int count, String date, String email, String id, String time) {
        this.clubname = clubname;
        this.clubaddress = clubaddress;
        this.clubprice = clubprice;
        this.clubsport = clubsport;
        this.cost = cost;
        this.count = count;
        this.date = date;
        this.email = email;
        this.id = id;
        this.time = time;
    }

    public booking(String clubname, String clubaddress, String clubprice, String clubsport, int cost, int count, String date, String time) {
        this.clubname = clubname;
        this.clubaddress = clubaddress;
        this.clubprice = clubprice;
        this.clubsport = clubsport;
        this.cost = cost;
        this.count = count;
        this.date = date;
        this.time = time;
    }

    public String getClubname() {
        return clubname;
    }

    public void setClubname(String clubname) {
        this.clubname = clubname;
    }

    public String getClubaddress() {
        return clubaddress;
    }

    public void setClubaddress(String clubaddress) {
        this.clubaddress = clubaddress;
    }

    public String getClubprice() {
        return clubprice;
    }

    public void setClubprice(String clubprice) {
        this.clubprice = clubprice;
    }

    public String getClubsport() {
        return clubsport;
    }

    public void setClubsport(String clubsport) {
        this.clubsport = clubsport;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
