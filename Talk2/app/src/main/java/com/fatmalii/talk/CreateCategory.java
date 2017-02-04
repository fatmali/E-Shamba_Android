package com.fatmalii.talk;

import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateCategory extends AppCompatActivity  {


    Button createCat;
    NavigationView nv;
    Menu menu;
    MenuItem menuItem;
    String menuTitle;
    EditText editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_category);


        createCat = (Button)findViewById(R.id.create_cat_btn);
    }

        /**
        nv = (NavigationView)findViewById(R.id.nv);
        menu = nv.getMenu();
        editor = (EditText)findViewById(R.id.create_cat_title);
        createCat.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        menuTitle = editor.getText().toString();
        menu.add(menuTitle);

    } **/
}
