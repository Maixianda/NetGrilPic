package com.example.maidou.netgirlpic.ui.base;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.View;

import com.example.maidou.netgirlpic.R;
import com.example.mxdbase.ui.activity.BaseFragmentActivityBinding;
import com.example.mxdbase.ui.model.HeaderModel;
import com.example.mxdbase.util.Systems;

/**
 * Created by Administrator on 2016/10/9.
 * 说明:           每个项目独有的BaseFragmentActivity
 * 创建人:         maixianda
 * 创建时间:       2016/10/9 11:44
 */

public abstract class BaseFragmentActivtyBinding extends BaseFragmentActivityBinding implements HeaderModel.HeaderView{
    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        Systems.setBarColor(this, getResources().getColor(R.color.colorPrimaryDark));
        return super.onCreateView(name, context, attrs);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        //UiUtil.bindSwipeRefreshView(this, (SwipeRefreshLayout) findViewById(R.id.srv_refresh));
    }
}
