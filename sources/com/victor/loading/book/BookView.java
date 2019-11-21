package com.victor.loading.book;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.victor.loading.R;

public class BookView extends View {
    private int height;
    private Paint paint;
    private int width;

    public BookView(Context context) {
        super(context);
        initView();
    }

    public BookView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public BookView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.width = w;
        this.height = h;
    }

    private void initView() {
        this.paint = new Paint();
        this.paint.setColor(getResources().getColor(R.color.book_loading_book));
        this.paint.setStrokeWidth(getResources().getDimension(R.dimen.book_border));
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Style.STROKE);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(0.0f, 0.0f, (float) this.width, (float) this.height, this.paint);
    }
}
