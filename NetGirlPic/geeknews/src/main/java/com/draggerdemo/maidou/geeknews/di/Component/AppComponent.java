package com.draggerdemo.maidou.geeknews.di.Component;

import com.draggerdemo.maidou.geeknews.AppContext;
import com.draggerdemo.maidou.geeknews.di.ContextLife;
import com.draggerdemo.maidou.geeknews.di.module.AppModule;
import com.draggerdemo.maidou.geeknews.http.RetrofitHelper;

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
