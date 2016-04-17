package com.example.asus.myservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.asus.myservice.service.MyStartService;

/**
 * Created by Asus on 2016/4/16.
 */
public class MySecActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mButton1,mButton2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sec_layout);
        mButton1=(Button)findViewById(R.id.but1);
        mButton1.setOnClickListener(this);
        mButton2=(Button)findViewById(R.id.but2);
        mButton2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
            Intent intent;
        switch(v.getId()){
            case R.id.but1:
                intent=new Intent(MySecActivity.this, MyStartService.class);
                startService(intent);
                break;
            case R.id.but2:
                intent=new Intent(MySecActivity.this, MyStartService.class);
                stopService(intent);
                break;
        }
    }
}
