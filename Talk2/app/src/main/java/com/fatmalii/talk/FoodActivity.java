package com.fatmalii.talk;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class FoodActivity extends AppCompatActivity {

    ViewPager vp;
    TabLayout tl;
    Toolbar tb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        tb=(Toolbar)findViewById(R.id.food_tb);
        vp=(ViewPager)findViewById(R.id.food_vl);
        tl=(TabLayout)findViewById(R.id.food_tl);

        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager());
        vp.setAdapter(myAdapter);
        tl.setupWithViewPager(vp);
        setSupportActionBar(tb);

    }


    class MyAdapter extends FragmentStatePagerAdapter{

        MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment f = null;
            if(position == 0) f = new FoodFragmentA();
            if(position == 1) f = new FoodFragmentB();
                    return f;
        }

        @Override
        public int getCount() {
            return 2;
        }

        public CharSequence getPageTitle(int position){
            String name =null;
            if(position == 0) name = "Meals";
            if(position == 1) name = "Utensils";
            return name;
        }
    }


}
