package com.google.android.gms.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzagg implements zzaiw {
    static final /* synthetic */ boolean $assertionsDisabled = (!zzagg.class.desiredAssertionStatus());
    private static final Charset pb = Charset.forName("UTF-8");
    private final SQLiteDatabase aPX;
    private final zzajx aPY;
    private boolean aPZ;
    private long aQa = 0;

    private static class zza extends SQLiteOpenHelper {
        static final /* synthetic */ boolean $assertionsDisabled = (!zzagg.class.desiredAssertionStatus());

        public zza(Context context, String str) {
            super(context, str, null, 2);
        }

        private void zzd(SQLiteDatabase sQLiteDatabase, String str) {
            String str2 = "DROP TABLE IF EXISTS ";
            String valueOf = String.valueOf(str);
            sQLiteDatabase.execSQL(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE serverCache (path TEXT PRIMARY KEY, value BLOB);");
            sQLiteDatabase.execSQL("CREATE TABLE writes (id INTEGER, path TEXT, type TEXT, part INTEGER, node BLOB, UNIQUE (id, part));");
            sQLiteDatabase.execSQL("CREATE TABLE trackedQueries (id INTEGER PRIMARY KEY, path TEXT, queryParams TEXT, lastUse INTEGER, complete INTEGER, active INTEGER);");
            sQLiteDatabase.execSQL("CREATE TABLE trackedKeys (id INTEGER, key TEXT);");
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (!$assertionsDisabled && i2 != 2) {
                throw new AssertionError("Why is onUpgrade() called with a different version?");
            } else if (i <= 1) {
                zzd(sQLiteDatabase, "serverCache");
                sQLiteDatabase.execSQL("CREATE TABLE serverCache (path TEXT PRIMARY KEY, value BLOB);");
                zzd(sQLiteDatabase, "complete");
                sQLiteDatabase.execSQL("CREATE TABLE trackedKeys (id INTEGER, key TEXT);");
                sQLiteDatabase.execSQL("CREATE TABLE trackedQueries (id INTEGER PRIMARY KEY, path TEXT, queryParams TEXT, lastUse INTEGER, complete INTEGER, active INTEGER);");
            } else {
                throw new AssertionError("We don't handle upgrading to " + i2);
            }
        }
    }

    public zzagg(Context context, zzahk zzahk, String str) {
        try {
            this.aPX = new zza(context, URLEncoder.encode(str, "utf-8")).getWritableDatabase();
            this.aPY = zzahk.zzrh("Persistence");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int zza(zzahr zzahr, List<String> list, int i) {
        int i2 = i + 1;
        String zzc = zzc(zzahr);
        if (!((String) list.get(i)).startsWith(zzc)) {
            throw new IllegalStateException("Extracting split nodes needs to start with path prefix");
        }
        while (i2 < list.size() && ((String) list.get(i2)).equals(zza(zzahr, i2 - i))) {
            i2++;
        }
        if (i2 < list.size()) {
            String str = (String) list.get(i2);
            String valueOf = String.valueOf(zzc);
            String valueOf2 = String.valueOf(".part-");
            if (str.startsWith(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf))) {
                throw new IllegalStateException("Run did not finish with all parts");
            }
        }
        return i2 - i;
    }

    private int zza(String str, zzahr zzahr) {
        String zzc = zzc(zzahr);
        String zzqt = zzqt(zzc);
        return this.aPX.delete(str, "path >= ? AND path < ?", new String[]{zzc, zzqt});
    }

    private Cursor zza(zzahr zzahr, String[] strArr) {
        String zzc = zzc(zzahr);
        String zzqt = zzqt(zzc);
        String[] strArr2 = new String[(zzahr.size() + 3)];
        String valueOf = String.valueOf(zzb(zzahr, strArr2));
        String valueOf2 = String.valueOf(" OR (path > ? AND path < ?)");
        String str = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        strArr2[zzahr.size() + 1] = zzc;
        strArr2[zzahr.size() + 2] = zzqt;
        return this.aPX.query("serverCache", strArr, str, strArr2, null, null, "path");
    }

    private String zza(zzahr zzahr, int i) {
        String valueOf = String.valueOf(zzc(zzahr));
        String valueOf2 = String.valueOf(String.format(".part-%04d", new Object[]{Integer.valueOf(i)}));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    private void zza(zzahr zzahr, long j, String str, byte[] bArr) {
        int i = 0;
        zzcna();
        this.aPX.delete("writes", "id = ?", new String[]{String.valueOf(j)});
        if (bArr.length >= 262144) {
            List zzc = zzc(bArr, 262144);
            while (true) {
                int i2 = i;
                if (i2 < zzc.size()) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("id", Long.valueOf(j));
                    contentValues.put("path", zzc(zzahr));
                    contentValues.put("type", str);
                    contentValues.put("part", Integer.valueOf(i2));
                    contentValues.put("node", (byte[]) zzc.get(i2));
                    this.aPX.insertWithOnConflict("writes", null, contentValues, 5);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        } else {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("id", Long.valueOf(j));
            contentValues2.put("path", zzc(zzahr));
            contentValues2.put("type", str);
            contentValues2.put("part", null);
            contentValues2.put("node", bArr);
            this.aPX.insertWithOnConflict("writes", null, contentValues2, 5);
        }
    }

    private void zza(zzahr zzahr, zzahr zzahr2, zzaja<Long> zzaja, final zzaja<Long> zzaja2, zzaix zzaix, List<zzall<zzahr, zzakm>> list) {
        if (zzaja.getValue() != null) {
            int intValue = ((Integer) zzaix.zza(Integer.valueOf(0), new com.google.android.gms.internal.zzaja.zza<Void, Integer>() {
                public Integer zza(zzahr zzahr, Void voidR, Integer num) {
                    return Integer.valueOf(zzaja2.zzak(zzahr) == null ? num.intValue() + 1 : num.intValue());
                }
            })).intValue();
            if (intValue > 0) {
                zzahr zzh = zzahr.zzh(zzahr2);
                if (this.aPY.zzcum()) {
                    this.aPY.zzh(String.format("Need to rewrite %d nodes below path %s", new Object[]{Integer.valueOf(intValue), zzh}), new Object[0]);
                }
                final zzakm zzb = zzb(zzh);
                final zzaja<Long> zzaja3 = zzaja2;
                final List<zzall<zzahr, zzakm>> list2 = list;
                final zzahr zzahr3 = zzahr2;
                zzaix.zza(null, new com.google.android.gms.internal.zzaja.zza<Void, Void>() {
                    public Void zza(zzahr zzahr, Void voidR, Void voidR2) {
                        if (zzaja3.zzak(zzahr) == null) {
                            list2.add(new zzall(zzahr3.zzh(zzahr), zzb.zzao(zzahr)));
                        }
                        return null;
                    }
                });
                return;
            }
            return;
        }
        Iterator it = zzaja.zzcsx().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            zzaka zzaka = (zzaka) entry.getKey();
            zzaix zzd = zzaix.zzd((zzaka) entry.getKey());
            zza(zzahr, zzahr2.zza(zzaka), (zzaja) entry.getValue(), zzaja2.zze(zzaka), zzd, list);
        }
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=com.google.android.gms.internal.zzakm, code=com.google.android.gms.internal.zzakm<com.google.android.gms.internal.zzakl>, for r11v0, types: [com.google.android.gms.internal.zzakm, com.google.android.gms.internal.zzakm<com.google.android.gms.internal.zzakl>] */
    private void zza(zzahr zzahr, zzakm<zzakl> zzakm, boolean z) {
        int i;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        if (!z) {
            i2 = zza("serverCache", zzahr);
            i = zzc(zzahr, (zzakm) zzakm);
        } else {
            i = 0;
            i2 = 0;
            for (zzakl zzakl : zzakm) {
                i2 += zza("serverCache", zzahr.zza(zzakl.zzcvs()));
                i = zzc(zzahr.zza(zzakl.zzcvs()), zzakl.zzcmq()) + i;
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.aPY.zzcum()) {
            this.aPY.zzh(String.format("Persisted a total of %d rows and deleted %d rows for a set at %s in %dms", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), zzahr.toString(), Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
    }

    private byte[] zzao(List<byte[]> list) {
        int i = 0;
        for (byte[] length : list) {
            i = length.length + i;
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (byte[] bArr2 : list) {
            System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
            i2 = bArr2.length + i2;
        }
        return bArr;
    }

    private zzakm zzat(byte[] bArr) {
        try {
            return zzakn.zzbs(zzalf.zzrr(new String(bArr, pb)));
        } catch (IOException e) {
            IOException iOException = e;
            String str = "Could not deserialize node: ";
            String valueOf = String.valueOf(new String(bArr, pb));
            throw new RuntimeException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), iOException);
        }
    }

    /* JADX INFO: finally extract failed */
    private zzakm zzb(zzahr zzahr) {
        zzakm zzakm;
        int i;
        zzahr zzahr2;
        boolean z;
        zzakm zzl;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        Cursor zza2 = zza(zzahr, new String[]{"path", Param.VALUE});
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        long currentTimeMillis3 = System.currentTimeMillis();
        while (zza2.moveToNext()) {
            try {
                arrayList.add(zza2.getString(0));
                arrayList2.add(zza2.getBlob(1));
            } catch (Throwable th) {
                zza2.close();
                throw th;
            }
        }
        zza2.close();
        long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
        long currentTimeMillis5 = System.currentTimeMillis();
        zzakm zzcvi = zzakf.zzcvi();
        boolean z2 = false;
        HashMap hashMap = new HashMap();
        int i2 = 0;
        while (i2 < arrayList2.size()) {
            if (((String) arrayList.get(i2)).endsWith(".part-0000")) {
                String str = (String) arrayList.get(i2);
                zzahr zzahr3 = new zzahr(str.substring(0, str.length() - ".part-0000".length()));
                int zza3 = zza(zzahr3, (List<String>) arrayList, i2);
                if (this.aPY.zzcum()) {
                    this.aPY.zzh("Loading split node with " + zza3 + " parts.", new Object[0]);
                }
                byte[] zzao = zzao(arrayList2.subList(i2, i2 + zza3));
                i = (i2 + zza3) - 1;
                zzahr2 = zzahr3;
                zzakm = zzat(zzao);
            } else {
                zzakm zzat = zzat((byte[]) arrayList2.get(i2));
                zzahr zzahr4 = new zzahr((String) arrayList.get(i2));
                zzakm = zzat;
                i = i2;
                zzahr2 = zzahr4;
            }
            if (zzahr2.zzcre() != null && zzahr2.zzcre().zzcut()) {
                hashMap.put(zzahr2, zzakm);
                z = z2;
                zzl = zzcvi;
            } else if (zzahr2.zzi(zzahr)) {
                zzalo.zzb(!z2, "Descendants of path must come after ancestors.");
                boolean z3 = z2;
                zzl = zzakm.zzao(zzahr.zza(zzahr2, zzahr));
                z = z3;
            } else if (zzahr.zzi(zzahr2)) {
                z = true;
                zzl = zzcvi.zzl(zzahr.zza(zzahr, zzahr2), zzakm);
            } else {
                throw new IllegalStateException(String.format("Loading an unrelated row with path %s for %s", new Object[]{zzahr2, zzahr}));
            }
            i2 = i + 1;
            zzcvi = zzl;
            z2 = z;
        }
        for (Entry entry : hashMap.entrySet()) {
            zzcvi = zzcvi.zzl(zzahr.zza(zzahr, (zzahr) entry.getKey()), (zzakm) entry.getValue());
        }
        long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis5;
        long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
        if (this.aPY.zzcum()) {
            this.aPY.zzh(String.format("Loaded a total of %d rows for a total of %d nodes at %s in %dms (Query: %dms, Loading: %dms, Serializing: %dms)", new Object[]{Integer.valueOf(arrayList2.size()), Integer.valueOf(zzalj.zzt(zzcvi)), zzahr, Long.valueOf(currentTimeMillis7), Long.valueOf(currentTimeMillis2), Long.valueOf(currentTimeMillis4), Long.valueOf(currentTimeMillis6)}), new Object[0]);
        }
        return zzcvi;
    }

    private static String zzb(zzahr zzahr, String[] strArr) {
        if ($assertionsDisabled || strArr.length >= zzahr.size() + 1) {
            int i = 0;
            StringBuilder sb = new StringBuilder("(");
            while (!zzahr.isEmpty()) {
                sb.append("path");
                sb.append(" = ? OR ");
                strArr[i] = zzc(zzahr);
                zzahr = zzahr.zzcrd();
                i++;
            }
            sb.append("path");
            sb.append(" = ?)");
            strArr[i] = zzc(zzahr.zzcqy());
            return sb.toString();
        }
        throw new AssertionError();
    }

    private byte[] zzbe(Object obj) {
        try {
            return zzalf.zzbu(obj).getBytes(pb);
        } catch (IOException e) {
            throw new RuntimeException("Could not serialize leaf node", e);
        }
    }

    private int zzc(zzahr zzahr, zzakm zzakm) {
        int i;
        int i2 = 0;
        long zzs = zzalj.zzs(zzakm);
        if (!(zzakm instanceof zzakb) || zzs <= 16384) {
            zzd(zzahr, zzakm);
            return 1;
        }
        if (this.aPY.zzcum()) {
            this.aPY.zzh(String.format("Node estimated serialized size at path %s of %d bytes exceeds limit of %d bytes. Splitting up.", new Object[]{zzahr, Long.valueOf(zzs), Integer.valueOf(16384)}), new Object[0]);
        }
        Iterator it = zzakm.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            zzakl zzakl = (zzakl) it.next();
            i2 = zzc(zzahr.zza(zzakl.zzcvs()), zzakl.zzcmq()) + i;
        }
        if (!zzakm.zzcux().isEmpty()) {
            zzd(zzahr.zza(zzaka.zzcur()), zzakm.zzcux());
            i++;
        }
        zzd(zzahr, zzakf.zzcvi());
        return i + 1;
    }

    private static String zzc(zzahr zzahr) {
        return zzahr.isEmpty() ? "/" : String.valueOf(zzahr.toString()).concat("/");
    }

    private static List<byte[]> zzc(byte[] bArr, int i) {
        int length = ((bArr.length - 1) / i) + 1;
        ArrayList arrayList = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            int min = Math.min(i, bArr.length - (i2 * i));
            byte[] bArr2 = new byte[min];
            System.arraycopy(bArr, i2 * i, bArr2, 0, min);
            arrayList.add(bArr2);
        }
        return arrayList;
    }

    private void zzcna() {
        zzalo.zzb(this.aPZ, "Transaction expected to already be in progress.");
    }

    private void zzd(zzahr zzahr, zzakm zzakm) {
        int i = 0;
        byte[] zzbe = zzbe(zzakm.getValue(true));
        if (zzbe.length >= 262144) {
            List zzc = zzc(zzbe, 262144);
            if (this.aPY.zzcum()) {
                this.aPY.zzh("Saving huge leaf node with " + zzc.size() + " parts.", new Object[0]);
            }
            while (true) {
                int i2 = i;
                if (i2 < zzc.size()) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("path", zza(zzahr, i2));
                    contentValues.put(Param.VALUE, (byte[]) zzc.get(i2));
                    this.aPX.insertWithOnConflict("serverCache", null, contentValues, 5);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        } else {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("path", zzc(zzahr));
            contentValues2.put(Param.VALUE, zzbe);
            this.aPX.insertWithOnConflict("serverCache", null, contentValues2, 5);
        }
    }

    private String zzp(Collection<Long> collection) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        Iterator it = collection.iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return sb.toString();
            }
            long longValue = ((Long) it.next()).longValue();
            if (!z2) {
                sb.append(",");
            }
            z = false;
            sb.append(longValue);
        }
    }

    private static String zzqt(String str) {
        if ($assertionsDisabled || str.endsWith("/")) {
            String valueOf = String.valueOf(str.substring(0, str.length() - 1));
            return new StringBuilder(String.valueOf(valueOf).length() + 1).append(valueOf).append('0').toString();
        }
        throw new AssertionError("Path keys must end with a '/'");
    }

    public void beginTransaction() {
        zzalo.zzb(!this.aPZ, "runInTransaction called when an existing transaction is already in progress.");
        if (this.aPY.zzcum()) {
            this.aPY.zzh("Starting transaction.", new Object[0]);
        }
        this.aPX.beginTransaction();
        this.aPZ = true;
        this.aQa = System.currentTimeMillis();
    }

    public void endTransaction() {
        this.aPX.endTransaction();
        this.aPZ = false;
        long currentTimeMillis = System.currentTimeMillis() - this.aQa;
        if (this.aPY.zzcum()) {
            this.aPY.zzh(String.format("Transaction completed. Elapsed: %dms", new Object[]{Long.valueOf(currentTimeMillis)}), new Object[0]);
        }
    }

    public void setTransactionSuccessful() {
        this.aPX.setTransactionSuccessful();
    }

    public zzakm zza(zzahr zzahr) {
        return zzb(zzahr);
    }

    public void zza(long j, Set<zzaka> set) {
        zzcna();
        long currentTimeMillis = System.currentTimeMillis();
        String valueOf = String.valueOf(j);
        this.aPX.delete("trackedKeys", "id = ?", new String[]{valueOf});
        for (zzaka zzaka : set) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Long.valueOf(j));
            contentValues.put("key", zzaka.asString());
            this.aPX.insertWithOnConflict("trackedKeys", null, contentValues, 5);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.aPY.zzcum()) {
            this.aPY.zzh(String.format("Set %d tracked query keys for tracked query %d in %dms", new Object[]{Integer.valueOf(set.size()), Long.valueOf(j), Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
    }

    public void zza(long j, Set<zzaka> set, Set<zzaka> set2) {
        zzcna();
        long currentTimeMillis = System.currentTimeMillis();
        String str = "id = ? AND key = ?";
        String valueOf = String.valueOf(j);
        for (zzaka asString : set2) {
            this.aPX.delete("trackedKeys", str, new String[]{valueOf, asString.asString()});
        }
        for (zzaka zzaka : set) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Long.valueOf(j));
            contentValues.put("key", zzaka.asString());
            this.aPX.insertWithOnConflict("trackedKeys", null, contentValues, 5);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.aPY.zzcum()) {
            this.aPY.zzh(String.format("Updated tracked query keys (%d added, %d removed) for tracked query id %d in %dms", new Object[]{Integer.valueOf(set.size()), Integer.valueOf(set2.size()), Long.valueOf(j), Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
    }

    public void zza(zzahr zzahr, zzahi zzahi) {
        zzcna();
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = zzahi.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            i += zza("serverCache", zzahr.zzh((zzahr) entry.getKey()));
            i2 = zzc(zzahr.zzh((zzahr) entry.getKey()), (zzakm) entry.getValue()) + i2;
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.aPY.zzcum()) {
            this.aPY.zzh(String.format("Persisted a total of %d rows and deleted %d rows for a merge at %s in %dms", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), zzahr.toString(), Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
    }

    public void zza(zzahr zzahr, zzahi zzahi, long j) {
        zzcna();
        long currentTimeMillis = System.currentTimeMillis();
        zzahr zzahr2 = zzahr;
        long j2 = j;
        zza(zzahr2, j2, "m", zzbe(zzahi.zzcs(true)));
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.aPY.zzcum()) {
            this.aPY.zzh(String.format("Persisted user merge in %dms", new Object[]{Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
    }

    public void zza(zzahr zzahr, zzaix zzaix) {
        if (zzaix.zzcsr()) {
            zzcna();
            long currentTimeMillis = System.currentTimeMillis();
            Cursor zza2 = zza(zzahr, new String[]{"rowid", "path"});
            zzaja zzaja = new zzaja(null);
            zzaja zzaja2 = new zzaja(null);
            while (zza2.moveToNext()) {
                long j = zza2.getLong(0);
                zzahr zzahr2 = new zzahr(zza2.getString(1));
                if (!zzahr.zzi(zzahr2)) {
                    zzajx zzajx = this.aPY;
                    String valueOf = String.valueOf(zzahr);
                    String valueOf2 = String.valueOf(zzahr2);
                    zzajx.warn(new StringBuilder(String.valueOf(valueOf).length() + 67 + String.valueOf(valueOf2).length()).append("We are pruning at ").append(valueOf).append(" but we have data stored higher up at ").append(valueOf2).append(". Ignoring.").toString());
                } else {
                    zzahr zza3 = zzahr.zza(zzahr, zzahr2);
                    if (zzaix.zzw(zza3)) {
                        zzaja = zzaja.zzb(zza3, Long.valueOf(j));
                    } else if (zzaix.zzx(zza3)) {
                        zzaja2 = zzaja2.zzb(zza3, Long.valueOf(j));
                    } else {
                        zzajx zzajx2 = this.aPY;
                        String valueOf3 = String.valueOf(zzahr);
                        String valueOf4 = String.valueOf(zzahr2);
                        zzajx2.warn(new StringBuilder(String.valueOf(valueOf3).length() + 88 + String.valueOf(valueOf4).length()).append("We are pruning at ").append(valueOf3).append(" and have data at ").append(valueOf4).append(" that isn't marked for pruning or keeping. Ignoring.").toString());
                    }
                }
            }
            int i = 0;
            int i2 = 0;
            if (!zzaja.isEmpty()) {
                ArrayList<zzall> arrayList = new ArrayList<>();
                zza(zzahr, zzahr.zzcqy(), zzaja, zzaja2, zzaix, arrayList);
                Collection values = zzaja.values();
                String valueOf5 = String.valueOf(zzp(values));
                this.aPX.delete("serverCache", new StringBuilder(String.valueOf(valueOf5).length() + 11).append("rowid IN (").append(valueOf5).append(")").toString(), null);
                for (zzall zzall : arrayList) {
                    zzc(zzahr.zzh((zzahr) zzall.getFirst()), (zzakm) zzall.zzcwr());
                }
                i = values.size();
                i2 = arrayList.size();
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (this.aPY.zzcum()) {
                this.aPY.zzh(String.format("Pruned %d rows with %d nodes resaved in %dms", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(currentTimeMillis2)}), new Object[0]);
            }
        }
    }

    public void zza(zzahr zzahr, zzakm zzakm) {
        zzcna();
        zza(zzahr, zzakm, false);
    }

    public void zza(zzahr zzahr, zzakm zzakm, long j) {
        zzcna();
        long currentTimeMillis = System.currentTimeMillis();
        zzahr zzahr2 = zzahr;
        long j2 = j;
        zza(zzahr2, j2, "o", zzbe(zzakm.getValue(true)));
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.aPY.zzcum()) {
            this.aPY.zzh(String.format("Persisted user overwrite in %dms", new Object[]{Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
    }

    public void zza(zzaiy zzaiy) {
        zzcna();
        long currentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Long.valueOf(zzaiy.id));
        contentValues.put("path", zzc(zzaiy.aWS.zzcmu()));
        contentValues.put("queryParams", zzaiy.aWS.zzctz().zzctx());
        contentValues.put("lastUse", Long.valueOf(zzaiy.aWT));
        contentValues.put("complete", Boolean.valueOf(zzaiy.aWU));
        contentValues.put("active", Boolean.valueOf(zzaiy.aWV));
        this.aPX.insertWithOnConflict("trackedQueries", null, contentValues, 5);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.aPY.zzcum()) {
            this.aPY.zzh(String.format("Saved new tracked query in %dms", new Object[]{Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
    }

    public void zzb(zzahr zzahr, zzakm zzakm) {
        zzcna();
        zza(zzahr, zzakm, true);
    }

    public void zzbv(long j) {
        zzcna();
        long currentTimeMillis = System.currentTimeMillis();
        int delete = this.aPX.delete("writes", "id = ?", new String[]{String.valueOf(j)});
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.aPY.zzcum()) {
            this.aPY.zzh(String.format("Deleted %d write(s) with writeId %d in %dms", new Object[]{Integer.valueOf(delete), Long.valueOf(j), Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
    }

    public void zzbw(long j) {
        zzcna();
        String valueOf = String.valueOf(j);
        this.aPX.delete("trackedQueries", "id = ?", new String[]{valueOf});
        this.aPX.delete("trackedKeys", "id = ?", new String[]{valueOf});
    }

    public void zzbx(long j) {
        zzcna();
        long currentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        contentValues.put("active", Boolean.valueOf(false));
        contentValues.put("lastUse", Long.valueOf(j));
        this.aPX.updateWithOnConflict("trackedQueries", contentValues, "active = 1", new String[0], 5);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.aPY.zzcum()) {
            this.aPY.zzh(String.format("Reset active tracked queries in %dms", new Object[]{Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
    }

    public Set<zzaka> zzby(long j) {
        return zzh(Collections.singleton(Long.valueOf(j)));
    }

    public List<zzaif> zzcmw() {
        byte[] zzao;
        zzaif zzaif;
        String[] strArr = {"id", "path", "type", "part", "node"};
        long currentTimeMillis = System.currentTimeMillis();
        Cursor query = this.aPX.query("writes", strArr, null, null, null, null, "id, part");
        ArrayList arrayList = new ArrayList();
        while (query.moveToNext()) {
            try {
                long j = query.getLong(0);
                zzahr zzahr = new zzahr(query.getString(1));
                String string = query.getString(2);
                if (query.isNull(3)) {
                    zzao = query.getBlob(4);
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    do {
                        arrayList2.add(query.getBlob(4));
                        if (!query.moveToNext()) {
                            break;
                        }
                    } while (query.getLong(0) == j);
                    query.moveToPrevious();
                    zzao = zzao(arrayList2);
                }
                Object zzrr = zzalf.zzrr(new String(zzao, pb));
                if ("o".equals(string)) {
                    zzaif = new zzaif(j, zzahr, zzakn.zzbs(zzrr), true);
                } else if ("m".equals(string)) {
                    zzaif = new zzaif(j, zzahr, zzahi.zzbx((Map) zzrr));
                } else {
                    String str = "Got invalid write type: ";
                    String valueOf = String.valueOf(string);
                    throw new IllegalStateException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                }
                arrayList.add(zzaif);
            } catch (IOException e) {
                throw new RuntimeException("Failed to load writes", e);
            } catch (Throwable th) {
                query.close();
                throw th;
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.aPY.zzcum()) {
            this.aPY.zzh(String.format("Loaded %d writes in %dms", new Object[]{Integer.valueOf(arrayList.size()), Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
        query.close();
        return arrayList;
    }

    public long zzcmx() {
        Cursor rawQuery = this.aPX.rawQuery(String.format("SELECT sum(length(%s) + length(%s)) FROM %s", new Object[]{Param.VALUE, "path", "serverCache"}), null);
        try {
            if (rawQuery.moveToFirst()) {
                return rawQuery.getLong(0);
            }
            throw new IllegalStateException("Couldn't read database result!");
        } finally {
            rawQuery.close();
        }
    }

    public List<zzaiy> zzcmy() {
        String[] strArr = {"id", "path", "queryParams", "lastUse", "complete", "active"};
        long currentTimeMillis = System.currentTimeMillis();
        Cursor query = this.aPX.query("trackedQueries", strArr, null, null, null, null, "id");
        ArrayList arrayList = new ArrayList();
        while (query.moveToNext()) {
            try {
                arrayList.add(new zzaiy(query.getLong(0), zzajm.zzb(new zzahr(query.getString(1)), zzalf.zzrq(query.getString(2))), query.getLong(3), query.getInt(4) != 0, query.getInt(5) != 0));
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (Throwable th) {
                query.close();
                throw th;
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.aPY.zzcum()) {
            this.aPY.zzh(String.format("Loaded %d tracked queries in %dms", new Object[]{Integer.valueOf(arrayList.size()), Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
        query.close();
        return arrayList;
    }

    public void zzcmz() {
        zzcna();
        long currentTimeMillis = System.currentTimeMillis();
        int delete = this.aPX.delete("writes", null, null);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.aPY.zzcum()) {
            this.aPY.zzh(String.format("Deleted %d (all) write(s) in %dms", new Object[]{Integer.valueOf(delete), Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
    }

    public Set<zzaka> zzh(Set<Long> set) {
        String[] strArr = {"key"};
        long currentTimeMillis = System.currentTimeMillis();
        String valueOf = String.valueOf("id IN (");
        String valueOf2 = String.valueOf(zzp(set));
        Cursor query = this.aPX.query(true, "trackedKeys", strArr, new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length()).append(valueOf).append(valueOf2).append(")").toString(), null, null, null, null, null);
        HashSet hashSet = new HashSet();
        while (query.moveToNext()) {
            try {
                hashSet.add(zzaka.zzrm(query.getString(0)));
            } finally {
                query.close();
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.aPY.zzcum()) {
            this.aPY.zzh(String.format("Loaded %d tracked queries keys for tracked queries %s in %dms", new Object[]{Integer.valueOf(hashSet.size()), set.toString(), Long.valueOf(currentTimeMillis2)}), new Object[0]);
        }
        return hashSet;
    }
}
