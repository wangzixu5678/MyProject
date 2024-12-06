package com.duodian.myapplication;

import static androidx.core.content.ContextCompat.getSystemService;

import android.content.Context;
import android.graphics.ImageFormat;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CameraMetadata;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Log;
import android.util.Size;

import java.util.Arrays;
import java.util.Collections;

public class CameraResolutionUtil {

    // 获取前置摄像头支持的分辨率
    public static void getFrontCameraResolution(Context context) {
        getCameraResolution(context, CameraCharacteristics.LENS_FACING_FRONT);
    }

    // 获取后置摄像头支持的分辨率
    public static void getBackCameraResolution(Context context) {
        getCameraResolution(context, CameraCharacteristics.LENS_FACING_BACK);
    }



    // 获取指定类型的摄像头分辨率（前置/后置）
    private static void getCameraResolution(Context context, int cameraFacing) {
        CameraManager cameraManager = (CameraManager) context.getSystemService(Context.CAMERA_SERVICE);
        try {
            String[] cameraIdList = cameraManager.getCameraIdList();
            for (String cameraId : cameraIdList) {
                CameraCharacteristics characteristics = cameraManager.getCameraCharacteristics(cameraId);
                Integer facing = characteristics.get(CameraCharacteristics.LENS_FACING);

                if (facing != null && facing == cameraFacing) {
                    // 获取摄像头支持的StreamConfigurationMap
                    StreamConfigurationMap map =
                            characteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                    if (map != null) {
                        // 获取摄像头支持的输出分辨率列表
                        Size[] outputSizes = map.getOutputSizes(ImageFormat.JPEG);
                        int maxWidth = 0;
                        int maxHeight = 0;// 以JPEG格式为例
                        for (Size size : outputSizes) {
                            maxWidth = Math.max(maxWidth,size.getWidth());
                            maxHeight = Math.max(maxHeight,size.getHeight());
                        }
                        Log.d("CameraResolution", "支持的分辨率: " + maxWidth + "x" +maxHeight);
                    }
                }
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }



}
