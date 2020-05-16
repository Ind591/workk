package com.example.workhithaa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.workhithaa.ui.providerhomee.ProviderHomeeFragment;

public class providerHomee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.provider_homee_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ProviderHomeeFragment.newInstance())
                    .commitNow();
        }
    }
}
