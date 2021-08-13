package com.example.womansafety;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {
    Button signup, back;
    EditText fullname, email, password, phonenumber, phonenumber1, phonenumber2, phonenumber3;
    FirebaseDatabase rootNode;
    DatabaseReference refrence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup);

        signup = findViewById(R.id.signup);
        back = findViewById(R.id.back);
        fullname = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phonenumber = findViewById(R.id.phone_number);
        password = findViewById(R.id.password);
        phonenumber1 = findViewById(R.id.phone_number1);
        phonenumber2 = findViewById(R.id.phone_number2);
        phonenumber3 = findViewById(R.id.phone_number3);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signup.this, login_screen.class);
                startActivity(intent);
                rootNode = FirebaseDatabase.getInstance();
                refrence = rootNode.getReference("users");

                String rname = fullname.getText().toString();
                String remail = email.getText().toString();
                String rphonenumber = phonenumber.getText().toString();
                String rpassword = password.getText().toString();
                String rphonenumber1 = phonenumber1.getText().toString();
                String rphonenumber2 = phonenumber2.getText().toString();
                String rphonenumber3 = phonenumber3.getText().toString();
                UserHelperClass helperclass = new UserHelperClass(rname, remail, rphonenumber, rpassword, rphonenumber1, rphonenumber2, rphonenumber3);
                refrence.child(rname).setValue(helperclass);

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signup.this, login_screen.class);
                startActivity(intent);
            }
        });
    }

}