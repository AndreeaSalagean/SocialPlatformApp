package com.example.mysocialplatformapp.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mysocialplatformapp.R;

public class MainActivity extends AppCompatActivity {

    private Button services;
    private Button announcements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        services = findViewById(R.id.servicesB);
        announcements = findViewById(R.id.announcementsB);

        final Intent intent = new Intent(this, MainScreenActivity.class);
        services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
        announcements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        String logout = getIntent().getStringExtra("logout");
        if (logout!=null && logout.equals("please logout")) {
            finish();
        }
    }
}