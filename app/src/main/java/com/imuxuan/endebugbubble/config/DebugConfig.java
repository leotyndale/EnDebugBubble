package com.imuxuan.endebugbubble.config;

import android.util.SparseArray;

import com.imuxuan.enbubble.view.sheet.entity.SimpleEntity;

import java.util.ArrayList;

/**
 * Debug悬浮窗配置
 */
public class DebugConfig {

    private static ArrayList<SimpleEntity> page(){
        return new FeaturePageList().get();
    }

    private static ArrayList<SimpleEntity> feature(){
        return new FeatureToggleList().get();
    }

    private static ArrayList<SimpleEntity> dynamic(){
        return new DynamicToggleList().get();
    }

    public static SparseArray<ArrayList<SimpleEntity>> getList() {
        SparseArray<ArrayList<SimpleEntity>> list = new SparseArray<>();
        list.put(0, DebugConfig.page());
        list.put(1, DebugConfig.feature());
        list.put(2, DebugConfig.dynamic());
        return list;
    }
}
