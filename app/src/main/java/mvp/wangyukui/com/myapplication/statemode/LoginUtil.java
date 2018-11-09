package mvp.wangyukui.com.myapplication.statemode;

import android.content.Context;

/**
 * Created by lenvo on 2018/11/8.
 */

public class LoginUtil {
    public static LoginUtil loginUtil;
    private UserState userState;

    private LoginUtil() {
        userState = new LogoutState();
    }

    public static LoginUtil getInstance() {
        if (loginUtil == null) {
            synchronized (LoginUtil.class) {
                if (loginUtil == null) {
                    loginUtil = new LoginUtil();
                }
            }
        }
        return loginUtil;
    }

    public void setUserSate(UserState sate) {
        userState = sate;
    }

    public UserState getUserState() {
        return userState;
    }

    /**
     * 转发
     *
     * @param context
     */
    public void forword(Context context) {
        userState.forword(context);
    }

    /**
     * 评论
     *
     * @param context
     */
    public void commit(Context context) {
        userState.commit(context);
    }
}
