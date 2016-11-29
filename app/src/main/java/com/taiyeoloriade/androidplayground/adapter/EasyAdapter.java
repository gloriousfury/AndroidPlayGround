package com.taiyeoloriade.androidplayground.adapter;

/**
 * Created by OLORIAKE KEHINDE on 11/16/2016.
 */

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
import com.taiyeoloriade.androidplayground.model.Menu_Title;

import java.util.List;

import static com.taiyeoloriade.androidplayground.R.id.menu_item;




public class EasyAdapter extends RecyclerView.Adapter<EasyAdapter.ViewHolder> {
    Context context;
    private List<Menu_Title> title_list;

    public EasyAdapter(Context context, List<Menu_Title> menu_title) {
//        this.context = context;
//        this.title_list = menu_title;


    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;

        public ViewHolder(View view) {
            super(view);
            view.setClickable(true);
            view.setOnClickListener(this);
//            title = (TextView) view.findViewById(menu_item);


        }

        @Override
        public void onClick(View v) {

            switch (getAdapterPosition()) {

//                case 0:
//                    Toast test = Toast.makeText(context, "It is Clicking", Toast.LENGTH_LONG);
//                    test.show();
//
//                    Intent retrofit = new Intent(context, RetrofitActivity.class);
//                    context.startActivity(retrofit);
//
//                break;
//
//
//                default:


            }

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.easy_cardview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        holder.title.setText(title_list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return title_list.size();
    }
}

