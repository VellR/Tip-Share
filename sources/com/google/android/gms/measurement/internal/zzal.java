package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzaov;
import com.google.android.gms.internal.zzun.zzb;
import com.google.android.gms.internal.zzun.zzc;
import com.google.android.gms.internal.zzun.zzd;
import com.google.android.gms.internal.zzun.zze;
import com.google.android.gms.internal.zzun.zzf;
import com.google.android.gms.internal.zzup;
import com.google.android.gms.internal.zzup.zza;
import com.google.android.gms.internal.zzup.zzg;
import com.google.android.gms.measurement.AppMeasurement;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.BitSet;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class zzal extends zzz {
    zzal(zzx zzx) {
        super(zzx);
    }

    private Object zza(int i, Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        } else if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        } else {
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                return zza(String.valueOf(obj), i, z);
            }
            return null;
        }
    }

    public static String zza(zzb zzb) {
        if (zzb == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        zza(sb, 0, "filter_id", (Object) zzb.aoa);
        zza(sb, 0, "event_name", (Object) zzb.aob);
        zza(sb, 1, "event_count_filter", zzb.aoe);
        sb.append("  filters {\n");
        for (zzc zza : zzb.aoc) {
            zza(sb, 2, zza);
        }
        zza(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    public static String zza(zze zze) {
        if (zze == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        zza(sb, 0, "filter_id", (Object) zze.aoa);
        zza(sb, 0, "property_name", (Object) zze.aoq);
        zza(sb, 1, zze.aor);
        sb.append("}\n");
        return sb.toString();
    }

    private static void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    private static void zza(StringBuilder sb, int i, zzc zzc) {
        if (zzc != null) {
            zza(sb, i);
            sb.append("filter {\n");
            zza(sb, i, "complement", (Object) zzc.aoi);
            zza(sb, i, "param_name", (Object) zzc.aoj);
            zza(sb, i + 1, "string_filter", zzc.aog);
            zza(sb, i + 1, "number_filter", zzc.aoh);
            zza(sb, i);
            sb.append("}\n");
        }
    }

    private static void zza(StringBuilder sb, int i, zzup.zze zze) {
        if (zze != null) {
            zza(sb, i);
            sb.append("bundle {\n");
            zza(sb, i, "protocol_version", (Object) zze.aoR);
            zza(sb, i, "platform", (Object) zze.aoZ);
            zza(sb, i, "gmp_version", (Object) zze.apd);
            zza(sb, i, "uploading_gmp_version", (Object) zze.ape);
            zza(sb, i, "gmp_app_id", (Object) zze.ajz);
            zza(sb, i, "app_id", (Object) zze.zzck);
            zza(sb, i, "app_version", (Object) zze.abU);
            zza(sb, i, "app_version_major", (Object) zze.apm);
            zza(sb, i, "firebase_instance_id", (Object) zze.ajH);
            zza(sb, i, "dev_cert_hash", (Object) zze.api);
            zza(sb, i, "app_store", (Object) zze.ajA);
            zza(sb, i, "upload_timestamp_millis", (Object) zze.aoU);
            zza(sb, i, "start_timestamp_millis", (Object) zze.aoV);
            zza(sb, i, "end_timestamp_millis", (Object) zze.aoW);
            zza(sb, i, "previous_bundle_start_timestamp_millis", (Object) zze.aoX);
            zza(sb, i, "previous_bundle_end_timestamp_millis", (Object) zze.aoY);
            zza(sb, i, "app_instance_id", (Object) zze.aph);
            zza(sb, i, "resettable_device_id", (Object) zze.apf);
            zza(sb, i, "device_id", (Object) zze.app);
            zza(sb, i, "limited_ad_tracking", (Object) zze.apg);
            zza(sb, i, "os_version", (Object) zze.zzct);
            zza(sb, i, "device_model", (Object) zze.apa);
            zza(sb, i, "user_default_language", (Object) zze.apb);
            zza(sb, i, "time_zone_offset_minutes", (Object) zze.apc);
            zza(sb, i, "bundle_sequential_index", (Object) zze.apj);
            zza(sb, i, "service_upload", (Object) zze.apk);
            zza(sb, i, "health_monitor", (Object) zze.ajD);
            zza(sb, i, zze.aoT);
            zza(sb, i, zze.apl);
            zza(sb, i, zze.aoS);
            zza(sb, i);
            sb.append("}\n");
        }
    }

    private static void zza(StringBuilder sb, int i, String str, zzd zzd) {
        if (zzd != null) {
            zza(sb, i);
            sb.append(str);
            sb.append(" {\n");
            if (zzd.aok != null) {
                String str2 = "UNKNOWN_COMPARISON_TYPE";
                switch (zzd.aok.intValue()) {
                    case 1:
                        str2 = "LESS_THAN";
                        break;
                    case 2:
                        str2 = "GREATER_THAN";
                        break;
                    case 3:
                        str2 = "EQUAL";
                        break;
                    case 4:
                        str2 = "BETWEEN";
                        break;
                }
                zza(sb, i, "comparison_type", (Object) str2);
            }
            zza(sb, i, "match_as_float", (Object) zzd.aol);
            zza(sb, i, "comparison_value", (Object) zzd.aom);
            zza(sb, i, "min_comparison_value", (Object) zzd.aon);
            zza(sb, i, "max_comparison_value", (Object) zzd.aoo);
            zza(sb, i);
            sb.append("}\n");
        }
    }

    private static void zza(StringBuilder sb, int i, String str, zzf zzf) {
        String[] strArr;
        if (zzf != null) {
            zza(sb, i);
            sb.append(str);
            sb.append(" {\n");
            if (zzf.aos != null) {
                String str2 = "UNKNOWN_MATCH_TYPE";
                switch (zzf.aos.intValue()) {
                    case 1:
                        str2 = "REGEXP";
                        break;
                    case 2:
                        str2 = "BEGINS_WITH";
                        break;
                    case 3:
                        str2 = "ENDS_WITH";
                        break;
                    case 4:
                        str2 = "PARTIAL";
                        break;
                    case 5:
                        str2 = "EXACT";
                        break;
                    case 6:
                        str2 = "IN_LIST";
                        break;
                }
                zza(sb, i, "match_type", (Object) str2);
            }
            zza(sb, i, "expression", (Object) zzf.aot);
            zza(sb, i, "case_sensitive", (Object) zzf.aou);
            if (zzf.aov.length > 0) {
                zza(sb, i + 1);
                sb.append("expression_list {\n");
                for (String str3 : zzf.aov) {
                    zza(sb, i + 2);
                    sb.append(str3);
                    sb.append("\n");
                }
                sb.append("}\n");
            }
            zza(sb, i);
            sb.append("}\n");
        }
    }

    private static void zza(StringBuilder sb, int i, String str, zzup.zzf zzf) {
        int i2 = 0;
        if (zzf != null) {
            int i3 = i + 1;
            zza(sb, i3);
            sb.append(str);
            sb.append(" {\n");
            if (zzf.apr != null) {
                zza(sb, i3 + 1);
                sb.append("results: ");
                long[] jArr = zzf.apr;
                int length = jArr.length;
                int i4 = 0;
                int i5 = 0;
                while (i4 < length) {
                    Long valueOf = Long.valueOf(jArr[i4]);
                    int i6 = i5 + 1;
                    if (i5 != 0) {
                        sb.append(", ");
                    }
                    sb.append(valueOf);
                    i4++;
                    i5 = i6;
                }
                sb.append(10);
            }
            if (zzf.apq != null) {
                zza(sb, i3 + 1);
                sb.append("status: ");
                long[] jArr2 = zzf.apq;
                int length2 = jArr2.length;
                int i7 = 0;
                while (i2 < length2) {
                    Long valueOf2 = Long.valueOf(jArr2[i2]);
                    int i8 = i7 + 1;
                    if (i7 != 0) {
                        sb.append(", ");
                    }
                    sb.append(valueOf2);
                    i2++;
                    i7 = i8;
                }
                sb.append(10);
            }
            zza(sb, i3);
            sb.append("}\n");
        }
    }

    private static void zza(StringBuilder sb, int i, String str, Object obj) {
        if (obj != null) {
            zza(sb, i + 1);
            sb.append(str);
            sb.append(": ");
            sb.append(obj);
            sb.append(10);
        }
    }

    private static void zza(StringBuilder sb, int i, zza[] zzaArr) {
        if (zzaArr != null) {
            int i2 = i + 1;
            for (zza zza : zzaArr) {
                if (zza != null) {
                    zza(sb, i2);
                    sb.append("audience_membership {\n");
                    zza(sb, i2, "audience_id", (Object) zza.anW);
                    zza(sb, i2, "new_audience", (Object) zza.aoI);
                    zza(sb, i2, "current_data", zza.aoG);
                    zza(sb, i2, "previous_data", zza.aoH);
                    zza(sb, i2);
                    sb.append("}\n");
                }
            }
        }
    }

    private static void zza(StringBuilder sb, int i, zzup.zzb[] zzbArr) {
        if (zzbArr != null) {
            int i2 = i + 1;
            for (zzup.zzb zzb : zzbArr) {
                if (zzb != null) {
                    zza(sb, i2);
                    sb.append("event {\n");
                    zza(sb, i2, "name", (Object) zzb.name);
                    zza(sb, i2, "timestamp_millis", (Object) zzb.aoL);
                    zza(sb, i2, "previous_timestamp_millis", (Object) zzb.aoM);
                    zza(sb, i2, "count", (Object) zzb.count);
                    zza(sb, i2, zzb.aoK);
                    zza(sb, i2);
                    sb.append("}\n");
                }
            }
        }
    }

    private static void zza(StringBuilder sb, int i, zzup.zzc[] zzcArr) {
        if (zzcArr != null) {
            int i2 = i + 1;
            for (zzup.zzc zzc : zzcArr) {
                if (zzc != null) {
                    zza(sb, i2);
                    sb.append("param {\n");
                    zza(sb, i2, "name", (Object) zzc.name);
                    zza(sb, i2, "string_value", (Object) zzc.zr);
                    zza(sb, i2, "int_value", (Object) zzc.aoO);
                    zza(sb, i2, "double_value", (Object) zzc.anT);
                    zza(sb, i2);
                    sb.append("}\n");
                }
            }
        }
    }

    private static void zza(StringBuilder sb, int i, zzg[] zzgArr) {
        if (zzgArr != null) {
            int i2 = i + 1;
            for (zzg zzg : zzgArr) {
                if (zzg != null) {
                    zza(sb, i2);
                    sb.append("user_property {\n");
                    zza(sb, i2, "set_timestamp_millis", (Object) zzg.apt);
                    zza(sb, i2, "name", (Object) zzg.name);
                    zza(sb, i2, "string_value", (Object) zzg.zr);
                    zza(sb, i2, "int_value", (Object) zzg.aoO);
                    zza(sb, i2, "double_value", (Object) zzg.anT);
                    zza(sb, i2);
                    sb.append("}\n");
                }
            }
        }
    }

    public static boolean zza(long[] jArr, int i) {
        return i < jArr.length * 64 && (jArr[i / 64] & (1 << (i % 64))) != 0;
    }

    public static long[] zza(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        long[] jArr = new long[length];
        int i = 0;
        while (i < length) {
            jArr[i] = 0;
            int i2 = 0;
            while (i2 < 64 && (i * 64) + i2 < bitSet.length()) {
                if (bitSet.get((i * 64) + i2)) {
                    jArr[i] = jArr[i] | (1 << i2);
                }
                i2++;
            }
            i++;
        }
        return jArr;
    }

    static long zzac(byte[] bArr) {
        int i = 0;
        zzab.zzaa(bArr);
        zzab.zzbm(bArr.length > 0);
        long j = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            j += (((long) bArr[length]) & 255) << i;
            i += 8;
            length--;
        }
        return j;
    }

    public static boolean zzam(Bundle bundle) {
        return bundle.getLong("_c") == 1;
    }

    public static String zzb(zzup.zzd zzd) {
        zzup.zze[] zzeArr;
        if (zzd == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        if (zzd.aoP != null) {
            for (zzup.zze zze : zzd.aoP) {
                if (zze != null) {
                    zza(sb, 1, zze);
                }
            }
        }
        sb.append("}\n");
        return sb.toString();
    }

    public static boolean zzb(Context context, String str, boolean z) {
        try {
            ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, str), 2);
            if (receiverInfo != null && receiverInfo.enabled && (!z || receiverInfo.exported)) {
                return true;
            }
        } catch (NameNotFoundException e) {
        }
        return false;
    }

    public static boolean zzbb(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    static MessageDigest zzfb(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 2) {
                return null;
            }
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    return instance;
                }
                i = i2 + 1;
            } catch (NoSuchAlgorithmException e) {
            }
        }
    }

    public static boolean zzk(Context context, String str) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, str), 4);
            if (serviceInfo != null && serviceInfo.enabled) {
                return true;
            }
        } catch (NameNotFoundException e) {
        }
        return false;
    }

    static boolean zzmk(String str) {
        zzab.zzhs(str);
        return str.charAt(0) != '_';
    }

    private int zzmt(String str) {
        return "_ldl".equals(str) ? zzbtb().zzbrp() : zzbtb().zzbro();
    }

    public static boolean zzmu(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public Bundle zza(String str, Bundle bundle, @Nullable List<String> list, boolean z) {
        int i;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        int zzbri = zzbtb().zzbri();
        int i2 = 0;
        for (String str2 : bundle.keySet()) {
            if (list == null || !list.contains(str2)) {
                i = z ? zzmp(str2) : 0;
                if (i == 0) {
                    i = zzmq(str2);
                }
            } else {
                i = 0;
            }
            if (i != 0) {
                if (zzd(bundle2, i)) {
                    bundle2.putString("_ev", zza(str2, zzbtb().zzbrl(), true));
                }
                bundle2.remove(str2);
            } else if (zzk(str2, bundle.get(str2)) || "_ev".equals(str2)) {
                if (zzmk(str2)) {
                    i2++;
                    if (i2 > zzbri) {
                        zzbsz().zzbtr().zze("Event can't contain more then " + zzbri + " params", str, bundle);
                        zzd(bundle2, 5);
                        bundle2.remove(str2);
                    }
                }
                i2 = i2;
            } else {
                if (zzd(bundle2, 4)) {
                    bundle2.putString("_ev", zza(str2, zzbtb().zzbrl(), true));
                }
                bundle2.remove(str2);
            }
        }
        return bundle2;
    }

    public String zza(String str, int i, boolean z) {
        if (str.length() <= i) {
            return str;
        }
        if (z) {
            return String.valueOf(str.substring(0, i)).concat("...");
        }
        return null;
    }

    public void zza(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (str != null) {
                zzbsz().zzbtv().zze("Not putting event parameter. Invalid value type. name, type", str, obj != null ? obj.getClass().getSimpleName() : null);
            }
        }
    }

    public void zza(zzup.zzc zzc, Object obj) {
        zzab.zzaa(obj);
        zzc.zr = null;
        zzc.aoO = null;
        zzc.anT = null;
        if (obj instanceof String) {
            zzc.zr = (String) obj;
        } else if (obj instanceof Long) {
            zzc.aoO = (Long) obj;
        } else if (obj instanceof Double) {
            zzc.anT = (Double) obj;
        } else {
            zzbsz().zzbtr().zzj("Ignoring invalid (type) event param value", obj);
        }
    }

    public void zza(zzg zzg, Object obj) {
        zzab.zzaa(obj);
        zzg.zr = null;
        zzg.aoO = null;
        zzg.anT = null;
        if (obj instanceof String) {
            zzg.zr = (String) obj;
        } else if (obj instanceof Long) {
            zzg.aoO = (Long) obj;
        } else if (obj instanceof Double) {
            zzg.anT = (Double) obj;
        } else {
            zzbsz().zzbtr().zzj("Ignoring invalid (type) user attribute value", obj);
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean zza(String str, String str2, int i, Object obj) {
        if (obj == null || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Boolean) || (obj instanceof Double)) {
            return true;
        }
        if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
            return false;
        }
        String valueOf = String.valueOf(obj);
        if (valueOf.length() <= i) {
            return true;
        }
        zzbsz().zzbtt().zzd("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
        return false;
    }

    public byte[] zza(zzup.zzd zzd) {
        try {
            byte[] bArr = new byte[zzd.ao()];
            zzaov zzba = zzaov.zzba(bArr);
            zzd.zza(zzba);
            zzba.ab();
            return bArr;
        } catch (IOException e) {
            zzbsz().zzbtr().zzj("Data loss. Failed to serialize batch", e);
            return null;
        }
    }

    public byte[] zzab(byte[] bArr) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read <= 0) {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
        } catch (IOException e) {
            zzbsz().zzbtr().zzj("Failed to ungzip content", e);
            throw e;
        }
    }

    public long zzad(byte[] bArr) {
        zzab.zzaa(bArr);
        MessageDigest zzfb = zzfb("MD5");
        if (zzfb != null) {
            return zzac(zzfb.digest(bArr));
        }
        zzbsz().zzbtr().log("Failed to get MD5");
        return 0;
    }

    /* access modifiers changed from: 0000 */
    public boolean zzaz(String str, String str2) {
        if (str2 == null) {
            zzbsz().zzbtr().zzj("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzbsz().zzbtr().zzj("Name is required and can't be empty. Type", str);
            return false;
        } else if (!Character.isLetter(str2.charAt(0))) {
            zzbsz().zzbtr().zze("Name must start with a letter. Type, name", str, str2);
            return false;
        } else {
            int i = 1;
            while (i < str2.length()) {
                char charAt = str2.charAt(i);
                if (charAt == '_' || Character.isLetterOrDigit(charAt)) {
                    i++;
                } else {
                    zzbsz().zzbtr().zze("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean zzba(String str, String str2) {
        if (str2 == null) {
            zzbsz().zzbtr().zzj("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzbsz().zzbtr().zzj("Name is required and can't be empty. Type", str);
            return false;
        } else {
            char charAt = str2.charAt(0);
            if (Character.isLetter(charAt) || charAt == '_') {
                int i = 1;
                while (i < str2.length()) {
                    char charAt2 = str2.charAt(i);
                    if (charAt2 == '_' || Character.isLetterOrDigit(charAt2)) {
                        i++;
                    } else {
                        zzbsz().zzbtr().zze("Name must start with a letter or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            zzbsz().zzbtr().zze("Name must start with a letter or _ (underscores). Type, name", str, str2);
            return false;
        }
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

    /* access modifiers changed from: 0000 */
    public boolean zzc(String str, int i, String str2) {
        if (str2 == null) {
            zzbsz().zzbtr().zzj("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() <= i) {
            return true;
        } else {
            zzbsz().zzbtr().zzd("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean zzc(String str, Map<String, String> map, String str2) {
        if (str2 == null) {
            zzbsz().zzbtr().zzj("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.startsWith("firebase_")) {
            zzbsz().zzbtr().zze("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        } else if (map == null || !map.containsKey(str2)) {
            return true;
        } else {
            zzbsz().zzbtr().zze("Name is reserved. Type, name", str, str2);
            return false;
        }
    }

    public boolean zzd(Bundle bundle, int i) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i);
        return true;
    }

    public void zze(int i, String str, String str2) {
        Bundle bundle = new Bundle();
        zzd(bundle, i);
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(str, str2);
        }
        this.aja.zzbsq().zze("auto", "_err", bundle);
    }

    @WorkerThread
    public boolean zzep(String str) {
        zzwu();
        if (getContext().checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        zzbsz().zzbtx().zzj("Permission not granted", str);
        return false;
    }

    public boolean zzg(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(zzyw().currentTimeMillis() - j) > j2;
    }

    public byte[] zzj(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            zzbsz().zzbtr().zzj("Failed to gzip content", e);
            throw e;
        }
    }

    public boolean zzk(String str, Object obj) {
        return zzmu(str) ? zza("param", str, zzbtb().zzbrn(), obj) : zza("param", str, zzbtb().zzbrm(), obj);
    }

    public Object zzl(String str, Object obj) {
        if ("_ev".equals(str)) {
            return zza(zzbtb().zzbrn(), obj, true);
        }
        return zza(zzmu(str) ? zzbtb().zzbrn() : zzbtb().zzbrm(), obj, false);
    }

    public int zzm(String str, Object obj) {
        return "_ldl".equals(str) ? zza("user property referrer", str, zzmt(str), obj) : zza("user property", str, zzmt(str), obj) ? 0 : 7;
    }

    public int zzml(String str) {
        if (!zzaz("event", str)) {
            return 2;
        }
        if (!zzc("event", AppMeasurement.zza.ajb, str)) {
            return 13;
        }
        return zzc("event", zzbtb().zzbrj(), str) ? 0 : 2;
    }

    public int zzmm(String str) {
        if (!zzba("event", str)) {
            return 2;
        }
        if (!zzc("event", AppMeasurement.zza.ajb, str)) {
            return 13;
        }
        return zzc("event", zzbtb().zzbrj(), str) ? 0 : 2;
    }

    public int zzmn(String str) {
        if (!zzaz("user property", str)) {
            return 6;
        }
        if (!zzc("user property", AppMeasurement.zze.ajd, str)) {
            return 15;
        }
        return zzc("user property", zzbtb().zzbrk(), str) ? 0 : 6;
    }

    public int zzmo(String str) {
        if (!zzba("user property", str)) {
            return 6;
        }
        if (!zzc("user property", AppMeasurement.zze.ajd, str)) {
            return 15;
        }
        return zzc("user property", zzbtb().zzbrk(), str) ? 0 : 6;
    }

    public int zzmp(String str) {
        if (!zzaz("event param", str)) {
            return 3;
        }
        if (!zzc("event param", null, str)) {
            return 14;
        }
        return zzc("event param", zzbtb().zzbrl(), str) ? 0 : 3;
    }

    public int zzmq(String str) {
        if (!zzba("event param", str)) {
            return 3;
        }
        if (!zzc("event param", null, str)) {
            return 14;
        }
        return zzc("event param", zzbtb().zzbrl(), str) ? 0 : 3;
    }

    public boolean zzmr(String str) {
        if (TextUtils.isEmpty(str)) {
            zzbsz().zzbtr().log("Measurement Service called without google_app_id");
            return false;
        } else if (!str.startsWith("1:")) {
            zzbsz().zzbtt().zzj("Measurement Service called with unknown id version", str);
            return true;
        } else if (zzms(str)) {
            return true;
        } else {
            zzbsz().zzbtr().zzj("Invalid google_app_id. Firebase Analytics disabled. See", "https://goo.gl/FZRIUV");
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean zzms(String str) {
        zzab.zzaa(str);
        return str.matches("^1:\\d+:android:[a-f0-9]+$");
    }

    public Object zzn(String str, Object obj) {
        return "_ldl".equals(str) ? zza(zzmt(str), obj, true) : zza(zzmt(str), obj, false);
    }

    public /* bridge */ /* synthetic */ void zzwu() {
        super.zzwu();
    }

    public /* bridge */ /* synthetic */ void zzyv() {
        super.zzyv();
    }

    public /* bridge */ /* synthetic */ com.google.android.gms.common.util.zze zzyw() {
        return super.zzyw();
    }
}
