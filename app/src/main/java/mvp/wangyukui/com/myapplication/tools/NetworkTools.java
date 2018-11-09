package mvp.wangyukui.com.myapplication.tools;

import android.app.ActivityManager;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by lenvo on 2018/11/8.
 */

public class NetworkTools {
    public static int CMNET = 3;
    public static int CMWAP = 2;
    public static int WIFI = 1;
    public static int NONETWORK = -1;

    public static boolean isNetConnect(Context context) {
        if (NONETWORK == getAPNType(context)) {
            return false;
        }
        return true;
    }

    private static int getAPNType(Context context) {
        int netType = NONETWORK;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null) {
            return netType;
        }
        int nType = networkInfo.getType();
        if (nType == ConnectivityManager.TYPE_MOBILE) {
            if (networkInfo.getExtraInfo() != null && networkInfo.getExtraInfo().toLowerCase().equals("cmnet")) {
                netType = CMNET;
            } else {
                netType = CMWAP;
            }

        }

        if (nType == ConnectivityManager.TYPE_WIFI) {
            netType = WIFI;
        }
        return netType;
    }
}
