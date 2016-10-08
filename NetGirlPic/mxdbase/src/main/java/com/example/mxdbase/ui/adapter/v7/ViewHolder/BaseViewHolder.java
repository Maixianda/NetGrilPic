package com.example.mxdbase.ui.adapter.v7.ViewHolder;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
/**
 * Created by rick on 10/20/15.
 */
public class BaseViewHolder<B extends ViewDataBinding> extends RecyclerView.ViewHolder {
    private B mBinding;

    public BaseViewHolder(B binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public B getBinding() {
        return mBinding;
    }

    public void bindTo(Object obj) {
        mBinding.executePendingBindings();
    }

}
