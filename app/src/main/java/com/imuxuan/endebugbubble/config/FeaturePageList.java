package com.imuxuan.endebugbubble.config;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import com.imuxuan.enbubble.BubbleContext;
import com.imuxuan.enbubble.view.sheet.entity.SimpleEntity;
import com.imuxuan.enbubble.view.sheet.entity.TextEntity;

import java.util.ArrayList;

/**
 * @ClassName FeaturePageList
 * @Description 请在{@link #get()}中直接向List添加测试数据
 * @Author Yunpeng Li
 * @Creation 2018/10/31 下午3:20
 * @Mender Yunpeng Li
 * @Modification 2018/10/31 下午3:20
 */
public class FeaturePageList {

    @NonNull
    public ArrayList<SimpleEntity> get() {
        final ArrayList<SimpleEntity> list = new ArrayList<>();
        list.add(new TextEntity().setTitle("测试页面"));
        list.add(new SimpleEntity().setTitle("测试1")
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(BubbleContext.getAppContext(), "Test", Toast.LENGTH_SHORT).show();
                    }
                }));
        list.add(new SimpleEntity().setTitle("测试2")
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(BubbleContext.getAppContext(), "Test", Toast.LENGTH_SHORT).show();

                    }
                }));
        list.add(new SimpleEntity().setTitle("测试3")
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(BubbleContext.getAppContext(), "Test", Toast.LENGTH_SHORT).show();
                    }
                }));
        list.add(new SimpleEntity().setTitle("测试4")
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(BubbleContext.getAppContext(), "Test", Toast.LENGTH_SHORT).show();
                    }
                }));
        list.add(new SimpleEntity().setTitle("测试6")
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(BubbleContext.getAppContext(), "Test", Toast.LENGTH_SHORT).show();
                    }
                }));
        list.add(new SimpleEntity().setTitle("测试7")
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(BubbleContext.getAppContext(), "Test", Toast.LENGTH_SHORT).show();
                    }
                }));
        list.add(new SimpleEntity().setTitle("测试8")
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(BubbleContext.getAppContext(), "Test", Toast.LENGTH_SHORT).show();
                    }
                }));
        list.add(new SimpleEntity().setTitle("测试9")
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(BubbleContext.getAppContext(), "Test", Toast.LENGTH_SHORT).show();
                    }
                }));
        list.add(new SimpleEntity().setTitle("测试10")
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(BubbleContext.getAppContext(), "Test", Toast.LENGTH_SHORT).show();
                    }
                }));
        list.add(new SimpleEntity().setTitle("测试11")
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(BubbleContext.getAppContext(), "Test", Toast.LENGTH_SHORT).show();
                    }
                }));
        return list;
    }

}
