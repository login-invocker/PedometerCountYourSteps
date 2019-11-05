package com.doctor.blue.pedometer_countyoursteps.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {
    protected View view;//view
    private Unbinder unbinder;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        init();
        return view;
    }

    public abstract int getLayoutId();
    public abstract void init();
    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
