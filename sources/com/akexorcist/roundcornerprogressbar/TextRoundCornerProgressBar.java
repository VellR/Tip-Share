package com.akexorcist.roundcornerprogressbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.akexorcist.roundcornerprogressbar.common.BaseRoundCornerProgressBar;

public class TextRoundCornerProgressBar extends BaseRoundCornerProgressBar implements OnGlobalLayoutListener {
    protected static final int DEFAULT_TEXT_MARGIN = 10;
    protected static final int DEFAULT_TEXT_SIZE = 16;
    private int colorTextProgress;
    private String textProgress;
    private int textProgressMargin;
    private int textProgressSize;
    private TextView tvProgress;

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        int colorTextProgress;
        String textProgress;
        int textProgressMargin;
        int textProgressSize;

        SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            this.colorTextProgress = in.readInt();
            this.textProgressSize = in.readInt();
            this.textProgressMargin = in.readInt();
            this.textProgress = in.readString();
        }

        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(this.colorTextProgress);
            out.writeInt(this.textProgressSize);
            out.writeInt(this.textProgressMargin);
            out.writeString(this.textProgress);
        }
    }

    public TextRoundCornerProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TextRoundCornerProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /* access modifiers changed from: protected */
    public int initLayout() {
        return R.layout.layout_text_round_corner_progress_bar;
    }

    /* access modifiers changed from: protected */
    public void initStyleable(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TextRoundCornerProgress);
        this.colorTextProgress = typedArray.getColor(R.styleable.TextRoundCornerProgress_rcTextProgressColor, -1);
        this.textProgressSize = (int) typedArray.getDimension(R.styleable.TextRoundCornerProgress_rcTextProgressSize, dp2px(16.0f));
        this.textProgressMargin = (int) typedArray.getDimension(R.styleable.TextRoundCornerProgress_rcTextProgressMargin, dp2px(10.0f));
        this.textProgress = typedArray.getString(R.styleable.TextRoundCornerProgress_rcTextProgress);
        typedArray.recycle();
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.tvProgress = (TextView) findViewById(R.id.tv_progress);
        this.tvProgress.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    /* access modifiers changed from: protected */
    public void drawProgress(LinearLayout layoutProgress, float max, float progress, float totalWidth, int radius, int padding, int colorProgress, boolean isReverse) {
        GradientDrawable backgroundDrawable = createGradientDrawable(colorProgress);
        int newRadius = radius - (padding / 2);
        backgroundDrawable.setCornerRadii(new float[]{(float) newRadius, (float) newRadius, (float) newRadius, (float) newRadius, (float) newRadius, (float) newRadius, (float) newRadius, (float) newRadius});
        if (VERSION.SDK_INT >= 16) {
            layoutProgress.setBackground(backgroundDrawable);
        } else {
            layoutProgress.setBackgroundDrawable(backgroundDrawable);
        }
        int progressWidth = (int) ((totalWidth - ((float) (padding * 2))) / (max / progress));
        LayoutParams progressParams = layoutProgress.getLayoutParams();
        progressParams.width = progressWidth;
        layoutProgress.setLayoutParams(progressParams);
    }

    /* access modifiers changed from: protected */
    public void onViewDraw() {
        drawTextProgress();
        drawTextProgressSize();
        drawTextProgressMargin();
        drawTextProgressPosition();
        drawTextProgressColor();
    }

    private void drawTextProgress() {
        this.tvProgress.setText(this.textProgress);
    }

    private void drawTextProgressColor() {
        this.tvProgress.setTextColor(this.colorTextProgress);
    }

    private void drawTextProgressSize() {
        this.tvProgress.setTextSize(0, (float) this.textProgressSize);
    }

    private void drawTextProgressMargin() {
        MarginLayoutParams params = (MarginLayoutParams) this.tvProgress.getLayoutParams();
        params.setMargins(this.textProgressMargin, 0, this.textProgressMargin, 0);
        this.tvProgress.setLayoutParams(params);
    }

    private void drawTextProgressPosition() {
        clearTextProgressAlign();
        if (this.textProgressMargin + this.tvProgress.getMeasuredWidth() + (getTextProgressMargin() * 2) < ((int) ((getLayoutWidth() - ((float) (getPadding() * 2))) / (getMax() / getProgress())))) {
            alignTextProgressInsideProgress();
        } else {
            alignTextProgressOutsideProgress();
        }
    }

    private void clearTextProgressAlign() {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) this.tvProgress.getLayoutParams();
        params.addRule(5, 0);
        params.addRule(7, 0);
        params.addRule(0, 0);
        params.addRule(1, 0);
        if (VERSION.SDK_INT >= 17) {
            params.removeRule(16);
            params.removeRule(17);
            params.removeRule(18);
            params.removeRule(19);
        }
        this.tvProgress.setLayoutParams(params);
    }

    private void alignTextProgressInsideProgress() {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) this.tvProgress.getLayoutParams();
        if (isReverse()) {
            params.addRule(5, R.id.layout_progress);
            if (VERSION.SDK_INT >= 17) {
                params.addRule(18, R.id.layout_progress);
            }
        } else {
            params.addRule(7, R.id.layout_progress);
            if (VERSION.SDK_INT >= 17) {
                params.addRule(19, R.id.layout_progress);
            }
        }
        this.tvProgress.setLayoutParams(params);
    }

    private void alignTextProgressOutsideProgress() {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) this.tvProgress.getLayoutParams();
        if (isReverse()) {
            params.addRule(0, R.id.layout_progress);
            if (VERSION.SDK_INT >= 17) {
                params.addRule(16, R.id.layout_progress);
            }
        } else {
            params.addRule(1, R.id.layout_progress);
            if (VERSION.SDK_INT >= 17) {
                params.addRule(17, R.id.layout_progress);
            }
        }
        this.tvProgress.setLayoutParams(params);
    }

    public String getProgressText() {
        return this.textProgress;
    }

    public void setProgressText(String text) {
        this.textProgress = text;
        drawTextProgress();
        drawTextProgressPosition();
    }

    public void setProgress(float progress) {
        super.setProgress(progress);
        drawTextProgressPosition();
    }

    public int getTextProgressColor() {
        return this.colorTextProgress;
    }

    public void setTextProgressColor(int color) {
        this.colorTextProgress = color;
        drawTextProgressColor();
    }

    public int getTextProgressSize() {
        return this.textProgressSize;
    }

    public void setTextProgressSize(int size) {
        this.textProgressSize = size;
        drawTextProgressSize();
        drawTextProgressPosition();
    }

    public int getTextProgressMargin() {
        return this.textProgressMargin;
    }

    public void setTextProgressMargin(int margin) {
        this.textProgressMargin = margin;
        drawTextProgressMargin();
        drawTextProgressPosition();
    }

    public void onGlobalLayout() {
        if (VERSION.SDK_INT >= 16) {
            this.tvProgress.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        } else {
            this.tvProgress.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
        drawTextProgressPosition();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState ss = new SavedState(super.onSaveInstanceState());
        ss.colorTextProgress = this.colorTextProgress;
        ss.textProgressSize = this.textProgressSize;
        ss.textProgressMargin = this.textProgressMargin;
        ss.textProgress = this.textProgress;
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
        this.colorTextProgress = ss.colorTextProgress;
        this.textProgressSize = ss.textProgressSize;
        this.textProgressMargin = ss.textProgressMargin;
        this.textProgress = ss.textProgress;
    }
}
