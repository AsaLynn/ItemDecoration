package com.zxn.divider;

import android.content.Context;

import androidx.annotation.Nullable;

import com.yanyusong.y_divideritemdecoration.Y_Divider;
import com.yanyusong.y_divideritemdecoration.Y_DividerBuilder;

/**
 * 使用一个三列的中间间隙均匀的列表.
 * Created by zxn on 2020/3/5.
 */
public class CenterGridDecoration extends RvItemDecoration {


    protected CenterGridDecoration(Context context) {
        super(context);
    }

    @Nullable
    @Override
    public Y_Divider getDivider(int itemPosition) {
        mBgColor = mContext.getResources()
                .getColor(mBgColoerId);

        Y_Divider divider = null;
        switch (itemPosition % mSpanCount) {//mSpanCount
            case 0:
                divider = new Y_DividerBuilder()
                        .setRightSideLine(true, mBgColor, mWidthDp, 0, 0)
                        .setBottomSideLine(true, mBgColor, mWidthDp, 0, 0)
                        .create();
                break;
            case 1:
                //每一行第一个和第二个显示rignt和bottom
                divider = new Y_DividerBuilder()
                        //.setLeftSideLine(true, mBgColor, mWidthDp/2, 0, 0)
                        .setRightSideLine(true, mBgColor, mWidthDp / 2, 0, 0)
                        .setBottomSideLine(true, mBgColor, mWidthDp, 0, 0)
                        .create();
                break;
            case 2:
                //最后一个只显示bottom
                divider = new Y_DividerBuilder()
                        .setLeftSideLine(true, mBgColor, mWidthDp / 2, 0, 0)
                        .setBottomSideLine(true, mBgColor, mWidthDp, 0, 0)
                        .create();
                break;
            default:
                break;
        }
        return divider;
    }
}
