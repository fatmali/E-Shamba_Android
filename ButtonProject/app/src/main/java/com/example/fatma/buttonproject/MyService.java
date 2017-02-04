package com.example.fatma.buttonproject;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by fatma on 12/18/16.
 */
public class MyService extends Service {

    public void onCreate(){

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int flags, int startId){
        Toast.makeText(this,"Service Started",Toast.LENGTH_LONG).show();
        return START_STICKY;
    }

    public void onDestroy(){
        super.onDestroy();
        Toast.makeText(this,"Service Destroyed",Toast.LENGTH_LONG).show();
    }
}
