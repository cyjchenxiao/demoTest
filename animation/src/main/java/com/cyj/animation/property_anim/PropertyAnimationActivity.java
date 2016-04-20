package com.cyj.animation.property_anim;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cyj.animation.R;
import com.cyj.animation.property_anim.obj_wrapper_view.WrapperView;

public class PropertyAnimationActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnObjAnimTranslation;
    private Button mBtnObjWrapperAnimator;
    private Button mBtnPropertyValueHolder;
    private Button mBtnValueAnimator;
    private Button mBtnAnimatorSet;
    private Button mBtnAnimatorXML;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obj_animation);

        mBtnObjAnimTranslation = (Button) findViewById(R.id.btn_objanim_translation);
        mBtnObjAnimTranslation.setOnClickListener(this);

        mBtnObjWrapperAnimator = (Button) findViewById(R.id.btn_obj_wrapper);
        mBtnObjWrapperAnimator.setOnClickListener(this);

        mBtnPropertyValueHolder = (Button) findViewById(R.id.btn_property_value_holder);
        mBtnPropertyValueHolder.setOnClickListener(this);

        mBtnValueAnimator = (Button) findViewById(R.id.btn_value_animator);
        mBtnValueAnimator.setOnClickListener(this);

        mBtnAnimatorSet = (Button) findViewById(R.id.btn_animatorSet);
        mBtnAnimatorSet.setOnClickListener(this);

        mBtnAnimatorXML = (Button) findViewById(R.id.btn_animator_xml);
        mBtnAnimatorXML.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_objanim_translation:
                ObjectAnimator objAnim = ObjectAnimator.ofFloat(
                        mBtnObjAnimTranslation,
                        "translationX",
                        300);
                objAnim.setDuration(1500);
                objAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        Float value = (Float) animation.getAnimatedValue();
                        Log.d("VALUE_ANIMATOR", ">>>>> animation.getAnimatedValue: " + value);
                    }
                });
                objAnim.start();
                break;
            case R.id.btn_obj_wrapper:
                WrapperView wrapperView = new WrapperView(mBtnObjWrapperAnimator);
                ObjectAnimator.ofInt(wrapperView, "width", 200).setDuration(3000).start();
                break;

            case R.id.btn_property_value_holder:
                PropertyValuesHolder pvh1 = PropertyValuesHolder.ofFloat("translationX", 300f);
                PropertyValuesHolder pvh2 = PropertyValuesHolder.ofFloat("scaleX", 1f, 0, 1f);
                PropertyValuesHolder pvh3 = PropertyValuesHolder.ofFloat("scaleY", 1f, 0, 1f);
                ObjectAnimator objAnim2 = ObjectAnimator.ofPropertyValuesHolder(mBtnPropertyValueHolder, pvh1, pvh2, pvh3);
                objAnim2.setDuration(1500);
                objAnim2.start();
                break;

            case R.id.btn_value_animator:
                ValueAnimator valueAnim = ValueAnimator.ofFloat(0, 200);
                valueAnim.setTarget(mBtnValueAnimator);
                valueAnim.setDuration(1500);
                valueAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        Float value = (Float) animation.getAnimatedValue();
                        Log.d("VALUE_ANIMATOR", ">>>>> animation.getAnimatedValue: " + value);
                    }
                });
                break;

            case R.id.btn_animatorSet:
                ObjectAnimator objAnim1 = ObjectAnimator.ofFloat(mBtnAnimatorSet, "translationX", 300f);
                ObjectAnimator objAnim3 = ObjectAnimator.ofFloat(mBtnAnimatorSet, "alpha", 0f, 1f);
                ObjectAnimator objAnim4 = ObjectAnimator.ofFloat(mBtnAnimatorSet, "translationX", 0f);

                AnimatorSet set = new AnimatorSet();
                set.setDuration(2000);
                set.playTogether(objAnim1, objAnim3);
                set.play(objAnim4).after(objAnim1);
                set.start();
                break;

            case R.id.btn_animator_xml:
                Animator animator = AnimatorInflater.loadAnimator(this, R.animator.obj_animator_test);
                animator.setTarget(mBtnAnimatorXML);
                animator.start();
                break;
        }
    }
}
