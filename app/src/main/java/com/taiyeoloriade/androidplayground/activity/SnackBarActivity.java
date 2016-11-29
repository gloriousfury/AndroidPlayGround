package com.taiyeoloriade.androidplayground.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.crash.FirebaseCrash;
import com.taiyeoloriade.androidplayground.R;
import com.taiyeoloriade.androidplayground.adapter.MenuAdapter;
import com.taiyeoloriade.androidplayground.model.Menu_Title;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.attr.action;
import static android.R.attr.id;

public class SnackBarActivity extends AppCompatActivity {

    @BindView(R.id.btnSimpleSnackbar) Button Simple;
    @BindView(R.id.btnCustomSnackbar) Button Custom;
    @BindView(R.id.btnActionCallback) Button CallBack;

    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar);
        ButterKnife.bind(this);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);


    }




    @OnClick (R.id.btnSimpleSnackbar)
    public void SimpleSnackbar(View view){

        Snackbar snackbar = Snackbar.make(coordinatorLayout, "This is Taiye's playground", Snackbar.LENGTH_LONG);
        snackbar.show();


    }

    @OnClick (R.id.btnCustomSnackbar)
    public void  CustomSnackbar(View view){

        Snackbar snackbar = Snackbar.make(coordinatorLayout, "No Internet Connection", Snackbar.LENGTH_LONG);
        snackbar.setAction("RETRY", new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        // Changing message text color
        snackbar.setActionTextColor(Color.RED);

        // Changing action button text color
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.YELLOW);


        snackbar.show();


    }

    @OnClick (R.id.btnActionCallback)
        public void CallbackSnackbar(View view){

        Snackbar snackbar = Snackbar.make(coordinatorLayout,"Message is deleted", Snackbar.LENGTH_LONG);
        snackbar.setAction("UNDO", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar1 = Snackbar.make(coordinatorLayout, "Message is restored!", Snackbar.LENGTH_SHORT);
                snackbar1.show();
            }
        });
        snackbar.show();


        }


    private final String title[] = {
            "Retrofit 2.0",
            "SnackBar"


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
