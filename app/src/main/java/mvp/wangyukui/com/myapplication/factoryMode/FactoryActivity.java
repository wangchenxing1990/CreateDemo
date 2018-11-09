package mvp.wangyukui.com.myapplication.factoryMode;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import mvp.wangyukui.com.myapplication.R;

/**
 * Created by lenvo on 2018/11/9.
 */

public class FactoryActivity extends AppCompatActivity {
    private MessageFactory messageFactory;
    private IMyMessage myMessage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factory);
        messageFactory = new MessageFactory();
        try {
            myMessage = messageFactory.createMessage("OA");
            myMessage.sendMessage();

            myMessage = messageFactory.createMessage("dao");
            myMessage.sendMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
