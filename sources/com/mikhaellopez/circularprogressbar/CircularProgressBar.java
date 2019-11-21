package com.mikhaellopez.circularprogressbar;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.google.android.gms.common.ConnectionResult;

public class CircularProgressBar extends View {
    private int backgroundColor = -7829368;
    private Paint backgroundPaint;
    private float backgroundStrokeWidth = getResources().getDimension(R.dimen.default_background_stroke_width);
    private int color = ViewCompat.MEASURED_STATE_MASK;
    private Paint foregroundPaint;
    private float progress = 0.0f;
    private RectF rectF;
    private int startAngle = -90;
    private float strokeWidth = getResources().getDimension(R.dimen.default_stroke_width);

    public CircularProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    /* JADX INFO: finally extract failed */
    private void init(Context context, AttributeSet attrs) {
        this.rectF = new RectF();
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CircularProgressBar, 0, 0);
        try {
            this.progress = typedArray.getFloat(R.styleable.CircularProgressBar_cpb_progress, this.progress);
            this.strokeWidth = typedArray.getDimension(R.styleable.CircularProgressBar_cpb_progressbar_width, this.strokeWidth);
            this.backgroundStrokeWidth = typedArray.getDimension(R.styleable.CircularProgressBar_cpb_background_progressbar_width, this.backgroundStrokeWidth);
            this.color = typedArray.getInt(R.styleable.CircularProgressBar_cpb_progressbar_color, this.color);
            this.backgroundColor = typedArray.getInt(R.styleable.CircularProgressBar_cpb_background_progressbar_color, this.backgroundColor);
            typedArray.recycle();
            this.backgroundPaint = new Paint(1);
            this.backgroundPaint.setColor(this.backgroundColor);
            this.backgroundPaint.setStyle(Style.STROKE);
            this.backgroundPaint.setStrokeWidth(this.backgroundStrokeWidth);
            this.foregroundPaint = new Paint(1);
            this.foregroundPaint.setColor(this.color);
            this.foregroundPaint.setStyle(Style.STROKE);
            this.foregroundPaint.setStrokeWidth(this.strokeWidth);
        } catch (Throwable th) {
            typedArray.recycle();
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawOval(this.rectF, this.backgroundPaint);
        Canvas canvas2 = canvas;
        canvas2.drawArc(this.rectF, (float) this.startAngle, (360.0f * this.progress) / 100.0f, false, this.foregroundPaint);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int min = Math.min(getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec), getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec));
        setMeasuredDimension(min, min);
        float highStroke = this.strokeWidth > this.backgroundStrokeWidth ? this.strokeWidth : this.backgroundStrokeWidth;
        this.rectF.set((highStroke / 2.0f) + 0.0f, (highStroke / 2.0f) + 0.0f, ((float) min) - (highStroke / 2.0f), ((float) min) - (highStroke / 2.0f));
    }

    public float getProgress() {
        return this.progress;
    }

    public void setProgress(float progress2) {
        if (progress2 > 100.0f) {
            progress2 = 100.0f;
        }
        this.progress = progress2;
        invalidate();
    }

    public float getProgressBarWidth() {
        return this.strokeWidth;
    }

    public void setProgressBarWidth(float strokeWidth2) {
        this.strokeWidth = strokeWidth2;
        this.foregroundPaint.setStrokeWidth(strokeWidth2);
        requestLayout();
        invalidate();
    }

    public float getBackgroundProgressBarWidth() {
        return this.backgroundStrokeWidth;
    }

    public void setBackgroundProgressBarWidth(float backgroundStrokeWidth2) {
        this.backgroundStrokeWidth = backgroundStrokeWidth2;
        this.backgroundPaint.setStrokeWidth(backgroundStrokeWidth2);
        requestLayout();
        invalidate();
    }

    public int getColor() {
        return this.color;
    }

    public void setColor(int color2) {
        this.color = color2;
        this.foregroundPaint.setColor(color2);
        invalidate();
        requestLayout();
    }

    public int getBackgroundColor() {
        return this.backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor2) {
        this.backgroundColor = backgroundColor2;
        this.backgroundPaint.setColor(backgroundColor2);
        invalidate();
        requestLayout();
    }

    public void setProgressWithAnimation(float progress2) {
        setProgressWithAnimation(progress2, ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
    }

    public void setProgressWithAnimation(float progress2, int duration) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(this, "progress", new float[]{progress2});
        objectAnimator.setDuration((long) duration);
        objectAnimator.setInterpolator(new DecelerateInterpolator());
        objectAnimator.start();
    }
}
