package com.cyj.animation.custom_anim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.cyj.animation.R;

public class CustomAnimActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_animation);
    }

    public void onCustomTV(View view){
        CustomTvAnim tvAnim = new CustomTvAnim();
        view.startAnimation(tvAnim);
    }

    public void onCustomCamera(View view){
        CustomAnim cusAnim = new CustomAnim();
        cusAnim.setRotateY(30f);
        view.startAnimation(cusAnim);
    }
}
