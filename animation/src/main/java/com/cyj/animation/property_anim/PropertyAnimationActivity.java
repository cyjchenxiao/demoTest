package com.cyj.animation.property_anim;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cyj.animation.R;
import com.cyj.animation.property_anim.obj_wrapper_view.WrapperView;

public class PropertyAnimationActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mBtnObjAnimTranslation;
    private Button mBtnObjWrapperAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obj_animation);

        mBtnObjAnimTranslation = (Button) findViewById(R.id.btn_objanim_translation);
        mBtnObjAnimTranslation.setOnClickListener(this);

        mBtnObjWrapperAnimator = (Button) findViewById(R.id.btn_obj_wrapper);
        mBtnObjWrapperAnimator.setOnClickListener(this);

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
                objAnim.start();
                break;
            case R.id.btn_obj_wrapper:
                WrapperView wrapperView = new WrapperView(mBtnObjWrapperAnimator);
                ObjectAnimator.ofInt(wrapperView, "width", 200).setDuration(3000).start();
                break;
        }
    }
}
