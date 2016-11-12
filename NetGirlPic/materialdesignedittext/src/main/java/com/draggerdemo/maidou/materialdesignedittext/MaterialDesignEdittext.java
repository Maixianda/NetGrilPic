package com.draggerdemo.maidou.materialdesignedittext;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;

import com.example.mxdbase.util.Systems;

/**
 * Created by Administrator on 2016/11/11.
 * 说明:
 * 创建人:         maixianda
 * 创建时间:       2016/11/11 9:22
 */

public class MaterialDesignEdittext extends EditText {
    /**
     * 输入字符最大长度
     */
    private int maxCount;
    /**
     * 输入框下划线初始颜色
     */
    private int preLineColor;
    /**
     * 标签文字颜色
     */
    private int labelColor;
    /**
     * 标签文字内容
     */
    private String labelText;
    /**
     * 输入内容超过长度后下划线的颜色
     */
    private int overLengthColor;
    /**
     * 用来存放右下角字符计数内容的字符串
     */
    private StringBuffer countString;
    /**
     * 下划线画笔
     */
    private Paint mPaint;

    /**
     * 初始化标签画笔
     */
    private TextPaint textPaint;

    /**
     * 初始化字符计数的画笔
     */
    private TextPaint countPaint;
    private int extraTopPadding;
    private int extraBottomPadding;
    /**
     * 标签动画
     */
    private ValueAnimator labelAnim;
    /**
     * 标签透明度
     */
    private float textAlpha;
    private float yFraction;

    private int presentCount;
    /**
     * 标签是否显示
     */
    private boolean isShow = false;
    private float lineStartY;

    public MaterialDesignEdittext(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public MaterialDesignEdittext(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);

    }

    private void init(AttributeSet attrs) {
        //region 获取xml属性
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.MaterialDesignEdittext);
        // 获取设置的最大输入字符数，默认为-1，-1时不限制输入
        maxCount = typedArray.getInt(R.styleable.MaterialDesignEdittext_maxLength, -1);
        // 捕捉焦点后，下划线的初始颜色
        preLineColor = typedArray.getColor(R.styleable.MaterialDesignEdittext_preLineColor, getResources().getColor(R.color.preLineColor));
        // 标签文字的颜色
        labelColor = typedArray.getColor(R.styleable.MaterialDesignEdittext_labelColor, getResources().getColor(R.color.labelColor));
        // 标签文字的内容
        labelText = typedArray.getString(R.styleable.MaterialDesignEdittext_labelText);
        if (labelText == null) {
            labelText = "";
        }
        // 超过长度后的下划线颜色
        overLengthColor = typedArray.getColor(R.styleable.MaterialDesignEdittext_overlengthColor, Color.RED);

        typedArray.recycle();
        //endregion 获取xml属性

        // 用来存放右下角的计数内容的字符串
        countString = new StringBuffer();

