package com.zxn.itemdecoration.adapter;

import android.net.Uri;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zxn.itemdecoration.R;

/**
 * Created by zxn on 2018/11/24.
 */
public class VerticalAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public VerticalAdapter() {
        super(R.layout.item_coin_icon);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        SimpleDraweeView simpleDraweeView = helper.getView(R.id.simple_drawee_view);
        simpleDraweeView.setImageURI(Uri.parse(item));
    }
}
