package com.example.workhithaa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
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

public class providerregister extends AppCompatActivity {
    EditText nameTV,addressTV,mobileTV,emailTV,passwordTV;
    Button b1;
    TextView t1;
    private FirebaseAuth mAuth;
    FirebaseDatabase database;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_providerregister);
        mAuth = FirebaseAuth.getInstance();


        nameTV =(EditText)findViewById(R.id.name);
        addressTV =(EditText)findViewById(R.id.address);
        mobileTV =(EditText)findViewById(R.id.mobile);
        emailTV =(EditText)findViewById(R.id.email);
        passwordTV =(EditText)findViewById(R.id.password);
        b1 =(Button) findViewById(R.id.b1);
        t1 =(TextView) findViewById(R.id.t1);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("info");
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(providerregister.this,providerlogin.class);
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

    private void registerNewUser() {
        final String name;
        final String address;
        final String mobile;
        final String email;
        final String password;


        name = nameTV.getText().toString();
        address = addressTV.getText().toString();
        mobile= mobileTV.getText().toString();
        email = emailTV.getText().toString();
        password = passwordTV.getText().toString();



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



        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            info in = new info(
                                    name,
                                    address,
                                    mobile,
                                    email,
                                    password

                            );


                            FirebaseDatabase.getInstance().getReference("info")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(in).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(providerregister.this, "Registration Success!", Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(providerregister.this, providerlogin.class);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(providerregister.this, "Registration Fail!", Toast.LENGTH_LONG).show();

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
