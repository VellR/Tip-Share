package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.ProviderQueryResult;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.api.model.GetAccountInfoUser;
import com.google.firebase.auth.api.model.ProviderUserInfo;
import com.google.firebase.auth.api.model.VerifyAssertionRequest;
import java.util.ArrayList;
import java.util.List;

public class zzafd extends com.google.android.gms.common.api.zzc<com.google.android.gms.internal.zzafl.zza> {

    static final class zza extends zzafo<AuthResult, zzafs> {
        @NonNull
        private String cQ;
        @NonNull
        private String dG;

        public zza(@NonNull String str, @NonNull String str2) {
            super(2);
            this.dG = zzab.zzh(str, "email cannot be null or empty");
            this.cQ = zzab.zzh(str2, "password cannot be null or empty");
        }

        public void dispatch() throws RemoteException {
            this.aNM.zzc(this.dG, this.cQ, this.aNK);
        }

        public void zzcky() {
            zzafx zzb = zzafd.zza(this.aNi, this.aNQ);
            ((zzafs) this.aNN).zza(this.aNP, zzb);
            zzbd(new zzafu(zzb));
        }
    }

    static final class zzb extends zzafo<Void, zzaga> {
        public zzb() {
            super(5);
        }

        public void dispatch() throws RemoteException {
            this.aNM.zzg(this.aNL.zzckt(), this.aNK);
        }

        public void zzcky() {
            ((zzaga) this.aNN).zzckr();
            zzbd(null);
        }
    }

    static final class zzc extends zzafo<ProviderQueryResult, zzafs> {
        @NonNull
        private final String dG;

        public zzc(@NonNull String str) {
            super(3);
            this.dG = zzab.zzh(str, "email cannot be null or empty");
        }

        public void dispatch() throws RemoteException {
            this.aNM.zzc(this.dG, this.aNK);
        }

        public void zzcky() {
            zzbd(new zzafy(this.aNR));
        }
    }

    static final class zzd extends zzafo<GetTokenResult, zzafs> {
        @NonNull
        private final String aNx;

        public zzd(@NonNull String str) {
            super(1);
            this.aNx = zzab.zzh(str, "refresh token cannot be null");
        }

        public void dispatch() throws RemoteException {
            this.aNM.zza(this.aNx, (zzafj) this.aNK);
        }

        public void zzcky() {
            this.aNP.zzqm(this.aNx);
            ((zzafs) this.aNN).zza(this.aNP, this.aNL);
            zzbd(new GetTokenResult(this.aNP.getAccessToken()));
        }
    }

    static final class zze extends zzafo<AuthResult, zzafs> {
        @NonNull
        private final EmailAuthCredential aNy;

        public zze(@NonNull EmailAuthCredential emailAuthCredential) {
            super(2);
            this.aNy = (EmailAuthCredential) zzab.zzb(emailAuthCredential, (Object) "credential cannot be null");
        }

        public void dispatch() throws RemoteException {
            this.aNM.zza(this.aNy.getEmail(), this.aNy.getPassword(), this.aNL.zzckt(), this.aNK);
        }

        public void zzcky() {
            zzafx zzb = zzafd.zza(this.aNi, this.aNQ);
            ((zzafs) this.aNN).zza(this.aNP, zzb);
            zzbd(new zzafu(zzb));
        }
    }

    static final class zzf extends zzafo<AuthResult, zzafs> {
        @NonNull
        private final VerifyAssertionRequest aNz;

        public zzf(@NonNull AuthCredential authCredential) {
            super(2);
            zzab.zzb(authCredential, (Object) "credential cannot be null");
            this.aNz = zzaft.zza(authCredential);
        }

        public void dispatch() throws RemoteException {
            this.aNM.zza(this.aNL.zzckt(), this.aNz, (zzafj) this.aNK);
        }

        public void zzcky() {
            zzafx zzb = zzafd.zza(this.aNi, this.aNQ);
            ((zzafs) this.aNN).zza(this.aNP, zzb);
            zzbd(new zzafu(zzb));
        }
    }

    private class zzg<ResultT, CallbackT> extends zzrb<zzafe, ResultT> implements zzafn<ResultT> {
        private zzafo<ResultT, CallbackT> aNA;
        private TaskCompletionSource<ResultT> sq;

