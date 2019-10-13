package com.google.android.gms.auth.api.credentials.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzpr.zzb;

public final class zze implements CredentialsApi {

    private static class zza extends zza {
        private zzb<Status> ds;

        zza(zzb<Status> zzb) {
            this.ds = zzb;
        }

        public void zzh(Status status) {
            this.ds.setResult(status);
        }
    }

    private PasswordSpecification zza(GoogleApiClient googleApiClient) {
        AuthCredentialsOptions zzafj = ((zzg) googleApiClient.zza((zzc<C>) Auth.cE)).zzafj();
        return (zzafj == null || zzafj.zzafb() == null) ? PasswordSpecification.de : zzafj.zzafb();
    }

    public PendingResult<Status> delete(GoogleApiClient googleApiClient, final Credential credential) {
        return googleApiClient.zzd(new zzf<Status>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(Context context, zzk zzk) throws RemoteException {
                zzk.zza((zzj) new zza(this), new DeleteRequest(credential));
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzb */
            public Status zzc(Status status) {
                return status;
            }
        });
    }

    public PendingResult<Status> disableAutoSignIn(GoogleApiClient googleApiClient) {
        return googleApiClient.zzd(new zzf<Status>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(Context context, zzk zzk) throws RemoteException {
                zzk.zza(new zza(this));
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzb */
            public Status zzc(Status status) {
                return status;
            }
        });
    }

    public PendingIntent getHintPickerIntent(GoogleApiClient googleApiClient, HintRequest hintRequest) {
        zzab.zzb(googleApiClient, (Object) "client must not be null");
        zzab.zzb(hintRequest, (Object) "request must not be null");
        zzab.zzb(googleApiClient.zza(Auth.CREDENTIALS_API), (Object) "Auth.CREDENTIALS_API must be added to GoogleApiClient to use this API");
        return PendingIntent.getActivity(googleApiClient.getContext(), CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE, zzc.zza(googleApiClient.getContext(), hintRequest, zza(googleApiClient)), 268435456);
    }

    public PendingResult<CredentialRequestResult> request(GoogleApiClient googleApiClient, final CredentialRequest credentialRequest) {
        return googleApiClient.zzc(new zzf<CredentialRequestResult>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(Context context, zzk zzk) throws RemoteException {
                zzk.zza((zzj) new zza() {
                    public void zza(Status status, Credential credential) {
                        AnonymousClass1.this.zzc((Result) new zzd(status, credential));
                    }

                    public void zzh(Status status) {
                        AnonymousClass1.this.zzc((Result) zzd.zzi(status));
                    }
                }, credentialRequest);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzj */
            public CredentialRequestResult zzc(Status status) {
                return zzd.zzi(status);
            }
        });
    }

    public PendingResult<Status> save(GoogleApiClient googleApiClient, final Credential credential) {
        return googleApiClient.zzd(new zzf<Status>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(Context context, zzk zzk) throws RemoteException {
                zzk.zza((zzj) new zza(this), new SaveRequest(credential));
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzb */
            public Status zzc(Status status) {
                return status;
            }
        });
    }
}
