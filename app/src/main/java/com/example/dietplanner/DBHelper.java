package com.example.dietplanner;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;

import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    public static final String name = "base";

    public DBHelper(Context context) {
        super(context, "base", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(username TEXT primary key,password TEXT,name TEXT,water FLOAT)");
        db.execSQL("create table meals(id INTEGER primary key,name TEXT,calories TEXT,time TEXT,day TEXT)");
        ContentValues cv = new ContentValues();
        db.execSQL("insert into meals(name,calories,time,day)" + "VALUES" + "('Banana pancakes','243kcal','10 min','Monday')");
        db.execSQL("insert into meals(name,calories,time,day)" + "VALUES" + "('Cranberry and Raspberry smoothie','100kcal','17 min','Tuesday')");
        db.execSQL("insert into meals(name,calories,time,day)" + "VALUES" + "('Baked salmon and eggs','238kcal','15 min','Wednesday')");
        db.execSQL("insert into meals(name,calories,time,day)" + "VALUES" + "('Avocado and smoked salmon toasts','274kcal','15 min','Thursday')");
        db.execSQL("insert into meals(name,calories,time,day)" + "VALUES" + "('Baked eggs with spinach','131kcal','45 min','Friday')");
        db.execSQL("insert into meals(name,calories,time,day)" + "VALUES" + "('Ham, mushroom & spinach frittata','226kcal','13 min','Saturday')");
        db.execSQL("insert into meals(name,calories,time,day)" + "VALUES" + "('Blueberry muffins','206kcal','50 min','Sunday')");
        db.execSQL("insert into meals(name,calories,time,day)" + "VALUES" + "('Roasted veg & couscous salad','399kcal','50 min','Monday')");
        db.execSQL("insert into meals(name,calories,time,day)" + "VALUES" + "('Fresh tuna tortillas','405kcal','15 min','Tuesday')");
        db.execSQL("insert into meals(name,calories,time,day)" + "VALUES" + "('Bulgur & quinoa lunch bowls','368kcal','20 min','Wednesday')");
        db.execSQL("insert into meals(name,calories,time,day)" + "VALUES" + "('Vegetarian sausage rolls','335kcal','70 min','Thursday')");
        db.execSQL("insert into meals(name,calories,time,day)" + "VALUES" + "('Herby fish fingers with rice','487kcal','45 min','Friday')");
        db.execSQL("insert into meals(name,calories,time,day)" + "VALUES" + "('Vegan chickpea curry jacket potatoes','376kcal','55 min','Saturday')");
        db.execSQL("insert into meals(name,calories,time,day)" + "VALUES" + "('Chicken & sweetcorn tacos','382kcal','60 min','Sunday')");
        db.execSQL("insert into meals(name,calories,time,day)" + "VALUES" + "('Easy chicken curry','354kcal','50 min','Monday')");
        db.execSQL("insert into meals(name,calories,time,day)" + "VALUES" + "('Honey & mustard chicken thighs','475kcal','50 min','Tuesday')");
        db.execSQL("insert into meals(name,calories,time,day)" + "VALUES" + "('Vegetarian bolognese','451kcal','70 min','Wednesday')");
        db.execSQL("insert into meals(name,calories,time,day)" + "VALUES" + "('Spiced chicken & apricot pastilla','384kcal','90 min','Thursday')");
        db.execSQL("insert into meals(name,calories,time,day)" + "VALUES" + "('Coconut, rum & raisin rice pudding','457kcal','45 min','Friday')");
        db.execSQL("insert into meals(name,calories,time,day)" + "VALUES" + "('Quinoa-stuffed peppers with roast tomatoes & feta','462kcal','30 min','Saturday')");
        db.execSQL("insert into meals(name,calories,time,day)" + "VALUES" + "('Broccoli pesto & pancetta pasta','452kcal','25 min','Sunday')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users");
        db.execSQL("drop table if exists meals");

    }

    public boolean insertData(String username, String password, String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("password", password);
        cv.put("name", name);
        long result = db.insert("users", null, cv);
        if (result == -1) return false;
        else
            return true;
    }

    public boolean checkuser(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where username=?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public boolean checkusernamepass(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where username=? and password=?", new String[]{username, password});
        if (cursor.getCount() > 0) return true;
        else return false;
    }

    public String getName(String username) {
        String total;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where username=?", new String[]{username});
        if (cursor.moveToFirst()) {
            total = cursor.getString(2);
            cursor.close();
            return total;
        } else {
            return null;
        }
    }
    public Float getWater(String username) {
        float total;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where username=?", new String[]{username});
        if (cursor.moveToFirst()) {
            total = cursor.getFloat(3);
            cursor.close();
            return total;
        } else {
            return null;
        }
    }

    public List<Meals> getAllMeals(String den) {
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            onCreate(db);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Meals> returnList = new ArrayList<>();

        String query = "SELECT * FROM meals WHERE day =?";

        Cursor cursor = db.rawQuery(query, new String[]{den});

        while (cursor.moveToNext()) {
            int mealId = cursor.getInt(0);
            String mealName = cursor.getString(1);
            String calories = cursor.getString(2);
            String day = cursor.getString(4);
            String time = cursor.getString(3);
            Meals meals =
                    new Meals(mealId, mealName, calories, time, day);
            returnList.add(meals);
        }
        cursor.close();
        db.close();

        return returnList;
    }

    public boolean insertWater(Float water,String user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv= new ContentValues();
            cv.put("water", water);
            long result = db.update("users",cv, "username=?",new String[]{user});
            if (result == -1) return false;
            else
                return true;
        }
}
