package com.imuxuan.enbubble.view.sheet.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.widget.ImageView;

public class CRImageView extends ImageView implements CircleRevealHelper.CircleRevealEnable {

    private CircleRevealHelper mCircleRevealHelper;

    public CRImageView(Context context) {
        super(context);
        init();
    }

    public CRImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CRImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CRImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (getParent() instanceof GrowUpParent) {
            return ((GrowUpParent) getParent()).onParentHandMotionEvent(event);
        }
        return super.onTouchEvent(event);
    }

    private void init() {
        mCircleRevealHelper = new CircleRevealHelper(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mCircleRevealHelper.onDraw(canvas);
    }

    @Override
    public void superOnDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public void circularReveal(int centerX, int centerY, float startRadius, float endRadius, long duration, Interpolator interpolator) {
        mCircleRevealHelper.circularReveal(centerX, centerY, startRadius, endRadius, duration, interpolator);
    }

    @Override
    public void circularReveal(int centerX, int centerY, float startRadius, float endRadius) {
        mCircleRevealHelper.circularReveal(centerX, centerY, startRadius, endRadius);
    }

}
