package com.alandwiprasetyo.notificationalarmmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alandwiprasetyo.androidlovschedulenotification.ScheduleNotification;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String timeSchedule = "2016-10-26 21:07:00"; // data schedule time
        ScheduleNotification notification = new ScheduleNotification(0, this, NotifActivity.class, timeSchedule);
        notification.setId(0).setTitle("Title").setMessage("This is a message for notification");
        notification.save();
    }
}
