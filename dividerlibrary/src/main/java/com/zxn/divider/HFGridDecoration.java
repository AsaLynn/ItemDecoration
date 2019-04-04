package com.zxn.divider;

import android.content.Context;

import com.yanyusong.y_divideritemdecoration.Y_Divider;
import com.yanyusong.y_divideritemdecoration.Y_DividerBuilder;

/**
 * Created by zxn on 2019/4/4.
 */
public class HFGridDecoration extends RvItemDecoration {

    protected HFGridDecoration(Context context) {
        super(context);
    }

    @Override
    public Y_Divider getDivider(int itemPosition) {
        mBgColor = mContext.getResources()
                .getColor(mBgColoerId);
        Y_DividerBuilder builder = new Y_DividerBuilder();


        if (itemPosition % mSpanCount == 0) { //第4列条目显示每一个top,bottom(第4列的显示分隔线)
            if (itemPosition != 0 && mHeadCount == 1) {//头视图条目不显示分割线.
                builder.setTopSideLine(true, mBgColor, mWidthDp, 0, 0)
                        .setBottomSideLine(true, mBgColor, mWidthDp, 0, 0);
            }
        } else {
            //第1列条目显示每一个top,rignt,bottom(第1列的显示分隔线)
            //第2列条目显示每一个top,rignt,bottom(第2列的显示分隔线)
            //第3列条目显示每一个top,rignt,bottom(第3列的显示分隔线)
            if (itemPosition != 0 && itemPosition != getItemCount() - 1) {//itemPosition==5--->(foot)-->getItemCount==6
                //头视图条目不显示分割线 && 脚视图条目不显示分割线
                builder.setTopSideLine(true, mBgColor, mWidthDp, 0, 0)
                        .setRightSideLine(true, mBgColor, mWidthDp, 0, 0)
                        .setBottomSideLine(true, mBgColor, mWidthDp, 0, 0);
            }
        }
        return builder.create();
    }

//    private int getItemCount() {
//        if (mRecyclerView == null) return 0;
//        if (mRecyclerView.getLayoutManager() == null) return 0;
//        return mRecyclerView.getLayoutManager().getItemCount();
//    }

}



