package mvp.wangyukui.com.myapplication.cycler;


import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import mvp.wangyukui.com.myapplication.R;

/**
 * Created by wangyukui on 2018/11/20.
 */

public class CircleTwoView extends View {
    private Context context;
    private int mMinRadio;
    private int mMaxValue;
    private int mSelectRing;
    private float mRingWidth;
    private int mRingNormalColor;
    private int mMinCircleColor;
    private Paint mPaint;
    private int color[] = new int[3];
    private int mViewCenterX;
    private int mViewCenterY;
    private RectF mRectF;
    private ValueAnimator valueAnimator;

    public CircleTwoView(Context context) {
        super(context);
        this.context = context;
    }

    public CircleTwoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(context, attrs);
    }

    public CircleTwoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SuperCircleView);
        mMinRadio = typedArray.getInteger(R.styleable.SuperCircleView_min_circle_radio, 300);
        mRingWidth = typedArray.getFloat(R.styleable.SuperCircleView_ring_width, 40);
        //最里面的圆的颜色(绿色)
        mMinCircleColor = typedArray.getColor(R.styleable.SuperCircleView_circle_color, context.getResources().getColor(R.color.green));
        //圆环的默认颜色(圆环占据的是里面的圆的空间)
        mRingNormalColor = typedArray.getColor(R.styleable.SuperCircleView_ring_normal_color, context.getResources().getColor(R.color.gray));
        //圆环要显示的彩色的区域
        mSelectRing = typedArray.getInt(R.styleable.SuperCircleView_ring_color_select, 0);

        mMaxValue = typedArray.getInt(R.styleable.SuperCircleView_maxValue, 100);

        typedArray.recycle();

        initPaint();//初始化画笔

    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        this.setWillNotDraw(false);
        color[0] = Color.parseColor("#FFD300");
        color[1] = Color.parseColor("#FF0084");
//        color[2]=Color.parseColor("#FF0084");
        color[2] = Color.parseColor("#16FF00");
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        int viewHeight = getMeasuredHeight();
        int viewWidth = getMeasuredWidth();
        mViewCenterX = viewWidth / 2;
        mViewCenterY = viewHeight / 2;
        mRectF = new RectF(mViewCenterX - mMinRadio - mRingWidth / 2, mViewCenterY - mMinRadio - mRingWidth / 2, mViewCenterX + mMinRadio + mRingWidth / 2, mViewCenterY + mMinRadio + mRingWidth / 2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(mMinCircleColor);
        canvas.drawCircle(mViewCenterX, mViewCenterY, mMinRadio, mPaint);
        //画默认的圆环
        drawNormalRing(canvas);
        //画彩色圆环
        doColorRing(canvas);
    }


    /**
     * 画默认的圆环
     *
     * @param canvas
     */
    private void drawNormalRing(Canvas canvas) {
        Paint ringNormalPaint = new Paint(mPaint);
        ringNormalPaint.setStyle(Paint.Style.STROKE);
        ringNormalPaint.setStrokeWidth(mRingWidth);
        ringNormalPaint.setColor(mRingNormalColor);//圆环默认颜色为灰色
        canvas.drawArc(mRectF, 360, 360, false, ringNormalPaint);
    }

    /**
     * 画彩色圆环
     *
     * @param canvas
     */
    private void doColorRing(Canvas canvas) {
        Paint ringColorPaint = new Paint(mPaint);
        ringColorPaint.setStyle(Paint.Style.STROKE);
        ringColorPaint.setStrokeWidth(mRingWidth);
        ringColorPaint.setShader(new SweepGradient(mViewCenterX, mViewCenterX, color, null));
        //逆时针旋转90度
//        canvas.rotate(-90, mViewCenterX, mViewCenterY);
        canvas.drawArc(mRectF, 360, mSelectRing, false, ringColorPaint);
        ringColorPaint.setShader(null);
    }

    /**
     * 设定当前值
     */
    public void setValue(int value) {
        if (value > mMaxValue) {
            value = mMaxValue;
        }
        int start = 0;
        int end = value;
        startAnimator(start, end, 2000);
    }

    private void startAnimator(int start, int end, long animTime) {
        valueAnimator = ValueAnimator.ofInt(start, end);
        valueAnimator.setDuration(animTime);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int i = Integer.valueOf(String.valueOf(animation.getAnimatedValue()));
//                textView.setText(i + "");
                //每个单位长度占多少度
                mSelectRing = (int) (360 * (i / 100f));
                invalidate();
            }
        });
        valueAnimator.start();
    }


}
