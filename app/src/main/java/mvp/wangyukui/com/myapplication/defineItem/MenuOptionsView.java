package mvp.wangyukui.com.myapplication.defineItem;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import mvp.wangyukui.com.myapplication.R;

/**
 * Created by lenvo on 2018/11/19.
 */

public class MenuOptionsView extends RelativeLayout implements View.OnClickListener {
    private Context context;
    private String leftTitle = "";
    private String rightTitle = "";
    private String centerTitle = "";
    private int imageLeft, imageRight;
    private float imageLeftPadding, imageRightPadding;
    private float titleLeftSize, titleRightSize, titleCenterSize;
    private View rootView;
    private TextView tv_title_center;
    private TextView tv_title_left;
    private TextView tv_title_right;
    private ImageView iv_left, iv_right;
    private RelativeLayout rl_content;
    private MenuOptionsClickListener menuOptionsClickListener;
    private MenuOptionsLeftIngClickListener menuOptionsLeftIngClickListener;
    private MenuOptionsRImgClickListener menuOptionsRImgClickListener;
    private MenuOptionsTvRightClickListener menuOptionsTvRightClickListener;
    private MenuOptionsTvLeftClickListener menuOptionsTvLeftClickListener;

    public MenuOptionsView(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    public MenuOptionsView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(context, attrs);
    }


    public MenuOptionsView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        initTypeArray(context, attrs);
        initView();
    }


    /**
     * 初始化arrayType
     *
     * @param context
     * @param attrs
     */
    private void initTypeArray(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.menu_options_view);
        leftTitle = typedArray.getString(R.styleable.menu_options_view_title_left);
        rightTitle = typedArray.getString(R.styleable.menu_options_view_title_right);
        centerTitle = typedArray.getString(R.styleable.menu_options_view_title_center);

        imageLeft = typedArray.getResourceId(R.styleable.menu_options_view_image_left_src, -1);
        imageRight = typedArray.getResourceId(R.styleable.menu_options_view_image_right_src, -1);
        imageLeftPadding = typedArray.getDimension(R.styleable.menu_options_view_imageLeftPadding, 0);
        imageRightPadding = typedArray.getDimension(R.styleable.menu_options_view_imageRightPadding, 0);

        titleLeftSize = typedArray.getDimension(R.styleable.menu_options_view_titleLeftSize, 0);
        titleCenterSize = typedArray.getDimension(R.styleable.menu_options_view_titleCenterSize, 0);
        titleRightSize = typedArray.getDimension(R.styleable.menu_options_view_titleRightSize, 0);

        typedArray.recycle();

    }

    /**
     * 初始化view
     */
    private void initView() {
        rootView = LayoutInflater.from(context).inflate(R.layout.menu_options_view, null);
        this.addView(rootView);
        rl_content = rootView.findViewById(R.id.rl_content);
        tv_title_center = rootView.findViewById(R.id.tv_title_center);
        tv_title_left = rootView.findViewById(R.id.tv_title_left);
        tv_title_right = rootView.findViewById(R.id.tv_title_right);

        iv_left = rootView.findViewById(R.id.iv_left);
        iv_right = rootView.findViewById(R.id.iv_right);

        tvStateChange();

        iv_left.setImageResource(imageLeft);
        iv_right.setImageResource(imageRight);

        tv_title_center.setText(centerTitle);
        tv_title_left.setText(leftTitle);
        tv_title_right.setText(rightTitle);

        tv_title_center.setTextSize(titleCenterSize);
        tv_title_left.setTextSize(titleLeftSize);
        tv_title_right.setTextSize(titleRightSize);

        iv_left.setOnClickListener(this);
        iv_right.setOnClickListener(this);

        tv_title_left.setOnClickListener(this);
        tv_title_right.setOnClickListener(this);
        tv_title_center.setOnClickListener(this);
        rl_content.setOnClickListener(this);

    }

    public void tvStateChange() {
        int k = 0;
        tv_title_center.setVisibility(GONE);
        if (centerTitle == null || centerTitle.equals("")) {
            tv_title_center.setVisibility(GONE);
        } else {
            tv_title_center.setVisibility(VISIBLE);
            tv_title_left.setVisibility(GONE);
            tv_title_right.setVisibility(GONE);
            return;
        }
        if (leftTitle == null || leftTitle.equals("")) {
            tv_title_left.setVisibility(GONE);
        } else {
            tv_title_left.setVisibility(VISIBLE);
            k++;
        }

        if (rightTitle == null || rightTitle.equals("")) {
            tv_title_right.setVisibility(GONE);
        } else {
            tv_title_right.setVisibility(VISIBLE);
            k++;
        }
        if (k == 2) {
            tv_title_center.setVisibility(VISIBLE);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_content:
                if (menuOptionsClickListener != null) {
                    menuOptionsClickListener.layoutClickLayout();
                }
                break;
            case R.id.iv_left:
                if (menuOptionsClickListener != null) {
                    menuOptionsClickListener.layoutClickLayout();
                    break;
                }
                if (menuOptionsLeftIngClickListener != null) {
                    menuOptionsLeftIngClickListener.leftImageClick();
                }
                break;
            case R.id.iv_right:
                if (menuOptionsClickListener != null) {
                    menuOptionsClickListener.layoutClickLayout();
                    break;
                }
                if (menuOptionsRImgClickListener != null) {
                    menuOptionsRImgClickListener.rightImageClick();
                }
                break;
            case R.id.tv_title_center:
                if (menuOptionsClickListener != null) {
                    menuOptionsClickListener.layoutClickLayout();
                    break;
                }
                break;
            case R.id.tv_title_right:
                if (menuOptionsClickListener != null) {
                    menuOptionsClickListener.layoutClickLayout();
                    break;
                }
                if (menuOptionsTvRightClickListener != null) {
                    menuOptionsTvRightClickListener.tvRightClick();
                }
                break;
        }
    }

    public interface MenuOptionsClickListener {
        void layoutClickLayout();
    }

    public void setMenuOptionsClickListener(MenuOptionsClickListener menuOptionsClickListener) {
        this.menuOptionsClickListener = menuOptionsClickListener;
    }

    public interface MenuOptionsLeftIngClickListener {
        void leftImageClick();
    }

    public void setMenuOptionsLeftIngClickListener(MenuOptionsLeftIngClickListener menuOptionsLeftIngClickListener) {
        this.menuOptionsLeftIngClickListener = menuOptionsLeftIngClickListener;
    }

    public interface MenuOptionsRImgClickListener {
        void rightImageClick();
    }

    public void setMenuOptionsRImgClickListener(MenuOptionsRImgClickListener menuOptionsRImgClickListener) {
        this.menuOptionsRImgClickListener = menuOptionsRImgClickListener;
    }

    public interface MenuOptionsTvRightClickListener {
        void tvRightClick();
    }

    public void setMenuOptionsTvRightClickListener(MenuOptionsTvRightClickListener menuOptionsTvRightClickListener) {
        this.menuOptionsTvRightClickListener = menuOptionsTvRightClickListener;
    }

    public interface MenuOptionsTvLeftClickListener {
        void tvLeftClick();
    }

    public void setMenuOptionsTvLeftClickListener(MenuOptionsTvLeftClickListener menuOptionsTvLeftClickListener) {
        this.menuOptionsTvLeftClickListener = menuOptionsTvLeftClickListener;
    }
}
