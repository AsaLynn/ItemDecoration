package com.zxn.itemdecoration.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zxn.itemdecoration.R;

/**
 * Created by zxn on 2019-1-27 11:21:49.
 */
public class GridItemDecorationAty extends AppCompatActivity {

    private static final String ARG_PARAM1 = "param1";
    private String mParam1;

    public static void jumpTo(Context context, String param1) {
        Intent intent = new Intent(context, GridItemDecorationAty.class);
        intent.putExtra(ARG_PARAM1, param1);
        context.startActivity(intent);
    }

    public static void jumpTo(Context context) {
        Intent intent = new Intent(context, GridItemDecorationAty.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_item_decoration_aty);
        mParam1 = getIntent().getStringExtra(ARG_PARAM1);
    }
}
