package com.example.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class LoggedScreen extends AppCompatActivity implements View.OnClickListener {
TextView log;
Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_screen);
        log=findViewById(R.id.tv_loggedname);

        logout=findViewById(R.id.logout);
        logout.setOnClickListener(this);
        Intent LoginIntent =getIntent();
        if(LoginIntent.hasExtra("Username")){
            log.setText("Welcome"+" "+LoginIntent.getStringExtra("Username")+"!");
        }
    }

    @Override
    public void onClick(View v) {
finish();

        }
    }
