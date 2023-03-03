package com.example.event;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SendMassgeForm extends AppCompatActivity {

    EditText dateFormat, txt_fullname, txt_phone_no, txt_email, txt_function_date, txt_no_of_guest, txt_no_of_room, txt_function_type, txt_function_time;;
    int date, month, year;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_massge_form);
        dateFormat = findViewById(R.id.sendFunctionDate);
        Calendar calendar = Calendar.getInstance();

        txt_fullname = findViewById(R.id.sendName);
        txt_phone_no = findViewById(R.id.sendPhone);
        txt_email = findViewById(R.id.sendEmailAddress);
        txt_function_date = findViewById(R.id.sendFunctionDate);
        txt_no_of_guest = findViewById(R.id.sendNumOfGuests);
        txt_no_of_room = findViewById(R.id.sendNumOfRooms);
        txt_function_type = findViewById(R.id.txtFunctionType);
        txt_function_time = findViewById(R.id.txtFunctionTime);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        dateFormat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date = calendar.get(Calendar.DATE);
                month = calendar.get(Calendar.MONTH);
                year = calendar.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(SendMassgeForm.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        dateFormat.setText(SimpleDateFormat.getDateInstance().format(calendar.getTime()));
                    }
                }, date, month, year);
                datePickerDialog.show();
            }
        });
    }
}