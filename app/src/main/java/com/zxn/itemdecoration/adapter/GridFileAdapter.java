package com.zxn.itemdecoration.adapter;

import android.view.View;

import androidx.annotation.LayoutRes;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zxn.itemdecoration.R;
import com.zxn.itemdecoration.entity.BaseInfo;

import butterknife.ButterKnife;

/**
 * Created by zxn on 2020-3-4 23:56:39.
 */
public class GridFileAdapter
        extends BaseQuickAdapter<BaseInfo, GridFileAdapter.GridFileHolder> {


    public GridFileAdapter() {
        super(GridFileHolder.ITEM_LAYOUT_ID);
    }

    @Override
    protected void convert(GridFileHolder helper, BaseInfo item) {
        helper.onConvert(item);
    }

    static class GridFileHolder extends BaseViewHolder {

        private static @LayoutRes
        int ITEM_LAYOUT_ID = R.layout.item_rv_grid_file;

        GridFileHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        void onConvert(BaseInfo item) {

        }
    }

}


