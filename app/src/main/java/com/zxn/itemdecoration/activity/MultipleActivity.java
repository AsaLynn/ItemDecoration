package com.zxn.itemdecoration.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zxn.divider.RvItemDecoration;
import com.zxn.itemdecoration.R;
import com.zxn.itemdecoration.adapter.MultipleAdapter;
import com.zxn.itemdecoration.entity.BasePageInfo;
import com.zxn.itemdecoration.entity.ResultEntity;
import com.zxn.itemdecoration.entity.SearchEntity;
import com.zxn.itemdecoration.entity.TableInfo;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by zxn on 2019-1-27 10:17:33.
 */
public class MultipleActivity extends AppCompatActivity {

    private static final String ARG_PARAM1 = "param1";
    @BindView(R.id.rv_skills)
    RecyclerView rvSkills;
    private String mParam1;
    private MultipleAdapter adapter;
    private String result = "{\"code\":\"SUCCESS\",\"msg\":\"查询成功\",\"result\":[{\"id\":480,\"appId\":\"EW_N6933871347\",\"merchantCode\":\"EW_N2420475438\",\"regionId\":134,\"tableName\":\"A010\",\"tableNum\":6,\"tableStatus\":0,\"createTime\":\"2019-07-05 13:37:13\",\"updateTime\":\"2019-07-05 13:37:13\"},{\"id\":479,\"appId\":\"EW_N6933871347\",\"merchantCode\":\"EW_N2420475438\",\"regionId\":134,\"tableName\":\"A009\",\"tableNum\":6,\"tableStatus\":0,\"createTime\":\"2019-07-05 13:37:13\",\"updateTime\":\"2019-07-05 13:37:13\"},{\"id\":478,\"appId\":\"EW_N6933871347\",\"merchantCode\":\"EW_N2420475438\",\"regionId\":134,\"tableName\":\"A008\",\"tableNum\":6,\"tableStatus\":0,\"createTime\":\"2019-07-05 13:37:13\",\"updateTime\":\"2019-07-05 13:37:13\"},{\"id\":477,\"appId\":\"EW_N6933871347\",\"merchantCode\":\"EW_N2420475438\",\"regionId\":134,\"tableName\":\"A007\",\"tableNum\":6,\"tableStatus\":0,\"createTime\":\"2019-07-05 13:37:13\",\"updateTime\":\"2019-07-05 13:37:13\"},{\"id\":476,\"appId\":\"EW_N6933871347\",\"merchantCode\":\"EW_N2420475438\",\"regionId\":134,\"tableName\":\"A006\",\"tableNum\":6,\"tableStatus\":0,\"createTime\":\"2019-07-05 13:37:13\",\"updateTime\":\"2019-07-05 13:37:13\"},{\"id\":475,\"appId\":\"EW_N6933871347\",\"merchantCode\":\"EW_N2420475438\",\"regionId\":134,\"tableName\":\"A005\",\"tableNum\":6,\"tableStatus\":0,\"createTime\":\"2019-07-05 13:37:13\",\"updateTime\":\"2019-07-05 13:37:13\"},{\"id\":474,\"appId\":\"EW_N6933871347\",\"merchantCode\":\"EW_N2420475438\",\"regionId\":134,\"tableName\":\"A004\",\"tableNum\":6,\"tableStatus\":0,\"createTime\":\"2019-07-05 13:37:13\",\"updateTime\":\"2019-07-05 13:37:13\"},{\"id\":473,\"appId\":\"EW_N6933871347\",\"merchantCode\":\"EW_N2420475438\",\"regionId\":134,\"tableName\":\"A003\",\"tableNum\":6,\"tableStatus\":0,\"createTime\":\"2019-07-05 13:37:13\",\"updateTime\":\"2019-07-05 13:37:13\"},{\"id\":472,\"appId\":\"EW_N6933871347\",\"merchantCode\":\"EW_N2420475438\",\"regionId\":134,\"tableName\":\"A002\",\"tableNum\":6,\"tableStatus\":0,\"createTime\":\"2019-07-05 13:37:13\",\"updateTime\":\"2019-07-05 13:37:13\"},{\"id\":471,\"appId\":\"EW_N6933871347\",\"merchantCode\":\"EW_N2420475438\",\"regionId\":134,\"tableName\":\"A001\",\"tableNum\":6,\"tableStatus\":0,\"createTime\":\"2019-07-05 13:37:13\",\"updateTime\":\"2019-07-05 13:37:13\"}]}";

    public static void jumpTo(Context context, String param1) {
        Intent intent = new Intent(context, MultipleActivity.class);
        intent.putExtra(ARG_PARAM1, param1);
        context.startActivity(intent);
    }

    public static void jumpTo(Context context) {
        Intent intent = new Intent(context, MultipleActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple);
        ButterKnife.bind(this);
        mParam1 = getIntent().getStringExtra(ARG_PARAM1);

        rvSkills.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        rvSkills.setLayoutManager(layoutManager);
        adapter = new MultipleAdapter();
        rvSkills.setAdapter(adapter);
        RvItemDecoration divider = new RvItemDecoration.Builder(this)
                .bgColor(R.color.c_ffffff)
                .spanCount(layoutManager.getSpanCount())
                .widthDp(5)
                .createGrid();
        rvSkills.addItemDecoration(divider);

//        http();
//        String result = response.body().string();
        Type type = new TypeToken<BasePageInfo<TableInfo>>() {
        }.getType();
        final BasePageInfo<TableInfo> entity = new Gson().fromJson(result, type);
        adapter.setNewData(entity.result);

    }

    private void http() {
//        OkHttpClient client = new OkHttpClient.Builder()
//                .build();
//        Request request = new Request.Builder()
//                .get()
//                .url("http://api.wdy330.com/guns-rest-0.0.1-SNAPSHOT/skills/list")
//                .build();
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                String result = response.body().string();
//                Type type = new TypeToken<ResultEntity<List<SearchEntity>>>() {
//                }.getType();
//                final ResultEntity<List<SearchEntity>> entity = new Gson().fromJson(result, type);
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        adapter.setNewData(entity.result);
//                    }
//                });
//
//            }
//        });
    }
}
