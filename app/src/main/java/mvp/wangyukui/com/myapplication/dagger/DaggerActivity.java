package mvp.wangyukui.com.myapplication.dagger;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import mvp.wangyukui.com.myapplication.R;

/**
 * Created by wangyukui on 2018/11/4.
 */

public class DaggerActivity extends AppCompatActivity {
    @Inject
    NewCart newCart;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);
        DaggerDaggerComponent.create()
                .inject(this);
        DaggerDaggerComponent.builder().daggerModule(new DaggerModule())
                .build();
        newCart.setEatMouse();
    }
}
