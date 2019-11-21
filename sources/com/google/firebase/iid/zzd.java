package com.google.firebase.iid;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import java.io.IOException;
import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;

public class zzd {
    static Map<String, zzd> abO = new HashMap();
    static String abU;
    private static zzg baQ;
    private static zzf baR;
    KeyPair abR;
    String abS = "";
    long abT;
    Context mContext;

    protected zzd(Context context, String str, Bundle bundle) {
        this.mContext = context.getApplicationContext();
        this.abS = str;
    }

    public static synchronized zzd zzb(Context context, Bundle bundle) {
        zzd zzd;
        synchronized (zzd.class) {
            String string = bundle == null ? "" : bundle.getString("subtype");
            String str = string == null ? "" : string;
            Context applicationContext = context.getApplicationContext();
            if (baQ == null) {
                baQ = new zzg(applicationContext);
                baR = new zzf(applicationContext);
            }
            abU = Integer.toString(FirebaseInstanceId.zzdf(applicationContext));
            zzd = (zzd) abO.get(str);
            if (zzd == null) {
                zzd = new zzd(applicationContext, str, bundle);
                abO.put(str, zzd);
            }
        }
        return zzd;
    }

    public long getCreationTime() {
        if (this.abT == 0) {
            String str = baQ.get(this.abS, "cre");
            if (str != null) {
                this.abT = Long.parseLong(str);
            }
        }
        return this.abT;
    }

    public String getToken(String str, String str2, Bundle bundle) throws IOException {
        boolean z = false;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        boolean z2 = true;
        String zzi = zzbmx() ? null : baQ.zzi(this.abS, str, str2);
        if (zzi == null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            if (bundle.getString("ttl") != null) {
                z2 = false;
            }
            if (!"jwt".equals(bundle.getString("type"))) {
                z = z2;
            }
            zzi = zzc(str, str2, bundle);
            if (zzi != null && z) {
                baQ.zza(this.abS, str, str2, zzi, abU);
            }
        }
        return zzi;
    }

    public void zzb(String str, String str2, Bundle bundle) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        baQ.zzj(this.abS, str, str2);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("sender", str);
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("subscription", str);
        bundle.putString("delete", "1");
        bundle.putString("X-delete", "1");
        bundle.putString("subtype", "".equals(this.abS) ? str : this.abS);
        String str3 = "X-subtype";
        if (!"".equals(this.abS)) {
            str = this.abS;
        }
        bundle.putString(str3, str);
        baR.zzs(baR.zza(bundle, zzbmt()));
    }

    /* access modifiers changed from: 0000 */
    public KeyPair zzbmt() {
        if (this.abR == null) {
            this.abR = baQ.zzki(this.abS);
        }
        if (this.abR == null) {
            this.abT = System.currentTimeMillis();
            this.abR = baQ.zze(this.abS, this.abT);
        }
        return this.abR;
    }

    public void zzbmu() {
        this.abT = 0;
        baQ.zzkj(this.abS);
        this.abR = null;
    }

    /* access modifiers changed from: 0000 */
    public boolean zzbmx() {
        String str = baQ.get("appVersion");
        if (str == null || !str.equals(abU)) {
            return true;
        }
        String str2 = baQ.get("lastToken");
        if (str2 == null) {
            return true;
        }
        return (System.currentTimeMillis() / 1000) - Long.valueOf(Long.parseLong(str2)).longValue() > 604800;
    }

    public String zzc(String str, String str2, Bundle bundle) throws IOException {
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("sender", str);
        String str3 = "".equals(this.abS) ? str : this.abS;
        if (!bundle.containsKey("legacy.register")) {
            bundle.putString("subscription", str);
            bundle.putString("subtype", str3);
            bundle.putString("X-subscription", str);
            bundle.putString("X-subtype", str3);
        }
        return baR.zzs(baR.zza(bundle, zzbmt()));
    }

    public zzg zzcxa() {
        return baQ;
    }

    public zzf zzcxb() {
        return baR;
    }
}
