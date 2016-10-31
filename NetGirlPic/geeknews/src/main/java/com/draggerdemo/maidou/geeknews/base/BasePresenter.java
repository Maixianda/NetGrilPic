package com.draggerdemo.maidou.geeknews.base;

/**
 * Created by Administrator on 2016/10/24.
 * 说明:
 * 创建人:         maixianda
 * 创建时间:       2016/10/24 17:58
 */

public interface BasePresenter<T extends BaseView> {
    void attachView(T view);

    void detachView();
}
