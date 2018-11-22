package mvp.wangyukui.com.myapplication.cycler;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by lenvo on 2018/11/21.
 */

public class UserDefinedCircle extends View {
    private String TAG = "UserDefinedCircle";

    public UserDefinedCircle(Context context) {
        super(context);
    }

    public UserDefinedCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public UserDefinedCircle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.i(TAG, "onMeasure");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.i(TAG, "onMeasure");
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.i(TAG, "onLayout");
    }
}
