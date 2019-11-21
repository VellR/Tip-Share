package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.MainThread;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.zzab;

class zzr extends BroadcastReceiver {
    static final String ad = zzr.class.getName();
    private boolean ae;
    private boolean af;
    /* access modifiers changed from: private */
    public final zzx aja;

    zzr(zzx zzx) {
        zzab.zzaa(zzx);
        this.aja = zzx;
    }

    private Context getContext() {
        return this.aja.getContext();
    }

    private zzp zzbsz() {
        return this.aja.zzbsz();
    }

    @WorkerThread
    public boolean isRegistered() {
        this.aja.zzwu();
        return this.ae;
    }

    @MainThread
    public void onReceive(Context context, Intent intent) {
        this.aja.zzzg();
        String action = intent.getAction();
        zzbsz().zzbty().zzj("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            final boolean zzadj = this.aja.zzbuo().zzadj();
            if (this.af != zzadj) {
                this.af = zzadj;
                this.aja.zzbsy().zzl(new Runnable() {
                    public void run() {
                        zzr.this.aja.zzas(zzadj);
                    }
                });
                return;
            }
            return;
        }
        zzbsz().zzbtt().zzj("NetworkBroadcastReceiver received unknown action", action);
    }

    @WorkerThread
    public void unregister() {
        this.aja.zzzg();
        this.aja.zzwu();
        if (isRegistered()) {
            zzbsz().zzbty().log("Unregistering connectivity change receiver");
            this.ae = false;
            this.af = false;
            try {
                getContext().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                zzbsz().zzbtr().zzj("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    @WorkerThread
    public void zzadg() {
        this.aja.zzzg();
        this.aja.zzwu();
        if (!this.ae) {
            getContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.af = this.aja.zzbuo().zzadj();
            zzbsz().zzbty().zzj("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.af));
            this.ae = true;
        }
    }
}
