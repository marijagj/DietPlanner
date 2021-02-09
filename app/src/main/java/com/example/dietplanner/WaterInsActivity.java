package com.example.dietplanner;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WaterInsActivity extends AppCompatActivity {
    Button b;
    Float voda;
    Intent intent;
    TextView v;
    String name,user,pass,water;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_ins);
        b=(Button) findViewById(R.id.b);
        intent=getIntent();
        v=(TextView)findViewById(R.id.vodaa);
        name=intent.getStringExtra("name");
        voda=intent.getFloatExtra("water",0);
        pass=intent.getStringExtra("pass");
        user=intent.getStringExtra("user");
        water=intent.getStringExtra("voda");
        v.setText(water);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ProfileActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("water",voda);
                intent.putExtra("pass",pass);
                intent.putExtra("user",user);
                startActivity(intent);
            }
        });
    }
}

