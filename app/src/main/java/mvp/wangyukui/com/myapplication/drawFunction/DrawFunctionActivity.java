package mvp.wangyukui.com.myapplication.drawFunction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import mvp.wangyukui.com.myapplication.R;

/**
 * Created by lenvo on 2018/11/26.
 */

public class DrawFunctionActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button_path,button_region;

    public static void startEnterActivity(Activity mActivity) {
        mActivity.startActivity(new Intent(mActivity, DrawFunctionActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_function);
        initView();
        initClickListener();
    }

    private void initView() {
        button_path = findViewById(R.id.button_path);
        button_region = findViewById(R.id.button_region);
    }

    private void initClickListener() {
        button_path.setOnClickListener(this);
        button_region.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_path:
                DrawPathActivity.startEnterActivity(this);
                break;
            case R.id.button_region:
                RegionActivity.startEnterActivity(this);
                break;
        }
    }
}
