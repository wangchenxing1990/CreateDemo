package mvp.wangyukui.com.myapplication.duty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenvo on 2018/11/13.
 */

public class ChainOfResponsibilityClient {
    private List<Ratify> ratifyList;

    public ChainOfResponsibilityClient() {
        new ArrayList<Ratify>();
    }

    public void addRatifys(Ratify ratify) {
        ratifyList.add(ratify);
    }

    public Result execute(Request request) {
        ArrayList<Ratify> arrayList = new ArrayList<Ratify>();
        arrayList.addAll(ratifyList);
        arrayList.add(new GroupLeader());
        arrayList.add(new Manager());
        arrayList.add(new DepartLeader());

        RealChain realChain = new RealChain(arrayList, request, 0);
        return realChain.process(request);
    }
}
