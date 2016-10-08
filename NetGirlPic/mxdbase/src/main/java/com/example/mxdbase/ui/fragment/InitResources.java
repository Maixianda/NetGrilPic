package com.example.mxdbase.ui.fragment;

/**
 * Created by maidou on 2016/10/8.
 * 初始化fragment资源借口
 */

public interface InitResources {

    int getLayoutResourceId();

    void initView();

    void initListener();

    void initData();
}
