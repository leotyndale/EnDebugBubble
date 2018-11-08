package com.imuxuan.enbubble.view.sheet.sweetpick;

import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;

import com.imuxuan.enbubble.R;
import com.imuxuan.enbubble.view.sheet.adapter.ViewpagerAdapter;
import com.imuxuan.enbubble.view.sheet.entity.SimpleEntity;
import com.imuxuan.enbubble.view.sheet.widget.CRImageView;
import com.imuxuan.enbubble.view.sheet.widget.FreeGrowUpParent;
import com.imuxuan.enbubble.view.sheet.widget.IndicatorView;
import com.imuxuan.enbubble.view.sheet.widget.SweetView;

import java.util.ArrayList;

public class ViewPagerDelegate extends Delegate {

    private ArrayList<MenuListViewHandler> mMenuListViewHandlers;
    private IndicatorView mIndicatorView;
    private ViewPager mViewPager;
    private SweetView mSweetView;
    private MenuListViewHandler mMenuListViewHandler;
    private FreeGrowUpParent mFreeGrowUpParentRelativeLayout;
    private SweetSheet.OnMenuItemClickListener mOnMenuItemClickListener;
//    private SparseArray<ArrayList<SimpleEntity>> mMenuEntities;
    private CRImageView sliderIm;

    private int mNumColumns = 3;
    private int mContentViewHeight;

    @Override
    protected View createView() {
        View rootView = LayoutInflater.from(mParentVG.getContext()).inflate(R.layout.layout_sweet, null, false);
        mSweetView = (SweetView) rootView.findViewById(R.id.sv);
        mFreeGrowUpParentRelativeLayout = (FreeGrowUpParent) rootView.findViewById(R.id.freeGrowUpParentF);
        sliderIm = (CRImageView) rootView.findViewById(R.id.sliderIM);

        mIndicatorView = (IndicatorView) rootView.findViewById(R.id.indicatorView);
        mIndicatorView.alphaDismiss(false);
        mSweetView.setAnimationListener(new AnimationImp());
        mViewPager = (ViewPager) rootView.findViewById(R.id.vp);

        if (mContentViewHeight > 0) {
            mFreeGrowUpParentRelativeLayout.setContentHeight(mContentViewHeight);
        }

        return rootView;
    }

    public ViewPagerDelegate setContentHeight(int height) {
        if (height > 0 && mFreeGrowUpParentRelativeLayout != null) {
            mFreeGrowUpParentRelativeLayout.setContentHeight(height);
        } else {
            mContentViewHeight = height;
        }
        return this;
    }

    protected void setMenuList(SparseArray<ArrayList<SimpleEntity>> menuEntities) {
//        mMenuEntities = menuEntities;
        mMenuListViewHandlers = new ArrayList<>();
//        int fragmentCount = menuEntities.size() / (mNumColumns * 2);
//        if (menuEntities.size() % (mNumColumns * 2) != 0) {`
//            fragmentCount += 1;
//        }
        mNumColumns = menuEntities.size();
        for (int i = 0; i < menuEntities.size(); i++) {
//            int lastIndex = Math.min((i + 1) * (mNumColumns * 2), menuEntities.size());
            MenuListViewHandler menuListViewHandler = MenuListViewHandler.getInstant(i, menuEntities.get(i));
            menuListViewHandler.setOnMenuItemClickListener(new OnFragmentInteractionListenerImp());
            mMenuListViewHandlers.add(menuListViewHandler);
        }
        mViewPager.setAdapter(new ViewpagerAdapter(mMenuListViewHandlers));
        mIndicatorView.setViewPager(mViewPager);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                selectPosition(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        selectPosition(0);
    }

    protected void show() {
        super.show();
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        if (mRootView.getParent() != null) {
            mParentVG.removeView(mRootView);
        }

        mParentVG.addView(mRootView, lp);
        mSweetView.show();
    }

    @Override
    protected void setOnMenuItemClickListener(SweetSheet.OnMenuItemClickListener onItemClickListener) {
        mOnMenuItemClickListener = onItemClickListener;
    }

    private void selectPosition(int position) {
        mMenuListViewHandler = mMenuListViewHandlers.get(position);
    }

    class OnFragmentInteractionListenerImp implements MenuListViewHandler.OnFragmentInteractionListener {

        @Override
        public void onFragmentInteraction(View view, SimpleEntity menuEntity) {
            if (mOnMenuItemClickListener != null) {
                if (mOnMenuItemClickListener.onItemClick(view, menuEntity)) {
                    delayedDismiss();
                }
            }
        }
    }

    class AnimationImp implements SweetView.AnimationListener {

        @Override
        public void onStart() {
            mFreeGrowUpParentRelativeLayout.reset();

            mStatus = SweetSheet.Status.SHOWING;
            sliderIm.setVisibility(View.INVISIBLE);
            mIndicatorView.setVisibility(View.INVISIBLE);
            if (mMenuListViewHandler != null) {
                mMenuListViewHandler.animationOnStart();
            }
        }

        @Override
        public void onEnd() {
            if (mStatus == SweetSheet.Status.SHOWING) {
                mIndicatorView.alphaShow(true);

                mIndicatorView.setVisibility(View.VISIBLE);

                mIndicatorView.circularReveal(
                        mIndicatorView.getWidth() / 2,
                        mIndicatorView.getHeight() / 2,
                        0,
                        mIndicatorView.getWidth(), 2000, new DecelerateInterpolator());
                mStatus = SweetSheet.Status.SHOW;

                sliderIm.setVisibility(View.VISIBLE);
                sliderIm.circularReveal(sliderIm.getWidth() / 2, sliderIm.getHeight() / 2, 0, sliderIm.getWidth());
            }
        }

        @Override
        public void onContentShow() {
            if (mMenuListViewHandler != null) {
                mMenuListViewHandler.notifyAnimation();
            }
        }
    }

}
