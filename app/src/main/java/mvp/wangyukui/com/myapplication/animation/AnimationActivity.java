package mvp.wangyukui.com.myapplication.animation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import mvp.wangyukui.com.myapplication.MainActivity;
import mvp.wangyukui.com.myapplication.R;

/**
 * Created by lenvo on 2018/11/22.
 */

public class AnimationActivity extends AppCompatActivity {
    private Button button_scale;
    private TextView textView;
    private Animation animation;

    public static void startEnterActivity(MainActivity mainActivity) {
        mainActivity.startActivity(new Intent(mainActivity, AnimationActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        button_scale = findViewById(R.id.button_scale);
        textView = findViewById(R.id.text);
        animation = AnimationUtils.loadAnimation(this, R.anim.scaleanim);
        button_scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.startAnimation(animation);
            }
        });
    }


}
