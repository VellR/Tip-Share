package com.google.android.gms.auth.api.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzqv;
import java.util.HashSet;

public class zzc implements GoogleSignInApi {

    private abstract class zza<R extends Result> extends com.google.android.gms.internal.zzpr.zza<R, zzd> {
        public zza(GoogleApiClient googleApiClient) {
            super(Auth.GOOGLE_SIGN_IN_API, googleApiClient);
        }
    }

    private OptionalPendingResult<GoogleSignInResult> zza(GoogleApiClient googleApiClient, final GoogleSignInOptions googleSignInOptions) {
        Log.d("GoogleSignInApiImpl", "trySilentSignIn");
        return new zzqv(googleApiClient.zzc(new zza<GoogleSignInResult>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzd zzd) throws RemoteException {
                final zzk zzbc = zzk.zzbc(zzd.getContext());
                ((zzh) zzd.zzarw()).zza(new zza() {
                    public void zza(GoogleSignInAccount googleSignInAccount, Status status) throws RemoteException {
                        if (googleSignInAccount != null) {
                            zzbc.zzb(googleSignInAccount, googleSignInOptions);
                        }
                        AnonymousClass1.this.zzc((Result) new GoogleSignInResult(googleSignInAccount, status));
                    }
                }, googleSignInOptions);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzn */
            public GoogleSignInResult zzc(Status status) {
                return new GoogleSignInResult(null, status);
            }
        }));
    }

    private boolean zza(Account account, Account account2) {
        return account == null ? account2 == null : account.equals(account2);
    }

    private GoogleSignInOptions zzb(GoogleApiClient googleApiClient) {
        return ((zzd) googleApiClient.zza((com.google.android.gms.common.api.Api.zzc<C>) Auth.cG)).zzagb();
    }

    public Intent getSignInIntent(GoogleApiClient googleApiClient) {
        zzab.zzaa(googleApiClient);
        return ((zzd) googleApiClient.zza((com.google.android.gms.common.api.Api.zzc<C>) Auth.cG)).zzaga();
    }

    public GoogleSignInResult getSignInResultFromIntent(Intent intent) {
        if (intent == null || (!intent.hasExtra("googleSignInStatus") && !intent.hasExtra("googleSignInAccount"))) {
            return null;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) intent.getParcelableExtra("googleSignInAccount");
        Status status = (Status) intent.getParcelableExtra("googleSignInStatus");
        if (googleSignInAccount != null) {
            status = Status.sg;
        }
        return new GoogleSignInResult(googleSignInAccount, status);
    }

    public PendingResult<Status> revokeAccess(GoogleApiClient googleApiClient) {
        zzk.zzbc(googleApiClient.getContext()).zzagl();
        for (GoogleApiClient zzaoc : GoogleApiClient.zzaob()) {
            zzaoc.zzaoc();
        }
        return googleApiClient.zzd(new zza<Status>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzd zzd) throws RemoteException {
                ((zzh) zzd.zzarw()).zzc(new zza() {
                    public void zzm(Status status) throws RemoteException {
                        AnonymousClass3.this.zzc((Result) status);
                    }
                }, zzd.zzagb());
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzb */
            public Status zzc(Status status) {
                return status;
            }
        });
    }

    public PendingResult<Status> signOut(GoogleApiClient googleApiClient) {
        zzk.zzbc(googleApiClient.getContext()).zzagl();
        for (GoogleApiClient zzaoc : GoogleApiClient.zzaob()) {
            zzaoc.zzaoc();
        }
        return googleApiClient.zzd(new zza<Status>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzd zzd) throws RemoteException {
                ((zzh) zzd.zzarw()).zzb(new zza() {
                    public void zzl(Status status) throws RemoteException {
                        AnonymousClass2.this.zzc((Result) status);
                    }
                }, zzd.zzagb());
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzb */
            public Status zzc(Status status) {
                return status;
            }
        });
    }

    public OptionalPendingResult<GoogleSignInResult> silentSignIn(GoogleApiClient googleApiClient) {
        GoogleSignInOptions zzb = zzb(googleApiClient);
        GoogleSignInResult zza2 = zza(googleApiClient.getContext(), zzb);
        return zza2 != null ? PendingResults.zzb(zza2, googleApiClient) : zza(googleApiClient, zzb);
    }

    public GoogleSignInResult zza(Context context, GoogleSignInOptions googleSignInOptions) {
        Log.d("GoogleSignInApiImpl", "getSavedSignInResultIfEligible");
        zzab.zzaa(googleSignInOptions);
        zzk zzbc = zzk.zzbc(context);
        GoogleSignInOptions zzagk = zzbc.zzagk();
        if (zzagk == null || !zza(zzagk.getAccount(), googleSignInOptions.getAccount()) || googleSignInOptions.zzafs()) {
            return null;
        }
        if ((googleSignInOptions.zzafr() && (!zzagk.zzafr() || !googleSignInOptions.zzafu().equals(zzagk.zzafu()))) || !new HashSet(zzagk.zzafq()).containsAll(new HashSet(googleSignInOptions.zzafq()))) {
            return null;
        }
        GoogleSignInAccount zzagj = zzbc.zzagj();
        if (zzagj == null || zzagj.zza()) {
            return null;
        }
        return new GoogleSignInResult(zzagj, Status.sg);
    }
}
