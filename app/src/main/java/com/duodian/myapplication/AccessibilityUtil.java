package com.duodian.myapplication;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.view.accessibility.AccessibilityManager;

import java.util.List;

public class AccessibilityUtil {
    /**
     * 判断是否开启无障碍模式
     *
     * @param context 上下文对象
     * @return 是否启用无障碍模式
     */
    public static boolean isAccessibilityServiceEnabled(Context context) {
        AccessibilityManager am = (AccessibilityManager) context.getSystemService(Context.ACCESSIBILITY_SERVICE);
        if (am == null) {
            return false;
        }

        List<AccessibilityServiceInfo> enabledServices = am.getEnabledAccessibilityServiceList(AccessibilityServiceInfo.FEEDBACK_ALL_MASK);
        for (AccessibilityServiceInfo service : enabledServices) {
            // 检查是否有服务启用
            if (service != null) {
                return true;
            }
        }
        return false;
    }
}
