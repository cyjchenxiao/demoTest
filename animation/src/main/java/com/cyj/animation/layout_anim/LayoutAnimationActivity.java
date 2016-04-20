package com.cyj.animation.layout_anim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;

import com.cyj.animation.R;

public class LayoutAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_animation);

        LinearLayout viewGroup = (LinearLayout) findViewById(R.id.layout_animation_viewgroup);
        //设置过度动画
        ScaleAnimation sa = new ScaleAnimation(0,1,0,1);
        sa.setDuration(500);

        //设置布局动画的显示属性
        LayoutAnimationController lac = new LayoutAnimationController(sa, 0.5f);
        lac.setOrder(LayoutAnimationController.ORDER_NORMAL);
        //为ViewGroup设置布局动画
        viewGroup.setLayoutAnimation(lac);
    }
}
