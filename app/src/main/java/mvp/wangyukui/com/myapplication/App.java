package mvp.wangyukui.com.myapplication;

import android.app.Application;

/**
 * Created by wangyukui on 2018/11/4.
 */

public class App extends Application {
    public static App mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext=this;
    }
}
