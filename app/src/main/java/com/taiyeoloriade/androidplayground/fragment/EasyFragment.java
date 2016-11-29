package com.taiyeoloriade.androidplayground.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.taiyeoloriade.androidplayground.R;

/**
 * Created by OLORIAKE KEHINDE on 11/16/2016.
 */

public class EasyFragment extends Fragment implements View.OnClickListener {

  
        public static EasyFragment newInstance() {
            EasyFragment fragment = new EasyFragment();
            return fragment;
        }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    RelativeLayout settingsLayout;
    ImageView settingsImage;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_main, container, false);

        //define variable
//        settingsImage = (ImageView) v.findViewById(R.id.settings_image);
//        settingsLayout = (RelativeLayout) v.findViewById(R.id.settings_layout);
//
//        settingsImage.setOnClickListener(this);
//        settingsLayout.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {




        }


    }
