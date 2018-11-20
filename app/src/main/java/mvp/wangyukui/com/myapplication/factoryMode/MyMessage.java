package mvp.wangyukui.com.myapplication.factoryMode;

import java.util.Map;

/**
 * Created by lenvo on 2018/11/9.
 */

public abstract class MyMessage implements IMyMessage {
    private Map<String, Object> map;

    @Override
    public Map<String, Object> getMessage() {
        return map;
    }

    @Override
    public void setMessage(Map<String, Object> map) {
        this.map = map;
    }
}
