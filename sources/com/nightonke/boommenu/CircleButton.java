package com.nightonke.boommenu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.nightonke.boommenu.Types.ClickEffectType;

public class CircleButton extends FrameLayout {
    private ClickEffectType clickEffectType;
    private FrameLayout frameLayout;
    private ImageButton imageButton;
    private ImageView imageView;
    /* access modifiers changed from: private */
    public int index;
    private Context mContext;
    /* access modifiers changed from: private */
    public OnCircleButtonClickListener onCircleButtonClickListener;
    private int radius;
    private View ripple;
    private ShadowLayout shadowLayout;
    private TextView textView;

    public interface OnCircleButtonClickListener {
        void onClick(int i);
    }

    public CircleButton(Context context) {
        this(context, null);
    }

    public CircleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.clickEffectType = ClickEffectType.RIPPLE;
        this.radius = ((int) Util.getInstance().dp2px(80.0f)) / 2;
        this.mContext = context;
        if (VERSION.SDK_INT >= 21) {
            LayoutInflater.from(this.mContext).inflate(R.layout.circle_button, this, true);
        } else {
            LayoutInflater.from(this.mContext).inflate(R.layout.circle_button_below_lollipop, this, true);
        }
        this.shadowLayout = (ShadowLayout) findViewById(R.id.shadow_layout);
        this.frameLayout = (FrameLayout) findViewById(R.id.frame_layout);
        this.imageButton = (ImageButton) findViewById(R.id.image_button);
        this.ripple = findViewById(R.id.ripple);
        this.imageView = (ImageView) findViewById(R.id.image_view);
        this.textView = (TextView) findViewById(R.id.text);
    }

    public void setOnCircleButtonClickListener(OnCircleButtonClickListener onCircleButtonClickListener2, int index2) {
        this.onCircleButtonClickListener = onCircleButtonClickListener2;
        this.index = index2;
        setRipple(this.clickEffectType);
    }

    public void setDrawable(Drawable drawable) {
        if (this.imageView != null) {
            this.imageView.setImageDrawable(drawable);
        }
    }

    public void setText(String text) {
        if (this.textView != null) {
            this.textView.setText(text);
        }
    }

    public FrameLayout getFrameLayout() {
        return this.frameLayout;
    }

    public ImageButton getImageButton() {
        return this.imageButton;
    }

    public ImageView getImageView() {
        return this.imageView;
    }

    public ShadowLayout getShadowLayout() {
        return this.shadowLayout;
    }

    public TextView getTextView() {
        return this.textView;
    }

    public void setColor(int pressedColor, int normalColor) {
        Util.getInstance().setCircleButtonStateListDrawable(this.imageButton, this.radius, pressedColor, normalColor);
    }

    public void setRipple(ClickEffectType clickEffectType2) {
        this.clickEffectType = clickEffectType2;
        if (VERSION.SDK_INT < 21 || !clickEffectType2.equals(ClickEffectType.RIPPLE)) {
            this.ripple.setVisibility(8);
            this.imageButton.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    CircleButton.this.onCircleButtonClickListener.onClick(CircleButton.this.index);
                }
            });
            return;
        }
        this.ripple.setVisibility(0);
        this.ripple.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                CircleButton.this.onCircleButtonClickListener.onClick(CircleButton.this.index);
            }
        });
    }

    public void setShadowColor(int mShadowColor) {
        this.shadowLayout.setShadowColor(mShadowColor);
    }

    public void setShadowDx(float mDx) {
        this.shadowLayout.setmDx(mDx);
    }

    public void setShadowDy(float mDy) {
        this.shadowLayout.setmDy(mDy);
    }
}
