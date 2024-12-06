package com.duodian.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import java.util.HashMap;
import java.util.Map;

public class ScreenUtil {

    /**
     * 获取屏幕尺寸、密度和分辨率
     *
     * @param context 上下文对象
     * @return 一个包含屏幕尺寸、密度和分辨率的字符串
     */
    @SuppressLint("DefaultLocale")
    public static Map<String, String> getScreenInfo(Context context) {

        HashMap<String, String> map = new HashMap<>();
        // 获取 WindowManager 和 Display 对象
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();


        DisplayMetrics realMetrics = new DisplayMetrics();

        display.getRealMetrics(realMetrics);

        // 获取屏幕宽度、高度、密度和分辨率
        int widthPixels = realMetrics.widthPixels; // 屏幕宽度（像素）
        int heightPixels = realMetrics.heightPixels; // 屏幕高度（像素）
        float density = realMetrics.density; // 屏幕密度（每密度独立像素的像素数）

        // 计算屏幕尺寸（以英寸为单位）
        double widthInches = realMetrics.widthPixels / realMetrics.xdpi;
        double heightInches = realMetrics.heightPixels / realMetrics.ydpi;




        map.put("widthInches",String.format("%.2f", widthInches));
        map.put("heightInches",String.format("%.2f", heightInches));


        map.put("widthPixels",String.valueOf(widthPixels));
        map.put("heightPixels",String.valueOf(heightPixels));


        map.put("density",String.valueOf(density));


        // 返回屏幕信息
        return map;
    }
}
