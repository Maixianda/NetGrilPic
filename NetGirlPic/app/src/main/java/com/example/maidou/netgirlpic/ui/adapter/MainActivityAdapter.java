package com.example.maidou.netgirlpic.ui.adapter;

import android.app.Activity;

import com.example.maidou.netgirlpic.R;
import com.example.maidou.netgirlpic.databinding.ItemIvBinding;
import com.example.maidou.netgirlpic.dto.MainDto;
import com.example.mxdbase.core.image.PhotoLoader;
import com.example.mxdbase.ui.adapter.v7.ListAdapter;
import com.example.mxdbase.ui.adapter.v7.ViewHolder.BaseViewHolder;

/**
 * Created by Administrator on 2016/10/11.
 * 说明:
 * 创建人:         maixianda
 * 创建时间:       2016/10/11 11:42
 */

public class MainActivityAdapter extends ListAdapter<MainDto.ResultBean.ItemsBean,ItemIvBinding>{
    private Activity mActivity;
    public MainActivityAdapter(Activity context) {
        super(context);
        mActivity = context;
    }

    @Override
    public void onBindViewBinding(BaseViewHolder<ItemIvBinding> vh, int position) {
        MainDto.ResultBean.ItemsBean itemsBean = get(position);
        PhotoLoader.display(vh.getBinding().iv,
                itemsBean.getCover().get(position).getUrl(),
                getContext().getResources().getDrawable(R.drawable.ic_product_loading));
    }

    @Override
    protected int getItemLayoutId(int position) {
        return R.layout.item_iv;
    }
}
