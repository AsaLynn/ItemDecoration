package com.zxn.divider;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yanyusong.y_divideritemdecoration.Y_Divider;
import com.yanyusong.y_divideritemdecoration.Y_DividerBuilder;

/**
 * Rv单条竖线.
 * Created by zxn on 2018/11/24.
 */
public class VerticalDivider extends ItemDivider {


    private RecyclerView mRecyclerView;


    protected VerticalDivider(Context context) {
        super(context);
        mContext = context;
        mBgColor = context.getResources()
                .getColor(R.color.c_ffffff);
        mWidthDp = 5;
    }

    @Override
    public Y_Divider getDivider(int itemPosition) {
        int lastItemPosition = mRecyclerView.getLayoutManager().getItemCount() - 1;
        float widthDp
                = (lastItemPosition == itemPosition && !mShowLastDiveder)
                ? 0 : mWidthDp;
        return new Y_DividerBuilder()
                .setRightSideLine(true, mBgColor, widthDp, mStartPaddingDp, mEndPaddingDp)
                .create();
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        mRecyclerView = parent;
        super.getItemOffsets(outRect, view, parent, state);
    }

    //    public void showLastDecoration(boolean show) {
//        this.showLastDecoration = show;
//    }

    @Deprecated
    public static class Builder {
        private Context context;
        private int bgColor;
        private float widthDp = 5f;
        //        private float mStartPaddingDp;
//        private float mEndPaddingDp;
        private boolean showLastDecoration;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder bgColor(int bgColor) {
            this.bgColor = bgColor;
            return this;
        }

        public Builder widthDp(float widthDp) {
            this.widthDp = widthDp;
            return this;
        }

        public Builder showLastDecoration(boolean showLastDecoration) {
            this.showLastDecoration = showLastDecoration;
            return this;
        }

        public VerticalDivider create() {
            VerticalDivider verticalDecoration = new VerticalDivider(context);
            verticalDecoration.mBgColor = bgColor;
            verticalDecoration.mWidthDp = widthDp;
            verticalDecoration.mShowLastDiveder = showLastDecoration;
            return verticalDecoration;
        }
    }

}
