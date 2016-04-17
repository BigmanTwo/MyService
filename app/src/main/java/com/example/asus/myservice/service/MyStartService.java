package com.example.asus.myservice.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Asus on 2016/4/16.
 */
public class MyStartService extends Service {
    private static final String TGA="MyStartService";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TGA,"正在运行的时间————  "+Thread.currentThread().getStackTrace()[2].getMethodName());
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TGA,"正在运行的时间————  "+Thread.currentThread().getStackTrace()[2].getMethodName());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TGA,"正在运行的时间————  "+Thread.currentThread().getStackTrace()[2].getMethodName());
    }
}
