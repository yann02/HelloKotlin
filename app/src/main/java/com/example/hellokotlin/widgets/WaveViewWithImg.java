package com.example.hellokotlin.widgets;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.hellokotlin.R;

public class WaveViewWithImg extends View {
    private Integer mDrawable;
    public WaveViewWithImg(Context context) {
        super(context);
    }

    public WaveViewWithImg(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.WaveViewWithImg);

        //第一个参数为属性集合里面的属性，R文件名称：R.styleable+属性集合名称+下划线+属性名称
        //第二个参数为，如果没有设置这个属性，则设置的默认的值
        mDrawable = a.getResourceId(R.styleable.WaveViewWithImg_src, R.drawable.thinking_in_java);
        //最后记得将TypedArray对象回收
        a.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint mPaint = new Paint();
        @SuppressLint("DrawAllocation") Bitmap bitmap = BitmapFactory.decodeResource(getResources(), mDrawable);
        RectF rectF = new RectF(50, 50, 200, 200);
        canvas.drawBitmap(bitmap, null, rectF, mPaint);
    }
}
