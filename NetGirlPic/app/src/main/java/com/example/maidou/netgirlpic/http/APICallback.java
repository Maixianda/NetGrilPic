package com.example.maidou.netgirlpic.http;

import com.example.mxdbase.exception.NetworkException;
import com.example.mxdbase.exception.ServerException;
import com.example.mxdbase.util.Strings;
import com.orhanobut.logger.Logger;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Administrator on 2016/11/7.
 * 说明:
 * 创建人:         maixianda
 * 创建时间:       2016/11/7 16:45
 */

public abstract class APICallback<T> implements Callback<T> {
    @Override
    public void onResponse(Response<T> response, Retrofit retrofit) {
        Logger.d("response.code()="+response.code());
        //判断http错误码
        if (response.code()<300)
        {
            //无返回内容
            if (response.body()==null)
            {
                Logger.e("empty response, message:" + response.message());
                if (Strings.isNotEmpty(response.message())) {
                    onFailed(response.message());
                } else {
                    onFailed(new NetworkException(null).getMessage());
                }
                onFinish();
                return;
            }

            //拦截json中的错误信息
            HttpError error = API.intercept(response.body());
            if (error != null) {
                Logger.d("intercept http error:" + error);
                onFailed("接口返回错误"/*error.getMessage()*/);
                onFinish();
                return;
            }

            //请求正常返回
            onSuccess(response.body());
            onFinish();
        }
        else //http错误码为30x 40x 50x
        {
            onFailed(new ServerException(response.code()).getMessage());
            onFinish();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        //一般是一些网络异常
        NetworkException exception = new NetworkException(t);
        Logger.w("network occurs failure:", exception);
        onFailed(exception.getMessage());
        onFinish();
    }

    /**
     * 请求成功
     *
     * @param t
     */
    public abstract void onSuccess(T t);

    /**
     * 请求失败
     *
     * @param message 简单点只返回必要的message, ui层不再关心code.
     */
    public abstract void onFailed(String message);

    /**
     * 请求完成, 成功与否都执行
     */
    public abstract void onFinish();
}
