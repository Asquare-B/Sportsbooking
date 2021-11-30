package com.example.sports;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Locale;

public class BookingForm extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    Button verify;
    String details, bDate, bTime, bPeople;
    String email,name,address,price,sport,id;
    EditText bookingDate,bookingTime,bookingPeople;
    TextView things;
    int hour, minute;
    int p,cost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_form);
        verify = findViewById(R.id.verifyBooking);
        bookingDate = findViewById(R.id.BookingDate);
        bookingTime = findViewById(R.id.BookingTime);
        bookingPeople = findViewById(R.id.BookingPeople);
        things = findViewById(R.id.comment);


        bDate = bookingDate.getText().toString();
        bTime = bookingTime.getText().toString();
        bPeople = bookingPeople.getText().toString();



        bookingDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });
        bookingTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog();
            }
        });

        email = getIntent().getStringExtra("useremail");
        name = getIntent().getStringExtra("name");
        address = getIntent().getStringExtra("address");
        price = getIntent().getStringExtra("price");
        sport = getIntent().getStringExtra("sport");
        id = getIntent().getStringExtra("id");

        details = "User Details\n"+email+
                "\nClub Detials \nClub Name: " + name+
                "\nClub ID: "+id+
                "\nClub Address: "+address+
                "\nSport: "+sport+
                "\nPrice per person: "+price +
                "\n\nPlease Give the additional detials to book the slot";
        things.setText(details);
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                p = Integer.parseInt(bookingPeople.getText().toString());
                cost = p * getIntent().getIntExtra("pricePerPerson",0);
                Intent intent = new Intent(BookingForm.this,ConfirmationPage.class);
                intent.putExtra("name", name);
                intent.putExtra("address", address);
                intent.putExtra("price", price);
                intent.putExtra("sport", sport);
                intent.putExtra("id",id);
                intent.putExtra("useremail", email);
                intent.putExtra("cost",cost);
                intent.putExtra("time",bTime);
                intent.putExtra("date",bDate);
                intent.putExtra("count", p);
                startActivity(intent);
                finish();
            }
        });
    }

    private  void showTimePickerDialog(){
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedhour, int selectminute) {
                bookingTime.setText(String.format(Locale.getDefault(),"%02d:%02d",selectedhour,selectminute));
                bTime = String.format(Locale.getDefault(),"%02d:%02d",selectedhour,selectminute);
                hour = selectedhour;
                minute = selectminute;
            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,onTimeSetListener,hour,minute,true);
        timePickerDialog.setTitle("Select Time:");
        timePickerDialog.show();
    }

    private  void showDatePickerDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        String date = ""+i2+"/"+i1+"/"+i+"";
        bookingDate.setText(date);
        bDate = date;
    }
}