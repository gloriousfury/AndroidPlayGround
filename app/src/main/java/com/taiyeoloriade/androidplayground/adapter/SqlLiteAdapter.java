package com.taiyeoloriade.androidplayground.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.taiyeoloriade.androidplayground.R;
import com.taiyeoloriade.androidplayground.activity.AndroidSqlLiteActivity;
import com.taiyeoloriade.androidplayground.activity.AppBarActivity;
import com.taiyeoloriade.androidplayground.activity.CustomTabsActivity;
import com.taiyeoloriade.androidplayground.activity.RetrofitActivity;
import com.taiyeoloriade.androidplayground.activity.SnackBarActivity;
import com.taiyeoloriade.androidplayground.model.Contact;
import com.taiyeoloriade.androidplayground.model.Menu_Title;

import static android.R.id.list;
import static com.taiyeoloriade.androidplayground.R.id.name;

import java.util.List;

import static android.media.CamcorderProfile.get;

import static com.taiyeoloriade.androidplayground.R.id.custom;
import static com.taiyeoloriade.androidplayground.R.id.default_activity_button;
import static com.taiyeoloriade.androidplayground.R.id.menu_item;
import static com.taiyeoloriade.androidplayground.R.id.phone_no;

/**
 * Created by OLORIAKE KEHINDE on 11/9/2016.
 */

public class SqlLiteAdapter extends RecyclerView.Adapter<SqlLiteAdapter.ViewHolder> {
    Context context;
    private List<Contact> contact_list;

    public SqlLiteAdapter(Context context, List<Contact> contacts) {
        this.context = context;
        this.contact_list = contacts;


    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView Name, phone_no;

        public ViewHolder(View view) {
            super(view);
            view.setClickable(true);
            view.setOnClickListener(this);
            Name = (TextView) view.findViewById(name);
            phone_no = (TextView) view.findViewById(R.id.phone_no);


        }

        @Override
        public void onClick(View v) {


        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_sqlite, parent, false);
        return new ViewHolder(view);
    }

    @Override

    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.Name.setText(contact_list.get(position).getName());
        holder.phone_no.setText(contact_list.get(position).getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return contact_list.size();
    }

    public void clear() {
//        items.clear();
        notifyDataSetChanged();
    }

    // Add a list of items
    public void addAll(List<Contact> contacts) {
//        items.addAll(list);
        notifyDataSetChanged();
    }
}
