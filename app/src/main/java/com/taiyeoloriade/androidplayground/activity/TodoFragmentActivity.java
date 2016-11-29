package com.taiyeoloriade.androidplayground.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.taiyeoloriade.androidplayground.R;
import com.taiyeoloriade.androidplayground.fragment.CalendarFragment;
import com.taiyeoloriade.androidplayground.fragment.EasyFragment;
import com.taiyeoloriade.androidplayground.fragment.TodoFragment;
import com.taiyeoloriade.androidplayground.fragment.ViewTodoFragment;

import butterknife.BindView;

import static android.R.attr.thumbnail;

public class TodoFragmentActivity extends AppCompatActivity {

    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    Toolbar toolbar;
    private TodoSectionsPagerAdapter mSectionsPagerAdapter;
    TabLayout tabLayout;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_todo);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(" ");

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        setUpViews();



    }

    private void setUpViews() {


        mSectionsPagerAdapter = new TodoSectionsPagerAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(mSectionsPagerAdapter);

        tabLayout.setupWithViewPager(mViewPager);
    }



//    private FragmentManager.OnBackStackChangedListener getListener()
//    {
//        FragmentManager.OnBackStackChangedListener result = new FragmentManager.OnBackStackChangedListener()
//        {
//            public void onBackStackChanged()
//            {
//                FragmentManager manager = getSupportFragmentManager();
//
//                if (manager != null)
//                {
//                    ViewTodoFragment currFrag = (ViewTodoFragment) manager.findFragmentById(R.id.fragmentItem);
//
//                    currFrag.onFragmentResume();
//                }
//            }
//        };
//
//        return result;
//    }


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

    public class TodoSectionsPagerAdapter extends FragmentPagerAdapter {

        public TodoSectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(position == 0){
                return ViewTodoFragment.newInstance();
            } else if(position == 1) {
                return CalendarFragment.newInstance();
            } else {
                return ViewTodoFragment.newInstance();
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Todo List";
                case 1:
                    return "Calendar ";

            }
            return null;
        }
    }



}
