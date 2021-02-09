package com.example.dietplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MealActivity extends AppCompatActivity {
TextView datum,day;
String dayOfTheWeek;
RecyclerView recyclerView;
DBHelper databaseHelper;
ArrayList<Meals> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);
        datum=(TextView) findViewById(R.id.date);
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        datum.setText("Date: "+date);
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        Date d = new Date();
        dayOfTheWeek = sdf.format(d);
        day=(TextView) findViewById(R.id.day);
        day.setText(dayOfTheWeek+"'s Meal Plan  ");
        recyclerView = (RecyclerView) findViewById(R.id.list2);
        databaseHelper = new DBHelper(this);
        displayMeals();

    }
    private void displayMeals() {
        arrayList = new ArrayList<>(databaseHelper.getAllMeals(dayOfTheWeek));
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        MyMealAdapter adapter = new MyMealAdapter(getApplicationContext(), this, arrayList);
        recyclerView.setAdapter(adapter);
    }
}