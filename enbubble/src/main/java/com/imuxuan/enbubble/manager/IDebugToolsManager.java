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

    DebugTools fillMenuData(SparseArray<ArrayList<SimpleEntity>> menuEntities);

    DebugTools remove();

    DebugTools add();

    IDebugToolsManager attach(Activity activity);

    DebugTools attach(FrameLayout container);

    DebugTools detach(Activity activity);

    DebugTools detach(FrameLayout container);

    DebugTools updateInfo(CharSequence text, float percent);

    boolean isMemoryInfoShow();

    boolean dismissMenu();
}
