package com.demo.cyj.scroller.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

/**
 * Author: ChenYJ
 * Date: 2016/3/10 16:07
 * Email:cyjchenxiao@163.com
 */
public class CustomDragView extends View implements View.OnTouchListener{
    private int mLastX;
    private int mLastY;

    private Scroller mScroller;

    public CustomDragView(Context context) {
        super(context);
        init(context);
    }

    public CustomDragView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomDragView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setOnTouchListener(this);
        mScroller = new Scroller(context);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                mLastX = x;
                mLastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                //计算偏移量
                int offsetX = x-mLastX;
                int offsetY = y-mLastY;
                //在当前left top right bottom的基础上加上偏移量


//                offsetLeftAndRight(offsetX);
//                offsetTopAndBottom(offsetY);

//                layout(getLeft()+offsetX,
//                        getTop()+offsetY,
//                        getRight()+offsetX,
//                        getBottom()+offsetY);

                ((View)getParent()).scrollBy(-offsetX, -offsetY);

                break;
            case MotionEvent.ACTION_UP:
                View viewGroup = (View) getParent();
                mScroller.startScroll(viewGroup.getScrollX(),
                        viewGroup.getScrollY(),
                        -viewGroup.getScrollX(),
                        -viewGroup.getScrollY(), 500);
                invalidate();
                break;
        }
        return true;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();

        if (mScroller.computeScrollOffset()){
            ((View)getParent()).scrollTo(
                    mScroller.getCurrX(),
                    mScroller.getCurrY());

            invalidate();
        }
    }
}
