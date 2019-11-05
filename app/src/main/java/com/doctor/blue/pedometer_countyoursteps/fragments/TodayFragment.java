package com.doctor.blue.pedometer_countyoursteps.fragments;

import com.doctor.blue.pedometer_countyoursteps.R;
import com.doctor.blue.pedometer_countyoursteps.base.BaseFragment;
import com.doctor.blue.pedometer_countyoursteps.views.WaveView;

import butterknife.BindView;

public class TodayFragment extends BaseFragment {

    @BindView(R.id.wave_view_today)
    WaveView waveViewToday;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_today;
    }

    @Override
    public void init() {

    }


}
