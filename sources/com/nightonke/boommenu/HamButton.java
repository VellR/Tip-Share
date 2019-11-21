package com.nightonke.boommenu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.nightonke.boommenu.Types.ClickEffectType;

public class HamButton extends FrameLayout {
    private ClickEffectType clickEffectType;
    private FrameLayout frameLayout;
    private int height;
    private ImageView imageView;
    /* access modifiers changed from: private */
    public int index;
    private Context mContext;
    /* access modifiers changed from: private */
    public OnHamButtonClickListener onHamButtonClickListener;
    private View ripple;
    private ShadowLayout shadowLayout;
    private TextView textView;
    private int width;

    public interface OnHamButtonClickListener {
        void onClick(int i);
    }

    public HamButton(Context context) {
        this(context, null);
    }

    public HamButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.clickEffectType = ClickEffectType.RIPPLE;
        this.width = 0;
        this.height = (int) Util.getInstance().dp2px(66.0f);
        this.mContext = context;
        if (VERSION.SDK_INT >= 21) {
            LayoutInflater.from(this.mContext).inflate(R.layout.ham_button, this, true);
        } else {
            LayoutInflater.from(this.mContext).inflate(R.layout.ham_button_below_lollipop, this, true);
        }
        this.shadowLayout = (ShadowLayout) findViewById(R.id.shadow_layout);
        this.frameLayout = (FrameLayout) findViewById(R.id.frame_layout);
        this.ripple = findViewById(R.id.ripple);
        this.imageView = (ImageView) findViewById(R.id.image);
        this.textView = (TextView) findViewById(R.id.text);
        this.width = (Util.getInstance().getScreenWidth(getContext()) * 8) / 9;
        this.height = (int) Util.getInstance().dp2px(66.0f);
        LayoutParams layoutParams = (LayoutParams) this.frameLayout.getLayoutParams();
        layoutParams.width = this.width - ((int) Util.getInstance().dp2px(8.0f));
        this.frameLayout.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams1 = this.shadowLayout.getLayoutParams();
        layoutParams1.width = this.width;
        layoutParams1.height = this.height + ((int) Util.getInstance().dp2px(4.0f));
        this.shadowLayout.setLayoutParams(layoutParams1);
    }

    public void setOnHamButtonClickListener(OnHamButtonClickListener onHamButtonClickListener2, int index2) {
        this.onHamButtonClickListener = onHamButtonClickListener2;
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

    public ImageView getImageView() {
        return this.imageView;
    }

    public TextView getTextView() {
        return this.textView;
    }

    public ShadowLayout getShadowLayout() {
        return this.shadowLayout;
    }

    public void setRipple(ClickEffectType clickEffectType2) {
        this.clickEffectType = clickEffectType2;
        if (VERSION.SDK_INT < 21 || !clickEffectType2.equals(ClickEffectType.RIPPLE)) {
            this.ripple.setVisibility(8);
            this.frameLayout.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    HamButton.this.onHamButtonClickListener.onClick(HamButton.this.index);
                }
            });
            return;
        }
        this.ripple.setVisibility(0);
        this.ripple.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                HamButton.this.onHamButtonClickListener.onClick(HamButton.this.index);
            }
        });
    }

    public void setColor(int pressedColor, int normalColor) {
        Util.getInstance().setHamButtonStateListDrawable(this.frameLayout, this.width, this.height, pressedColor, normalColor);
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
