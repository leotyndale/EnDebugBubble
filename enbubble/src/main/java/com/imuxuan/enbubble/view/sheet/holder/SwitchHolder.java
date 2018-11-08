package com.imuxuan.enbubble.view.sheet.holder;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.imuxuan.enbubble.R;
import com.imuxuan.enbubble.view.sheet.entity.SwitchEntity;


/**
 * Created by Yunpeng Li on 2018/10/30.
 */
public class SwitchHolder extends BaseSweetHolder<SwitchEntity> {

    public Switch iv;
    private TextView nameTV;
    private RelativeLayout itemRl;
    private TextView info;

    public SwitchHolder(View parent) {
        super(getItemView(parent));
        setIsRecyclable(false);
        iv = (Switch) itemView.findViewById(R.id.iv);
        nameTV = (TextView) itemView.findViewById(R.id.nameTV);
        itemRl = (RelativeLayout) itemView.findViewById(R.id.itemRl);
        info = (TextView) itemView.findViewById(R.id.infoTV);
    }

    public View getContent() {
        return itemRl;
    }

    private static View getItemView(View itemView) {
        return LayoutInflater.from(itemView.getContext()).inflate(
                R.layout.item_horizon_check, null, false
        );
    }

    @Override
    public void bind(SwitchEntity menuEntity) {
        super.bind(menuEntity);
        nameTV.setText(menuEntity.getTitle());
        nameTV.setTextColor(menuEntity.getTitleColor());

        if (!TextUtils.isEmpty(menuEntity.getInfo())) {
            info.setVisibility(View.VISIBLE);
            info.setText(menuEntity.getInfo());
        } else {
            info.setVisibility(View.GONE);
        }

        iv.setChecked(menuEntity.isChecked());
        iv.setOnCheckedChangeListener(menuEntity.getOnCheckedChangeListener());
    }
}