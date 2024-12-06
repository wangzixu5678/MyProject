package com.duodian.myapplication

import android.content.Context
import android.content.SharedPreferences
import com.blankj.utilcode.util.LogUtils
import org.json.JSONArray
import org.json.JSONObject

object ClickEventManager {

    private const val SP_DATA_KEY = "clickEvents"
    private const val UPLOAD_DELAY_MILLIS: Long = 5000 // 5秒延迟
    private var firstClickTime: Long = 0
    private var preferences: SharedPreferences? = null


    fun initialize(context: Context) {
        preferences = context.getSharedPreferences("ClickEventPrefs", Context.MODE_PRIVATE)
    }

    // 保存点击事件到 SharedPreferences
    fun recordClickEvent(pageName: String, pointX: Float, pointY: Float, screen: String) {
        val currentTime = System.currentTimeMillis()
        if (firstClickTime == 0L) {
            firstClickTime = currentTime
        }
        val clickEvent = ClickEvent(
            pageName,
            pointX,
            pointY,
            screen,
            currentTime
        )
        val clickEventsArray = getStoredClickEvents()
        clickEventsArray.put(clickEvent.toJson())
        preferences?.edit()?.putString(SP_DATA_KEY, clickEventsArray.toString())?.apply()

        // 检查时间间隔是否大于5秒
        if (currentTime - firstClickTime >= UPLOAD_DELAY_MILLIS) {
            uploadClickEvents()
        }
    }

    // 获取存储的点击事件
    private fun getStoredClickEvents(): JSONArray {
        val eventsString = preferences?.getString(SP_DATA_KEY, "[]") ?: "[]"
        return JSONArray(eventsString)
    }


    // 上传点击事件到服务端
    private fun uploadClickEvents() {
        val storedEvents = getStoredClickEvents()
        if (storedEvents.length() > 0) {
            // 实际的上传逻辑，调用 API 接口上传
            uploadToServer(storedEvents)

            // 清空本地存储的点击事件
            preferences?.edit()?.remove(SP_DATA_KEY)?.apply()
            firstClickTime = 0L
        }
    }

    // 模拟上传事件到服务端
    private fun uploadToServer(events: JSONArray) {
        // 实现实际的上传逻辑，调用接口上传
        LogUtils.d("上传到服务器: $events")
    }

    // 点击事件的数据结构
    data class ClickEvent(
        val pageName: String,
        val pointX: Float,
        val pointY: Float,
        val screen: String,
        val timeMillis: Long
    ) {
        fun toJson(): JSONObject {
            return JSONObject().apply {
                put("pageName", pageName)
                put("pointX", pointX)
                put("pointY", pointY)
                put("screen", screen)
                put("timeMillis", timeMillis)
            }
        }
    }
}