package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.Process;
import android.support.annotation.BinderThread;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.measurement.internal.zzm.zza;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class zzy extends zza {
    /* access modifiers changed from: private */
    public final zzx aja;
    private final boolean amQ;

    public zzy(zzx zzx) {
        zzab.zzaa(zzx);
        this.aja = zzx;
        this.amQ = false;
    }

    public zzy(zzx zzx, boolean z) {
        zzab.zzaa(zzx);
        this.aja = zzx;
        this.amQ = z;
    }

    @BinderThread
    private void zzf(AppMetadata appMetadata) {
        zzab.zzaa(appMetadata);
        zzmg(appMetadata.packageName);
        this.aja.zzbsv().zzmr(appMetadata.ajz);
    }

    @BinderThread
    private void zzmg(String str) throws SecurityException {
        if (TextUtils.isEmpty(str)) {
            this.aja.zzbsz().zzbtr().log("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        try {
            zzmh(str);
        } catch (SecurityException e) {
            this.aja.zzbsz().zzbtr().zzj("Measurement Service called with invalid calling package", str);
            throw e;
        }
    }

    @BinderThread
    public List<UserAttributeParcel> zza(final AppMetadata appMetadata, boolean z) {
        zzf(appMetadata);
        try {
            List<zzak> list = (List) this.aja.zzbsy().zzd((Callable<V>) new Callable<List<zzak>>() {
                /* renamed from: zzbvg */
                public List<zzak> call() throws Exception {
                    zzy.this.aja.zzbvd();
                    return zzy.this.aja.zzbsu().zzln(appMetadata.packageName);
                }
            }).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzak zzak : list) {
                if (z || !zzal.zzmu(zzak.mName)) {
                    arrayList.add(new UserAttributeParcel(zzak));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.aja.zzbsz().zzbtr().zzj("Failed to get user attributes", e);
            return null;
        }
    }

    @BinderThread
    public void zza(final AppMetadata appMetadata) {
        zzf(appMetadata);
        this.aja.zzbsy().zzl(new Runnable() {
            public void run() {
                zzy.this.aja.zzbvd();
                zzy.this.zzmf(appMetadata.ajD);
                zzy.this.aja.zzd(appMetadata);
            }
        });
    }

    @BinderThread
    public void zza(final EventParcel eventParcel, final AppMetadata appMetadata) {
        zzab.zzaa(eventParcel);
        zzf(appMetadata);
        this.aja.zzbsy().zzl(new Runnable() {
            public void run() {
                zzy.this.aja.zzbvd();
                zzy.this.zzmf(appMetadata.ajD);
                zzy.this.aja.zzb(eventParcel, appMetadata);
            }
        });
    }

    @BinderThread
    public void zza(final EventParcel eventParcel, final String str, final String str2) {
        zzab.zzaa(eventParcel);
        zzab.zzhs(str);
        zzmg(str);
        this.aja.zzbsy().zzl(new Runnable() {
            public void run() {
                zzy.this.aja.zzbvd();
                zzy.this.zzmf(str2);
                zzy.this.aja.zzb(eventParcel, str);
            }
        });
    }

    @BinderThread
    public void zza(final UserAttributeParcel userAttributeParcel, final AppMetadata appMetadata) {
        zzab.zzaa(userAttributeParcel);
        zzf(appMetadata);
        if (userAttributeParcel.getValue() == null) {
            this.aja.zzbsy().zzl(new Runnable() {
                public void run() {
                    zzy.this.aja.zzbvd();
                    zzy.this.zzmf(appMetadata.ajD);
                    zzy.this.aja.zzc(userAttributeParcel, appMetadata);
                }
            });
        } else {
            this.aja.zzbsy().zzl(new Runnable() {
                public void run() {
                    zzy.this.aja.zzbvd();
                    zzy.this.zzmf(appMetadata.ajD);
                    zzy.this.aja.zzb(userAttributeParcel, appMetadata);
                }
            });
        }
    }

    @BinderThread
    public byte[] zza(final EventParcel eventParcel, final String str) {
        zzab.zzhs(str);
        zzab.zzaa(eventParcel);
        zzmg(str);
        this.aja.zzbsz().zzbtx().zzj("Log and bundle. event", eventParcel.name);
        long nanoTime = this.aja.zzyw().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.aja.zzbsy().zze((Callable<V>) new Callable<byte[]>() {
                /* renamed from: zzbvf */
                public byte[] call() throws Exception {
                    zzy.this.aja.zzbvd();
                    return zzy.this.aja.zza(eventParcel, str);
                }
            }).get();
            if (bArr == null) {
                this.aja.zzbsz().zzbtr().log("Log and bundle returned null");
                bArr = new byte[0];
            }
            this.aja.zzbsz().zzbtx().zzd("Log and bundle processed. event, size, time_ms", eventParcel.name, Integer.valueOf(bArr.length), Long.valueOf((this.aja.zzyw().nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e) {
            this.aja.zzbsz().zzbtr().zze("Failed to log and bundle. event, error", eventParcel.name, e);
            return null;
        }
    }

    @BinderThread
    public void zzb(final AppMetadata appMetadata) {
        zzf(appMetadata);
        this.aja.zzbsy().zzl(new Runnable() {
            public void run() {
                zzy.this.aja.zzbvd();
                zzy.this.zzmf(appMetadata.ajD);
                zzy.this.aja.zzc(appMetadata);
            }
        });
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public void zzmf(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(":", 2);
            if (split.length == 2) {
                try {
                    long longValue = Long.valueOf(split[0]).longValue();
                    if (longValue > 0) {
                        this.aja.zzbta().alu.zzg(split[1], longValue);
                    } else {
                        this.aja.zzbsz().zzbtt().zzj("Combining sample with a non-positive weight", Long.valueOf(longValue));
                    }
                } catch (NumberFormatException e) {
                    this.aja.zzbsz().zzbtt().zzj("Combining sample with a non-number weight", split[0]);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzmh(String str) throws SecurityException {
        int callingUid = this.amQ ? Process.myUid() : Binder.getCallingUid();
        if (!com.google.android.gms.common.util.zzy.zzb(this.aja.getContext(), callingUid, str)) {
            if (!com.google.android.gms.common.util.zzy.zze(this.aja.getContext(), callingUid) || this.aja.zzbuu()) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
            }
        }
    }
}
