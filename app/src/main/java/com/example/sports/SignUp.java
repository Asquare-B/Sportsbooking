package com.example.sports;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    private EditText name, age, email, gender;
    private EditText pass,rpass;
    private Button signup;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = findViewById(R.id.SignupName);
        age = findViewById(R.id.SignupAge);
        gender = findViewById(R.id.SignupGender);
        email = findViewById(R.id.SignupEmail);
        pass = findViewById(R.id.SignupPass);
        rpass = findViewById(R.id.SignupRePass);
        signup = findViewById(R.id.button8);

        auth = FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEmail = email.getText().toString();
                String userPass = pass.getText().toString();
                String userRpass = rpass.getText().toString();

                if(TextUtils.isEmpty( userEmail) || TextUtils.isEmpty(userPass)){
                    Toast.makeText(SignUp.this,"Empty Credentials", Toast.LENGTH_LONG).show();
                }
                else if(userPass.length()<6){
                    Toast.makeText(SignUp.this,"Password is short", Toast.LENGTH_LONG).show();
                }
                else if(userPass.equals(userRpass)==false){
                    Toast.makeText(SignUp.this,"Password is not Same", Toast.LENGTH_LONG).show();
                }
                else{
                    registerUser(userEmail,userPass);
                }
            }
        });

    }

    private void registerUser(String email, String userPass) {

        auth.createUserWithEmailAndPassword(email, userPass).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(SignUp.this,"Registration Successful", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(SignUp.this,"Failed", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
