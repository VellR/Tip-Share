package com.victor.loading.rotate;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.victor.loading.R;

public class RotateLoading extends View {
    private static final int DEFAULT_SHADOW_POSITION = 2;
    private static final int DEFAULT_SPEED_OF_DEGREE = 10;
    private static final int DEFAULT_WIDTH = 6;
    private float arc;
    private int bottomDegree = 190;
    private boolean changeBigger = true;
    private int color;
    /* access modifiers changed from: private */
    public boolean isStart = false;
    private RectF loadingRectF;
    private Paint mPaint;
    private int shadowPosition;
    private RectF shadowRectF;
    private float speedOfArc;
    private int speedOfDegree;
    private int topDegree = 10;
    private int width;

    public RotateLoading(Context context) {
        super(context);
        initView(context, null);
    }

    public RotateLoading(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public RotateLoading(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        this.color = -1;
        this.width = dpToPx(context, 6.0f);
        this.shadowPosition = dpToPx(getContext(), 2.0f);
        this.speedOfDegree = 10;
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RotateLoading);
            this.color = typedArray.getColor(R.styleable.RotateLoading_loading_color, -1);
            this.width = typedArray.getDimensionPixelSize(R.styleable.RotateLoading_loading_width, dpToPx(context, 6.0f));
            this.shadowPosition = typedArray.getInt(R.styleable.RotateLoading_shadow_position, 2);
            this.speedOfDegree = typedArray.getInt(R.styleable.RotateLoading_loading_speed, 10);
            typedArray.recycle();
        }
        this.speedOfArc = (float) (this.speedOfDegree / 4);
        this.mPaint = new Paint();
        this.mPaint.setColor(this.color);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Style.STROKE);
        this.mPaint.setStrokeWidth((float) this.width);
        this.mPaint.setStrokeCap(Cap.ROUND);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.arc = 10.0f;
        this.loadingRectF = new RectF((float) (this.width * 2), (float) (this.width * 2), (float) (w - (this.width * 2)), (float) (h - (this.width * 2)));
        this.shadowRectF = new RectF((float) ((this.width * 2) + this.shadowPosition), (float) ((this.width * 2) + this.shadowPosition), (float) ((w - (this.width * 2)) + this.shadowPosition), (float) ((h - (this.width * 2)) + this.shadowPosition));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        boolean z = false;
        super.onDraw(canvas);
        if (this.isStart) {
            this.mPaint.setColor(Color.parseColor("#1a000000"));
            canvas.drawArc(this.shadowRectF, (float) this.topDegree, this.arc, false, this.mPaint);
            canvas.drawArc(this.shadowRectF, (float) this.bottomDegree, this.arc, false, this.mPaint);
            this.mPaint.setColor(this.color);
            canvas.drawArc(this.loadingRectF, (float) this.topDegree, this.arc, false, this.mPaint);
            canvas.drawArc(this.loadingRectF, (float) this.bottomDegree, this.arc, false, this.mPaint);
            this.topDegree += this.speedOfDegree;
            this.bottomDegree += this.speedOfDegree;
            if (this.topDegree > 360) {
                this.topDegree -= 360;
            }
            if (this.bottomDegree > 360) {
                this.bottomDegree -= 360;
            }
            if (this.changeBigger) {
                if (this.arc < 160.0f) {
                    this.arc += this.speedOfArc;
                    invalidate();
                }
            } else if (this.arc > ((float) this.speedOfDegree)) {
                this.arc -= 2.0f * this.speedOfArc;
                invalidate();
            }
            if (this.arc >= 160.0f || this.arc <= 10.0f) {
                if (!this.changeBigger) {
                    z = true;
                }
                this.changeBigger = z;
                invalidate();
            }
        }
    }

    public void setLoadingColor(int color2) {
        this.color = color2;
    }

    public int getLoadingColor() {
        return this.color;
    }

    public void start() {
        startAnimator();
        this.isStart = true;
        invalidate();
    }

    public void stop() {
        stopAnimator();
        invalidate();
    }

    public boolean isStart() {
        return this.isStart;
    }

    private void startAnimator() {
        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(this, "scaleX", new float[]{0.0f, 1.0f});
        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(this, "scaleY", new float[]{0.0f, 1.0f});
        scaleXAnimator.setDuration(300);
        scaleXAnimator.setInterpolator(new LinearInterpolator());
        scaleYAnimator.setDuration(300);
        scaleYAnimator.setInterpolator(new LinearInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{scaleXAnimator, scaleYAnimator});
        animatorSet.start();
    }

    private void stopAnimator() {
        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(this, "scaleX", new float[]{1.0f, 0.0f});
        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(this, "scaleY", new float[]{1.0f, 0.0f});
        scaleXAnimator.setDuration(300);
        scaleXAnimator.setInterpolator(new LinearInterpolator());
        scaleYAnimator.setDuration(300);
        scaleYAnimator.setInterpolator(new LinearInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{scaleXAnimator, scaleYAnimator});
        animatorSet.addListener(new AnimatorListener() {
            public void onAnimationStart(Animator animation) {
            }

            public void onAnimationEnd(Animator animation) {
                RotateLoading.this.isStart = false;
            }

            public void onAnimationCancel(Animator animation) {
            }

            public void onAnimationRepeat(Animator animation) {
            }
        });
        animatorSet.start();
    }

    public int dpToPx(Context context, float dpVal) {
        return (int) TypedValue.applyDimension(1, dpVal, context.getResources().getDisplayMetrics());
    }
}
