package com.example.maidou.netgirlpic.util;

import android.content.Context;

import com.example.maidou.netgirlpic.dto.Bean.MainBean;
import com.example.maidou.netgirlpic.http.API;
import com.example.maidou.netgirlpic.http.APICallback;
import com.example.maidou.netgirlpic.service.GirlPicService;

import retrofit.Call;


/**
 * Created by Administrator on 2016/11/7.
 * 说明:           获取美女图片数据工具类
 * 创建人:         maixianda
 * 创建时间:       2016/11/7 16:26
 */

public class GirlPicServiceUtil {
    private static GirlPicServiceUtil mGirlPicServiceUtil;
    private GirlPicService mGirlPicService;
    /**
     * 单例模式
     */
    public static GirlPicServiceUtil me()
    {
        if (mGirlPicServiceUtil==null)
        {
            mGirlPicServiceUtil = new GirlPicServiceUtil();
        }
        return mGirlPicServiceUtil;
    }

    /**
     * 获取一个网络请求对象
     */
    public GirlPicService getService() {
        if (mGirlPicService == null) {
            mGirlPicService = API.of(GirlPicService.class);
        }
        return mGirlPicService;
    }

    public void getGirlPicData(final Context context)
    {
        Call<MainBean> call = getService().getGirlPicCall(1,10);
        call.enqueue(new APICallback<MainBean>() {
            @Override
            public void onSuccess(MainBean mainBean) {

            }

            @Override
            public void onFailed(String message) {

            }

            @Override
            public void onFinish() {

            }
        });
    }
}
