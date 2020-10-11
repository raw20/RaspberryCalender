package com.example.raspberrycalender;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Gravity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;

public class MonthItemView extends AppCompatTextView {

    private  MonthItem item;

    public MonthItemView(@NonNull Context context) {
        super(context);
        init();
    }

    public MonthItemView(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        setBackgroundColor(Color.WHITE);
    }

    public MonthItem getItem(){
        return item;
    }

    public void setItem(MonthItem item){
        this.item = item;
        HashSet<Date> eventDays;
        Date date = new Date();
        int day = item.getDay();

        if (day != 0) {
            setText(String.valueOf(day));
            setGravity(Gravity.CENTER);
            setTextColor(Color.BLACK);
            setTextSize(20);
            if (day == date.getDate()){
                setText(String.valueOf(date));
                setGravity(Gravity.CENTER);
                setTextColor(Color.GREEN);
                setTextSize(15);
            }
        }
        else{
            setText("");
        }
    }
}
