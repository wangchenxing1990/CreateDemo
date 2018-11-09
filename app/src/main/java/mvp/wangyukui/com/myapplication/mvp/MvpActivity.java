package mvp.wangyukui.com.myapplication.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

import mvp.wangyukui.com.myapplication.MainActivity;
import mvp.wangyukui.com.myapplication.R;

/**
 * Created by lenvo on 2018/11/9.
 */

public class MvpActivity extends AppCompatActivity implements LoginView, View.OnClickListener {
    public static void startActivityEnter(MainActivity mainActivity) {
        mainActivity.startActivity(new Intent(mainActivity, MvpActivity.class));
    }

    private EditText edit_text_account;
    private EditText edit_text_password;
    private Button button_register;
    private Button button_login;
    private PresenterRequest presenterRequest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        presenterRequest = new PresenterRequest(this);
        initView();//初始化view
        initClickListener();//初始化点击事件
    }


    private void initView() {
        edit_text_account = findViewById(R.id.edit_text_account);
        edit_text_password = findViewById(R.id.edit_text_password);
        button_register = findViewById(R.id.button_register);
        button_login = findViewById(R.id.button_login);
    }

    private void initClickListener() {
        button_register.setOnClickListener(this);
        button_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_register:
                String account = edit_text_account.getText().toString().trim();
                String password = edit_text_password.getText().toString().trim();
                presenterRequest.clickRequest(account, password);
                break;
            case R.id.button_login:
                break;
        }
    }

    @Override
    public void requestShow() {

    }

    @Override
    public void requestHide() {

    }

    @Override
    public void requestSuccess(String string) {
        Log.i("string", string);
    }

    @Override
    public void requestFailure(IOException e) {

    }
}
