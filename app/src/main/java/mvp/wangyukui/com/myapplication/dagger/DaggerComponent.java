package mvp.wangyukui.com.myapplication.dagger;

import dagger.Component;

/**
 * Created by wangyukui on 2018/11/4.
 */
@Component(modules = DaggerModule.class)
public interface DaggerComponent {
    void inject(DaggerActivity daggerActivity);
}
