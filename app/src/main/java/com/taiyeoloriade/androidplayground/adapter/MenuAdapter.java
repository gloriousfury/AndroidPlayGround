package com.taiyeoloriade.androidplayground.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.taiyeoloriade.androidplayground.R;
import com.taiyeoloriade.androidplayground.activity.AndroidSqlLiteActivity;
import com.taiyeoloriade.androidplayground.activity.AppBarActivity;
import com.taiyeoloriade.androidplayground.activity.CustomTabsActivity;
import com.taiyeoloriade.androidplayground.activity.RetrofitActivity;
import com.taiyeoloriade.androidplayground.activity.SnackBarActivity;
import com.taiyeoloriade.androidplayground.activity.TodoActivity;
import com.taiyeoloriade.androidplayground.activity.TodoFragmentActivity;
import com.taiyeoloriade.androidplayground.model.Menu_Title;

import java.util.List;

import static android.media.CamcorderProfile.get;

import static com.taiyeoloriade.androidplayground.R.id.custom;
import static com.taiyeoloriade.androidplayground.R.id.default_activity_button;
import static com.taiyeoloriade.androidplayground.R.id.menu_item;

/**
 * Created by OLORIAKE KEHINDE on 11/9/2016.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {
    Context context;
    private List<Menu_Title> title_list;

    public MenuAdapter(Context context, List<Menu_Title> menu_title) {
        this.context = context;
        this.title_list = menu_title;


    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title, desc, duration;
        LinearLayout layout;

        public ViewHolder(View view) {
            super(view);
            view.setClickable(true);
            view.setOnClickListener(this);
            title = (TextView) view.findViewById(R.id.menu_item);
            desc =  (TextView) view.findViewById(R.id.menu_description);
            duration = (TextView) view.findViewById(R.id.duration);
            layout = (LinearLayout) view.findViewById(R.id.linear_layout);

        }

        @Override
        public void onClick(View v) {

            switch (getAdapterPosition()) {

                case 0:

                    Intent retrofit = new Intent(context, RetrofitActivity.class);
                    context.startActivity(retrofit);

                    break;
                case 1:


                    Intent snackbar = new Intent(context, SnackBarActivity.class);
                    context.startActivity(snackbar);

                    break;
                case 2:


                    Intent appbarlayout = new Intent(context, AppBarActivity.class);
                    context.startActivity(appbarlayout);

                    break;
                case 3:


                    Intent customTabs = new Intent(context, CustomTabsActivity.class);
                    context.startActivity(customTabs);

                    break;
                case 4:


                    Intent sqlite = new Intent(context, AndroidSqlLiteActivity.class);
                    context.startActivity(sqlite);

                    break;

                case 5:


                    Intent todo = new Intent(context, TodoFragmentActivity.class);
                    context.startActivity(todo);

                    break;


                default:


            }

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_menu, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(title_list.get(position).getTitle());
        holder.desc.setText(title_list.get(position).getAbout());
        holder.duration.setText(title_list.get(position).getTime_interval());


        ChangeLayoutBackground(holder, position);


    }

    private void ChangeLayoutBackground(ViewHolder holder, int position) {


        if (position == 0){

            holder.layout.setBackgroundColor(ContextCompat.getColor(context, R.color.color_1));
        }else if (position ==1){


            holder.layout.setBackgroundColor(ContextCompat.getColor(context, R.color.color_2));

        }else if (position ==2){


            holder.layout.setBackgroundColor(ContextCompat.getColor(context, R.color.color_3));

        }else if (position ==3){


            holder.layout.setBackgroundColor(ContextCompat.getColor(context, R.color.color_4));

        }else if (position ==4){


            holder.layout.setBackgroundColor(ContextCompat.getColor(context, R.color.color_5));

        }else if (position ==5){


            holder.layout.setBackgroundColor(ContextCompat.getColor(context, R.color.color_6));

        }

    }

    @Override
    public int getItemCount() {
        return title_list.size();
    }
}
