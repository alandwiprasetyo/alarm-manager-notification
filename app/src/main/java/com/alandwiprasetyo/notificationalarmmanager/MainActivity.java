package com.alandwiprasetyo.notificationalarmmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] timeNotification = {"2016-10-26 01:30:00", "2016-10-26 01:04:00"}; // data from timestamps
        for (int i = 0; i < timeNotification.length; i++) {
            ConvertTime time = new ConvertTime(timeNotification[i]);
            Calendar cal = Calendar.getInstance();
            System.out.println("YEAR :"+time.getYear());
            System.out.println("MONTH :"+time.getMonth());
            System.out.println("DAY :"+time.getDay());
            System.out.println("MINUTES :"+time.getMinutes());
            System.out.println("SECOND :"+time.getSecond());

            cal.set(Calendar.DAY_OF_MONTH, time.getDay());
            cal.set(Calendar.HOUR_OF_DAY, time.getHour());
//            cal.set(Calendar.HOUR_OF_DAY, time.getHour() - Constants.REMINDER_BEFORE);
            cal.set(Calendar.MINUTE, 12);
            cal.set(Calendar.SECOND, time.getSecond());
            long start = cal.getTimeInMillis();
            if (cal.before(Calendar.getInstance())) {
                start += AlarmManager.INTERVAL_DAY * 7;
            }
            Intent mainIntent = new Intent(this, Receiver.class);
            mainIntent.putExtra("name", "New Event");
            mainIntent.putExtra("jam", time.getHour() + ":" + time.getMinutes());

            PendingIntent pIntent = PendingIntent.getBroadcast(this, i, mainIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            AlarmManager myAlarm = (AlarmManager) getSystemService(ALARM_SERVICE);
            myAlarm.setRepeating(AlarmManager.RTC_WAKEUP, start, AlarmManager.INTERVAL_DAY * 7, pIntent);
        }

    }
}
