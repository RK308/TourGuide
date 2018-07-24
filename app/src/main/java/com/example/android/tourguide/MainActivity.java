package com.example.android.tourguide;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Set the toolbar and the back button
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Find the viewpager that will allow the user  to swipe between fragments
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    //    setupTabIcons();

     //   private void setupTabIcons(){
            View headerView = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.custom_tab, null, false);

            LinearLayout linearLayout1 = (LinearLayout) headerView.findViewById(R.id.tab_icon1);
            LinearLayout linearLayout2 = (LinearLayout) headerView.findViewById(R.id.tab_icon2);
            LinearLayout linearLayout3 = (LinearLayout) headerView.findViewById(R.id.tab_icon3);
            LinearLayout linearLayout4 = (LinearLayout) headerView.findViewById(R.id.tab_icon4);

            tabLayout.getTabAt(0).setCustomView(linearLayout1);
            tabLayout.getTabAt(1).setCustomView(linearLayout2);
            tabLayout.getTabAt(2).setCustomView(linearLayout3);
            tabLayout.getTabAt(3).setCustomView(linearLayout4);

   //              tabLayout.getTabAt(0).getIcon().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN);
   //              tabLayout.getTabAt(1).getIcon().setColorFilter(Color.parseColor("#e8eaf6"),PorterDuff.Mode.SRC_IN);

  //          tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

  //              @Override
    //            public void onTabSelected(TabLayout.Tab tab) {
             //       super.onTabSelected(tab);
              //      tabIconColor = ContextCompat.getColor(context, R.color.tabSelectedIconColor);
   //                 tab.getIcon().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN);
  //              }

   //         @Override
     //       public void onTabUnselected(TabLayout.Tab tab) {
  //              tab.getIcon().setColorFilter(Color.parseColor("#e8eaf6"), PorterDuff.Mode.SRC_IN);
    //        }

  //          @Override
    //        public void onTabReselected(TabLayout.Tab tab) {

      //      }
        //    });
  //      }
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new AttractionFragment(), "ATTRACTIONS");
        adapter.addFragment(new MuseumFragment(), "MUSEUMS");
        adapter.addFragment(new HotelFragment(), "HOTELS");
        adapter.addFragment(new RestaurantFragment(), "RESTAURANTS");

        // set the adapter onto the view pager
        viewPager.setAdapter(adapter);
    }

    // Custom Adapter class provides fragments required for the view pager.
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        /**
         * @param position of fragment
         * @return fragment
         */
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        /**
         * @return the number of fragments
         */
        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        /**
         * @param position of fragment
         * @return page title
         */
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);

        }
    }
}



