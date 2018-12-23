package com.juniors.dae3a;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.sql.SQLException;

import Controller.PersonController;
import Controller.UserController;
import DAOS.*;




public class MainActivity extends AppCompatActivity {


    EditText Email, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Email = (EditText) findViewById(R.id.userName);
        Password = (EditText) findViewById(R.id.password);

    }

    public void login(View view) throws SQLException {
        PersonController PC=new PersonController();

        String Message=PC.Login(Email.getText().toString(),Password.getText().toString());

        if(Message.equals("Login succefully")){
            Intent myIntent = new Intent(MainActivity.this, UserHomeActivity.class);
            myIntent.putExtra("UserEmail", Email.getText().toString()); //Optional parameters
            MainActivity.this.startActivity(myIntent);
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Error");
            builder.setMessage(Message);
            builder.show();
        }

        Log.e("ERRO", Message);
    }

    public void Register(View view) {
        Intent myIntent = new Intent(MainActivity.this, RegisterActivity.class);
        //myIntent.putExtra("key", value); //Optional parameters
        MainActivity.this.startActivity(myIntent);
    }





}
