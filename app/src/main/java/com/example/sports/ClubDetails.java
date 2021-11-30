package com.example.sports;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class ClubDetails extends AppCompatActivity {

    TextView name,address,price,sport,comment;
    Button bookBtn;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    int p =0;
    String useremail;
    String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_details);

        name = findViewById(R.id.name);
        address = findViewById(R.id.address);
        price = findViewById(R.id.price);
        sport = findViewById(R.id.sport);
        comment = findViewById(R.id.comment);
        bookBtn = findViewById(R.id.bookClub);
        useremail = auth.getCurrentUser().getEmail();

        name.setText(getIntent().getStringExtra("name").toString());
        address.setText(getIntent().getStringExtra("address").toString());
        id = getIntent().getStringExtra("id");
        p = getIntent().getIntExtra("price",0);
        price.setText(String.valueOf(p));
        sport.setText(getIntent().getStringExtra("sport").toString());

        bookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClubDetails.this,BookingForm.class);
                intent.putExtra("name", name.getText().toString());
                intent.putExtra("address", address.getText().toString());
                intent.putExtra("price", price.getText().toString());
                intent.putExtra("sport", sport.getText().toString());
                intent.putExtra("sport", sport.getText().toString());
                intent.putExtra("pricePerPerson",p);
                intent.putExtra("id",id);
                intent.putExtra("useremail", useremail);
                startActivity(intent);
                finish();
            }
        });

    }
}