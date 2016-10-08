package com.example.mxdbase.ui.activity;

/**
 * 自定义onCreate生命周期
 * <p/>
 * Created by Tony on 9/30/15.
 */
public interface InitResources {

    void beforeInitView();

    void initView();

    void initListener();

    void initData();

}
