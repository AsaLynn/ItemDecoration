package com.zxn.itemdecoration.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zxn.itemdecoration.R;
import com.zxn.itemdecoration.entity.HomeOptionsEntity;
import com.zxn.itemdecoration.utils.ViewUtil;
import com.zxn.itemdecoration.weight.DrawableTopTextView;


import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zxn on 2019/4/2.
 */
public class HomeOptionsAdatper extends BaseQuickAdapter<HomeOptionsEntity, HomeOptionsAdatper.ViewHolder> {

    public HomeOptionsAdatper() {
        super(R.layout.item_home_optios);
    }

    @Override
    protected void convert(ViewHolder helper, HomeOptionsEntity item) {
        //helper.dttvOptions.setText(item.name);
        helper.dttvOptions.setText(item.textId);
        ViewUtil.setDrawTopBitmap(mContext.getResources(), item.resId, helper.dttvOptions);
    }

    static class ViewHolder extends BaseViewHolder {
        @BindView(R.id.dttv_options)
        DrawableTopTextView dttvOptions;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
