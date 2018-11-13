package mvp.wangyukui.com.myapplication.duty;

/**
 * Created by lenvo on 2018/11/13.
 */

public class GroupLeader implements Ratify {
    @Override
    public Result deal(Chain chain) {
        Request request = chain.request();
        if (request.days() > 1) {
            Request newRequest = new Request.Builder().newRequest(request)
                    .setGroupLeaderInfo(request.name() + "平时表现不错,而且现在项目也不忙")
                    .build();
            return chain.process(newRequest);
        }

        return new Result(true, "早去早回");
    }
}
