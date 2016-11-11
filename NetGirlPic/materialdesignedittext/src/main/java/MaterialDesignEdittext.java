import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.EditText;

import com.draggerdemo.maidou.materialdesignedittext.R;
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

    public MaterialDesignEdittext(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public MaterialDesignEdittext(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);

    }

    private void init(AttributeSet attrs)
    {
        //region 获取xml属性
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.MaterialDesignEdittext);
        // 获取设置的最大输入字符数，默认为-1，-1时不限制输入
        maxCount = typedArray.getInt(R.styleable.MaterialDesignEdittext_maxLength,-1);
        // 捕捉焦点后，下划线的初始颜色
        preLineColor = typedArray.getColor(R.styleable.MaterialDesignEdittext_preLineColor,getResources().getColor(R.color.preLineColor));
        // 标签文字的颜色
        labelColor = typedArray.getColor(R.styleable.MaterialDesignEdittext_labelColor, getResources().getColor(R.color.labelColor));
        // 标签文字的内容
        labelText = typedArray.getString(R.styleable.MaterialDesignEdittext_labelText);
        if (labelText==null)
        {
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
        mPaint.setStrokeWidth(Systems.dpToPx(getContext(),0.35f));
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        //endregion 初始化下划线画笔

        //region 初始化标签画笔
        textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setTextSize(Systems.spToPix(getContext(),14.5f));
        textPaint.setColor(labelColor);
        //endregion 初始化标签画笔

        //region 初始化字符计数的画笔
        countPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        countPaint.setTextSize(Systems.spToPix(getContext(),14.5f));
        countPaint.setColor(Color.LTGRAY);
        //endregion 初始化字符计数的画笔

        // 获取额外的顶部内边距
        extraTopPadding = (int) getTextHeight(textPaint) + Systems.dpToPx(getContext(),4.0f);

        // 获取额外的底部内布距
        extraBottomPadding = (int) getTextHeight(textPaint) + Systems.dpToPx(getContext(),6);

        // 矫正edittext的内边距
        //correctPaddings();

        // 初始化标签动画
//        labelAnim = ValueAnimator.ofFloat(0, 255);
//        labelAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                // 获取标签的透明度
//                textAlpha = (float) animation.getAnimatedValue();
//                // 获取文字的高度比例：
//                // 当透明度为0时，高度比例为1.5，为1时，高度为1
//                // 达到一种从底部浮现的效果
//                yFraction = (float) (-(5.0f / 2550.0f) * textAlpha + 1.5);
//                // 重绘
//                invalidate();
//            }
//        });
    }

    // 因为我们需要绘制标签和下划线，因此需要重新设置padding值
    private void correctPaddings() {
        super.setPadding(getPaddingLeft(),
                getPaddingTop()+extraTopPadding,
                getPaddingRight(),
                getPaddingBottom()+extraBottomPadding+Systems.dpToPx(getContext(),5));

    }

    // 获取文字的高度
    private float getTextHeight(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.bottom-fontMetrics.descent-fontMetrics.ascent;
    }
}
