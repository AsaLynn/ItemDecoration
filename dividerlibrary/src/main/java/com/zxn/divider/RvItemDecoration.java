package com.zxn.divider;

import android.content.Context;
import android.graphics.Rect;

import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.yanyusong.y_divideritemdecoration.Y_DividerItemDecoration;

/**
 * Created by zxn on 2019/4/4.
 */
public abstract class RvItemDecoration extends Y_DividerItemDecoration {


    protected int mBgColor;
    protected float mWidthDp = 1, mStartPaddingDp, mEndPaddingDp;
    protected Context mContext;
    protected int mSpanCount;
    protected int mBgColoerId;
    protected boolean mShowLeft, mShowFirstDiveder, mShowRight, mShowLastDiveder, mShowHeadDecoration;//
    protected RecyclerView mRecyclerView;
    protected int mHeadCount;
    protected int mFootCount;
    protected int mOrientation;


    protected RvItemDecoration(Context context) {
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

    protected int getItemCount() {
        if (mRecyclerView == null) return 0;
        if (mRecyclerView.getLayoutManager() == null) return 0;
        return mRecyclerView.getLayoutManager().getItemCount();
    }

    public static class Builder {

        private int bgColorId;
        private float widthDp = 1, startPaddingDp, endPaddingDp;
        private Context context;
        private boolean showLastDiveder, showFirstDivider, showLeft, showRight, showHeadDecoration;
        private int spanCount;
        private int headCount;
        private int footCount;
        private int orientation;

        public Builder(Context context) {
            this.context = context;
        }


        public Builder setOrientation(@LinearDecoration.OrientationMode int orientation) {
            if (orientation != this.orientation) {
                this.orientation = orientation;
            }
            return this;
        }

        public RvItemDecoration.Builder footCount(int footCount) {
            this.footCount = footCount;
            return this;
        }

        public RvItemDecoration.Builder headCount(int headCount) {
            this.headCount = headCount;
            return this;
        }

        public RvItemDecoration.Builder bgColor(int bgColorId) {
            this.bgColorId = bgColorId;
            return this;
        }

        public RvItemDecoration.Builder widthDp(float mWidthDp) {
            this.widthDp = mWidthDp;
            return this;
        }

        public RvItemDecoration.Builder startPaddingDp(float mStartPaddingDp) {
            this.startPaddingDp = mStartPaddingDp;
            return this;
        }

        public RvItemDecoration.Builder endPaddingDp(float mEndPaddingDp) {
            this.endPaddingDp = mEndPaddingDp;
            return this;
        }

        public RvItemDecoration.Builder showLastDiveder(boolean showLastDiveder) {
            this.showLastDiveder = showLastDiveder;
            return this;
        }

        public RvItemDecoration.Builder showFirstDivider(boolean show) {
            this.showFirstDivider = show;
            return this;
        }

        public RvItemDecoration.Builder showLeft(boolean show) {
            this.showLeft = show;
            return this;
        }

        public RvItemDecoration.Builder showRight(boolean show) {
            this.showRight = show;
            return this;
        }

        public RvItemDecoration.Builder showHeadDecoration(boolean show) {
            this.showHeadDecoration = show;
            return this;
        }

        public RvItemDecoration.Builder spanCount(int spanCount) {
            this.spanCount = spanCount;
            return this;
        }

        public RvItemDecoration createLinear() {
            LinearDecoration decoration = new LinearDecoration(context);
            decoration.mBgColoerId = bgColorId;
            decoration.mWidthDp = widthDp;
            decoration.mShowLastDiveder = showLastDiveder;
            decoration.mShowFirstDiveder = showFirstDivider;
            decoration.mStartPaddingDp = startPaddingDp;
            decoration.mEndPaddingDp = endPaddingDp;
            decoration.mOrientation = orientation;
            decoration.mShowLeft = showLeft;
            decoration.mShowRight = showRight;
            decoration.mHeadCount = headCount;
            decoration.mShowHeadDecoration = showHeadDecoration;
            return decoration;
        }

        /**
         * 创建间隙均匀的格子列表.
         *
         * @return
         */
        public RvItemDecoration createGrid() {
            GridDecoration decoration = new GridDecoration(context);
            decoration.mBgColoerId = bgColorId;
            decoration.mWidthDp = widthDp;
            decoration.mSpanCount = spanCount;
            return decoration;
        }

        public RvItemDecoration createHeadGrid() {
            HeadGridDecoration decoration = new HeadGridDecoration(context);
            decoration.mBgColoerId = bgColorId;
            decoration.mWidthDp = widthDp;
            decoration.mSpanCount = spanCount;
            decoration.mHeadCount = headCount;
            return decoration;
        }

        //FootGridDecoration
        public RvItemDecoration createFootGrid() {
            FootGridDecoration decoration = new FootGridDecoration(context);
            decoration.mBgColoerId = bgColorId;
            decoration.mWidthDp = widthDp;
            decoration.mSpanCount = spanCount;
            decoration.mHeadCount = headCount;
            decoration.mFootCount = footCount;
            return decoration;
        }

        //HFGridDecoration
        public RvItemDecoration createHeadFootGrid() {
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
        public RvItemDecoration createMultipleGrid() {
            MultipleGridDecoration divider = new MultipleGridDecoration(context);
            divider.mBgColoerId = bgColorId;
            divider.mWidthDp = widthDp;
            divider.mSpanCount = spanCount;
            divider.mHeadCount = headCount;
            return divider;
        }

        /**
         * 创建只有中间间隙的格子列表,无头无脚,不好用.
         *
         * @return
         */
        public RvItemDecoration createCenterGrid() {
            CenterGridDecoration decoration = new CenterGridDecoration(context);
            decoration.mBgColoerId = bgColorId;
            decoration.mWidthDp = widthDp;
            decoration.mSpanCount = spanCount;
            return decoration;
        }

    }

}
