package com.alandwiprasetyo.androidlovschedulenotification;

import android.app.*;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;
import java.util.Random;

/**
 * Created by alandwiprasetyo on 10/26/16.
 */

public class ScheduleNotification extends Notification implements ScheduleImpl {
    private Activity activity;
    static Class aClass;
    private long start;

    private boolean repeat;

    public ConvertTime getTime() {
        return time;
    }

    private ConvertTime time;

    public ScheduleNotification(int id, Activity activity, Class aClass, String timestamps) {
        setId(id);
        this.activity = activity;
        this.time = new ConvertTime(timestamps);
        ScheduleNotification.aClass = aClass;
    }

    public ScheduleNotification(Activity activity, Class aClass, String timestamps) {
        setId(new Random().nextInt());
        this.activity = activity;
        this.time = new ConvertTime(timestamps);
        ScheduleNotification.aClass = aClass;
    }

    public ScheduleNotification save() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, time.getDay());
        cal.set(Calendar.HOUR_OF_DAY, time.getHour());
        cal.set(Calendar.MINUTE, time.getMinutes());
        cal.set(Calendar.SECOND, time.getSecond());
        start = cal.getTimeInMillis();
        if (isRepeat()) {
            if (cal.before(Calendar.getInstance())) {
                start += AlarmManager.INTERVAL_DAY * 7;
            }
        }
        setData();
        return this;
    }

    public void setData() {
        Intent mainIntent = new Intent(activity, Receiver.class);
        mainIntent.putExtra("id", getId());
        mainIntent.putExtra("title", getTitle());
        mainIntent.putExtra("message", getMessage());
        mainIntent.putExtra("time", getTime().toString());
        mainIntent.putExtra("icon", getIcon());
        setIntent(mainIntent);
    }

    public void setIntent(Intent mainIntent) {
        PendingIntent pIntent = PendingIntent.getBroadcast(activity, getId(), mainIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager myAlarm = (AlarmManager) activity.getSystemService(Context.ALARM_SERVICE);
        myAlarm.setRepeating(AlarmManager.RTC_WAKEUP, start, AlarmManager.INTERVAL_DAY * 7, pIntent);
    }

    private boolean isRepeat() {
        return repeat;
    }

    public void setRepeat(boolean repeat) {
        this.repeat = repeat;
    }
}
