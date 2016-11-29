package com.taiyeoloriade.androidplayground.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.taiyeoloriade.androidplayground.R;
import com.taiyeoloriade.androidplayground.adapter.SqlLiteAdapter;
import com.taiyeoloriade.androidplayground.model.Contact;

import java.util.List;

import butterknife.ButterKnife;

import com.taiyeoloriade.androidplayground.utility.DatabaseHandler;

/**
 * Created by OLORIAKE KEHINDE on 11/12/2016.
 */

public class AndroidSqlLiteActivity extends AppCompatActivity implements View.OnClickListener {

    DatabaseHandler db;
    Button contactBtn;
    SqlLiteAdapter adapter;
    private
    SwipeRefreshLayout swipeContainer;
    RecyclerView recycler;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        ButterKnife.bind(this);

        contactBtn = (Button) findViewById(R.id.btn_addContact);
        contactBtn.setOnClickListener(this);

         recycler = (RecyclerView) findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);


        db = new DatabaseHandler(this);


        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        // Setup refresh listener which triggers new data loading
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Your code to refresh the list here.
                // Make sure you call swipeContainer.setRefreshing(false)
                // once the network request has completed successfully.
                List<Contact> contacts = db.getAllContacts();
                adapter = new SqlLiteAdapter(AndroidSqlLiteActivity.this, contacts);
                recycler.setAdapter(adapter);
                swipeContainer.setRefreshing(false);
            }
        });
        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);


        /**
         * CRUD Operations
         * */
        // Inserting Contacts
        //        Log.d("Insert: ", "Inserting ..");
        //        db.addContact(new Contact("Ravi", "9100000000"));
        //        db.addContact(new Contact("Srinivas", "9199999999"));
        //        db.addContact(new Contact("Tommy", "9522222222"));
        //        db.addContact(new Contact("Karthik", "9533333333"));

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.getAllContacts();

        adapter = new SqlLiteAdapter(this, contacts);
        recycler.setAdapter(adapter);


//        for (Contact cn : contacts) {
//                String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
//                // Writing Contacts to log
//                Log.d("Name: ", log);
//            Toast toast = Toast.makeText(this, cn.getName(),Toast.LENGTH_LONG );
//            toast.show();
//        }
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_addContact:

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                alertDialog.setTitle("ADDCONTACT");
                TextView name = new TextView(this);
                name.setText("Name");
                final EditText nameText = new EditText(this);
                final EditText phone_no = new EditText(this);

//quantity.setInputType(InputType.TYPE_CLASS_NUMBER|InputType.TYPE_NUMBER_FLAG_DECIMAL);
//lot.setInputType(InputType.TYPE_CLASS_NUMBER|InputType.TYPE_NUMBER_FLAG_DECIMAL);


                LinearLayout ll = new LinearLayout(this);
                ll.setOrientation(LinearLayout.VERTICAL);
                ll.addView(name);
                ll.addView(nameText);
                ll.addView(phone_no);
                alertDialog.setView(ll);

                alertDialog.setCancelable(false);
                alertDialog.setPositiveButton("ADD", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        db.addContact(new Contact(nameText.getText().toString(), phone_no.getText().toString()));
                        AdapterChanged();
//ACTION
                    }
                });

                alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        dialog.cancel();
                    }
                });


                alertDialog.show();


                break;


        }


    }

    private void AdapterChanged() {
        List<Contact> contacts = db.getAllContacts();
        adapter = new SqlLiteAdapter(AndroidSqlLiteActivity.this, contacts);
        recycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }





}
