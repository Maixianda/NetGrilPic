package com.draggerdemo.maidou.geeknews.di.module;

import com.draggerdemo.maidou.geeknews.AppContext;
import com.draggerdemo.maidou.geeknews.di.ContextLife;
import com.draggerdemo.maidou.geeknews.http.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016/10/21.
 * 说明:
 * 创建人:         maixianda
 * 创建时间:       2016/10/21 17:59
 */
@Module
public class AppModule {
    private final AppContext appContext;

    public AppModule(AppContext application) {
        this.appContext = application;
    }

    @Singleton
    @Provides
    @ContextLife("NetGirlPicApplication")
    AppContext provideApplicationContext() {
        return appContext;
    }

    @Singleton
    @Provides
    RetrofitHelper provideRetrofitHelper(){return new RetrofitHelper();}
}
