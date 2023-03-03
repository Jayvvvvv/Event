package com.example.event;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegistrationActivity extends AppCompatActivity {

    Button btnRegister;
    TextView alreadyHaveAnAcount;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    EditText name, email, password, phone, conform_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        name = findViewById(R.id.editTextTextPersonName);
        email = findViewById(R.id.editTextEmailAddress);
        phone = findViewById(R.id.editTextPhone);
        password = findViewById(R.id.editTextPassword);
        conform_password = findViewById(R.id.editTextPassword2);
        progressDialog = new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();


        alreadyHaveAnAcount = findViewById(R.id.already_have_an_accont);
        alreadyHaveAnAcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btnRegister = findViewById(R.id.btn_signup);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PerforAuth();
            }
        });
    }

    private void PerforAuth() {
        String n = name.getText().toString();
        String e = email.getText().toString();
        String ph = phone.getText().toString();
        String p = password.getText().toString();
        String cp = conform_password.getText().toString();


        if (!e.matches(emailPattern)){
            email.setError("Enter Correct Email");
        } else if (p.isEmpty() || p.length()<6) {
            password.setError("Enter Proper Password");
        } else if (!p.equals(cp)) {
            conform_password.setError("Password Not match Both field");
        }else {
            progressDialog.setMessage("Please Wait While Signup...");
            progressDialog.setTitle("Signup");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(e,p).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(RegistrationActivity.this, "SignedUp Successfully", Toast.LENGTH_SHORT).show();
                    }else {
                        progressDialog.dismiss();
                        Toast.makeText(RegistrationActivity.this, "This email is already exist.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void sendUserToNextActivity() {
        Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
        startActivity(intent);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
    }
}