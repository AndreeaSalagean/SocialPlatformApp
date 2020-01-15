package com.example.mysocialplatformapp.payment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mysocialplatformapp.R;
import com.example.mysocialplatformapp.announcementDetails.AnnouncementDetailActivity;
import com.example.mysocialplatformapp.reviewUser.UserReviewActivity;

public class PaymentActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Spinner mySpinner = findViewById(R.id.spinner6);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(PaymentActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.months));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
                Toast.makeText(getBaseContext(), "You complete a collaboration! Check your bonus points!" , Toast.LENGTH_SHORT ).show();

            }
        });

    }
}
