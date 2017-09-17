package com.seatedclimb.main;


import android.content.Intent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Custom webview class
 */
public class webview extends WebViewClient {
    /**
     * URL load Override
     * @param view
     * @param request
     * @return
     */
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        // when the url hostname is "itcrowd.hu" the not open outside the application,
        if (request.getUrl().getHost().equals("itcrowd.hu")) {
            view.loadUrl(request.getUrl().toString());
        } else {
            Intent intent = new Intent(Intent.ACTION_VIEW, request.getUrl());
            view.getContext().startActivity(intent);
        }
        return true;
    }
}
