package com.taiyeoloriade.androidplayground.activity;

/**
 * Created by OLORIAKE KEHINDE on 11/16/2016.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.crash.FirebaseCrash;
import com.taiyeoloriade.androidplayground.R;
import com.taiyeoloriade.androidplayground.adapter.MenuAdapter;
import com.taiyeoloriade.androidplayground.model.Menu_Title;

import java.util.ArrayList;

import butterknife.ButterKnife;



public class EasyRecyclerActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.easy_recyclerview);


//        FirebaseCrash.report(new Exception("This is my first Firebase crash testing"));


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        MenuAdapter adapter = new MenuAdapter(this, MenuItems());

        recyclerView.setAdapter(adapter);


    }



    private final String title[] = {
            "Retrofit 2.0",
            "SnackBar Test",
            "AppBarLayout",
            "Chrome Custom Tabs",
            "SqlLite"


    };

    public ArrayList MenuItems(){

        ArrayList menuItems = new ArrayList<>();
        for(int i=0;i<title.length; i++){
            Menu_Title newModel = new Menu_Title();
            newModel.setTitle(title[i]);

            menuItems.add(newModel);


        }

        return  menuItems;


    }




}

