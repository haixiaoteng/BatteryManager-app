package com.example.batterymanager_app;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    private PowerConnectionReceiver powerConnectionReceiver;
    private  BatteryLevelReceiver batteryLevelReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);

        IntentFilter intentFilter1 = new IntentFilter();
        intentFilter1.addAction("android.net.conn.CONNECTIVITY_CHANGE");

        powerConnectionReceiver = new PowerConnectionReceiver();
        registerReceiver(powerConnectionReceiver, intentFilter);

        batteryLevelReceiver = new BatteryLevelReceiver();
        registerReceiver(batteryLevelReceiver,intentFilter);

    }

}