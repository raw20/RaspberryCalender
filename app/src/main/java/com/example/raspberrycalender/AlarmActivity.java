package com.example.raspberrycalender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Locale;

public class AlarmActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    TextView alarmText, readText;
    TextToSpeech tts;
    int mHour, mMinute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        alarmText = (TextView) findViewById(R.id.alarmText);
        readText = (TextView) findViewById(R.id.readText);
        Intent intent = getIntent();
        String plan = intent.getStringExtra("plan");
        alarmText.setText(plan);
        tts = new TextToSpeech(this,this);
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS){
            int language = tts.setLanguage(Locale.KOREAN);
            if (language == TextToSpeech.LANG_MISSING_DATA || language == TextToSpeech.LANG_NOT_SUPPORTED){
                alarmText.setEnabled(false);
                Toast.makeText(this, "지원하지 않는 언어입니다.", Toast.LENGTH_SHORT).show();
            }else {
                alarmText.setEnabled(true);
                readText.setEnabled(true);
                Toast.makeText(this, "음성출력 성공.", Toast.LENGTH_SHORT).show();
                speakOut();
            }
        }else {
            Toast.makeText(this, "TTS 실패!", Toast.LENGTH_SHORT).show();
        }
    }
    private void speakOut() { // 음성출력 기본설정
        final Calendar calendar = Calendar.getInstance();
        mHour = calendar.get(Calendar.HOUR_OF_DAY);
        mMinute = calendar.get(Calendar.MINUTE);
        String text = alarmText.getText().toString();
        String text1 = ".... 지금은" + text + "할 시간입니다. 현재시간은" + String.valueOf(mHour) + "시" + String.valueOf(mMinute) + "분입니다.";
        tts.setPitch((float) 1);
        tts.setSpeechRate((float) 1);
        tts.speak(text1, TextToSpeech.QUEUE_FLUSH, null);
    }
}
