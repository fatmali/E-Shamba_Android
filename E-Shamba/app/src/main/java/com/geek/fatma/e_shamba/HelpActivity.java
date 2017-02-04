package com.geek.fatma.e_shamba;

import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HelpActivity extends AppCompatActivity implements View.OnClickListener {

    private Button sendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);



        Toolbar topToolBar = (Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(topToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        sendEmail = (Button)findViewById(R.id.email);
        sendEmail.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String[] to = {"tumz92@gmail.com"};

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "E-Shamba User");


        try{
            startActivity(Intent.createChooser(emailIntent,"Send Email"));
            finish();
        }

        catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this,
                    "There is no email client installed.",
                    Toast.LENGTH_SHORT).show();
        }

    }
}
