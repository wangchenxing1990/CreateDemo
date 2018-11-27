package mvp.wangyukui.com.myapplication.drawView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lenvo on 2018/11/26.
 */

public class MyTextView extends View {
    private Context context;
    private Paint paint;
    private String text="落花人独立，微雨燕双飞";
    public MyTextView(Context context) {
        super(context);
        this.context=context;
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        init(context,attrs);
    }
    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        init(context,attrs);
    }
    private void init(Context context, AttributeSet attrs) {
        paint=new Paint();
        paint.setStrokeWidth(5);
        paint.setAntiAlias(true);
        paint.setTextSize(50);
        paint.setColor(Color.RED);
//        paint.setStyle(Paint.Style.FILL);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrikeThruText(true);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(text,10,200,paint);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawText(text,10,400,paint);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawText(text,10,600,paint);
    }
}
