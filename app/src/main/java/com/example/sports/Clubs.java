package com.example.sports;

import android.text.style.ClickableSpan;

public class Clubs {

    String title, desc;
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
