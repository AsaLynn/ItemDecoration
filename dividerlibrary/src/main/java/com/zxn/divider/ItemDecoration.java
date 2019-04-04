package com.zxn.divider;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yanyusong.y_divideritemdecoration.Y_DividerItemDecoration;

/**
 * Created by zxn on 2019/4/4.
 */
public abstract class ItemDecoration extends Y_DividerItemDecoration {

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

    protected ItemDecoration(Context context) {
        super(context);
        mContext = context;
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

        public ItemDecoration.Builder footCount(int footCount) {
            this.footCount = footCount;
            return this;
        }

        public ItemDecoration.Builder headCount(int headCount) {
            this.headCount = headCount;
            return this;
        }

        public ItemDecoration.Builder bgColor(int bgColorId) {
            this.bgColorId = bgColorId;
            return this;
        }

        public ItemDecoration.Builder widthDp(float mWidthDp) {
            this.widthDp = mWidthDp;
            return this;
        }

        public ItemDecoration.Builder startPaddingDp(float mStartPaddingDp) {
            this.startPaddingDp = mStartPaddingDp;
            return this;
        }

        public ItemDecoration.Builder endPaddingDp(float mEndPaddingDp) {
            this.endPaddingDp = mEndPaddingDp;
            return this;
        }

        public ItemDecoration.Builder showLastDiveder(boolean showLastDiveder) {
            this.showLastDiveder = showLastDiveder;
            return this;
        }

        public ItemDecoration.Builder spanCount(int spanCount) {
            this.spanCount = spanCount;
            return this;
        }

        //LinearLayoutManager
        public ItemDecoration createLinear() {
            LinearDecoration decoration = new LinearDecoration(context);
            decoration.mBgColoerId = bgColorId;
            decoration.mWidthDp = widthDp;
            decoration.mShowLastDiveder = showLastDiveder;
            return decoration;
        }

        public ItemDecoration createGrid() {
            GridDecoration decoration = new GridDecoration(context);
            decoration.mBgColoerId = bgColorId;
            decoration.mWidthDp = widthDp;
            decoration.mSpanCount = spanCount;
            return decoration;
        }

        public ItemDecoration createHeadGrid() {
            HeadGridDecoration decoration = new HeadGridDecoration(context);
            decoration.mBgColoerId = bgColorId;
            decoration.mWidthDp = widthDp;
            decoration.mSpanCount = spanCount;
            decoration.mHeadCount = headCount;
            return decoration;
        }

        //FootGridDecoration
        public ItemDecoration createFootGrid() {
            FootGridDecoration decoration = new FootGridDecoration(context);
            decoration.mBgColoerId = bgColorId;
            decoration.mWidthDp = widthDp;
            decoration.mSpanCount = spanCount;
            decoration.mHeadCount = headCount;
            decoration.mFootCount = footCount;
            return decoration;
        }

        //HFGridDecoration
        public ItemDecoration createHeadFootGrid() {
            HFGridDecoration decoration = new HFGridDecoration(context);
            decoration.mBgColoerId = bgColorId;
            decoration.mWidthDp = widthDp;
            decoration.mSpanCount = spanCount;
            decoration.mHeadCount = headCount;
            decoration.mFootCount = footCount;
            return decoration;
        }

        /**
         * 带头视图的grid分割线.MultipleGridDecoration
         *
         * @return
         */
        //todo:有待完善...
        public ItemDecoration createMultipleGrid() {
            MultipleGridDecoration divider = new MultipleGridDecoration(context);
            divider.mBgColoerId = bgColorId;
            divider.mWidthDp = widthDp;
            divider.mSpanCount = spanCount;
            divider.mHeadCount = headCount;
            return divider;
        }

    }
}
