package com.fatmalii.talk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MedicalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical);
        Toolbar tb = (Toolbar)findViewById(R.id.medical_tb);
        setSupportActionBar(tb);
    }
}
