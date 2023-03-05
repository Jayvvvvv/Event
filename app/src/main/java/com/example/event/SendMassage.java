package com.example.event;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SendMassage extends AppCompatActivity {

    Button btn_send_massage;
    EditText dateFormat, txt_fullname, txt_phone_no, txt_email, txt_function_date, txt_no_of_guest, txt_no_of_room;
    RadioButton txt_pre_wedding, txt_wedding, txt_evening, txt_day;;
    int date, month, year;
    String Function_Type = "";
    String Function_Time = "";
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;

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
        txt_pre_wedding = findViewById(R.id.radio_pre_wed);
        txt_wedding = findViewById(R.id.radio_wed);
        txt_evening = findViewById(R.id.radio_evening);
        txt_day = findViewById(R.id.radio_day);
        btn_send_massage = findViewById(R.id.sendForm);

        // This is the Prograss Dialog
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait While Sending Massage...");
        progressDialog.setCanceledOnTouchOutside(false);

        // This is for firebase Connectivity
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Form");
        firebaseAuth = FirebaseAuth.getInstance();

        btn_send_massage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String FullName = txt_fullname.getText().toString();
                String Phone = txt_phone_no.getText().toString();
                String Email = txt_email.getText().toString();
                String Function_Date = txt_function_date.getText().toString();
                String Number_of_guest = txt_no_of_guest.getText().toString();
                String Number_of_room = txt_no_of_room.getText().toString();
                String Function_Type1 = txt_pre_wedding.getText().toString();
                String Function_Type2 = txt_wedding.getText().toString();
                String Function_Time1 = txt_evening.getText().toString();
                String Function_Time2 = txt_day.getText().toString();

                progressDialog.show();

                Form form = new Form(FullName, Phone, Email, Function_Date, Number_of_guest, Number_of_room, Function_Type1, Function_Type2, Function_Time1, Function_Time2);
                databaseReference.push().setValue(form);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.dismiss();
                        Toast.makeText(SendMassage.this, "Massage has sent", Toast.LENGTH_SHORT).show();
                    }
                }, 3000);


                if(txt_pre_wedding.isChecked()){
                    Function_Type = "Pre-Wedding";
                }
                if(txt_wedding.isChecked()){
                    Function_Type = "Wedding";
                }
                if(txt_evening.isChecked()){
                    Function_Time = "Evening";
                }
                if(txt_day.isChecked()){
                    Function_Time = "Day";
                }
            }

        });

        progressDialog.dismiss();
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

                DatePickerDialog datePickerDialog = new DatePickerDialog(SendMassage.this, new DatePickerDialog.OnDateSetListener() {
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
