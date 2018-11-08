package com.imuxuan.enbubble.view;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import com.imuxuan.enbubble.R;
import com.imuxuan.enbubble.Utils;


public class MagnetView extends FrameLayout {

    private static final int TOUCH_TIME_THRESHOLD = 150;

    private int width;
    private int mStatusBarHeight;
    private int mScreenHeight;

    private float initialTouchX;
    private float initialTouchY;
    private float initialX;
    private float initialY;

    private long lastTouchDown;

    private boolean shouldStickToWall = true;

    private MoveAnimator animator;
    private OnRemoveListener onRemoveListener;
    private OnClickListener onClickListener;
    private DebugToolsCoordinator layoutCoordinator;

    public void setOnRemoveListener(OnRemoveListener listener) {
        onRemoveListener = listener;
    }

    public void setOnClickListener(OnClickListener listener) {
        onClickListener = listener;
    }

    public MagnetView(Context context) {
        this(context, null);
        inflate(getContext(), R.layout.debug_tools_layout, this);
        initializeView();
    }

    public MagnetView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        initializeView();
    }

    public MagnetView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeView();
    }

    public void setShouldStickToWall(boolean shouldStick) {
        this.shouldStickToWall = shouldStick;
    }

    void notifyRemoved() {
        if (onRemoveListener != null) {
            onRemoveListener.onRemoved(this);
        }
    }

    private void initializeView() {
        mStatusBarHeight = Utils.getStatusBarHeight();
        mScreenHeight = Utils.getScreenHeight();
        animator = new MoveAnimator();
        setClickable(true);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        playAnimation();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event != null) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    initialX = getX();
                    initialY = getY();
                    initialTouchX = event.getRawX();
                    initialTouchY = event.getRawY();
                    playAnimationClickDown();
                    lastTouchDown = System.currentTimeMillis();
                    updateSize();
                    animator.stop();
                    break;
                case MotionEvent.ACTION_MOVE:
                    updateViewPosition(event);
                    if (getLayoutCoordinator() != null) {
                        getLayoutCoordinator().notifyPositionChanged(this);
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    goToWall();
                    if (getLayoutCoordinator() != null) {
                        getLayoutCoordinator().notifyBubbleRelease(this);
                        playAnimationClickUp();
                    }
                    if (System.currentTimeMillis() - lastTouchDown < TOUCH_TIME_THRESHOLD) {
                        if (onClickListener != null) {
                            onClickListener.onClick(this);
                        }
                    }
                    break;
            }
        }
        return super.onTouchEvent(event);
    }

    private void updateViewPosition(MotionEvent event) {
        setX(initialX + event.getRawX() - initialTouchX);
        // 限制不可超出屏幕高度
        float desY = initialY + event.getRawY() - initialTouchY;
        if (desY < mStatusBarHeight) {
            desY = mStatusBarHeight;
        }
        if (desY > mScreenHeight - getHeight()) {
            desY = mScreenHeight - getHeight();
        }
        setY(desY);
    }

    private void playAnimation() {
        if (!isInEditMode()) {
            AnimatorSet animator = (AnimatorSet) AnimatorInflater
                    .loadAnimator(getContext(), R.animator.debug_tools_shown_animator);
            animator.setTarget(this);
            animator.start();
        }
    }

    private void playAnimationClickDown() {
        if (!isInEditMode()) {
            AnimatorSet animator = (AnimatorSet) AnimatorInflater
                    .loadAnimator(getContext(), R.animator.debug_tools_down_click_animator);
            animator.setTarget(this);
            animator.start();
        }
    }

    private void playAnimationClickUp() {
        if (!isInEditMode()) {
            AnimatorSet animator = (AnimatorSet) AnimatorInflater
                    .loadAnimator(getContext(), R.animator.debug_tools_up_click_animator);
            animator.setTarget(this);
            animator.start();
        }
    }

    private void updateSize() {
        width = Utils.getScreenWidth() - this.getWidth();
    }

    public void setLayoutCoordinator(DebugToolsCoordinator layoutCoordinator) {
        this.layoutCoordinator = layoutCoordinator;
    }

    DebugToolsCoordinator getLayoutCoordinator() {
        return layoutCoordinator;
    }

    public interface OnRemoveListener {
        void onRemoved(MagnetView magnetView);
    }

    public interface OnClickListener {
        void onClick(MagnetView magnetView);
    }

    public void goToWall() {
        if (shouldStickToWall) {
            int middle = width / 2;
            float nearestXWall = getX() >= middle ? width + Utils.dp2px(20) : -Utils.dp2px(20);
            animator.start(nearestXWall, getY());
        }
    }

    private void move(float deltaX, float deltaY) {
        setX(getX() + deltaX);
        setY(getY() + deltaY);
    }


    private class MoveAnimator implements Runnable {

        private Handler handler = new Handler(Looper.getMainLooper());
        private float destinationX;
        private float destinationY;
        private long startingTime;

        private void start(float x, float y) {
            this.destinationX = x;
            this.destinationY = y;
            startingTime = System.currentTimeMillis();
            handler.post(this);
        }

        @Override
        public void run() {
            if (getRootView() != null && getRootView().getParent() != null) {
                float progress = Math.min(1, (System.currentTimeMillis() - startingTime) / 400f);
                float deltaX = (destinationX - getX()) * progress;
                float deltaY = (destinationY - getY()) * progress;
                move(deltaX, deltaY);
                if (progress < 1) {
                    handler.post(this);
                }
            }
        }

        private void stop() {
            handler.removeCallbacks(this);
        }
    }
}
