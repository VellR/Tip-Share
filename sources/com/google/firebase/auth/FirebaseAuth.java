package com.google.firebase.auth;

import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzafd;
import com.google.android.gms.internal.zzafg;
import com.google.android.gms.internal.zzafi;
import com.google.android.gms.internal.zzafl;
import com.google.android.gms.internal.zzafl.zza.C0027zza;
import com.google.android.gms.internal.zzafs;
import com.google.android.gms.internal.zzafu;
import com.google.android.gms.internal.zzafw;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzaga;
import com.google.android.gms.internal.zzagb;
import com.google.android.gms.internal.zzagc;
import com.google.android.gms.internal.zzalt;
import com.google.android.gms.internal.zzams;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.api.model.GetTokenResponse;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class FirebaseAuth implements zzalt {
    private static FirebaseAuth aNo;
    private static Map<String, FirebaseAuth> abO = new ArrayMap();
    /* access modifiers changed from: private */
    public FirebaseApp aNi;
    private zzafd aNj;
    /* access modifiers changed from: private */
    public FirebaseUser aNk;
    private zzagb aNl;
    /* access modifiers changed from: private */
    public zzams aNm;
    private zzagc aNn;
    /* access modifiers changed from: private */
    public List<AuthStateListener> mListeners;

    public interface AuthStateListener {
        void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth);
    }

    class zza implements zzafs {
        zza() {
        }

        public void zza(@NonNull GetTokenResponse getTokenResponse, @NonNull FirebaseUser firebaseUser) {
            zzab.zzaa(getTokenResponse);
            zzab.zzaa(firebaseUser);
            firebaseUser.zzql(FirebaseAuth.this.aNm.zzcj(getTokenResponse));
            FirebaseAuth.this.zza(firebaseUser, getTokenResponse, true);
            FirebaseAuth.this.zza(firebaseUser, true, true);
        }
    }

    public FirebaseAuth(FirebaseApp firebaseApp) {
        this(firebaseApp, zza(firebaseApp), new zzagb(firebaseApp.getApplicationContext(), firebaseApp.zzckc(), zzafi.zzcla()));
    }

    FirebaseAuth(FirebaseApp firebaseApp, zzafd zzafd, zzagb zzagb) {
        this.aNi = (FirebaseApp) zzab.zzaa(firebaseApp);
        this.aNj = (zzafd) zzab.zzaa(zzafd);
        this.aNl = (zzagb) zzab.zzaa(zzagb);
        this.mListeners = new CopyOnWriteArrayList();
        this.aNm = zzafi.zzcla();
        this.aNn = zzagc.zzcmc();
        zzckq();
    }

    public static FirebaseAuth getInstance() {
        return zzb(FirebaseApp.getInstance());
    }

    @Keep
    public static FirebaseAuth getInstance(@NonNull FirebaseApp firebaseApp) {
        return zzb(firebaseApp);
    }

    static zzafd zza(FirebaseApp firebaseApp) {
        return zzafl.zza(firebaseApp.getApplicationContext(), new C0027zza(firebaseApp.getOptions().getApiKey()).zzcld());
    }

    private static FirebaseAuth zzb(@NonNull FirebaseApp firebaseApp) {
        return zzc(firebaseApp);
    }

    private static synchronized FirebaseAuth zzc(@NonNull FirebaseApp firebaseApp) {
        FirebaseAuth firebaseAuth;
        synchronized (FirebaseAuth.class) {
            firebaseAuth = (FirebaseAuth) abO.get(firebaseApp.zzckc());
            if (firebaseAuth == null) {
                firebaseAuth = new zzafw(firebaseApp);
                firebaseApp.zza((zzalt) firebaseAuth);
                if (aNo == null) {
                    aNo = firebaseAuth;
                }
                abO.put(firebaseApp.zzckc(), firebaseAuth);
            }
        }
        return firebaseAuth;
    }

    public void addAuthStateListener(@NonNull final AuthStateListener authStateListener) {
        this.mListeners.add(authStateListener);
        this.aNn.execute(new Runnable() {
            public void run() {
                authStateListener.onAuthStateChanged(FirebaseAuth.this);
            }
        });
    }

    @NonNull
    public Task<AuthResult> createUserWithEmailAndPassword(@NonNull String str, @NonNull String str2) {
        zzab.zzhs(str);
        zzab.zzhs(str2);
        return this.aNj.zza(this.aNi, str, str2, (zzafs) new zza());
    }

    @NonNull
    public Task<ProviderQueryResult> fetchProvidersForEmail(@NonNull String str) {
        zzab.zzhs(str);
        return this.aNj.zza(this.aNi, str);
    }

    @Nullable
    public FirebaseUser getCurrentUser() {
        return this.aNk;
    }

    public void removeAuthStateListener(@NonNull AuthStateListener authStateListener) {
        this.mListeners.remove(authStateListener);
    }

    @NonNull
    public Task<Void> sendPasswordResetEmail(@NonNull String str) {
        zzab.zzhs(str);
        return this.aNj.zzb(this.aNi, str);
    }

    @NonNull
    public Task<AuthResult> signInAnonymously() {
        return (this.aNk == null || !this.aNk.isAnonymous()) ? this.aNj.zza(this.aNi, (zzafs) new zza()) : Tasks.forResult(new zzafu((zzafx) this.aNk));
    }

    @NonNull
    public Task<AuthResult> signInWithCredential(@NonNull AuthCredential authCredential) {
        zzab.zzaa(authCredential);
        if (!EmailAuthCredential.class.isAssignableFrom(authCredential.getClass())) {
            return this.aNj.zza(this.aNi, authCredential, (zzafs) new zza());
        }
        EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredential;
        return this.aNj.zzb(this.aNi, emailAuthCredential.getEmail(), emailAuthCredential.getPassword(), (zzafs) new zza());
    }

    @NonNull
    public Task<AuthResult> signInWithCustomToken(@NonNull String str) {
        zzab.zzhs(str);
        return this.aNj.zza(this.aNi, str, (zzafs) new zza());
    }

    @NonNull
    public Task<AuthResult> signInWithEmailAndPassword(@NonNull String str, @NonNull String str2) {
        zzab.zzhs(str);
        zzab.zzhs(str2);
        return this.aNj.zzb(this.aNi, str, str2, (zzafs) new zza());
    }

    public void signOut() {
        zzckp();
    }

    @NonNull
    public Task<Void> zza(@NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential) {
        zzab.zzaa(firebaseUser);
        zzab.zzaa(authCredential);
        if (!EmailAuthCredential.class.isAssignableFrom(authCredential.getClass())) {
            return this.aNj.zza(this.aNi, firebaseUser, authCredential, (zzafs) new zza());
        }
        EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredential;
        return this.aNj.zza(this.aNi, firebaseUser, emailAuthCredential.getEmail(), emailAuthCredential.getPassword(), new zza());
    }

    @NonNull
    public Task<Void> zza(@NonNull FirebaseUser firebaseUser, @NonNull UserProfileChangeRequest userProfileChangeRequest) {
        zzab.zzaa(firebaseUser);
        zzab.zzaa(userProfileChangeRequest);
        return this.aNj.zza(this.aNi, firebaseUser, userProfileChangeRequest, (zzafs) new zza());
    }

    @NonNull
    public Task<AuthResult> zza(@NonNull FirebaseUser firebaseUser, @NonNull String str) {
        zzab.zzhs(str);
        zzab.zzaa(firebaseUser);
        return this.aNj.zzd(this.aNi, firebaseUser, str, new zza());
    }

    @NonNull
    public Task<GetTokenResult> zza(@Nullable FirebaseUser firebaseUser, boolean z) {
        if (firebaseUser == null) {
            return Tasks.forException(zzafg.zzes(new Status(17495)));
        }
        GetTokenResponse getTokenResponse = (GetTokenResponse) this.aNm.zzf(this.aNk.zzckt(), GetTokenResponse.class);
        return (!getTokenResponse.isValid() || z) ? this.aNj.zza(this.aNi, firebaseUser, getTokenResponse.zzcln(), (zzafs) new zzafs() {
            public void zza(@NonNull GetTokenResponse getTokenResponse, @NonNull FirebaseUser firebaseUser) {
                FirebaseAuth.this.zza(firebaseUser, getTokenResponse, true);
            }
        }) : Tasks.forResult(new GetTokenResult(getTokenResponse.getAccessToken()));
    }

    public void zza(@Nullable final FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            String valueOf = String.valueOf(firebaseUser.getUid());
            Log.d("FirebaseAuth", new StringBuilder(String.valueOf(valueOf).length() + 36).append("Notifying listeners about user ( ").append(valueOf).append(" ).").toString());
        } else {
            Log.d("FirebaseAuth", "Notifying listeners about a sign-out event.");
        }
        this.aNn.execute(new Runnable() {
            public void run() {
                FirebaseAuth.this.aNi.zza(FirebaseAuth.this, firebaseUser);
                for (AuthStateListener onAuthStateChanged : FirebaseAuth.this.mListeners) {
                    onAuthStateChanged.onAuthStateChanged(FirebaseAuth.this);
                }
            }
        });
    }

    public void zza(@NonNull FirebaseUser firebaseUser, @NonNull GetTokenResponse getTokenResponse, boolean z) {
        boolean z2 = true;
        zzab.zzaa(firebaseUser);
        zzab.zzaa(getTokenResponse);
        if (this.aNk != null) {
            String accessToken = ((GetTokenResponse) this.aNm.zzf(this.aNk.zzckt(), GetTokenResponse.class)).getAccessToken();
            z2 = this.aNk.getUid().equalsIgnoreCase(firebaseUser.getUid()) && accessToken != null && !accessToken.equals(getTokenResponse.getAccessToken());
        }
        if (z2) {
            if (this.aNk != null) {
                this.aNk.zzql(this.aNm.zzcj(getTokenResponse));
            }
            zza(this.aNk);
        }
        if (z) {
            this.aNl.zza(firebaseUser, getTokenResponse);
        }
    }

    public void zza(@NonNull FirebaseUser firebaseUser, boolean z, boolean z2) {
        zzab.zzaa(firebaseUser);
        if (this.aNk == null) {
            this.aNk = firebaseUser;
        } else {
            this.aNk.zzcm(firebaseUser.isAnonymous());
            this.aNk.zzan(firebaseUser.getProviderData());
        }
        if (z) {
            this.aNl.zze(this.aNk);
        }
        if (z2) {
            zza(this.aNk);
        }
    }

    @NonNull
    public Task<Void> zzb(@NonNull FirebaseUser firebaseUser) {
        zzab.zzaa(firebaseUser);
        return this.aNj.zzb(this.aNi, firebaseUser, (zzafs) new zza());
    }

    @NonNull
    public Task<AuthResult> zzb(@NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential) {
        zzab.zzaa(authCredential);
        zzab.zzaa(firebaseUser);
        return this.aNj.zzb(this.aNi, firebaseUser, authCredential, (zzafs) new zza());
    }

    @NonNull
    public Task<Void> zzb(@NonNull FirebaseUser firebaseUser, @NonNull String str) {
        zzab.zzaa(firebaseUser);
        zzab.zzhs(str);
        return this.aNj.zzb(this.aNi, firebaseUser, str, (zzafs) new zza());
    }

    @NonNull
    public Task<Void> zzc(@NonNull final FirebaseUser firebaseUser) {
        zzab.zzaa(firebaseUser);
        return this.aNj.zza(firebaseUser, (zzaga) new zzaga() {
            public void zzckr() {
                if (FirebaseAuth.this.aNk.getUid().equalsIgnoreCase(firebaseUser.getUid())) {
                    FirebaseAuth.this.zzckp();
                }
            }
        });
    }

    @NonNull
    public Task<Void> zzc(@NonNull FirebaseUser firebaseUser, @NonNull String str) {
        zzab.zzaa(firebaseUser);
        zzab.zzhs(str);
        return this.aNj.zzc(this.aNi, firebaseUser, str, new zza());
    }

    public void zzckp() {
        if (this.aNk != null) {
            this.aNl.zzg(this.aNk);
            this.aNk = null;
        }
        this.aNl.zzcmb();
        zza((FirebaseUser) null);
    }

    /* access modifiers changed from: protected */
    public void zzckq() {
        this.aNk = this.aNl.zzcma();
        if (this.aNk != null) {
            zza(this.aNk, false, true);
            GetTokenResponse zzf = this.aNl.zzf(this.aNk);
            if (zzf != null) {
                zza(this.aNk, zzf, false);
            }
        }
    }
}
