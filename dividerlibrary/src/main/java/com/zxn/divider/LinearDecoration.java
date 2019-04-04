package com.zxn.divider;

import android.content.Context;
import android.support.annotation.IntDef;
import android.support.v7.widget.RecyclerView;

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
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;


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

        if (mOrientation == HORIZONTAL) {
            mBgColor = mContext.getResources()
                    .getColor(mBgColoerId);
            mBgTransparent = mContext.getResources()
                    .getColor(android.R.color.transparent);
            //int lastItemPosition = mRecyclerView.getAdapter().getItemCount() - 1;
            int lastItemPosition = getItemCount();
            int bgColor = (itemPosition == lastItemPosition && !mShowLastDiveder) ? mBgTransparent : mBgColor;
            return new Y_DividerBuilder()
                    .setBottomSideLine(true, bgColor, mWidthDp, mStartPaddingDp, mEndPaddingDp).create();
        } else {
            int lastItemPosition = mRecyclerView.getLayoutManager().getItemCount() - 1;
            float widthDp
                    = (lastItemPosition == itemPosition && !mShowLastDiveder)
                    ? 0 : mWidthDp;
            return new Y_DividerBuilder()
                    .setRightSideLine(true, mBgColor, widthDp, mStartPaddingDp, mEndPaddingDp)
                    .create();
        }

    }


}
