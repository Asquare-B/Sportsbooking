package com.example.sports;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LogIn extends AppCompatActivity {

    private EditText email,password;
    private Button login,register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        login = findViewById(R.id.button4);
        email = findViewById(R.id.LoginUsername);
        password = findViewById(R.id.LoginPassword);
        register = findViewById(R.id.button5);



    }
}