package com.imuxuan.enbubble.view.sheet.sweetpick;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import com.imuxuan.enbubble.view.sheet.entity.SimpleEntity;

import java.util.ArrayList;

public class SweetSheet {

    public static final String Tag = "SweetSheet";

    public enum Type {
        RecyclerView, Viewpager
    }

    private ViewGroup mParentVG;
    private Delegate mDelegate;
    private Effect mEffect = new DimEffect(8);
    private OnMenuItemClickListener mOnMenuItemClickListener;
    private SparseArray<ArrayList<SimpleEntity>> mMenuEntities;

    public SweetSheet(ViewGroup parentVG) {
        mParentVG = parentVG;
    }

    public void setDelegate(Delegate delegate) {
        mDelegate = delegate;
        mDelegate.init(mParentVG);
        setup();
    }

    public Delegate getDelegate() {
        return mDelegate;
    }

    private void setup() {
        if (mOnMenuItemClickListener != null) {
            mDelegate.setOnMenuItemClickListener(mOnMenuItemClickListener);
        }
        if (mMenuEntities != null) {
            mDelegate.setMenuList(mMenuEntities);
        }
        mDelegate.setBackgroundEffect(mEffect);
        mDelegate.setBackgroundClickEnable(true);
    }

    public void setBackgroundEffect(Effect effect) {
        if (mDelegate != null) {
            mDelegate.setBackgroundEffect(effect);
        } else {
            mEffect = effect;
        }
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onItemClickListener) {
        if (mDelegate != null) {
            mDelegate.setOnMenuItemClickListener(onItemClickListener);
        } else {
            mOnMenuItemClickListener = onItemClickListener;
        }
    }

    public void show() {
        if (mDelegate != null) {
            mDelegate.show();
        } else {
            Log.e(Tag, "you must setDelegate before");
        }
    }

    public void dismiss() {
        if (mDelegate != null) {
            mDelegate.dismiss();
        } else {
            Log.e(Tag, "you must setDelegate before");
        }
    }

    public void toggle() {
        if (mDelegate != null) {
            mDelegate.toggle();
        } else {
            Log.e(Tag, "you must setDelegate before");
        }

    }

    public boolean isShow() {
        return mDelegate != null &&
                (mDelegate.getStatus() == Status.SHOW || mDelegate.getStatus() == Status.SHOWING);
    }


    public void setMenuList(SparseArray<ArrayList<SimpleEntity>> menuEntities) {
        if (mDelegate != null) {
            mDelegate.setMenuList(menuEntities);
        } else {
            mMenuEntities = menuEntities;
        }
    }

    protected enum Status {
        SHOW, SHOWING,
        DISMISS, DISMISSING
    }

    public interface OnMenuItemClickListener {
        boolean onItemClick(View view, SimpleEntity menuEntity);
    }

}
