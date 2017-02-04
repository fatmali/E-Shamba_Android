package com.example.fatma.gettingbacktobasics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {
    String msg = "Android : ";




    //when activity is first created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//loads UI components

        //action bar



        Log.d(msg, "The onCreate() Event");
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //when activitiy is about to become visible
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(msg, "The onStart() Event");
    }

    //called after activity is visible
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(msg, "The onResume() Event");
    }


    //when another activity is taking focus
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(msg, "The onPause() Event");
    }


    //when activity is no longer visible
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(msg, "The onStop() Event");
    }

    //just before the acivity is destroyed
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(msg, "The onDestroy() Event");
    }


    public void startService(View view){
        startService(new Intent(getBaseContext(), HelloService.class));
    }


    public void stopService(View view){
        stopService(new Intent(getBaseContext(), HelloService.class));
    }

    //broadcast custom intent

    public void broadcastIntent(View view){
        Intent intent = new Intent();
        intent.setAction("com.example.fatma.CUSTOM_INTENT");
        sendBroadcast(intent);

    }



}
