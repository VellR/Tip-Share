package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.RemoteException;
import com.google.android.gms.auth.account.WorkAccount;
import com.google.android.gms.auth.account.WorkAccountApi;
import com.google.android.gms.auth.account.WorkAccountApi.AddAccountResult;
import com.google.android.gms.auth.account.zza.C0000zza;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class zzmw implements WorkAccountApi {
    /* access modifiers changed from: private */
    public static final Status cy = new Status(13);

    static class zza extends C0000zza {
        zza() {
        }

        public void zzay(boolean z) {
            throw new UnsupportedOperationException();
        }

        public void zzc(Account account) {
            throw new UnsupportedOperationException();
        }
    }

    static class zzb implements AddAccountResult {
        private final Account aP;
        private final Status cc;

        public zzb(Status status, Account account) {
            this.cc = status;
            this.aP = account;
        }

        public Account getAccount() {
            return this.aP;
        }

        public Status getStatus() {
            return this.cc;
        }
    }

    static class zzc implements Result {
        private final Status cc;

        public zzc(Status status) {
            this.cc = status;
        }

        public Status getStatus() {
            return this.cc;
        }
    }

    public PendingResult<AddAccountResult> addWorkAccount(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzd(new com.google.android.gms.internal.zzpr.zza<AddAccountResult, zzmx>(WorkAccount.API, googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzmx zzmx) throws RemoteException {
                ((com.google.android.gms.auth.account.zzb) zzmx.zzarw()).zza((com.google.android.gms.auth.account.zza) new zza() {
                    public void zzc(Account account) {
                        AnonymousClass2.this.zzc(new zzb(account != null ? Status.sg : zzmw.cy, account));
                    }
                }, str);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzf */
            public AddAccountResult zzc(Status status) {
                return new zzb(status, null);
            }
        });
    }

    public PendingResult<Result> removeWorkAccount(GoogleApiClient googleApiClient, final Account account) {
        return googleApiClient.zzd(new com.google.android.gms.internal.zzpr.zza<Result, zzmx>(WorkAccount.API, googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzmx zzmx) throws RemoteException {
                ((com.google.android.gms.auth.account.zzb) zzmx.zzarw()).zza((com.google.android.gms.auth.account.zza) new zza() {
                    public void zzay(boolean z) {
                        AnonymousClass3.this.zzc(new zzc(z ? Status.sg : zzmw.cy));
                    }
                }, account);
            }

            /* access modifiers changed from: protected */
            public Result zzc(Status status) {
                return new zzc(status);
            }
        });
    }

    public void setWorkAuthenticatorEnabled(GoogleApiClient googleApiClient, final boolean z) {
        googleApiClient.zzd(new com.google.android.gms.internal.zzpr.zza<Result, zzmx>(WorkAccount.API, googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzmx zzmx) throws RemoteException {
                ((com.google.android.gms.auth.account.zzb) zzmx.zzarw()).zzaz(z);
            }

            /* access modifiers changed from: protected */
            public Result zzc(Status status) {
                return null;
            }
        });
    }
}
