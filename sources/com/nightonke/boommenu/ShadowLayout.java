package com.nightonke.boommenu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class ShadowLayout extends FrameLayout {
    private int OriginalShadowColor;
    private int ShadowColor;
    private float mCornerRadius;
    private float mDx;
    private float mDy;
    private boolean mForceInvalidateShadow = false;
    private boolean mInvalidateShadowOnSizeChanged = true;
    private float mShadowRadius;

    public ShadowLayout(Context context) {
        super(context);
        initView(context, null);
    }

    public ShadowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public ShadowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumWidth() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumHeight() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w > 0 && h > 0) {
            if (getBackground() == null || this.mInvalidateShadowOnSizeChanged || this.mForceInvalidateShadow) {
                this.mForceInvalidateShadow = false;
                setBackgroundCompat(w, h);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (this.mForceInvalidateShadow) {
            this.mForceInvalidateShadow = false;
            setBackgroundCompat(right - left, bottom - top);
        }
    }

    public void setInvalidateShadowOnSizeChanged(boolean invalidateShadowOnSizeChanged) {
        this.mInvalidateShadowOnSizeChanged = invalidateShadowOnSizeChanged;
    }

    public void invalidateShadow() {
        this.mForceInvalidateShadow = true;
        requestLayout();
        invalidate();
    }

    private void initView(Context context, AttributeSet attrs) {
        initAttributes(context, attrs);
        int xPadding = (int) (this.mShadowRadius + Math.abs(this.mDx));
        int yPadding = (int) (this.mShadowRadius + Math.abs(this.mDy));
        setPadding(xPadding, yPadding, xPadding, yPadding);
    }

    private void setBackgroundCompat(int w, int h) {
        BitmapDrawable drawable = new BitmapDrawable(getResources(), createShadowBitmap(w, h, this.mCornerRadius, this.mShadowRadius, this.mDx, this.mDy, this.ShadowColor, 0));
        if (VERSION.SDK_INT <= 16) {
            setBackgroundDrawable(drawable);
        } else {
            setBackground(drawable);
        }
    }

    private void initAttributes(Context context, AttributeSet attrs) {
        TypedArray attr = getTypedArray(context, attrs, R.styleable.ShadowLayout);
        if (attr != null) {
            try {
                this.mCornerRadius = attr.getDimension(R.styleable.ShadowLayout_sl_cornerRadius, getResources().getDimension(R.dimen.default_corner_radius));
                this.mShadowRadius = attr.getDimension(R.styleable.ShadowLayout_sl_shadowRadius, getResources().getDimension(R.dimen.default_shadow_radius));
                this.mDx = attr.getDimension(R.styleable.ShadowLayout_sl_dx, 0.0f);
                this.mDy = attr.getDimension(R.styleable.ShadowLayout_sl_dy, 0.0f);
                int color = attr.getColor(R.styleable.ShadowLayout_sl_shadowColor, ContextCompat.getColor(context, R.color.default_shadow_color));
                this.ShadowColor = color;
                this.OriginalShadowColor = color;
            } finally {
                attr.recycle();
            }
        }
    }

    private TypedArray getTypedArray(Context context, AttributeSet attributeSet, int[] attr) {
        return context.obtainStyledAttributes(attributeSet, attr, 0, 0);
    }

    private Bitmap createShadowBitmap(int shadowWidth, int shadowHeight, float cornerRadius, float shadowRadius, float dx, float dy, int shadowColor, int fillColor) {
        Bitmap output = Bitmap.createBitmap(shadowWidth, shadowHeight, Config.ALPHA_8);
        Canvas canvas = new Canvas(output);
        RectF shadowRect = new RectF(shadowRadius, shadowRadius, ((float) shadowWidth) - shadowRadius, ((float) shadowHeight) - shadowRadius);
        if (dy > 0.0f) {
            shadowRect.top += dy;
            shadowRect.bottom -= dy;
        } else if (dy < 0.0f) {
            shadowRect.top += Math.abs(dy);
            shadowRect.bottom -= Math.abs(dy);
        }
        if (dx > 0.0f) {
            shadowRect.left += dx;
            shadowRect.right -= dx;
        } else if (dx < 0.0f) {
            shadowRect.left += Math.abs(dx);
            shadowRect.right -= Math.abs(dx);
        }
        Paint shadowPaint = new Paint();
        shadowPaint.setAntiAlias(true);
        shadowPaint.setColor(fillColor);
        shadowPaint.setStyle(Style.FILL);
        if (!isInEditMode()) {
            shadowPaint.setShadowLayer(shadowRadius, dx, dy, shadowColor);
        }
        canvas.drawRoundRect(shadowRect, cornerRadius, cornerRadius, shadowPaint);
        return output;
    }

    public void setShadowColor(int shadowColor) {
        this.ShadowColor = shadowColor;
        invalidate();
    }

    public int getOriginalShadowColor() {
        return this.OriginalShadowColor;
    }

    public int getShadowColor() {
        return this.ShadowColor;
    }

    public void setmShadowRadius(float mShadowRadius2) {
        this.mShadowRadius = mShadowRadius2;
    }

    public void setmCornerRadius(float mCornerRadius2) {
        this.mCornerRadius = mCornerRadius2;
        invalidate();
    }

    public void setmDx(float mDx2) {
        this.mDx = mDx2;
        invalidate();
    }

    public void setmDy(float mDy2) {
        this.mDy = mDy2;
        invalidate();
    }
}
