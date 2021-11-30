package com.example.sports;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ConfirmationPage extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks {

    CheckBox checkBox;
    GoogleApiClient googleApiClient;
    Button back;
    String details;
    TextView bookingDetails;
    FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    FirebaseAuth auth = FirebaseAuth.getInstance();

    String SiteKey = "6LdUkGwdAAAAALidYXTUaRxinWgdhwvW8hQW2oID";
    String SecretKey = "6LdUkGwdAAAAAMgK42227SA1fC7YCX2_yvWccwHS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_page);
        back = findViewById(R.id.verifyBooking);
        checkBox=findViewById(R.id.checkBox);

        details = "User Detials:  UserEmail: " + getIntent().getStringExtra("useremail")+
                "\n Club Details:\n Club name "+ getIntent().getStringExtra("name") +
                "\n Club ID: "+getIntent().getStringExtra("id")+
                "\n Club address:"+ getIntent().getStringExtra("address")+
                "\n Price/Person:"+ getIntent().getStringExtra("price") +
                "\n Selected sport:"+ getIntent().getStringExtra("sport") +
                "\n Person count:"+ getIntent().getIntExtra("count",0) +
                "\n Booking Date: " + getIntent().getStringExtra("date")+
                "\n Booking Time: "+getIntent().getStringExtra("time")+
                "\n Total Cost: "+getIntent().getIntExtra("cost",0);

        bookingDetails = findViewById(R.id.bookingDetials);
        bookingDetails.setText(details);
        googleApiClient = new GoogleApiClient.Builder(this)
                .addApi(SafetyNet.API)
                .addConnectionCallbacks(ConfirmationPage.this)
                .build();
        googleApiClient.connect();
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox.isChecked()){
                    SafetyNet.SafetyNetApi.verifyWithRecaptcha(googleApiClient,SiteKey)
                            .setResultCallback(new ResultCallback<SafetyNetApi.RecaptchaTokenResult>() {
                                @Override
                                public void onResult(@NonNull SafetyNetApi.RecaptchaTokenResult recaptchaTokenResult) {
                                    Status status = recaptchaTokenResult.getStatus();
                                    if((status!=null) && status.isSuccess()){
                                        Toast.makeText(getApplicationContext()
                                                ,"Successfully Verified.."
                                                ,Toast.LENGTH_SHORT).show();

                                        checkBox.setTextColor(Color.GREEN);
                                    }
                                }
                            });
                }else{
                    checkBox.setTextColor(Color.BLACK);
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertBooking();
            }
        });
    }

    private void insertBooking() {

        Map<Object,Object> map= new HashMap<>();
        map.put("clubname",getIntent().getStringExtra("name"));
        map.put("clubaddress",getIntent().getStringExtra("address"));
        map.put("clubsport",getIntent().getStringExtra("sport"));
        map.put("clubprice",getIntent().getStringExtra("price"));
        map.put("count",getIntent().getIntExtra("count",0));
        map.put("date",getIntent().getStringExtra("date"));
        map.put("time",getIntent().getStringExtra("time"));
        map.put("cost",getIntent().getIntExtra("cost",0));
        map.put("email",getIntent().getStringExtra("useremail"));
        map.put("counter",false);
        map.put("id",getIntent().getStringExtra("id"));

        firestore.collection("bookings").add(map)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(ConfirmationPage.this,"Booking detailsstored",Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ConfirmationPage.this,"Failed"+e.toString(),Toast.LENGTH_LONG).show();
                    }
                });

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }
}