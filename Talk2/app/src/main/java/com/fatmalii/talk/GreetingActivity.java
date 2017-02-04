package com.fatmalii.talk;

import android.annotation.TargetApi;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Locale;

public class GreetingActivity extends AppCompatActivity implements View.OnClickListener {

    ViewPager vp;
    TabLayout tl;
    TextToSpeech textToSpeech;
    String toSpeak;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings);

        vp = (ViewPager)findViewById(R.id.greetings_vl);
        tl = (TabLayout) findViewById(R.id.greetings_tl);



        MyAdapter adapter = new MyAdapter(getSupportFragmentManager());
        vp.setAdapter(adapter);
        tl.setupWithViewPager(vp);
        final Locale loc = new Locale("Swa");




        //initializing tts
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status!=TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.US);
                }

                if(textToSpeech.isLanguageAvailable(loc)==1){
                    textToSpeech.setLanguage(loc);
                }

            }
        });


        //end initializing tts

    }









    /// on Pause ///







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




    public void onStop(){
        super.onStop();
    }


    @Override
    public void onClick(View v) {
        Button btnPressed = (Button)v;
        toSpeak = btnPressed.getText().toString();
        if(Build.VERSION.SDK_INT >=  Build.VERSION_CODES.LOLLIPOP)
            ttsGreater21(toSpeak);
        else
            ttsUnder20(toSpeak);
    }




    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void ttsGreater21(String toSpeak){
        String utteranceID=this.hashCode()+"";
        Toast.makeText(this,toSpeak,Toast.LENGTH_LONG).show();
        textToSpeech.speak(toSpeak,TextToSpeech.QUEUE_FLUSH,null,utteranceID);

    }



    @SuppressWarnings("deprecation")
    public void ttsUnder20(String toSpeak){
        HashMap<String,String> map = new HashMap<>();
        map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID,"MessageId");
        textToSpeech.speak(toSpeak,TextToSpeech.QUEUE_FLUSH,map);

    }

    //////////////////////// MyAdapter Class ////////////////////////////


    class MyAdapter extends FragmentStatePagerAdapter{

        MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment f = null;
            if(position == 0) f = new GreetingFragmentA();
            if(position == 1) f = new GreetingFragmentB();
            return f;
        }

        @Override
        public int getCount() {
            return 2;
        }


        public CharSequence getPageTitle(int position){
            String name = null;
            if(position == 0) name = "Morning";
            if(position == 1) name = "Evening";
            return name;
        }
    }
}
