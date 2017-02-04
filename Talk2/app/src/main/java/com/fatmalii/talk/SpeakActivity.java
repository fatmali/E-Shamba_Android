package com.fatmalii.talk;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by fatma on 1/2/17.
 */

public class SpeakActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    Button button;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_speak);
        String toSpeak = getIntent().getExtras().toString();

        editText = (EditText)findViewById(R.id.editTextSpeak);
        editText.setText(toSpeak);

        button = (Button)findViewById(R.id.speak_btn);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
