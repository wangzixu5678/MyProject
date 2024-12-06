package com.duodian.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

public class LanguageSp {

    private static final String PREFERENCE_NAME = "language_preference"; // SharedPreferences 文件名
    private static final String KEY_LANGUAGE = "selected_language";      // 存储语言的键值
    private static final String DEFAULT_LANGUAGE = Language.ENGLISH;     // 默认语言

    /**
     * 获取存储的语言
     *
     * @param context Context
     * @return 存储的语言代码，如果不存在则返回默认语言
     */
    public static String getLanguage(Context context) {
        SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        return sp.getString(KEY_LANGUAGE, DEFAULT_LANGUAGE);
    }

    /**
     * 设置语言
     *
     * @param context  Context
     * @param language 语言代码
     */
    public static void setLanguage(Context context, String language) {
        SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        sp.edit().putString(KEY_LANGUAGE, language).apply();
    }
}
