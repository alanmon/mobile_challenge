package com.example.medbuddy;

import java.util.Locale;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class P_childContralPanel extends FragmentActivity implements
                ActionBar.TabListener {

        /**
         * The {@link android.support.v4.view.PagerAdapter} that will provide
         * fragments for each of the sections. We use a
         * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
         * will keep every loaded fragment in memory. If this becomes too memory
         * intensive, it may be best to switch to a
         * {@link android.support.v4.app.FragmentStatePagerAdapter}.
         */
        SectionsPagerAdapter mSectionsPagerAdapter;

        /**
         * The {@link ViewPager} that will host the section contents.
         */
        ViewPager mViewPager;

        @SuppressLint("NewApi")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_p_child_contral_panel);

                // Set up the action bar.
                final ActionBar actionBar = getActionBar();
                actionBar.setTitle("Control Panel");
                actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

                // Create the adapter that will return a fragment for each of the three
                // primary sections of the app.
                mSectionsPagerAdapter = new SectionsPagerAdapter(
                                getSupportFragmentManager());

                // Set up the ViewPager with the sections adapter.
                mViewPager = (ViewPager) findViewById(R.id.pager);
                mViewPager.setAdapter(mSectionsPagerAdapter);

                // When swiping between different sections, select the corresponding
                // tab. We can also use ActionBar.Tab#select() to do this if we have
                // a reference to the Tab.
                mViewPager
                                .setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
                                        @Override
                                        public void onPageSelected(int position) {
                                                actionBar.setSelectedNavigationItem(position);
                                        }
                                });

                actionBar.addTab(actionBar.newTab().setIcon(R.drawable.btn_med).setTabListener(this));
                actionBar.addTab(actionBar.newTab().setIcon(R.drawable.btn_reward).setTabListener(this));
                actionBar.addTab(actionBar.newTab().setIcon(R.drawable.btn_history).setTabListener(this));
                actionBar.addTab(actionBar.newTab().setIcon(R.drawable.btn_log).setTabListener(this));
                actionBar.addTab(actionBar.newTab().setIcon(R.drawable.btn_profile).setTabListener(this));
                android.app.FragmentManager fmFragmentManager=getFragmentManager();
                fmFragmentManager.popBackStack();
                //TODO::change to action bar to gray
                //actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_launcher));
                //TODO::change the tab color to gray
                //actionBar.setStackedBackgroundDrawable(getResources().getDrawable(
            //        R.drawable.ic_launcher));

                /*
                // For each of the sections in the app, add a tab to the action bar.
                for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
                        // Create a tab with text corresponding to the page title defined by
                        // the adapter. Also specify this Activity object, which implements
                        // the TabListener interface, as the callback (listener) for when
                        // this tab is selected.
                        actionBar.addTab(actionBar.newTab()
                                        .setText(mSectionsPagerAdapter.getPageTitle(i))//add icon over here
                                        .setTabListener(this));
                }
                */
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case android.R.id.home:
                    // app icon in action bar clicked; go home
                    Intent intent = new Intent(this, P_childList.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
                // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.p_child_contral_panel, menu);
                return true;
        }

        @Override
        public void onTabSelected(ActionBar.Tab tab,
                        FragmentTransaction fragmentTransaction) {
                // When the given tab is selected, switch to the corresponding page in
                // the ViewPager.
                mViewPager.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab,
                        FragmentTransaction fragmentTransaction) {
        }

        @Override
        public void onTabReselected(ActionBar.Tab tab,
                        FragmentTransaction fragmentTransaction) {
        }

        /**
         * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
         * one of the sections/tabs/pages.
         */
        public class SectionsPagerAdapter extends FragmentPagerAdapter {

                public SectionsPagerAdapter(FragmentManager fm) {
                        super(fm);
                }

                @Override
                public Fragment getItem(int position) {
                        // getItem is called to instantiate the fragment for the given page.
                        // Return a DummySectionFragment (defined as a static inner class
                        // below) with the page number as its lone argument.
                        /*Fragment fragment = new DummySectionFragment();
                        Toast.makeText(MainActivity.this,"position"+Integer.toString(position), Toast.LENGTH_LONG).show();
                        Bundle args = new Bundle();
                        args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
                        fragment.setArguments(args);
                        return fragment;
                        */
                        if (position == 0) {
                                Fragment fragment0 = new Medication();

                                return fragment0;
                        }
                        else if(position == 1)
                        {
                                Fragment listofMed = new Reward();
                                return  listofMed;

                        }
                        else if(position == 2){
                                Fragment fragment2 = new History();
                                return fragment2;
                        }
                        else if(position == 3){
                                Fragment fragment3 = new Quicklog();
                                return fragment3;
                        }
                        else if(position == 4){
                                Fragment fragment3 = new Profile();
                                return fragment3;
                        }
                        else {
                                return null;
                        }
                }

                @Override
                public int getCount() {
                        // Show 2 total pages.
                        return 5;
                }

                @Override
                public CharSequence getPageTitle(int position) {
                        Locale l = Locale.getDefault();
                        switch (position) {
                        case 0:
                                return getString(R.string.title_section0).toUpperCase(l);
                        case 1:
                                return getString(R.string.title_section1).toUpperCase(l);
                        case 2:
                                return getString(R.string.title_section2).toUpperCase(l);
                        case 3:
                                return getString(R.string.title_section3).toUpperCase(l);
                        }
                        return null;
                }
        }





}