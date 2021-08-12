package com.example.myandroidupway.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayoutRes());
        ButterKnife.bind(this);
        initView();
        initData();
    }

    public abstract void initView();
    public abstract void initData();

    public abstract int initLayoutRes();
}
