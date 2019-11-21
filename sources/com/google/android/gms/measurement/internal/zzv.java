package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.internal.zzaou;
import com.google.android.gms.internal.zzaov;
import com.google.android.gms.internal.zzuo.zza;
import com.google.android.gms.internal.zzuo.zzb;
import com.google.android.gms.internal.zzuo.zzc;
import com.google.android.gms.measurement.AppMeasurement;
import java.io.IOException;
import java.util.Map;

public class zzv extends zzaa {
    private final Map<String, Map<String, String>> alR = new ArrayMap();
    private final Map<String, Map<String, Boolean>> alS = new ArrayMap();
    private final Map<String, Map<String, Boolean>> alT = new ArrayMap();
    private final Map<String, zzb> alU = new ArrayMap();
    private final Map<String, String> alV = new ArrayMap();

    zzv(zzx zzx) {
        super(zzx);
    }

    private Map<String, String> zza(zzb zzb) {
        zzc[] zzcArr;
        ArrayMap arrayMap = new ArrayMap();
        if (!(zzb == null || zzb.aoB == null)) {
            for (zzc zzc : zzb.aoB) {
                if (zzc != null) {
                    arrayMap.put(zzc.zzcb, zzc.value);
                }
            }
        }
        return arrayMap;
    }

    private void zza(String str, zzb zzb) {
        zza[] zzaArr;
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        if (!(zzb == null || zzb.aoC == null)) {
            for (zza zza : zzb.aoC) {
                if (zza != null) {
                    String str2 = (String) AppMeasurement.zza.ajb.get(zza.name);
                    if (str2 != null) {
                        zza.name = str2;
                    }
                    arrayMap.put(zza.name, zza.aox);
                    arrayMap2.put(zza.name, zza.aoy);
                }
            }
        }
        this.alS.put(str, arrayMap);
        this.alT.put(str, arrayMap2);
    }

    @WorkerThread
    private zzb zze(String str, byte[] bArr) {
        if (bArr == null) {
            return new zzb();
        }
        zzaou zzaz = zzaou.zzaz(bArr);
        zzb zzb = new zzb();
        try {
            zzb zzb2 = (zzb) zzb.zzb(zzaz);
            zzbsz().zzbty().zze("Parsed config. version, gmp_app_id", zzb.aoz, zzb.ajz);
            return zzb;
        } catch (IOException e) {
            zzbsz().zzbtt().zze("Unable to merge remote config", str, e);
            return null;
        }
    }

    @WorkerThread
    private void zzmb(String str) {
        zzzg();
        zzwu();
        zzab.zzhs(str);
        if (!this.alU.containsKey(str)) {
            byte[] zzlq = zzbsu().zzlq(str);
            if (zzlq == null) {
                this.alR.put(str, null);
                this.alS.put(str, null);
                this.alT.put(str, null);
                this.alU.put(str, null);
                this.alV.put(str, null);
                return;
            }
            zzb zze = zze(str, zzlq);
            this.alR.put(str, zza(zze));
            zza(str, zze);
            this.alU.put(str, zze);
            this.alV.put(str, null);
        }
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public String zzaw(String str, String str2) {
        zzwu();
        zzmb(str);
        Map map = (Map) this.alR.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public boolean zzax(String str, String str2) {
        zzwu();
        zzmb(str);
        Map map = (Map) this.alS.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public boolean zzay(String str, String str2) {
        zzwu();
        zzmb(str);
        Map map = (Map) this.alT.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public boolean zzb(String str, byte[] bArr, String str2) {
        zzzg();
        zzwu();
        zzab.zzhs(str);
        zzb zze = zze(str, bArr);
        if (zze == null) {
            return false;
        }
        zza(str, zze);
        this.alU.put(str, zze);
        this.alV.put(str, str2);
        this.alR.put(str, zza(zze));
        zzbsp().zza(str, zze.aoD);
        try {
            zze.aoD = null;
            byte[] bArr2 = new byte[zze.ao()];
            zze.zza(zzaov.zzba(bArr2));
            bArr = bArr2;
        } catch (IOException e) {
            zzbsz().zzbtt().zzj("Unable to serialize reduced-size config.  Storing full config instead.", e);
        }
        zzbsu().zzd(str, bArr);
        return true;
    }

    public /* bridge */ /* synthetic */ void zzbso() {
        super.zzbso();
    }

    public /* bridge */ /* synthetic */ zzc zzbsp() {
        return super.zzbsp();
    }

    public /* bridge */ /* synthetic */ zzac zzbsq() {
        return super.zzbsq();
    }

    public /* bridge */ /* synthetic */ zzn zzbsr() {
        return super.zzbsr();
    }

    public /* bridge */ /* synthetic */ zzg zzbss() {
        return super.zzbss();
    }

    public /* bridge */ /* synthetic */ zzad zzbst() {
        return super.zzbst();
    }

    public /* bridge */ /* synthetic */ zze zzbsu() {
        return super.zzbsu();
    }

    public /* bridge */ /* synthetic */ zzal zzbsv() {
        return super.zzbsv();
    }

    public /* bridge */ /* synthetic */ zzv zzbsw() {
        return super.zzbsw();
    }

    public /* bridge */ /* synthetic */ zzaf zzbsx() {
        return super.zzbsx();
    }

    public /* bridge */ /* synthetic */ zzw zzbsy() {
        return super.zzbsy();
    }

    public /* bridge */ /* synthetic */ zzp zzbsz() {
        return super.zzbsz();
    }

    public /* bridge */ /* synthetic */ zzt zzbta() {
        return super.zzbta();
    }

    public /* bridge */ /* synthetic */ zzd zzbtb() {
        return super.zzbtb();
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public zzb zzmc(String str) {
        zzzg();
        zzwu();
        zzab.zzhs(str);
        zzmb(str);
        return (zzb) this.alU.get(str);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public String zzmd(String str) {
        zzwu();
        return (String) this.alV.get(str);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public void zzme(String str) {
        zzwu();
        this.alV.put(str, null);
    }

    public /* bridge */ /* synthetic */ void zzwu() {
        super.zzwu();
    }

    /* access modifiers changed from: protected */
    public void zzwv() {
    }

    public /* bridge */ /* synthetic */ void zzyv() {
        super.zzyv();
    }

    public /* bridge */ /* synthetic */ zze zzyw() {
        return super.zzyw();
    }
}
