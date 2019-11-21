package com.nightonke.boommenu;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.util.StateSet;
import android.view.Display;
import android.view.View;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;

public class Util {
    private static Util ourInstance = new Util();

    public int getScreenWidth(Context context) {
        Display display = ((Activity) context).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.x;
    }

    public int getScreenHeight(Context context) {
        Display display = ((Activity) context).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.y;
    }

    public float dp2px(float dp) {
        return (float) Math.round(dp * (((float) Resources.getSystem().getDisplayMetrics().densityDpi) / 160.0f));
    }

    public int getDarkerColor(int color) {
        float[] hsv = new float[3];
        Color.colorToHSV(color, hsv);
        hsv[2] = hsv[2] * 0.9f;
        return Color.HSVToColor(hsv);
    }

    public int getLighterColor(int color) {
        float[] hsv = new float[3];
        Color.colorToHSV(color, hsv);
        hsv[2] = hsv[2] * 1.1f;
        return Color.HSVToColor(hsv);
    }

    public int getPressedColor(int color) {
        if (getLighterColor(color) == color) {
            return getDarkerColor(color);
        }
        return getLighterColor(color);
    }

    public void setCircleButtonStateListDrawable(View circleButton, int radius, int pressedColor, int normalColor) {
        WeakReference<Bitmap> imagePressed = new WeakReference<>(Bitmap.createBitmap(radius * 2, radius * 2, Config.ARGB_8888));
        Canvas canvasPressed = new Canvas((Bitmap) imagePressed.get());
        Paint paintPressed = new Paint();
        paintPressed.setAntiAlias(true);
        paintPressed.setColor(pressedColor);
        canvasPressed.drawCircle((float) radius, (float) radius, (float) radius, paintPressed);
        WeakReference<Bitmap> imageNormal = new WeakReference<>(Bitmap.createBitmap(radius * 2, radius * 2, Config.ARGB_8888));
        Canvas canvasNormal = new Canvas((Bitmap) imageNormal.get());
        Paint paintNormal = new Paint();
        paintNormal.setAntiAlias(true);
        paintNormal.setColor(normalColor);
        canvasNormal.drawCircle((float) radius, (float) radius, (float) radius, paintNormal);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, new BitmapDrawable(circleButton.getContext().getResources(), (Bitmap) imagePressed.get()));
        stateListDrawable.addState(StateSet.WILD_CARD, new BitmapDrawable(circleButton.getContext().getResources(), (Bitmap) imageNormal.get()));
        if (VERSION.SDK_INT >= 16) {
            circleButton.setBackground(stateListDrawable);
        } else {
            circleButton.setBackgroundDrawable(stateListDrawable);
        }
    }

    public void setHamButtonStateListDrawable(View linearLayout, int width, int height, int pressedColor, int normalColor) {
        WeakReference<Bitmap> imagePressed = new WeakReference<>(Bitmap.createBitmap(width, height, Config.ARGB_8888));
        Canvas canvasPressed = new Canvas((Bitmap) imagePressed.get());
        Paint paintPressed = new Paint();
        paintPressed.setAntiAlias(true);
        paintPressed.setColor(pressedColor);
        canvasPressed.drawRoundRect(new RectF(0.0f, 0.0f, (float) width, (float) height), dp2px(3.0f), dp2px(3.0f), paintPressed);
        WeakReference<Bitmap> imageNormal = new WeakReference<>(Bitmap.createBitmap(width, height, Config.ARGB_8888));
        Canvas canvasNormal = new Canvas((Bitmap) imageNormal.get());
        Paint paintNormal = new Paint();
        paintNormal.setAntiAlias(true);
        paintNormal.setColor(normalColor);
        canvasNormal.drawRoundRect(new RectF(0.0f, 0.0f, (float) width, (float) height), dp2px(3.0f), dp2px(3.0f), paintNormal);
        WeakReference<StateListDrawable> stateListDrawable = new WeakReference<>(new StateListDrawable());
        ((StateListDrawable) stateListDrawable.get()).addState(new int[]{16842919}, (Drawable) new WeakReference(new BitmapDrawable(linearLayout.getContext().getResources(), (Bitmap) imagePressed.get())).get());
        ((StateListDrawable) stateListDrawable.get()).addState(StateSet.WILD_CARD, (Drawable) new WeakReference(new BitmapDrawable(linearLayout.getContext().getResources(), (Bitmap) imageNormal.get())).get());
        if (VERSION.SDK_INT >= 16) {
            linearLayout.setBackground((Drawable) stateListDrawable.get());
            return;
        }
        linearLayout.setBackgroundDrawable((Drawable) stateListDrawable.get());
    }

    public float round(float d, int decimalPlace) {
        return new BigDecimal(Float.toString(d)).setScale(decimalPlace, 4).floatValue();
    }

    public static Util getInstance() {
        return ourInstance;
    }

    private Util() {
    }
}
