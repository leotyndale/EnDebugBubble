package com.imuxuan.enbubble;

import android.app.Application;
import android.content.res.Resources;
import android.util.TypedValue;

/**
 * Created by Yunpeng Li on 2018/11/8.
 */
public class Utils {

    private static Application application = BubbleContext.getAppContext();

    public static int getStatusBarHeight() {
        int result = 0;
        int resourceId = application.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = BubbleContext.getAppContext().getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public static int getScreenWidth() {
        int screenWith = -1;
        try {
            screenWith = application.getResources().getDisplayMetrics().widthPixels;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return screenWith;
    }

    public static int getScreenHeight() {
        int screenHeight = -1;
        try {
            screenHeight = application.getResources().getDisplayMetrics().heightPixels;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return screenHeight;
    }

    public static float dp2px(float dp) {
        Resources res = application.getResources();
        return TypedValue.applyDimension(1, dp, res.getDisplayMetrics());
    }
}
