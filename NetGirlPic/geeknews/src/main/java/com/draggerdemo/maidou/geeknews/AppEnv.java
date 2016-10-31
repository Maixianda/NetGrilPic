package com.draggerdemo.maidou.geeknews;

import com.example.mxdbase.Config;

/**
 * Created by maidou on 2016/10/7.
 * 应用程序静态环境变量配置
 */

public class AppEnv {
    public static void init()
    {
        // App 数据保存目录
        Config.DATA_PATH = BuildConfig.DATA_PATH;
    }
}
