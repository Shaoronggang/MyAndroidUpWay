package com.example.myandroidupway.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Scroller;

import androidx.annotation.Nullable;

public class CustomView extends LinearLayout {

    private Scroller mScroller;
    private int lastX;
    private int lastY;

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mScroller = new Scroller(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    /**
     * 在这个方法中获取触摸点的坐标
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 获取手指触摸点的横坐标和纵坐标
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
//              计算移动的距离
                int offSetX = x - lastX;
                int offSetY = y - lastY;

//             方法一: 调用layout方法来重新放置它的位置，依据，
//             绘制View的时候会调用onLayout方法来设置显示的位置，
//             因此可以通过修改View的left、top、right、bottom这4种属性来控制View的坐标
//                layout(getLeft()+ offSetX,getTop() + offSetY,getRight() + offSetX,getBottom() + offSetY);

//                或者使用方法二 offSetLeftAndRight()与 offSetTopAndBottom()
                offsetLeftAndRight(offSetX);
                offsetTopAndBottom(offSetY);


                break;
        }

        return true;
    }

    /**
     * 系统会在绘制View的时候在draw方法中调用该方法，
     * 在这个方法调用父类的scrollTo方法并通过Scroller来不断获取当前的滑动值
     * 每滑动一小段距离，再调用invalidate方法不断重绘
     */
    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()) {
            ((View) getParent()).scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            invalidate();
        }
    }

    public void smoothScrollTo(int destX, int destY) {
        int scrollX = getScrollX();
        int delta = destX - scrollX;
        mScroller.startScroll(scrollX, 0, delta, 0, 2000);
        invalidate();
    }


}
