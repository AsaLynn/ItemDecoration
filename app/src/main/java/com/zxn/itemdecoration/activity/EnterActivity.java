package com.zxn.itemdecoration.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.yanyusong.divideritemdecoration.MainOldActivity;
import com.zxn.itemdecoration.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class EnterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_old, R.id.btn_new})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_old:
                MainOldActivity.jumpTo(this);
                break;
            case R.id.btn_new:
                MainActivity.jumpTo(this);
                break;
        }
    }
}
