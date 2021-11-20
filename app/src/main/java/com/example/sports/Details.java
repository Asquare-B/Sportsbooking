package com.example.sports;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ActionBar actionBar = getSupportActionBar();
        TextView mDetailsTv = findViewById(R.id.textView4);

        Intent intent = getIntent();
        String mActionBarTitle = intent.getStringExtra("actionBarTitle");
        String mcontentTv = intent.getStringExtra("contentTV");

        actionBar.setTitle(mActionBarTitle);
        mDetailsTv.setText(mcontentTv);



    }
}