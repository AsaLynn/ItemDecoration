package com.zxn.itemdecoration.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zxn.itemdecoration.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zxn on 2018-11-24 18:04:56.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_horizontal_line, R.id.btn_vertical_line, R.id.btn_grid_line})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_horizontal_line:
                startActivity(new Intent(this, HorizontalItemDecorationAty.class));
                break;
            case R.id.btn_vertical_line:
                startActivity(new Intent(this, VerticalItemDecorationAty.class));
                break;
            case R.id.btn_grid_line:
                startActivity(new Intent(this, MultipleActivity.class));
                break;
            case R.id.btn_grid_head_line:
                //startActivity(new Intent(this, MultipleActivity.class));
                break;
        }
    }
}
