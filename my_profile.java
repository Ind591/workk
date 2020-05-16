package com.example.workhithaa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.workhithaa.ui.myprofile.MyProfileFragment;

public class my_profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_profile_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MyProfileFragment.newInstance())
                    .commitNow();
        }
    }
}
