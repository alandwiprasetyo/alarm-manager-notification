package com.alandwiprasetyo.notificationalarmmanager;

/**
 * Created by alandwiprasetyo on 10/26/16.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by root on 02/01/16.
 */
public class Receiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context c, Intent i) {
        Intent myService1 = new Intent(c, AlarmService.class);
        Bundle extras = i.getExtras();
        myService1.putExtra("name", extras.getString("name"));
        myService1.putExtra("jam", extras.getString("jam"));
        c.startService(myService1);
    }
}