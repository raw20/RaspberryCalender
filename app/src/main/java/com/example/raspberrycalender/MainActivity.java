package com.example.raspberrycalender;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    GridView monthView;
    TextView monthText;
    MonthAdapter adapter;
    SimpleDateFormat format = new SimpleDateFormat("yyyy/M/d");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        monthView = findViewById(R.id.monthView); //그리드뷰 객체 참조
        adapter = new MonthAdapter(this); //어댑터 객체 생성
        monthView.setAdapter(adapter); //그리드뷰에 어댑터 설정

        monthText = findViewById(R.id.monthText);
        setMonthText();
        Date date = new Date();
        String time = format.format(date);
        monthText.setText(time);
        Button monthPrevious = findViewById(R.id.monthPrevious);
        Button monthNext = findViewById(R.id.monthNext);

        monthPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.setPreviousMonth();
                adapter.notifyDataSetChanged(); //어댑터 데이터 갱신하고 뷰 다시 뿌리기
                setMonthText();
            }
        });
        monthNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.setNextMonth();
                adapter.notifyDataSetChanged(); //어댑터 데이터 갱신하고 뷰 다시 뿌리기
                setMonthText();
            }
        });
    }
    public void setMonthText() {
        int curYear = adapter.getCurYear();
        int curMonth = adapter.getCurMonth();
        monthText.setText(curYear + "년 " + (curMonth + 1) + "월");
    }
}
