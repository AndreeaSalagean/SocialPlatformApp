package com.example.mysocialplatformapp.bonus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mysocialplatformapp.R;
import com.example.mysocialplatformapp.main.MainActivity;
import com.example.mysocialplatformapp.main.MainScreenActivity;
import com.example.mysocialplatformapp.myProfile.MyProfileActivity;

public class BonusActivity extends AppCompatActivity {

    private Intent myProfileIntent;
    private Intent logOutIntent;
    private Intent bonusIntent;
    private Intent main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonus);

        myProfileIntent = new Intent(this, MyProfileActivity.class);
        logOutIntent = new Intent(this, MainActivity.class);
        bonusIntent = new Intent(this, BonusActivity.class);
        main = new Intent(this, MainScreenActivity.class);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.myProfile) {
            startActivity(myProfileIntent);
        } else if (id == R.id.myBonusPoints) {
            startActivity(bonusIntent);
            finish();

        } else if (id == R.id.logout) {
            logOutIntent.putExtra("logout","please logout");
            startActivity(logOutIntent);
            finish();
        } else if (id == R.id.home) {
            startActivity(main);
            finish();
        } else if (id == R.id.notification) {
        } else if (id == R.id.message) {
        }
        return super.onOptionsItemSelected(item);
    }
}
