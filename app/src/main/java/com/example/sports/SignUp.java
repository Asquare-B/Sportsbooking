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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class SignUp extends AppCompatActivity {

    private EditText name, age, email, gender;
    private EditText pass,rpass;
    private Button signup;

    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseFirestore firebaseFirestore  = FirebaseFirestore.getInstance();
    public String userID = null;
    public int i =0;



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
                String username = name.getText().toString();
                String userage = age.getText().toString();
                String usergender = gender.getText().toString();

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

                    auth.createUserWithEmailAndPassword(userEmail, userPass).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                userID = auth.getCurrentUser().getEmail();
                                DocumentReference documentReference = firebaseFirestore.collection("users").document(userID);
                                HashMap<String, Object> map = new HashMap<>();
                                map.put("name",username);
                                map.put("age",userage);
                                map.put("gender",usergender);
                                map.put("email",userEmail);
                                map.put("password",userPass);
                                documentReference.set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Log.d("tag","onSuccess:user profile is added");

                                    }

                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.d("tag","onFailer:"+e.toString());
                                    }
                                });
                                startActivity(new Intent(SignUp.this,LogIn.class));
                                Toast.makeText(SignUp.this,"Registration Successful", Toast.LENGTH_LONG).show();

                            }
                            else{
                                Toast.makeText(SignUp.this,"Failed", Toast.LENGTH_LONG).show();
                            }
                        }

                        private String toString(int i) {
                            return ""+i;
                        }
                    });

                }
            }

        });

    }
}
