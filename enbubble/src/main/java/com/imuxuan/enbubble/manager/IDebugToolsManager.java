package com.imuxuan.enbubble.manager;

import android.app.Activity;
import android.util.SparseArray;
import android.widget.FrameLayout;

import com.imuxuan.enbubble.view.sheet.entity.SimpleEntity;

import java.util.ArrayList;

/**
 * Created by Yunpeng Li on 2018/3/15.
 */

public interface IDebugToolsManager {

    DebugToolsManager fillMenuData(SparseArray<ArrayList<SimpleEntity>> menuEntities);

    DebugToolsManager remove();

    DebugToolsManager add();

    IDebugToolsManager attach(Activity activity);

    DebugToolsManager attach(FrameLayout container);

    DebugToolsManager detach(Activity activity);

    DebugToolsManager detach(FrameLayout container);

    DebugToolsManager updateInfo(CharSequence text, float percent);

    boolean isMemoryInfoShow();

    boolean dismissMenu();
}
