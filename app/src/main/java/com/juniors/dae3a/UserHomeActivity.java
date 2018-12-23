package com.juniors.dae3a;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class UserHomeActivity extends AppCompatActivity {

    private String UserEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        Intent intent = getIntent();
        UserEmail=intent.getStringExtra("UserEmail");
    }


    public void AddPost(View view) {
        Intent myIntent = new Intent(UserHomeActivity.this, addPostActivity.class);
        myIntent.putExtra("UserEmail",UserEmail); //Optional parameters
        UserHomeActivity.this.startActivity(myIntent);
    }

    public void Search(View view) {
        Intent myIntent = new Intent(UserHomeActivity.this, categoryActivity.class);
        myIntent.putExtra("UserEmail",UserEmail); //Optional parameters
        UserHomeActivity.this.startActivity(myIntent);
    }
}
