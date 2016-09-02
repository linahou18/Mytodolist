package com.example.nina.mytodolist.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.example.nina.mytodolist.AlarmReceiver;
import com.example.nina.mytodolist.TodoEditActivity;
import com.example.nina.mytodolist.models.Todo;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by nina on 8/31/16.
 */
public class AlarmUtils {

    public static void setAlarm(@NonNull Context context, @NonNull Todo todo) {
        Calendar c = Calendar.getInstance();
        if (todo.remindDate.compareTo(c.getTime()) < 0) {
            return;
        }

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(context, AlarmReceiver.class);
        intent.putExtra(TodoEditActivity.KEY_TODO, todo);
        PendingIntent alarmIntent = PendingIntent.getBroadcast(context,
                                                               0,
                                                               intent,
                                                               PendingIntent.FLAG_UPDATE_CURRENT);

        alarmManager.set(AlarmManager.RTC_WAKEUP,
                         todo.remindDate.getTime(),
                         alarmIntent);
    }
}
