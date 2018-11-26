package mvp.wangyukui.com.myapplication.drawFunction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import mvp.wangyukui.com.myapplication.R;

/**
 * Created by lenvo on 2018/11/26.
 */

public class DrawPathActivity extends AppCompatActivity {
    public static void startEnterActivity(Activity mActivity) {
        mActivity.startActivity(new Intent(mActivity, DrawPathActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_path);
    }


}
