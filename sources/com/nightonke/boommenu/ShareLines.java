package com.nightonke.boommenu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class ShareLines extends View {
    private int line1Color;
    private int line2Color;
    private float lineWidth;
    private float[][] locations;
    private float offset;

    public ShareLines(Context context) {
        this(context, null);
    }

    public ShareLines(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.offset = 1.0f;
        this.lineWidth = 3.0f;
        this.line1Color = -1;
        this.line2Color = -1;
    }

    public void setLocations(float[][] locations2) {
        this.locations = locations2;
    }

    public void setOffset(float offset2) {
        this.offset = Util.getInstance().round(offset2, 2);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(this.line1Color);
        paint.setStrokeWidth(this.lineWidth);
        paint.setAntiAlias(true);
        canvas.drawLine(this.locations[1][0], this.locations[1][1], this.locations[1][0] + ((this.locations[0][0] - this.locations[1][0]) * this.offset), this.locations[1][1] + ((this.locations[0][1] - this.locations[1][1]) * this.offset), paint);
        paint.setColor(this.line2Color);
        canvas.drawLine(this.locations[1][0], this.locations[1][1], this.locations[1][0] + ((this.locations[2][0] - this.locations[1][0]) * this.offset), this.locations[1][1] + ((this.locations[2][1] - this.locations[1][1]) * this.offset), paint);
        super.onDraw(canvas);
    }

    public void setLineWidth(float lineWidth2) {
        this.lineWidth = lineWidth2;
        invalidate();
    }

    public void setLine1Color(int line1Color2) {
        this.line1Color = line1Color2;
        invalidate();
    }

    public void setLine2Color(int line2Color2) {
        this.line2Color = line2Color2;
        invalidate();
    }
}
