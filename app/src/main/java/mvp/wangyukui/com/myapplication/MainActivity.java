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

import java.io.IOException;

import mvp.wangyukui.com.myapplication.defineRecycler.DefineRecyclerActivity;

public class MainActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    private EditText edit_text_account;
    private EditText edit_text_password;
    private Button button_login;
    private Button button_register;
    private RelativeLayout relative_progress;
    private PresenterRequest presenterRequest;
    private ViewStub viewStub;
    private RelativeLayout relative_layout;
    private MyNetWorkBroadcastReceiver registerReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_text_account = findViewById(R.id.edit_text_account);
        edit_text_password = findViewById(R.id.edit_text_password);
        button_login = findViewById(R.id.button_login);
        button_register = findViewById(R.id.button_register);
        relative_progress = findViewById(R.id.relative_progress);
        relative_progress.setVisibility(View.INVISIBLE);
        button_register.setOnClickListener(this);
        button_login.setOnClickListener(this);
        presenterRequest = new PresenterRequest(this);

//        viewStub = findViewById(R.id.view_stub);
        registerReceiver = new MyNetWorkBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(registerReceiver, intentFilter);
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
                Intent intent=new Intent(this,DefineRecyclerActivity.class);
                startActivity(intent);
                break;
            case R.id.button_login:
                String account = edit_text_account.getText().toString().trim();
                String password = edit_text_password.getText().toString().trim();
                presenterRequest.clickRequest(account, password);
                break;
        }
    }
}
