package com.example.salesrecord.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.salesrecord.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SalesActivity extends AppCompatActivity {
    private BottomNavigationView navigationView;
    private Button insertSaleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);
        // Assign variables
        navigationView = findViewById(R.id.bottom_navigation);
        insertSaleButton = findViewById(R.id.create_sale_button);


        // Button Methods
        insertSaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SalesRegister.class));
            }
        });


        // Navigation Menu

        // set selected item
        navigationView.setSelectedItemId(R.id.home);
        // Perform selection list
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.home:
                        return true;
                    case R.id.config:
                        Intent intent = new Intent(getApplicationContext(), ConfigActivity.class);
                        startActivity(intent);
                        finish();
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    protected void onRestart() {
        navigationView.setSelectedItemId(R.id.home);
        super.onRestart();
    }

}