package com.draggerdemo.maidou.geeknews.http;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/10/22.
 * 说明:           Retrofit辅助类
 * 创建人:         maixianda
 * 创建时间:       2016/10/22 15:15
 */

public class RetrofitHelper {
    private static OkHttpClient okHttpClient = null;
    private static ZhihuApis zhihuApiService = null;
    private static GankApis gankApiService = null;
    private static WeChatApis wechatApiService = null;

    public RetrofitHelper() {
        init();
    }

    private void init() {
        zhihuApiService = getZhihuApiService();
        gankApiService = getGankApiService();
        wechatApiService = getWechatApiService();
    }

    /**
     * 获取Wechat接口的retrofit服务
     * @return
     */
    private WeChatApis getWechatApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                                        .client(okHttpClient)
                                        .baseUrl(WeChatApis.HOST)
                                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                                        .addConverterFactory(GsonConverterFactory.create())
                                        .build();
        return retrofit.create(WeChatApis.class);
    }

    /**
     * 获取Gank接口的retrofit服务
     * @return
     */
    private GankApis getGankApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                                .client(okHttpClient)
                                .baseUrl(GankApis.HOST)
                                .addConverterFactory(GsonConverterFactory.create())
                                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                                .build();
        return retrofit.create(GankApis.class);
    }

    /**
     * 获取知乎接口的retrofit服务
     * @return
     */
    private ZhihuApis getZhihuApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                                        .baseUrl(ZhihuApis.HOST)
                                        .client(okHttpClient)
                                        .addConverterFactory(GsonConverterFactory.create())
                                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                                        .build();
        return retrofit.create(ZhihuApis.class);
    }
}
