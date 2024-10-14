package com.example.superkomponenty2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CustomCircleView extends View {
    private Paint paint;
    private float cx, cy;
    private float radius;
    private int color;

    public CustomCircleView(Context context) {
        super(context);
        init();
    }

    public CustomCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);
        radius = 100;
        cx = 300;
        cy = 300;
        color = Color.BLUE;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(color);
        canvas.drawCircle(cx, cy, radius, paint);
    }

    public void setRadius(float newRadius) {
        radius = newRadius;
        invalidate();
    }

    public void setColor(int newColor) {
        color = newColor;
        invalidate();
    }

    public void setPosition(float newCx, float newCy) {
        cx = newCx;
        cy = newCy;
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            color = color == Color.BLUE ? Color.RED : Color.BLUE; // Zmiana koloru okręgu
            invalidate();
        }
        return true;
    }

    // Gettery
    public float getCx() {
        return cx;
    }

    public float getCy() {
        return cy;
    }

    public int getColor() {
        return color;
    }

    public void setCx(float newCx) {
        cx = newCx;
        invalidate();
    }

    public void setCy(float newCy) {
        cy = newCy;
        invalidate();
    }
}
