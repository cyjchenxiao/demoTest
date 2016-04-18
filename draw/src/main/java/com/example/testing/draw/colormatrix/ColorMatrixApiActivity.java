package com.example.testing.draw.colormatrix;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.example.testing.draw.R;

public class ColorMatrixApiActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{

    private static int MAX_VALUE = 255;
    private static int MID_VALUE = 127;
    private ImageView mImageView;
    private SeekBar mSeekbarhue, mSeekbarSaturation, mSeekbarLum;
    private float mHue, mSaturation, mLum;
    private Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_matrix);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.color_matrix_test);
        mImageView = (ImageView) findViewById(R.id.test_img);

        mSeekbarhue = (SeekBar) findViewById(R.id.seekbar_matrix_hue);
        mSeekbarSaturation = (SeekBar) findViewById(R.id.seekbar_matrix_saturation);
        mSeekbarLum = (SeekBar) findViewById(R.id.seekbar_matrix_lum);

        mSeekbarhue.setOnSeekBarChangeListener(this);
        mSeekbarSaturation.setOnSeekBarChangeListener(this);
        mSeekbarLum.setOnSeekBarChangeListener(this);

        mSeekbarhue.setMax(MAX_VALUE);
        mSeekbarSaturation.setMax(MAX_VALUE);
        mSeekbarLum.setMax(MAX_VALUE);
        mSeekbarhue.setProgress(MID_VALUE);
        mSeekbarSaturation.setProgress(MID_VALUE);
        mSeekbarLum.setProgress(MID_VALUE);
        mImageView.setImageBitmap(bitmap);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()){
            case R.id.seekbar_matrix_hue:
                mHue = (progress - MID_VALUE)*1.0f/MID_VALUE*180;
                break;
            case R.id.seekbar_matrix_saturation:
                mSaturation = progress*1.0f/MID_VALUE;
                break;
            case R.id.seekbar_matrix_lum:
                mLum = progress*1.0f/MID_VALUE;
                break;
        }
        mImageView.setImageBitmap(ImageHelper.handleImageEffect(
               bitmap, mHue, mSaturation, mLum));

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
