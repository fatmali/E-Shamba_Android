package com.example.fatma.buttonproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView t;
    Button b1;
    Button b2;
    Button b3;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.button);
        b1.setOnClickListener(this);
        t = (TextView) findViewById(R.id.textView);




}

    public void broadcastIntent(View view){
        sendBroadcast(new Intent().setAction("com.example.CUSTOM_INTENT"));
    }


    public void startService(View v) {
        startService(new Intent(getBaseContext(), MyService.class));

    }


    public void stopService(View v) {
        stopService(new Intent(getBaseContext(), MyService.class));
    }

    public void onClick(View v) {
        updateTime();
    }

    public void updateTime() {
        t.setText("The time is " + new Date().toString());

    }
}
