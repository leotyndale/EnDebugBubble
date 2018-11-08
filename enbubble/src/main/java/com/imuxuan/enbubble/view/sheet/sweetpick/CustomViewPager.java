package com.imuxuan.enbubble.view.sheet.sweetpick;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Yunpeng Li on 2018/10/30.
 */
public class CustomViewPager extends ViewPager {

    private float preX;
    private float preY;

    public CustomViewPager(@NonNull Context context) {
        super(context);
    }

    public CustomViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        boolean res = super.onInterceptTouchEvent(event);
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            preX = event.getX();
            preY = event.getY();
        } else {
            if (Math.abs(event.getX() - preX) > 4 && Math.abs(event.getX() - preX) >= Math.abs(event.getY() - preY)) {
                return true;
            } else {
                preX = event.getX();
                preY = event.getY();
            }
        }
        return res;
    }

//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent event) {
//        this.requestDisallowInterceptTouchEvent(false);
//        if (this.getParent() != null) {
////        	System.out.println("x>"+Math.abs(event.getX() - preX)+",y>"+Math.abs(event.getY() - preY));
//            if(event.getAction() == MotionEvent.ACTION_DOWN) {
//                preX = event.getX();
//                preY = event.getY();
//                this.getParent().requestDisallowInterceptTouchEvent(false);
//            }else if(event.getAction() == MotionEvent.ACTION_MOVE){
//                this.getParent().requestDisallowInterceptTouchEvent(true);
//                if(Math.abs(event.getX() - preX) >= 10 || Math.abs(event.getY() - preY) >= 10){
//                    if( Math.abs(event.getX() - preX) >= Math.abs(event.getY() - preY) ) {
//                        return true;
//                    }else if(Math.abs(event.getY() - preY) > Math.abs(event.getX() - preX)){
//                        preX = 0;
//                        this.getParent().requestDisallowInterceptTouchEvent(false);
//                    }else{
//                        preX = event.getX();
//                        preY = event.getY();
//                        this.getParent().requestDisallowInterceptTouchEvent(false);
//                    }
//                }else{
//                    this.getParent().requestDisallowInterceptTouchEvent(false);
//                }
//            }else{
//                this.getParent().requestDisallowInterceptTouchEvent(false);
//            }
//        }
//        return super.onInterceptTouchEvent(event);
//    }

}
