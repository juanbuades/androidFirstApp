package com.example.ej04_juan_buades;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Web2fragment extends Fragment {
    String web = "https://www.amazon.es/Jay-JA0027-Nada-de-regalo/dp/B019HDSCPU/ref=sr_1_1?s=kitchen&ie=UTF8&qid=1535962640&sr=1-1&keywords=nada";
    String url2Modified;
    WebView webView2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentweb2,container,false);
        webView2 = view.findViewById(R.id.url2View);
        if (url2Modified == null) {
            webView2.loadUrl(web);
        } else {
            webView2.loadUrl(url2Modified);
        }
        webView2.setWebViewClient(new WebViewClient()
        {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });
        WebSettings webSettings = webView2.getSettings();
        webSettings.setJavaScriptEnabled(true);
        return view;
    }

    public void url2Modified (String url2Modified) {
        this.url2Modified = url2Modified;
    }
}
