package com.draggerdemo.maidou.geeknews;

import android.content.Context;
import android.support.multidex.MultiDex;

import com.draggerdemo.maidou.geeknews.di.Component.AppComponent;
import com.draggerdemo.maidou.geeknews.di.Component.DaggerAppComponent;
import com.draggerdemo.maidou.geeknews.di.module.AppModule;
import com.example.mxdbase.BaseApp;

/**
 * Created by maidou on 2016/10/7.
 * 继承自库的应用程序基类
 */
public class AppContext extends BaseApp {
    // TODO: 2016/10/7 记录登陆用户
    // TODO: 2016/10/7 升级弹窗

    @Override
    public void onCreate() {
        super.onCreate();
        AppEnv.init();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    /**
     * 获取上一文环境实例
     *
     * @return
     */
    public static AppContext me() {
        return BaseApp.me();
    }

    // TODO: 2016/10/17 10:06 不是很懂 AppComponent 是什么
    public static AppComponent getAppComponent(){
        return DaggerAppComponent.builder()
                .appModule(new AppModule((AppContext)APP))
                .build();
    }
}
