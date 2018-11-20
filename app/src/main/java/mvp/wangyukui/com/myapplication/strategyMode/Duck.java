package mvp.wangyukui.com.myapplication.strategyMode;

/**
 * Created by lenvo on 2018/11/19.
 */

public abstract class Duck {
    private FlyBehavior flyBehavior;
    public Duck(){

    }
    public void fly(){
    this.flyBehavior.fly();
    }

    public void setFlyBehavior(FlyBehavior flyBehavior){
        this.flyBehavior=flyBehavior;
    }

    public void swing(){

    }

    public abstract void display();

}
