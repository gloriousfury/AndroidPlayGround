package com.taiyeoloriade.androidplayground.activity;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.crash.FirebaseCrash;
import com.taiyeoloriade.androidplayground.R;
import com.taiyeoloriade.androidplayground.adapter.MenuAdapter;
import com.taiyeoloriade.androidplayground.model.Menu_Title;
import com.taiyeoloriade.androidplayground.model.Project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

    public ArrayList MenuItems() {

        ArrayList menuItems = new ArrayList<>();
        menuItems.add(new Project("PayWithCapture Landing",
                "an interface with a minimized video playing in the background",
                5));
        menuItems.add(new Project("Todo List",
                "starting work on a todo work application",
                2));
        menuItems.add(new Project("Chrome Custom Tabs",
                "The awesome chrome tabs",
                1));
        menuItems.add(new Project("SqlLite",
                "tutorial implementation of the sqlite",
                1));
        menuItems.add(new Project("SnackBar Test",
                "Android support design implementation",
                2));
        menuItems.add(new Project("Payment Interface",
                "A nice payment interface",
                4));
        menuItems.add(new Project("Firebase Chatroom",
                "Learning to implement firebase on android",
                4));

       ArrayList<Project> sortedMenuList = sortArrayListByRanking(menuItems);
//
//        for(int i=0;i<title.length; i++){
//            Menu_Title newModel = new Menu_Title();
//
//
//            newModel.setTitle(title[i]);
//            newModel.setAbout(about[i]);
//            newModel.setTime_interval(duration[i]);
//
//            menuItems.add(newModel);
//
//
//        }

        return sortedMenuList;


    }

    public ArrayList<Project> sortArrayListByRanking(ArrayList<Project> projectLists) {

        Collections.sort(projectLists, new Comparator<Project>() {
            @Override
            public int compare(Project p1, Project p2) {
                return  p2.getRanking() -p1.getRanking(); // Descending
            }

        });

        return projectLists;
    }


}
