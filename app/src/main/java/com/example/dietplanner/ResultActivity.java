package com.example.dietplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
TextView res;
Intent intent;
String bmi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        res=(TextView) findViewById(R.id.res);
        intent=getIntent();
        bmi=intent.getStringExtra("result");
        res.setText("Your BMI is: "+bmi);

    }
}