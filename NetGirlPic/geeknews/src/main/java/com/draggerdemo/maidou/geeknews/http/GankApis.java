package com.draggerdemo.maidou.geeknews.http;

/**
 * Created by Administrator on 2016/10/22.
 * 说明:           Gank接口类
 *                 主要就是用retrofit封装gank的接口
 * 创建人:         maixianda
 * 创建时间:       2016/10/22 15:15
 */

public interface GankApis {

    String HOST = "http://gank.io/api/";

    /**
     * 技术文章列表
     */
//    @GET("data/{tech}/{num}/{page}")
//    Observable<GankHttpResponse<List<GankItemBean>>> getTechList(@Path("tech") String tech, @Path("num") int num, @Path("page") int page);

    /**
     * 妹纸列表
     */
//    @GET("data/福利/{num}/{page}")
//    Observable<GankHttpResponse<List<GankItemBean>>> getGirlList(@Path("num") int num, @Path("page") int page);

    /**
     * 随机妹纸图
     */
//    @GET("random/data/福利/{num}")
//    Observable<GankHttpResponse<List<GankItemBean>>> getRandomGirl(@Path("num") int num);

    /**
     * 搜索
     */
//    @GET("search/query/{query}/category/{type}/count/{count}/page/{page}")
//    Observable<GankHttpResponse<List<GankSearchItemBean>>> getSearchList(@Path("query") String query, @Path("type") String type, @Path("count") int num, @Path("page") int page);

}
