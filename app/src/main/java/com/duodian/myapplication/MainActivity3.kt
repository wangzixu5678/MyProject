package com.duodian.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity



class MainActivity3 : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "ClickableViewAccessibility", "DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)





    }

    fun btnAnim(view: View) {
       startActivity(Intent(this,MainActivity4::class.java))
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {

        return super.dispatchTouchEvent(ev)

    }


}