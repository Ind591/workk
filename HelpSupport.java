package com.example.workhithaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.workhithaa.ui.helpsupport.HelpSupportFragment;

public class HelpSupport extends AppCompatActivity {
    EditText call,chat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_support_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, HelpSupportFragment.newInstance())
                    .commitNow();
        }
        call =(EditText)findViewById(R.id.call);
        chat = (EditText)findViewById(R.id.chat);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(HelpSupport.this,callus.class);
                startActivity(in);
            }
        });
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(HelpSupport.this,chatwithus.class);
                startActivity(in);

            }
        });
    }
}
