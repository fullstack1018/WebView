package com.test.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.CookieManager;
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

        CookieManager cookieManager = CookieManager.getInstance();
//        String cookies = cookieManager.getCookie(url);
//        if(cookies != null){
//            String[] temp=cookies.split(";");
//            for (String ar1 : temp ){
//                if(ar1.contains(CookieName)){
//                    String[] temp1=ar1.split("=");
//                    CookieValue = temp1[1];
//                }
//            }
//        }
        String cookies = CookieManager.getInstance().getCookie(url);
        webView.loadUrl(url);
        Log.e("cookies", cookies);
    }

}