package com.example.asus.myservice.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;
import com.tj.chf.IMyAidlInterface;

/**
 * Created by Asus on 2016/4/16.
 */
public class MyBindService extends Service {
    private static final String LGD="MyBindSerice";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(LGD,"运行的方法------"+Thread.currentThread().getStackTrace()[2].getMethodName());
        return new MyService();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(LGD,"运行的方法------"+Thread.currentThread().getStackTrace()[2].getMethodName());
        return super.onUnbind(intent);
    }

    @Override
    public void onCreate() {
        Log.i(LGD,"运行的方法------"+Thread.currentThread().getStackTrace()[2].getMethodName());
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    public  class MyService extends Binder{
        public Service getService(){
            return MyBindService.this;
        }
    }
    public int getNum(){
        int a=0;
        for (int i=0;i<100;i++){
            a++;
        }
        return a;
    }


}
