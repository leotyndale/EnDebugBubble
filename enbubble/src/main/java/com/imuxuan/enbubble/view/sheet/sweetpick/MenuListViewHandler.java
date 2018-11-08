package com.imuxuan.enbubble.view.sheet.sweetpick;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.imuxuan.enbubble.R;
import com.imuxuan.enbubble.view.sheet.adapter.MenuRVAdapter;
import com.imuxuan.enbubble.view.sheet.entity.SimpleEntity;

import java.util.List;


public class MenuListViewHandler {


    private List<SimpleEntity> mMenuEntities;
    private int mIndex;

    private int mRvVisibility = View.VISIBLE;
    private OnFragmentInteractionListener mOnFragmentInteractionListener;
    private RecyclerView mRV;
    private MenuRVAdapter mMenuRVAdapter;

    private View mView;
    private TextView mRvTitle;

    public static MenuListViewHandler getInstant(int index, List<SimpleEntity> menuEntities) {
        MenuListViewHandler menuListViewHandler = new MenuListViewHandler();
        menuListViewHandler.mMenuEntities = menuEntities;
        menuListViewHandler.mIndex = index;
        return menuListViewHandler;
    }

    public void setOnMenuItemClickListener(OnFragmentInteractionListener onFragmentInteractionListener) {
        mOnFragmentInteractionListener = onFragmentInteractionListener;
    }

    public View onCreateView(ViewGroup container) {
        if (mView == null) {
            mView = LayoutInflater.from(container.getContext()).inflate(R.layout.layout_grid_menu, container, false);
            onViewCreated(mView);
        }
        return mView;
    }

    public void onViewCreated(View view) {
        if (mMenuEntities == null || mMenuEntities.size() == 0) {
            return;
        }
        mRV = (RecyclerView) view.findViewById(R.id.rv);
        mRV.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));
        mRV.setHasFixedSize(true);
        mMenuRVAdapter = new MenuRVAdapter(mMenuEntities);
        mMenuRVAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (mOnFragmentInteractionListener == null) {
                    return;
                }
                mOnFragmentInteractionListener.onFragmentInteraction(view, mMenuEntities.get(position));
            }
        });
        mRV.setAdapter(mMenuRVAdapter);
        mRV.setVisibility(mRvVisibility);
    }

    public void animationOnStart() {
        if (mRV != null) {
            mRV.setVisibility(View.GONE);
        } else {
            mRvVisibility = View.GONE;
        }
    }

    public void notifyAnimation() {
        if (mRV != null) {
            mRV.setVisibility(View.VISIBLE);
            mRvVisibility = View.VISIBLE;
//            mMenuRVAdapter.notifyAnimation();
        } else {
            mRvVisibility = View.VISIBLE;
        }
    }

    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(View view, SimpleEntity menuEntity);
    }

}
