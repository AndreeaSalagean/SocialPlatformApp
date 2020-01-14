package com.example.mysocialplatformapp.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.mysocialplatformapp.main.MainActivity;
import com.example.mysocialplatformapp.R;

public class LoginActivity extends AppCompatActivity {

    private ImageView fingerPrint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Intent intent = new Intent(this, MainActivity.class);

        fingerPrint = findViewById(R.id.image);
        fingerPrint.setImageResource(R.drawable.fingerprint);
        fingerPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
}