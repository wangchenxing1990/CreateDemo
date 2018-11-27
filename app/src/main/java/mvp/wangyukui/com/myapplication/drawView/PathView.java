package mvp.wangyukui.com.myapplication.drawView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lenvo on 2018/11/26.
 */

public class PathView extends View {

    private Context context;
    private Paint mPaint;
    private Paint textPaint;
    private Path path;
    private Path CWPath;
    private RectF rectF;
    private RectF CWRectF;
    private String text = "闲云潭影日悠悠,物换星移几度秋";

    public PathView(Context context) {
        super(context);
        this.context = context;
    }

    public PathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(context, attrs);
        initRectPath();
//        initPath();
    }

    public PathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init(context, attrs);
        initRectPath();
//        initPath();
    }

    private void initRectPath() {
        path = new Path();
        rectF = new RectF(50, 50, 250, 300);
//        path.addRect(rectF, Path.Direction.CCW);
//        path.addRoundRect(rectF, 30, 30, Path.Direction.CCW);
        path.addCircle(180,180,100,Path.Direction.CCW);
        CWPath = new Path();
        CWRectF = new RectF(300, 50, 500, 300);
//        CWPath.addRect(CWRectF,Path.Direction.CW);
        CWPath.addRoundRect(CWRectF, 10, 10, Path.Direction.CW);
    }


    private void init(Context context, AttributeSet attrs) {

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(5);

        textPaint = new Paint();
        textPaint.setColor(Color.GRAY);
        textPaint.setTextSize(50);
        textPaint.setAntiAlias(true);
    }

    private void initPath() {
        path = new Path();
        path.moveTo(10, 10);
        path.lineTo(20, 100);
        path.lineTo(300, 300);
        path.lineTo(500, 100);
        path.close();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path, mPaint);
        canvas.drawPath(CWPath, mPaint);
        //文字跟随路径
//        canvas.drawTextOnPath(text,path,0,text.length(),textPaint);
//        canvas.drawTextOnPath(text,CWPath,0,text.length(),textPaint);
    }
}
