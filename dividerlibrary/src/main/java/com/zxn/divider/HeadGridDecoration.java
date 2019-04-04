package com.zxn.divider;

import android.content.Context;

import com.yanyusong.y_divideritemdecoration.Y_Divider;
import com.yanyusong.y_divideritemdecoration.Y_DividerBuilder;

/**
 * RecyclerView使用的GridLayoutManager的分割线,
 * 适配器带1个HeadView,
 * Created by zxn on 2019/4/4.
 */
public class HeadGridDecoration extends ItemDecoration {


    protected HeadGridDecoration(Context context) {
        super(context);
    }

    @Override
    public Y_Divider getDivider(int itemPosition) {
        mBgColor = mContext.getResources()
                .getColor(mBgColoerId);
        Y_DividerBuilder builder = new Y_DividerBuilder();

        //第4列条目显示每一个top,bottom(第4列的显示分隔线)
        if (itemPosition % mSpanCount == 0) {
            if (itemPosition != 0 && mHeadCount == 1) {
                //头视图条目不显示分割线.
                builder.setTopSideLine(true, mBgColor, 6, 0, 0)
                        .setBottomSideLine(true, mBgColor, 6, 0, 0);
            }
        } else {
            //第1列条目显示每一个top,rignt,bottom(第1列的显示分隔线)
            //第2列条目显示每一个top,rignt,bottom(第2列的显示分隔线)
            //第3列条目显示每一个top,rignt,bottom(第3列的显示分隔线)
            //头视图条目不显示分割线 && 脚视图条目不显示分割线
            builder.setTopSideLine(true, mBgColor, 6, 0, 0)
                    .setRightSideLine(true, mBgColor, 6, 0, 0)
                    .setBottomSideLine(true, mBgColor, 6, 0, 0);
        }
        return builder.create();
    }
}
