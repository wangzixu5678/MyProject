package com.duodian.myapplication

import android.os.Bundle
import android.telecom.Call
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ThreadUtils
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException


class MainActivity2 : AppCompatActivity() {

    private lateinit var mOkHttpClient: OkHttpClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        mOkHttpClient = OkHttpClient()

    }

    //按钮触发
    fun btnGo(view: View) {
        startSSE()
    }


    private fun startSSE() {
        //192.168.144.36本地IP
        val request: Request = Request.Builder()
            .url("https://zppost.58.com/common-new/event-stream") // 你的SSE流URL
            .build()

        mOkHttpClient.newCall(request).enqueue(object :Callback{
            override fun onFailure(call: okhttp3.Call, e: IOException) {
                e.printStackTrace()
            }
            override fun onResponse(call: okhttp3.Call, response: Response) {
                if (!response.isSuccessful) {
                    throw IOException("Unexpected code $response")
                }
                response.body?.let {
                    val source = it.source()
                    while (!source.exhausted()) {
                        val line = source.readUtf8Line()?:""
                        LogUtils.d("SSE",line)
                    }
                }

            }
        })
    }



}