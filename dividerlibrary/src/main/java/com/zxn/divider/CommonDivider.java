package com.zxn.divider;

import android.content.Context;
import android.graphics.Rect;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import com.yanyusong.y_divideritemdecoration.Y_Divider;
import com.yanyusong.y_divideritemdecoration.Y_DividerBuilder;

/**
 * 通用RecyclerView条目横线(纵向列表,单条目,底部横线)
 * 可设置线条宽度,颜色,距离左侧长度,距离右侧长度,控制最后的横线是否显示等等.
 * Created by zxn on 2018/10/29.
 */
@Deprecated
public class CommonDivider extends ItemDivider {

    private RecyclerView mRecyclerView;
    private int mBgTransparent;


    protected CommonDivider(Context context) {
        super(context);
        mBgColor = context.getResources()
                .getColor(R.color.c_f2f2f2);
    }

    protected CommonDivider(Context context, int bgColorId, float widthDp, float startPaddingDp, float endPaddingDp, boolean showLastDiveder, boolean showFirstDiveder) {
        super(context);
        mBgColor = context.getResources()
                .getColor(R.color.c_f2f2f2);

        if (bgColorId == 0) {
            bgColorId = R.color.c_f2f2f2;
        }
        mBgColor = context.getResources()
                .getColor(bgColorId);
        mBgTransparent = context.getResources()
                .getColor(android.R.color.transparent);
        mWidthDp = widthDp;
        mStartPaddingDp = startPaddingDp;
        mEndPaddingDp = endPaddingDp;
        mShowLastDiveder = showLastDiveder;
        mShowFirstDiveder = showFirstDiveder;
    }

    @Override
    public Y_Divider getDivider(int itemPosition) {
        int lastItemPosition = mRecyclerView.getAdapter().getItemCount() - 1;
        int bgColor = (itemPosition == lastItemPosition && !mShowLastDiveder) ? mBgTransparent : mBgColor;
        return new Y_DividerBuilder()
                .setBottomSideLine(true, bgColor, mWidthDp, mStartPaddingDp, mEndPaddingDp).create();
    }

    @Deprecated
    public static class Builder {
        private int bgColorId;
        private float widthDp = 1, startPaddingDp, endPaddingDp;
        private Context context;
        private boolean showLastDiveder;
        private boolean showFirstDiveder;

        public Builder(Context context) {
            this.context = context;
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

        public Builder showFirstDiveder(boolean showFirstDiveder) {
            this.showFirstDiveder = showFirstDiveder;
            return this;
        }

        public CommonDivider create() {
            return new CommonDivider(context, bgColorId, widthDp, startPaddingDp, endPaddingDp, showLastDiveder,showLastDiveder);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        mRecyclerView = parent;
        super.getItemOffsets(outRect, view, parent, state);
    }
}
