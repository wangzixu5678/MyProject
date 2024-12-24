package com.duodian.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.webkit.WebView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.blankj.utilcode.util.ThreadUtils
import com.blankj.utilcode.util.ToastUtils


class MainActivity5 : AppCompatActivity() {

    private val mHandler = Handler()


    //1

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main5)

        var count = 0



        findViewById<Button>(R.id.btn_switch_language).setOnClickListener {
            //getUser()

            Log.d("AAA","安装间隔时间" +  ScreenUtil.getCurDayNatureDaySinceInstall())
            //LanguageUtil.switchLanguage(Language.CHINA,this,MainActivity5::class.java )
//getUser(i)
           //ToastUtils.showLong(resources.getString(R.string.farewell))
        //    recreate()
        }






    }


    override fun attachBaseContext(newBase: Context?) {
        Log.d("AAA","attachBaseContext")
        var webView = WebView(App.context)
        webView.loadUrl("https://horizon-dev.afafb.com/tt")
        super.attachBaseContext(LanguageUtil.getNewLocalContext(newBase));
    }

    var total = 0
    var totalPlan1 = 0
    var totalPlan2 = 0


    private fun getUser(){
        var currentTimeMillis = System.currentTimeMillis()
        var percentage = Math.abs(currentTimeMillis % 100)
        total++
        if (percentage<20){
            if (Math.abs(currentTimeMillis % 2) == 0L){
                totalPlan1++
                Log.d("AAA","进入方案1")
            }else{
                totalPlan2++
                Log.d("AAA","进入方案2")
            }
        }
        Log.d("AAA","总点击：" + total +"\n" + "命中方案1:" + totalPlan1 +"\n" + "命中方案2:" + totalPlan2)
    }



}