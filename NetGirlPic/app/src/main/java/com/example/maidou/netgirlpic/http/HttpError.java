package com.example.maidou.netgirlpic.http;

/**
 * Created by Administrator on 2016/11/7.
 * 说明:           retrofit返回状态错误类
 * 创建人:         maixianda
 * 创建时间:       2016/11/7 14:23
 */

public class HttpError {
    private boolean error;

    public HttpError(boolean error) {
        this.error = error;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
