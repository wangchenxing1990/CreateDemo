package mvp.wangyukui.com.myapplication.duty;

/**
 * Created by lenvo on 2018/11/13.
 */

public class DepartLeader implements Ratify {
    @Override
    public Result deal(Chain chain) {
        Request request = chain.request();
        if (request.days() > 7) {
            return new Result(false, "你这个完全没有必要");
        }
        return new Result(true, "你这个不要着急,把事情办万再回来");
    }
}
