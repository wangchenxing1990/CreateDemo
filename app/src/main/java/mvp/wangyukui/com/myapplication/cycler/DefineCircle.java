package mvp.wangyukui.com.myapplication.cycler;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import mvp.wangyukui.com.myapplication.R;

/**
 * Created by lenvo on 2018/11/20.
 */

public class DefineCircle extends View {
    private Context context;
    private Paint outCirclePaint;

    public DefineCircle(Context context) {
        super(context);
        this.context = context;
    }

    public DefineCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(context, attrs);
    }

    public DefineCircle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        initPaint();
    }

    @SuppressLint("ResourceAsColor")
    private void initPaint() {
        outCirclePaint = new Paint();
        outCirclePaint.setColor(Color.BLACK);
        outCirclePaint.setStrokeWidth(5);
        outCirclePaint.setStyle(Paint.Style.STROKE);
        outCirclePaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = new Rect();
        canvas.drawRect(rect, outCirclePaint);
    }
}
