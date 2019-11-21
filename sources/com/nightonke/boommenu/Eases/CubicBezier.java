package com.nightonke.boommenu.Eases;

import android.graphics.PointF;

public abstract class CubicBezier {
    private PointF a = new PointF();
    private PointF b = new PointF();
    private PointF c = new PointF();
    private PointF end;
    private PointF start;

    public void init(float startX, float startY, float endX, float endY) {
        setStart(new PointF(startX, startY));
        setEnd(new PointF(endX, endY));
    }

    public void init(double startX, double startY, double endX, double endY) {
        init((float) startX, (float) startY, (float) endX, (float) endY);
    }

    public float getOffset(float offset) {
        return getBezierCoordinateY(getXForTime(offset));
    }

    private float getBezierCoordinateY(float time) {
        this.c.y = this.start.y * 3.0f;
        this.b.y = ((this.end.y - this.start.y) * 3.0f) - this.c.y;
        this.a.y = (1.0f - this.c.y) - this.b.y;
        return (this.c.y + ((this.b.y + (this.a.y * time)) * time)) * time;
    }

    private float getXForTime(float time) {
        float x = time;
        for (int i = 1; i < 14; i++) {
            float z = getBezierCoordinateX(x) - time;
            if (((double) Math.abs(z)) < 0.001d) {
                break;
            }
            x -= z / getXDerivate(x);
        }
        return x;
    }

    private float getXDerivate(float t) {
        return this.c.x + (((2.0f * this.b.x) + (3.0f * this.a.x * t)) * t);
    }

    private float getBezierCoordinateX(float time) {
        this.c.x = this.start.x * 3.0f;
        this.b.x = ((this.end.x - this.start.x) * 3.0f) - this.c.x;
        this.a.x = (1.0f - this.c.x) - this.b.x;
        return (this.c.x + ((this.b.x + (this.a.x * time)) * time)) * time;
    }

    public PointF getStart() {
        return this.start;
    }

    public void setStart(PointF start2) {
        this.start = start2;
    }

    public PointF getEnd() {
        return this.end;
    }

    public void setEnd(PointF end2) {
        this.end = end2;
    }
}
