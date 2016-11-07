package com.example.maidou.netgirlpic;

import com.example.mxdbase.Config;
import com.example.mxdbase.util.Strings;

/**
 * Created by maidou on 2016/10/7.
 * 应用程序静态环境变量配置
 */

public class AppEnv {
    public final static String BASE_URL = BuildConfig.BASE_URL;//server url服务器域名
    public final static boolean isDebug = Strings.isEquals("debug", BuildConfig.BUILD_TYPE);// debug包为true, release包为false
    public static void init()
    {
        // App 数据保存目录
        Config.DATA_PATH = BuildConfig.DATA_PATH;
    }
}
