package com.example.dietplanner;

public class Meals {
    private int id;
    private String name;
    private String calories;
    private String time;
    private String day;
    public Meals(int id,String name,String calories,String time,String day)
    {
        this.id=id;
        this.name=name;
        this.calories=calories;
        this.time=time;
        this.day=day;
    }
    public int getId () {
        return id;
    }
    public void setId ( int id){
        this.id = id;
    }
    public String getName () {
        return name;
    }
    public void setName ( String name){
        this.name = name;
    }
    public String getCalories () {
        return calories;
    }
    public void setCalories ( String calories){
        this.calories = calories;
    }
    public String getTime () {
        return time;
    }
    public void setTime ( String time){
        this.time = time;
    }
    public String getDay () {
        return day;
    }
    public void setDay ( String day){
        this.day = day;
    }
}
