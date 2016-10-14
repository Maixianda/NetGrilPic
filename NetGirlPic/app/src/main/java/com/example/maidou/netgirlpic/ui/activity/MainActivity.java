package com.example.maidou.netgirlpic.ui.activity;

import android.databinding.DataBindingUtil;

import com.example.maidou.netgirlpic.R;
import com.example.maidou.netgirlpic.databinding.MainActivityBinding;
import com.example.maidou.netgirlpic.ui.base.BaseActivityBinding;
import com.example.maidou.netgirlpic.ui.base.BaseFragmentActivtyBinding;
import com.example.mxdbase.ui.model.HeaderModel;
import com.orhanobut.logger.Logger;

/**
 * Created by Administrator on 2016/10/9.
 * 说明:
 * 创建人:         maixianda
 * 创建时间:       2016/10/9 9:14
 */

public class MainActivity extends BaseActivityBinding {
    MainActivityBinding binding;
    HeaderModel header;
    @Override
    public void beforeInitView() {
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        setHeader();
        Logger.d("111");
//        setFooter();
    }

    private void setHeader() {
        header = new HeaderModel(this);
        header.setMidTitle("title");
        binding.setHeader(header);
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

    @Override
    public void onBackClicked() {

    }

    @Override
    public void onTitleClicked() {

    }

    @Override
    public void onMenuClicked() {

    }
}
