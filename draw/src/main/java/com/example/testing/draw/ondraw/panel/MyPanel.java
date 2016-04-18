package com.example.testing.draw.ondraw.panel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.testing.draw.R;

/**
 * Author: ChenYJ
 * Date: 2016/3/17 11:28
 * Email:cyjchenxiao@163.com
 */
public class MyPanel extends View {

    private int mWidth;
    private int mHeight;

    public MyPanel(Context context) {
        super(context);
    }

    public MyPanel(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyPanel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paintCircle = new Paint();
        paintCircle.setStyle(Paint.Style.STROKE);
        paintCircle.setAntiAlias(true);
        paintCircle.setStrokeWidth(10);
        canvas.drawCircle(mWidth / 2, mHeight / 2, (mWidth - 10) / 2, paintCircle);

        Paint painTEXT = new Paint();
        painTEXT.setStrokeWidth(5);
        painTEXT.setTextSize(30);
        String a="0";
        canvas.drawText(a, mWidth / 2 - painTEXT.measureText(a) / 2,
                mHeight / 2 - mWidth / 2 + 90, painTEXT);
        String b="6";
        canvas.drawText(b, mWidth-90,
                mHeight / 2 + 5, painTEXT);
        String c="12";
        canvas.drawText(c, mWidth / 2 - painTEXT.measureText(c) / 2,
                mHeight / 2 - mWidth / 2 + mWidth-90, painTEXT);
        String d="18";
        canvas.drawText(d, 90,
                mHeight / 2 + 5, painTEXT);

        Paint painDegree = new Paint();
        painDegree.setStrokeWidth(3);
        for (int i=0; i<24;i++){
            if (i==0 || i==6 || i==12 || i== 18){
                painDegree.setStrokeWidth(5);
                painDegree.setTextSize(30);
                canvas.drawLine(mWidth/2, mHeight/2-mWidth/2, mWidth/2, mHeight/2-mWidth/2+60, painDegree);
            } else {
                painDegree.setStrokeWidth(3);
                painDegree.setTextSize(15);
                canvas.drawLine(mWidth / 2, mHeight / 2 - mWidth / 2, mWidth / 2, mHeight / 2 - mWidth / 2 + 30, painDegree);
            }
            //通过旋转画布简化坐标运算
            canvas.rotate(15, mWidth/2, mHeight/2);
        }

        //画指针
        Paint paintHour = new Paint();
        Paint paintMinute = new Paint();
        paintHour.setStrokeWidth(20);
        paintMinute.setStrokeWidth(10);
        canvas.save();
        //画布平移
        canvas.translate(mWidth/2, mHeight/2);
        canvas.drawLine(0,0,getResources().getDimension(R.dimen.dimen_90dp),getResources().getDimension(R.dimen.dimen_90dp),paintHour);
        canvas.drawLine(0,0,getResources().getDimension(R.dimen.dimen_100dp),getResources().getDimension(R.dimen.dimen_180dp),paintMinute);
        canvas.restore();
    }
}
