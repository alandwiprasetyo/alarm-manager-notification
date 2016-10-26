package com.alandwiprasetyo.androidlovschedulenotification;

import android.content.Intent;

/**
 * Created by alandwiprasetyo on 10/26/16.
 */
interface ScheduleImpl {
    ConvertTime getTime();
    ScheduleNotification save();
    void setData();
    void setIntent(Intent mainIntent);
}
