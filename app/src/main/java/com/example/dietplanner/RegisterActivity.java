package com.example.dietplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText user,pass,repass,name;
    Button register;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        user=(EditText) findViewById(R.id.username);
        pass=(EditText) findViewById(R.id.pass);
        repass=(EditText) findViewById(R.id.repass);
        name=(EditText) findViewById(R.id.name);
        register=(Button) findViewById(R.id.re);
        db=new DBHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userr=user.getText().toString();
                String pas=pass.getText().toString();
                String rep=repass.getText().toString();
                String n=name.getText().toString();
                if(userr.equals("") || pas.equals("")|| rep.equals("")|| n.equals(""))
                    Toast.makeText(RegisterActivity.this,"Please enter all fields",Toast.LENGTH_SHORT).show();
                else{
                    if(pas.equals(rep)){
                        Boolean checkuser=db.checkuser(userr);
                        if(checkuser==false) {
                            Boolean insert=db.insertData(userr,pas,n);
                            if(insert==true) {
                                Toast.makeText(RegisterActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
                                intent.putExtra("name",n);
                                intent.putExtra("username",userr);
                                intent.putExtra("password",pas);
                                startActivity(intent);
                            } else
                            {Toast.makeText(RegisterActivity.this,"Registration failed",Toast.LENGTH_SHORT).show();}
                        }
                        else {Toast.makeText(RegisterActivity.this,"User already exist",Toast.LENGTH_SHORT).show();}
                    }
                    else {Toast.makeText(RegisterActivity.this,"Passwords not matching",Toast.LENGTH_SHORT).show();}
                }

            }
        });
    }
}