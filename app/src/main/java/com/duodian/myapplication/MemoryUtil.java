package com.duodian.myapplication;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;

import com.blankj.utilcode.util.AppUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MemoryUtil {

    /**
     * 获取设备的总内存（RAM）
     *
     * @param context 上下文
     * @return 总内存（以字节为单位）
     */
    public static long getTotalRAM(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    /**
     * 获取设备的已使用内存（RAM）
     *
     * @return 已使用内存（以字节为单位）
     */
    public static long getUsedRAM(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem - memoryInfo.availMem;
    }




    /**
     * 获取SD卡的总内存大小
     *
     * @return SD卡的总内存（以字节为单位）
     */
    public static long getSDCardTotalMemory() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long blockSize = statFs.getBlockSizeLong();
            long totalBlocks = statFs.getBlockCountLong();
            return blockSize * totalBlocks;
        } else {
            return 0; // SD卡不可用时返回0
        }
    }

    /**
     * 获取SD卡的可用内存大小
     *
     * @return SD卡的可用内存（以字节为单位）
     */
    public static long getSDCardAvailableMemory() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long blockSize = statFs.getBlockSizeLong();
            long availableBlocks = statFs.getAvailableBlocksLong();
            return blockSize * availableBlocks;
        } else {
            return 0; // SD卡不可用时返回0
        }
    }

    /**
     * 获取SD卡的已使用内存大小
     *
     * @return SD卡的已使用内存（以字节为单位）
     */
    public static long getSDCardUsedMemory() {
        long totalMemory = getSDCardTotalMemory();
        long availableMemory = getSDCardAvailableMemory();
        return totalMemory - availableMemory;
    }



    @SuppressLint("DefaultLocale")
    public static String convertBytes(long bytes) {
        if (bytes < 1024) {
            return bytes + " B";
        } else if (bytes < 1024 * 1024) {
            return String.format("%.2f KB", bytes / 1024.0);
        } else if (bytes < 1024 * 1024 * 1024) {
            return String.format("%.2f MB", bytes / (1024.0 * 1024.0));
        } else {
            return String.format("%.2f GB", bytes / (1024.0 * 1024.0 * 1024.0));
        }
    }
}
