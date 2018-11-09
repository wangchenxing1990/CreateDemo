package mvp.wangyukui.com.myapplication.statemode;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import mvp.wangyukui.com.myapplication.R;

/**
 * Created by lenvo on 2018/11/8.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    public static void startEnterActivity(Context context) {
        context.startActivity(new Intent(context, LoginActivity.class));
    }

    private Button button_login;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_two);
        button_login = findViewById(R.id.button_login);
        button_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_login:
                LoginUtil.getInstance().setUserSate(new LoginState());
                finish();
                break;
        }
    }
}
