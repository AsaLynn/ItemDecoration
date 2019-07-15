package com.zxn.divider;

import android.content.Context;
import android.support.annotation.IntDef;

import com.yanyusong.y_divideritemdecoration.Y_Divider;
import com.yanyusong.y_divideritemdecoration.Y_DividerBuilder;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Rv单条竖线.
 * Linear
 * Created by zxn on 2018/11/24.
 */
public class LinearDecoration extends RvItemDecoration {
    private int mBgTransparent;
    public static final int HORIZONTAL = 0;//适用于横向滑动的列表
    public static final int VERTICAL = 1;//适用于纵向滑动的列表


    @IntDef({HORIZONTAL, VERTICAL})
    @Retention(RetentionPolicy.SOURCE)
    public @interface OrientationMode {
    }

    protected LinearDecoration(Context context) {
        super(context);
        mContext = context;
        mBgColor = context.getResources()
                .getColor(R.color.c_ffffff);


        mWidthDp = 5;
    }

    @Override
    public Y_Divider getDivider(int itemPosition) {
        if (mBgColoerId != 0) {
            mBgColor = mContext.getResources()
                    .getColor(mBgColoerId);
        }

        if (mOrientation == VERTICAL) {

            mBgTransparent = mContext.getResources()
                    .getColor(android.R.color.transparent);
            int lastItemPosition = getItemCount();
            int bgColor = (itemPosition == lastItemPosition && !mShowLastDiveder) ? mBgTransparent : mBgColor;
            if (itemPosition == 0) {
                if (mHeadCount == 1) {
                    if (mShowHeadDecoration) {
                        return new Y_DividerBuilder()
                                .setLeftSideLine(mShowLeft, bgColor, mWidthDp, mStartPaddingDp, mEndPaddingDp)
                                .setTopSideLine(mShowFirstDiveder, bgColor, mWidthDp, mStartPaddingDp, mEndPaddingDp)
                                .setRightSideLine(mShowRight, bgColor, mWidthDp, mStartPaddingDp, mEndPaddingDp)
                                .setBottomSideLine(true, bgColor, mWidthDp, mStartPaddingDp, mEndPaddingDp).create();
                    } else {
                        return new Y_DividerBuilder()
                                .setTopSideLine(mShowFirstDiveder, bgColor, mWidthDp, mStartPaddingDp, mEndPaddingDp)
                                .setBottomSideLine(true, bgColor, mWidthDp, mStartPaddingDp, mEndPaddingDp).create();
                    }
                } else {
                    return new Y_DividerBuilder()
                            .setLeftSideLine(mShowLeft, bgColor, mWidthDp, mStartPaddingDp, mEndPaddingDp)
                            .setTopSideLine(mShowFirstDiveder, bgColor, mWidthDp, mStartPaddingDp, mEndPaddingDp)
                            .setRightSideLine(mShowRight, bgColor, mWidthDp, mStartPaddingDp, mEndPaddingDp)
                            .setBottomSideLine(true, bgColor, mWidthDp, mStartPaddingDp, mEndPaddingDp).create();
                }
            } else {
                return new Y_DividerBuilder()
                        .setLeftSideLine(mShowLeft, bgColor, mWidthDp, mStartPaddingDp, mEndPaddingDp)
                        .setRightSideLine(mShowRight, bgColor, mWidthDp, mStartPaddingDp, mEndPaddingDp)
                        .setBottomSideLine(true, bgColor, mWidthDp, mStartPaddingDp, mEndPaddingDp).create();
            }
        } else {
            if (itemPosition == 0) {
                return new Y_DividerBuilder()
                        .setRightSideLine(true, mBgColor, mWidthDp, mStartPaddingDp, mEndPaddingDp)
                        .setLeftSideLine(mShowFirstDiveder, mBgColor, mWidthDp, mStartPaddingDp, mEndPaddingDp)
                        .create();
            } else if (itemPosition == getItemCount() - 1) {
                return new Y_DividerBuilder()
                        .setRightSideLine(mShowLastDiveder, mBgColor, mWidthDp, mStartPaddingDp, mEndPaddingDp)
                        .create();
            } else {
                return new Y_DividerBuilder()
                        .setRightSideLine(true, mBgColor, mWidthDp, mStartPaddingDp, mEndPaddingDp)
                        .create();
            }
        }

    }


}
