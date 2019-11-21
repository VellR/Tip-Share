package com.google.android.gms.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzab;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.api.model.CreateAuthUriResponse;
import com.google.firebase.auth.api.model.GetAccountInfoUser;
import com.google.firebase.auth.api.model.GetTokenResponse;

abstract class zzafo<SuccessT, CallbackT> {
    private boolean aDQ;
    protected final int aNJ;
    protected final zza aNK = new zza();
    protected FirebaseUser aNL;
    protected zzafk aNM;
    protected CallbackT aNN;
    protected zzafn<SuccessT> aNO;
    protected GetTokenResponse aNP;
    protected GetAccountInfoUser aNQ;
    protected CreateAuthUriResponse aNR;
    boolean aNS;
    SuccessT aNT;
    Status aNU;
    protected FirebaseApp aNi;

    private class zza extends com.google.android.gms.internal.zzafj.zza {
        private zza() {
        }

        public void onFailure(@NonNull Status status) throws RemoteException {
            zzafo.this.zzet(status);
        }

        public void zza(@NonNull CreateAuthUriResponse createAuthUriResponse) throws RemoteException {
            zzab.zza(zzafo.this.aNJ == 3, (Object) "Unexpected response type " + zzafo.this.aNJ);
            zzafo.this.aNR = createAuthUriResponse;
            zzafo.this.zzclf();
        }

        public void zza(@NonNull GetTokenResponse getTokenResponse) throws RemoteException {
            boolean z = true;
            if (zzafo.this.aNJ != 1) {
                z = false;
            }
            zzab.zza(z, (Object) "Unexpected response type: " + zzafo.this.aNJ);
            zzafo.this.aNP = getTokenResponse;
            zzafo.this.zzclf();
        }

        public void zza(@NonNull GetTokenResponse getTokenResponse, @NonNull GetAccountInfoUser getAccountInfoUser) throws RemoteException {
            zzab.zza(zzafo.this.aNJ == 2, (Object) "Unexpected response type: " + zzafo.this.aNJ);
            zzafo.this.aNP = getTokenResponse;
            zzafo.this.aNQ = getAccountInfoUser;
            zzafo.this.zzclf();
        }

        public void zzclb() throws RemoteException {
            zzab.zza(zzafo.this.aNJ == 4, (Object) "Unexpected response type " + zzafo.this.aNJ);
            zzafo.this.zzclf();
        }

        public void zzclc() throws RemoteException {
            zzab.zza(zzafo.this.aNJ == 5, (Object) "Unexpected response type " + zzafo.this.aNJ);
            zzafo.this.zzclf();
        }
    }

    public zzafo(int i) {
        this.aNJ = i;
    }

    /* access modifiers changed from: private */
    public void zzclf() {
        zzcky();
        zzab.zza(this.aDQ, (Object) "no success or failure set on method implementation");
    }

    /* access modifiers changed from: protected */
    public abstract void dispatch() throws RemoteException;

    public zzafo<SuccessT, CallbackT> zza(zzafn<SuccessT> zzafn) {
        this.aNO = zzafn;
        return this;
    }

    public void zza(zzafk zzafk) throws RemoteException {
        this.aNM = zzafk;
        dispatch();
    }

    public zzafo<SuccessT, CallbackT> zzbc(CallbackT callbackt) {
        this.aNN = zzab.zzb(callbackt, (Object) "external callback cannot be null");
        return this;
    }

    public void zzbd(SuccessT successt) {
        this.aDQ = true;
        this.aNS = true;
        this.aNT = successt;
        this.aNO.zza(successt, null);
    }

    public abstract void zzcky();

    public void zzcle() {
        zzbd(null);
    }

    public zzafo<SuccessT, CallbackT> zzd(FirebaseApp firebaseApp) {
        this.aNi = (FirebaseApp) zzab.zzb(firebaseApp, (Object) "firebaseApp cannot be null");
        return this;
    }

    public zzafo<SuccessT, CallbackT> zzd(FirebaseUser firebaseUser) {
        this.aNL = (FirebaseUser) zzab.zzb(firebaseUser, (Object) "firebaseUser cannot be null");
        return this;
    }

    public void zzet(Status status) {
        this.aDQ = true;
        this.aNS = false;
        this.aNU = status;
        this.aNO.zza(null, status);
    }
}
