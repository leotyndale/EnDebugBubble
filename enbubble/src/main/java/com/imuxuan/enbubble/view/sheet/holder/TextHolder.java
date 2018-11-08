package com.imuxuan.enbubble.view.sheet.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.imuxuan.enbubble.R;
import com.imuxuan.enbubble.view.sheet.entity.TextEntity;

/**
 * Created by Yunpeng Li on 2018/10/30.
 */
public class TextHolder extends BaseSweetHolder<TextEntity> {

    public TextHolder(View parent) {
        super(getItemView(parent));
        nameTV = (TextView) itemView.findViewById(R.id.rv_title);
    }

    private TextView nameTV;

    private static View getItemView(View itemView) {
        return LayoutInflater.from(itemView.getContext()).inflate(R.layout.item_header,
                (ViewGroup) itemView, false);
    }

    @Override
    public void bind(TextEntity menuEntity) {
        super.bind(menuEntity);
        nameTV.setText(menuEntity.title);
    }
}
