package com.example.mxdbase;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.orhanobut.logger.Logger;

/**
 * Created by maidou on 2016/10/7.
 * 应用程序基类
 */

public class BaseApp extends Application {
    private static BaseApp APP;

    public BaseApp() {
        APP = this;
    }

    /**
     * 单例
     *
     * @return
     */
    public static <T extends BaseApp> T me() {
        return (T) APP;
    }

    /**
     * 应用启动
     */
    @Override
    public void onCreate() {
        super.onCreate();

        APP = this;

        //TODO: uncomment this to print the log message about the lifecycle of activities.
        //监听应用程序activity的各个生命周期
//        registerActivityLifecycleCallbacks(new LifecycleLoggingCallbacks());
    }

    /**
     * 应用销毁
     */
    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    private final class LifecycleLoggingCallbacks implements ActivityLifecycleCallbacks {
        private final String TAG = "Lifecycle";

        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            Logger.d(activity.getLocalClassName() + " onCreated");
        }

        @Override
        public void onActivityStarted(Activity activity) {
            Logger.d(activity.getLocalClassName() + " onStarted");
        }

        @Override
        public void onActivityResumed(Activity activity) {
            Logger.d(activity.getLocalClassName() + " onResumed");
        }

        @Override
        public void onActivityPaused(Activity activity) {
            Logger.d(activity.getLocalClassName() + " onPaused");
        }

        @Override
        public void onActivityStopped(Activity activity) {
            Logger.d(activity.getLocalClassName() + " onStopped");
        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            Logger.d(activity.getLocalClassName() + " onSaveInstanceState");
        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            Logger.d(activity.getLocalClassName() + " onDestroyed");
        }
    }
}
