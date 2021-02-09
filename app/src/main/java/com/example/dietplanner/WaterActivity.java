package com.example.dietplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class WaterActivity extends AppCompatActivity {
DBHelper db;
EditText water;
TextView ml;
Intent intent;
Button vnesi;
String user,name,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);

        db= new DBHelper(this);
        water=(EditText) findViewById(R.id.water);
        ml=(TextView) findViewById(R.id.ml);
        vnesi=(Button) findViewById(R.id.vnesi);
        intent=getIntent();
        user=intent.getStringExtra("user");
        name=intent.getStringExtra("name");
        pass=intent.getStringExtra("pass");

        vnesi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String w=water.getText().toString();
                float ww=Float.parseFloat(w);
                Float prevwater=db.getWater(user);
                Float vnesw=ww+prevwater;
                Boolean vnesii=db.insertWater(vnesw,user);
                if(vnesii==true){
                    Float voda=db.getWater(user);
                    Intent intent=new Intent(getApplicationContext(),WaterInsActivity.class);
                    intent.putExtra("water",voda);
                    intent.putExtra("user",user);
                    intent.putExtra("name",name);
                    intent.putExtra("pass",pass);
                    intent.putExtra("voda",w);
                    startActivity(intent);
                }
            }
        });
    }
}