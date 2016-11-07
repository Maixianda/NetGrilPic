package com.example.maidou.netgirlpic.http;

import android.os.Build;

import com.example.maidou.netgirlpic.AppContext;
import com.example.maidou.netgirlpic.AppEnv;
import com.example.maidou.netgirlpic.dto.BaseDTO;
import com.example.mxdbase.util.Systems;
import com.orhanobut.logger.Logger;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;


/**
 * Created by Administrator on 2016/11/7.
 * 说明:
 * 创建人:         maixianda
 * 创建时间:       2016/11/7 13:59
 */

public class API {
    /**
     * API base
     */
    public final static String API_BASE_URL = AppEnv.BASE_URL;

    /**
     * okhttp
     */
    private static OkHttpClient httpClient;

    /**
     * retrofit builder
     */
    private static Retrofit.Builder builder;

    /**
     * keep service singleton,只保留一个retrofit service
     */
    private static Map<Class, Object> mServices;

    /**
     * retrofit错误拦截
     */
    private static Deque<ErrorInterceptor> interceptors;

    /**
     * retrofit错误拦截接口
     */
    private interface ErrorInterceptor {
        <T> HttpError intercept(T body);
    }

    /**
     * 初始化okhttp,retrofit,sevice,interceptors错误拦截器
     */
    static {
        httpClient = new OkHttpClient();
        builder = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());
        mServices = new ConcurrentHashMap<>();
        interceptors = new LinkedList<>();

        /**
         * 默认拦截器,在每个请求header添加android版本,应用程序版本
         */
        final Interceptor defaultInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                String androidVersion = "android: Build.VERSION.RELEASE=" + Build.VERSION.RELEASE + ",Build.VERSION.SDK_INT = " + Build.VERSION.SDK_INT;
                String appVersion = Systems.getVersionName(AppContext.me());

                Request request = chain.request()
                        .newBuilder()
                        .addHeader("androidVersion", androidVersion)
                        .addHeader("appVersion", appVersion)
                        .build();
                return chain.proceed(request);
            }
        };
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Logger.d(message);
            }
        });
        /**
         * 根据生成类型判断是否打印请求
         */
        httpLoggingInterceptor.setLevel(AppEnv.isDebug ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);

        //添加拦截器
        httpClient.interceptors().add(defaultInterceptor);
        httpClient.interceptors().add(httpLoggingInterceptor);
        addResponseInterceptors();
    }

    /**
     * 添加错误消息拦截
     * 错误消息拦截 error,配合{@link com.example.maidou.netgirlpic.dto.BaseDTO}使用
     *
     */
    private static void addResponseInterceptors() {
        interceptors.add(new ErrorInterceptor() {
            @Override
            public <T> HttpError intercept(T body) {
                if (body instanceof BaseDTO)
                {
                    BaseDTO baseDTO = (BaseDTO) body;
                    if (baseDTO.isError())
                    {
                        return new HttpError(baseDTO.isError());
                    }
                }
                return null;
            }
        });
    }

    /**
     * 创建一个api service(单例)
     *
     * @param cls 对应的service.class
     * @param <S> service的类型,例如之前的例子githubservice类类型
     * @return
     */
    public static <S> S of(Class<S> cls) {
        if (mServices.containsKey(cls)) {
            return (S) mServices.get(cls);
        }

        Retrofit retrofit = builder.client(httpClient).build();
        S service = retrofit.create(cls);
        mServices.put(cls, service);
        return service;
    }

    /**
     * 根据响应参数body遍历interceptors进行错误拦截
     * @param body
     * @param <T>
     * @return
     */
    public static <T> HttpError intercept(T body) {
        for (ErrorInterceptor r : interceptors) {
            HttpError error = r.intercept(body);
            if (error != null) {
                return error;
            }
        }
        return null;
    }
}
