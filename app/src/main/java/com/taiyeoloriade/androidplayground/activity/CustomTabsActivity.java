package com.taiyeoloriade.androidplayground.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.taiyeoloriade.androidplayground.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by OLORIAKE KEHINDE on 11/12/2016.
 */


public class CustomTabsActivity extends AppCompatActivity {

    @BindView(R.id.btn_Retry)
    Button retry;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customtabs);
        ButterKnife.bind(this);


        LoadUri();


    }

    public void LoadUri() {


        Uri uri = Uri.parse("https://rightschools.com.ng");

// create an intent builder
        CustomTabsIntent.Builder intentBuilder = new CustomTabsIntent.Builder();

// Begin customizing
// set toolbar colors
        intentBuilder.setToolbarColor(ContextCompat.getColor(this, R.color.colorPrimary));
        intentBuilder.setSecondaryToolbarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));

// set start and exit animations
//        intentBuilder.setStartAnimations(this, R.anim.slide_in_right, R.anim.slide_out_left);
        intentBuilder.setExitAnimations(this, android.R.anim.slide_in_left,
                android.R.anim.slide_out_right);

// build custom tabs intent
        CustomTabsIntent customTabsIntent = intentBuilder.build();

// launch the url
        customTabsIntent.launchUrl(this, uri);


    }

    @OnClick public void RetryChrome(){

        LoadUri();
    }



}
