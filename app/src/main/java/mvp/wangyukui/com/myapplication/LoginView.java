package mvp.wangyukui.com.myapplication;

import java.io.IOException;

/**
 * Created by lenvo on 2018/5/16.
 */

public interface LoginView {
    void requestShow();
    void requestHide();
    void requestSuccess(String string);
    void requestFailure(IOException e);
}
