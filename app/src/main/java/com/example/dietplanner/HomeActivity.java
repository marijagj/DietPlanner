package com.example.dietplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class HomeActivity extends AppCompatActivity {
 TextView welcome;
 Intent intent;
 String name,user,pass;
 Float w;
 String dayOfYear;
    Button meal,bmi,profile,water;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        welcome=(TextView) findViewById(R.id.welcome);
        intent=getIntent();
        name=intent.getStringExtra("name");
        user=intent.getStringExtra("username");
        pass=intent.getStringExtra("password");
        w=intent.getFloatExtra("water",0);
        welcome.setText("Welcome "+name);
        meal=(Button) findViewById(R.id.meal);
        bmi=(Button) findViewById(R.id.bmi);
        profile=(Button) findViewById(R.id.prof);
        water=(Button) findViewById(R.id.water);
        meal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent intent=new Intent(getApplicationContext(),MealActivity.class);
             startActivity(intent);
            }
        });
        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getApplicationContext(),BMIActivity.class);
                startActivity(intent1);
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent2=new Intent(getApplicationContext(),ProfileActivity.class);
            intent2.putExtra("user",user);
            intent2.putExtra("pass",pass);
            intent2.putExtra("name",name);
            intent2.putExtra("water",w);
            startActivity(intent2);
            }
        });
        water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(),WaterActivity.class);
                intent3.putExtra("user",user);
                intent3.putExtra("pass",pass);
                intent3.putExtra("name",name);
                startActivity(intent3);
            }
        });




    }
}