package mvp.wangyukui.com.myapplication.duty;


import java.util.List;

/**
 * Created by lenvo on 2018/11/13.
 */

public class RealChain implements Ratify.Chain {
    public List<Ratify> ratifyList;
    private Request request;
    private int index;

    public RealChain(List<Ratify> ratifyList, Request request, int index) {
        this.ratifyList = ratifyList;
        this.request = request;
        this.index = index;
    }

    @Override
    public Request request() {
        return request;
    }

    @Override
    public Result process(Request request) {
        Result process = null;
        if (ratifyList.size() > index) {
            RealChain realChain = new RealChain(ratifyList, request, index + 1);
            Ratify ratify = ratifyList.get(index);
            process = ratify.deal(realChain);
        }
        return process;
    }
}
