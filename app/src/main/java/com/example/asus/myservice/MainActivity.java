package com.example.asus.myservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.asus.myservice.service.MyBindService;
import com.example.asus.myservice.service.MyStartService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
        private Button mButton1,mButton2,mButton3,mButton4,mButton5;
    private MyBindService myBindService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton1=(Button)findViewById(R.id.but1);
        mButton1.setOnClickListener(this);
        mButton2=(Button)findViewById(R.id.but2);
        mButton2.setOnClickListener(this);
        mButton3=(Button)findViewById(R.id.but3);
        mButton3.setOnClickListener(this);
        mButton4=(Button)findViewById(R.id.but4);
        mButton4.setOnClickListener(this);
        mButton5=(Button)findViewById(R.id.but5);
        mButton5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.but1:
                 intent=new Intent(MainActivity.this, MyStartService.class);
                startService(intent);
                break;
            case R.id.but2:
                 intent=new Intent(MainActivity.this, MyStartService.class);
                stopService(intent);
                break;
            case R.id.but3:
                intent=new Intent(MainActivity.this, MyBindService.class);
                bindService(intent,sc,BIND_AUTO_CREATE);
                break;
            case R.id.but4:
                unbindService(sc);
                break;
            case R.id.but5:
                intent=new Intent(MainActivity.this,MySecActivity.class);
                startActivity(intent);
                break;


        }
    }
//必须在此调用方法，bind绑定在
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(sc);
    }

    private ServiceConnection sc=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            if(service instanceof MyBindService.MyService){
//                myBindService=new MyBindService();两种实例化
                myBindService=(MyBindService)((MyBindService.MyService)service).getService();
                myBindService.getNum();
            }
            Log.i("MainActivity","连接成功------"+myBindService.getNum());
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i("MainActivity","连接中断------");
        }
    };
}
