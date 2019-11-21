package com.google.android.gms.internal;

import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.api.zzb;
import java.util.Set;

public final class zzpq extends zzpt<zzb> {
    private int sx;
    private boolean sy;

    private void zza(ConnectionResult connectionResult) {
        ArrayMap arrayMap = null;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayMap.size()) {
                zza((zzpo) arrayMap.keyAt(i2), connectionResult);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public void zza(zzpo<?> zzpo, ConnectionResult connectionResult) {
        synchronized (0) {
            ArrayMap arrayMap = null;
            try {
                arrayMap.put(zzpo, connectionResult);
                this.sx--;
                if (!connectionResult.isSuccess()) {
                    this.sy = true;
                }
                if (this.sx == 0) {
                    Status status = this.sy ? new Status(13) : Status.sg;
                    ArrayMap arrayMap2 = null;
                    zzc(arrayMap2.size() == 1 ? new zza(status, null) : new zzb(status, null));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Set<zzpo<?>> zzaon() {
        ArrayMap arrayMap = null;
        return arrayMap.keySet();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    /* renamed from: zzy */
    public zzb zzc(Status status) {
        zzb zzb;
        synchronized (0) {
            try {
                zza(new ConnectionResult(8));
                ArrayMap arrayMap = null;
                zzb = arrayMap.size() == 1 ? new zza(status, null) : new zzb(status, null);
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzb;
    }
}
