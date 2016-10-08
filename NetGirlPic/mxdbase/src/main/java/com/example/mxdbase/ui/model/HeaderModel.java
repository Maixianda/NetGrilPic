package com.example.mxdbase.ui.model;

import android.databinding.BaseObservable;
import android.view.View;

import com.example.mxdbase.R;
import com.example.mxdbase.core.event.extend.OnSingleClickListener;


/**
 * Created by aaron on 11/9/15.
 */
public class HeaderModel extends BaseObservable {
    private HeaderView mView;
    private int rightIcon;
    private int midIcon;
    private int midTitleColor = 0xFFffffff;
    private int rightTitleColor = 0xFFffffff;
    private boolean leftClickable = true;
    private boolean rightClickable = true;
    private String leftTitle = "";
    private String rightTitle = "";
    private String midTitle = "良策金服";

    public HeaderModel(HeaderView mView) {
        this.mView = mView;
    }

    public View.OnClickListener onBackClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (leftClickable) {
                    mView.onBackClicked();
                }
            }
        };
    }

    public View.OnClickListener onTitleClickListener() {
        return new OnSingleClickListener() {
            @Override
            public void onSingleClick(View v) {
                mView.onTitleClicked();
            }
        };
    }

    public View.OnClickListener onMenuClickListener() {
        return new OnSingleClickListener() {
            @Override
            public void onSingleClick(View v) {
                if (rightClickable) {
                    mView.onMenuClicked();
                }
            }
        };
    }


    public int getRightIcon() {
        return rightIcon;
    }

    public void setRightIcon(int rightIcon) {
        this.rightIcon = rightIcon;
    }

    public int getMidIcon() {
        return midIcon;
    }

    public void setMidIcon(int midIcon) {
        this.midIcon = midIcon;
    }

    public String getLeftTitle() {
        return leftTitle;
    }

    public void setLeftTitle(String leftTitle) {
        this.leftTitle = leftTitle;
    }

    public String getRightTitle() {
        return rightTitle;
    }

    public void setRightTitle(String rightTitle) {
        this.rightTitle = rightTitle;
    }

    public String getMidTitle() {
        return midTitle;
    }

    public void setMidTitle(String midTitle) {
        this.midTitle = midTitle;
    }


    public HeaderView getmView() {
        return mView;
    }

    public void setmView(HeaderView mView) {
        this.mView = mView;
    }

    public int getMidTitleColor() {
        return midTitleColor;
    }

    public void setMidTitleColor(int midTitleColor) {
        this.midTitleColor = midTitleColor;
    }

    public int getRightTitleColor() {
        return rightTitleColor;
    }

    public void setRightTitleColor(int rightTitleColor) {
        this.rightTitleColor = rightTitleColor;
    }

    public boolean isLeftClickable() {
        return leftClickable;
    }

    public void setLeftClickable(boolean leftClickable) {
        this.leftClickable = leftClickable;
    }

    public boolean isRightClickable() {
        return rightClickable;
    }

    public void setRightClickable(boolean rightClickable) {
        this.rightClickable = rightClickable;
    }

    public interface HeaderView {
        void onBackClicked();

        void onTitleClicked();

        void onMenuClicked();
    }

}
