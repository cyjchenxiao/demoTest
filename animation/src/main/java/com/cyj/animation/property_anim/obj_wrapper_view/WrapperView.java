package com.cyj.animation.property_anim.obj_wrapper_view;

import android.view.View;
import android.widget.Button;

/**
 * Created by cyj on 16/4/13.
 */
public class WrapperView {

    private Button mTarget;

    public WrapperView(Button v){
        mTarget = v;
    }

    public int getWidth(){
        return mTarget.getLayoutParams().width;
    }

    public void setWidth(int width){
        mTarget.getLayoutParams().width = width;
        mTarget.requestLayout();
    }
}
