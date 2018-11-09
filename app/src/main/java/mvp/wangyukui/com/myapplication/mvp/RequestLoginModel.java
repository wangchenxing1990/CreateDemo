package mvp.wangyukui.com.myapplication.mvp;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by lenvo on 2018/5/16.
 */

public class RequestLoginModel {

    public void clickLoginRequest(String account, String password, final RequestCallString callBack) {

        RequestBody requestBody = new FormBody.Builder()
                .add("username", account)
                .add("password", password)
                .add("client_id", "7")
                .add("client_secret", "Y4HkAcva7FOHR7cZg0QLRiTM95Sjyirf78eyRIov")
                .build();
        Request request = new Request.Builder()
                .post(requestBody)
                .url("http://www.bo-qu.com/api/user/login")
                .build();
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (callBack != null) {
                    callBack.failureRequest(e);
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (callBack != null) {
                    String string = response.body().string();
                    callBack.successRequest(string);
                }
            }
        });
    }
}
