package com.imuxuan.enbubble;

import android.os.Debug;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

import com.imuxuan.enbubble.manager.DebugToolsManager;

import java.text.DecimalFormat;

/**
 * Created by Yunpeng Li on 2018/11/8.
 */
public class MemoryInfo {

    private static volatile MemoryInfo mInstance;
    private Handler mCheckMemoryHandler;

    private static final int UPDATE_MEMORY = 1;

    private MemoryInfo() {
    }

    public static MemoryInfo getInstance() {
        if (mInstance == null) {
            synchronized (MemoryInfo.class) {
                if (mInstance == null) {
                    mInstance = new MemoryInfo();
                }
            }
        }
        return mInstance;
    }

    public void start() {
        HandlerThread checkMemoryThread = new HandlerThread("check-memory");
        checkMemoryThread.start();
        mCheckMemoryHandler = new Handler(checkMemoryThread.getLooper()) {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what != UPDATE_MEMORY) {
                    return;
                }
                checkMemory();
                mCheckMemoryHandler.sendEmptyMessageDelayed(UPDATE_MEMORY, 3000);
            }
        };
        mCheckMemoryHandler.sendEmptyMessageDelayed(UPDATE_MEMORY, 3000);
    }

    private void checkMemory() {
        if (!DebugToolsManager.getInstance().isMemoryInfoShow()) {
            return;
        }
        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        String formatSize;
        String memorySize = "";
        Integer javaHeapSize;
        float percent = 0.5f;
        try {
            javaHeapSize = memoryInfo.dalvikPrivateDirty;
            double size = ((double) javaHeapSize) / 1024;
            formatSize = new DecimalFormat("#.##").format(size);
            memorySize = formatSize + "M";
            int totalPss = memoryInfo.getTotalPss();
            percent = (float) javaHeapSize / totalPss;
        } catch (Exception e) {
            e.printStackTrace();
        }
        DebugToolsManager.getInstance().updateInfo(memorySize, percent);
    }
}
