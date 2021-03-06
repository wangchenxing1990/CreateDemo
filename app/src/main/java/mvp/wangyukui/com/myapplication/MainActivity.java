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

import mvp.wangyukui.com.myapplication.animation.AnimationActivity;
import mvp.wangyukui.com.myapplication.cycler.CyclerActivity;
import mvp.wangyukui.com.myapplication.defineItem.DefineItemActivity;
import mvp.wangyukui.com.myapplication.defineRecycler.DefineRecyclerActivity;
import mvp.wangyukui.com.myapplication.drawFunction.DrawFunctionActivity;
import mvp.wangyukui.com.myapplication.duty.DutyActivity;
import mvp.wangyukui.com.myapplication.mvp.MvpActivity;
import mvp.wangyukui.com.myapplication.mvp.PresenterRequest;
import mvp.wangyukui.com.myapplication.notification.NotificationActivity;
import mvp.wangyukui.com.myapplication.rxjava.RxJavaActivity;
import mvp.wangyukui.com.myapplication.statemode.StateActivity;
import mvp.wangyukui.com.myapplication.strategyMode.StrategyActivity;
import mvp.wangyukui.com.myapplication.tools.NetworkTools;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button_mvp;
    private Button button_internet;
    private Button start_new_activity;
    private RelativeLayout relative_layout;
    private MyNetWorkBroadcastReceiver registerReceiver;
    private TextView text_test;
    private Button button_circle, button_state_mode, button_rxJava_mode,
            button_duty, button_strategy, button_define_item, button_animation,
            button_draw_function,button_notification;

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
        button_strategy = findViewById(R.id.button_strategy);
        button_define_item = findViewById(R.id.button_define_item);
        button_circle = findViewById(R.id.button_circle);
        button_animation = findViewById(R.id.button_animation);
        button_draw_function = findViewById(R.id.button_draw_function);
        button_notification = findViewById(R.id.button_notification);
    }

    private void setOnClickListener() {
        button_mvp.setOnClickListener(this);
        button_internet.setOnClickListener(this);
        button_state_mode.setOnClickListener(this);
        button_rxJava_mode.setOnClickListener(this);
        start_new_activity.setOnClickListener(this);
        button_duty.setOnClickListener(this);
        button_strategy.setOnClickListener(this);
        button_define_item.setOnClickListener(this);
        button_circle.setOnClickListener(this);
        button_animation.setOnClickListener(this);
        button_draw_function.setOnClickListener(this);
        button_notification.setOnClickListener(this);
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
            case R.id.button_strategy:
                StrategyActivity.startEnterActivity(this);
                break;
            case R.id.button_define_item:
                DefineItemActivity.startEnterActivity(this);
                break;
            case R.id.button_circle:
                CyclerActivity.startEnterActivity(this);
                break;
            case R.id.button_animation:
                AnimationActivity.startEnterActivity(this);
                break;
            case R.id.button_draw_function:
                DrawFunctionActivity.startEnterActivity(this);
                break;
            case R.id.button_notification:
                NotificationActivity.startEnterActivity(this);
                break;
        }
    }
}