        public zzg(zzafo<ResultT, CallbackT> zzafo) {
            this.aNA = zzafo;
            this.aNA.zza((zzafn<SuccessT>) this);
        }

        /* access modifiers changed from: protected */
        public void zza(zzafe zzafe, TaskCompletionSource<ResultT> taskCompletionSource) throws RemoteException {
            this.sq = taskCompletionSource;
            this.aNA.zza(zzafe.zzckz());
        }

        public final void zza(ResultT resultt, Status status) {
            zzab.zzb(this.sq, (Object) "doExecute must be called before onComplete");
            if (status != null) {
                this.sq.setException(zzafg.zzes(status));
            } else {
                this.sq.setResult(resultt);
            }
        }
    }

    static final class zzh extends zzafo<Void, zzafs> {
        @NonNull
        private final VerifyAssertionRequest aNz;

        public zzh(@NonNull AuthCredential authCredential) {
            super(2);
            zzab.zzb(authCredential, (Object) "credential cannot be null");
            this.aNz = zzaft.zza(authCredential);
        }

        public void dispatch() throws RemoteException {
            this.aNM.zza(this.aNz, (zzafj) this.aNK);
        }

        public void zzcky() {
            zzafx zzb = zzafd.zza(this.aNi, this.aNQ);
            if (this.aNL.getUid().equalsIgnoreCase(zzb.getUid())) {
                ((zzafs) this.aNN).zza(this.aNP, zzb);
                zzcle();
                return;
            }
            zzet(zzafz.zzclz());
        }
    }

    static final class zzi extends zzafo<Void, zzafs> {
        @NonNull
        private final String cQ;
        @NonNull
        private final String dG;

        public zzi(@NonNull String str, @NonNull String str2) {
            super(2);
            this.dG = zzab.zzh(str, "email cannot be null or empty");
            this.cQ = zzab.zzh(str2, "password cannot be null or empty");
        }

        public void dispatch() throws RemoteException {
            this.aNM.zzd(this.dG, this.cQ, this.aNK);
        }

        public void zzcky() {
            zzafx zzb = zzafd.zza(this.aNi, this.aNQ);
            if (this.aNL.getUid().equalsIgnoreCase(zzb.getUid())) {
                ((zzafs) this.aNN).zza(this.aNP, zzb);
                zzcle();
                return;
            }
            zzet(zzafz.zzclz());
        }
    }

    static final class zzj extends zzafo<Void, zzafs> {
        public zzj() {
            super(2);
        }

        public void dispatch() throws RemoteException {
            this.aNM.zzf(this.aNL.zzckt(), this.aNK);
        }

        public void zzcky() {
            ((zzafs) this.aNN).zza(this.aNP, zzafd.zza(this.aNi, this.aNQ, this.aNL.isAnonymous()));
            zzbd(null);
        }
    }

    static final class zzk extends zzafo<Void, zzafs> {
        @NonNull
        private String dG;

        public zzk(@NonNull String str) {
            super(4);
            this.dG = zzab.zzh(str, "email cannot be null or empty");
        }

        public void dispatch() throws RemoteException {
            this.aNM.zzd(this.dG, this.aNK);
        }

        public void zzcky() {
            zzcle();
        }
    }

    static final class zzl extends zzafo<AuthResult, zzafs> {
        public zzl() {
            super(2);
        }

        public void dispatch() throws RemoteException {
            this.aNM.zza(this.aNK);
        }

        public void zzcky() {
            zzafx zzb = zzafd.zza(this.aNi, this.aNQ, true);
            ((zzafs) this.aNN).zza(this.aNP, zzb);
            zzbd(new zzafu(zzb));
        }
    }

    static final class zzm extends zzafo<AuthResult, zzafs> {
        @NonNull
        private final VerifyAssertionRequest aNz;

        public zzm(@NonNull AuthCredential authCredential) {
            super(2);
            zzab.zzb(authCredential, (Object) "credential cannot be null");
            this.aNz = zzaft.zza(authCredential);
        }

        public void dispatch() throws RemoteException {
            this.aNM.zza(this.aNz, (zzafj) this.aNK);
        }

