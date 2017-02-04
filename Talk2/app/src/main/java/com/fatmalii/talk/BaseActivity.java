package com.fatmalii.talk;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ActionBarDrawerToggle ab;
    NavigationView nv;
    DrawerLayout fullView;
    FrameLayout fl;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    public void setContentView(int layoutResID) {
        fullView = (DrawerLayout) getLayoutInflater().inflate(R.layout.toolbar, null);
        fl = (FrameLayout) fullView.findViewById(R.id.activity_content);
        getLayoutInflater().inflate(layoutResID, fl, true);
        super.setContentView(fullView);

        toolbar = (Toolbar) findViewById(R.id.tb);
        nv = (NavigationView) findViewById(R.id.nv);
        if(useToolbar())
            setSupportActionBar(toolbar);
        else
            toolbar.setVisibility(View.GONE);

        setUpNavView();





    }


    protected boolean useToolbar(){
        return true;
    }




    protected void setUpNavView(){
        nv.setNavigationItemSelectedListener(this);
        ab = new ActionBarDrawerToggle(this,fullView, toolbar,R.string.open,R.string.close);
        fullView.addDrawerListener(ab);
        ab.syncState();
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent i;
        switch (item.getItemId()) {
            case R.id.food_item:
                i = new Intent(this, FoodActivity.class);
                startActivity(i);
                break;

            case R.id.clothing_item:
                i = new Intent(this, ClothingActivity.class);
                startActivity(i);
                break;

            case R.id.drink_item:
                break;

            case R.id.comfort_item:
                i = new Intent(this, ComfortActivity.class);
                startActivity(i);
                break;

            case R.id.loo_item:
                i = new Intent(this, WashroomActivity.class);
                startActivity(i);
                break;

            case R.id.greetings_item:
                i = new Intent(this, GreetingActivity.class);
                startActivity(i);
                break;


            case R.id.medical_item:
                i = new Intent(this, MedicalActivity.class);
                startActivity(i);
                break;

            case R.id.word_item:
                break;

        }

        return true;
    }



        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            getMenuInflater().inflate(R.menu.tb_menu, menu);
            return true;
        }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //settings menu
        return true;
    }
}
