package mvp.wangyukui.com.myapplication.factoryMode;

import java.util.Map;

/**
 * Created by lenvo on 2018/11/9.
 */

public interface IMyMessage {
    public Map<String, Object> getMessage();

    public void setMessage(Map<String, Object> map);

    public void sendMessage() throws Exception;
}
