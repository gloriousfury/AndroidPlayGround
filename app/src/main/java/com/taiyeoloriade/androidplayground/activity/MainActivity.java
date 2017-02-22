package com.taiyeoloriade.androidplayground.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.crash.FirebaseCrash;
import com.taiyeoloriade.androidplayground.R;
import com.taiyeoloriade.androidplayground.adapter.MenuAdapter;
import com.taiyeoloriade.androidplayground.model.Menu_Title;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        FirebaseCrash.report(new Exception("This is my first Firebase crash testing"));
//        FirebaseCrash.log("MainActivity log started");

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        MenuAdapter adapter = new MenuAdapter(this, MenuItems());

        recyclerView.setAdapter(adapter);


    }



    private final String title[] = {

            "PayWithCapture Landing",
            "Todo List",
            "Chrome Custom Tabs",
            "SqlLite",
            "SnackBar Test",
            "Payment Interface"




    };


    private final String about[] = {
            "an interface with a minimized video playing in the background",
            "starting work on a todo work application",
            "The awesome chrome tabs",
            "tutorial implementation of the sqlite",
            "Android support design implementation",
            "A nice payment interface"







    };


    private final String duration[] = {
            "weeks ago",
            "weeks ago",
            "weeks ago",
            "weeks ago",
            "weeks ago",
            "weeks ago",



    };



    public ArrayList MenuItems(){

        ArrayList menuItems = new ArrayList<>();


        for(int i=0;i<title.length; i++){
            Menu_Title newModel = new Menu_Title();


            newModel.setTitle(title[i]);
            newModel.setAbout(about[i]);
            newModel.setTime_interval(duration[i]);

            menuItems.add(newModel);


        }

        return  menuItems;


    }




}
