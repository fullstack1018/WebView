package com.test.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    WebView webView;

    String url = "https://ind.millenniumbcp.pt/_layouts/BCP.SDC.FEP.Foundation.Presentation/Login.aspx";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.web);
        String CookieValue = null;

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setDatabaseEnabled(true);
//        CookieManager.getInstance().removeAllCookies(null);
        CookieManager.getInstance().setAcceptCookie(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);

//        CookieManager.getInstance().setCookie(url,"cookies-state=accepted");
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url1) {
                String cookies = CookieManager.getInstance().getCookie(url);
                Log.e("cookies", cookies);
                // Convert the cookies to a universal format
                CookieManager.getInstance().setAcceptCookie(true);

                super.onPageFinished(view, url1);
            }
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                webView.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
    }

}