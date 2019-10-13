package com.akexorcist.roundcornerprogressbar.common;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.BaseSavedState;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.akexorcist.roundcornerprogressbar.R;

public abstract class BaseRoundCornerProgressBar extends LinearLayout {
    protected static final int DEFAULT_BACKGROUND_PADDING = 0;
    protected static final int DEFAULT_MAX_PROGRESS = 100;
    protected static final int DEFAULT_PROGRESS = 0;
    protected static final int DEFAULT_PROGRESS_RADIUS = 30;
    protected static final int DEFAULT_SECONDARY_PROGRESS = 0;
    private int colorBackground;
    private int colorProgress;
    private int colorSecondaryProgress;
    private boolean isReverse;
    private LinearLayout layoutBackground;
    private LinearLayout layoutProgress;
    private LinearLayout layoutSecondaryProgress;
    private float max;
    private int padding;
    private float progress;
    private OnProgressChangedListener progressChangedListener;
    private int radius;
    private float secondaryProgress;
    private int totalWidth;

    public interface OnProgressChangedListener {
        void onProgressChanged(int i, float f, boolean z, boolean z2);
    }

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        int colorBackground;
        int colorProgress;
        int colorSecondaryProgress;
        boolean isReverse;
        float max;
        int padding;
        float progress;
        int radius;
        float secondaryProgress;

        SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            this.max = in.readFloat();
            this.progress = in.readFloat();
            this.secondaryProgress = in.readFloat();
            this.radius = in.readInt();
            this.padding = in.readInt();
            this.colorBackground = in.readInt();
            this.colorProgress = in.readInt();
            this.colorSecondaryProgress = in.readInt();
            this.isReverse = in.readByte() != 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeFloat(this.max);
            out.writeFloat(this.progress);
            out.writeFloat(this.secondaryProgress);
            out.writeInt(this.radius);
            out.writeInt(this.padding);
            out.writeInt(this.colorBackground);
            out.writeInt(this.colorProgress);
            out.writeInt(this.colorSecondaryProgress);
            out.writeByte((byte) (this.isReverse ? 1 : 0));
        }
    }

    /* access modifiers changed from: protected */
    public abstract void drawProgress(LinearLayout linearLayout, float f, float f2, float f3, int i, int i2, int i3, boolean z);

    /* access modifiers changed from: protected */
    public abstract int initLayout();

    /* access modifiers changed from: protected */
    public abstract void initStyleable(Context context, AttributeSet attributeSet);

    /* access modifiers changed from: protected */
    public abstract void initView();

    /* access modifiers changed from: protected */
    public abstract void onViewDraw();

    public BaseRoundCornerProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (isInEditMode()) {
            previewLayout(context);
        } else {
            setup(context, attrs);
        }
    }

    @TargetApi(11)
    public BaseRoundCornerProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (isInEditMode()) {
            previewLayout(context);
        } else {
            setup(context, attrs);
        }
    }

    private void previewLayout(Context context) {
        setGravity(17);
        TextView tv = new TextView(context);
        tv.setLayoutParams(new LayoutParams(-1, -1));
        tv.setGravity(17);
        tv.setText(getClass().getSimpleName());
        tv.setTextColor(-1);
        tv.setBackgroundColor(-7829368);
        addView(tv);
    }

    public void setup(Context context, AttributeSet attrs) {
        setupStyleable(context, attrs);
        removeAllViews();
        LayoutInflater.from(context).inflate(initLayout(), this);
        this.layoutBackground = (LinearLayout) findViewById(R.id.layout_background);
        this.layoutProgress = (LinearLayout) findViewById(R.id.layout_progress);
        this.layoutSecondaryProgress = (LinearLayout) findViewById(R.id.layout_secondary_progress);
        initView();
    }

    public void setupStyleable(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RoundCornerProgress);
        this.radius = (int) typedArray.getDimension(R.styleable.RoundCornerProgress_rcRadius, dp2px(30.0f));
        this.padding = (int) typedArray.getDimension(R.styleable.RoundCornerProgress_rcBackgroundPadding, dp2px(0.0f));
        this.isReverse = typedArray.getBoolean(R.styleable.RoundCornerProgress_rcReverse, false);
        this.max = typedArray.getFloat(R.styleable.RoundCornerProgress_rcMax, 100.0f);
        this.progress = typedArray.getFloat(R.styleable.RoundCornerProgress_rcProgress, 0.0f);
        this.secondaryProgress = typedArray.getFloat(R.styleable.RoundCornerProgress_rcSecondaryProgress, 0.0f);
        this.colorBackground = typedArray.getColor(R.styleable.RoundCornerProgress_rcBackgroundColor, context.getResources().getColor(R.color.round_corner_progress_bar_background_default));
        this.colorProgress = typedArray.getColor(R.styleable.RoundCornerProgress_rcProgressColor, context.getResources().getColor(R.color.round_corner_progress_bar_progress_default));
        this.colorSecondaryProgress = typedArray.getColor(R.styleable.RoundCornerProgress_rcSecondaryProgressColor, context.getResources().getColor(R.color.round_corner_progress_bar_secondary_progress_default));
        typedArray.recycle();
        initStyleable(context, attrs);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int newWidth, int newHeight, int oldWidth, int oldHeight) {
        super.onSizeChanged(newWidth, newHeight, oldWidth, oldHeight);
        if (!isInEditMode()) {
            this.totalWidth = newWidth;
            drawAll();
            postDelayed(new Runnable() {
                public void run() {
                    BaseRoundCornerProgressBar.this.drawPrimaryProgress();
                    BaseRoundCornerProgressBar.this.drawSecondaryProgress();
                }
            }, 5);
        }
    }

    /* access modifiers changed from: protected */
    public void drawAll() {
        drawBackgroundProgress();
        drawPadding();
        drawProgressReverse();
        drawPrimaryProgress();
        drawSecondaryProgress();
        onViewDraw();
    }

    private void drawBackgroundProgress() {
        GradientDrawable backgroundDrawable = createGradientDrawable(this.colorBackground);
        int newRadius = this.radius - (this.padding / 2);
        backgroundDrawable.setCornerRadii(new float[]{(float) newRadius, (float) newRadius, (float) newRadius, (float) newRadius, (float) newRadius, (float) newRadius, (float) newRadius, (float) newRadius});
        if (VERSION.SDK_INT >= 16) {
            this.layoutBackground.setBackground(backgroundDrawable);
        } else {
            this.layoutBackground.setBackgroundDrawable(backgroundDrawable);
        }
    }

    /* access modifiers changed from: protected */
    public GradientDrawable createGradientDrawable(int color) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(color);
        return gradientDrawable;
    }

    /* access modifiers changed from: private */
    public void drawPrimaryProgress() {
        drawProgress(this.layoutProgress, this.max, this.progress, (float) this.totalWidth, this.radius, this.padding, this.colorProgress, this.isReverse);
    }

    /* access modifiers changed from: private */
    public void drawSecondaryProgress() {
        drawProgress(this.layoutSecondaryProgress, this.max, this.secondaryProgress, (float) this.totalWidth, this.radius, this.padding, this.colorSecondaryProgress, this.isReverse);
    }

    private void drawProgressReverse() {
        setupReverse(this.layoutProgress);
        setupReverse(this.layoutSecondaryProgress);
    }

    private void setupReverse(LinearLayout layoutProgress2) {
        RelativeLayout.LayoutParams progressParams = (RelativeLayout.LayoutParams) layoutProgress2.getLayoutParams();
        removeLayoutParamsRule(progressParams);
        if (this.isReverse) {
            progressParams.addRule(11);
            if (VERSION.SDK_INT >= 17) {
                progressParams.addRule(21);
            }
        } else {
            progressParams.addRule(9);
            if (VERSION.SDK_INT >= 17) {
                progressParams.addRule(20);
            }
        }
        layoutProgress2.setLayoutParams(progressParams);
    }

    private void drawPadding() {
        this.layoutBackground.setPadding(this.padding, this.padding, this.padding, this.padding);
    }

    private void removeLayoutParamsRule(RelativeLayout.LayoutParams layoutParams) {
        if (VERSION.SDK_INT >= 17) {
            layoutParams.removeRule(11);
            layoutParams.removeRule(21);
            layoutParams.removeRule(9);
            layoutParams.removeRule(20);
            return;
        }
        layoutParams.addRule(11, 0);
        layoutParams.addRule(9, 0);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"NewApi"})
    public float dp2px(float dp) {
        return (float) Math.round(((float) (getContext().getResources().getDisplayMetrics().densityDpi / 160)) * dp);
    }

    public boolean isReverse() {
        return this.isReverse;
    }

    public void setReverse(boolean isReverse2) {
        this.isReverse = isReverse2;
        drawProgressReverse();
        drawPrimaryProgress();
        drawSecondaryProgress();
    }

    public int getRadius() {
        return this.radius;
    }

    public void setRadius(int radius2) {
        if (radius2 >= 0) {
            this.radius = radius2;
        }
        drawBackgroundProgress();
        drawPrimaryProgress();
        drawSecondaryProgress();
    }

    public int getPadding() {
        return this.padding;
    }

    public void setPadding(int padding2) {
        if (padding2 >= 0) {
            this.padding = padding2;
        }
        drawPadding();
        drawPrimaryProgress();
        drawSecondaryProgress();
    }

    public float getMax() {
        return this.max;
    }

    public void setMax(float max2) {
        if (max2 >= 0.0f) {
            this.max = max2;
        }
        if (this.progress > max2) {
            this.progress = max2;
        }
        drawPrimaryProgress();
        drawSecondaryProgress();
    }

    public float getLayoutWidth() {
        return (float) this.totalWidth;
    }

    public float getProgress() {
        return this.progress;
    }

    public void setProgress(float progress2) {
        if (progress2 < 0.0f) {
            this.progress = 0.0f;
        } else if (progress2 > this.max) {
            this.progress = this.max;
        } else {
            this.progress = progress2;
        }
        drawPrimaryProgress();
        if (this.progressChangedListener != null) {
            this.progressChangedListener.onProgressChanged(getId(), this.progress, true, false);
        }
    }

    public float getSecondaryProgressWidth() {
        if (this.layoutSecondaryProgress != null) {
            return (float) this.layoutSecondaryProgress.getWidth();
        }
        return 0.0f;
    }

    public float getSecondaryProgress() {
        return this.secondaryProgress;
    }

    public void setSecondaryProgress(float secondaryProgress2) {
        if (secondaryProgress2 < 0.0f) {
            this.secondaryProgress = 0.0f;
        } else if (secondaryProgress2 > this.max) {
            this.secondaryProgress = this.max;
        } else {
            this.secondaryProgress = secondaryProgress2;
        }
        drawSecondaryProgress();
        if (this.progressChangedListener != null) {
            this.progressChangedListener.onProgressChanged(getId(), this.secondaryProgress, false, true);
        }
    }

    public int getProgressBackgroundColor() {
        return this.colorBackground;
    }

    public void setProgressBackgroundColor(int colorBackground2) {
        this.colorBackground = colorBackground2;
        drawBackgroundProgress();
    }

    public int getProgressColor() {
        return this.colorProgress;
    }

    public void setProgressColor(int colorProgress2) {
        this.colorProgress = colorProgress2;
        drawPrimaryProgress();
    }

    public int getSecondaryProgressColor() {
        return this.colorSecondaryProgress;
    }

    public void setSecondaryProgressColor(int colorSecondaryProgress2) {
        this.colorSecondaryProgress = colorSecondaryProgress2;
        drawSecondaryProgress();
    }

    public void setOnProgressChangedListener(OnProgressChangedListener listener) {
        this.progressChangedListener = listener;
    }

    public void invalidate() {
        super.invalidate();
        drawAll();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState ss = new SavedState(super.onSaveInstanceState());
        ss.radius = this.radius;
        ss.padding = this.padding;
        ss.colorBackground = this.colorBackground;
        ss.colorProgress = this.colorProgress;
        ss.colorSecondaryProgress = this.colorSecondaryProgress;
        ss.max = this.max;
        ss.progress = this.progress;
        ss.secondaryProgress = this.secondaryProgress;
        ss.isReverse = this.isReverse;
        return ss;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        this.radius = ss.radius;
        this.padding = ss.padding;
        this.colorBackground = ss.colorBackground;
        this.colorProgress = ss.colorProgress;
        this.colorSecondaryProgress = ss.colorSecondaryProgress;
        this.max = ss.max;
        this.progress = ss.progress;
        this.secondaryProgress = ss.secondaryProgress;
        this.isReverse = ss.isReverse;
    }
}
