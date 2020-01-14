package com.example.mysocialplatformapp.filters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.mysocialplatformapp.R;
import com.example.mysocialplatformapp.fragments.AnnouncementFragment;
import com.example.mysocialplatformapp.main.MainScreenActivity;
import com.example.mysocialplatformapp.reviewUser.UserReviewActivity;

import java.util.ArrayList;
import java.util.List;

public class FilterActivity extends AppCompatActivity {

    private Spinner location_spinner;
    private Spinner price_spinner;
    private Spinner date_spinner;
    private Spinner emergency_spinner;
    private Button resultB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        Integer fragment = getIntent().getIntExtra("fragment", 0);

        location_spinner = findViewById(R.id.location_search_spinner);
        price_spinner = findViewById(R.id.price_spinner);
        emergency_spinner = findViewById(R.id.emergency_spinner);
        date_spinner = findViewById(R.id.date_spinner);
        resultB = findViewById(R.id.result_button);

        if(fragment == 2){
            emergency_spinner.setEnabled(false);
            price_spinner.setEnabled(true);
        }
        else{
            price_spinner.setEnabled(false);
            emergency_spinner.setEnabled(true);
        }
        List<String> spinnerArray4 =  new ArrayList<String>();
        spinnerArray4.add("Cluj");
        spinnerArray4.add("Salaj");
        spinnerArray4.add("Bihor");
        spinnerArray4.add("Arad");
        spinnerArray4.add("Timis");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray4);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        location_spinner.setAdapter(adapter);

        List<String> spinnerArray3 =  new ArrayList<String>();
        spinnerArray3.add("Low to high");
        spinnerArray3.add("High to low");
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray3);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        emergency_spinner.setAdapter(adapter3);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray3);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        price_spinner.setAdapter(adapter2);

        List<String> spinnerArray1 =  new ArrayList<String>();
        spinnerArray1.add("Recent to last");
        spinnerArray1.add("Last to recent");
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray1);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        date_spinner.setAdapter(adapter1);

        final Intent intent = new Intent(this, MainScreenActivity.class);
        resultB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });


    }

//    @Override
//    public void onResume(){
//        super.onResume();
//        Integer fragment = getIntent().getIntExtra("Worked", 0);
//
//        if(fragment == 1){
//            emergency_spinner.setEnabled(false);
//            price_spinner.setEnabled(true);
//        }
//        else{
//            price_spinner.setEnabled(false);
//            emergency_spinner.setEnabled(true);
//        }
//        //will be executed onResume
//    }

}
