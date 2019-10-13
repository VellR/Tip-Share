package com.akexorcist.roundcornerprogressbar;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.akexorcist.roundcornerprogressbar.common.BaseRoundCornerProgressBar;

public class RoundCornerProgressBar extends BaseRoundCornerProgressBar {
    public RoundCornerProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundCornerProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int initLayout() {
        return R.layout.layout_round_corner_progress_bar;
    }

    /* access modifiers changed from: protected */
    public void initStyleable(Context context, AttributeSet attrs) {
    }

    /* access modifiers changed from: protected */
    public void initView() {
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
    }
}
