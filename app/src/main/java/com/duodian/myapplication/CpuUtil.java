package com.duodian.myapplication;

import android.os.Build;

import com.blankj.utilcode.util.LogUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CpuUtil {

    private static final String TAG = "CpuUtil";

    /**
     * 获取 CPU 架构
     *
     * @return CPU 架构
     */
    public static String getCpuArchitecture() {
        return Build.CPU_ABI;
    }

    /**
     * 获取 CPU 核数
     *
     * @return CPU 核数
     */
    public static int getCpuCoreCount() {
       return Runtime.getRuntime().availableProcessors();
    }

    /**
     * 获取每个 CPU 核的频率
     *
     * @return 每个 CPU 核的频率（以 Hz 为单位）
     */
    public static String getCpuFrequencies() {
        StringBuilder frequencies = new StringBuilder();
        try {
            for (int i = 0; ; i++) {
                String cpuFreqPath = "/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_max_freq";
                BufferedReader reader = new BufferedReader(new FileReader(cpuFreqPath));
                String line = reader.readLine();
                if (line == null) break;
                frequencies.append("CPU").append(i).append(": ").append(line).append(" Hz\n");
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return frequencies.toString();
    }


    public static double getCpuFrequency() {
        double totalFrequency = 0.0;
        int coreCount = 0;

        for (int i = 0; i < getCpuCoreCount(); i++) {
            String filePath = "/sys/devices/system/cpu/cpu" + i + "/cpufreq/scaling_cur_freq";
            try {
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                String line = reader.readLine();
                reader.close();
                if (line != null) {
                    totalFrequency += Double.parseDouble(line.trim());
                    coreCount++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (coreCount > 0) {
            return totalFrequency / coreCount; // 平均频率
        }
        return 0.0;
    }

    /**
     * 获取 CPU 使用占比
     *
     * @return CPU 使用占比（以百分比表示）
     */
    public static double getCpuUsage() {
        try {
            // 运行 top 命令，获取 CPU 使用情况
            Process process = Runtime.getRuntime().exec("top -n 1");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                // 解析包含 CPU 使用率的行
                LogUtils.d("CPU占比" + line);
                if (line.startsWith("%Cpu")) {
                    String[] tokens = line.split("\\s+");
                    String cpuUsageStr = tokens[1].replace("%", ""); // 提取 CPU 使用的百分比
                    return Double.parseDouble(cpuUsageStr);
                }
            }
            reader.close();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return 0.0;
    }



}
