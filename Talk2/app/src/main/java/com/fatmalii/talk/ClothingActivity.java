package com.fatmalii.talk;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ClothingActivity extends AppCompatActivity {

    ViewPager vl;
    TabLayout tl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothing);
        vl = (ViewPager)findViewById(R.id.clothing_vl);
        tl = (TabLayout)findViewById(R.id.clothing_tl);
        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager());
        vl.setAdapter(myAdapter);
        tl.setupWithViewPager(vl);
    }


    class MyAdapter extends FragmentStatePagerAdapter{

         MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment f=null;
            if(position==0)  f= new ClothingFragmentA();
            if(position==1)  f=new ClothingFragmentB();
            return f;
        }

        @Override
        public int getCount() {
            return 2;
        }

        public CharSequence getPageTitle(int position) {
            String title = null;
            if(position==0)  title = "Dress";
            if(position==1)  title = "Undress";
            return title;
        }

    }
}
