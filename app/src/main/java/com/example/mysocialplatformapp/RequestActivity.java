package com.example.mysocialplatformapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import java.time.LocalDateTime;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mysocialplatformapp.model.Announcement;

import java.util.ArrayList;
import java.util.List;

public class RequestActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton imgBtn;
    private EditText budgetField;
    private Spinner emergencyLevelSpinner;
    private EditText title;
    private EditText description;
    private Spinner type;
    private Spinner location;
    private Spinner category;
    private Spinner currency;
    private int emergencyOrService;
    private ImageView image;
    private int contor = 0;
    public Announcement newRequest;


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
        currency = findViewById(R.id.spinner5);

        sItems.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                emergencyOrService = position;
                if(position == 0){
                    budget.setTextColor(Color.GRAY);
                    budgetField.setEnabled(false);
                    currency.setEnabled(false);
                    emergencyLevel.setTextColor(Color.BLACK);
                    emergencyLevelSpinner.setEnabled(true);
                }else{
                    emergencyLevel.setTextColor(Color.GRAY);
                    emergencyLevelSpinner.setEnabled(false);
                    currency.setEnabled(true);
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

        List<String> spinnerArray4 =  new ArrayList<String>();
        spinnerArray4.add("Cluj");
        spinnerArray4.add("Salaj");
        spinnerArray4.add("Bihor");
        spinnerArray4.add("Arad");
        spinnerArray4.add("Timis");

        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray4);

        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems4 = (Spinner) findViewById(R.id.spinner4);
        sItems4.setAdapter(adapter4);

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

        List<String> spinnerArray5 =  new ArrayList<String>();
        spinnerArray5.add("EUR");
        spinnerArray5.add("Lei");
        spinnerArray5.add("$");

        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray5);

        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems5 = (Spinner) findViewById(R.id.spinner5);
        sItems5.setAdapter(adapter5);

        image = findViewById(R.id.imageView2);
        image.setVisibility(View.INVISIBLE);

        imgBtn = (ImageButton) findViewById(R.id.imageButton);

        imgBtn.setOnClickListener(RequestActivity.this);

        Bundle extras = getIntent().getExtras();


        if (extras != null) {

            contor = 1;

        }

    }


    @Override
    public void onResume(){
        super.onResume();
        contor++;
        if(contor  >= 2){
            image.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {

        final AlertDialog alertDialog = new AlertDialog.Builder(this).create(); //Read Update
        alertDialog.setTitle("");
        alertDialog.setMessage("Do you allow this app to access your gallery?");

        alertDialog.setButton("ALLOW", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent k = new Intent(RequestActivity.this, SelectImageActivity.class);
                startActivity(k);
            }
        });

        alertDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_request, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.action_settings) {
            if (validateForm()) {
                Toast toast = Toast.makeText(getApplicationContext(), "Request created successfully!", Toast.LENGTH_SHORT);
                toast.show();
//                Intent k = new Intent(RequestActivity.this, MainScreenActivity.class);
//                k.putExtra("title", title.getText().toString());
//                k.putExtra("description", description.getText().toString());
//                k.putExtra("location", location.getSelectedItem().toString());
//                startActivity(k);
//                newRequest = new Announcement(title.getText().toString(), description.getText().toString(), location.getSelectedItem().toString(),
//                        LocalDateTime.now(), R.drawable.pipes);
                finish();
            }
        }else{
            finish();
        }

        return true;
    }

    private boolean validateForm() {
        boolean ok = true;
        title = findViewById(R.id.editText);
        description = findViewById(R.id.description);

        if (title.getText().toString().trim().length() == 0){
            title.setError("Empty field!");
            ok = false;
        }

        if (description.getText().toString().trim().length() == 0){
            description.setError("Empty field!");
            ok = false;
        }

        if(emergencyOrService == 1 && !budgetField.getText().toString().matches("^\\d*\\.?\\d*$")){
            budgetField.setError("Not a valid number!");
            ok = false;
        }

        return ok;
    }
}