        //region 初始化下划线画笔
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.LTGRAY);
        mPaint.setStrokeWidth(Systems.dpToPx(getContext(), 0.35f));
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        //endregion 初始化下划线画笔

        //region 初始化标签画笔
        textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setTextSize(Systems.spToPix(getContext(), 14.5f));
        textPaint.setColor(labelColor);
        //endregion 初始化标签画笔

        //region 初始化字符计数的画笔
        countPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        countPaint.setTextSize(Systems.spToPix(getContext(), 14.5f));
        countPaint.setColor(Color.LTGRAY);
        //endregion 初始化字符计数的画笔

        // 获取额外的顶部内边距
        extraTopPadding = (int) getTextHeight(textPaint) + Systems.dpToPx(getContext(), 4.0f);

        // 获取额外的底部内布距
        extraBottomPadding = (int) getTextHeight(textPaint) + Systems.dpToPx(getContext(), 6);

        // 矫正edittext的内边距
        correctPaddings();

        //region  初始化标签动画,并在动画标签内设置标签的透明度根据动画改变
        labelAnim = ValueAnimator.ofFloat(0, 255);
        labelAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                // 获取标签的透明度
                textAlpha = (float) animation.getAnimatedValue();
                // 获取文字的高度比例：
                // 当透明度为0时，高度比例为1.5，为1时，高度为1
                // 达到一种从底部浮现的效果
                yFraction = (float) (-(5.0f / 2550.0f) * textAlpha + 1.5);
                // 重绘
                invalidate();
            }
        });
        //endregion  初始化标签动画,并在动画标签内设置标签的透明度根据动画改变

        //region 初始化监听器
        initListener();
        //endregion 初始化监听器
    }

    private void initListener() {
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (maxCount != -1) {
                    countString.delete(0, countString.length());
                    presentCount = s.length();
                    countString.append(presentCount);
                    countString.append(" / ");
                    countString.append(maxCount);

                    //region 超出固定长度后,设置下划线还有计数字符串颜色
                    if (presentCount > maxCount) {
                        mPaint.setColor(overLengthColor);
                        countPaint.setColor(overLengthColor);
                    } else {
                        mPaint.setColor(preLineColor);
                        countPaint.setColor(Color.LTGRAY);
                    }
                    //endregion 超出固定长度后,设置下划线还有计数字符串颜色

                    //region 内容为0的时候,播放标签的动画,否则反着播放动画
                    if (s.length()==0&&isShow&&isFocused())
                    {
                        labelAnim.reverse();
                        isShow = false;
                    }
                    else if (s.length()>0 && isShow && isFocused())
                    {
                        //内容不为0的时候,标签浮现动画播放一遍
                        labelAnim.start();
                        isShow = true;
                    }
                    //endregion 内容为0的时候,播放标签的动画
                }
            }
        });

        setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                //有焦点的时候
                if (hasFocus)
                {
                    // 改变下划线的粗细
                    mPaint.setStrokeWidth(Systems.dpToPx(getContext(),1.3f));
                    // 改变标签的颜色
                    textPaint.setColor(labelColor);

                    if(presentCount>maxCount&&maxCount!=-1){
                        // 超出字符长度时，设置画笔颜色
                        mPaint.setColor(overLengthColor);
                        countPaint.setColor(overLengthColor);
                    }else {
                        // 不超出字符长度/不设置规定长度时，设置画笔颜色
                        mPaint.setColor(preLineColor);
                        countPaint.setColor(Color.LTGRAY);
                    }

                }
                else
                {
                    // 没有获取焦点时，改变下划线的颜色和粗细和标签颜色
                    textPaint.setColor(Color.LTGRAY);
                    mPaint.setColor(Color.LTGRAY);
                    mPaint.setStrokeWidth(Systems.dpToPx(getContext(),0.35f));
                }
            }
        });
    }

    // 因为我们需要绘制标签和下划线，因此需要重新设置padding值
    private void correctPaddings() {
        super.setPadding(getPaddingLeft(),
                getPaddingTop() + extraTopPadding,
                getPaddingRight(),
                getPaddingBottom() + extraBottomPadding + Systems.dpToPx(getContext(), 5));

    }

    // 获取文字的高度
    private float getTextHeight(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.bottom - fontMetrics.descent - fontMetrics.ascent;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        // 设置edittext的背景为空，主要为了隐藏自带的下划线
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            setBackground(null);
        } else {
            setBackgroundDrawable(null);
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {

        // 获取下划线的起点高度
        lineStartY = getScrollY()+getHeight()-getPaddingBottom()+Systems.dpToPx(getContext(),5);
        // 设置标签的透明度
        textPaint.setAlpha((int) textAlpha);
        // 根据标签的高度比例绘制标签文字
        canvas.drawText(labelText, getScrollX(),(getScrollY()-Systems.dpToPx(getContext(),4)+extraTopPadding)*yFraction, textPaint);
        // 绘制下划线
        canvas.drawRect(getScrollX(), lineStartY, getScrollX()+getWidth()-getPaddingRight(), lineStartY + Systems.dpToPx(getContext(),0.8f), mPaint);
        // 根据是否有字符长度规定绘制右下角的计数
        if(maxCount!=-1) {
            canvas.drawText(countString.toString(), getScrollX()+getWidth()-getPaddingRight() - getTextWidth(countString.toString(), countPaint), lineStartY + extraBottomPadding, countPaint);
        }
        // 开始edittext原生的绘制
        super.onDraw(canvas);

    }

    // 获取字符串的宽度
    private int getTextWidth(String text,TextPaint paint) {
        return (int) paint.measureText(text);
    }
}
