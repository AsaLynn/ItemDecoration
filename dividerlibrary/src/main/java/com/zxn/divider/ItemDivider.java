package com.zxn.divider;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yanyusong.y_divideritemdecoration.Y_DividerItemDecoration;

/**
 * ItemDecoration
 * @Deprecated {@link ItemDecoration}
 * Created by zxn on 2019/1/27.
 */
@Deprecated
public abstract class ItemDivider extends Y_DividerItemDecoration {

    protected int mBgColor;
    protected float mWidthDp = 1, mStartPaddingDp, mEndPaddingDp;
    protected Context mContext;
    protected int mSpanCount;
    protected boolean mShowLastDiveder;
    protected int mBgColoerId;
    protected boolean mShowFirstDiveder;
    protected RecyclerView mRecyclerView;
    protected int mHeadCount;
    protected int mFootCount;


    protected ItemDivider(Context context) {
        super(context);
        mContext = context;
        mBgColor = context.getResources()
                .getColor(R.color.c_f2f2f2);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        mRecyclerView = parent;
    }

    public static class Builder {

        private int bgColorId;
        private float widthDp = 1, startPaddingDp, endPaddingDp;
        private Context context;
        private boolean showLastDiveder, showFirstDivider;
        private int spanCount;
        private int headCount;
        private int footCount;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder footCount(int footCount) {
            this.footCount = footCount;
            return this;
        }

        public Builder headCount(int headCount) {
            this.headCount = headCount;
            return this;
        }

        public Builder bgColor(int bgColorId) {
            this.bgColorId = bgColorId;
            return this;
        }

        public Builder widthDp(float mWidthDp) {
            this.widthDp = mWidthDp;
            return this;
        }

        public Builder startPaddingDp(float mStartPaddingDp) {
            this.startPaddingDp = mStartPaddingDp;
            return this;
        }

        public Builder endPaddingDp(float mEndPaddingDp) {
            this.endPaddingDp = mEndPaddingDp;
            return this;
        }

        public Builder showLastDiveder(boolean showLastDiveder) {
            this.showLastDiveder = showLastDiveder;
            return this;
        }

        public Builder spanCount(int spanCount) {
            this.spanCount = spanCount;
            return this;
        }

        public ItemDivider createCommon() {
            return new CommonDivider(context, bgColorId, widthDp, startPaddingDp, endPaddingDp, showLastDiveder, showFirstDivider);
        }

        public ItemDivider createVertical() {
            VerticalDivider verticalDecoration = new VerticalDivider(context);
            verticalDecoration.mBgColoerId = bgColorId;
            verticalDecoration.mWidthDp = widthDp;
            verticalDecoration.mShowLastDiveder = showLastDiveder;
            return verticalDecoration;
        }

        public ItemDivider createGrid() {
            GridDivider divider = new GridDivider(context);
            divider.mBgColoerId = bgColorId;
            divider.mWidthDp = widthDp;
            divider.mSpanCount = spanCount;
            return divider;
        }
    }

}
