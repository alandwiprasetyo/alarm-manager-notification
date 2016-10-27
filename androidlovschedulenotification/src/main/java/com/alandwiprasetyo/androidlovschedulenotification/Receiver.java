package com.alandwiprasetyo.androidlovschedulenotification;

/**
 * Created by alandwiprasetyo on 10/26/16.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class Receiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context c, Intent i) {
        Intent service = new Intent(c, AlarmService.class);
        Bundle extras = i.getExtras();
        service.putExtra("title", extras.getString("title"));
        service.putExtra("message", extras.getString("message"));
        service.putExtra("time", extras.getString("time"));
        service.putExtra("icon", extras.getInt("icon"));
        c.startService(service);
    }
}
