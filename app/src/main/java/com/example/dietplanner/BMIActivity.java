package com.example.dietplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BMIActivity extends AppCompatActivity {
EditText weight,height;
String wee,hii;
Float hi,we;
double bmi;
Button cal;
double centi;
String B;
TextView textView,w,kg,h,m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_i);
        weight=(EditText) findViewById(R.id.w);
        height=(EditText) findViewById(R.id.h);
        textView=(TextView) findViewById(R.id.text);
        w=(TextView) findViewById(R.id.ww) ;
        kg=(TextView) findViewById(R.id.kg) ;
        h=(TextView) findViewById(R.id.hh) ;
        m=(TextView) findViewById(R.id.m) ;

        cal=(Button) findViewById(R.id.bu);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wee=weight.getText().toString();
                hii=height.getText().toString();
                if(wee.equals("")|| hii.equals(""))
                {Toast.makeText(BMIActivity.this,"Please enter all the fields",Toast.LENGTH_SHORT).show();}
                /*Toast.makeText(BMIActivity.this,"Your BMI index is : " +B,Toast.LENGTH_SHORT).show();*/
                else{
                    we=Float.parseFloat(wee);
                    hi=Float.parseFloat(hii);
                    centi=hi/100.0;
                    bmi=we/(centi*centi);
                    B=String.format("%.2f",bmi);
                Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
                intent.putExtra("result",B);
                startActivity(intent);}
            }
        });


    }

}