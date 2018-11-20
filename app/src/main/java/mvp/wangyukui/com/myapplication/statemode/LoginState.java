package mvp.wangyukui.com.myapplication.statemode;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by lenvo on 2018/11/8.
 */

public class LoginState implements UserState {

    /**
     * 转发成功
     *
     * @param context
     */
    @Override
    public void forword(Context context) {
        Toast.makeText(context, "转发 转发成功", Toast.LENGTH_SHORT).show();
        Log.i("状态模式", "转发成功");
    }

    /**
     * 评论
     *
     * @param context
     */
    @Override
    public void commit(Context context) {
        Toast.makeText(context, "转发 评论成功", Toast.LENGTH_SHORT).show();
        Log.i("状态模式", "评论成功");
    }
}
