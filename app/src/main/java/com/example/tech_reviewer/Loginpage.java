package com.example.tech_reviewer;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class Loginpage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("black"));
        actionBar.setBackgroundDrawable(colorDrawable);
        TextView username =(TextView) findViewById(R.id.username);
        TextView password =(TextView) findViewById(R.id.password);

        Button loginbtn = (Button) findViewById(R.id.loginbtn);

        //admin and admin

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                    //correct
                    Toast.makeText(Loginpage.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Loginpage.this,Homepage.class);
                    startActivity(intent);


                }else
                    //incorrect
                    Toast.makeText(Loginpage.this,"LOGIN FAILED !!!",Toast.LENGTH_SHORT).show();
            }
        });


    }
    }

