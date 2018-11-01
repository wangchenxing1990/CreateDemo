package mvp.wangyukui.com.myapplication.rxjava;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by lenvo on 2018/11/1.
 */

public interface CreateService {
    @GET("top250")
    Call<ServiceBean> getService(@Query("start") int start,@Query("count") int count);
}
