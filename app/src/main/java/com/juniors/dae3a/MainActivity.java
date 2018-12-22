package com.juniors.dae3a;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.sql.SQLException;

import Controller.UserController;
import DAOS.*;




public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserDAO userDAO=new UserDAO();
        try {
            userDAO.test();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void login(View view) {
        UserController c=new UserController();
        c.Register("beass","ehab","123","01000","2662626",null);
    }
}
