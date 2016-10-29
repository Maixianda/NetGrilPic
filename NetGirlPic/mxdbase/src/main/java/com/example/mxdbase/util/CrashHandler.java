package com.example.mxdbase.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.example.mxdbase.AppManager;
import com.example.mxdbase.BaseApp;
import com.orhanobut.logger.Logger;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by Administrator on 2016/10/14.
 * 说明:
 * 创建人:         maixianda
 * 创建时间:       2016/10/14 16:51
 */

public class CrashHandler implements Thread.UncaughtExceptionHandler {

    /**
     * 系统默认的未捕抓异常处理类
     *
     * 用CrashHandler替代系统默认未捕抓异常处理类,所以改字段用来保存系统默认未捕抓异常处理类
     */
    private static Thread.UncaughtExceptionHandler defaultHandler = null;

    private Context context = null;

    public CrashHandler(Context context) {
        this.context = context;
    }

    /**
     * 初始化异常捕抓类
     *
     * 替换保存默认的异常捕抓类
     * @param crashHandler
     */
    public static void  init(CrashHandler crashHandler)
    {
        defaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(crashHandler);
    }

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        System.out.println(throwable.toString());
        Logger.e(throwable.toString());
        Logger.e(collectCrashDeviceInfo());
        Logger.e(getCrashInfo(throwable));
        // TODO: 2016/10/14 17:45 要把这些错误信息保存到文件中
        // 调用系统错误机制
        defaultHandler.uncaughtException(thread, throwable);
        ToastHelper.shortShow("抱歉,程序发生异常即将退出");
        AppManager.exitApp();
    }

    /**
     * 得到程序崩溃的详细信息
     */
    public String getCrashInfo(Throwable ex) {
        Writer result = new StringWriter();
        PrintWriter printWriter = new PrintWriter(result);
        ex.setStackTrace(ex.getStackTrace());
        ex.printStackTrace(printWriter);
        return result.toString();
    }

    /**
     * 收集程序崩溃的设备信息
     */
    private String collectCrashDeviceInfo() {
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), PackageManager.GET_ACTIVITIES);
            String versionName = pi.versionName;
            String model = android.os.Build.MODEL;
            String androidVersion = android.os.Build.VERSION.RELEASE;
            String manufacturer = android.os.Build.MANUFACTURER;
            return versionName + "  " + model + "  " + androidVersion + "  " + manufacturer;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


}
