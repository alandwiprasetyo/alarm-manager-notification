package com.alandwiprasetyo.androidlovschedulenotification;

/**
 * Created by alandwiprasetyo on 10/26/16.
 */

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by root on 02/01/16.
 */
public class AlarmService extends Service {

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        try {
            Bundle extras = intent.getExtras();
            displayNotification(extras.getString("title"), extras.getString("message"),
                    extras.getString("time"), extras.getInt("icon"));
        } catch (NullPointerException e) {
            Log.e("AlarmService", "onStart: " + e.getMessage());

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @SuppressLint("NewApi")
    public void displayNotification(String title, String message, String time, int icon) {
        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        Intent mainIntent = new Intent(this, ScheduleNotification.aClass);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, mainIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationManager nm = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(this);

        builder.setContentIntent(pIntent)
                .addAction(0, "View", pIntent)
                .setAutoCancel(true)
                .setSmallIcon(icon)
                .setTicker(title)
                .setContentTitle(title)
                .setContentText(message)
                .setSound(soundUri);

        nm.notify(0, builder.build());
    }
}