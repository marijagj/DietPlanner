package com.example.dietplanner;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyMealAdapter extends RecyclerView.Adapter<MyMealAdapter.viewHolder> {
    Context context;
    Activity activity;
    List<Meals> arrayList;
    DBHelper db;
    public MyMealAdapter(Context context, Activity activity, List<Meals> arrayList) {
        this.context=context;
        this.activity=activity;
        this.arrayList=arrayList;
    }
    @Override
    public MyMealAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.mealss, parent, false);
        return new MyMealAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyMealAdapter.viewHolder holder, int position) {
        Meals entry=arrayList.get(position);
        holder.name.setText(entry.getName());
        if(entry.getName().equals("Banana pancakes")) holder.photo.setImageResource(R.drawable.banana);
        if(entry.getName().equals("Cranberry and Raspberry smoothie")) holder.photo.setImageResource(R.drawable.smoothie);
        if(entry.getName().equals("Baked salmon and eggs")) holder.photo.setImageResource(R.drawable.salmoneggs);
        if(entry.getName().equals("Avocado and smoked salmon toasts")) holder.photo.setImageResource(R.drawable.avosal);
        if(entry.getName().equals("Baked eggs with spinach")) holder.photo.setImageResource(R.drawable.eggspin);
        if(entry.getName().equals("Ham, mushroom & spinach frittata")) holder.photo.setImageResource(R.drawable.hummush);
        if(entry.getName().equals("Blueberry muffins")) holder.photo.setImageResource(R.drawable.muffins);
        if(entry.getName().equals("Roasted veg & couscous salad")) holder.photo.setImageResource(R.drawable.couscous);
        if(entry.getName().equals("Fresh tuna tortillas")) holder.photo.setImageResource(R.drawable.tuna);
        if(entry.getName().equals("Bulgur & quinoa lunch bowls")) holder.photo.setImageResource(R.drawable.burgur);
        if(entry.getName().equals("Vegetarian sausage rolls")) holder.photo.setImageResource(R.drawable.rolls);
        if(entry.getName().equals("Herby fish fingers with rice")) holder.photo.setImageResource(R.drawable.herbrice);
        if(entry.getName().equals("Vegan chickpea curry jacket potatoes")) holder.photo.setImageResource(R.drawable.peacurry);
        if(entry.getName().equals("Chicken & sweetcorn tacos")) holder.photo.setImageResource(R.drawable.tacos);
        if(entry.getName().equals("Easy chicken curry")) holder.photo.setImageResource(R.drawable.chcurry);
        if(entry.getName().equals("Honey & mustard chicken thighs")) holder.photo.setImageResource(R.drawable.honey);
        if(entry.getName().equals("Vegetarian bolognese")) holder.photo.setImageResource(R.drawable.bolognese);
        if(entry.getName().equals("Spiced chicken & apricot pastilla")) holder.photo.setImageResource(R.drawable.pastills);
        if(entry.getName().equals("Coconut, rum & raisin rice pudding")) holder.photo.setImageResource(R.drawable.puding);
        if(entry.getName().equals("Quinoa-stuffed peppers with roast tomatoes & feta")) holder.photo.setImageResource(R.drawable.peppers);
        if(entry.getName().equals("Broccoli pesto & pancetta pasta")) holder.photo.setImageResource(R.drawable.pasta);
        holder.time.setText("Time : "+entry.getTime());
        holder.calories.setText("Calories : "+entry.getCalories());
        if(position==0)holder.num.setText("Breakfast");
        else if(position==1) holder.num.setText("Lunch");
        else if(position==2) holder.num.setText("Dinner");
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView name,num;
        TextView calories;
        TextView time;
        ImageView photo;
        Button day;
        public viewHolder(View view) {
            super(view);
            photo=(ImageView)  view.findViewById(R.id.mealph);
            num=(TextView) view.findViewById(R.id.nummeal);
            name=(TextView) view.findViewById(R.id.ime);
            calories=(TextView) view.findViewById(R.id.cal);
            time=(TextView) view.findViewById(R.id.vreme);
        }
    }
}
