package com.zxn.itemdecoration.recycleradapter;


/**
 * Created by mac on 16/6/18.
 */
public interface Y_OnBind<T> {

    /**
     * @param holder
     * @param position
     */
    void onBindChildViewData(GeneralRecyclerViewHolder holder, Object itemData, int position);
}
