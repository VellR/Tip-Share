package com.victor.loading.book;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.victor.loading.R;

public class PageView extends View {
    private int border;
    private int height;
    private float padding;
    private Paint paint;
    private Path path;
    private int width;

    public PageView(Context context) {
        super(context);
        initView();
    }

    public PageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public PageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        this.padding = getResources().getDimension(R.dimen.book_padding);
        this.border = getResources().getDimensionPixelOffset(R.dimen.book_border);
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(getResources().getDimension(R.dimen.page_border));
        this.path = new Path();
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
        this.paint.setColor(getResources().getColor(R.color.book_loading_book));
        this.paint.setStyle(Style.STROKE);
        float offset = (float) (this.border / 4);
        this.path.moveTo((float) (this.width / 2), this.padding + offset);
        this.path.lineTo((((float) this.width) - this.padding) - offset, this.padding + offset);
        this.path.lineTo((((float) this.width) - this.padding) - offset, (((float) this.height) - this.padding) - offset);
        this.path.lineTo((float) (this.width / 2), (((float) this.height) - this.padding) - offset);
        canvas.drawPath(this.path, this.paint);
        this.paint.setColor(getResources().getColor(R.color.book_loading_page));
        this.paint.setStyle(Style.FILL);
        float offset2 = (float) (this.border / 2);
        canvas.drawRect((float) (this.width / 2), this.padding + offset2, (((float) this.width) - this.padding) - offset2, (((float) this.height) - this.padding) - offset2, this.paint);
    }
}
