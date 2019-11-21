package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

public class zzaiu implements zzaiv {
    private boolean aPZ = false;

    private void zzcna() {
        zzalo.zzb(this.aPZ, "Transaction expected to already be in progress.");
    }

    public void zza(zzahr zzahr, zzahi zzahi, long j) {
        zzcna();
    }

    public void zza(zzahr zzahr, zzakm zzakm, long j) {
        zzcna();
    }

    public void zza(zzajm zzajm, zzakm zzakm) {
        zzcna();
    }

    public void zza(zzajm zzajm, Set<zzaka> set) {
        zzcna();
    }

    public void zza(zzajm zzajm, Set<zzaka> set, Set<zzaka> set2) {
        zzcna();
    }

    public void zzbv(long j) {
        zzcna();
    }

    public void zzc(zzahr zzahr, zzahi zzahi) {
        zzcna();
    }

    public List<zzaif> zzcmw() {
        return Collections.emptyList();
    }

    public void zzcmz() {
        zzcna();
    }

    public void zzd(zzahr zzahr, zzahi zzahi) {
        zzcna();
    }

    public zzaje zzf(zzajm zzajm) {
        return new zzaje(zzakh.zza(zzakf.zzcvi(), zzajm.zzcts()), false, false);
    }

    public <T> T zzf(Callable<T> callable) {
        zzalo.zzb(!this.aPZ, "runInTransaction called when an existing transaction is already in progress.");
        this.aPZ = true;
        try {
            T call = callable.call();
            this.aPZ = false;
            return call;
        } catch (Throwable th) {
            this.aPZ = false;
            throw th;
        }
    }

    public void zzg(zzajm zzajm) {
        zzcna();
    }

    public void zzh(zzajm zzajm) {
        zzcna();
    }

    public void zzi(zzajm zzajm) {
        zzcna();
    }

    public void zzk(zzahr zzahr, zzakm zzakm) {
        zzcna();
    }
}
