package com.pseudo.open2you

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.*

class MainActivity : AppCompatActivity() {

    private lateinit var defaultUrl : String
    private lateinit var webView : WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        webView = findViewById(R.id.mainWebView)

        defaultUrl = getString(R.string.default_url)
        val chromeClient = WebChromeClient()
        val webClient = WebViewClient()
    
        val cookieManager : CookieManager = CookieManager.getInstance()
        cookieManager.setAcceptCookie(true)

        webView.webChromeClient = chromeClient
        webView.webViewClient = webClient
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true

        webView.loadUrl(defaultUrl)
    }

    override fun onBackPressed() {
        val backForwardList : WebBackForwardList = webView.copyBackForwardList()
        if(backForwardList.currentIndex == 0)
        {
            super.onBackPressed()
        }
        else
        {
            webView.goBack()
        }
    }
}
