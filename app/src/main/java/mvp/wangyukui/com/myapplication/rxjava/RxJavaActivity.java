package mvp.wangyukui.com.myapplication.rxjava;

import android.content.Intent;
import android.database.Observable;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import mvp.wangyukui.com.myapplication.MainActivity;
import mvp.wangyukui.com.myapplication.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by lenvo on 2018/10/31.
 */

public class RxJavaActivity extends AppCompatActivity {
    private static String BASE_URL = "https://api.douban.com/v2/movie/";
    private TextView text_view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);
//        BitmapFactory.decodeResource();
//        BitmapFactory.decodeFile();
        text_view = findViewById(R.id.text_view);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CreateServiceRxJava createService = retrofit.create(CreateServiceRxJava.class);
        createService.getService(0, 20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ServiceBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ServiceBean serviceBean) {
                        serviceBean.getSubjects();
                    }
                });
//        Call<ServiceBean> service = createService.getService(0, 20);
//        service.enqueue(new Callback<ServiceBean>() {
//            @Override
//            public void onResponse(Call<ServiceBean> call, Response<ServiceBean> response) {
//                String string = response.body().toString();
//                text_view.setText(response.body().getTitle()+"");
//                Log.i("BASE_URL", string);
//            }
//
//            @Override
//            public void onFailure(Call<ServiceBean> call, Throwable t) {
//
//            }
//        });
    }

    public static void startEnterActivity(MainActivity mainActivity) {
        mainActivity.startActivity(new Intent(mainActivity,RxJavaActivity.class));
    }
}
