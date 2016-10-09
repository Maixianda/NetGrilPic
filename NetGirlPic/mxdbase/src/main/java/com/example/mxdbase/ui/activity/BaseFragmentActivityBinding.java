package com.example.mxdbase.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.View;

import com.example.mxdbase.AppManager;
import com.example.mxdbase.R;
import com.example.mxdbase.common.UIHelper;
import com.example.mxdbase.util.Systems;

/**
 * Created by Administrator on 2016/10/9.
 * 说明:
 * 创建人:         maixianda
 * 创建时间:       2016/10/9 10:33
 */

public abstract class BaseFragmentActivityBinding extends FragmentActivity implements InitResources {
    private Fragment currentFragment;

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        Systems.setBarColor(this,R.color.colorPrimaryDark);
        return super.onCreateView(parent, name, context, attrs);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.addActivity(this);
        beforeInitView();
        initView();
        initListener();
        initData();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        //绑定headview后退按钮
        UIHelper.bindActionBack(this,findViewById(R.id.action_back));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.removeActivity(this);
    }

    /**
     * 显示Fragment到容器中
     *
     * @param res
     * @param fragment
     * @param tag
     */
    protected void showFragment(int res, Fragment fragment, String tag) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(res, fragment, tag);
        transaction.commit();
        getSupportFragmentManager().executePendingTransactions();
        currentFragment = fragment;
    }
}
