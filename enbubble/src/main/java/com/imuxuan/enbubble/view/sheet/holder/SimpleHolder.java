package com.imuxuan.enbubble.view.sheet.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.imuxuan.enbubble.R;
import com.imuxuan.enbubble.view.sheet.entity.SimpleEntity;


/**
 * Created by Yunpeng Li on 2018/10/30.
 */
public class SimpleHolder extends BaseSweetHolder<SimpleEntity> {

    public ImageView iv;
    private TextView nameTV;
    public RelativeLayout itemRl;

    public SimpleHolder(View parent) {
        super(getItemView(parent));
        iv = (ImageView) itemView.findViewById(R.id.icon);
        nameTV = (TextView) itemView.findViewById(R.id.nameTV);
        itemRl = (RelativeLayout) itemView.findViewById(R.id.itemRl);
    }

    public View getContent() {
        return itemRl;
    }

    private static View getItemView(View itemView) {
        return LayoutInflater.from(itemView.getContext()).inflate(
                R.layout.item_horizon_rv, null, false
        );
    }

    @Override
    public void bind(SimpleEntity menuEntity) {
        super.bind(menuEntity);
        itemRl.setTag(getAdapterPosition());
        if (menuEntity.iconId != 0) {
            iv.setVisibility(View.VISIBLE);
            iv.setImageResource(menuEntity.iconId);
        } else if (menuEntity.icon != null) {
            iv.setVisibility(View.VISIBLE);
            iv.setImageDrawable(menuEntity.icon);
        } else {
            iv.setVisibility(View.GONE);
        }
        nameTV.setText(menuEntity.title);
        nameTV.setTextColor(menuEntity.titleColor);
    }
}