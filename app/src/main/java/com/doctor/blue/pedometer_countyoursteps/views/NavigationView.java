package com.doctor.blue.pedometer_countyoursteps.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.doctor.blue.pedometer_countyoursteps.R;

public class NavigationView extends LinearLayout {
    View view;
    ImageView navItemToday;
    ImageView navItemWeek;
    ImageView navItemMonth;
    public NavigationView(Context context) {
        super(context);
        init(context,null);
    }

    public NavigationView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public NavigationView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }
    private void init(Context context,AttributeSet attributeSet){
        view=View.inflate(context,R.layout.layout_navigation_view,this);
        navItemToday=view.findViewById(R.id.nav_today);
        navItemMonth=view.findViewById(R.id.nav_month);
        navItemWeek=view.findViewById(R.id.nav_week);

    }

}
