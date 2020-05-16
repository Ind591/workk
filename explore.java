package com.example.workhithaa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.workhithaa.ui.explore.ExploreFragment;

public class explore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explore_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ExploreFragment.newInstance())
                    .commitNow();
        }
    }
}
