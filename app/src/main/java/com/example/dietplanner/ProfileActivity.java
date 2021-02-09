package com.example.dietplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {
Intent intent;
String user,pass,name,v;
Float water;
TextView u,username,p,password,n,namee,w,wa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        intent=getIntent();
        user=intent.getStringExtra("user");
        pass=intent.getStringExtra("pass");
        name=intent.getStringExtra("name");
        water=intent.getFloatExtra("water",0);
        v=water.toString();

        u=(TextView) findViewById(R.id.u);
        username=(TextView) findViewById(R.id.user);
        p=(TextView) findViewById(R.id.p);
        password=(TextView) findViewById(R.id.password);
        n=(TextView) findViewById(R.id.n);
        namee=(TextView) findViewById(R.id.namee);
        w=(TextView) findViewById(R.id.w);
        wa=(TextView) findViewById(R.id.wat);
        username.setText(user);
        password.setText(pass);
        namee.setText(name);
        wa.setText(v);


    }
    public void hide(View view) {

        //Toggle
        if (password.getVisibility() == View.VISIBLE)
            password.setVisibility(View.INVISIBLE);
        else
            password.setVisibility(View.VISIBLE);

        //If you want it only one time
        //txtView.setVisibility(View.VISIBLE);

    }

}