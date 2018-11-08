package com.imuxuan.enbubble.manager;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.ViewCompat;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.imuxuan.enbubble.BubbleContext;
import com.imuxuan.enbubble.DebugViewManager;
import com.imuxuan.enbubble.MemoryInfo;
import com.imuxuan.enbubble.R;
import com.imuxuan.enbubble.Utils;
import com.imuxuan.enbubble.view.DebugToolsCoordinator;
import com.imuxuan.enbubble.view.DebugToolsTrashLayout;
import com.imuxuan.enbubble.view.MagnetView;
import com.imuxuan.enbubble.view.sheet.entity.SimpleEntity;
import com.imuxuan.enbubble.view.wave.WaterView;

import java.util.ArrayList;


/**
 * @ClassName DebugToolsManager
 * @Description 悬浮窗管理器
 * @Author Yunpeng Li
 * @Creation 2018/3/15 下午5:05
 * @Mender Yunpeng Li
 * @Modification 2018/3/15 下午5:05
 */
public class DebugToolsManager implements IDebugToolsManager {

    private MagnetView mEnFloatingView;
    private DebugToolsTrashLayout mTrashView;
    private DebugToolsCoordinator mLayoutCoordinator;

    private static volatile DebugToolsManager mInstance;
    private FrameLayout mContainer;
    private TextView mMemoryInfo;
    private DebugViewManager mDebugConfig;
    private WaterView mWaterView;

    private SparseArray<ArrayList<SimpleEntity>> menuEntities;

    private DebugToolsManager() {
    }

    public static IDebugToolsManager getInstance() {
        if (mInstance == null) {
            synchronized (DebugToolsManager.class) {
                if (mInstance == null) {
                    mInstance = new DebugToolsManager();
                }
            }
        }
        return mInstance;
    }

    @Override
    public DebugToolsManager fillMenuData(SparseArray<ArrayList<SimpleEntity>> menuEntities) {
        this.menuEntities = menuEntities;
        return this;
    }

    @Override
    public DebugToolsManager remove() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                if (mEnFloatingView == null) {
                    return;
                }
                if (ViewCompat.isAttachedToWindow(mEnFloatingView) && mContainer != null) {
                    mContainer.removeView(mEnFloatingView);
                }
                mEnFloatingView = null;
                mMemoryInfo = null;
                mWaterView = null;
                mDebugConfig = null;
            }
        });
        return this;
    }

    private void ensureView(Context context) {
        synchronized (this) {
            if (mEnFloatingView != null) {
                return;
            }
            initTrash();
            initFloatView(context);
            addViewToWindow(mEnFloatingView);

            MemoryInfo.getInstance().start();
        }
    }

    private void initFloatView(Context context) {
        mEnFloatingView = new MagnetView(context.getApplicationContext());
        mWaterView = (WaterView) mEnFloatingView.findViewById(R.id.waterview);
        mWaterView.start();
        mMemoryInfo = (TextView) mEnFloatingView.findViewById(R.id.memory_info);
        mEnFloatingView.setOnRemoveListener(new MagnetView.OnRemoveListener() {

            @Override
            public void onRemoved(MagnetView magnetView) {
                getConfig().dismiss();
            }
        });
        mEnFloatingView.setOnClickListener(new MagnetView.OnClickListener() {

            @Override
            public void onClick(MagnetView magnetView) {
                if (mContainer == null) {
                    return;
                }
                getConfig().setupRecyclerView(mContainer, menuEntities).toggle();
            }
        });
//        mEnFloatingView.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                ThemeSettingsHelper.getInstance().toggleTheme();
//                return false;
//            }
//        });
        mEnFloatingView.setShouldStickToWall(true);
        mEnFloatingView.setLayoutCoordinator(mLayoutCoordinator);
        mEnFloatingView.setLayoutParams(getParams());
    }

    public DebugViewManager getConfig() {
        if (mDebugConfig == null) {
            mDebugConfig = new DebugViewManager();
        }
        return mDebugConfig;
    }

    @Override
    public DebugToolsManager add() {
        ensureView(BubbleContext.getAppContext());
        return this;
    }

    @Override
    public IDebugToolsManager attach(Activity activity) {
        attach(getActivityRoot(activity));
        return this;
    }

    @Override
    public DebugToolsManager attach(FrameLayout container) {
        if (container == null || mEnFloatingView == null) {
            mContainer = container;
            return null;
        }
        if (mEnFloatingView.getParent() == container) {
            return this;
        }
        removeView(mTrashView);
        removeView(mEnFloatingView);

        mContainer = container;

        addViewToWindow(mEnFloatingView);
        addViewToWindow(mTrashView);
        return this;
    }

    private void removeView(View view) {
        if (mContainer != null && view.getParent() == mContainer) {
            mContainer.removeView(view);
        }
    }

    @Override
    public DebugToolsManager detach(Activity activity) {
        detach(getActivityRoot(activity));
        return this;
    }

    @Override
    public DebugToolsManager detach(FrameLayout container) {
        if (mEnFloatingView != null && container != null && ViewCompat.isAttachedToWindow(mEnFloatingView)) {
            container.removeView(mEnFloatingView);
            container.removeView(mTrashView);
        }
        if (mContainer == container) {
            mContainer = null;
        }
        return this;
    }

    private void addViewToWindow(final FrameLayout view) {
        if (mContainer == null) {
            return;
        }
        mContainer.addView(view);
    }

    private FrameLayout.LayoutParams getParams() {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.BOTTOM | Gravity.END;
        params.setMargins(
                params.leftMargin,
                params.topMargin,
                (int) -Utils.dp2px(20),
                Utils.getScreenHeight() / 3
        );
        return params;
    }

    private FrameLayout getActivityRoot(Activity activity) {
        if (activity == null) {
            return null;
        }
        try {
            return (FrameLayout) activity.getWindow().getDecorView().findViewById(android.R.id.content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void initTrash() {
        mTrashView = new DebugToolsTrashLayout(BubbleContext.getAppContext());
        mTrashView.setVisibility(View.GONE);
        LayoutInflater.from(BubbleContext.getAppContext()).inflate(R.layout.debug_tools_trash_layout, mTrashView, true);
        addViewToWindow(mTrashView);
        initializeLayoutCoordinator();
    }

    private void initializeLayoutCoordinator() {
        mLayoutCoordinator = new DebugToolsCoordinator.Builder()
                .setTrashView(mTrashView)
                .build();
    }

    @Override
    public DebugToolsManager updateInfo(final CharSequence text, final float percent) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                if (mMemoryInfo != null) {
                    mMemoryInfo.setText(text);
                }
                // 有bugs
//                if (mWaterView != null) {
//                    mWaterView.setKeepPercent(percent);
//                }
            }
        });
        return this;
    }

    @Override
    public boolean isMemoryInfoShow() {
        return mMemoryInfo != null;
    }

    @Override
    public boolean dismissMenu() {
        return getConfig().dismiss();
    }
}