        public void zzcky() {
            zzafx zzb = zzafd.zza(this.aNi, this.aNQ);
            ((zzafs) this.aNN).zza(this.aNP, zzb);
            zzbd(new zzafu(zzb));
        }
    }

    static final class zzn extends zzafo<AuthResult, zzafs> {
        @NonNull
        private final String ct;

        public zzn(@NonNull String str) {
            super(2);
            this.ct = zzab.zzh(str, "token cannot be null or empty");
        }

        public void dispatch() throws RemoteException {
            this.aNM.zzb(this.ct, this.aNK);
        }

        public void zzcky() {
            zzafx zzb = zzafd.zza(this.aNi, this.aNQ);
            ((zzafs) this.aNN).zza(this.aNP, zzb);
            zzbd(new zzafu(zzb));
        }
    }

    static final class zzo extends zzafo<AuthResult, zzafs> {
        @NonNull
        private String cQ;
        @NonNull
        private String dG;

        public zzo(String str, String str2) {
            super(2);
            this.dG = zzab.zzh(str, "email cannot be null or empty");
            this.cQ = zzab.zzh(str2, "password cannot be null or empty");
        }

        public void dispatch() throws RemoteException {
            this.aNM.zzd(this.dG, this.cQ, this.aNK);
        }

        public void zzcky() {
            zzafx zzb = zzafd.zza(this.aNi, this.aNQ);
            ((zzafs) this.aNN).zza(this.aNP, zzb);
            zzbd(new zzafu(zzb));
        }
    }

    static final class zzp extends zzafo<AuthResult, zzafs> {
        public zzp() {
            super(2);
        }

        public void dispatch() throws RemoteException {
            this.aNM.zze(this.aNL.zzckt(), this.aNK);
        }

        public void zzcky() {
            zzafx zzb = zzafd.zza(this.aNi, this.aNQ);
            ((zzafs) this.aNN).zza(this.aNP, zzb);
            zzbd(new zzafu(zzb));
        }
    }

    static final class zzq extends zzafo<AuthResult, zzafs> {
        @NonNull
        private String aNC;

        public zzq(@NonNull String str) {
            super(2);
            this.aNC = zzab.zzh(str, "provider cannot be null or empty");
        }

        public void dispatch() throws RemoteException {
            this.aNM.zze(this.aNC, this.aNL.zzckt(), this.aNK);
        }

        public void zzcky() {
            zzafx zzb = zzafd.zza(this.aNi, this.aNQ);
            ((zzafs) this.aNN).zza(this.aNP, zzb);
            zzbd(new zzafu(zzb));
        }
    }

    static final class zzr extends zzafo<Void, zzafs> {
        @NonNull
        private final String dG;

        public zzr(String str) {
            super(2);
            this.dG = zzab.zzh(str, "email cannot be null or empty");
        }

        public void dispatch() throws RemoteException {
            this.aNM.zza(this.aNL.zzckt(), this.dG, (zzafj) this.aNK);
        }

        public void zzcky() {
            ((zzafs) this.aNN).zza(this.aNP, zzafd.zza(this.aNi, this.aNQ));
            zzcle();
        }
    }

    static final class zzs extends zzafo<Void, zzafs> {
        @NonNull
        private final String cQ;

        public zzs(@NonNull String str) {
            super(2);
            this.cQ = zzab.zzh(str, "password cannot be null or empty");
        }

        public void dispatch() throws RemoteException {
            this.aNM.zzb(this.aNL.zzckt(), this.cQ, this.aNK);
        }

        public void zzcky() {
            ((zzafs) this.aNN).zza(this.aNP, zzafd.zza(this.aNi, this.aNQ));
            zzcle();
        }
    }

    static final class zzt extends zzafo<Void, zzafs> {
        @NonNull
        private final UserProfileChangeRequest aND;

        public zzt(UserProfileChangeRequest userProfileChangeRequest) {
            super(2);
            this.aND = (UserProfileChangeRequest) zzab.zzb(userProfileChangeRequest, (Object) "request cannot be null");
        }

        public void dispatch() throws RemoteException {
            this.aNM.zza(this.aNL.zzckt(), this.aND, (zzafj) this.aNK);
        }

