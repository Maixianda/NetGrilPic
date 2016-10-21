package com.example.maidou.netgirlpic.di.module;

import com.example.maidou.netgirlpic.AppContext;

import dagger.Module;

/**
 * Created by Administrator on 2016/10/21.
 * 说明:
 * 创建人:         maixianda
 * 创建时间:       2016/10/21 17:59
 */
@Module
public class AppModule {
    private final AppContext application;


    public AppModule(AppContext application) {
        this.application = application;
    }

}
