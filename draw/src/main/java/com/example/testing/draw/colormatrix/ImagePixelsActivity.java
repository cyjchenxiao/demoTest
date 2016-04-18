package com.example.testing.draw.colormatrix;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.testing.draw.R;

public class ImagePixelsActivity extends AppCompatActivity {

    private ImageView mImageView;
    private Bitmap mBmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_pixels);

        mBmp = BitmapFactory.decodeResource(getResources(), R.drawable.img_pixels_test);
        mImageView = (ImageView) findViewById(R.id.img_pixels);
        mImageView.setImageBitmap(mBmp);

    }

    public void btnNegative(View view){
        mImageView.setImageBitmap(ImageHelper.handleImageNegative(mBmp));
    }

    public void btnOldPhoto(View view){
        mImageView.setImageBitmap(ImageHelper.handleImageOldEffect(mBmp));
    }

    public void btnRelief(View view){
        mImageView.setImageBitmap(ImageHelper.handleImagePixelsRelief(mBmp));
    }
}
