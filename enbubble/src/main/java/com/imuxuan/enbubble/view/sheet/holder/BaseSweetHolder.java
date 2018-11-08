package com.imuxuan.enbubble.view.sheet.holder;

import android.support.annotation.CallSuper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Yunpeng Li on 2018/10/30.
 */
public class BaseSweetHolder<T> extends RecyclerView.ViewHolder implements ISweetHolder<T> {

    public BaseSweetHolder(View itemView) {
        super(itemView);
    }

    @CallSuper
    @Override
    public void bind(T menuEntity) {
        if (getContent() != null) {
            getContent().setTag(getAdapterPosition());
        }
    }

    @Override
    public View getContent(){
        return itemView;
    }
}
