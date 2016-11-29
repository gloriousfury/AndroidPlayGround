package com.taiyeoloriade.androidplayground.adapter;

/**
 * Created by OLORIAKE KEHINDE on 11/16/2016.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.taiyeoloriade.androidplayground.R;
import com.taiyeoloriade.androidplayground.model.Menu_Title;
import com.taiyeoloriade.androidplayground.model.Todo;

import java.util.List;


public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {
    Context context;
    private List<Todo> todo;

    public TodoAdapter(Context context, List<Todo> Todo) {
        this.context  = context;
        this.todo = Todo;


    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView note, createdat, deadline, status,title;

        public ViewHolder(View view) {
            super(view);
            view.setClickable(true);
            view.setOnClickListener(this);
//            title = (TextView) view.findViewById(menu_item);

            note = (TextView) view.findViewById(R.id.note);
            createdat = (TextView) view.findViewById(R.id.createdat);
            deadline = (TextView) view.findViewById(R.id.deadline);
            status = (TextView) view.findViewById(R.id.status);


        }

        @Override
        public void onClick(View v) {

            switch (getAdapterPosition()) {


            }

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        holder.title.setText(title_list.get(position).getTitle());

        holder.note.setText(todo.get(position).getNote());
        holder.createdat.setText(todo.get(position).getCreatedAt());

        if(todo.get(position).getStatus() == 1){
            holder.status.setText("Done");

        }else{
            holder.status.setText("Not yet done");

        }

    }

    @Override
    public int getItemCount() {
        return todo.size();
    }
}

