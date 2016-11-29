package com.taiyeoloriade.androidplayground.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import com.taiyeoloriade.androidplayground.R;
import com.taiyeoloriade.androidplayground.model.Tag;
import com.taiyeoloriade.androidplayground.model.Todo;

import java.util.ArrayList;
import java.util.List;

import com.taiyeoloriade.androidplayground.utility.DatabaseHelper;

public class SingleTodoActivity extends AppCompatActivity implements View.OnClickListener {


    AppCompatEditText note;
    AppCompatSpinner spinner;
    CalendarView calendarView;
    Toolbar toolbar;
    DatabaseHelper db;
    String noteGotten, noteTag;
    Button createToDo;
    List<Tag> tag;
    int  tagId;
    long selectedDeadline;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singletodo);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(" Create a Todo");

        note = (AppCompatEditText) findViewById(R.id.note);
        spinner = (AppCompatSpinner) findViewById(R.id.spinner);
        createToDo = (Button) findViewById(R.id.createTodo);
        calendarView = (CalendarView)findViewById(R.id.calendar);


        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {

                selectedDeadline = calendarView.getDate();
                Toast.makeText(getApplicationContext(), "Selected Date:\n" + "Day = " + i2 + "\n" + "Month = " + i1 + "\n" + "Year = " + i, Toast.LENGTH_LONG).show();
            }
        });
        createToDo.setOnClickListener(this);
        db = new DatabaseHelper(this);

         tag = db.getAllTags();

        List<String> tagNames = GetTagNames(tag);



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, tagNames);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // API 5+ solution
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.createTodo:

                noteGotten = note.getText().toString();
                noteTag = spinner.getSelectedItem().toString();

                long ex = calendarView.getDate();

            for (int i = 0; i < tag.size(); i++) {
                String tagName;
                tagName = tag.get(i).getTagName();

                if (tagName == noteTag) {

                    tagId = tag.get(i).getId();

                    Todo todo = new Todo(noteGotten, 0, selectedDeadline);
                     db.createToDo(todo, new long[]{tagId});

                    Toast test = Toast.makeText(this, "Todo has been created", Toast.LENGTH_LONG);
                    test.show();
                }

            }

                break;

        }



    }

    public ArrayList GetTagNames(List<Tag> tag){


        ArrayList tagItemNames = new ArrayList<>();
        for(int i=0;i<tag.size(); i++){
            String tagName;
            tagName = tag.get(i).getTagName();

            tagItemNames.add(tagName);



        }

        return  tagItemNames;


    }

}
