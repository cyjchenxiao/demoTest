package com.example.testing.draw.matrix;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.example.testing.draw.R;

public class MatrixApiActivity extends AppCompatActivity {

    private GridLayout mLayout;
    private ImageView mImg;
    private int mWidth;
    private int mHeight;
    private EditText[] mEdts = new EditText[9];
    private float[] mImageMatrix = new float[9];
    private Bitmap mBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix_api);

        mLayout = (GridLayout) findViewById(R.id.matrix_grid);
        mImg = (ImageView) findViewById(R.id.matrix_test_img);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        mLayout.post(new Runnable() {
            @Override
            public void run() {
                mWidth = mLayout.getWidth()/3;
                mHeight = mLayout.getHeight()/3;
                addView();
                initMatrix();
            }
        });


    }

    private void initMatrix() {
        for (int i=0; i<9; i++){
            if (i%4 == 0){
                mEdts[i].setText(String.valueOf(1));
            } else{
                mEdts[i].setText(String.valueOf(0));
            }
        }
    }

    private void addView() {
        for (int i=0; i<9; i++){
            EditText edt = new EditText(this);
            mEdts[i] = edt;
            mLayout.addView(edt, mWidth, mHeight);
        }
    }

    public void btn_Change(View view){
        Matrix matrix = new Matrix();
        for (int i = 0; i<9; i++){
            mImageMatrix[i] = Float.valueOf(mEdts[i].getText().toString());
        }
        matrix.setValues(mImageMatrix);

        Bitmap bmp = Bitmap.createBitmap(mBitmap.getWidth(), mBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint();
        canvas.drawBitmap(mBitmap, matrix, paint);
        mImg.setImageBitmap(bmp);
    }

    public void btn_Reset(View view){
        initMatrix();
        Matrix matrix = new Matrix();
        for (int i = 0; i<9; i++){
            mImageMatrix[i] = Float.valueOf(mEdts[i].getText().toString());
        }
        matrix.setValues(mImageMatrix);

        Bitmap bmp = Bitmap.createBitmap(mBitmap.getWidth(), mBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint();
        canvas.drawBitmap(mBitmap, matrix, paint);
        mImg.setImageBitmap(bmp);
    }
}
