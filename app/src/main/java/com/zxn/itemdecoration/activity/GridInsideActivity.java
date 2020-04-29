package com.zxn.itemdecoration.activity;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zxn.divider.LinearDecoration;
import com.zxn.divider.RvItemDecoration;
import com.zxn.itemdecoration.R;
import com.zxn.itemdecoration.adapter.GridFileAdapter;
import com.zxn.itemdecoration.entity.BaseInfo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 * Updated by zxn on 2020/4/29.
 */
public class GridInsideActivity extends AppCompatActivity {

    @BindView(R.id.rv)
    RecyclerView rv;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_three);
        ButterKnife.bind(this);
        mContext = this;
        onInitRecyclerView();
    }

    private void onInitRecyclerView() {
        GridLayoutManager manager = new GridLayoutManager(mContext, 4);
        rv.setLayoutManager(manager);
        rv.setHasFixedSize(true);
        rv.addItemDecoration(new RvItemDecoration.Builder(mContext)
                .bgColor(R.color.c_ffffff)
                .widthDp(10f)
                .spanCount(manager.getSpanCount())
                .createCenterGrid());
        GridFileAdapter mAdapter = new GridFileAdapter();
        rv.setAdapter(mAdapter);

        ArrayList<BaseInfo> data = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            BaseInfo baseInfo = new BaseInfo();
            data.add(baseInfo);
        }
        mAdapter.setNewData(data);
    }
}
