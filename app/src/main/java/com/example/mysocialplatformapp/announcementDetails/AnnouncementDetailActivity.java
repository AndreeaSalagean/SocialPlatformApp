package com.example.mysocialplatformapp.announcementDetails;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mysocialplatformapp.R;
import com.example.mysocialplatformapp.main.MainActivity;
import com.example.mysocialplatformapp.model.Announcement;
import com.example.mysocialplatformapp.payment.PaymentActivity;
import com.example.mysocialplatformapp.reviewUser.UserReviewActivity;

public class AnnouncementDetailActivity extends AppCompatActivity {
  private TextView title;
  private ImageView imageView;
  private TextView description;
  private TextView location;
  private TextView date;
  private ImageView userPhoto;
  private TextView userName;
  private Button request;
  private Button contact;
  private EditText editText;
  private ImageView iconSend;
  private Integer worked ;
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
    worked = 0;
    title.setText(announcement.getTitle());
    imageView.setImageResource(announcement.getPhoto());
    description.setText(announcement.getDescription());
    location.setText(String.valueOf(announcement.getLocation()));
    date.setText(String.valueOf(announcement.getLocalDateTime()));

    userPhoto = (ImageView)findViewById(R.id.user_photo);
    userName = (TextView)findViewById(R.id.user_name);



    final Intent intent = new Intent(this, UserReviewActivity.class);
    final Intent intentPayment = new Intent(this, PaymentActivity.class);
    userName.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startActivity(intent);
        intent.putExtra("Worked",worked);
      }
    });
    userPhoto.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startActivity(intent);
        intent.putExtra("Worked",worked);
      }
    });


    request = (Button)findViewById(R.id.request);
    request.setOnClickListener(new View.OnClickListener(){
      @Override
      public void onClick(View v) {
        startActivity(intentPayment);
        worked = worked + 1;
      }
    });

    contact= (Button)findViewById(R.id.contact);
    iconSend = (ImageView)findViewById(R.id.send_icon);
    editText = (EditText)findViewById(R.id.message_box);
    contact.setOnClickListener(new View.OnClickListener(){
      @Override
      public void onClick(View v) {
        editText.setVisibility(View.VISIBLE);
        iconSend.setVisibility(View.VISIBLE);
      }
    });

   iconSend.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
        startActivity(getIntent());
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
    if (id == R.id.account) {
    } else if (id == R.id.home) {
    } else if (id == R.id.notification) {
    } else if (id == R.id.message) {
    }
    return super.onOptionsItemSelected(item);
  }

}