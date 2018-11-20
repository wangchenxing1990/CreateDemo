package mvp.wangyukui.com.myapplication.cycler;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import mvp.wangyukui.com.myapplication.MainActivity;
import mvp.wangyukui.com.myapplication.R;

/**
 * Created by lenvo on 2018/11/20.
 */

public class CyclerActivity extends AppCompatActivity {

    public static void startEnterActivity(MainActivity mainActivity) {
        mainActivity.startActivity(new Intent(mainActivity,CyclerActivity.class));
    }
    private WaveView wave_view;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cycler);
        wave_view=findViewById(R.id.wave_view);
        wave_view.setFlowNum(50);
        wave_view.setUpSpeed(0);
        wave_view.setWaveSpeed(10);
    }

}
