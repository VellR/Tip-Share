package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaja.zza;

public class zzaix {
    private static final zzajb<Boolean> aWM = new zzajb<Boolean>() {
        /* renamed from: zzf */
        public boolean zzbr(Boolean bool) {
            return !bool.booleanValue();
        }
    };
    private static final zzajb<Boolean> aWN = new zzajb<Boolean>() {
        /* renamed from: zzf */
        public boolean zzbr(Boolean bool) {
            return bool.booleanValue();
        }
    };
    private static final zzaja<Boolean> aWO = new zzaja<>(Boolean.valueOf(true));
    private static final zzaja<Boolean> aWP = new zzaja<>(Boolean.valueOf(false));
    private final zzaja<Boolean> aWL;

    public zzaix() {
        this.aWL = zzaja.zzcsw();
    }

    private zzaix(zzaja<Boolean> zzaja) {
        this.aWL = zzaja;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaix)) {
            return false;
        }
        return this.aWL.equals(((zzaix) obj).aWL);
    }

    public int hashCode() {
        return this.aWL.hashCode();
    }

    public String toString() {
        String valueOf = String.valueOf(this.aWL.toString());
        return new StringBuilder(String.valueOf(valueOf).length() + 14).append("{PruneForest:").append(valueOf).append("}").toString();
    }

    public <T> T zza(T t, final zza<Void, T> zza) {
        return this.aWL.zzb(t, (zza<? super T, R>) new zza<Boolean, T>() {
            public T zza(zzahr zzahr, Boolean bool, T t) {
                return !bool.booleanValue() ? zza.zza(zzahr, null, t) : t;
            }
        });
    }

    public boolean zzcsr() {
        return this.aWL.zzb(aWN);
    }

    public zzaix zzd(zzaka zzaka) {
        zzaja zze = this.aWL.zze(zzaka);
        zzaja zzb = zze == null ? new zzaja((Boolean) this.aWL.getValue()) : (zze.getValue() != null || this.aWL.getValue() == null) ? zze : zze.zzb(zzahr.zzcqy(), (Boolean) this.aWL.getValue());
        return new zzaix(zzb);
    }

    public boolean zzw(zzahr zzahr) {
        Boolean bool = (Boolean) this.aWL.zzah(zzahr);
        return bool != null && bool.booleanValue();
    }

    public boolean zzx(zzahr zzahr) {
        Boolean bool = (Boolean) this.aWL.zzah(zzahr);
        return bool != null && !bool.booleanValue();
    }

    public zzaix zzy(zzahr zzahr) {
        if (this.aWL.zzb(zzahr, aWM) == null) {
            return this.aWL.zzb(zzahr, aWN) != null ? this : new zzaix(this.aWL.zza(zzahr, aWO));
        }
        throw new IllegalArgumentException("Can't prune path that was kept previously!");
    }

    public zzaix zzz(zzahr zzahr) {
        return this.aWL.zzb(zzahr, aWM) != null ? this : new zzaix(this.aWL.zza(zzahr, aWP));
    }
}
