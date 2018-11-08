package com.imuxuan.enbubble.view.sheet.entity;

import android.support.annotation.ColorInt;
import android.widget.CompoundButton;

public class SwitchEntity extends SimpleEntity {

    private boolean isChecked;
    private CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
    public @ColorInt
    int titleColor = 0xff000000;
    public CharSequence title;
    public CharSequence info;

    @Override
    public int getTitleColor() {
        return titleColor;
    }

    @Override
    public SwitchEntity setTitleColor(int titleColor) {
        this.titleColor = titleColor;
        return this;
    }

    @Override
    public CharSequence getTitle() {
        return title;
    }

    @Override
    public SwitchEntity setTitle(CharSequence title) {
        this.title = title;
        return this;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public SwitchEntity setChecked(boolean checked) {
        isChecked = checked;
        return this;
    }

    public CharSequence getInfo() {
        return info;
    }

    public SwitchEntity setInfo(CharSequence info) {
        this.info = info;
        return this;
    }

    public CompoundButton.OnCheckedChangeListener getOnCheckedChangeListener() {
        return onCheckedChangeListener;
    }

    public SwitchEntity setOnCheckedChangeListener(final CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean checked) {
                if (!buttonView.isPressed()) {
                    return;
                }
                isChecked = checked;
                onCheckedChangeListener.onCheckedChanged(buttonView, checked);
            }
        };
        return this;
    }

}
