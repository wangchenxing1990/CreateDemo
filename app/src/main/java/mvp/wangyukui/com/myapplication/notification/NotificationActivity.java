package mvp.wangyukui.com.myapplication.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

import mvp.wangyukui.com.myapplication.GlideApp;
import mvp.wangyukui.com.myapplication.MainActivity;
import mvp.wangyukui.com.myapplication.R;

/**
 * Created by lenvo on 2018/12/4.
 */

public class NotificationActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button_chat_notification;
    private Button button_service_notification;
    NotificationManager mNotificationManager;
    private ImageView imageView;
    public static void startEnterActivity(Activity mainActivity) {
        mainActivity.startActivity(new Intent(mainActivity, NotificationActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        createAllNotificationChannel();
        imageView=findViewById(R.id.image_view);
        button_chat_notification = findViewById(R.id.button_chat_notification);
        button_service_notification = findViewById(R.id.button_service_notification);
        button_chat_notification.setOnClickListener(this);
        button_service_notification.setOnClickListener(this);
        disPlay();
    }


    public void disPlay(){
        GlideApp.with(this)
                .load(R.mipmap.system_setting)
                .transform(new RoundedCorners(50))
                .into(imageView);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_chat_notification:
                publicNotification();
                break;
            case R.id.button_service_notification:
                break;
        }
    }

    private void publicNotification() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "chat");
//            Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(""));
//            PendingIntent mPendingIntent = PendingIntent.getActivity(this, 0, mIntent, 0);
//            builder.setContentIntent(mPendingIntent);
            builder.setContentTitle("收到一条聊天消息");
            builder.setContentText("今天中午吃什么？");
            builder.setAutoCancel(true);
            builder.setSmallIcon(R.mipmap.ic_launcher);
            builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));

            Notification notification = builder.build();
            mNotificationManager.notify(1, notification);
        } else {
            Notification.Builder builder = new Notification.Builder(this);
            Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(""));
            PendingIntent mPendingIntent = PendingIntent.getActivity(this, 0, mIntent, 0);
            builder.setContentIntent(mPendingIntent);
            builder.setAutoCancel(true);
            builder.setSmallIcon(R.mipmap.ic_launcher);
            builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
            builder.setContentTitle("普通通知");

            Notification notification = builder.getNotification();
            mNotificationManager.notify(1, notification);
        }

    }

    /**
     * 创建所有的消息通知渠道
     */
    private void createAllNotificationChannel() {
        String channelId = "chat";
        String channelName = "聊天消息";
        int importance = NotificationManager.IMPORTANCE_HIGH;
        createChannel(channelId, channelName, importance);
        channelId = "subscribe";
        channelName = "订阅消息";
        importance = NotificationManager.IMPORTANCE_DEFAULT;
        createChannel(channelId, channelName, importance);
    }

    private void createChannel(String channelId, String channel_name, int importance) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(channelId, channel_name, importance);
            mNotificationManager.createNotificationChannel(notificationChannel);
        }
    }


}
