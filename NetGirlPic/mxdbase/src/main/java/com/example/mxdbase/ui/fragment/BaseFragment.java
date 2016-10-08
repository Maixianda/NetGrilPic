package com.example.mxdbase.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mxdbase.R;
import com.example.mxdbase.common.UIHelper;

/**
 * Created by maidou on 2016/10/8.
 *  Fragment - 基类
 */

public abstract class BaseFragment extends Fragment implements InitResources{

    private String title;

    public String getFragmentTitle() {
        return title;
    }

    public void setFragmentTitle(String title) {
        this.title = title;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(getLayoutResourceId(),container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        UIHelper.bindActionBack(getActivity(),getView().findViewById(R.id.action_back));

        initView();
        initListener();
        initData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    /**
     * Fragment返回事件
     */
    public boolean onBackPressed() {
        return false;
    }
}
