package com.example.maidou.netgirlpic.di.module;

import com.example.maidou.netgirlpic.AppContext;
import com.example.maidou.netgirlpic.di.ContextLife;
import com.example.maidou.netgirlpic.module.http.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

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
