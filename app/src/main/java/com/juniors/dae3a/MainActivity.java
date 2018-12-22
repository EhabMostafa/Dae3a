package com.juniors.dae3a;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.sql.SQLException;

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
}
