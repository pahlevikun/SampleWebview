package com.aisyahastindrar.samplewebview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends ActionBarActivity {

    private WebView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "http://google.com.com/";  //Pendefinisian URL
        view = (WebView) this.findViewById(R.id.webView);  //sinkronisasi object berdasarkan id
        view.getSettings().setJavaScriptEnabled(true);
        view.getSettings().setBuiltInZoomControls(true);
        view.getSettings().setSupportZoom(true);
        view.setWebViewClient(new MyBrowser());
        view.loadUrl(url); //try js alert
        view.setWebChromeClient(new WebChromeClient()); // adding js alert support

    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //ketika disentuh tombol back
        if ((keyCode == KeyEvent.KEYCODE_BACK) && view.canGoBack()) {
            view.goBack(); //method goback() dieksekusi untuk kembali pada halaman sebelumnya
            return true;
        }
        // Jika tidak ada history (Halaman yang sebelumnya dibuka)
        // maka akan keluar dari activity
        return super.onKeyDown(keyCode, event);
    }

}