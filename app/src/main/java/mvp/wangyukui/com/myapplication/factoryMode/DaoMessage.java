package mvp.wangyukui.com.myapplication.factoryMode;

/**
 * Created by lenvo on 2018/11/9.
 */

public class DaoMessage extends MyMessage {
    @Override
    public void sendMessage() throws Exception {
        if (null == getMessage() || null == getMessage().get("EMALL")) {
            throw new Exception("发信息需要传入短信消息");
        }
    }
}
