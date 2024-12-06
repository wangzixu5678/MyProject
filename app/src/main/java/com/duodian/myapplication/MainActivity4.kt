package com.duodian.myapplication

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ScreenUtils
import com.blankj.utilcode.util.SizeUtils
import com.duodian.myapplication.rollingtextview.CharOrder
import com.duodian.myapplication.rollingtextview.strategy.Direction
import com.duodian.myapplication.rollingtextview.strategy.Strategy
import com.duodian.myapplication.ticker.TickerView

import org.json.JSONArray


class MainActivity4 : AppCompatActivity() {

    private lateinit var mScanLightAnimatorSet: AnimatorSet

    private var isCancel = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        //var jsonArray = JSONArray("")

        var jsonArray2 = JSONArray()

        try {
            LogUtils.d("${jsonArray2.getJSONObject(0)}")
        }catch (e:Exception){
            e.printStackTrace()
        }

        //SizeUtils.dp2px()
//
//        alphaBetView.setText("00",false)
//
//        alphaBetView.postDelayed(Runnable {
//            //alphaBetView.setText("00",false)
//            alphaBetView.animationDuration = 10000
//            alphaBetView.charStrategy = Strategy.CarryBitAnimation(Direction.SCROLL_UP)
//            alphaBetView.addCharOrder(CharOrder.Number)
//            alphaBetView.animationInterpolator = AccelerateDecelerateInterpolator()
//            alphaBetView.addAnimatorListener(object : AnimatorListenerAdapter() {
//                override fun onAnimationEnd(animation: Animator) {
//                    //finsih
//                }
//            })
//            alphaBetView.setText("46")
//        },1000)






//        img_sl.post {
//            val moveAnimator = ObjectAnimator.ofFloat(
//                img_sl,
//                "translationX",
//                -img_sl.width.toFloat(),
//                fl.width.toFloat()
//            )
//            moveAnimator.duration = 1500
//            moveAnimator.interpolator = LinearInterpolator()
//
//            val delayAnimator = ObjectAnimator.ofFloat(img_sl, "alpha", 1f, 1f)
//            delayAnimator.duration = 1500 // 延迟时间
//            mScanLightAnimatorSet = AnimatorSet()
//            mScanLightAnimatorSet.playSequentially(moveAnimator, delayAnimator)
//            mScanLightAnimatorSet.addListener(object : AnimatorListenerAdapter() {
//                override fun onAnimationEnd(animation: Animator) {
//                    mScanLightAnimatorSet.start()
//                }
//            })
//
//            mScanLightAnimatorSet.start()
//        }
//
//        tickerView.animationInterpolator = AccelerateDecelerateInterpolator()
//        tickerView.animationDuration = 2000
//        tickerView.setCharacterLists("9876543210")
//        tickerView.setPreferredScrollingDirection(TickerView.ScrollingDirection.UP)
//
//        tickerView.setText("00",false)
//        tickerView.setOnClickListener {
//            tickerView.setText("41")
//        }

    }

    fun pauseAnim(view: View) {
        isCancel = true
        mScanLightAnimatorSet.cancel()
    }
    fun resumeAnim(view: View) {

    }

}

