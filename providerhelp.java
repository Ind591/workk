package com.example.workhithaa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.workhithaa.ui.providerhelp.ProviderhelpFragment;

public class providerhelp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.providerhelp_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ProviderhelpFragment.newInstance())
                    .commitNow();
        }
    }
}
