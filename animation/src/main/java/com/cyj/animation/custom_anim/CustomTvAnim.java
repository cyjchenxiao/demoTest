package com.cyj.animation.custom_anim;

import android.graphics.Matrix;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by cyj on 16/4/20.
 */
public class CustomTvAnim extends Animation{

    private int mCenterWidth;
    private int mCenterHeight;

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        setDuration(100);
        //设置动画结束后保留状态
        setFillAfter(true);
        //设置默认Interpolators
        setInterpolator(new AccelerateInterpolator());
        mCenterWidth = width / 2;
        mCenterHeight = height/2;

    }


    /**
     *
     * @param interpolatedTime Interpolators的时间因子
     * @param t Transformation - Matrix封装类
     */
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        final Matrix matrix = t.getMatrix();
        //电视机关闭动画
        matrix.preScale(1,
                1-interpolatedTime,
                mCenterWidth,
                mCenterHeight);
    }
}
