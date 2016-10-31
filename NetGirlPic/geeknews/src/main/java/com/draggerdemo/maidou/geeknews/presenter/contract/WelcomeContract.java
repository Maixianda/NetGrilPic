package com.draggerdemo.maidou.geeknews.presenter.contract;

import com.draggerdemo.maidou.geeknews.base.BasePresenter;
import com.draggerdemo.maidou.geeknews.base.BaseView;
import com.draggerdemo.maidou.geeknews.model.bean.WelcomeBean;

/**
 * Created by Administrator on 2016/10/31.
 * 说明:           欢迎页面的约定接口
 * 创建人:         maixianda
 * 创建时间:       2016/10/31 11:40
 */

public interface WelcomeContract {
    interface View extends BaseView {

        void showContent(WelcomeBean welcomeBean);

        void jumpToMain();

    }

    interface  Presenter extends BasePresenter<View> {

        void getWelcomeData();

    }
}
