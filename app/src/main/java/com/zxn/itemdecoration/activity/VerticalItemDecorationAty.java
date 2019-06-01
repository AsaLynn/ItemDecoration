package com.zxn.itemdecoration.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zxn.divider.LinearDecoration;
import com.zxn.divider.RvItemDecoration;
import com.zxn.itemdecoration.R;
import com.zxn.itemdecoration.adapter.VerticalAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zxn on 2018-11-24 18:31:39.
 */
public class VerticalItemDecorationAty extends AppCompatActivity {

    @BindView(R.id.rv)
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_item_decoration_aty);
        ButterKnife.bind(this);

        rv.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv.setLayoutManager(layoutManager);
        //rv.addItemDecoration(new VerticalDivider(this));
        rv.addItemDecoration(new RvItemDecoration.Builder(this)
                .showLastDiveder(true)
                .showFirstDivider(true)
                .bgColor(R.color.colorPrimary)
                .setOrientation(LinearDecoration.HORIZONTAL)
                .createLinear());
        VerticalAdapter verticalAdapter = new VerticalAdapter();
        ArrayList<String> data = new ArrayList<>();
        data.add("https://3am-image.superwie.com/n_btc_a.png");
        data.add("https://3am-image.superwie.com/new_eth.png");
        data.add("https://3am-image.superwie.com/1541756727_3589446811.jpg");
        data.add("https://3am-image.superwie.com/18466_1538136317_8631181207.jpg");
        verticalAdapter.setNewData(data);
        rv.setAdapter(verticalAdapter);
    }
}
