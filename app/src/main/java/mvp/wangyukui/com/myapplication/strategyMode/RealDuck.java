package mvp.wangyukui.com.myapplication.strategyMode;

/**
 * Created by lenvo on 2018/11/19.
 */

public class RealDuck extends Duck {
    public RealDuck(){
        super.setFlyBehavior(new FlyWidthWing());
    }
    @Override
    public void display() {

    }
}
