package com.google.android.gms.internal;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.zzab;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class zzafx extends FirebaseUser {
    @zzann("cachedTokenState")
    private String aOo;
    @zzann("defaultUserInfo")
    private zzafv aOp;
    @zzann("applicationName")
    private String aOq;
    @zzann("type")
    private String aOr = "com.google.firebase.auth.internal.DefaultFirebaseUser";
    @zzann("userInfos")
    private List<zzafv> aOs;
    @zzann("providers")
    private List<String> aOt;
    @zzann("providerInfo")
    private Map<String, zzafv> aOu;
    @zzann("anonymous")
    private boolean aOv;

    public zzafx(@NonNull FirebaseApp firebaseApp, @NonNull List<? extends UserInfo> list) {
        zzab.zzaa(firebaseApp);
        this.aOq = firebaseApp.getName();
        zzan(list);
    }

    @Nullable
    public String getDisplayName() {
        return this.aOp.getDisplayName();
    }

    @Nullable
    public String getEmail() {
        return this.aOp.getEmail();
    }

    @Nullable
    public Uri getPhotoUrl() {
        return this.aOp.getPhotoUrl();
    }

    @NonNull
    public List<? extends UserInfo> getProviderData() {
        return this.aOs;
    }

    @NonNull
    public String getProviderId() {
        return this.aOp.getProviderId();
    }

    @Nullable
    public List<String> getProviders() {
        return this.aOt;
    }

    @NonNull
    public String getUid() {
        return this.aOp.getUid();
    }

    public boolean isAnonymous() {
        return this.aOv;
    }

    @NonNull
    public FirebaseUser zzan(@NonNull List<? extends UserInfo> list) {
        zzab.zzaa(list);
        this.aOs = new ArrayList(list.size());
        this.aOt = new ArrayList(list.size());
        this.aOu = new ArrayMap();
        for (int i = 0; i < list.size(); i++) {
            zzafv zzafv = new zzafv((UserInfo) list.get(i));
            if (zzafv.getProviderId().equals(FirebaseAuthProvider.PROVIDER_ID)) {
                this.aOp = zzafv;
            } else {
                this.aOt.add(zzafv.getProviderId());
            }
            this.aOs.add(zzafv);
            this.aOu.put(zzafv.getProviderId(), zzafv);
        }
        if (this.aOp == null) {
            this.aOp = (zzafv) this.aOs.get(0);
        }
        return this;
    }

    @NonNull
    public FirebaseApp zzcks() {
        return FirebaseApp.getInstance(this.aOq);
    }

    @NonNull
    public String zzckt() {
        return this.aOo;
    }

    /* renamed from: zzcn */
    public zzafx zzcm(boolean z) {
        this.aOv = z;
        return this;
    }

    public void zzql(@NonNull String str) {
        zzab.zzhs(str);
        this.aOo = str;
    }

    @NonNull
    public FirebaseUser zzqn(@NonNull String str) {
        this.aOt.add(zzab.zzhs(str));
        return this;
    }
}
