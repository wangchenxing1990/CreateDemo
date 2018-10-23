package mvp.wangyukui.com.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by lenvo on 2018/10/19.
 */

public class WebNewActivity extends Activity {
    private WebView webView;
    String url="https://a45.me/?sid=23791711B5I70028A168M6&mode=onlybac&lang=cn";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_web_view);
        webView=findViewById(R.id.webView);
        WebSettings setting = webView.getSettings();


        setting.setJavaScriptEnabled(true);
        setting.setUseWideViewPort(true);
        setting.setCacheMode(WebSettings.LOAD_NORMAL);
        setting.setLoadWithOverviewMode(true);
        setting.setAllowFileAccess(true);
        setting.setNeedInitialFocus(true);
        setting.setJavaScriptCanOpenWindowsAutomatically(true);
        setting.setLoadsImagesAutomatically(true);
        setting.setLightTouchEnabled(true);

        webView.setWebViewClient(new WebViewClient(){
            public void onPageFinished(WebView view, String url) {

            }
            @Override
            public void onLoadResource(WebView view, String url) {


            }


            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }

        });
        webView.setWebChromeClient(new WebChromeClient());
//        setting.setDomStorageEnabled(true);
        webView.loadUrl(url);
    }
}
