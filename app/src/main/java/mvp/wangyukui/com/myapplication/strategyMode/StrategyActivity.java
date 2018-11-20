package mvp.wangyukui.com.myapplication.strategyMode;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import mvp.wangyukui.com.myapplication.MainActivity;
import mvp.wangyukui.com.myapplication.R;

/**
 * Created by lenvo on 2018/11/19.
 */

public class StrategyActivity extends AppCompatActivity {

    public static void startEnterActivity(MainActivity mainActivity) {
        mainActivity.startActivity(new Intent(mainActivity, StrategyActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strategy);
    }
}
