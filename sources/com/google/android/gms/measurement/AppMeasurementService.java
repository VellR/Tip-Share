package com.google.android.gms.measurement;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.MainThread;
import com.google.android.gms.measurement.internal.zzae;
import com.google.android.gms.measurement.internal.zzae.zza;

public final class AppMeasurementService extends Service implements zza {
    private zzae ajf;

    private zzae zzbqm() {
        if (this.ajf == null) {
            this.ajf = new zzae(this);
        }
        return this.ajf;
    }

    public boolean callServiceStopSelfResult(int i) {
        return stopSelfResult(i);
    }

    public Context getContext() {
        return this;
    }

    @MainThread
    public IBinder onBind(Intent intent) {
        return zzbqm().onBind(intent);
    }

    @MainThread
    public void onCreate() {
        super.onCreate();
        zzbqm().onCreate();
    }

    @MainThread
    public void onDestroy() {
        zzbqm().onDestroy();
        super.onDestroy();
    }

    @MainThread
    public void onRebind(Intent intent) {
        zzbqm().onRebind(intent);
    }

    @MainThread
    public int onStartCommand(Intent intent, int i, int i2) {
        return zzbqm().onStartCommand(intent, i, i2);
    }

    @MainThread
    public boolean onUnbind(Intent intent) {
        return zzbqm().onUnbind(intent);
    }
}
