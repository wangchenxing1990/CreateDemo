package mvp.wangyukui.com.myapplication.factoryMode;

/**
 * Created by lenvo on 2018/11/9.
 */
public interface IMyMessageFactory {
    public IMyMessage createMessage(String messageType);
}
