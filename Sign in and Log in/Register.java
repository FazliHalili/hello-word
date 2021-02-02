package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity{

    EditText name, email, password, phone;
    Button regbtn, loginbtn;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.fullname);
        email = findViewById((R.id.email));
        password = findViewById(R.id.password);
        phone = findViewById(R.id.phoneNo);
        regbtn = findViewById(R.id.registerBtn);
        loginbtn = findViewById((R.id.logintext));

        regbtn.setOnClickListener(v -> {
            reference = FirebaseDatabase.getInstance().getReference("users");
            String Name = name.getText().toString();
            String Email = email.getText().toString();
            String Password = password.getText().toString();
            String Phone = phone.getText().toString();
            UserStorage userStorage = new UserStorage(Name,Email,Password,Phone);
            reference.child(Phone).setValue((userStorage));

            startActivity(new Intent(getApplicationContext(),Login.class));
        });

        loginbtn.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(),Login.class));
        });
    }
}