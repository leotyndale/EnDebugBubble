package com.imuxuan.enbubble.view.radio;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.imuxuan.enbubble.R;

public class GroupRadioView extends LinearLayout {

    private RadioGroup mRg;

    private Context mContext;
    private OnGroupBtnClickListener listener;

    private String groupBtnName = "A#B";
    private int check;
    private boolean isAdded;

    public GroupRadioView(Context context) {
        this(context, null);
    }

    public GroupRadioView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GroupRadioView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initContentView();
//        initView();
        initData();
    }

    public GroupRadioView setGroupBtnName(String groupBtnName) {
        this.groupBtnName = groupBtnName;
        initView();
        return this;
    }

    private void initContentView() {
        View.inflate(mContext, R.layout.view_item_group_buttons, this);
        mRg = (RadioGroup) findViewById(R.id.rg_item_group_btn);
    }

    private void initView() {
        if (isAdded) {
            return;
        }
        String[] btnNameArr = groupBtnName.split("#");
        if ((btnNameArr.length < 2)) {
            return;
        }

        for (int i = 0; i < btnNameArr.length; i++) {
            RadioButton rb = (RadioButton) View.inflate(mContext, R.layout.view_item_group_radio_button, null);
            if (btnNameArr.length == 2) {
                if (i == 0) {
                    rb.setBackgroundResource(R.drawable.left_button_selector);
//                    rb.setChecked(true);
                } else if (i == 1) {
                    rb.setBackgroundResource(R.drawable.right_button_selector);
                }
            } else {
                if (i == 0) {
                    rb.setBackgroundResource(R.drawable.left_button_selector);

                } else if (i == btnNameArr.length - 1) {
                    rb.setBackgroundResource(R.drawable.right_button_selector);
                } else {
                    rb.setBackgroundResource(R.drawable.mid_button_selector);
                }
            }
            if (i == check) {
                rb.setChecked(true);
            }
            rb.setId(i);
            rb.setTag(i);
            rb.setText(btnNameArr[i]);

            mRg.addView(rb);
        }
        isAdded = true;
        postInvalidate();
        requestLayout();
    }

    private void initData() {
        mRg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup rg, int checkedId) {
                RadioButton rb = (RadioButton) findViewById(checkedId);
                if (rb != null && rb.isChecked() && listener != null) {
                    listener.groupBtnClick((Integer) rb.getTag());
                }
            }
        });
    }

    public void setCheck(int position) {
        check = position;
    }

    public interface OnGroupBtnClickListener {
        void groupBtnClick(int position);
    }

    public void setOnGroupBtnClickListener(OnGroupBtnClickListener listener) {
        this.listener = listener;
    }
}
