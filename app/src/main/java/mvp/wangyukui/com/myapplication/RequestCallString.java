package mvp.wangyukui.com.myapplication;

import java.io.IOException;

/**
 * Created by lenvo on 2018/5/17.
 */

public interface RequestCallString {
    void successRequest(String string);
    void failureRequest(IOException e);
}
