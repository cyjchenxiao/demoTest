package com.example.testing.draw.colormatrix;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;

/**
 * Author: ChenYJ
 * Date: 2016/3/21 12:01
 * Email:cyjchenxiao@163.com
 */
public class ImageHelper {

    public static Bitmap handleImageEffect(Bitmap bm, float hue, float saturation, float lum){
        Bitmap bmp = Bitmap.createBitmap(bm.getWidth(), bm.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint();

        ColorMatrix hueMatrix = new ColorMatrix();
        hueMatrix.setRotate(0, hue);
        hueMatrix.setRotate(1, hue);
        hueMatrix.setRotate(2, hue);

        ColorMatrix saturationMatrix = new ColorMatrix();
        saturationMatrix.setSaturation(saturation);

        ColorMatrix lumMatrix = new ColorMatrix();
        lumMatrix.setScale(lum, lum, lum, 1);

        ColorMatrix imgMatrix = new ColorMatrix();
        imgMatrix.postConcat(hueMatrix);
        imgMatrix.postConcat(saturationMatrix);
        imgMatrix.postConcat(lumMatrix);

        paint.setColorFilter(new ColorMatrixColorFilter(imgMatrix));
        canvas.drawBitmap(bm, 0, 0, paint);
        return bmp;
    }

    /**
     * 底片效果
     * @param bm
     * @return
     */
    public static Bitmap handleImageNegative(Bitmap bm){
        int width = bm.getWidth();
        int height = bm.getHeight();
        int color;
        int r,g,b,a;

        Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        int[] oldPx = new int[width*height];
        int[] newPx = new int[width*height];

        bm.getPixels(oldPx, 0, width, 0, 0, width, height);
        for (int i=0;i<width*height;i++){
            color = oldPx[i];
            r = Color.red(color);
            g = Color.green(color);
            b = Color.blue(color);
            a = Color.alpha(color);

            r = 255-r;
            g = 255-g;
            b = 255-b;

            if (r > 255){
                r = 255;
            } else if (r < 0){
                r = 0;
            }
            if (g > 255){
                g = 255;
            } else if (g < 0){
                g = 0;
            }
            if (b > 255){
                b = 255;
            } else if (b < 0){
                b = 0;
            }

            newPx[i] = Color.argb(a,r,g,b);
        }
        bmp.setPixels(newPx, 0, width, 0, 0, width, height);
        return bmp;
    }

    public static Bitmap handleImageOldEffect(Bitmap bm){
        int width = bm.getWidth();
        int height = bm.getHeight();
        int color;
        int r,g,b,a;

        Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        int[] oldPx = new int[width*height];
        int[] newPx = new int[width*height];

        bm.getPixels(oldPx,0,width,0,0,width,height);
        for (int i=0;i<width*height;i++){
            color = oldPx[i];
            r = Color.red(color);
            g = Color.green(color);
            b = Color.blue(color);
            a = Color.alpha(color);

            int r1 = (int)(0.393*r + 0.769*g + 0.189*b);
            int g1 = (int)(0.349*r + 0.686*g + 0.168*b);
            int b1 = (int)(0.272*r + 0.534*g + 0.131*b);

            if (r1 > 255) {
                r1 = 255;
            }
            if (g1 > 255) {
                g1 = 255;
            }
            if (b1 > 255) {
                b1 = 255;
            }

            newPx[i] = Color.argb(a,r1,g1,b1);
        }
        bmp.setPixels(newPx,0,width,0,0,width,height);
        return bmp;
    }

    public static Bitmap handleImagePixelsRelief(Bitmap bm) {
        Bitmap bmp = Bitmap.createBitmap(bm.getWidth(), bm.getHeight(),
                Bitmap.Config.ARGB_8888);
        int width = bm.getWidth();
        int height = bm.getHeight();
        int color = 0, colorBefore = 0;
        int a, r, g, b;
        int r1, g1, b1;

        int[] oldPx = new int[width * height];
        int[] newPx = new int[width * height];

        bm.getPixels(oldPx, 0, bm.getWidth(), 0, 0, width, height);
        for (int i = 1; i < width * height; i++) {
            colorBefore = oldPx[i - 1];
            a = Color.alpha(colorBefore);
            r = Color.red(colorBefore);
            g = Color.green(colorBefore);
            b = Color.blue(colorBefore);

            color = oldPx[i];
            r1 = Color.red(color);
            g1 = Color.green(color);
            b1 = Color.blue(color);

            r = (r - r1 + 127);
            g = (g - g1 + 127);
            b = (b - b1 + 127);
            if (r > 255) {
                r = 255;
            }
            if (g > 255) {
                g = 255;
            }
            if (b > 255) {
                b = 255;
            }
            newPx[i] = Color.argb(a, r, g, b);
        }
        bmp.setPixels(newPx, 0, width, 0, 0, width, height);
        return bmp;
    }

    public static Bitmap handleBitmapMesh(Bitmap bitmap){
        final int WIDTH = 15;
        final int HEIGHT = 10;
        float[] verts = new float[WIDTH*WIDTH*2];
        float[] orgs = new float[WIDTH*WIDTH*2];
        float bmpWidth = bitmap.getWidth();
        float bmpHeight = bitmap.getHeight();
        int index = 0;
        for (int y = 0; y<=HEIGHT; y++){
            float fy = bmpHeight*y/HEIGHT;
            for (int x=0; x<=WIDTH; x++){
                float fx = bmpWidth*x/WIDTH;
                orgs[index*2+0] = verts[index*2+0] = fx;
                orgs[index*2+1] = verts[index*2+1] = fy;
                index += 1;
            }
        }


        for (int j=0; j<=HEIGHT; j++){
            for (int i=0; i<=WIDTH; i++){
                verts[(j*(WIDTH+1)+i)*2+0]+=0;
                float offsetY = (float)Math.sin((float)i/WIDTH*2*Math.PI);
                verts[(j*(WIDTH+1)+i)*2+1] = orgs[(j*WIDTH+i)*2+1]+offsetY*40;
            }
        }

        Bitmap bmp = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmp);
        canvas.drawBitmapMesh(bitmap, WIDTH, HEIGHT, verts, 0, null, 0, null);
        return bmp;
    }

    public static Bitmap handleBitmapPorterDuffX_01(Bitmap bitmap){
        Bitmap out = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(out);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawRoundRect(new RectF(0, 0, bitmap.getWidth(), bitmap.getHeight()), 40, 40, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0,0,paint);
        return out;
    }
}
