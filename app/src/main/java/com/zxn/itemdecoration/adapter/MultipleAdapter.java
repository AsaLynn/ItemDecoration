package com.zxn.itemdecoration.adapter;

import android.view.View;
import android.widget.CheckBox;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zxn.itemdecoration.R;
import com.zxn.itemdecoration.entity.TableInfo;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zxn on 2019/1/27.
 */
public class MultipleAdapter extends BaseQuickAdapter<TableInfo, MultipleAdapter.ViewHolder> {


    public MultipleAdapter() {
        super(R.layout.item_multiple_skills);
    }

    @Override
    protected void convert(ViewHolder helper, TableInfo item) {
        helper.itemSelectCb.setText(item.tableName);
    }

    static class ViewHolder extends BaseViewHolder {
        @BindView(R.id.item_select_cb)
        CheckBox itemSelectCb;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
