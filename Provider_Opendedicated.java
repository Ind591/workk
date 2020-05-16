package com.example.workhithaa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Provider_Opendedicated extends AppCompatActivity {
  Button b1,b2,b3,b4,b5,b6,b7,submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider__opendedicated);
        b1=(Button)findViewById(R.id.bb1);
        b2=(Button)findViewById(R.id.bb2);
        b3=(Button)findViewById(R.id.bb3);
        b4=(Button)findViewById(R.id.bb4);
        b5=(Button)findViewById(R.id.bb5);
        b6=(Button)findViewById(R.id.bb6);
        b7=(Button)findViewById(R.id.bb7);
        submit=(Button)findViewById(R.id.submit);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent (Provider_Opendedicated.this,opendedicatedaddphotos.class);
                startActivity(in);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent (Provider_Opendedicated.this,addplace.class);
                startActivity(in);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent (Provider_Opendedicated.this,opendedicatedaddamount.class);
                startActivity(in);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent (Provider_Opendedicated.this,opendedicatedaddamenities.class);
                startActivity(in);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent (Provider_Opendedicated.this,opendedicatedaddspaceinfo.class);
                startActivity(in);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent (Provider_Opendedicated.this,opendedicatedoverview.class);
                startActivity(in);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent (Provider_Opendedicated.this,opendedicatedopeningshour.class);
                startActivity(in);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent (Provider_Opendedicated.this,Providerpage.class);
                startActivity(in);
            }
        });


    }
}
