package com.akexorcist.roundcornerprogressbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.akexorcist.roundcornerprogressbar.common.BaseRoundCornerProgressBar;

public class IconRoundCornerProgressBar extends BaseRoundCornerProgressBar implements OnClickListener {
    protected static final int DEFAULT_ICON_PADDING_BOTTOM = 0;
    protected static final int DEFAULT_ICON_PADDING_LEFT = 0;
    protected static final int DEFAULT_ICON_PADDING_RIGHT = 0;
    protected static final int DEFAULT_ICON_PADDING_TOP = 0;
    protected static final int DEFAULT_ICON_SIZE = 20;
    private int colorIconBackground;
    private OnIconClickListener iconClickListener;
    private int iconHeight;
    private int iconPadding;
    private int iconPaddingBottom;
    private int iconPaddingLeft;
    private int iconPaddingRight;
    private int iconPaddingTop;
    private int iconResource;
    private int iconSize;
    private int iconWidth;
    private ImageView ivProgressIcon;

    public interface OnIconClickListener {
        void onIconClick();
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
        int colorIconBackground;
        int iconHeight;
        int iconPadding;
        int iconPaddingBottom;
        int iconPaddingLeft;
        int iconPaddingRight;
        int iconPaddingTop;
        int iconResource;
        int iconSize;
        int iconWidth;

        SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            this.iconResource = in.readInt();
            this.iconSize = in.readInt();
            this.iconWidth = in.readInt();
            this.iconHeight = in.readInt();
            this.iconPadding = in.readInt();
            this.iconPaddingLeft = in.readInt();
            this.iconPaddingRight = in.readInt();
            this.iconPaddingTop = in.readInt();
            this.iconPaddingBottom = in.readInt();
            this.colorIconBackground = in.readInt();
        }

        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(this.iconResource);
            out.writeInt(this.iconSize);
            out.writeInt(this.iconWidth);
            out.writeInt(this.iconHeight);
            out.writeInt(this.iconPadding);
            out.writeInt(this.iconPaddingLeft);
            out.writeInt(this.iconPaddingRight);
            out.writeInt(this.iconPaddingTop);
            out.writeInt(this.iconPaddingBottom);
            out.writeInt(this.colorIconBackground);
        }
    }

    public IconRoundCornerProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public IconRoundCornerProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int initLayout() {
        return R.layout.layout_icon_round_corner_progress_bar;
    }

    /* access modifiers changed from: protected */
    public void initStyleable(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.IconRoundCornerProgress);
        this.iconResource = typedArray.getResourceId(R.styleable.IconRoundCornerProgress_rcIconSrc, R.mipmap.round_corner_progress_icon);
        this.iconSize = (int) typedArray.getDimension(R.styleable.IconRoundCornerProgress_rcIconSize, -1.0f);
        this.iconWidth = (int) typedArray.getDimension(R.styleable.IconRoundCornerProgress_rcIconWidth, dp2px(20.0f));
        this.iconHeight = (int) typedArray.getDimension(R.styleable.IconRoundCornerProgress_rcIconHeight, dp2px(20.0f));
        this.iconPadding = (int) typedArray.getDimension(R.styleable.IconRoundCornerProgress_rcIconPadding, -1.0f);
        this.iconPaddingLeft = (int) typedArray.getDimension(R.styleable.IconRoundCornerProgress_rcIconPaddingLeft, dp2px(0.0f));
        this.iconPaddingRight = (int) typedArray.getDimension(R.styleable.IconRoundCornerProgress_rcIconPaddingRight, dp2px(0.0f));
        this.iconPaddingTop = (int) typedArray.getDimension(R.styleable.IconRoundCornerProgress_rcIconPaddingTop, dp2px(0.0f));
        this.iconPaddingBottom = (int) typedArray.getDimension(R.styleable.IconRoundCornerProgress_rcIconPaddingBottom, dp2px(0.0f));
        this.colorIconBackground = typedArray.getColor(R.styleable.IconRoundCornerProgress_rcIconBackgroundColor, context.getResources().getColor(R.color.round_corner_progress_bar_background_default));
        typedArray.recycle();
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.ivProgressIcon = (ImageView) findViewById(R.id.iv_progress_icon);
        this.ivProgressIcon.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.iv_progress_icon && this.iconClickListener != null) {
            this.iconClickListener.onIconClick();
        }
    }

    public void setOnIconClickListener(OnIconClickListener listener) {
        this.iconClickListener = listener;
    }

    /* access modifiers changed from: protected */
    public void drawProgress(LinearLayout layoutProgress, float max, float progress, float totalWidth, int radius, int padding, int colorProgress, boolean isReverse) {
        GradientDrawable backgroundDrawable = createGradientDrawable(colorProgress);
        int newRadius = radius - (padding / 2);
        if (!isReverse || progress == max) {
            backgroundDrawable.setCornerRadii(new float[]{0.0f, 0.0f, (float) newRadius, (float) newRadius, (float) newRadius, (float) newRadius, 0.0f, 0.0f});
        } else {
            backgroundDrawable.setCornerRadii(new float[]{(float) newRadius, (float) newRadius, (float) newRadius, (float) newRadius, (float) newRadius, (float) newRadius, (float) newRadius, (float) newRadius});
        }
        if (VERSION.SDK_INT >= 16) {
            layoutProgress.setBackground(backgroundDrawable);
        } else {
            layoutProgress.setBackgroundDrawable(backgroundDrawable);
        }
        int progressWidth = (int) ((totalWidth - ((float) ((padding * 2) + this.ivProgressIcon.getWidth()))) / (max / progress));
        LayoutParams progressParams = layoutProgress.getLayoutParams();
        progressParams.width = progressWidth;
        layoutProgress.setLayoutParams(progressParams);
    }

    /* access modifiers changed from: protected */
    public void onViewDraw() {
        drawImageIcon();
        drawImageIconSize();
        drawImageIconPadding();
        drawIconBackgroundColor();
    }

    private void drawImageIcon() {
        this.ivProgressIcon.setImageResource(this.iconResource);
    }

    private void drawImageIconSize() {
        if (this.iconSize == -1) {
            this.ivProgressIcon.setLayoutParams(new LinearLayout.LayoutParams(this.iconWidth, this.iconHeight));
        } else {
            this.ivProgressIcon.setLayoutParams(new LinearLayout.LayoutParams(this.iconSize, this.iconSize));
        }
    }

    private void drawImageIconPadding() {
        if (this.iconPadding == -1 || this.iconPadding == 0) {
            this.ivProgressIcon.setPadding(this.iconPaddingLeft, this.iconPaddingTop, this.iconPaddingRight, this.iconPaddingBottom);
        } else {
            this.ivProgressIcon.setPadding(this.iconPadding, this.iconPadding, this.iconPadding, this.iconPadding);
        }
        this.ivProgressIcon.invalidate();
    }

    private void drawIconBackgroundColor() {
        GradientDrawable iconBackgroundDrawable = createGradientDrawable(this.colorIconBackground);
        int radius = getRadius() - (getPadding() / 2);
        iconBackgroundDrawable.setCornerRadii(new float[]{(float) radius, (float) radius, 0.0f, 0.0f, 0.0f, 0.0f, (float) radius, (float) radius});
        if (VERSION.SDK_INT >= 16) {
            this.ivProgressIcon.setBackground(iconBackgroundDrawable);
        } else {
            this.ivProgressIcon.setBackgroundDrawable(iconBackgroundDrawable);
        }
    }

    public int getIconImageResource() {
        return this.iconResource;
    }

    public void setIconImageResource(int resId) {
        this.iconResource = resId;
        drawImageIcon();
    }

    public int getIconSize() {
        return this.iconSize;
    }

    public void setIconSize(int size) {
        if (size >= 0) {
            this.iconSize = size;
        }
        drawImageIconSize();
    }

    public int getIconPadding() {
        return this.iconPadding;
    }

    public void setIconPadding(int padding) {
        if (padding >= 0) {
            this.iconPadding = padding;
        }
        drawImageIconPadding();
    }

    public int getIconPaddingLeft() {
        return this.iconPaddingLeft;
    }

    public void setIconPaddingLeft(int padding) {
        if (padding > 0) {
            this.iconPaddingLeft = padding;
        }
        drawImageIconPadding();
    }

    public int getIconPaddingRight() {
        return this.iconPaddingRight;
    }

    public void setIconPaddingRight(int padding) {
        if (padding > 0) {
            this.iconPaddingRight = padding;
        }
        drawImageIconPadding();
    }

    public int getIconPaddingTop() {
        return this.iconPaddingTop;
    }

    public void setIconPaddingTop(int padding) {
        if (padding > 0) {
            this.iconPaddingTop = padding;
        }
        drawImageIconPadding();
    }

    public int getIconPaddingBottom() {
        return this.iconPaddingBottom;
    }

    public void setIconPaddingBottom(int padding) {
        if (padding > 0) {
            this.iconPaddingBottom = padding;
        }
        drawImageIconPadding();
    }

    public int getColorIconBackground() {
        return this.colorIconBackground;
    }

    public void setIconBackgroundColor(int color) {
        this.colorIconBackground = color;
        drawIconBackgroundColor();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState ss = new SavedState(super.onSaveInstanceState());
        ss.iconResource = this.iconResource;
        ss.iconSize = this.iconSize;
        ss.iconWidth = this.iconWidth;
        ss.iconHeight = this.iconHeight;
        ss.iconPadding = this.iconPadding;
        ss.iconPaddingLeft = this.iconPaddingLeft;
        ss.iconPaddingRight = this.iconPaddingRight;
        ss.iconPaddingTop = this.iconPaddingTop;
        ss.iconPaddingBottom = this.iconPaddingBottom;
        ss.colorIconBackground = this.colorIconBackground;
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
        this.iconResource = ss.iconResource;
        this.iconSize = ss.iconSize;
        this.iconWidth = ss.iconWidth;
        this.iconHeight = ss.iconHeight;
        this.iconPadding = ss.iconPadding;
        this.iconPaddingLeft = ss.iconPaddingLeft;
        this.iconPaddingRight = ss.iconPaddingRight;
        this.iconPaddingTop = ss.iconPaddingTop;
        this.iconPaddingBottom = ss.iconPaddingBottom;
        this.colorIconBackground = ss.colorIconBackground;
    }
}
