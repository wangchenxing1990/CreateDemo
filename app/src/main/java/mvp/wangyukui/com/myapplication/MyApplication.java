package mvp.wangyukui.com.myapplication;

import android.app.Application;
import android.content.Context;

/**
 * Created by lenvo on 2018/5/17.
 */

public class MyApplication extends Application {
    public static Context myContext;
    @Override
    public void onCreate() {
        super.onCreate();
        myContext=MyApplication.this;
    }
}
