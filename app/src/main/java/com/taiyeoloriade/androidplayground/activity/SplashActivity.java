package com.taiyeoloriade.androidplayground.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by OLORIAKE KEHINDE on 11/12/2016.
 */

public class SplashActivity extends AppCompatActivity {


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent MainAct = new Intent(this, MainActivity.class);
        startActivity(MainAct);
        this.finish();



    }


}
