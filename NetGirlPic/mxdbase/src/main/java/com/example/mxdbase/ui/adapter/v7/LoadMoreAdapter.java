package com.example.mxdbase.ui.adapter.v7;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.view.ViewGroup;

import com.example.mxdbase.R;
import com.example.mxdbase.databinding.IncludeHeaderBinding;
import com.example.mxdbase.databinding.IncludeLoadBinding;
import com.example.mxdbase.ui.adapter.v7.ViewHolder.BaseViewHolder;

/**
 * Created by Administrator on 2016/10/11.
 * 说明:
 * 创建人:         maixianda
 * 创建时间:       2016/10/11 15:50
 */

public abstract class LoadMoreAdapter<T,B extends ViewDataBinding> extends ListAdapter<T,B> {

    public LoadMoreAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder<B> onCreateViewHolder(ViewGroup parent, int viewType) {
       // if (viewType == R.layout.include_load)
        return super.onCreateViewHolder(parent,viewType);
    }

    public class LoadingView{

    }
}
