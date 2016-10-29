package com.example.mxdbase.util;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mxdbase.BaseApp;
import com.example.mxdbase.R;

/**
 * Toast 辅助类
 * # UI 安全
 * <p/>
 * Created by Tony on 9/30/15.
 */
public class ToastHelper {

    private static Toast toast;
    private static ToastHelper toastHelper;
    private static Toast mLocationToast;

    Context context;
    String msg;
    /**
     * 弹出Toast消息
     *
     * @param charSequence
     */
    public static void showMessage(final Context context, CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            charSequence = "";
        }
        if (toast == null) {
            toast = Toast.makeText(context, charSequence, Toast.LENGTH_SHORT);
        } else {
            toast.setText(charSequence);
        }
        toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM, 0, Systems.dpToPx(context, 64));
        toast.show();
    }

    /**
     * 弹出Toast消息
     *
     * @param charSequence
     */
    public static void showMessageMiddle(final Context context, final CharSequence charSequence) {
        if (toast == null) {
            toast = Toast.makeText(context, charSequence, Toast.LENGTH_SHORT);
        } else {
            toast.setText(charSequence);
        }
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * 弹出Toast消息
     *
     * @param resId
     */

    public static void showMessageMiddle(Context context, int resId) {
        showMessageMiddle(context, context.getResources().getText(resId));
    }

    /**
     * 资源ID信息显示
     *
     * @param context
     * @param resId
     */
    public static void showMessage(Context context, int resId) {
        showMessage(context, context.getResources().getText(resId));
    }

    /**
     * 资源ID信息显示
     *
     * @param context
     * @param resId
     * @param duration Toast.LENGTH_SHORT | Toast.LENGTH_LONG
     */
    public static void showMessage(Context context, int resId, int duration) {
        showMessage(context, context.getResources().getText(resId), duration);
    }

    /**
     * 指定消息显示时间
     *
     * @param context
     * @param charSequence
     * @param duration     Toast.LENGTH_SHORT | Toast.LENGTH_LONG
     */
    public static void showMessage(final Context context, final CharSequence charSequence, final int duration) {
        if (toast == null) {
            toast = Toast.makeText(context, charSequence, duration);
        } else {
            toast.setText(charSequence);
        }
        toast.show();
    }


    /**
     * 取消所有toast
     */
    public static void cancel() {
        if (toast != null) {
            toast.cancel();
        }
    }


    public static void show(int resId) {
        show(BaseApp.me().getString(resId));
    }

    public static void show(String msg) {
        if (toastHelper == null) {
            toastHelper = new ToastHelper(BaseApp.me());
        }
        toastHelper.setText(msg);
        toastHelper.create().show();
    }

    public static void shortShow(String msg) {
        if (toastHelper == null) {
            toastHelper = new ToastHelper(BaseApp.me());
        }
        toastHelper.setText(msg);
        toastHelper.createShort().show();
    }

    public ToastHelper(Context context) {
        this.context = context;
    }

    public Toast create() {
        View contentView = View.inflate(context, R.layout.dialog_toast, null);
        TextView tvMsg = (TextView) contentView.findViewById(R.id.tv_toast_msg);
        toast = new Toast(context);
        toast.setView(contentView);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        tvMsg.setText(msg);
        return toast;
    }

    public Toast createShort() {
        View contentView = View.inflate(context, R.layout.dialog_toast, null);
        TextView tvMsg = (TextView) contentView.findViewById(R.id.tv_toast_msg);
        toast = new Toast(context);
        toast.setView(contentView);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        tvMsg.setText(msg);
        return toast;
    }

    public void show() {
        if (toast != null) {
            toast.show();
        }
    }

    public void setText(String text) {
        msg = text;
    }
}
