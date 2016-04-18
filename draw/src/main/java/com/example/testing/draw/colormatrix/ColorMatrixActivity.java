package com.example.testing.draw.colormatrix;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.example.testing.draw.R;

public class ColorMatrixActivity extends AppCompatActivity {

    private Bitmap bitMap;
    private ImageView mImageView;
    private GridLayout mGroup;
    private int mEtWidth;
    private int mEtHeight;
    private EditText[] mEts = new EditText[20];
    private float[] mColorMatrix = new float[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_matrix2);

        bitMap = BitmapFactory.decodeResource(getResources(), R.drawable.color_matrix_test);
        mImageView = (ImageView) findViewById(R.id.test_img2);
        mGroup = (GridLayout) findViewById(R.id.gridlayout_group);
        mImageView.setImageBitmap(bitMap);

        mGroup.post(new Runnable() {
            @Override
            public void run() {
                mEtWidth = mGroup.getWidth()/5;
                mEtHeight = mGroup.getHeight()/4;
                addEtx();
                initMatrix();
            }
        });
    }

    private void initMatrix() {
        for (int i=0; i<20; i++){
            if (i%6 == 0){
                mEts[i].setText(String.valueOf(1));
            } else{
                mEts[i].setText(String.valueOf(0));
            }
        }
    }

    private void addEtx() {
        for (int i=0; i<20; i++){
            EditText editText = new EditText(ColorMatrixActivity.this);
            mEts[i] = editText;
            mGroup.addView(editText, mEtWidth, mEtHeight);
        }
    }

    private void getMatrix(){
        for (int i = 0; i < 20; i++){
            mColorMatrix[i] = Float.valueOf(mEts[i].getText().toString());
        }
    }

    private void setMatrix(){
        for (int i = 0; i < 20; i++){
            mEts[i].setText(String.valueOf(mColorMatrix[i]));
        }
    }

    private void setImageMatris(){
        Bitmap bmp = Bitmap.createBitmap(bitMap.getWidth(), bitMap.getHeight(), Bitmap.Config.ARGB_8888);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(mColorMatrix);
        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitMap, 0, 0, paint);
        mImageView.setImageBitmap(bmp);
    }

    public void btnChange(View view){
        getMatrix();
        setImageMatris();
    }

    public void btnReset(View view){
        initMatrix();
        getMatrix();
        setImageMatris();
    }

    public void effect_fanzhuan(View view){
        mColorMatrix = new float[]{
                -1,0,0,1,1,
                0,-1,0,1,1,
                0,0,-1,1,1,
                0,0,0,1,0};
        setMatrix();
        getMatrix();
        setImageMatris();
    }

    public void effect_huaijiu(View view){
        mColorMatrix = new float[]{
                0.293F,0.769F,0.189F,0,0,
                0.349F,0.686F,0.168F,0,0,
                0.272F,0.534F,0.131F,0,0,
                0,0,0,1,0};
        setMatrix();
        getMatrix();
        setImageMatris();
    }

    public void effect_quse(View view){
        mColorMatrix = new float[]{
                1.5F,1.5F,1.5F,0,-1,
                1.5F,1.5F,1.5F,0,-1,
                1.5F,1.5F,1.5F,0,-1,
                0,0,0,1,0};
        setMatrix();
        getMatrix();
        setImageMatris();
    }

    public void effect_gaobaohe(View view){
        mColorMatrix = new float[]{
                1.438F,-0.122F,-0.016F,0,-0.03F,
                -0.062F,1.378F,-0.016F,0,0.05F,
                -0.062F,-0.122F,1.483F,0,-0.02F,
                0,0,0,1,0};
        setMatrix();
        getMatrix();
        setImageMatris();
    }

    public void effect_huidu(View view){
        mColorMatrix = new float[]{
                0.33F,0.59F,0.11F,0,0,
                0.33F,0.59F,0.11F,0,0,
                0.33F,0.59F,0.11F,0,0,
                0,0,0,1,0};
        setMatrix();
        getMatrix();
        setImageMatris();
    }
}
