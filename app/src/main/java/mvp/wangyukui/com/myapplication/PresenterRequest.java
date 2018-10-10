package mvp.wangyukui.com.myapplication;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by lenvo on 2018/5/17.
 */

public class PresenterRequest {
    private LoginView loginView;
    private RequestLoginModel requestLoginModel;
    public PresenterRequest(LoginView loginView){
        this.loginView=loginView;
        this.requestLoginModel=new RequestLoginModel();
    }

    public void clickRequest(String account, String password){
        if (account == null || TextUtils.isEmpty(account)) {
            Toast.makeText(MyApplication.myContext, R.string.text_account, Toast.LENGTH_SHORT).show();
            return;
        }
        if (password == null || TextUtils.isEmpty(password)) {
            Toast.makeText(MyApplication.myContext, R.string.text_password, Toast.LENGTH_SHORT).show();
            return;
        }
        loginView.requestShow();
        requestLoginModel.clickLoginRequest(account, password, new RequestCallString() {
            @Override
            public void successRequest(String string) {
                loginView.requestSuccess(string);
                handler.sendEmptyMessage(100);
            }

            @Override
            public void failureRequest(IOException e) {
                loginView.requestFailure(e);
                handler.sendEmptyMessage(100);
            }
        });
    }

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 100:
                    loginView.requestHide();
                    break;
            }
        }
    };
}
