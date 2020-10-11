package com.example.raspberrycalender;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import java.util.Calendar;

public class MonthAdapter extends BaseAdapter {
    Calendar calendar;
    Context mContext;

    MonthItem[] items;
    int curYear;
    int curMonth;

    MonthAdapter(Context context){
        super();
        mContext = context;
        init();
    }

    MonthAdapter(Context context, AttributeSet attributeSet){
        super();
        mContext = context;
        init();
    }

    public void init() {
        calendar = Calendar.getInstance(); // 캘린더 객체를 가져온다
        items = new MonthItem[7*6]; // 달력 크기 설정
        calculate(); //날짜 계산해서 달력 배열 값 설정
    }

    public void calculate() {
        for (int i = 0; i < items.length; i++){
            items[i] = new MonthItem(0);
        }
        calendar.set(Calendar.DAY_OF_MONTH, 1); //1일로 설정

        int startDay = calendar.get(Calendar.DAY_OF_WEEK);
        int lastDay = calendar.getActualMaximum(Calendar.DATE);

        int cnt =1; //초기값
        for (int i = startDay-1; i < startDay-1 + lastDay; i++ ){
            items[i] = new MonthItem(cnt);
            cnt++;
        }
        curYear = calendar.get(Calendar.YEAR);
        curMonth = calendar.get(Calendar.MONTH);

    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MonthItemView view = new MonthItemView(mContext);
        MonthItem item = items[position];
        view.setItem(item);
        Integer today = calendar.get(Calendar.DAY_OF_MONTH);
        String sToday = String.valueOf(today);
        if(position %7 ==0){
            view.setTextColor(Color.RED);
        }
       else if(position %7 ==6){
            view.setTextColor(Color.BLUE);
        }

        GridView.LayoutParams params = new GridView.LayoutParams (GridView.LayoutParams.MATCH_PARENT, 150);
        view.setLayoutParams(params);

        return view;
    }
    public int getCurYear(){
        return curYear;
    }

    public int getCurMonth(){
        return curMonth;
    }

    public void setPreviousMonth() {
        calendar.add(Calendar.MONTH, -1);
        calculate();
    }

    public void setNextMonth(){
        calendar.add(Calendar.MONTH, 1); //한 달 뒤로가고 다시 계산
        calculate();
    }
}
