package com.imuxuan.enbubble.view.sheet.entity;

import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.view.View;


public class SimpleEntity {

    public @DrawableRes
    int iconId;
    public @ColorInt
    int titleColor = 0xff000000;
    public CharSequence title;
    public Drawable icon;
    private View.OnClickListener onClickListener;

    public View.OnClickListener getOnClickListener() {
        return onClickListener;
    }

    public SimpleEntity setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        return this;
    }

    public int getIconId() {
        return iconId;
    }

    public SimpleEntity setIconId(int iconId) {
        this.iconId = iconId;
        return this;
    }

    public int getTitleColor() {
        return titleColor;
    }

    public SimpleEntity setTitleColor(int titleColor) {
        this.titleColor = titleColor;
        return this;
    }

    public CharSequence getTitle() {
        return title;
    }

    public SimpleEntity setTitle(CharSequence title) {
        this.title = title;
        return this;
    }

    public Drawable getIcon() {
        return icon;
    }

    public SimpleEntity setIcon(Drawable icon) {
        this.icon = icon;
        return this;
    }
}
