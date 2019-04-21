package com.example.login;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
EditText username,password;
Button log;
TextView count;
String user;
int counter= 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.et_username);
        password=findViewById(R.id.et_password);
        log=findViewById(R.id.btn_login);
        count=findViewById(R.id.tv_count);
        count.setVisibility(View.GONE);

        log.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(username.getText().toString().equals("admin") &&
        password.getText().toString().equals("admin")){
            Toast.makeText(getApplicationContext(), "Redirecting", Toast.LENGTH_SHORT).show();
            Intent loginIntent=new Intent(MainActivity.this,LoggedScreen.class);
            user=username.getText().toString();
            loginIntent.putExtra("Username",user);
            loginIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(loginIntent);
            finish();

        }
        else{
            Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
            count.setVisibility(View.VISIBLE);
            count.setBackgroundColor(Color.RED);
            counter--;
            count.setText(Integer.toString(counter));
            if(counter==0){
                log.setEnabled(false);
            }

        }
    }
}
