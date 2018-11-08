package com.imuxuan.enbubble.view.sheet.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.imuxuan.enbubble.view.sheet.sweetpick.MenuListViewHandler;

import java.util.List;


public class ViewpagerAdapter extends PagerAdapter {

    List<MenuListViewHandler> mMenuListViewHandlers = null;

    public ViewpagerAdapter(List<MenuListViewHandler> menuListViewHandlers) {
        mMenuListViewHandlers = menuListViewHandlers;
    }

    @Override
    public int getCount() {
        return mMenuListViewHandlers.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mMenuListViewHandlers.get(position).onCreateView(container));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mMenuListViewHandlers.get(position).onCreateView(container));

        return mMenuListViewHandlers.get(position).onCreateView(container);
    }
}
