package com.google.android.gms.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.MainThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;

public abstract class zzps extends zzqo implements OnCancelListener {
    protected boolean mStarted;
    protected final GoogleApiAvailability rX;
    protected boolean sB;
    /* access modifiers changed from: private */
    public ConnectionResult sC;
    /* access modifiers changed from: private */
    public int sD;
    private final Handler sE;

    private class zza implements Runnable {
        private zza() {
        }

        @MainThread
        public void run() {
            if (zzps.this.mStarted) {
                if (zzps.this.sC.hasResolution()) {
                    zzps.this.va.startActivityForResult(GoogleApiActivity.zzb(zzps.this.getActivity(), zzps.this.sC.getResolution(), zzps.this.sD, false), 1);
                } else if (zzps.this.rX.isUserResolvableError(zzps.this.sC.getErrorCode())) {
                    zzps.this.rX.zza(zzps.this.getActivity(), zzps.this.va, zzps.this.sC.getErrorCode(), 2, zzps.this);
                } else if (zzps.this.sC.getErrorCode() == 18) {
                    final Dialog zza = zzps.this.rX.zza(zzps.this.getActivity(), (OnCancelListener) zzps.this);
                    zzps.this.rX.zza(zzps.this.getActivity().getApplicationContext(), (com.google.android.gms.internal.zzqj.zza) new com.google.android.gms.internal.zzqj.zza() {
                        public void zzaor() {
                            zzps.this.zzaoq();
                            if (zza.isShowing()) {
                                zza.dismiss();
                            }
                        }
                    });
                } else {
                    zzps.this.zza(zzps.this.sC, zzps.this.sD);
                }
            }
        }
    }

    protected zzps(zzqp zzqp) {
        this(zzqp, GoogleApiAvailability.getInstance());
    }

    zzps(zzqp zzqp, GoogleApiAvailability googleApiAvailability) {
        super(zzqp);
        this.sD = -1;
        this.sE = new Handler(Looper.getMainLooper());
        this.rX = googleApiAvailability;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        boolean z = true;
        switch (i) {
            case 1:
                if (i2 != -1) {
                    if (i2 == 0) {
                        this.sC = new ConnectionResult(intent != null ? intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13) : 13, null);
                    }
                }
                break;
            case 2:
                int isGooglePlayServicesAvailable = this.rX.isGooglePlayServicesAvailable(getActivity());
                if (isGooglePlayServicesAvailable != 0) {
                    z = false;
                }
                if (this.sC.getErrorCode() == 18 && isGooglePlayServicesAvailable == 18) {
                    return;
                }
            default:
                z = false;
                break;
        }
        if (z) {
            zzaoq();
        } else {
            zza(this.sC, this.sD);
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
        zza(new ConnectionResult(13, null), this.sD);
        zzaoq();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.sB = bundle.getBoolean("resolving_error", false);
            if (this.sB) {
                this.sD = bundle.getInt("failed_client_id", -1);
                this.sC = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution"));
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("resolving_error", this.sB);
        if (this.sB) {
            bundle.putInt("failed_client_id", this.sD);
            bundle.putInt("failed_status", this.sC.getErrorCode());
            bundle.putParcelable("failed_resolution", this.sC.getResolution());
        }
    }

    public void onStart() {
        super.onStart();
        this.mStarted = true;
    }

    public void onStop() {
        super.onStop();
        this.mStarted = false;
    }

    /* access modifiers changed from: protected */
    public abstract void zza(ConnectionResult connectionResult, int i);

    /* access modifiers changed from: protected */
    public abstract void zzaol();

    /* access modifiers changed from: protected */
    public void zzaoq() {
        this.sD = -1;
        this.sB = false;
        this.sC = null;
        zzaol();
    }

    public void zzb(ConnectionResult connectionResult, int i) {
        if (!this.sB) {
            this.sB = true;
            this.sD = i;
            this.sC = connectionResult;
            this.sE.post(new zza());
        }
    }
}
