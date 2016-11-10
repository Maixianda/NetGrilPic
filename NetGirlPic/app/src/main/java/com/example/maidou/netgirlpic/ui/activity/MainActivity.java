package com.example.maidou.netgirlpic.ui.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.maidou.netgirlpic.Entity.Item;
import com.example.maidou.netgirlpic.R;
import com.example.maidou.netgirlpic.databinding.MainActivityBinding;
import com.example.maidou.netgirlpic.dto.Bean.MainBean;
import com.example.maidou.netgirlpic.http.APICallback;
import com.example.maidou.netgirlpic.ui.adapter.MainActivityAdapter;
import com.example.maidou.netgirlpic.ui.base.BaseActivityBinding;

import com.example.maidou.netgirlpic.util.GirlPicServiceUtil;
import com.example.mxdbase.ui.model.HeaderModel;
import com.orhanobut.logger.Logger;

import retrofit.Call;

/**
 * Created by Administrator on 2016/10/9.
 * 说明:
 * 创建人:         maixianda
 * 创建时间:       2016/10/9 9:14
 */

public class MainActivity extends BaseActivityBinding {
    MainActivityBinding binding;
    private MainActivityAdapter mainActivityAdapter;
    HeaderModel header;

    @Override
    public void beforeInitView() {
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        setHeader();
    }

    private void setHeader() {
        header = new HeaderModel(this);
        header.setMidTitle("title");
        binding.setHeader(header);
    }

    @Override
    public void initView() {
        mainActivityAdapter = new MainActivityAdapter(this);
        binding.rcv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        binding.rcv.setAdapter(mainActivityAdapter);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        Call<MainBean> call = GirlPicServiceUtil.me().getService().getGirlPicCall(1,10);
        call.enqueue(new APICallback<MainBean>() {
            @Override
            public void onSuccess(MainBean mainBean) {
                Logger.d(mainBean);
            }

            @Override
            public void onFailed(String message) {

            }

            @Override
            public void onFinish() {

            }
        });
    }

    @Override
    public void onBackClicked() {

    }

    @Override
    public void onTitleClicked() {

    }

    @Override
    public void onMenuClicked() {

    }
}
