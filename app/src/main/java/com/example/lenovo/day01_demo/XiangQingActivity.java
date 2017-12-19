package com.example.lenovo.day01_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class XiangQingActivity extends AppCompatActivity {

    private ImageView img;
    private TextView name;
    private TextView integral;
    private TextView likes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang_qing);
        initView();

        Intent intent = getIntent();
        String nameValue = intent.getStringExtra("name");
        String integralValue = intent.getStringExtra("integral");
        String likesValue = intent.getStringExtra("likes");
        String imgValue = intent.getStringExtra("img");

        name.setText(nameValue);
        integral.setText(integralValue);
        likes.setText(likesValue);
        name.setText(nameValue);
        Glide.with(XiangQingActivity.this).load(imgValue).into(img);
    }

    private void initView() {
        img = (ImageView) findViewById(R.id.img);
        name = (TextView) findViewById(R.id.name);
        integral = (TextView) findViewById(R.id.integral);
        likes = (TextView) findViewById(R.id.likes);
    }
}
