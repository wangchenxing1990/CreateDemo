package mvp.wangyukui.com.myapplication.factoryMode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenvo on 2018/11/9.
 */

public class MessageFactory implements IMyMessageFactory {
    Map<String, Object> message = new HashMap();
    IMyMessage myMessage;

    @Override
    public IMyMessage createMessage(String messageType) {
        if ("OA".equals(messageType)) {
            myMessage = new MyMessageOA();
        } else if ("DM".equals(messageType)) {
            myMessage = new DaoMessage();
        } else {
            myMessage = new DaoMessage();
        }
        message.put(messageType, myMessage);
        return myMessage;
    }
}
