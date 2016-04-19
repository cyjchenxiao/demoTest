package com.cyj.animation.property_anim;

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

public class PropertyAnimationActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mBtnObjAnimTranslation;
    private Button mBtnObjWrapperAnimator;
    private Button mBtnPropertyValueHolder;
    private Button mBtnValueAnimator;

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

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
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
        }
    }
}
