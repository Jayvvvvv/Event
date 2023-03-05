package com.example.event;

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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SendMassagePhotographer extends AppCompatActivity {

    Button btn_send_massage;
    EditText dateFormat, txt_fullname, txt_phone_no, txt_email, txt_function_date, txt_decription;
    int date, month, year;
    String Description = "";
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_massage_photographer);
        dateFormat = findViewById(R.id.sendFunctionDateP);
        Calendar calendar = Calendar.getInstance();

        txt_fullname = findViewById(R.id.sendNameP);
        txt_phone_no = findViewById(R.id.sendPhoneP);
        txt_email = findViewById(R.id.sendEmailAddressP);
        txt_function_date = findViewById(R.id.sendFunctionDateP);
        txt_decription = findViewById(R.id.sendDescriptionP);
        btn_send_massage = findViewById(R.id.sendPhotographer);

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
                String Description = txt_decription.getText().toString();

                progressDialog.show();

                PhotographerForm form = new PhotographerForm(FullName, Phone, Email, Function_Date, Description);
                databaseReference.push().setValue(form);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.dismiss();
                        Toast.makeText(SendMassagePhotographer.this, "Massage has sent", Toast.LENGTH_SHORT).show();
                    }
                }, 3000);
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

                DatePickerDialog datePickerDialog = new DatePickerDialog(SendMassagePhotographer.this, new DatePickerDialog.OnDateSetListener() {
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