        public void zzcky() {
            ((zzafs) this.aNN).zza(this.aNP, zzafd.zza(this.aNi, this.aNQ));
            zzcle();
        }
    }

    zzafd(@NonNull Context context, @NonNull com.google.android.gms.internal.zzafl.zza zza2) {
        super(context, zzafl.aNI, zza2);
    }

    private <ResultT, CallbackT> zzg<ResultT, CallbackT> zza(zzafo<ResultT, CallbackT> zzafo) {
        return new zzg<>(zzafo);
    }

    /* access modifiers changed from: private */
    @NonNull
    public static zzafx zza(@NonNull FirebaseApp firebaseApp, @NonNull GetAccountInfoUser getAccountInfoUser) {
        return zza(firebaseApp, getAccountInfoUser, false);
    }

    /* access modifiers changed from: private */
    @NonNull
    public static zzafx zza(@NonNull FirebaseApp firebaseApp, @NonNull GetAccountInfoUser getAccountInfoUser, boolean z) {
        zzab.zzaa(firebaseApp);
        zzab.zzaa(getAccountInfoUser);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new zzafv(getAccountInfoUser, FirebaseAuthProvider.PROVIDER_ID));
        List zzclk = getAccountInfoUser.zzclk();
        if (zzclk != null && !zzclk.isEmpty()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= zzclk.size()) {
                    break;
                }
                arrayList.add(new zzafv((ProviderUserInfo) zzclk.get(i2)));
                i = i2 + 1;
            }
        }
        zzafx zzafx = new zzafx(firebaseApp, arrayList);
        zzafx zzafx2 = (zzafx) zzafx.zzcm(z);
        if (!TextUtils.isEmpty(getAccountInfoUser.getEmail()) && !TextUtils.isEmpty(getAccountInfoUser.getPassword())) {
            zzafx.zzqn(EmailAuthProvider.PROVIDER_ID);
        }
        return zzafx;
    }

    @NonNull
    private Task<AuthResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull AuthCredential authCredential, @NonNull FirebaseUser firebaseUser, @NonNull zzafs zzafs) {
        zzab.zzaa(firebaseApp);
        zzab.zzaa(authCredential);
        zzab.zzaa(firebaseUser);
        zzab.zzaa(zzafs);
        List providers = firebaseUser.getProviders();
        return (providers == null || !providers.contains(authCredential.getProvider())) ? zzb((zzrb<A, TResult>) zza(new zzf(authCredential).zzd(firebaseApp).zzd(firebaseUser).zzbc(zzafs))) : Tasks.forException(zzafg.zzes(new Status(17015)));
    }

    @NonNull
    private Task<AuthResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull EmailAuthCredential emailAuthCredential, @NonNull FirebaseUser firebaseUser, @NonNull zzafs zzafs) {
        return zzb((zzrb<A, TResult>) zza(new zze(emailAuthCredential).zzd(firebaseApp).zzd(firebaseUser).zzbc(zzafs)));
    }

    @NonNull
    private Task<AuthResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull zzafs zzafs) {
        return zzb((zzrb<A, TResult>) zza(new zzp().zzd(firebaseApp).zzd(firebaseUser).zzbc(zzafs)));
    }

    @NonNull
    private Task<AuthResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull String str, @NonNull FirebaseUser firebaseUser, @NonNull zzafs zzafs) {
        return zzb((zzrb<A, TResult>) zza(new zzq(str).zzd(firebaseApp).zzd(firebaseUser).zzbc(zzafs)));
    }

    public Task<AuthResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull zzafs zzafs) {
        return zzb((zzrb<A, TResult>) zza(new zzl().zzd(firebaseApp).zzbc(zzafs)));
    }

    public Task<AuthResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull AuthCredential authCredential, @NonNull zzafs zzafs) {
        return zzb((zzrb<A, TResult>) zza(new zzm(authCredential).zzd(firebaseApp).zzbc(zzafs)));
    }

    public Task<Void> zza(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential, @NonNull zzafs zzafs) {
        return zzb((zzrb<A, TResult>) zza(new zzh(authCredential).zzd(firebaseApp).zzd(firebaseUser).zzbc(zzafs)));
    }

    public Task<Void> zza(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull UserProfileChangeRequest userProfileChangeRequest, @NonNull zzafs zzafs) {
        return zzb((zzrb<A, TResult>) zza(new zzt(userProfileChangeRequest).zzd(firebaseApp).zzd(firebaseUser).zzbc(zzafs)));
    }

    public Task<GetTokenResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull String str, @NonNull zzafs zzafs) {
        return zza((zzrb<A, TResult>) zza(new zzd(str).zzd(firebaseApp).zzd(firebaseUser).zzbc(zzafs)));
    }

    public Task<Void> zza(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull String str, @NonNull String str2, @NonNull zzafs zzafs) {
        return zzb((zzrb<A, TResult>) zza(new zzi(str, str2).zzd(firebaseApp).zzd(firebaseUser).zzbc(zzafs)));
    }

    public Task<ProviderQueryResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull String str) {
        return zza((zzrb<A, TResult>) zza(new zzc(str).zzd(firebaseApp)));
    }

    public Task<AuthResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull String str, @NonNull zzafs zzafs) {
        return zzb((zzrb<A, TResult>) zza(new zzn(str).zzd(firebaseApp).zzbc(zzafs)));
    }

    public Task<AuthResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull String str, @NonNull String str2, @NonNull zzafs zzafs) {
        return zzb((zzrb<A, TResult>) zza(new zza(str, str2).zzd(firebaseApp).zzbc(zzafs)));
    }

    @NonNull
    public Task<Void> zza(@NonNull FirebaseUser firebaseUser, @NonNull zzaga zzaga) {
        return zzb((zzrb<A, TResult>) zza(new zzb().zzd(firebaseUser).zzbc(zzaga)));
    }

    @NonNull
    public Task<Void> zzb(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull zzafs zzafs) {
        return zza((zzrb<A, TResult>) zza(new zzj().zzd(firebaseApp).zzd(firebaseUser).zzbc(zzafs)));
    }

    public Task<AuthResult> zzb(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential, @NonNull zzafs zzafs) {
        zzab.zzaa(firebaseApp);
        zzab.zzaa(authCredential);
        zzab.zzaa(firebaseUser);
        zzab.zzaa(zzafs);
        return EmailAuthCredential.class.isAssignableFrom(authCredential.getClass()) ? zza(firebaseApp, (EmailAuthCredential) authCredential, firebaseUser, zzafs) : zza(firebaseApp, authCredential, firebaseUser, zzafs);
    }

    public Task<Void> zzb(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull String str, @NonNull zzafs zzafs) {
        return zzb((zzrb<A, TResult>) zza(new zzr(str).zzd(firebaseApp).zzd(firebaseUser).zzbc(zzafs)));
    }

    public Task<Void> zzb(@NonNull FirebaseApp firebaseApp, @NonNull String str) {
        return zzb((zzrb<A, TResult>) zza(new zzk(str).zzd(firebaseApp)));
    }

    public Task<AuthResult> zzb(@NonNull FirebaseApp firebaseApp, @NonNull String str, @NonNull String str2, @NonNull zzafs zzafs) {
        return zzb((zzrb<A, TResult>) zza(new zzo(str, str2).zzd(firebaseApp).zzbc(zzafs)));
    }

    public Task<Void> zzc(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull String str, @NonNull zzafs zzafs) {
        return zzb((zzrb<A, TResult>) zza(new zzs(str).zzd(firebaseApp).zzd(firebaseUser).zzbc(zzafs)));
    }

    public Task<AuthResult> zzd(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull String str, @NonNull zzafs zzafs) {
        zzab.zzaa(firebaseApp);
        zzab.zzhs(str);
        zzab.zzaa(firebaseUser);
        zzab.zzaa(zzafs);
        List providers = firebaseUser.getProviders();
        if ((providers != null && !providers.contains(str)) || firebaseUser.isAnonymous()) {
            return Tasks.forException(zzafg.zzes(new Status(17016, str)));
        }
        char c = 65535;
        switch (str.hashCode()) {
            case 1216985755:
                if (str.equals(EmailAuthProvider.PROVIDER_ID)) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return zza(firebaseApp, firebaseUser, zzafs);
            default:
                return zza(firebaseApp, str, firebaseUser, zzafs);
        }
    }
}
