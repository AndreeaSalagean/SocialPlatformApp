package com.example.mysocialplatformapp.main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mysocialplatformapp.announcementDetails.AnnouncementDetailActivity;
import com.example.mysocialplatformapp.R;
import com.example.mysocialplatformapp.adapter.MyAdapter;
import com.example.mysocialplatformapp.createNewAnnouncement.RequestActivity;
import com.example.mysocialplatformapp.filters.FilterActivity;
import com.example.mysocialplatformapp.fragments.AnnouncementFragment;
import com.example.mysocialplatformapp.fragments.ServiceFragment;
import com.example.mysocialplatformapp.login.LoginActivity;
import com.example.mysocialplatformapp.model.Announcement;
import com.example.mysocialplatformapp.reviewUser.UserReviewActivity;
import com.example.mysocialplatformapp.reviewUser.UserReviewActivity;
import com.example.mysocialplatformapp.myProfile.MyProfileActivity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MainScreenActivity extends AppCompatActivity {

    private TextView serviceTab;
    private TextView announcementTab;
    private final Fragment fragment1 = new ServiceFragment();
    private final Fragment fragment2 = new AnnouncementFragment();
    private final FragmentManager fm = getSupportFragmentManager();
    private Fragment active = fragment1;
    private Button filterButton;
    private Intent myProfileIntent;
    private Intent logOutIntent;
    private Button filterButton;


    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        final Intent filterIntent =new Intent(this, FilterActivity.class);

        myProfileIntent = new Intent(this, MyProfileActivity.class);
        logOutIntent = new Intent(this, MainActivity.class);
        final Intent filterIntent =new Intent(this, FilterActivity.class);

        serviceTab = findViewById(R.id.serviceTab);
        announcementTab = findViewById(R.id.announcementTab);
        initializeFragments();
        selectFragments();

        filterButton  = findViewById(R.id.filters);
        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(filterIntent);
                if (active.equals(fragment1)){
                    filterIntent.putExtra("fragment", 1);
                     Toast.makeText(getBaseContext(), "Your answer is correct!" , Toast.LENGTH_SHORT ).show();  }
                else {
                    filterIntent.putExtra("fragment", 2);
                    Toast.makeText(getBaseContext(), "Your answer is fragm 2!" , Toast.LENGTH_SHORT ).show();
                }

            }
        });

    }

    private void initializeFragments() {
        fm.beginTransaction().add(R.id.child_container, fragment2, "2").hide(fragment2).commit();
        fm.beginTransaction().add(R.id.child_container, fragment1, "1").commit();
    }

    private void selectFragments() {
        serviceTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm.beginTransaction().hide(active).show(fragment1).commit();
                active = fragment1;
            }
        });

        announcementTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm.beginTransaction().hide(active).show(fragment2).commit();
                active = fragment2;
            }
        });
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

        } else if (id == R.id.logout) {
            logOutIntent.putExtra("logout","please logout");
            startActivity(logOutIntent);
            finish();
        } else if (id == R.id.home) {
        } else if (id == R.id.notification) {
        } else if (id == R.id.message) {
        }
        return super.onOptionsItemSelected(item);
    }
}