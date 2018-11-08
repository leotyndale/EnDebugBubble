package com.imuxuan.enbubble.view.sheet.holder;

import android.view.View;

/**
 * Created by Yunpeng Li on 2018/10/30.
 */
public interface ISweetHolder<T> {

    void bind(T menuEntity);

    View getContent();
}
