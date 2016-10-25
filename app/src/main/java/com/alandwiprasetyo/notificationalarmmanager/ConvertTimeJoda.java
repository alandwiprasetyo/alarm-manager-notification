package com.alandwiprasetyo.notificationalarmmanager;

/**
 * Created by alandwiprasetyo on 10/26/16.
 */

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by root on 02/01/16.
 */
public class ConvertTimeJoda {

    SimpleDateFormat df;
    Calendar c1;
    public ConvertTimeJoda(String time){

        df = new SimpleDateFormat("hh:mm");
        Date d1 = null;
        try {
            d1 = df.parse(splitTime(time));
            c1 = GregorianCalendar.getInstance();
            c1.setTime(d1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private String splitTime(String time){
        return String.valueOf(time.split("-")[0]);
    }
    public int getHour(){
        return c1.getTime().getHours();
    }
    public int getMinutes(){
        return c1.getTime().getMinutes();
    }
    public int getDay(String s)
    {
        return Arrays.asList(new String[]{"SKIP", "MINGGU",
                "SENIN", "SELASA", "RABU", "KAMIS", "JUM'AT", "SABTU"
        }).indexOf(s.toUpperCase());
    }
    public static String timeDate(String time) {
        try {
            DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

            DateFormat format = new SimpleDateFormat("ddyyHHmmss");
            Date date = format.parse(time);
            System.out.println(date.toString());
            time = date.toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }


    public static String parseTime(Date time) {
        DateFormat df = new SimpleDateFormat("dd MMMM, HH:mm");
        String reportDate = df.format(time);
        return reportDate;
    }
}