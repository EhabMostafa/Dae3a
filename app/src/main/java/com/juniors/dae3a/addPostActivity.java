package com.juniors.dae3a;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Controller.MatchController;
import Controller.PostController;
import Models.MatchModel;

public class addPostActivity extends AppCompatActivity {

    private String UserEmail;
    EditText Title, Description,Address,Additional,FoundDate;
    Bitmap PostImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);

        Intent intent = getIntent();
        UserEmail=intent.getStringExtra("UserEmail");

        Title = (EditText) findViewById(R.id.title);
        Description = (EditText) findViewById(R.id.description);

        Address = (EditText) findViewById(R.id.address);
        Additional = (EditText) findViewById(R.id.additional);
        FoundDate = (EditText) findViewById(R.id.founded_date);


    }


    public void Post(View view) throws SQLException, ParseException {
        PostController PoC=new PostController();
        int PostID=PoC.addPost(PostImage,Title.getText().toString(),Description.getText().toString(),UserEmail);
        Log.e("err",Integer.toString(PostID));

        MatchController MC=new MatchController();


        String data= FoundDate.getText().toString();
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date date = format.parse(data);


        String Message=MC.addMatch(Additional.getText().toString(),Address.getText().toString(),date,PostID);
        Log.e("err",Message);
        Intent myIntent = new Intent(addPostActivity.this, UserHomeActivity.class);
        myIntent.putExtra("UserEmail", UserEmail); //Optional parameters
        addPostActivity.this.startActivity(myIntent);


    }


    public void UploadPostImage(View view) {
        final CharSequence[] items = {"Take Photo", "Gallery", "Close"};
        AlertDialog.Builder builder = new AlertDialog.Builder(addPostActivity.this);
        builder.setTitle("Add photo");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {

                //boolean result=Utility.checkPermissions(MainActivity.this);

                if (items[item].equals("Take Photo")) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, 1888);
                } else if (items[item].equals("Gallery")) {
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(intent.createChooser(intent, "Select File"), 1889);
                }
            }
        });
        builder.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 1888) {
                Bitmap img = (Bitmap) data.getExtras().get("data");
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                img.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
                PostImage = img;
            }
            if (requestCode == 1889) {
                Bitmap img = null;
                if (data != null) {
                    try {
                        img = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                PostImage = img;
            }
        }

    }




}
