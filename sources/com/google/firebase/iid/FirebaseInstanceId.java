package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.util.Base64;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class FirebaseInstanceId {
    private static Map<String, FirebaseInstanceId> abO = new ArrayMap();
    private static zze baE;
    private final FirebaseApp baF;
    private final zzd baG;
    private final String baH = zzcwu();

    private FirebaseInstanceId(FirebaseApp firebaseApp, zzd zzd) {
        this.baF = firebaseApp;
        this.baG = zzd;
        if (this.baH == null) {
            throw new IllegalStateException("IID failing to initialize, FirebaseApp is missing project ID");
        }
        FirebaseInstanceIdService.zza(this.baF.getApplicationContext(), this);
    }

    public static FirebaseInstanceId getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    @Keep
    public static synchronized FirebaseInstanceId getInstance(@NonNull FirebaseApp firebaseApp) {
        FirebaseInstanceId firebaseInstanceId;
        synchronized (FirebaseInstanceId.class) {
            firebaseInstanceId = (FirebaseInstanceId) abO.get(firebaseApp.getOptions().getApplicationId());
            if (firebaseInstanceId == null) {
                zzd zzb = zzd.zzb(firebaseApp.getApplicationContext(), null);
                if (baE == null) {
                    baE = new zze(zzb.zzcxa());
                }
                firebaseInstanceId = new FirebaseInstanceId(firebaseApp, zzb);
                abO.put(firebaseApp.getOptions().getApplicationId(), firebaseInstanceId);
            }
        }
        return firebaseInstanceId;
    }

    static String zza(KeyPair keyPair) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) (((digest[0] & 15) + 112) & 255);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException e) {
            Log.w("FirebaseInstanceId", "Unexpected error, device missing required alghorithms");
            return null;
        }
    }

    static void zza(Context context, zzg zzg) {
        zzg.zzbna();
        Intent intent = new Intent();
        intent.putExtra("CMD", "RST");
        context.sendBroadcast(FirebaseInstanceIdInternalReceiver.zzh(context, intent));
    }

    static int zzdf(Context context) {
        boolean z = false;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 38).append("Never happens: can't find own package ").append(valueOf).toString());
            return z;
        }
    }

    static String zzdg(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 38).append("Never happens: can't find own package ").append(valueOf).toString());
            return null;
        }
    }

    static void zzdh(Context context) {
        Intent intent = new Intent();
        intent.setPackage(context.getPackageName());
        intent.putExtra("CMD", "SYNC");
        context.sendBroadcast(FirebaseInstanceIdInternalReceiver.zzh(context, intent));
    }

    static String zzej(Context context) {
        return getInstance().baF.getOptions().getApplicationId();
    }

    static String zzz(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    public void deleteInstanceId() throws IOException {
        this.baG.zzb("*", "*", null);
        this.baG.zzbmu();
    }

    @WorkerThread
    public void deleteToken(String str, String str2) throws IOException {
        this.baG.zzb(str, str2, null);
    }

    public long getCreationTime() {
        return this.baG.getCreationTime();
    }

    public String getId() {
        return zza(this.baG.zzbmt());
    }

    @Nullable
    public String getToken() {
        String zzcwv = zzcwv();
        if (zzcwv == null) {
            FirebaseInstanceIdService.zzek(this.baF.getApplicationContext());
        }
        return zzcwv;
    }

    @WorkerThread
    public String getToken(String str, String str2) throws IOException {
        return this.baG.getToken(str, str2, null);
    }

    /* access modifiers changed from: 0000 */
    public String zzcwu() {
        String gcmSenderId = this.baF.getOptions().getGcmSenderId();
        if (gcmSenderId != null) {
            return gcmSenderId;
        }
        String applicationId = this.baF.getOptions().getApplicationId();
        if (!applicationId.startsWith("1:")) {
            return applicationId;
        }
        String[] split = applicationId.split(":");
        if (split.length < 2) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    /* access modifiers changed from: 0000 */
    @Nullable
    public String zzcwv() {
        return this.baG.zzcxa().zzi("", this.baH, "*");
    }

    /* access modifiers changed from: 0000 */
    public String zzcww() throws IOException {
        return getToken(this.baH, "*");
    }

    /* access modifiers changed from: 0000 */
    public zze zzcwx() {
        return baE;
    }

    public void zzsf(String str) {
        baE.zzsf(str);
        FirebaseInstanceIdService.zzek(this.baF.getApplicationContext());
    }

    /* access modifiers changed from: 0000 */
    public void zzsg(String str) throws IOException {
        if (getToken() == null) {
            throw new IOException("token not available");
        }
        Bundle bundle = new Bundle();
        String str2 = "gcm.topic";
        String valueOf = String.valueOf("/topics/");
        String valueOf2 = String.valueOf(str);
        bundle.putString(str2, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        zzd zzd = this.baG;
        String token = getToken();
        String valueOf3 = String.valueOf("/topics/");
        String valueOf4 = String.valueOf(str);
        zzd.getToken(token, valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), bundle);
    }

    /* access modifiers changed from: 0000 */
    public void zzsh(String str) throws IOException {
        if (getToken() == null) {
            throw new IOException("token not available");
        }
        Bundle bundle = new Bundle();
        String str2 = "gcm.topic";
        String valueOf = String.valueOf("/topics/");
        String valueOf2 = String.valueOf(str);
        bundle.putString(str2, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        zzd zzd = this.baG;
        String token = getToken();
        String valueOf3 = String.valueOf("/topics/");
        String valueOf4 = String.valueOf(str);
        zzd.zzb(token, valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), bundle);
    }
}
