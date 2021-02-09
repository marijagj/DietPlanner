package com.example.dietplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText username,password;
Button login,register;
DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=(EditText)findViewById(R.id.username1);
        password=(EditText)findViewById(R.id.pass1);
        login=(Button)findViewById(R.id.logg);
        register=(Button) findViewById(R.id.regg);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
            }
        });

        db = new DBHelper(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();
                String pass=password.getText().toString();
                String name=db.getName(user);
                Float water=db.getWater(user);
                if(user.equals("")|| pass.equals("")) {
                    Toast.makeText(MainActivity.this,"Please enter all the fields",Toast.LENGTH_SHORT).show();
                }
                else
                {Boolean checkuser=db.checkusernamepass(user,pass);
                if(checkuser==true) {Toast.makeText(MainActivity.this,"Login successfully",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
                    intent.putExtra("name",name);
                    intent.putExtra("username",user);
                    intent.putExtra("password",pass);
                    intent.putExtra("water",water);
                    startActivity(intent);
                }
                else{Toast.makeText(MainActivity.this,"Invalid",Toast.LENGTH_SHORT).show();}
                }
            }
        });
    }
}