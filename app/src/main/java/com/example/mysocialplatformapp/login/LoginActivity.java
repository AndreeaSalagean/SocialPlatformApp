package com.example.mysocialplatformapp.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mysocialplatformapp.main.MainActivity;
import com.example.mysocialplatformapp.R;

public class LoginActivity extends AppCompatActivity {

    private ImageView fingerPrint;
    private EditText pin;
    private TextView pinMessage;
    private Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Intent intent = new Intent(this, MainActivity.class);

        pin = findViewById(R.id.pin);
        pinMessage = findViewById(R.id.pin_message);
        fingerPrint = findViewById(R.id.login_image);
        loginButton = findViewById(R.id.login);

        pin.setVisibility(View.INVISIBLE);
        loginButton.setVisibility(View.INVISIBLE);

        pinMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pin.setVisibility(View.VISIBLE);
                loginButton.setVisibility(View.VISIBLE);
            }
        });

        fingerPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pin.getText().toString().equals("1111")){
                    startActivity(intent);
                }
            }
        });

    }
}