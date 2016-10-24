package com.example.maidou.netgirlpic.ui.base.GeekNews;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by Administrator on 2016/10/24.
 * 说明:           MVP activity基类
 * 创建人:         maixianda
 * 创建时间:       2016/10/24 17:56
 */

public abstract class BaseActivity<T extends BasePresenter> extends SupportActivity implements BaseView{
    protected Activity mContext;

    @Inject
    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLaout());
        mContext = this;
        initInject();
        if (mPresenter != null)
            mPresenter.attachView(this);
    }
    protected abstract void initInject();
    protected abstract int getLaout();
}
