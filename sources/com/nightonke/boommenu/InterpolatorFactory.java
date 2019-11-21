package com.nightonke.boommenu;

import android.view.animation.Interpolator;
import com.nightonke.boommenu.Eases.EaseType;

public class InterpolatorFactory {

    public static class BLVInterpolator implements Interpolator {
        private EaseType easeType;

        public BLVInterpolator(EaseType easeType2) {
            this.easeType = easeType2;
        }

        public float getInterpolation(float input) {
            return this.easeType.getOffset(input);
        }
    }

    public static BLVInterpolator getInterpolator(EaseType easeType) {
        return new BLVInterpolator(easeType);
    }
}
