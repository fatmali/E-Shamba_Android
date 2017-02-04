package com.fatmalii.talk;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Locale;


@SuppressWarnings("deprecation")
public class MainActivity extends BaseActivity  {

    FloatingActionButton createCat;
    Button speak;
    String text;
    EditText editText;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editTextSpeak);


        Button speak = (Button)findViewById(R.id.speak_btn);

        //initializing tts
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status!=TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.US);
                }


            }
        });

        speak.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                text = editText.getText().toString();

                if(Build.VERSION.SDK_INT >=  Build.VERSION_CODES.LOLLIPOP)
                    ttsGreater21(text);
                else
                    ttsUnder20(text);


            }
        });



    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void ttsGreater21(String toSpeak){
        if(toSpeak.isEmpty()) toSpeak = "Please type something first";
        String utteranceID=this.hashCode()+"";
        Toast.makeText(this,toSpeak,Toast.LENGTH_LONG).show();
        textToSpeech.speak(toSpeak,TextToSpeech.QUEUE_FLUSH,null,utteranceID);
    }


    public void ttsUnder20(String toSpeak){
        if(toSpeak.isEmpty()) toSpeak = "Please type something first";
        HashMap<String,String> map = new HashMap<>();
        map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID,"MessageId");
        textToSpeech.speak(toSpeak,TextToSpeech.QUEUE_FLUSH,map);
    }




    public void onResume(){

        //re-initializing tts
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) textToSpeech.setLanguage(Locale.US);
            }
        });

        super.onResume();
    }


    /// Destroy App
    public void onDestroy(){
        super.onDestroy();
    }



}
