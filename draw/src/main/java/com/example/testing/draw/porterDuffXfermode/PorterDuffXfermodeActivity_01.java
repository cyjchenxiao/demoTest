package com.example.testing.draw.porterDuffXfermode;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.testing.draw.R;
import com.example.testing.draw.colormatrix.ImageHelper;

public class PorterDuffXfermodeActivity_01 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_porter_duff_xfermode_activity_01);

        ImageView img = (ImageView) findViewById(R.id.porterduffx_img);
        img.setImageBitmap(ImageHelper.handleBitmapPorterDuffX_01(BitmapFactory.decodeResource(getResources(), R.drawable.color_matrix_test)));
    }
}
