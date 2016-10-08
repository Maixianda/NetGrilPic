package com.example.maidou.netgirlpic.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maidou.netgirlpic.R;
import com.example.mxdbase.databinding.FragmentAnticipatesNewsBinding;
import com.example.mxdbase.ui.adapter.CommonFPagerAdapter;
import com.example.mxdbase.ui.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maidou on 2016/10/8.
 */

public class NewsAnticipateFragment extends BaseFragment implements View.OnClickListener {
    private CommonFPagerAdapter commonFPagerAdapter;
    private FragmentAnticipatesNewsBinding binding;
    private List<BaseFragment> fragments = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAnticipatesNewsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.fragment_anticipates_news;
    }

    @Override
    public void initView() {
        commonFPagerAdapter = new CommonFPagerAdapter(getActivity().getSupportFragmentManager(), fragments);
        binding.vpNews.setAdapter(commonFPagerAdapter);
        binding.vpNews.setOffscreenPageLimit(3);
    }

    @Override
    public void initListener() {
    }

    @Override
    public void initData() {

    }
}
