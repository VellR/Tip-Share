package com.victor.loading.newton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.victor.loading.R;

public class CradleBall extends View {
    private int height;
    private int loadingColor = -1;
    private Paint paint;
    private int width;

    public CradleBall(Context context) {
        super(context);
        initView(null);
    }

    public CradleBall(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(attrs);
    }

    public CradleBall(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(attrs);
    }

    private void initView(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CradleBall);
            this.loadingColor = typedArray.getColor(R.styleable.CradleBall_cradle_ball_color, -1);
            typedArray.recycle();
        }
        this.paint = new Paint();
        this.paint.setColor(this.loadingColor);
        this.paint.setStyle(Style.FILL);
        this.paint.setAntiAlias(true);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.width = w;
        this.height = h;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle((float) (this.width / 2), (float) (this.height / 2), (float) (this.width / 2), this.paint);
    }

    public void setLoadingColor(int color) {
        this.loadingColor = color;
        this.paint.setColor(color);
        postInvalidate();
    }

    public int getLoadingColor() {
        return this.loadingColor;
    }
}
