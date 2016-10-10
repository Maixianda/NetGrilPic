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
    //背景
    private int leftBackground = R.drawable.translator;
    private int rightBackground = R.drawable.translator;
    private int midBackground = R.drawable.translator;
    //icon
    private int leftDrawableLeft = R.drawable.translator;
    private int rightDrawableLeft = R.drawable.translator;
    private int midDrawableLeft = R.drawable.translator;
    //color
    private int leftTitleColor = R.color.transparent;
    private int rightTitleColor = R.color.transparent;
    private int midTitleColor = R.color.colorPrimary;;
    //clickable
    private boolean leftTitleClickable = false;
    private boolean rightTitleClickable = false;
    private boolean midTitleClickable = false;
    //title
    private String leftTitle = "";
    private String rightTitle = "";
    private String midTitle = "";
    //textColor
    private int leftTextColor;

    public int getMidTextColor() {
        return midTextColor;
    }

    public void setMidTextColor(int midTextColor) {
        this.midTextColor = midTextColor;
    }

    public int getRightTextColor() {
        return rightTextColor;
    }

    public void setRightTextColor(int rightTextColor) {
        this.rightTextColor = rightTextColor;
    }

    public int getLeftTextColor() {

        return leftTextColor;
    }

    public void setLeftTextColor(int leftTextColor) {
        this.leftTextColor = leftTextColor;
    }

    private int midTextColor;
    private int rightTextColor;

    public HeaderModel(HeaderView mView) {
        this.mView = mView;
    }

    public View.OnClickListener onBackClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (leftTitleClickable) {
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
                if (rightTitleClickable) {
                    mView.onMenuClicked();
                }
            }
        };
    }

    public HeaderView getmView() {
        return mView;
    }

    public void setmView(HeaderView mView) {
        this.mView = mView;
    }

    public int getLeftBackground() {
        return leftBackground;
    }

    public void setLeftBackground(int leftBackground) {
        this.leftBackground = leftBackground;
    }

    public int getRightBackground() {
        return rightBackground;
    }

    public void setRightBackground(int rightBackground) {
        this.rightBackground = rightBackground;
    }

    public int getMidBackground() {
        return midBackground;
    }

    public void setMidBackground(int midBackground) {
        this.midBackground = midBackground;
    }

    public int getLeftDrawableLeft() {
        return leftDrawableLeft;
    }

    public void setLeftDrawableLeft(int leftDrawableLeft) {
        this.leftDrawableLeft = leftDrawableLeft;
    }

    public int getRightDrawableLeft() {
        return rightDrawableLeft;
    }

    public void setRightDrawableLeft(int rightDrawableLeft) {
        this.rightDrawableLeft = rightDrawableLeft;
    }

    public int getMidDrawableLeft() {
        return midDrawableLeft;
    }

    public void setMidDrawableLeft(int midDrawableLeft) {
        this.midDrawableLeft = midDrawableLeft;
    }

    public int getLeftTitleColor() {
        return leftTitleColor;
    }

    public void setLeftTitleColor(int leftTitleColor) {
        this.leftTitleColor = leftTitleColor;
    }

    public int getRightTitleColor() {
        return rightTitleColor;
    }

    public void setRightTitleColor(int rightTitleColor) {
        this.rightTitleColor = rightTitleColor;
    }

    public int getMidTitleColor() {
        return midTitleColor;
    }

    public void setMidTitleColor(int midTitleColor) {
        this.midTitleColor = midTitleColor;
    }

    public boolean isLeftTitleClickable() {
        return leftTitleClickable;
    }

    public void setLeftTitleClickable(boolean leftTitleClickable) {
        this.leftTitleClickable = leftTitleClickable;
    }

    public boolean isRightTitleClickable() {
        return rightTitleClickable;
    }

    public void setRightTitleClickable(boolean rightTitleClickable) {
        this.rightTitleClickable = rightTitleClickable;
    }

    public boolean isMidTitleClickable() {
        return midTitleClickable;
    }

    public void setMidTitleClickable(boolean midTitleClickable) {
        this.midTitleClickable = midTitleClickable;
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

    public interface HeaderView {
        void onBackClicked();

        void onTitleClicked();

        void onMenuClicked();
    }

}
