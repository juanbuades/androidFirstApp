package com.example.ej04_juan_buades;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Web1fragment extends Fragment {
    String web = "https://www.youtube.com/watch?v=bePCRKGUwAY";
    String url1Modified;
    WebView webView1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentweb1,container,false);
        webView1 = view.findViewById(R.id.url1View);
        if (url1Modified == null) {
            webView1.loadUrl(web);
        } else {
            webView1.loadUrl(url1Modified);
        }
        webView1.setWebViewClient(new WebViewClient()
        {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });
        WebSettings webSettings = webView1.getSettings();
        webSettings.setJavaScriptEnabled(true);
        return view;
    }

    public void url1Modified (String url1Modified) {
        this.url1Modified = url1Modified;
    }
}
