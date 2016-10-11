package com.example.maidou.netgirlpic.ui.base;


import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;

import com.example.maidou.netgirlpic.R;
import com.example.maidou.netgirlpic.util.UiUtil;
import com.example.mxdbase.ui.activity.BaseActivity;
import com.example.mxdbase.ui.model.HeaderModel;
import com.example.mxdbase.util.Colors;
import com.example.mxdbase.util.Systems;

/**
 * Created by Aaron on 11/10/15.
 * Activity 基类 - 无右滑返回上一页效果
 */
public abstract class BaseActivityBinding extends BaseActivity implements HeaderModel.HeaderView {
    public HeaderModel header;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Systems.setBarColor(this, Colors.RED_FA4141);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        UiUtil.bindSwipeRefreshView(this, (SwipeRefreshLayout) findViewById(R.id.srv_refresh));
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
