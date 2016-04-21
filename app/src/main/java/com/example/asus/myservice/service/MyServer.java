package com.example.asus.myservice.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.tj.chf.IMyAidlInterface;
/**
 * Created by Asus on 2016/4/21.
 */
public class MyServer extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return stb;
    }
    private IMyAidlInterface.Stub stb= new IMyAidlInterface.Stub() {
        @Override
        public int add(int a, int b) throws RemoteException {
            return a*b;
        }
    };
}
