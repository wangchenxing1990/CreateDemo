package mvp.wangyukui.com.myapplication.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import mvp.wangyukui.com.myapplication.MainActivity;
import mvp.wangyukui.com.myapplication.R;

/**
 * Created by lenvo on 2018/12/4.
 */

public class NotificationActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button_public_notification;
    NotificationManager mNotificationManager;
    public static void startEnterActivity(Activity mainActivity) {
        mainActivity.startActivity(new Intent(mainActivity, NotificationActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        button_public_notification = findViewById(R.id.button_public_notification);
        button_public_notification.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_public_notification:
                publicNotification();
                break;
        }
    }

    private void publicNotification() {

        Notification.Builder builder=new Notification.Builder(this);
        Intent mIntent=new Intent(Intent.ACTION_VIEW, Uri.parse(""));
        PendingIntent mPendingIntent=PendingIntent.getActivity(this,0,mIntent,0);
        builder.setContentIntent(mPendingIntent);
        builder.setAutoCancel(true);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
        builder.setContentTitle("普通通知");
//        if (){
//
//        }else{
//
//        }
        Notification notification=builder.getNotification();
        mNotificationManager.notify(1,notification);
    }


}
