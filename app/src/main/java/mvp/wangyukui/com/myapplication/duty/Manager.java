package mvp.wangyukui.com.myapplication.duty;

/**
 * Created by lenvo on 2018/11/13.
 */

public class Manager implements Ratify {
    @Override
    public Result deal(Chain chain) {
        Request request = chain.request();
        if (request.days() > 3) {
            Request newRequest = new Request.Builder()
                    .setManagerInfo(request.name() + "每个月的KPI考核还不错,可以批准")
                    .build();
            return chain.process(newRequest);
        }
        return new Result(true, "早点事办完,项目离不开你");
    }
}
