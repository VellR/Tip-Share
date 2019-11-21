package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Size;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zzf;
import com.google.android.gms.measurement.internal.UserAttributeParcel;
import com.google.android.gms.measurement.internal.zzx;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
public class AppMeasurement {
    private final zzx aja;

    public static final class zza {
        public static final Map<String, String> ajb = zzf.zzb(new String[]{"app_clear_data", "app_exception", "app_uninstall", "app_update", "firebase_campaign", "error", "first_open", "in_app_purchase", "notification_dismiss", "notification_foreground", "notification_open", "notification_receive", "os_update", "session_start", "user_engagement"}, new String[]{"_cd", "_ae", "_ui", "_au", "_cmp", "_err", "_f", "_iap", "_nd", "_nf", "_no", "_nr", "_ou", "_s", "_e"});
    }

    public interface zzb {
        @WorkerThread
        void zzb(String str, String str2, Bundle bundle, long j);
    }

    public interface zzc {
        @WorkerThread
        void zzc(String str, String str2, Bundle bundle, long j);
    }

    public static final class zzd {
        public static final Map<String, String> ajc = zzf.zzb(new String[]{"firebase_conversion", "engagement_time_msec", "firebase_error", "error_value", "firebase_event_origin", "message_device_time", "message_id", "message_name", "message_time", "previous_app_version", "previous_os_version", "topic"}, new String[]{"_c", "_et", "_err", "_ev", "_o", "_ndt", "_nmid", "_nmn", "_nmt", "_pv", "_po", "_nt"});
    }

    public static final class zze {
        public static final Map<String, String> ajd = zzf.zzb(new String[]{"firebase_last_notification", "first_open_time", "last_deep_link_referrer", "user_id"}, new String[]{"_ln", "_fot", "_ldl", "_id"});
    }

    public AppMeasurement(zzx zzx) {
        zzab.zzaa(zzx);
        this.aja = zzx;
    }

    @Keep
    @Deprecated
    public static AppMeasurement getInstance(Context context) {
        return zzx.zzdo(context).zzbun();
    }

    private void zzc(String str, String str2, Object obj) {
        this.aja.zzbsq().zzd(str, str2, obj);
    }

    @Deprecated
    public void logEvent(@Size(max = 32, min = 1) @NonNull String str, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (this.aja.zzbtb().zzabc() || !"_iap".equals(str)) {
            int zzml = this.aja.zzbsv().zzml(str);
            if (zzml != 0) {
                this.aja.zzbsv().zze(zzml, "_ev", this.aja.zzbsv().zza(str, this.aja.zzbtb().zzbrj(), true));
                return;
            }
        }
        this.aja.zzbsq().zza("app", str, bundle, true);
    }

    @Deprecated
    public void setMeasurementEnabled(boolean z) {
        this.aja.zzbsq().setMeasurementEnabled(z);
    }

    @Deprecated
    public void setMinimumSessionDuration(long j) {
        this.aja.zzbsq().setMinimumSessionDuration(j);
    }

    @Deprecated
    public void setSessionTimeoutDuration(long j) {
        this.aja.zzbsq().setSessionTimeoutDuration(j);
    }

    @Deprecated
    public void setUserId(String str) {
        zzb("app", "_id", str);
    }

    @Deprecated
    public void setUserProperty(@Size(max = 24, min = 1) @NonNull String str, @Nullable @Size(max = 36) String str2) {
        int zzmn = this.aja.zzbsv().zzmn(str);
        if (zzmn != 0) {
            this.aja.zzbsv().zze(zzmn, "_ev", this.aja.zzbsv().zza(str, this.aja.zzbtb().zzbrk(), true));
            return;
        }
        zzb("app", str, str2);
    }

    @WorkerThread
    public void zza(zzb zzb2) {
        this.aja.zzbsq().zza(zzb2);
    }

    @WorkerThread
    public void zza(zzc zzc2) {
        this.aja.zzbsq().zza(zzc2);
    }

    public void zza(String str, String str2, Bundle bundle, long j) {
        this.aja.zzbsq().zzd(str, str2, bundle == null ? new Bundle() : bundle, j);
    }

    public void zzb(String str, String str2, Object obj) {
        zzc(str, str2, obj);
    }

    @WorkerThread
    public Map<String, Object> zzbz(boolean z) {
        List<UserAttributeParcel> zzcd = this.aja.zzbsq().zzcd(z);
        HashMap hashMap = new HashMap(zzcd.size());
        for (UserAttributeParcel userAttributeParcel : zzcd) {
            hashMap.put(userAttributeParcel.name, userAttributeParcel.getValue());
        }
        return hashMap;
    }

    public void zzd(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.aja.zzbsq().zze(str, str2, bundle);
    }
}
