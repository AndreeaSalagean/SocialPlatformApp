package com.example.mysocialplatformapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RequestActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton imgBtn;
    private EditText budgetField;
    private Spinner emergencyLevelSpinner;
    private String photos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        List<String> spinnerArray =  new ArrayList<String>();
        spinnerArray.add("Emergency");
        spinnerArray.add("Service");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.spinner);
        sItems.setAdapter(adapter);

        String selected = sItems.getSelectedItem().toString();
        final TextView budget = findViewById(R.id.textView7);
        budgetField = findViewById(R.id.editText3);
        final TextView emergencyLevel = findViewById(R.id.textView5);
        emergencyLevelSpinner = findViewById(R.id.spinner3);

        sItems.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                if(position == 0){
                    budget.setTextColor(Color.GRAY);
                    budgetField.setEnabled(false);
                    emergencyLevel.setTextColor(Color.BLACK);
                    emergencyLevelSpinner.setEnabled(true);
                }else{
                    emergencyLevel.setTextColor(Color.GRAY);
                    emergencyLevelSpinner.setEnabled(false);
                    budget.setTextColor(Color.BLACK);
                    budgetField.setEnabled(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

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

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            photos = extras.getString("photos");
            if("yes".equals(photos)){
                findViewById(R.id.imageView2).setVisibility(View.VISIBLE);
            }else{
                findViewById(R.id.imageView2).setVisibility(View.INVISIBLE);
            }
        }

    }

    @Override
    public void onClick(View v) {

        Intent k = new Intent(RequestActivity.this, SelectImageActivity.class);
        startActivity(k);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_request, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast toast = Toast.makeText(getApplicationContext(), "Request created successfully!", Toast.LENGTH_SHORT);
        toast.show();
        Intent k = new Intent(RequestActivity.this, MainScreenActivity.class);
        startActivity(k);
        return true;
    }
}
