package com.fatmalii.talk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class ComfortActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comfort);
        Toolbar tb = (Toolbar)findViewById(R.id.comfort_tb);
        setSupportActionBar(tb);
    }
}
