package com.zxn.itemdecoration;

import android.net.Uri;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by zxn on 2018/11/24.
 */
class VerticalAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public VerticalAdapter() {
        super(R.layout.item_coin_icon);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        SimpleDraweeView simpleDraweeView = helper.getView(R.id.simple_drawee_view);
        simpleDraweeView.setImageURI(Uri.parse(item));
    }
}
