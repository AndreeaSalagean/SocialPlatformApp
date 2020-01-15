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
import android.widget.Toast;

import com.example.mysocialplatformapp.R;
import com.example.mysocialplatformapp.bonus.BonusActivity;
import com.example.mysocialplatformapp.main.MainActivity;
import com.example.mysocialplatformapp.main.MainScreenActivity;
import com.example.mysocialplatformapp.model.Announcement;
import com.example.mysocialplatformapp.myProfile.MyProfileActivity;
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
  private Integer colab;

  private Intent myProfileIntent;
  private Intent logOutIntent;
  private Intent bonusIntent;
  private Intent main;

  private String active = MainScreenActivity.fragmentName;

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
    colab = 0;
    title.setText(announcement.getTitle());
    imageView.setImageResource(announcement.getPhoto());
    description.setText(announcement.getDescription());
    location.setText(String.valueOf(announcement.getLocation()));
    date.setText(String.valueOf(announcement.getLocalDateTime()));
    request = (Button) findViewById(R.id.request);
    userPhoto = (ImageView) findViewById(R.id.user_photo);
    userName = (TextView) findViewById(R.id.user_name);

    myProfileIntent = new Intent(this, MyProfileActivity.class);
    main = new Intent(this, MainScreenActivity.class);
    logOutIntent = new Intent(this, MainActivity.class);
    bonusIntent = new Intent(this, BonusActivity.class);
    final Intent intent = new Intent(this, UserReviewActivity.class);
    final Intent intentPayment = new Intent(this, PaymentActivity.class);
    userName.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startActivity(intent);
        intent.putExtra("Worked", worked);
      }
    });
    userPhoto.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startActivity(intent);
        intent.putExtra("Worked", worked);
      }
    });


    request.setOnClickListener(new View.OnClickListener(){
      @Override
      public void onClick(View v) {
        if(active.equals("1")) {
          startActivity(intentPayment);
        }
        else{
          Toast.makeText(getBaseContext(), "You complete a collaboration! Check your bonus points!" , Toast.LENGTH_SHORT ).show();
          request.setEnabled(false);
        }
        worked = worked + 1;
        colab = colab+ 1;
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
        iconSend.setVisibility(View.INVISIBLE);
        editText.setVisibility(View.INVISIBLE);
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

  public void onResume(){
    super.onResume();
    request.setEnabled(false);
    if(colab!=0){
      request.setEnabled(false);
    }
    else{
      request.setEnabled(true);
    }
  }
}