package mvp.wangyukui.com.myapplication.statemode;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import mvp.wangyukui.com.myapplication.MainActivity;
import mvp.wangyukui.com.myapplication.R;

/**
 * Created by lenvo on 2018/11/8.
 */

public class StateActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button_login;
    private Button button_transmit;
    private Button button_discuss;
    private Button button_logout;

    public static void startEnterActivity(MainActivity mainActivity) {
        mainActivity.startActivity(new Intent(mainActivity, StateActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_mode);
        button_login = findViewById(R.id.button_login);
        button_transmit = findViewById(R.id.button_transmit);
        button_discuss = findViewById(R.id.button_discuss);
        button_logout = findViewById(R.id.button_logout);

        button_login.setOnClickListener(this);
        button_transmit.setOnClickListener(this);
        button_discuss.setOnClickListener(this);
        button_logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_login://登录
                LoginUtil.getInstance().setUserSate(new LoginState());
                break;
            case R.id.button_transmit://转发
                LoginUtil.getInstance().forword(this);
                break;
            case R.id.button_discuss://评论
                LoginUtil.getInstance().commit(this);
                break;
            case R.id.button_logout://注销
                LoginUtil.getInstance().setUserSate(new LogoutState());
                break;
        }
    }


}
