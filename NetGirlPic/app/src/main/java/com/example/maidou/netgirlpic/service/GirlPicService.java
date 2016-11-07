package com.example.maidou.netgirlpic.service;

import com.example.maidou.netgirlpic.dto.BaseDTO;
import com.example.maidou.netgirlpic.dto.Bean.MainBean;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Administrator on 2016/11/7.
 * 说明:
 * 创建人:         maixianda
 * 创建时间:       2016/11/7 16:30
 */

public interface GirlPicService {

    /**
     * 获取美女图片接口
     * @param pageNum 当前页
     * @param pageSize 每页数量
     * @return
     */
    @FormUrlEncoded
    @POST("article/findArticleSearchAll.do")
    Call<MainBean> getGirlPicCall(@Field("pageNum") int pageNum, @Field("pageSize") int pageSize);
}
