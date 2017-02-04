package com.example.fatma.gettingbacktobasics;

import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.app.Service;
import android.widget.Toast;

/**
 * Created by fatma on 12/18/16.
 */

public class HelloService extends Service {

    String msg = "Android : ";
    int mStartMode; //how to behave if service is killed

    IBinder mBinder; //interface that client binds

    boolean mAllowRebind; //should rebind be used?

    public void onCreate(){
        //service created
        Log.d(msg, "service created");
    }

    public int onStartCommand(Intent intent, int flags, int startID){
         //service started due to call to startService() in MainActivity
        Log.d(msg, "service  started");
        Toast.makeText(this,"Service Started",Toast.LENGTH_LONG).show();
        return mStartMode;
    }

    public IBinder onBind(Intent intent){

        return null;
    }

    public boolean onUnbind(Intent intent){

        Log.d(msg, "service  unbinded");
        return mAllowRebind;
    }

    public void onRebind(Intent intent){
        Log.d(msg, "service  rebinded");

    }


    public void onDestroy(){
        super.onDestroy();
        Toast.makeText(this,"Service Destroyed",Toast.LENGTH_LONG).show();
        Log.d(msg, "service  destroyed! muhaahahaha");

    }
}
