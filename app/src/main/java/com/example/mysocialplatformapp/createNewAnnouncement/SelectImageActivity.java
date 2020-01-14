package com.example.mysocialplatformapp.createNewAnnouncement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.mysocialplatformapp.R;

public class SelectImageActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_image);

        img = (ImageView) findViewById(R.id.imageView);
        img.setOnClickListener(SelectImageActivity.this);
    }

    @Override
    public void onClick(View v) {

        Intent k = new Intent(SelectImageActivity.this, RequestActivity.class);
        k.putExtra("photo", "yes");
        finish();
    }
}
