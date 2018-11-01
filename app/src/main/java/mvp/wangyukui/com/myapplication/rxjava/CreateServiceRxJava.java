package mvp.wangyukui.com.myapplication.rxjava;



import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lenvo on 2018/11/1.
 */

public interface CreateServiceRxJava {
    @GET("top250")
    Observable<ServiceBean> getService(@Query("start") int start, @Query("count") int count);
}
