package com.draggerdemo.maidou.geeknews.base;

import com.draggerdemo.maidou.geeknews.presenter.contract.WelcomeContract;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Administrator on 2016/10/31.
 * 说明:           基于Rx的Presenter封装,控制订阅的生命周期
 * 创建人:         maixianda
 * 创建时间:       2016/10/31 11:51
 */

public class RxPresenter<T extends BaseView> implements BasePresenter<T> {

    private T mView;
    private CompositeSubscription mCompositeSubscription;



    public void unSubscribe()
    {
        if (null != mCompositeSubscription)
        {
            mCompositeSubscription.unsubscribe();
        }
    }

    public void addSubscribe(Subscription subscription)
    {
        if (null == mCompositeSubscription)
        {
            mCompositeSubscription = new CompositeSubscription();
        }
    }
    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {

    }
}
