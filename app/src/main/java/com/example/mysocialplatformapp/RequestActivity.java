package com.example.mysocialplatformapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class RequestActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton imgBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        List<String> spinnerArray =  new ArrayList<String>();
        spinnerArray.add("Emergency");
        spinnerArray.add("Service");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.spinner);
        sItems.setAdapter(adapter);

        ///////!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//        String selected = sItems.getSelectedItem().toString();
//        if (selected.equals("what ever the option was")) {
//        }

        List<String> spinnerArray2 =  new ArrayList<String>();
        spinnerArray2.add("IT");
        spinnerArray2.add("Electricity");
        spinnerArray2.add("Plumbing");
        spinnerArray2.add("Gardening");
        spinnerArray2.add("Drain");

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray2);

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems2 = (Spinner) findViewById(R.id.spinner2);
        sItems2.setAdapter(adapter2);

        List<String> spinnerArray3 =  new ArrayList<String>();
        spinnerArray3.add("Low");
        spinnerArray3.add("Medium");
        spinnerArray3.add("High");
        spinnerArray3.add("Very high");

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray3);

        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems3 = (Spinner) findViewById(R.id.spinner3);
        sItems3.setAdapter(adapter3);

        imgBtn = (ImageButton) findViewById(R.id.imageButton);

        imgBtn.setOnClickListener(RequestActivity.this);

    }

    @Override
    public void onClick(View v) {

        Intent k = new Intent(RequestActivity.this, SelectImageActivity.class);
        startActivity(k);
    }
}
