package com.imuxuan.enbubble;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import com.imuxuan.enbubble.view.sheet.entity.SimpleEntity;
import com.imuxuan.enbubble.view.sheet.sweetpick.DimEffect;
import com.imuxuan.enbubble.view.sheet.sweetpick.SweetSheet;
import com.imuxuan.enbubble.view.sheet.sweetpick.ViewPagerDelegate;

import java.util.ArrayList;


/**
 * Created by Yunpeng Li on 2018/10/25.
 */
public class DebugViewManager {

    private SweetSheet mSweetSheet;

    public DebugViewManager setupRecyclerView(ViewGroup parentVG, SparseArray<ArrayList<SimpleEntity>> menuEntities) {
        mSweetSheet = new SweetSheet(parentVG);
        mSweetSheet.setMenuList(menuEntities);
        ViewPagerDelegate delegate = new ViewPagerDelegate();
        delegate.setContentHeight(Utils.getScreenHeight() / 2);
        mSweetSheet.setDelegate(delegate);
        mSweetSheet.setBackgroundEffect(new DimEffect(8));
        mSweetSheet.setOnMenuItemClickListener(new SweetSheet.OnMenuItemClickListener() {
            @Override
            public boolean onItemClick(View view, SimpleEntity menuEntity) {
                if (menuEntity.getOnClickListener() != null) {
                    menuEntity.getOnClickListener().onClick(view);
                    return true;
                }
                return false;
            }
        });
        return this;
    }

    public void toggle() {
        if (mSweetSheet == null){
            return;
        }
        mSweetSheet.toggle();
    }

    public boolean dismiss() {
        if (mSweetSheet == null || !mSweetSheet.isShow()) {
            return false;
        }
        mSweetSheet.dismiss();
        return true;
    }

}
