package com.example.testing.draw.ondraw.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.testing.draw.R;

/**
 * Author: ChenYJ
 * Date: 2016/3/17 15:10
 * Email:cyjchenxiao@163.com
 */
public class LayerView extends View {
    public LayerView(Context context) {
        super(context);
    }

    public LayerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LayerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        canvas.drawCircle(getResources().getDimension(R.dimen.dimen_150dp), getResources().getDimension(R.dimen.dimen_150dp), getResources().getDimension(R.dimen.dimen_100dp), paint);

        //图层入栈
        canvas.saveLayerAlpha(0, 0, getResources().getDimension(R.dimen.dimen_400dp), getResources().getDimension(R.dimen.dimen_400dp), (int) getResources().getDimension(R.dimen.dimen_127dp), Canvas.HAS_ALPHA_LAYER_SAVE_FLAG);
//        canvas.saveLayerAlpha(0, 0, 400, 400,255, Canvas.HAS_ALPHA_LAYER_SAVE_FLAG);
//        canvas.saveLayerAlpha(0, 0, 400, 400,0, Canvas.HAS_ALPHA_LAYER_SAVE_FLAG);

        paint.setColor(Color.RED);
        canvas.drawCircle(getResources().getDimension(R.dimen.dimen_200dp), getResources().getDimension(R.dimen.dimen_200dp), getResources().getDimension(R.dimen.dimen_200dp), paint);
        canvas.restore();
    }
}
