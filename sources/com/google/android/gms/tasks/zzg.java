package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.Queue;

class zzg<TResult> {
    private Queue<zzf<TResult>> aDL;
    private boolean aDM;
    private final Object zzail = new Object();

    zzg() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0011, code lost:
        r1 = r2.zzail;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r0 = (com.google.android.gms.tasks.zzf) r2.aDL.poll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001c, code lost:
        if (r0 != null) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001e, code lost:
        r2.aDM = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0021, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x002a, code lost:
        r0.onComplete(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return;
     */
    public void zza(@NonNull Task<TResult> task) {
        synchronized (this.zzail) {
            if (this.aDL != null && !this.aDM) {
                this.aDM = true;
            }
        }
    }

    public void zza(@NonNull zzf<TResult> zzf) {
        synchronized (this.zzail) {
            if (this.aDL == null) {
                this.aDL = new ArrayDeque();
            }
            this.aDL.add(zzf);
        }
    }
}
