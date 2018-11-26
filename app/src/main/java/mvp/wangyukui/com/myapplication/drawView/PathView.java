package mvp.wangyukui.com.myapplication.drawView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lenvo on 2018/11/26.
 */

public class PathView extends View {

    private Context context;
    private Paint mPaint;
    private Path path;


    public PathView(Context context) {
        super(context);
        this.context = context;
    }

    public PathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(context, attrs);
    }

    public PathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init(context, attrs);
        initPath();
    }


    private void init(Context context, AttributeSet attrs) {
        mPaint = new Paint();
//        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(5);
    }

    private void initPath() {
        path = new Path();
        path.moveTo(10, 10);
        path.lineTo(10, 100);
        path.lineTo(300, 100);
        path.lineTo(500, 100);
//        path.close();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path, mPaint);
    }
}
