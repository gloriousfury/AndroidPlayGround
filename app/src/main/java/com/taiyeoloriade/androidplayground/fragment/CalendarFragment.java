package com.taiyeoloriade.androidplayground.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.taiyeoloriade.androidplayground.R;
import com.taiyeoloriade.androidplayground.model.Tag;
import com.taiyeoloriade.androidplayground.model.Todo;
import com.taiyeoloriade.androidplayground.utility.DatabaseHelper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static android.media.CamcorderProfile.get;
import static com.taiyeoloriade.androidplayground.R.id.calendarView;

/**
 * Created by OLORIAKE KEHINDE on 11/16/2016.
 */

public class CalendarFragment extends Fragment implements View.OnClickListener {

  
        public static CalendarFragment newInstance() {
            CalendarFragment fragment = new CalendarFragment();
            return fragment;
        }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    RelativeLayout settingsLayout;
    ImageView settingsImage;
    CalendarView calendar;
    private MaterialCalendarView calendarView;

    DatabaseHelper db;
    Long deadlineDates;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_calendar, container, false);
        calendarView= (MaterialCalendarView) v.findViewById(R.id.calendarView);
        calendarView.setSelectionColor(Color.GREEN);
        Calendar calendar = new Calendar() {
            @Override
            public void add(int field, int value) {

            }

            @Override
            protected void computeFields() {

            }

            @Override
            protected void computeTime() {

            }

            @Override
            public int getGreatestMinimum(int field) {
                return 0;
            }

            @Override
            public int getLeastMaximum(int field) {
                return 0;
            }

            @Override
            public int getMaximum(int field) {
                return 0;
            }

            @Override
            public int getMinimum(int field) {
                return 0;
            }

            @Override
            public void roll(int field, boolean increment) {

            }
        };
        calendar.set(2016,11,24);
        calendarView.setSelectedDate(calendar);

        db = new DatabaseHelper(getContext());
        List<Todo> todo = db.getAllToDos();


        for (int i= 0; i< todo.size(); i++){
            deadlineDates = todo.get(i).getDeadline();
            if(deadlineDates  != null ){



            }else{}


        }






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
