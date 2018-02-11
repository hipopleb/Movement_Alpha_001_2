package com.example.ftors.movementalpha01_1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ActionBarContainer;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.example.ftors.movementalpha01_1.Fragment.Tab1Fragment;
import com.example.ftors.movementalpha01_1.Fragment.Tab2Fragment;
import com.example.ftors.movementalpha01_1.Fragment.Tab3Fragment;
import com.example.ftors.movementalpha01_1.Fragment.Tab4Fragment;
import com.example.ftors.movementalpha01_1.Fragment.Tab5Fragment;


public class  MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    Toolbar mtoolbar;
    BottomNavigationView bottomNavigationView;

    //This is our viewPager
    private ViewPager viewPager;



    //Fragments

    Tab1Fragment tab1Fragment;
    Tab2Fragment tab2Fragment;
    Tab3Fragment tab3Fragment;
    Tab4Fragment tab4Fragment;
    Tab5Fragment tab5Fragment;

    MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         mtoolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);


        //Initializing viewPager
        viewPager = (ViewPager) findViewById(R.id.viewpager);


        // viewPager.setCurrentItem(0);
        //viewPager.setId(R.id.fragment_tab1);
        //Initializing the bottomNavigationView
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.getMenu().getItem(2).setChecked(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.donatorpage:
                                viewPager.setCurrentItem(0);
                                break;
                            case R.id.feedpage:
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.startpage:
                                viewPager.setCurrentItem(2);
                                break;
                            case R.id.insamlatpage:
                                viewPager.setCurrentItem(3);
                                break;
                            case R.id.profilpage:
                                viewPager.setCurrentItem(4);
                                break;

                        }
                        return false;
                    }
                });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else
                {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: "+position);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

       /*  //Disable ViewPager Swipe

       viewPager.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                return true;
            }
        });

        */
        setupViewPager(viewPager);
        viewPager.setCurrentItem(2);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        tab1Fragment = new Tab1Fragment();
        tab2Fragment = new Tab2Fragment();
        tab3Fragment = new Tab3Fragment();
        tab4Fragment = new Tab4Fragment();
        tab5Fragment = new Tab5Fragment();

        adapter.addFragment(tab1Fragment);
        adapter.addFragment(tab2Fragment);
        adapter.addFragment(tab3Fragment);
        adapter.addFragment(tab4Fragment);
        adapter.addFragment(tab5Fragment);
        viewPager.setAdapter(adapter);
    }

}
