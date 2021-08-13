package com.example.womansafety;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class login_screen extends AppCompatActivity {
    EditText name, userphonenumber, loginpassword;
    Button go,login_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        name = findViewById(R.id.name);
        loginpassword = findViewById(R.id.loginpassword);
        userphonenumber = findViewById(R.id.loginnum);
        go = findViewById(R.id.go);
        login_signup = findViewById(R.id.login_signup);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String userEnteredpassword = loginpassword.getText().toString().trim();
                final String userEnteredname = name.getText().toString().trim();
                final String userEnteredphonenumber = userphonenumber.getText().toString().trim();

                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
                Query chechkuser = reference.orderByChild("fullname").equalTo(userEnteredname);
                chechkuser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        if(snapshot.exists()){
                            String passwordfromDB = snapshot.child(userEnteredname).child("password").getValue(String.class);
                            String phonenumberfromDB = snapshot.child(userEnteredname).child("phonenumber").getValue(String.class);
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                                if (Objects.equals(passwordfromDB,userEnteredpassword)&&Objects.equals(phonenumberfromDB,userEnteredphonenumber)){
                                    String fullnamefromDB = snapshot.child(userEnteredname).child("fullname").getValue(String.class);
                                    String emailfromDB = snapshot.child(userEnteredname).child("email").getValue(String.class);
                                    String phonenumber1fromDB = snapshot.child(userEnteredname).child("phonenumber1").getValue(String.class);
                                    String phonenumber2fromDB = snapshot.child(userEnteredname).child("phonenumber2").getValue(String.class);
                                    String phonenumber3fromDB = snapshot.child(userEnteredname).child("phonenumber3").getValue(String.class);

                                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                    intent.putExtra("phonenumber1",phonenumber1fromDB);
                                    intent.putExtra("phonenumber2",phonenumber2fromDB);
                                    intent.putExtra("phonenumber3",phonenumber3fromDB);
                                    startActivity(intent);
                                }
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    login_signup.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(login_screen.this, signup.class);
            startActivity(intent);
        }
    });
    }
}