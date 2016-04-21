package com.cyj.animation.anim_menu;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import com.cyj.animation.R;

public class AnimMenuActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mMenu1;
    private ImageView mMenu2;
    private ImageView mMenu3;
    private ImageView mMenu4;
    private ImageView mMenu;

    private boolean mFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_menu);

        mMenu = (ImageView) findViewById(R.id.menu_main);
        mMenu1 = (ImageView) findViewById(R.id.menu_01);
        mMenu2 = (ImageView) findViewById(R.id.menu_02);
        mMenu3 = (ImageView) findViewById(R.id.menu_03);
        mMenu4 = (ImageView) findViewById(R.id.menu_04);

        mMenu.setOnClickListener(this);
        mMenu1.setOnClickListener(this);
        mMenu2.setOnClickListener(this);
        mMenu3.setOnClickListener(this);
        mMenu4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.menu_main:
                if (mFlag){
                    closeMenu();
                } else{
                    openMenu();
                }
                break;

            default:
                Toast.makeText(this, "Menu Click", Toast.LENGTH_LONG);
                break;
        }
    }

    private void openMenu(){
        ObjectAnimator objMain = ObjectAnimator.ofFloat(
                mMenu,
                "alpha",
                1f,
                0.5f);

        ObjectAnimator obj1 = ObjectAnimator.ofFloat(
                mMenu1,
                "translationY",
                200F);

        ObjectAnimator obj2 = ObjectAnimator.ofFloat(
                mMenu2,
                "translationX",
                200F);

        ObjectAnimator obj3 = ObjectAnimator.ofFloat(
                mMenu3,
                "translationY",
                -200F);

        ObjectAnimator obj4 = ObjectAnimator.ofFloat(
                mMenu4,
                "translationX",
                -200F);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(500);
        set.setInterpolator(new BounceInterpolator());
        set.playTogether(objMain, obj1, obj2, obj3, obj4);
        set.start();
        mFlag = true;
    }

    private void closeMenu(){
        ObjectAnimator objMain = ObjectAnimator.ofFloat(
                mMenu,
                "alpha",
                0.5f,
                1f);

        ObjectAnimator obj1 = ObjectAnimator.ofFloat(
                mMenu1,
                "translationY",
                200F,
                0F);

        ObjectAnimator obj2 = ObjectAnimator.ofFloat(
                mMenu2,
                "translationX",
                200F,
                0F);

        ObjectAnimator obj3 = ObjectAnimator.ofFloat(
                mMenu3,
                "translationY",
                -200F,
                0F);

        ObjectAnimator obj4 = ObjectAnimator.ofFloat(
                mMenu4,
                "translationX",
                -200F,
                0F);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(500);
        set.setInterpolator(new BounceInterpolator());
        set.playTogether(objMain, obj1, obj2, obj3, obj4);
        set.start();
        mFlag = false;
    }
}
