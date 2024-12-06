package com.duodian.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.blankj.utilcode.util.LogUtils

class TestFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_test, container, false)
        val fragmentContainerViewGroup =
            rootView.findViewById<FragmentContainerViewGroup>(R.id.fragment_container)
        fragmentContainerViewGroup.setCallBack{x,y->
          //  tv_content.text = this.javaClass.simpleName + String.format("X: %.2f, Y: %.2f", x, y)
        }
        return rootView
    }





//    @SuppressLint("ClickableViewAccessibility")
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        val mainView = activity?.findViewById<View>(android.R.id.content)
//        mainView?.setOnTouchListener { _,event -> // 获取点击坐标
//            val x = event.x
//            val y = event.y
//            tv_content.text = String.format("X: %.2f, Y: %.2f", x, y)
//            true
//        }
//    }
}