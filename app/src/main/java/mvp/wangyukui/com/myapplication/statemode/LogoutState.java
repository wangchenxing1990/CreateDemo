package mvp.wangyukui.com.myapplication.statemode;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by lenvo on 2018/11/8.
 */

public class LogoutState implements UserState {
    /**
     * 转发
     *
     * @param context
     */
    @Override
    public void forword(Context context) {
        gotoLoginActivity(context);
        Toast.makeText(context, "转发 请先登录", Toast.LENGTH_SHORT).show();
    }

    /**
     * 评论
     *
     * @param context
     */
    @Override
    public void commit(Context context) {
        Toast.makeText(context, "评论 请先登录", Toast.LENGTH_SHORT).show();
        gotoLoginActivity(context);
    }

    private void gotoLoginActivity(Context context) {
        LoginActivity.startEnterActivity(context);
    }

}
