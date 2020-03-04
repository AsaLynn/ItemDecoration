package com.zxn.itemdecoration.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;

import com.zxn.divider.RvItemDecoration;
import com.zxn.itemdecoration.R;
import com.zxn.itemdecoration.adapter.HomeOptionsAdatper;
import com.zxn.itemdecoration.entity.HomeOptionsEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zxn on 2019-4-4 17:36:48.
 */
public class GridFootActivity extends AppCompatActivity {

    @BindView(R.id.rv_home_options)
    RecyclerView rvHomeOptions;
    private static final String ARG_PARAM1 = "param1";
    private String mParam1;

    public static void jumpTo(Context context, String param1) {
        Intent intent = new Intent(context, GridFootActivity.class);
        intent.putExtra(ARG_PARAM1, param1);
        context.startActivity(intent);
    }

    public static void jumpTo(Context context) {
        Intent intent = new Intent(context, GridFootActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_head);
        ButterKnife.bind(this);
        mParam1 = getIntent().getStringExtra(ARG_PARAM1);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 4);
        rvHomeOptions.setLayoutManager(layoutManager);
        rvHomeOptions.setHasFixedSize(true);
        rvHomeOptions.addItemDecoration(new RvItemDecoration.Builder(this)
                .spanCount(layoutManager.getSpanCount())
                .bgColor(R.color.colorAccent)
                .widthDp(1f)
                .footCount(1)
                .createFootGrid());
        HomeOptionsAdatper mAdapter = new HomeOptionsAdatper();
//        mAdapter.addHeaderView(LayoutInflater.from(this).inflate(R.layout.fragment_home_options_head, null));

        mAdapter.addFooterView(LayoutInflater.from(this).inflate(R.layout.holder_foot, null));

        List<HomeOptionsEntity> optionsInfoList
                = HomeOptionsEntity
                .create(0);
        mAdapter.setNewData(optionsInfoList);

        rvHomeOptions.setAdapter(mAdapter);

    }
}
