package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.MainThread;
import com.google.android.gms.measurement.internal.zzu;

public final class AppMeasurementReceiver extends BroadcastReceiver {
    private zzu aje;

    private zzu zzbql() {
        if (this.aje == null) {
            this.aje = new zzu();
        }
        return this.aje;
    }

    @MainThread
    public void onReceive(Context context, Intent intent) {
        zzbql().onReceive(context, intent);
    }
}
