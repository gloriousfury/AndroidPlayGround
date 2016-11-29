package com.taiyeoloriade.androidplayground.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.taiyeoloriade.androidplayground.R;
import com.taiyeoloriade.androidplayground.activity.AndroidSqlLiteActivity;
import com.taiyeoloriade.androidplayground.activity.SingleTodoActivity;
import com.taiyeoloriade.androidplayground.adapter.SqlLiteAdapter;
import com.taiyeoloriade.androidplayground.adapter.TodoAdapter;
import com.taiyeoloriade.androidplayground.model.Contact;
import com.taiyeoloriade.androidplayground.model.Tag;
import com.taiyeoloriade.androidplayground.model.Todo;

import java.util.List;

import com.taiyeoloriade.androidplayground.utility.DatabaseHelper;

/**
 * Created by OLORIAKE KEHINDE on 11/16/2016.
 */

public class ViewTodoFragment extends Fragment implements View.OnClickListener {

    public ViewTodoFragment() {
        // Required empty public constructor
    }

    public static ViewTodoFragment newInstance() {
        ViewTodoFragment fragment = new ViewTodoFragment();
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    DatabaseHelper db;
    Button createTag, createToDo;
    RecyclerView recycler;
    TodoAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_todo, container, false);

        createTag = (Button) v.findViewById(R.id.btnCreateTag);
        createToDo = (Button) v.findViewById(R.id.btnCreateTodo);
        createTag.setOnClickListener(this);
        createToDo.setOnClickListener(this);
        db = new DatabaseHelper(getActivity());


        recycler = (RecyclerView) v.findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(layoutManager);
        List<Todo> Todo = db.getAllToDos();

        List<Todo> allToDos = db.getAllToDos();
        for (Todo todo : allToDos) {
            Log.d("ToDo", todo.getNote());
        }
        adapter = new TodoAdapter(getActivity(), Todo);
        recycler.setAdapter(adapter);
        return v;
    }





    public void AdapterChanged() {
        List<Todo> todo= db.getAllToDos();
        adapter = new TodoAdapter(getActivity(), todo);
        recycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }



    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.btnCreateTag:
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                alertDialog.setTitle("Create a Tag");


                final EditText tag_name = new EditText(getActivity());


//quantity.setInputType(InputType.TYPE_CLASS_NUMBER|InputType.TYPE_NUMBER_FLAG_DECIMAL);
//lot.setInputType(InputType.TYPE_CLASS_NUMBER|InputType.TYPE_NUMBER_FLAG_DECIMAL);


                LinearLayout ll = new LinearLayout(getActivity());
                ll.setOrientation(LinearLayout.VERTICAL);


                ll.addView(tag_name);
                alertDialog.setView(ll);

                alertDialog.setCancelable(false);
                alertDialog.setPositiveButton("ADD", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        String tagname_string = tag_name.getText().toString();
                        Tag tag = new Tag(tag_name.getText().toString());
                        db.createTag(tag);


                        Toast test = Toast.makeText(getActivity(), tagname_string + "has been added to your tags", Toast.LENGTH_LONG);
                        test.show();


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

            case R.id.btnCreateTodo:


                Intent TodoClass = new Intent(getActivity(), SingleTodoActivity.class);
                startActivity(TodoClass);

                break;


        }


    }

    @Override
    public void onResume() {
        super.onResume();
        AdapterChanged();
    }
}
