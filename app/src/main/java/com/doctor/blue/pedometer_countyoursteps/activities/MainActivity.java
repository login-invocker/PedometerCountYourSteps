package com.doctor.blue.pedometer_countyoursteps.activities;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.fragment.app.FragmentTransaction;

import com.doctor.blue.pedometer_countyoursteps.R;
import com.doctor.blue.pedometer_countyoursteps.base.BaseActivity;
import com.doctor.blue.pedometer_countyoursteps.fragments.MonthFragment;
import com.doctor.blue.pedometer_countyoursteps.fragments.TodayFragment;
import com.doctor.blue.pedometer_countyoursteps.fragments.WeekFragment;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @BindView(R.id.tabLayout_main)
    TabLayout tabLayoutMain;
    @BindView(R.id.frame_main)
    FrameLayout frameMain;


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        initTabLayout();
    }

    private void initTabLayout() {
        tabLayoutMain.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                frameMain.removeAllViews();
                int tabPosition = tab.getPosition();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                if (tabPosition == 0) {
                    WeekFragment weekFragment = new WeekFragment();
                    transaction.replace(R.id.frame_main, weekFragment);
                } else if (tabPosition == 1) {
                    TodayFragment todayFragment = new TodayFragment();
                    transaction.replace(R.id.frame_main, todayFragment);
                } else {
                    MonthFragment monthFragment = new MonthFragment();
                    transaction.replace(R.id.frame_main, monthFragment);
                }
                transaction.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        TabLayout.Tab tab = tabLayoutMain.getTabAt(1);
        if (tab != null)
            tab.select();
    }

}
