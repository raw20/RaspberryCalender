package com.example.raspberrycalender;

class MonthItem { //달력의 item의 데이터를 위한 클래스
    private int dayValue;

    MonthItem(int dayValue){
        this.dayValue = dayValue;
    }
    public int getDay(){
        return dayValue;
    }

}
