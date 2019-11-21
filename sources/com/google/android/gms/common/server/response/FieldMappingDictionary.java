package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FieldMappingDictionary extends AbstractSafeParcelable {
    public static final zzc CREATOR = new zzc();
    private final int mVersionCode;
    private final HashMap<String, Map<String, Field<?, ?>>> zD;
    private final ArrayList<Entry> zE = null;
    private final String zF;

    public static class Entry extends AbstractSafeParcelable {
        public static final zzd CREATOR = new zzd();
        final String className;
        final int versionCode;
        final ArrayList<FieldMapPair> zG;

        Entry(int i, String str, ArrayList<FieldMapPair> arrayList) {
            this.versionCode = i;
            this.className = str;
            this.zG = arrayList;
        }

        Entry(String str, Map<String, Field<?, ?>> map) {
            this.versionCode = 1;
            this.className = str;
            this.zG = zzat(map);
        }

        private static ArrayList<FieldMapPair> zzat(Map<String, Field<?, ?>> map) {
            if (map == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : map.keySet()) {
                arrayList.add(new FieldMapPair(str, (Field) map.get(str)));
            }
            return arrayList;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzd zzd = CREATOR;
            zzd.zza(this, parcel, i);
        }

        /* access modifiers changed from: 0000 */
        public HashMap<String, Field<?, ?>> zzaug() {
            HashMap<String, Field<?, ?>> hashMap = new HashMap<>();
            int size = this.zG.size();
            for (int i = 0; i < size; i++) {
                FieldMapPair fieldMapPair = (FieldMapPair) this.zG.get(i);
                hashMap.put(fieldMapPair.zzcb, fieldMapPair.zH);
            }
            return hashMap;
        }
    }

    public static class FieldMapPair extends AbstractSafeParcelable {
        public static final zzb CREATOR = new zzb();
        final int versionCode;
        final Field<?, ?> zH;
        final String zzcb;

        FieldMapPair(int i, String str, Field<?, ?> field) {
            this.versionCode = i;
            this.zzcb = str;
            this.zH = field;
        }

        FieldMapPair(String str, Field<?, ?> field) {
            this.versionCode = 1;
            this.zzcb = str;
            this.zH = field;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzb zzb = CREATOR;
            zzb.zza(this, parcel, i);
        }
    }

    FieldMappingDictionary(int i, ArrayList<Entry> arrayList, String str) {
        this.mVersionCode = i;
        this.zD = zzi(arrayList);
        this.zF = (String) zzab.zzaa(str);
        zzaud();
    }

    private static HashMap<String, Map<String, Field<?, ?>>> zzi(ArrayList<Entry> arrayList) {
        HashMap<String, Map<String, Field<?, ?>>> hashMap = new HashMap<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Entry entry = (Entry) arrayList.get(i);
            hashMap.put(entry.className, entry.zzaug());
        }
        return hashMap;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.zD.keySet()) {
            sb.append(str).append(":\n");
            Map map = (Map) this.zD.get(str);
            for (String str2 : map.keySet()) {
                sb.append("  ").append(str2).append(": ");
                sb.append(map.get(str2));
            }
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc zzc = CREATOR;
        zzc.zza(this, parcel, i);
    }

    public void zzaud() {
        for (String str : this.zD.keySet()) {
            Map map = (Map) this.zD.get(str);
            for (String str2 : map.keySet()) {
                ((Field) map.get(str2)).zza(this);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public ArrayList<Entry> zzaue() {
        ArrayList<Entry> arrayList = new ArrayList<>();
        for (String str : this.zD.keySet()) {
            arrayList.add(new Entry(str, (Map) this.zD.get(str)));
        }
        return arrayList;
    }

    public String zzauf() {
        return this.zF;
    }

    public Map<String, Field<?, ?>> zzhx(String str) {
        return (Map) this.zD.get(str);
    }
}
