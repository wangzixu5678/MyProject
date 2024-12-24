package com.duodian.myapplication

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import android.webkit.WebView
import com.blankj.utilcode.util.NetworkUtils
import com.facebook.drawee.backends.pipeline.Fresco


class App : Application() {
    companion object{
       lateinit var context:Context
    }
    override fun onCreate() {

        super.onCreate()
        context = this
        Fresco.initialize(this)
        ClickEventManager.initialize(this)
        var webView = WebView(this)
        webView.loadUrl("https://horizon-dev.afafb.com/tt")
    }


    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(LanguageUtil.attachBaseContext(base))


    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        LanguageUtil.attachBaseContext(this);
    }

}

