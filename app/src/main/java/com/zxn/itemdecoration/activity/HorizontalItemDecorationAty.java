package com.zxn.itemdecoration.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zxn.divider.CommonDivider;
import com.zxn.divider.ItemDivider;
import com.zxn.itemdecoration.R;
import com.zxn.itemdecoration.adapter.MyBaseQuickAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zxn on 2018-11-24 18:19:02.
 */
public class HorizontalItemDecorationAty extends AppCompatActivity {

    @BindView(R.id.rv)
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_item_decoration_aty);
        ButterKnife.bind(this);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new ItemDivider.Builder(this)
                .bgColor(R.color.colorPrimaryDark)
                .widthDp(20)
                .createCommon());
        MyBaseQuickAdapter adapter = new MyBaseQuickAdapter();
        rv.setAdapter(adapter);
        ArrayList<String> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add(getString(R.string.text_item) + i);
        }
        adapter.setNewData(data);
    }
}
