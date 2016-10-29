package com.example.maidou.netgirlpic.di.Component;

import com.example.maidou.netgirlpic.AppContext;
import com.example.maidou.netgirlpic.di.ContextLife;
import com.example.maidou.netgirlpic.di.module.AppModule;
import com.example.maidou.netgirlpic.module.http.RetrofitHelper;
import com.example.mxdbase.BaseApp;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2016/10/24.
 * 说明:
 * 创建人:         maixianda
 * 创建时间:       2016/10/24 17:09
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    @ContextLife("NetGirlPicApplication")
    AppContext getContext();  // 提供App的Context

    RetrofitHelper retrofitHelper();  //提供http的帮助类

    //RealmHelper realmHelper();    //提供数据库帮助类
}
