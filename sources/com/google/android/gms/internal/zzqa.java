package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.internal.zzpr.zza;

public class zzqa implements zzqe {
    /* access modifiers changed from: private */
    public final zzqf tm;
    private boolean tn = false;

    public zzqa(zzqf zzqf) {
        this.tm = zzqf;
    }

    /* JADX WARNING: type inference failed for: r0v8, types: [com.google.android.gms.common.api.Api$zzg] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    private <A extends zzb> void zzf(zza<? extends Result, A> zza) throws DeadObjectException {
        this.tm.sX.ue.zzg(zza);
        zze zzb = this.tm.sX.zzb(zza.zzanp());
        if (zzb.isConnected() || !this.tm.un.containsKey(zza.zzanp())) {
            if (zzb instanceof zzah) {
                zzb = ((zzah) zzb).zzatj();
            }
            zza.zzb(zzb);
            return;
        }
        zza.zzz(new Status(17));
    }

    public void begin() {
    }

    public void connect() {
        if (this.tn) {
            this.tn = false;
            this.tm.zza((zza) new zza(this) {
                public void zzapi() {
                    zzqa.this.tm.ur.zzm(null);
                }
            });
        }
    }

    public boolean disconnect() {
        if (this.tn) {
            return false;
        }
        if (this.tm.sX.zzapu()) {
            this.tn = true;
            for (zzrc zzaqt : this.tm.sX.ud) {
                zzaqt.zzaqt();
            }
            return false;
        }
        this.tm.zzi(null);
        return true;
    }

    public void onConnected(Bundle bundle) {
    }

    public void onConnectionSuspended(int i) {
        this.tm.zzi(null);
        this.tm.ur.zzc(i, this.tn);
    }

    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
    }

    /* access modifiers changed from: 0000 */
    public void zzaph() {
        if (this.tn) {
            this.tn = false;
            this.tm.sX.ue.release();
            disconnect();
        }
    }

    public <A extends zzb, R extends Result, T extends zza<R, A>> T zzc(T t) {
        return zzd(t);
    }

    public <A extends zzb, T extends zza<? extends Result, A>> T zzd(T t) {
        try {
            zzf(t);
        } catch (DeadObjectException e) {
            this.tm.zza((zza) new zza(this) {
                public void zzapi() {
                    zzqa.this.onConnectionSuspended(1);
                }
            });
        }
        return t;
    }
}
