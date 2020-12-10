package com.example.raspberrycalender;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class MainActivity extends Activity{
    EditText planEdit;
    NotificationManager notificationManager;
    AlarmManager alarmManager;
    TextView monthText, planText, timeText, dateText;
    int mYear, mMonth, mDay, mHour, mMinute;
    Button alarmButton;
    Calendar calendar;
    ArrayList <String> items;
    ArrayAdapter <String> adapter;
    ListView listView;
    SharedPreferences sharedPreferences;
    SimpleDateFormat format = new SimpleDateFormat("yyyy/M/d");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 그리드뷰 객체 참조
        planEdit = findViewById(R.id.planEdit);
        monthText = findViewById(R.id.monthText);
        planText = findViewById(R.id.palnText);
        timeText = findViewById(R.id.timeText);
        dateText = findViewById(R.id.dateText);
        alarmButton = findViewById(R.id.alarmButton);
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_single_choice, items);
        listView = (ListView) findViewById(R.id.listView);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        sharedPreferences = getSharedPreferences("sp",MODE_PRIVATE);
        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        final String plan = sharedPreferences.getString("plan","");
        final String hour = sharedPreferences.getString("hour","");
        final String day = sharedPreferences.getString("day", "");
        planText.setText(plan); // 입력한 일정을 어플 재시작시에도 출력이 되게 저장
        timeText.setText(hour);
        dateText.setText(day);
        notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        calendar = Calendar.getInstance();
        mYear = calendar.get(calendar.YEAR);
        mMonth = calendar.get(calendar.MONTH);
        mDay = calendar.get(calendar.DAY_OF_MONTH);
        mHour = calendar.get(calendar.HOUR_OF_DAY);
        mMinute = calendar.get(calendar.MINUTE);
        Date date = new Date();
        String time = format.format(date);
        monthText.setText(time);
        alarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = planEdit.getText().toString(); // 공백방지
                if(text.getBytes().length <= 0){
                    Toast.makeText(MainActivity.this,"일정을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    planText.setText(planEdit.getText()); // 입력한 일정 출력
                }
                GregorianCalendar calendar = new GregorianCalendar(Locale.KOREA);
                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, mDateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)); // 날짜선택
                dialog.show();
            }
        });
    }

    DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) { //사용자가 입력한 값을 가져온뒤
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth; //텍스트뷰의 값을 업데이트함
            UpdateNow(); // 선택한 날짜를 텍스트로 출력

            GregorianCalendar calendar= new GregorianCalendar(Locale.KOREA);
            TimePickerDialog dialog= new TimePickerDialog(MainActivity.this,mTimeSetListener,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),true); // 시간선택
            dialog.show();
        }
    };
   TimePickerDialog.OnTimeSetListener mTimeSetListener  = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) { //사용자가 입력한 값을 가져온뒤
            mHour = hourOfDay;
            mMinute = minute; //텍스트뷰의 값을 업데이트함
            UpdateNow(); // 선택한 시간을 텍스트로 출력
            GregorianCalendar calendar = new GregorianCalendar(mYear, mMonth, mDay, mHour, mMinute);
            Intent intent = new Intent(MainActivity.this, AlarmActivity.class);
            intent.putExtra("plan", planEdit.getText().toString());
            Toast.makeText(MainActivity.this,"알람이 설정되었습니다", Toast.LENGTH_SHORT).show();
            PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 30, intent, PendingIntent.FLAG_UPDATE_CURRENT); // 설정한 시간에 activiy가 생성
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
            }else {
                alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
            }
        }
    };

    private void UpdateNow() { // TextView 에 설정한 날짜와 시간을 출력
        dateText.setText(String.format("%d/%d/%d", mYear, mMonth + 1, mDay));
        timeText.setText(String.format("%d:%d", mHour, mMinute));
    }

    @Override protected void onDestroy() { // 어플 재실행할때 저장된 일정들을 불러온다.
        super.onDestroy();
        plan(planText.getText().toString());
        hour(timeText.getText().toString());
        day(dateText.getText().toString());
    }

    public void plan(String s){ // 입력한 일정들을 저장
        sharedPreferences = getSharedPreferences("sp", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("plan",s);
        editor.commit();
    }

    public void hour(String s){ // 입력한 일정들을 저장
        sharedPreferences = getSharedPreferences("sp", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("hour",s);
        editor.commit();
    }

    public void day(String s){
        sharedPreferences = getSharedPreferences("sp", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("day", s);
        editor.commit();
    }
}
