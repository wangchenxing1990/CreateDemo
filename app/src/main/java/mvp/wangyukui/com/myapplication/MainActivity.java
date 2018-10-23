package mvp.wangyukui.com.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.IOException;

import mvp.wangyukui.com.myapplication.defineRecycler.DefineRecyclerActivity;

public class MainActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    private EditText edit_text_account;
    private EditText edit_text_password;
    private Button button_login;
    private Button button_register;
    private Button start_new_activity;
    private RelativeLayout relative_progress;
    private PresenterRequest presenterRequest;
    private ViewStub viewStub;
    private RelativeLayout relative_layout;
    private MyNetWorkBroadcastReceiver registerReceiver;
    private TextView text_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_text_account = findViewById(R.id.edit_text_account);
        edit_text_password = findViewById(R.id.edit_text_password);
        text_test = findViewById(R.id.text_test);
        button_login = findViewById(R.id.button_login);
        button_register = findViewById(R.id.button_register);
        start_new_activity = findViewById(R.id.start_new_activity);
        relative_progress = findViewById(R.id.relative_progress);
        relative_progress.setVisibility(View.INVISIBLE);
        button_register.setOnClickListener(this);
        button_login.setOnClickListener(this);
        start_new_activity.setOnClickListener(this);
        presenterRequest = new PresenterRequest(this);

//        viewStub = findViewById(R.id.view_stub);
        registerReceiver = new MyNetWorkBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(registerReceiver, intentFilter);
        String text = getString(R.string.text_test, "杭州西湖美景", 6);
        text_test.setText(text);
    }

    @Override
    public void requestShow() {
        relative_progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void requestHide() {
        relative_progress.setVisibility(View.INVISIBLE);
    }

    @Override
    public void requestSuccess(String string) {
        Log.i("string", string);
    }

    @Override
    public void requestFailure(IOException e) {

    }

    class MyNetWorkBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (relative_layout == null) {
                ((ViewStub) findViewById(R.id.view_stub)).inflate();
                relative_layout = findViewById(R.id.relative_layout);
            } else {
                relative_layout.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_register:
                Intent intent = new Intent(this, DefineRecyclerActivity.class);
                startActivity(intent);
                break;
            case R.id.button_login:
                String account = edit_text_account.getText().toString().trim();
                String password = edit_text_password.getText().toString().trim();
                presenterRequest.clickRequest(account, password);
                break;
            case R.id.start_new_activity:
                Intent intentWeb = new Intent(this, WebNewActivity.class);
                startActivity(intentWeb);
                break;
        }
    }
}
