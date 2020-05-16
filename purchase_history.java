package com.example.workhithaa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.workhithaa.ui.purchasehistory.PurchaseHistoryFragment;

public class purchase_history extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.purchase_history_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, PurchaseHistoryFragment.newInstance())
                    .commitNow();
        }
    }
}
