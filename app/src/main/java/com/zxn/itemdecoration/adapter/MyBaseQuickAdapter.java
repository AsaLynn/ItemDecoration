package com.zxn.itemdecoration.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zxn.itemdecoration.R;

/**
 * Created by zxn on 2018/11/24.
 */
public class MyBaseQuickAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public MyBaseQuickAdapter() {
        super(R.layout.item_text);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_text, item);
    }
}
