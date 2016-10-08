package com.example.maidou.netgirlpic.ui;

import android.databinding.DataBindingUtil;

import com.example.maidou.netgirlpic.R;
import com.example.maidou.netgirlpic.databinding.ActivitySplashBinding;
import com.example.mxdbase.ui.activity.BaseActivity;

public class SplashActivity extends BaseActivity {
    ActivitySplashBinding binding;
    @Override
    public void beforeInitView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }
}
