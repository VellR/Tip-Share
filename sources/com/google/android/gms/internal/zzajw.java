package com.google.android.gms.internal;

import com.google.android.gms.internal.zzajy.zza;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class zzajw implements zzajy {
    private final Set<String> aYs;
    private final zza aYt;

    public zzajw(zza zza, List<String> list) {
        if (list != null) {
            this.aYs = new HashSet(list);
        } else {
            this.aYs = null;
        }
        this.aYt = zza;
    }

    /* access modifiers changed from: protected */
    public String zza(zza zza, String str, String str2, long j) {
        String valueOf = String.valueOf(new Date(j).toString());
        String valueOf2 = String.valueOf(zza);
        return new StringBuilder(String.valueOf(valueOf).length() + 6 + String.valueOf(valueOf2).length() + String.valueOf(str).length() + String.valueOf(str2).length()).append(valueOf).append(" [").append(valueOf2).append("] ").append(str).append(": ").append(str2).toString();
    }

    /* access modifiers changed from: protected */
    public boolean zza(zza zza, String str) {
        return zza.ordinal() >= this.aYt.ordinal() && (this.aYs == null || zza.ordinal() > zza.DEBUG.ordinal() || this.aYs.contains(str));
    }

    public void zzb(zza zza, String str, String str2, long j) {
        if (zza(zza, str)) {
            String zza2 = zza(zza, str, str2, j);
            switch (zza) {
                case ERROR:
                    zzbp(str, zza2);
                    return;
                case WARN:
                    zzbq(str, zza2);
                    return;
                case INFO:
                    zzbr(str, zza2);
                    return;
                case DEBUG:
                    zzbs(str, zza2);
                    return;
                default:
                    throw new RuntimeException("Should not reach here!");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzbp(String str, String str2) {
        System.err.println(str2);
    }

    /* access modifiers changed from: protected */
    public void zzbq(String str, String str2) {
        System.out.println(str2);
    }

    /* access modifiers changed from: protected */
    public void zzbr(String str, String str2) {
        System.out.println(str2);
    }

    /* access modifiers changed from: protected */
    public void zzbs(String str, String str2) {
        System.out.println(str2);
    }

    public zza zzcpl() {
        return this.aYt;
    }
}
