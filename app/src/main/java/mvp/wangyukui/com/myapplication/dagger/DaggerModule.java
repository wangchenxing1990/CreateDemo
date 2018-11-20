package mvp.wangyukui.com.myapplication.dagger;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wangyukui on 2018/11/4.
 */
@Module
public class DaggerModule {
    @Provides
    NewCart providesNewCart() {
        return new NewCart();
    }
}
