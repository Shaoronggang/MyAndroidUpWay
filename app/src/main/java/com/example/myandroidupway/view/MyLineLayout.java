package com.example.myandroidupway.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

/**
 * @author shaoronggang
 * 创建日期：2020/4/30
 * 描述：我的自定义View水平布局
 * 修改：
 */
public class MyLineLayout extends LinearLayout {
    public MyLineLayout(Context context) {
        super(context);
    }

    public MyLineLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLineLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
