package com.example.mysocialplatformapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mysocialplatformapp.adapter.MyAdapter;
import com.example.mysocialplatformapp.model.Announcement;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MainScreenActivity extends AppCompatActivity {
    private ListView listView;
    private MyAdapter listAdapter;
    private ImageButton addButton;
    private final List<Announcement> announcements = new ArrayList<>();

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        listView = findViewById(R.id.announcement_list);
        addButton = findViewById(R.id.add_button);
        addButton.setImageResource(R.drawable.ic_add);
        addAnnouncements();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),R.string.app_name,Toast.LENGTH_SHORT).show();
            }
        });

        listAdapter = new MyAdapter(this, announcements);
        listView.setAdapter(listAdapter);
        listAdapter.notifyDataSetChanged();
        registerForContextMenu(listView);

        listView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentDetails = new Intent(parent.getContext(), AnnouncementDetailActivity.class);
                Announcement announcement = (Announcement) parent.getItemAtPosition(position);
                intentDetails.putExtra("announcement", announcement);
                startActivity(intentDetails);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void addAnnouncements() {
        for (int i = 0; i < 10; i++) {
            announcements.add(new Announcement("Reparation services " + i, "Repair shop auto body shop durango repair service diagnostics repair download number: - Daily updated free icons and png images for your projects. All images use to free for personal projects. " + i,
                    "Cluj Napoca",LocalDateTime.now(),R.drawable.repair));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.account) {
        } else if (id == R.id.home) {
        } else if (id == R.id.notification) {
        } else if (id == R.id.message) {
        }
        return super.onOptionsItemSelected(item);
    }
}