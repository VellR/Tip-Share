package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzd;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class zzrd {
    private static final com.google.android.gms.internal.zzpr.zza<?, ?>[] vt = new com.google.android.gms.internal.zzpr.zza[0];
    private final Map<zzc<?>, zze> tY;
    final Set<com.google.android.gms.internal.zzpr.zza<?, ?>> vu;
    private final zzb vv;

    private static class zza implements DeathRecipient, zzb {
        private final WeakReference<com.google.android.gms.internal.zzpr.zza<?, ?>> vx;
        private final WeakReference<zzd> vy;
        private final WeakReference<IBinder> vz;

        private zza(com.google.android.gms.internal.zzpr.zza<?, ?> zza, zzd zzd, IBinder iBinder) {
            this.vy = new WeakReference<>(zzd);
            this.vx = new WeakReference<>(zza);
            this.vz = new WeakReference<>(iBinder);
        }

        private void zzaqd() {
            com.google.android.gms.internal.zzpr.zza zza = (com.google.android.gms.internal.zzpr.zza) this.vx.get();
            zzd zzd = (zzd) this.vy.get();
            if (!(zzd == null || zza == null)) {
                zzd.remove(zza.zzaog().intValue());
            }
            IBinder iBinder = (IBinder) this.vz.get();
            if (this.vz != null) {
                iBinder.unlinkToDeath(this, 0);
            }
        }

        public void binderDied() {
            zzaqd();
        }

        public void zzh(com.google.android.gms.internal.zzpr.zza<?, ?> zza) {
            zzaqd();
        }
    }

    interface zzb {
        void zzh(com.google.android.gms.internal.zzpr.zza<?, ?> zza);
    }

    public zzrd(zzc<?> zzc, zze zze) {
        this.vu = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
        this.vv = new zzb() {
            public void zzh(com.google.android.gms.internal.zzpr.zza<?, ?> zza) {
                zzrd.this.vu.remove(zza);
                if (zza.zzaog() != null && zzrd.zza(zzrd.this) != null) {
                    zzrd.zza(zzrd.this).remove(zza.zzaog().intValue());
                }
            }
        };
        this.tY = new ArrayMap();
        this.tY.put(zzc, zze);
    }

    public zzrd(Map<zzc<?>, zze> map) {
        this.vu = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
        this.vv = new zzb() {
            public void zzh(com.google.android.gms.internal.zzpr.zza<?, ?> zza) {
                zzrd.this.vu.remove(zza);
                if (zza.zzaog() != null && zzrd.zza(zzrd.this) != null) {
                    zzrd.zza(zzrd.this).remove(zza.zzaog().intValue());
                }
            }
        };
        this.tY = map;
    }

    static /* synthetic */ zzd zza(zzrd zzrd) {
        return null;
    }

    private static void zza(com.google.android.gms.internal.zzpr.zza<?, ?> zza2, zzd zzd, IBinder iBinder) {
        if (zza2.isReady()) {
            zza2.zza((zzb) new zza(zza2, zzd, iBinder));
        } else if (iBinder == null || !iBinder.isBinderAlive()) {
            zza2.zza((zzb) null);
            zza2.cancel();
            zzd.remove(zza2.zzaog().intValue());
        } else {
            zza zza3 = new zza(zza2, zzd, iBinder);
            zza2.zza((zzb) zza3);
            try {
                iBinder.linkToDeath(zza3, 0);
            } catch (RemoteException e) {
                zza2.cancel();
                zzd.remove(zza2.zzaog().intValue());
            }
        }
    }

    public void dump(PrintWriter printWriter) {
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.vu.size());
    }

    public void release() {
        com.google.android.gms.internal.zzpr.zza[] zzaArr;
        for (com.google.android.gms.internal.zzpr.zza zza2 : (com.google.android.gms.internal.zzpr.zza[]) this.vu.toArray(vt)) {
            zza2.zza((zzb) null);
            if (zza2.zzaog() != null) {
                zza2.zzaoo();
                zza(zza2, null, ((zze) this.tY.get(zza2.zzanp())).zzans());
                this.vu.remove(zza2);
            } else if (zza2.zzaos()) {
                this.vu.remove(zza2);
            }
        }
    }

    public void zzaqv() {
        for (com.google.android.gms.internal.zzpr.zza zzaa : (com.google.android.gms.internal.zzpr.zza[]) this.vu.toArray(vt)) {
            zzaa.zzaa(new Status(8, "The connection to Google Play services was lost"));
        }
    }

    public boolean zzaqw() {
        for (com.google.android.gms.internal.zzpr.zza isReady : (com.google.android.gms.internal.zzpr.zza[]) this.vu.toArray(vt)) {
            if (!isReady.isReady()) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public <A extends com.google.android.gms.common.api.Api.zzb> void zzg(com.google.android.gms.internal.zzpr.zza<? extends Result, A> zza2) {
        this.vu.add(zza2);
        zza2.zza(this.vv);
    }
}
