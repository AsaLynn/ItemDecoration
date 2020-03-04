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

public class GridThreeActivity extends AppCompatActivity {

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
        rv.setLayoutManager(new GridLayoutManager(mContext, 3));
        rv.setHasFixedSize(true);
        rv.addItemDecoration(new RvItemDecoration.Builder(mContext)
                .bgColor(R.color.c_ffffff)
                .widthDp(20f)
                .spanCount(3)
                .createCenterGrid());
        GridFileAdapter mAdapter = new GridFileAdapter();
        rv.setAdapter(mAdapter);

        ArrayList<BaseInfo> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            BaseInfo baseInfo = new BaseInfo();
            data.add(baseInfo);
        }
        mAdapter.setNewData(data);
    }
}
