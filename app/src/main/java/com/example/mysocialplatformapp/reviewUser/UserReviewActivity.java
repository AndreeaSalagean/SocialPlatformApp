package com.example.mysocialplatformapp.reviewUser;

import android.annotation.SuppressLint;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mysocialplatformapp.R;

public class UserReviewActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private Button comment;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_review);
        comment = findViewById(R.id.leave_comment_button);
        ratingBar = findViewById(R.id.big_rating_bar);
        Integer worked = getIntent().getIntExtra("Worked", 0);
        if (worked > 0){
            comment.setVisibility(View.VISIBLE);
        }
        ratingBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    AlertDialog alertDialog = new AlertDialog.Builder(UserReviewActivity.this).create(); //Read Update
                    alertDialog.setTitle("Error");
                    alertDialog.setMessage("You cannot rate a user before you have worked with him!");
                    alertDialog.show();
                }
                return true;
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
