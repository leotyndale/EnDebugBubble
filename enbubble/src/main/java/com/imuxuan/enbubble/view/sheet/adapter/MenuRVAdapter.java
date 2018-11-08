package com.imuxuan.enbubble.view.sheet.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.AdapterView;

import com.imuxuan.enbubble.view.sheet.entity.RadioEntity;
import com.imuxuan.enbubble.view.sheet.entity.SimpleEntity;
import com.imuxuan.enbubble.view.sheet.entity.SwitchEntity;
import com.imuxuan.enbubble.view.sheet.entity.TextEntity;
import com.imuxuan.enbubble.view.sheet.holder.BaseSweetHolder;
import com.imuxuan.enbubble.view.sheet.holder.RadioHolder;
import com.imuxuan.enbubble.view.sheet.holder.SimpleHolder;
import com.imuxuan.enbubble.view.sheet.holder.SwitchHolder;
import com.imuxuan.enbubble.view.sheet.holder.TextHolder;
import com.imuxuan.enbubble.view.sheet.listener.SingleClickListener;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.view.ViewHelper;

import java.util.List;

public class MenuRVAdapter extends RecyclerView.Adapter<BaseSweetHolder> {

    private static final int TYPE_SIMPLE = 0;
    private static final int TYPE_CHECK = 1;
    private static final int TYPE_TEXT = 2;
    private static final int TYPE_RADIO = 3;
    private List<SimpleEntity> mDataList;
    private boolean mIsAnimation;
    private AdapterView.OnItemClickListener mOnItemClickListener;

    public MenuRVAdapter(List<SimpleEntity> dataLis) {
        mDataList = dataLis;
    }

    @Override
    public BaseSweetHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        if (viewType == TYPE_CHECK) {
            return new SwitchHolder(viewGroup);
        } else if (viewType == TYPE_TEXT) {
            return new TextHolder(viewGroup);
        } else if (viewType == TYPE_RADIO) {
            return new RadioHolder(viewGroup);
        }
        return new SimpleHolder(viewGroup);
    }

    @Override
    public int getItemViewType(int position) {
        if (mDataList.get(position) instanceof SwitchEntity) {
            return TYPE_CHECK;
        } else if (mDataList.get(position) instanceof TextEntity) {
            return TYPE_TEXT;
        } else if (mDataList.get(position) instanceof RadioEntity) {
            return TYPE_RADIO;
        } else {
            return TYPE_SIMPLE;
        }
    }

    @Override
    public void onBindViewHolder(BaseSweetHolder menuVH, int i) {
        menuVH.getContent().setOnClickListener(mSingleClickListener);
        menuVH.bind(mDataList.get(i));
        if (mIsAnimation) {
            animation(menuVH);
        }
    }

    private void animation(RecyclerView.ViewHolder menuVH) {
        ViewHelper.setAlpha(menuVH.itemView, 0);
        ViewHelper.setTranslationY(menuVH.itemView, 300);
        ObjectAnimator translationY = ObjectAnimator.ofFloat(menuVH.itemView, "translationY", 500, 0);
        translationY.setDuration(300);
        translationY.setInterpolator(new OvershootInterpolator(1.6f));
        ObjectAnimator alphaIn = ObjectAnimator.ofFloat(menuVH.itemView, "alpha", 0, 1);
        alphaIn.setDuration(100);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(translationY, alphaIn);
        animatorSet.setStartDelay(30 * menuVH.getAdapterPosition());
        animatorSet.start();
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public void notifyAnimation() {
        mIsAnimation = true;
        this.notifyDataSetChanged();
    }

    public void notifyNoAimation() {
        mIsAnimation = false;
        this.notifyDataSetChanged();
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    private SingleClickListener mSingleClickListener = new SingleClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int position = (int) v.getTag();

            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(null, v, position, position);
            }
        }
    });
}
