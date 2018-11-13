package mvp.wangyukui.com.myapplication.duty;

/**
 * 处理请求
 * Created by lenvo on 2018/11/13.
 */

public interface Ratify {
    //处理请求
    public Result deal(Chain chain);

    /**
     * 接口描述  对result和request进行封装
     */
    interface Chain {
        //获取当前request
        Request request();

        //转发request
        Result process(Request request);
    }
}
