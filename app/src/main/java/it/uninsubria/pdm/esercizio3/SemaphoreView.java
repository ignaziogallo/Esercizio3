package it.uninsubria.pdm.esercizio3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;

import java.util.Random;

public class SemaphoreView extends View {
    public int background;
    public int sfondo;
    public static int identificatore = 0;
    private float raggio;
    private float coordX;
    private float coordY;
    public static String stato = "";
    Paint paint;

    public SemaphoreView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setupAttributes(attrs);
        setupPaint();
    }

    public void setupAttributes(AttributeSet attrs) {
        TypedArray array = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.SemaphoreView, 0, 0);
        try {
            background = array.getColor(R.styleable.SemaphoreView_back, Color.GRAY);
            raggio = array.getDimension(R.styleable.SemaphoreView_dim, 50);
            coordX = array.getDimension(R.styleable.SemaphoreView_coordX, 0);
            coordY = array.getDimension(R.styleable.SemaphoreView_coordY, 0);
        } finally {
            array.recycle();
        }
    }

    private void setupPaint() {
        paint = new Paint();
        paint.setColor(Color.GRAY);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(4);
        paint.setAntiAlias(true);

    }

    public void setIdentif(int id) {
        this.identificatore = id;
    }

    public int getIdentif() {
        return identificatore;
    }

    public void setBack(int back) {
        this.background = back;
    }

    public int getBack() {
        return background;
    }

    public void ricreaView() {
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (identificatore == 1) {
            Log.d(" QUI_ARRIVO set id 1: ", " valore: " + identificatore);
            canvas.drawColor(background);
            paint.setColor(sfondo);
            canvas.drawCircle(coordX, coordY, raggio, paint);
            paint.setColor(Color.GRAY);
            canvas.drawCircle(coordX, coordY + (raggio * 2), raggio, paint);
            canvas.drawCircle(coordX, coordY + (raggio * 4), raggio, paint);
            stato = "RED";
        } else if (identificatore == 2) {
            Log.d(" QUI_ARRIVO set id 2: ", " valore: " + identificatore);
            canvas.drawColor(background);
            paint.setColor(Color.GRAY);
            canvas.drawCircle(coordX, coordY, raggio, paint);
            paint.setColor(sfondo);
            canvas.drawCircle(coordX, coordY + (raggio * 2), raggio, paint);
            paint.setColor(Color.GRAY);
            canvas.drawCircle(coordX, coordY + (raggio * 4), raggio, paint);
            stato = "YELLOW";
        } else if (identificatore == 3) {
            Log.d(" QUI_ARRIVO set id 3: ", " valore: " + identificatore);
            canvas.drawColor(background);
            paint.setColor(Color.GRAY);
            canvas.drawCircle(coordX, coordY, raggio, paint);
            paint.setColor(Color.GRAY);
            canvas.drawCircle(coordX, coordY + (raggio * 2), raggio, paint);
            paint.setColor(sfondo);
            canvas.drawCircle(coordX, coordY + (raggio * 4), raggio, paint);
            stato = "GREEN";
        } else {
            Log.d(" QUI_ARRIVO set id df: ", " valore: " + identificatore);
            canvas.drawColor(background);
            paint.setColor(Color.GRAY);
            canvas.drawCircle(coordX, coordY, raggio, paint);
            canvas.drawCircle(coordX, coordY + (raggio * 2), raggio, paint);
            canvas.drawCircle(coordX, coordY + (raggio * 4), raggio, paint);
            stato = "";
        }
    }
}