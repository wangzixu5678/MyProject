package com.duodian.myapplication

import android.content.*
import android.content.res.Configuration
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View

import android.widget.ImageView
import com.blankj.utilcode.util.AdaptScreenUtils
import com.blankj.utilcode.util.ConvertUtils
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ScreenUtils
import com.blankj.utilcode.util.ThreadUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }




    override fun onResume() {
        super.onResume()
        ThreadUtils.runOnUiThreadDelayed(Runnable {
            var density1 = Resources.getSystem().displayMetrics.density
            var density2 = resources.displayMetrics.density
            LogUtils.d("density1 = ${density1}density2 = ${density2} 100dp = ${ConvertUtils.px2dp(btn2.width.toFloat())}")
        },2000)
    }


    override fun getResources(): Resources {
        val resources = super.getResources()
        val ori: Int = resources.configuration.orientation
        return if (ori == Configuration.ORIENTATION_PORTRAIT) {
            AdaptScreenUtils.adaptWidth(resources, 360)
        } else {
            AdaptScreenUtils.adaptHeight(resources, 360, false)
        }
    }
}