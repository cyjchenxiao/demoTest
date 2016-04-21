package com.cyj.animation.anim_menu;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cyj.animation.R;

public class AnimTimerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_timer);

    }

    public void onStartTimer(final View view){
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 100);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                ((TextView)view).setText("$" + (Integer) animation.getAnimatedValue());
            }
        });

        valueAnimator.setDuration(3000);
        valueAnimator.start();
    }
}
