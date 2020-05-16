package com.example.workhithaa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    EditText nameTV,addressTV,mobileTV,emailTV,passwordTV;
    Button b1;
    Spinner s1;
    String [] usertype;
    TextView t1;
    private FirebaseAuth mAuth;
    FirebaseDatabase database;
    DatabaseReference reference;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();


        nameTV =(EditText)findViewById(R.id.name);
        addressTV =(EditText)findViewById(R.id.address);
        mobileTV =(EditText)findViewById(R.id.mobile);
        emailTV =(EditText)findViewById(R.id.email);
        passwordTV =(EditText)findViewById(R.id.password);
        b1 =(Button) findViewById(R.id.b1);
        s1 =(Spinner) findViewById(R.id.spinner);
        t1 =(TextView) findViewById(R.id.t1);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("User");

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(in);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerNewUser();
            }
        });

    }
    private void getValues(){
        user.setName(nameTV.getText().toString());
        user.setAddress(addressTV.getText().toString());
        user.setMobile(mobileTV.getText().toString());
        user.setEmail(emailTV.getText().toString());
        user.setPassword(passwordTV.getText().toString());
        user.setS1(s1.getClass().toString());
    }


    private void registerNewUser() {
       final String name;
        final String address;
        final String mobile;
        final String email;
        final String password;
        String s1 = "";

        name = nameTV.getText().toString();
        address = addressTV.getText().toString();
        mobile= mobileTV.getText().toString();
        email = emailTV.getText().toString();
        password = passwordTV.getText().toString();
        s1  = s1.getClass().toString();


        if (TextUtils.isEmpty(name)) {
            Toast.makeText(getApplicationContext(), "Please enter full name...", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(address)) {
            Toast.makeText(getApplicationContext(), "Please enter address...", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(mobile)) {
            Toast.makeText(getApplicationContext(), "Please enter mobile number...", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Please enter email...", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Please enter password...", Toast.LENGTH_LONG).show();
            return;
        }


        final String finalS1 = s1;
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            User user = new User(
                                    name,
                                    address,
                                    mobile,
                                    email,
                                    password,
                                    finalS1
                            );


                            FirebaseDatabase.getInstance().getReference("User")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(RegisterActivity.this, "Registration Success!", Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(RegisterActivity.this, "Registration Fail!", Toast.LENGTH_LONG).show();

                                    }
                                }
                            });
                        } else {
                            Toast.makeText(getApplicationContext(), "Registration failed! Please try again later", Toast.LENGTH_LONG).show();
                        }


                    }
                });


    }
}
