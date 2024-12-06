package com.duodian.myapplication

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.FrameLayout
import com.blankj.utilcode.util.LogUtils

class FragmentContainerViewGroup @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

   private var callback:((x:Float, y:Float)->Unit)?=null

    fun setCallBack(callback: (x:Float, y:Float) -> Unit){
        this.callback = callback
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        LogUtils.d("onTouchEvent" + context.javaClass.simpleName)
        return super.onTouchEvent(event)

    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        if (ev.action == MotionEvent.ACTION_DOWN) {
            callback?.invoke(ev.rawX,ev.rawY)
            ClickEventManager.recordClickEvent("AAA",ev.rawX,ev.rawY,"xxx")
        }

        return super.dispatchTouchEvent(ev) // 继续传递事件
    }
}