package com.example.mxdbase.ui.adapter.v7;

import android.content.Context;
import android.content.res.Resources;
import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.icu.util.IslamicCalendar;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;

import com.example.mxdbase.R;
import com.example.mxdbase.databinding.IncludeLoadingBinding;
import com.example.mxdbase.ui.adapter.v7.ViewHolder.BaseViewHolder;
import com.example.mxdbase.ui.drawable.MaterialProgressDrawable;
import com.example.mxdbase.util.Timers;

/**
 * Created by Administrator on 2016/10/11.
 * 说明:
 * 创建人:         maixianda
 * 创建时间:       2016/10/11 15:50
 */

public abstract class LoadMoreAdapter<T, B extends ViewDataBinding> extends ListAdapter<T, B> {
    private Runnable runnable;
    private LoadMoreListener mLoadMoreListener;
    public LoadingView loadingView;

    public LoadMoreAdapter(Context context) {
        super(context);
    }

    public void setLoadMoreListener(LoadMoreListener mLoadMoreListener) {
        this.mLoadMoreListener = mLoadMoreListener;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == R.layout.include_loading) {
            IncludeLoadingBinding binding = IncludeLoadingBinding.inflate(getInflater(), parent, false);
            loadingView = new LoadingView(getContext(), binding);
            loadingView.stop();
            return new BaseViewHolder<>(binding);
        } else {
            return super.onCreateViewHolder(parent, viewType);
        }
    }

    private boolean isLastPage = false;
    @Override
    public void onBindViewHolder(BaseViewHolder<B> holder, int position) {
        if (holder.getItemViewType() == R.layout.include_loading)
        {
            if (!isLastPage)
            {
                LoadMoreData(holder);
            }
        }
        else
        {
            super.onBindViewHolder(holder,position);
        }
    }

    private void LoadMoreData(BaseViewHolder holder) {
        loadingView.start();
        loadMore();
    }

    @Override
    public int getItemCount() {
        return size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount())
        {
            return R.layout.include_loading;
        }
        else {
            return super.getItemViewType(position);
        }
    }

    public void hideLoadMore() {
        if (loadingView != null) {
            loadingView.stop();
        }
    }

    public void onFinishLoadMore(boolean lastPage) {
        isLastPage = lastPage;
        if (loadingView != null) {
            loadingView.stop();
        }
    }

    public void loadMore() {
        if (mLoadMoreListener != null) {
            new Handler(Looper.myLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    mLoadMoreListener.onLoadMore();
                }
            }, 500);
        }
    }

    public class LoadingView {
        private MaterialProgressDrawable mFooterProgress;
        private Context context;
        private IncludeLoadingBinding binding;
        private boolean isFinish = false;

        public LoadingView(Context context, IncludeLoadingBinding binding) {
            this.context = context;
            this.binding = binding;
        }


        private Context getContext() {
            return context;
        }

        private void initProgressView() {
            mFooterProgress = new MaterialProgressDrawable(getContext(), this.binding.getRoot());
            mFooterProgress.setAlpha(255);
            mFooterProgress.setBackgroundColor(Color.TRANSPARENT);
            Resources resources = getContext().getResources();
            int color = resources.getColor(R.color.colorPrimaryDark);
            int blue = resources.getColor(R.color.colorPrimary);
            int green = resources.getColor(R.color.colorAccent);
            mFooterProgress.setColorSchemeColors(color, blue, green);
        }

        public void start() {
            if (!isFinish) {
                if (mFooterProgress == null) {
                    initProgressView();
                }

                if (!mFooterProgress.isRunning()) {
                    binding.imageView.setImageDrawable(mFooterProgress);
                    mFooterProgress.start();
                }
            }
        }

        public void stop() {
            if (binding.getRoot() != null && mFooterProgress != null && binding.imageView != null) {
                binding.imageView.setImageDrawable(null);
                mFooterProgress.stop();
            }
        }

    }

    public void startRunnable() {
        if (runnable == null) {
            runnable = new Runnable() {
                @Override
                public void run() {
                    onFinishLoadMore(false);
                }
            };
        }
        Timers.setTimeout(runnable, 500);
    }

    public void stopRunnable() {
        if (runnable != null) {
            Timers.killTimer(runnable);
        }
    }

}
