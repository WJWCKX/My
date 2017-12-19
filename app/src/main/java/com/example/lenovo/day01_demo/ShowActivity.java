package com.example.lenovo.day01_demo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.lenovo.day01_demo.adapter.MyAdapter;
import com.example.lenovo.day01_demo.bean.MyData;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ShowActivity extends AppCompatActivity {

    private Intent intent;
    private MyAdapter myAdapter;
    private RecyclerView recycler;
    private String url = "http://192.168.43.224/zuoye/data.txt";
    private List<MyData.InfoListBean> mList;
    private Handler mHandler = new Handler() {


        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            String obj = (String) msg.obj;

            Gson gson = new Gson();
            MyData myData = gson.fromJson(obj, MyData.class);
            mList = myData.getInfoList();

            myAdapter = new MyAdapter(mList, ShowActivity.this);
            LinearLayoutManager manager = new LinearLayoutManager(ShowActivity.this, LinearLayoutManager.VERTICAL, false);
            recycler.setLayoutManager(manager);
            recycler.setAdapter(myAdapter);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        initView();
        initInfo();

    }


    private void initInfo() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Request build = new Request.Builder().url(url).build();
                client.newCall(build).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        mHandler.obtainMessage(12, response.body().string()).sendToTarget();
                    }
                });
            }
        }).start();

    }

    private void initView() {
        recycler = (RecyclerView) findViewById(R.id.recycler);
    }
}
