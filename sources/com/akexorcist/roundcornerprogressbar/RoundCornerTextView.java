package com.akexorcist.roundcornerprogressbar;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class RoundCornerTextView extends TextView {
    private OnSizeChangedListener sizeChangedListener;

    public interface OnSizeChangedListener {
        void onTextViewSizeChanged(TextView textView);
    }

    public RoundCornerTextView(Context context) {
        super(context);
    }

    public RoundCornerTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundCornerTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(21)
    public RoundCornerTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int newWidth, int newHeight, int oldWidth, int oldHeight) {
        super.onSizeChanged(newWidth, newHeight, oldWidth, oldHeight);
        if (this.sizeChangedListener != null) {
            this.sizeChangedListener.onTextViewSizeChanged(this);
        }
    }

    public void setOnSizeChangedListener(OnSizeChangedListener listener) {
        this.sizeChangedListener = listener;
    }
}
