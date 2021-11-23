package com.example.sports;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogIn extends AppCompatActivity {

    private EditText email,password;
    private Button login,register;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        auth = FirebaseAuth.getInstance();

        login = findViewById(R.id.button4);
        email = findViewById(R.id.LoginUsername);
        password = findViewById(R.id.LoginPassword);
        register = findViewById(R.id.button5);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LogIn.this,SignUp.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEmail = email.getText().toString();
                String userPass = password.getText().toString();


                if(TextUtils.isEmpty( userEmail)){
                    Toast.makeText(LogIn.this,"Empty email", Toast.LENGTH_LONG).show();
                    email.requestFocus();
                }
                else if(TextUtils.isEmpty( userPass)){
                    Toast.makeText(LogIn.this,"Empty password", Toast.LENGTH_LONG).show();
                    password.requestFocus();
                }
                else{
                    loginUser(userEmail,userPass);
                }
            }
        });

    }

    private void loginUser(String userEmail, String userPass) {
        auth.signInWithEmailAndPassword(userEmail,userPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(LogIn.this, "User logged in successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LogIn.this, MainActivity.class));
                }else{
                    Toast.makeText(LogIn.this, "Log in Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}