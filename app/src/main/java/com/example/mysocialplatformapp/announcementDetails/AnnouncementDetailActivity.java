package com.example.mysocialplatformapp.announcementDetails;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mysocialplatformapp.R;
import com.example.mysocialplatformapp.model.Announcement;

public class AnnouncementDetailActivity extends AppCompatActivity {
  private TextView title;
  private ImageView imageView;
  private TextView description;
  private TextView location;
  private TextView date;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_announcement_details);

    Announcement announcement = (Announcement) getIntent().getSerializableExtra("announcement");

    title = findViewById(R.id.title_id);
    imageView = findViewById(R.id.image_id);
    description = findViewById(R.id.description_id);
    location = findViewById(R.id.location_id);
    date = findViewById(R.id.date_id);

    title.setText(announcement.getTitle());
    imageView.setImageResource(announcement.getPhoto());
    description.setText(announcement.getDescription());
    location.setText(String.valueOf(announcement.getLocation()));
    date.setText(String.valueOf(announcement.getLocalDateTime()));
  }
}