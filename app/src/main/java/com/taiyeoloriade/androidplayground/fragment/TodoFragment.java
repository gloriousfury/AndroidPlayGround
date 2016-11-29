package com.taiyeoloriade.androidplayground.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taiyeoloriade.androidplayground.R;

import static android.R.attr.fragment;


/**
 * Created by Ratan on 7/27/2015.
 */
public class TodoFragment extends Fragment {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 2 ;

   
    public static TodoFragment f;
    public static TodoFragment newInstance() {
        TodoFragment fragment = new TodoFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /**
         *Inflate tab_layout and setup Views.
         */
        View x =  inflater.inflate(R.layout.tablayout_todo,null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        viewPager = (ViewPager) x.findViewById(R.id.viewpager);

        /**
         *Set an Apater for the View Pager
         */
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));



        /**
         * Now , this is a workaround ,
         * The setupWithViewPager dose't works without the runnable .
         * Maybe a Support Library Bug .
         */

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);

            }
        });

        return x;

    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return fragment with respect to Position .
         */

        @Override
        public Fragment getItem(int position)
        {
            switch (position){
                case 0: new ViewTodoFragment();break;
                case 1: new EasyFragment(); break;

            }
            return null;
        }

        @Override
        public int getCount() {

            return int_items;

        }

        /**
         * This method returns the title of the tab according to the position.
         */


        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0 :
                    return "TRAINERS ";
                case 1 :
                    return "TRAINING PROGRAMS";

            }
            return null;
        }


    }

    public static String makeFragmentName(int viewpager, int index) {
        return "android:switcher:" + viewpager + ":" + index;
    }


    public static TodoFragment newInstance(String title) {
        f = new TodoFragment();
        Bundle b = new Bundle();
        b.putString("Title", title);
        f.setArguments(b);
        return f;
    }

    public static TodoFragment getInstance(){
        return f;
    }



}
