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
import mvp.wangyukui.com.myapplication.duty.DutyActivity;
import mvp.wangyukui.com.myapplication.mvp.MvpActivity;
import mvp.wangyukui.com.myapplication.mvp.PresenterRequest;
import mvp.wangyukui.com.myapplication.rxjava.RxJavaActivity;
import mvp.wangyukui.com.myapplication.statemode.StateActivity;
import mvp.wangyukui.com.myapplication.tools.NetworkTools;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button_mvp;
    private Button button_internet;
    private Button start_new_activity;
    private RelativeLayout relative_layout;
    private MyNetWorkBroadcastReceiver registerReceiver;
    private TextView text_test;
    private Button button_state_mode, button_rxJava_mode, button_duty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();//初始化view
        setOnClickListener();//初始化点击事件的监听
        text_test = findViewById(R.id.text_test);
        registerReceiver = new MyNetWorkBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(registerReceiver, intentFilter);

        String text = getString(R.string.text_test, "杭州西湖美景", 6);
        text_test.setText(text);
    }

    private void initView() {
        button_mvp = findViewById(R.id.button_mvp);
        start_new_activity = findViewById(R.id.start_new_activity);
        button_internet = findViewById(R.id.button_internet);
        button_state_mode = findViewById(R.id.button_state_mode);
        button_rxJava_mode = findViewById(R.id.button_rxjava_mode);
        button_duty = findViewById(R.id.button_duty);
    }

    private void setOnClickListener() {
        button_mvp.setOnClickListener(this);
        button_internet.setOnClickListener(this);
        button_state_mode.setOnClickListener(this);
        button_rxJava_mode.setOnClickListener(this);
        start_new_activity.setOnClickListener(this);
        button_duty.setOnClickListener(this);
    }


    class MyNetWorkBroadcastReceiver extends BroadcastReceiver implements View.OnClickListener {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (NetworkTools.isNetConnect(getApplicationContext())) {
                if (relative_layout != null) {
                    relative_layout.setVisibility(View.GONE);
                }
            } else {
                if (relative_layout == null) {
                    ((ViewStub) findViewById(R.id.view_stub)).inflate();
                    relative_layout = findViewById(R.id.relative_layout);
                    relative_layout.setOnClickListener(this);
                } else {
                    relative_layout.setVisibility(View.VISIBLE);
                }
            }
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.relative_layout:
                    intentSystemSettings();
                    break;
            }
        }

        /**
         * 跳转到系统设置界面
         */
        public void intentSystemSettings() {
            try {
                // 跳转到系统的网络设置界面
                Intent intentSettings = null;
                // 先判断当前系统版本
                if (android.os.Build.VERSION.SDK_INT > 10) {  // 3.0以上
                    intentSettings = new Intent(android.provider.Settings.ACTION_WIFI_SETTINGS);
                } else {
                    intentSettings = new Intent();
                    intentSettings.setClassName("com.android.settings", "com.android.settings.WirelessSettings");
                }
                startActivity(intentSettings);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_internet:
                Intent intent = new Intent(this, DefineRecyclerActivity.class);
                startActivity(intent);
                break;
            case R.id.button_mvp:
                MvpActivity.startActivityEnter(this);
                break;
            case R.id.start_new_activity:
                Intent intentWeb = new Intent(this, WebNewActivity.class);
                startActivity(intentWeb);
                break;
            case R.id.button_state_mode://状态模式
                StateActivity.startEnterActivity(this);
                break;
            case R.id.button_rxjava_mode://rxjava的训练
                RxJavaActivity.startEnterActivity(this);
                break;
            case R.id.button_duty:
                DutyActivity.startEnterActivity(this);
                break;
        }
    }
}
