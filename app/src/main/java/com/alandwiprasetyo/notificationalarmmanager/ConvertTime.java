package com.alandwiprasetyo.notificationalarmmanager;

/**
 * Created by alandwiprasetyo on 10/26/16.
 */


import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by root on 01/05/16.
 */
public class ConvertTime {
    private String pattern = "yyyy-MM-dd HH:mm:ss";
    private DateTime dateTime;
    private String date;
    static DecimalFormat formatter = new DecimalFormat("00");

    public ConvertTime() {
        //current date
        dateTime = DateTime.parse(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis())), DateTimeFormat.forPattern(pattern));

    }

    public ConvertTime(String date, String time) {
        setDateTime(date, time);
    }

    public ConvertTime(String date) {
        this.date = date;
        dateTime = DateTime.parse(this.date, DateTimeFormat.forPattern(pattern));
    }

    public void setDateTime(String date, String time) {
        this.date = date;
        dateTime = DateTime.parse(date.concat(" ").concat(time), DateTimeFormat.forPattern(pattern));
    }

    public String getDateTime() {
        return dateTime.getYear() + "-" + getSecondCharacter(dateTime.getMonthOfYear());
    }

    public String getDate() {
        return getSecondCharacter(getDay()) + "-" + getSecondCharacter(dateTime.getMonthOfYear()) + "-" + dateTime.getYear();
    }

    public String getDateEnglish() {
        return dateTime.getYear() + "-" + getSecondCharacter(dateTime.getMonthOfYear()) + "-" + getSecondCharacter(getDay());
    }

    public String getMonthYear() {
        return formatter.format(getYear()) + "-" + getSecondCharacter(getMonth());
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

    public static String getMonthForInt(int month) {
        String[] monthNames = {"Jan", "Feb", "March", "April", "May", "June", "July", "August", "Sept", "Oct", "Nov", "Dec", ""};
        return monthNames[month - 1];
    }

    public static String getMonthForInteger(int month) {
        String monthString = new DateFormatSymbols().getMonths()[month - 1];
        return monthString;
    }

    public static String getSecondCharacter(int value) {
        return String.valueOf(formatter.format(Double.valueOf(value)));
    }


}