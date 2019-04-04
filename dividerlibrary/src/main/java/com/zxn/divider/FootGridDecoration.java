package com.zxn.divider;

import android.content.Context;

import com.yanyusong.y_divideritemdecoration.Y_Divider;
import com.yanyusong.y_divideritemdecoration.Y_DividerBuilder;

/**
 * * RecyclerView使用的GridLayoutManager的分割线,
 * * 适配器带1个footview,
 * Created by zxn on 2019/4/4.
 */
public class FootGridDecoration extends ItemDecoration {

    protected FootGridDecoration(Context context) {
        super(context);
    }

    @Override
    public Y_Divider getDivider(int itemPosition) {
        mBgColor = mContext.getResources()
                .getColor(mBgColoerId);
        Y_DividerBuilder builder = new Y_DividerBuilder();

        if (itemPosition % mSpanCount == 3) {
            builder.setTopSideLine(true, mBgColor, 6, 0, 0)
                    .setBottomSideLine(true, mBgColor, 6, 0, 0);
        } else {
            if (itemPosition != getItemCount() - 1) {//itemPosition==4--->(foot)-->getItemCount==5.
                //脚视图条目不显示分割线
                builder.setTopSideLine(true, mBgColor, 6, 0, 0)
                        .setRightSideLine(true, mBgColor, 6, 0, 0)
                        .setBottomSideLine(true, mBgColor, 6, 0, 0);
            }
        }
        return builder.create();
    }

    private int getItemCount() {
        if (mRecyclerView == null) return 0;
        if (mRecyclerView.getLayoutManager() == null) return 0;
        return mRecyclerView.getLayoutManager().getItemCount();
        //return mRecyclerView.getLayoutManager() == null ? 0 : mRecyclerView.getLayoutManager().getItemCount();
    }


}
