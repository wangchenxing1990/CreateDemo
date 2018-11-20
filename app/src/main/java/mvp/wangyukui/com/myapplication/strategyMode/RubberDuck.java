package mvp.wangyukui.com.myapplication.strategyMode;

/**
 * Created by lenvo on 2018/11/19.
 */

public class RubberDuck extends Duck {
    public RubberDuck() {
        super.setFlyBehavior(new FlyNoWay());
    }

    @Override
    public void display() {

    }
}
