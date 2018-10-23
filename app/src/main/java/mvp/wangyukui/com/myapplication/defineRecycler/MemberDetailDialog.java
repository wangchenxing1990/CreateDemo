package mvp.wangyukui.com.myapplication.defineRecycler;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import mvp.wangyukui.com.myapplication.R;

/**
 * Created by lenvo on 2018/7/6.
 */

public class MemberDetailDialog extends Dialog implements View.OnClickListener {
    private Activity context;
    private View rootView;
    private WebView webView;
    private ImageView imageView;
    public MemberDetailDialog(@NonNull Activity context) {
        super(context, R.style.MyDialog);
        initView(context);
    }

    private void initView(Activity context) {
        this.context = context;
        int width = ViewGroup.LayoutParams.MATCH_PARENT;
//        int height = BaseTools.getWindowHeigh(context) * 2 / 3;
        int height = getWindowHeigh(context) * 2 / 3;
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Window win = this.getWindow();
        win.setGravity(Gravity.CENTER);
        win.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams lp = win.getAttributes();
        lp.width = width;   //宽度填满
        lp.height = height;  //高度自适应
        win.setAttributes(lp);
        rootView = LayoutInflater.from(context).inflate(R.layout.dialog_web_view, null);
        int padding = dp2px(context, 20);//setPadding(padding, 0, padding, 0)
        initRootView(context);
        setContentView(rootView);
        ((FrameLayout.LayoutParams) rootView.getLayoutParams()).setMargins(padding, 0, padding, 0);
    }


    private void initRootView(Context context) {
        imageView= rootView.findViewById(R.id.imageView);
        webView=rootView.findViewById(R.id.webView);
        imageView.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
      switch (view.getId()){
          case R.id.imageView:
              MemberDetailDialog.this.dismiss();
               break;
      }
    }

    /**
     * 获取当前屏幕分辨率 - 高度
     * @param context
     * @return
     */
    public static int getWindowHeigh(Context context) {
        WindowManager wm = (WindowManager) (context.getSystemService(Context.WINDOW_SERVICE));
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        int mScreenHeigh = dm.heightPixels;
        return mScreenHeigh;
    }

    public static int dp2px(Context context, float dp) {
        if (context == null) {
            return (int) ((dp * 2.5) + 0.5);
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) ((dp * displayMetrics.density) + 0.5);
    }
}
