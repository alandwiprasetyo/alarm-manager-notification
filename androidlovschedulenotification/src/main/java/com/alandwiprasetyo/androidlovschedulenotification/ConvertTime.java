package com.alandwiprasetyo.androidlovschedulenotification;

/**
 * Created by alandwiprasetyo on 10/26/16.
 */

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

public class ConvertTime {
    private String pattern = "yyyy-MM-dd HH:mm:ss";
    private DateTime dateTime;
    private String date;

    public ConvertTime(String date) {
        this.date = date;
        dateTime = DateTime.parse(this.date, DateTimeFormat.forPattern(pattern));
    }

    public void setDateTime(String date, String time) {
        this.date = date;
        dateTime = DateTime.parse(date.concat(" ").concat(time), DateTimeFormat.forPattern(pattern));
    }

    public int getYear() {
        return dateTime.getYear();
    }

    public int getMonth() {
        return dateTime.getMonthOfYear();
    }

    public int getDay() {
        return dateTime.getDayOfMonth();
    }

    public int getHour() {
        return dateTime.getHourOfDay();
    }

    public int getMinutes() {
        return dateTime.getMinuteOfHour();
    }

    public int getSecond() {
        return dateTime.getSecondOfMinute();
    }

}