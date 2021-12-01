package com.example.sports;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class booking_list extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<booking> bookingArrayList;
    bookAdapter bookAdapter;
    FirebaseFirestore firebaseFirestore;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    private Button refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking_list);
        refresh = findViewById(R.id.loadButton);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        firebaseFirestore = FirebaseFirestore.getInstance();


        bookingArrayList = new ArrayList<booking>();
        bookingArrayList.clear();
        bookAdapter = new bookAdapter(booking_list.this,bookingArrayList);
        recyclerView.setAdapter(bookAdapter);
        getData();


        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(booking_list.this,MainActivity.class));
                finish();
            }
        });

    }

    private void getData() {

        firebaseFirestore.collection("bookings").whereEqualTo("email",auth.getCurrentUser().getEmail()).whereEqualTo("counter",false)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot d:list){

                            booking booking = d.toObject(com.example.sports.booking.class);
                            bookingArrayList.add(booking);
                        }
                        bookAdapter.notifyDataSetChanged();
                    }
                });


    }

}
