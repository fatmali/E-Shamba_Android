package com.example.fatma.gettingbacktobasics;

import android.content.BroadcastReceiver;

/**
 * Created by fatma on 12/18/16.
 */
 import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver{

        public void onReceive(Context context, Intent intent){
            Toast.makeText(context,"Battery Okay",Toast.LENGTH_LONG).show();
        }

}
