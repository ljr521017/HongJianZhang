package com.android.hongjianzhang.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.android.hongjianzhang.R;

public class WebViewActivity extends AppCompatActivity {
    private WebView webView;

    private static String mUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        findView();
        initWebView();
    }

    private void initWebView() {
        WebSettings settings = webView.getSettings();
        // 设置内置的缩放控件，如果设为false，则webView不可缩放。
        settings.setBuiltInZoomControls(false);
        // 隐藏缩放控件
        settings.setDisplayZoomControls(true);
        // 不使用缓存
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        //Log.e("webView","启动时间" + System.currentTimeMillis());
        // 5.0是默认不支持mixed content的，即不支持同时加载https和http混合模式。
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        //Log.e("webView","启动时间" + System.currentTimeMillis());
        settings.setJavaScriptEnabled(true);

        webView.setWebChromeClient(new WebChromeClient(){

        });

        webView.setWebViewClient(new WebViewClient(){});
    }

    private void findView() {
        webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl(mUrl);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (webView.canGoBack()) {
                webView.goBack();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    public static void startWebViewActivity(Context context,String url){
        if (TextUtils.isEmpty(url)) {
            return;
        }else {
            mUrl = url;
        }
        context.startActivity(new Intent(context,WebViewActivity.class));
    }
}
