package mvp.wangyukui.com.myapplication.dagger;

import android.widget.Toast;

import mvp.wangyukui.com.myapplication.App;

/**
 * Created by wangyukui on 2018/11/4.
 */

public class NewCart {
    public void setEatMouse() {
        Toast.makeText(App.mContext, "手动设置的dagger的使用方法", Toast.LENGTH_SHORT).show();
    }
}
