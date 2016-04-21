package com.cyj.animation.anim_menu;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cyj.animation.R;

public class AnimDropMenuActivity extends AppCompatActivity {

    private LinearLayout mHiddenView;
    private float mDensity;
    private int mHiddenViewMeasureHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_drop_menu);
        mHiddenView = (LinearLayout) findViewById(R.id.hidden_view);

        //get device's density
        mDensity = getResources().getDisplayMetrics().density;

        //get layout height
        mHiddenViewMeasureHeight = (int) (mDensity *
                getResources().getDimension(R.dimen.dimen_80dp) + 0.5);
    }

    public void onIIClick(View view){
        if (mHiddenView.getVisibility() == View.GONE){
            //open animation
            showAnim(mHiddenView);
        } else {
            //close
            hideAnim(mHiddenView);
        }
    }

    private ValueAnimator createDropAnimator(final View view, int start, int end) {
        ValueAnimator animator = ValueAnimator.ofInt(start, end);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) animation.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = value;
                view.setLayoutParams(layoutParams);
            }
        });
        return animator;
    }

    private void showAnim(final View view) {
        view.setVisibility(View.VISIBLE);
        ValueAnimator showAnim = createDropAnimator(view, 0, mHiddenViewMeasureHeight);
        showAnim.setDuration(1000);
        showAnim.start();
    }

    private void hideAnim(final View view) {
        int origHeight = view.getHeight();
        ValueAnimator animator = createDropAnimator(view, origHeight, 0);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                view.setVisibility(View.GONE);
            }
        });
        animator.setDuration(1000);
        animator.start();
    }
}
