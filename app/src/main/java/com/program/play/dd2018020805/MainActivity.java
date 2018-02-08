package com.program.play.dd2018020805;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MyReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        receiver = new MyReceiver();
    }

    public void click1(View v)
    {
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_ON);     //thomas 20180208 filter.addAction("myaction");
        filter.setPriority(500);
        registerReceiver(receiver, filter);
        Log.d("REC", "onReceive2");
    }

    public void click2(View v)
    {
        unregisterReceiver(receiver);
    }

    public void click3(View v)
    {
        Intent intent = new Intent("myaction");
        sendBroadcast(intent);

    }
}
