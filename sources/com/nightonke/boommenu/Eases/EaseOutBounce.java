package com.nightonke.boommenu.Eases;

public class EaseOutBounce extends CubicBezier {
    public float getOffset(float t) {
        float t2 = t / 1.0f;
        if (t2 < 0.36363637f) {
            return (7.5625f * t2 * t2 * 1.0f) + 0.0f;
        }
        if (t2 < 0.72727275f) {
            float t3 = t2 - 0.54545456f;
            return (((7.5625f * t3 * t3) + 0.75f) * 1.0f) + 0.0f;
        } else if (((double) t2) < 0.9090909090909091d) {
            float t4 = t2 - 0.8181818f;
            return (((7.5625f * t4 * t4) + 0.9375f) * 1.0f) + 0.0f;
        } else {
            float t5 = t2 - 0.95454544f;
            return (((7.5625f * t5 * t5) + 0.984375f) * 1.0f) + 0.0f;
        }
    }
}
