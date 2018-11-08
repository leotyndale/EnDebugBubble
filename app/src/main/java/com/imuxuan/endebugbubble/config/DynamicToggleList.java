package com.imuxuan.endebugbubble.config;

import android.widget.CompoundButton;
import android.widget.Toast;

import com.imuxuan.enbubble.BubbleContext;
import com.imuxuan.enbubble.view.sheet.entity.SimpleEntity;
import com.imuxuan.enbubble.view.sheet.entity.SwitchEntity;

import java.util.ArrayList;

public class DynamicToggleList {

    public ArrayList<SimpleEntity> get() {
        final ArrayList<SimpleEntity> list = new ArrayList<>();
        list.add(new SwitchEntity().setChecked(true)
                .setTitle("test feature toggle1")
                .setInfo("动态功能开关测试1")
                .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        Toast.makeText(BubbleContext.getAppContext(), "动态功能开关测试", Toast.LENGTH_SHORT).show();
                    }
                }));
        list.add(new SwitchEntity().setChecked(true)
                .setTitle("test feature toggle2")
                .setInfo("动态功能开关测试2")
                .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        Toast.makeText(BubbleContext.getAppContext(), "动态功能开关测试", Toast.LENGTH_SHORT).show();
                    }
                }));
        list.add(new SwitchEntity().setChecked(true)
                .setTitle("test feature toggle3")
                .setInfo("动态功能开关测试3")
                .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        Toast.makeText(BubbleContext.getAppContext(), "动态功能开关测试", Toast.LENGTH_SHORT).show();
                    }
                }));
        list.add(new SwitchEntity().setChecked(true)
                .setTitle("test feature toggle4")
                .setInfo("动态功能开关测试4")
                .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        Toast.makeText(BubbleContext.getAppContext(), "动态功能开关测试", Toast.LENGTH_SHORT).show();
                    }
                }));
        list.add(new SwitchEntity().setChecked(true)
                .setTitle("test feature toggle5")
                .setInfo("动态功能开关测试5")
                .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        Toast.makeText(BubbleContext.getAppContext(), "动态功能开关测试", Toast.LENGTH_SHORT).show();
                    }
                }));
        list.add(new SwitchEntity().setChecked(true)
                .setTitle("test feature toggle6")
                .setInfo("动态功能开关测试6")
                .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        Toast.makeText(BubbleContext.getAppContext(), "动态功能开关测试", Toast.LENGTH_SHORT).show();
                    }
                }));
        list.add(new SwitchEntity().setChecked(true)
                .setTitle("test feature toggle7")
                .setInfo("动态功能开关测试7")
                .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        Toast.makeText(BubbleContext.getAppContext(), "动态功能开关测试", Toast.LENGTH_SHORT).show();
                    }
                }));
        list.add(new SwitchEntity().setChecked(true)
                .setTitle("test feature toggle8")
                .setInfo("动态功能开关测试8")
                .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        Toast.makeText(BubbleContext.getAppContext(), "动态功能开关测试", Toast.LENGTH_SHORT).show();
                    }
                }));
        list.add(new SwitchEntity().setChecked(true)
                .setTitle("test feature toggle9")
                .setInfo("动态功能开关测试9")
                .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        Toast.makeText(BubbleContext.getAppContext(), "动态功能开关测试", Toast.LENGTH_SHORT).show();
                    }
                }));
        return list;
    }


}
