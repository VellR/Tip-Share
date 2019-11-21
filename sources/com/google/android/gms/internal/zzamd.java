package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.util.Log;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzh;
import com.google.firebase.FirebaseApp;
import java.util.Random;

public class zzamd {
    private static Random aJf = new Random();
    static zzamf bdG = new zzamg();
    static zze dF = new zzh();
    private FirebaseApp baF;
    private long bdH;
    private volatile boolean zzak;

    public zzamd(FirebaseApp firebaseApp, long j) {
        this.baF = firebaseApp;
        this.bdH = j;
    }

    public void cancel() {
        this.zzak = true;
    }

    public void reset() {
        this.zzak = false;
    }

    public void zza(@NonNull zzamm zzamm, boolean z) {
        zzab.zzaa(zzamm);
        long elapsedRealtime = dF.elapsedRealtime() + this.bdH;
        if (z) {
            zzamm.zza(zzami.zzh(this.baF), this.baF.getApplicationContext());
        } else {
            zzamm.zzst(zzami.zzh(this.baF));
        }
        int i = 1000;
        while (dF.elapsedRealtime() + ((long) i) <= elapsedRealtime && !zzamm.zzcza() && zzaea(zzamm.getResultCode())) {
            try {
                bdG.zzaeb(aJf.nextInt(Callback.DEFAULT_SWIPE_ANIMATION_DURATION) + i);
                if (i < 30000) {
                    if (zzamm.getResultCode() != -2) {
                        i *= 2;
                        Log.w("ExponenentialBackoff", "network error occurred, backing off/sleeping.");
                    } else {
                        Log.w("ExponenentialBackoff", "network unavailable, sleeping.");
                        i = 1000;
                    }
                }
                if (!this.zzak) {
                    zzamm.reset();
                    if (z) {
                        zzamm.zza(zzami.zzh(this.baF), this.baF.getApplicationContext());
                    } else {
                        zzamm.zzst(zzami.zzh(this.baF));
                    }
                } else {
                    return;
                }
            } catch (InterruptedException e) {
                Log.w("ExponenentialBackoff", "thread interrupted during exponential backoff.");
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    public boolean zzaea(int i) {
        return (i >= 500 && i < 600) || i == -2 || i == 429;
    }

    public void zzd(@NonNull zzamm zzamm) {
        zza(zzamm, true);
    }
}
