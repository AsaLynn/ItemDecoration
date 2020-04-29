package com.yanyusong.divideritemdecoration;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

//import androidx.appcompat.app.AppCompatActivity;
import com.zxn.itemdecoration.R;

public class MainOldActivity extends AppCompatActivity implements View.OnClickListener {

    public static void jumpTo(Context context) {
        Intent intent = new Intent(context, MainOldActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_old);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                startActivity(new Intent(MainOldActivity.this, LinearLayoutManagerActivity.class));
                break;
            case R.id.button2:
                startActivity(new Intent(MainOldActivity.this, GridLayoutManagerActivity.class));
                break;
            case R.id.button3:
                startActivity(new Intent(MainOldActivity.this, GridLayoutManager1Activity.class));
                break;
            case R.id.button4:
                startActivity(new Intent(MainOldActivity.this, GridLayoutManager2Activity.class));
                break;
            default:
                break;
        }

    }
}
