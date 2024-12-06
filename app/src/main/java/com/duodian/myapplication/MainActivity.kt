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

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }




    override fun onResume() {
        super.onResume()

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