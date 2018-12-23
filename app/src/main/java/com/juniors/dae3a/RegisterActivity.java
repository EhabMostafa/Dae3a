package com.juniors.dae3a;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import Controller.UserController;

public class RegisterActivity extends AppCompatActivity {

    EditText FName, LName, Email, Password, PhoneNumber, NationalID;
    Bitmap NationalIDImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        FName=(EditText) findViewById(R.id.FirstName);
        LName=(EditText) findViewById(R.id.LastName);

        Email = (EditText) findViewById(R.id.Email);
        Password = (EditText) findViewById(R.id.Password);
        PhoneNumber = (EditText) findViewById(R.id.PhoneNumber);
        NationalID = (EditText) findViewById(R.id.NationalID);



    }

    public void Submit(View view) throws SQLException {
        UserController c = new UserController();
        String Message = "";
        Message = c.Register(FName.getText().toString() + " " + LName.getText().toString()
                , Email.getText().toString()
                , Password.getText().toString()
                , PhoneNumber.getText().toString()
                , NationalID.getText().toString()
                , NationalIDImage);

        Log.e("ERRO", Message);
        if(Message.equals("Registeration Success")){
            Intent myIntent = new Intent(RegisterActivity.this, UserHomeActivity.class);
            myIntent.putExtra("UserEmail", Email.getText().toString()); //Optional parameters
            RegisterActivity.this.startActivity(myIntent);
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
            builder.setTitle("Error");
            builder.setMessage(Message);
            builder.show();
        }

    }

    public void UploadImage(View view) {
        final CharSequence[] items = {"Take Photo", "Gallery", "Close"};
        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
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
                NationalIDImage = img;
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
                NationalIDImage = img;
            }
        }

    }
}