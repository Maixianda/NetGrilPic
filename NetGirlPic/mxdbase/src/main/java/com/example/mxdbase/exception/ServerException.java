package com.example.mxdbase.exception;


import com.example.mxdbase.BaseApp;
import com.example.mxdbase.R;

/**
 * server exception. 40x 50x, etc
 * <p/>
 * Created by Wilson on 12/12/15.
 */
public class ServerException extends BaseException {
    private int mResponseCode;

    public ServerException() {
        super();
    }

    public ServerException(int responseCode) {
        super();
        this.mResponseCode = responseCode;
    }

    @Override
    public String getMessage() {
        if (mResponseCode != 0) {
            return BaseApp.me().getResources().getString(R.string.ex_server_error_with_code, mResponseCode);
        } else {
            return BaseApp.me().getResources().getString(R.string.ex_server_error);
        }
    }
}
