package com.zxn.divider;

import android.content.Context;

import androidx.annotation.Nullable;

import com.yanyusong.y_divideritemdecoration.Y_Divider;
import com.yanyusong.y_divideritemdecoration.Y_DividerBuilder;

/**
 * 只有内部有间隙均匀的列表,适用于列数有1,2,
 * Created by zxn on 2020/3/5.
 */
public class CenterGridDecoration extends RvItemDecoration {


    protected CenterGridDecoration(Context context) {
        super(context);
    }

    /**
     * 判断当前位置的条目是否处于最后一行.
     *
     * @param itemPosition 条目位置.
     * @return true:最后一行.
     */
    private boolean isLastLine(int itemPosition) {
        //计算行数,最后一行不展示底部
        int complementCount = getItemCount() % mSpanCount;
        //行数
        if (getItemCount() <= mSpanCount){
            return true;
        }
        int lineCount = getItemCount() / mSpanCount + (complementCount == 0 ? complementCount : 1);

        //根据位置,判断处于第几行.
        //1:--->0,1 (0 / 2 + 1)
        //2:--->2,3 (2 / 2 + 1)
        //3:--->4,5 (4 / 2 + 1)
        //lineCount:--->(itemPosition / mSpanCount + 1)
        return lineCount == (itemPosition / mSpanCount + 1);
    }

    /**
     * 绘制条目分割线.
     *
     * @param itemPosition 条目位置索引.
     * @return 分割线.
     */
    @Nullable
    @Override
    public Y_Divider getDivider(int itemPosition) {
        mBgColor = mContext.getResources()
                .getColor(mBgColoerId);
        Y_Divider divider = null;
        if (mSpanCount == 1) {
            if (isLastLine(itemPosition)) {
                return new Y_DividerBuilder()
                        .setLeftSideLine(false, mBgColor, mWidthDp, 0, 0)
                        .setTopSideLine(false, mBgColor, mWidthDp, 0, 0)
                        .setRightSideLine(false, mBgColor, mWidthDp, 0, 0)
                        .setBottomSideLine(false, mBgColor, mWidthDp, 0, 0)
                        .create();
            } else {
                return new Y_DividerBuilder()
                        .setLeftSideLine(false, mBgColor, mWidthDp, 0, 0)
                        .setTopSideLine(false, mBgColor, mWidthDp, 0, 0)
                        .setRightSideLine(false, mBgColor, mWidthDp, 0, 0)
                        .setBottomSideLine(true, mBgColor, mWidthDp, 0, 0)
                        .create();
            }
        } else if (mSpanCount == 2) {
            if (itemPosition % mSpanCount == 0) {//第1列
                //最后一行左边的不绘制底部
                if (isLastLine(itemPosition)) {
                    return new Y_DividerBuilder()
                            .setLeftSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setTopSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setRightSideLine(true, mBgColor, mWidthDp, 0, 0)
                            .setBottomSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .create();
                } else {
                    return new Y_DividerBuilder()
                            .setLeftSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setTopSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setRightSideLine(true, mBgColor, mWidthDp, 0, 0)
                            .setBottomSideLine(true, mBgColor, mWidthDp, 0, 0)
                            .create();
                }

            } else {////第2列
                if (isLastLine(itemPosition)) {
                    return new Y_DividerBuilder()
                            .setLeftSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setTopSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setRightSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setBottomSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .create();
                } else {
                    return new Y_DividerBuilder()
                            .setLeftSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setTopSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setRightSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setBottomSideLine(true, mBgColor, mWidthDp, 0, 0)
                            .create();
                }
            }
        } else if (mSpanCount == 3) {
            if (itemPosition % mSpanCount == 0) {//第1列
                if (isLastLine(itemPosition)) {
                    return new Y_DividerBuilder()
                            .setLeftSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setTopSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setRightSideLine(true, mBgColor, mWidthDp, 0, 0)
                            .setBottomSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .create();
                } else {
                    return new Y_DividerBuilder()
                            .setLeftSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setTopSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setRightSideLine(true, mBgColor, mWidthDp, 0, 0)
                            .setBottomSideLine(true, mBgColor, mWidthDp, 0, 0)
                            .create();
                }

            } else if (itemPosition % mSpanCount == 1) {//第2列
                if (isLastLine(itemPosition)) {
                    return new Y_DividerBuilder()
                            .setLeftSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setTopSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setRightSideLine(true, mBgColor, mWidthDp, 0, 0)
                            .setBottomSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .create();
                } else {
                    return new Y_DividerBuilder()
                            .setLeftSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setTopSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setRightSideLine(true, mBgColor, mWidthDp, 0, 0)
                            .setBottomSideLine(true, mBgColor, mWidthDp, 0, 0)
                            .create();
                }
            } else {//第3列
                if (isLastLine(itemPosition)) {
                    return new Y_DividerBuilder()
                            .setLeftSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setTopSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setRightSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setBottomSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .create();
                } else {
                    return new Y_DividerBuilder()
                            .setLeftSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setTopSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setRightSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setBottomSideLine(true, mBgColor, mWidthDp, 0, 0)
                            .create();
                }
            }
        } else if (mSpanCount == 4) {
            if (itemPosition % mSpanCount == 0) {//第1列
                if (isLastLine(itemPosition)) {
                    return new Y_DividerBuilder()
                            .setLeftSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setTopSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setRightSideLine(true, mBgColor, mWidthDp, 0, 0)
                            .setBottomSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .create();
                } else {
                    return new Y_DividerBuilder()
                            .setLeftSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setTopSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setRightSideLine(true, mBgColor, mWidthDp, 0, 0)
                            .setBottomSideLine(true, mBgColor, mWidthDp, 0, 0)
                            .create();
                }

            } else if (itemPosition % mSpanCount == 1) {//第2列
                if (isLastLine(itemPosition)) {
                    return new Y_DividerBuilder()
                            .setLeftSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setTopSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setRightSideLine(true, mBgColor, mWidthDp, 0, 0)
                            .setBottomSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .create();
                } else {
                    return new Y_DividerBuilder()
                            .setLeftSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setTopSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setRightSideLine(true, mBgColor, mWidthDp, 0, 0)
                            .setBottomSideLine(true, mBgColor, mWidthDp, 0, 0)
                            .create();
                }
            } else if (itemPosition % mSpanCount == 2) {//第2列
                if (isLastLine(itemPosition)) {
                    return new Y_DividerBuilder()
                            .setLeftSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setTopSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setRightSideLine(true, mBgColor, mWidthDp, 0, 0)
                            .setBottomSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .create();
                } else {
                    return new Y_DividerBuilder()
                            .setLeftSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setTopSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setRightSideLine(true, mBgColor, mWidthDp, 0, 0)
                            .setBottomSideLine(true, mBgColor, mWidthDp, 0, 0)
                            .create();
                }
            } else {//第3列
                if (isLastLine(itemPosition)) {
                    return new Y_DividerBuilder()
                            .setLeftSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setTopSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setRightSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setBottomSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .create();
                } else {
                    return new Y_DividerBuilder()
                            .setLeftSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setTopSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setRightSideLine(false, mBgColor, mWidthDp, 0, 0)
                            .setBottomSideLine(true, mBgColor, mWidthDp, 0, 0)
                            .create();
                }
            }
        } else {
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
            }
            return divider;
        }
    }
}
