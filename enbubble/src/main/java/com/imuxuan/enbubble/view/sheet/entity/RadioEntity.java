package com.imuxuan.enbubble.view.sheet.entity;


import com.imuxuan.enbubble.view.radio.GroupRadioView;

/**
 * Created by Yunpeng Li on 2018/10/31.
 */
public class RadioEntity extends SimpleEntity {

    private GroupRadioView.OnGroupBtnClickListener onCheckedChangeListener;
    private String groupBtnName;
    private String groupBtnCode;
    private int checkPosition;

    public RadioEntity setOnCheckedChangeListener(final GroupRadioView.OnGroupBtnClickListener onCheckedChangeListener) {
        this.onCheckedChangeListener = onCheckedChangeListener;
        return this;
    }

    public GroupRadioView.OnGroupBtnClickListener getOnCheckedChangeListener() {
        return onCheckedChangeListener;
    }

    public String getGroupBtnName() {
        return groupBtnName;
    }

    public RadioEntity setGroupBtnName(String groupBtnName) {
        this.groupBtnName = groupBtnName;
        return this;
    }

    public String getGroupBtnCode() {
        return groupBtnCode;
    }

    public RadioEntity setGroupBtnCode(String groupBtnCode) {
        this.groupBtnCode = groupBtnCode;
        return this;
    }

    public int getCheckPosition() {
        return checkPosition;
    }

    public RadioEntity setCheckPosition(int checkPosition) {
        this.checkPosition = checkPosition;
        return this;
    }
}
