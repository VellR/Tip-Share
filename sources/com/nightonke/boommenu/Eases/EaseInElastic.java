package com.nightonke.boommenu.Eases;

public class EaseInElastic extends CubicBezier {
    public float getOffset(float t) {
        if (t == 0.0f) {
            return 0.0f;
        }
        float t2 = t / 1.0f;
        if (t2 == 1.0f) {
            return 0.0f + 1.0f;
        }
        float p = 1.0f * 0.3f;
        float t3 = t2 - 1.0f;
        return 0.0f + (-(((float) Math.pow(2.0d, (double) (10.0f * t3))) * 1.0f * ((float) Math.sin((double) ((((t3 * 1.0f) - (p / 4.0f)) * 6.2831855f) / p)))));
    }
}
