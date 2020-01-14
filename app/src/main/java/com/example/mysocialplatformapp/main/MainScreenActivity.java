package com.example.mysocialplatformapp.main;

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
import android.widget.ListView;

import com.example.mysocialplatformapp.announcementDetails.AnnouncementDetailActivity;
import com.example.mysocialplatformapp.R;
import com.example.mysocialplatformapp.adapter.MyAdapter;
import com.example.mysocialplatformapp.createNewAnnouncement.RequestActivity;
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
                Intent k = new Intent(MainScreenActivity.this, RequestActivity.class);
                startActivity(k);
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

    @Override
    protected void onResume() {
        super.onResume();
        Announcement announcement = (Announcement) getIntent().getSerializableExtra("announcementCreated");
        if(announcement!=null){
            listAdapter.insert(announcement,listAdapter.getCount());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void addAnnouncements() {
        for (int i = 0; i < 10; i++) {
            announcements.add(new Announcement("Reparation services " + i, "Repair shop auto body shop durango repair service diagnostics repair download number: - Daily updated free icons and png images for your projects. All images use to free for personal projects. " + i,
                    "Cluj Napoca", LocalDateTime.now(), R.drawable.repair));
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