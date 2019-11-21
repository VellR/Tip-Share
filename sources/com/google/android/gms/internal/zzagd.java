package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.zzahg.zzb;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseApp.zza;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public class zzagd implements zzahg {
    /* access modifiers changed from: private */
    public final ScheduledExecutorService aPL;
    private final FirebaseApp aPM;

    public zzagd(@NonNull FirebaseApp firebaseApp, @NonNull ScheduledExecutorService scheduledExecutorService) {
        this.aPM = firebaseApp;
        this.aPL = scheduledExecutorService;
    }

    public void zza(final zzb zzb) {
        this.aPM.zza((zza) new zza() {
            public void zzb(@NonNull zzalt zzalt, @Nullable FirebaseUser firebaseUser) {
                zzagd.this.aPL.execute(new Runnable() {
                    public void run() {
                        zzb.zzcpt();
                    }
                });
            }
        });
    }

    public void zza(boolean z, @NonNull final zzahg.zza zza) {
        this.aPM.getToken(z).addOnSuccessListener((Executor) this.aPL, (OnSuccessListener<? super TResult>) new OnSuccessListener<GetTokenResult>() {
            /* renamed from: zza */
            public void onSuccess(GetTokenResult getTokenResult) {
                zza.zzqy(getTokenResult.getToken());
            }
        }).addOnFailureListener((Executor) this.aPL, (OnFailureListener) new OnFailureListener() {
            private boolean zza(Exception exc) {
                return (exc instanceof FirebaseApiNotAvailableException) || (exc instanceof zzalu);
            }

            public void onFailure(@NonNull Exception exc) {
                if (zza(exc)) {
                    zza.zzqy(null);
                } else {
                    zza.onError(exc.getMessage());
                }
            }
        });
    }
}
