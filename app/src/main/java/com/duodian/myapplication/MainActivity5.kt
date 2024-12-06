package com.duodian.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.blankj.utilcode.util.ToastUtils


class MainActivity5 : AppCompatActivity() {

    private val mHandler = Handler()

    //test1

    //test2
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main5)


        findViewById<Button>(R.id.btn_switch_language).setOnClickListener {
            LanguageUtil.updateApplicationLocale(this, Language.CHINA)

            ToastUtils.showLong(resources.getString(R.string.farewell))
        }





    }


    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(LanguageUtil.getNewLocalContext(newBase));
    }



}