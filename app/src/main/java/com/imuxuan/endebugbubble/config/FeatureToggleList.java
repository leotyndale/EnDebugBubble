package com.imuxuan.endebugbubble.config;

import android.support.annotation.NonNull;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.imuxuan.enbubble.BubbleContext;
import com.imuxuan.enbubble.view.radio.GroupRadioView;
import com.imuxuan.enbubble.view.sheet.entity.RadioEntity;
import com.imuxuan.enbubble.view.sheet.entity.SimpleEntity;
import com.imuxuan.enbubble.view.sheet.entity.SwitchEntity;
import com.imuxuan.enbubble.view.sheet.entity.TextEntity;

import java.util.ArrayList;

/**
 * @ClassName FeatureToggleList
 * @Description 请在{@link #get()}中直接向List添加测试数据
 * @Author Yunpeng Li
 * @Creation 2018/10/31 下午3:20
 * @Mender Yunpeng Li
 * @Modification 2018/10/31 下午3:20
 */
public class FeatureToggleList {

    private static int hostType = 2;

    private static final int HOST_TYPE_ONE = 0;
    private static final int HOST_TYPE_TWO = 1;
    private static final int HOST_TYPE_THREE = 2;

    @NonNull
    public ArrayList<SimpleEntity> get() {
        final ArrayList<SimpleEntity> list = new ArrayList<>();
        list.add(new TextEntity().setTitle("功能开关"));
        list.add(new RadioEntity().setGroupBtnName("接口类型1#接口类型2#接口类型3")
                .setCheckPosition(getSelectedHostId())
                .setOnCheckedChangeListener(getHostCheckedChangeListener()).setTitle("接口类型:"));
        list.add(new SwitchEntity().setChecked(true).setTitle("测试1")
                .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        Toast.makeText(BubbleContext.getAppContext(), "Test", Toast.LENGTH_SHORT).show();
                    }
                }));
        list.add(new SwitchEntity().setChecked(true).setTitle("测试2")
                .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        Toast.makeText(BubbleContext.getAppContext(), "Test", Toast.LENGTH_SHORT).show();
                    }
                }));
        list.add(new SwitchEntity().setChecked(false).setTitle("测试3")
                .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        Toast.makeText(BubbleContext.getAppContext(), "Test", Toast.LENGTH_SHORT).show();
                    }
                }));
        list.add(new SwitchEntity().setChecked(false).setTitle("测试4")
                .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        Toast.makeText(BubbleContext.getAppContext(), "Test", Toast.LENGTH_SHORT).show();
                    }
                }));
        list.add(new SwitchEntity().setChecked(true).setTitle("测试5")
                .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        Toast.makeText(BubbleContext.getAppContext(), "Test", Toast.LENGTH_SHORT).show();
                    }
                }));
        list.add(new SwitchEntity().setChecked(false).setTitle("测试6")
                .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        Toast.makeText(BubbleContext.getAppContext(), "Test", Toast.LENGTH_SHORT).show();
                    }
                }));
        list.add(new SwitchEntity().setChecked(true).setTitle("测试7")
                .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        Toast.makeText(BubbleContext.getAppContext(), "Test", Toast.LENGTH_SHORT).show();
                    }
                }));
        list.add(new SwitchEntity().setChecked(false).setTitle("测试8")
                .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    }
                }));
        list.add(new SwitchEntity().setChecked(true).setTitle("测试9")
                .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    }
                }));
        list.add(new SwitchEntity().setChecked(true).setTitle("测试10")
                .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    }
                }));
        list.add(new SwitchEntity().setChecked(false).setTitle("测试11")
                .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        Toast.makeText(BubbleContext.getAppContext(), "Test", Toast.LENGTH_SHORT).show();
                    }
                }));
        list.add(new SwitchEntity().setChecked(false).setTitle("测试12")
                .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        Toast.makeText(BubbleContext.getAppContext(), "Test", Toast.LENGTH_SHORT).show();
                    }
                }));
        list.add(new SwitchEntity().setChecked(true).setTitle("测试13")
                .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        Toast.makeText(BubbleContext.getAppContext(), "Test", Toast.LENGTH_SHORT).show();
                    }
                }));
        list.add(new SwitchEntity().setChecked(false).setTitle("测试14")
                .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        Toast.makeText(BubbleContext.getAppContext(), "Test", Toast.LENGTH_SHORT).show();
                    }
                }));
        list.add(new SwitchEntity().setChecked(false).setTitle("测试15")
                .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        Toast.makeText(BubbleContext.getAppContext(), "Test", Toast.LENGTH_SHORT).show();
                    }
                }));
        list.add(new SwitchEntity().setChecked(false).setTitle("测试16")
                .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        Toast.makeText(BubbleContext.getAppContext(), "Test", Toast.LENGTH_SHORT).show();
                    }
                }));
        list.add(new SwitchEntity().setChecked(false).setTitle("测试17")
                .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        Toast.makeText(BubbleContext.getAppContext(), "Test", Toast.LENGTH_SHORT).show();
                    }
                }));
        return list;
    }

    @NonNull
    private GroupRadioView.OnGroupBtnClickListener getHostCheckedChangeListener() {
        return new GroupRadioView.OnGroupBtnClickListener() {
            @Override
            public void groupBtnClick(int position) {
                switch (position) {
                    case 0:
                        hostType = HOST_TYPE_ONE;
                        break;
                    case 1:
                        hostType = HOST_TYPE_TWO;
                        break;
                    case 2:
                        hostType = HOST_TYPE_THREE;
                        break;
                }
            }
        };
    }

    private int getSelectedHostId() {
        int selectedHostId = 2;
        switch (hostType) {
            case HOST_TYPE_ONE:
                selectedHostId = 0;
                break;
            case HOST_TYPE_TWO:
                selectedHostId = 1;
                break;
            default:
                break;
        }
        return selectedHostId;
    }
}
