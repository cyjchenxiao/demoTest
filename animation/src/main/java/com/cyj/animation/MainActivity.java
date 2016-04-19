package com.cyj.animation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cyj.animation.property_anim.PropertyAnimationActivity;
import com.cyj.animation.view_anim.ViewAnimActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_ViewAnimation = (Button) findViewById(R.id.btn_view_animation);
        btn_ViewAnimation.setOnClickListener(this);

        Button btn_PropertyAnimation = (Button) findViewById(R.id.btn_property_animation);
        btn_PropertyAnimation.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_view_animation:
                startActivity(new Intent(this, ViewAnimActivity.class));
                break;

            case R.id.btn_property_animation:
                startActivity(new Intent(this, PropertyAnimationActivity.class));
                break;
        }
    }
}
