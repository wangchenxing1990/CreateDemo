package mvp.wangyukui.com.myapplication.strategyMode;

/**
 * Created by lenvo on 2018/11/19.
 */

public class SuperDuck extends Duck {
    public SuperDuck() {
        super.setFlyBehavior(new FlyWithRocketPower());
    }

    @Override
    public void display() {

    }
}
