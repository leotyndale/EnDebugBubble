package com.imuxuan.enbubble.view.sheet.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.imuxuan.enbubble.R;
import com.imuxuan.enbubble.view.radio.GroupRadioView;
import com.imuxuan.enbubble.view.sheet.entity.RadioEntity;


/**
 * Created by Yunpeng Li on 2018/10/31.
 */
public class RadioHolder extends BaseSweetHolder<RadioEntity> {

    private final TextView nameTV;
    private final GroupRadioView hostSpace;

    public RadioHolder(View parent) {
        super(getItemView(parent));
        nameTV = (TextView) itemView.findViewById(R.id.nameTV);
        hostSpace = (GroupRadioView) itemView.findViewById(R.id.radio_group_host);
    }

    private static View getItemView(View itemView) {
        return LayoutInflater.from(itemView.getContext()).inflate(R.layout.item_radio,
                (ViewGroup) itemView, false);
    }

    @Override
    public void bind(RadioEntity menuEntity) {
        super.bind(menuEntity);
        nameTV.setText(menuEntity.title);
        nameTV.setTextColor(menuEntity.titleColor);
        hostSpace.setCheck(menuEntity.getCheckPosition());
        hostSpace.setGroupBtnName(menuEntity.getGroupBtnName());
        hostSpace.setOnGroupBtnClickListener(menuEntity.getOnCheckedChangeListener());
    }
}
