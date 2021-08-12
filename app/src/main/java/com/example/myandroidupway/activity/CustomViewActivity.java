package com.example.myandroidupway.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myandroidupway.R;
import com.example.myandroidupway.base.BaseActivity;
import com.example.myandroidupway.view.CustomView;

import butterknife.BindView;

public class CustomViewActivity extends BaseActivity {
    @BindView(R.id.custom_view)
    CustomView customView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public int initLayoutRes() {
        return R.layout.activity_custom_view;
    }
}