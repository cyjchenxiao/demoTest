package com.cyj.animation.view_anim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import com.cyj.animation.R;

public class ViewAnimActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mAlphaBtn, mRotateBtn;
    private Button mRotateSelfBtn;
    private Button mTranstateBtn;
    private Button mScaleBtn, mScaleSelfBtn;
    private Button mAnimaSetBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_anim);

        mAlphaBtn = (Button) findViewById(R.id.btn_alpha);
        mRotateBtn = (Button) findViewById(R.id.btn_rotate);
        mRotateSelfBtn = (Button) findViewById(R.id.btn_rotateself);
        mTranstateBtn = (Button) findViewById(R.id.btn_transtate);
        mScaleBtn = (Button) findViewById(R.id.btn_scale);
        mScaleSelfBtn = (Button) findViewById(R.id.btn_scaleself);
        mAnimaSetBtn = (Button) findViewById(R.id.btn_animset);

        mAlphaBtn.setOnClickListener(this);
        mRotateBtn.setOnClickListener(this);
        mRotateSelfBtn.setOnClickListener(this);
        mTranstateBtn.setOnClickListener(this);
        mScaleSelfBtn.setOnClickListener(this);
        mScaleBtn.setOnClickListener(this);
        mAnimaSetBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_alpha:
                AlphaAnimation alphaAnim = new AlphaAnimation(1.0f, 0.0f);
                alphaAnim.setDuration(1500);
                mAlphaBtn.startAnimation(alphaAnim);
                break;
            case R.id.btn_rotate:
                RotateAnimation rotateAnimation = new RotateAnimation(0, 360, 100, 100);
                rotateAnimation.setDuration(1500);
                mRotateBtn.startAnimation(rotateAnimation);
                break;
            case R.id.btn_rotateself:
                RotateAnimation rotateSelfAnimation = new RotateAnimation(0, 360,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                rotateSelfAnimation.setDuration(1500);
                mRotateSelfBtn.startAnimation(rotateSelfAnimation);
                break;
            case R.id.btn_transtate:
                TranslateAnimation translateAnimation = new TranslateAnimation(0, 200, 0, 300);
                translateAnimation.setDuration(1500);
                mTranstateBtn.startAnimation(translateAnimation);
                break;
            case R.id.btn_scale:
                ScaleAnimation scaleAnimation = new ScaleAnimation(0, 2, 0, 2);
                scaleAnimation.setDuration(1500);
                mScaleBtn.startAnimation(scaleAnimation);
                break;
            case R.id.btn_scaleself:
                ScaleAnimation scaleSelfAnimation = new ScaleAnimation(0,2,0,1,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
                scaleSelfAnimation.setDuration(1500);
                mScaleSelfBtn.startAnimation(scaleSelfAnimation);
                break;
            case R.id.btn_animset:
                AnimationSet animSet = new AnimationSet(true);
                animSet.setDuration(1500);

                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(1500);
                animSet.addAnimation(alphaAnimation);

                TranslateAnimation translateAnimation1 = new TranslateAnimation(0,100,0,200);
                translateAnimation1.setDuration(1500);
                animSet.addAnimation(translateAnimation1);

                mAnimaSetBtn.startAnimation(animSet);

                break;
        }
    }
}
