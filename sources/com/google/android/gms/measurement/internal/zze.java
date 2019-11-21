package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzaou;
import com.google.android.gms.internal.zzaov;
import com.google.android.gms.internal.zzup.zzf;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zze extends zzaa {
    /* access modifiers changed from: private */
    public static final Map<String, String> ajJ = new ArrayMap(16);
    private final zzc ajK = new zzc(getContext(), zzaab());
    /* access modifiers changed from: private */
    public final zzah ajL = new zzah(zzyw());

    public static class zza {
        long ajM;
        long ajN;
        long ajO;
        long ajP;
    }

    interface zzb {
        boolean zza(long j, com.google.android.gms.internal.zzup.zzb zzb);

        void zzc(com.google.android.gms.internal.zzup.zze zze);
    }

    private class zzc extends SQLiteOpenHelper {
        zzc(Context context, String str) {
            super(context, str, null, 1);
        }

        @WorkerThread
        private void zza(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, Map<String, String> map) throws SQLiteException {
            if (!zzb(sQLiteDatabase, str)) {
                sQLiteDatabase.execSQL(str2);
            }
            try {
                zza(sQLiteDatabase, str, str3, map);
            } catch (SQLiteException e) {
                zze.this.zzbsz().zzbtr().zzj("Failed to verify columns on table that was just created", str);
                throw e;
            }
        }

        @WorkerThread
        private void zza(SQLiteDatabase sQLiteDatabase, String str, String str2, Map<String, String> map) throws SQLiteException {
            String[] split;
            Set zzc = zzc(sQLiteDatabase, str);
            for (String str3 : str2.split(",")) {
                if (!zzc.remove(str3)) {
                    throw new SQLiteException(new StringBuilder(String.valueOf(str).length() + 35 + String.valueOf(str3).length()).append("Table ").append(str).append(" is missing required column: ").append(str3).toString());
                }
            }
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    if (!zzc.remove(entry.getKey())) {
                        sQLiteDatabase.execSQL((String) entry.getValue());
                    }
                }
            }
            if (!zzc.isEmpty()) {
                throw new SQLiteException(new StringBuilder(String.valueOf(str).length() + 30).append("Table ").append(str).append(" table has extra columns").toString());
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0041  */
        @WorkerThread
        private boolean zzb(SQLiteDatabase sQLiteDatabase, String str) {
            Cursor cursor;
            Cursor cursor2 = null;
            try {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                cursor = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    boolean moveToFirst = cursor.moveToFirst();
                    if (cursor == null) {
                        return moveToFirst;
                    }
                    cursor.close();
                    return moveToFirst;
                } catch (SQLiteException e) {
                    e = e;
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th) {
                th = th;
                if (cursor2 != null) {
                }
                throw th;
            }
            try {
                zze.this.zzbsz().zzbtt().zze("Error querying for table", str, e);
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        }

        @WorkerThread
        private Set<String> zzc(SQLiteDatabase sQLiteDatabase, String str) {
            HashSet hashSet = new HashSet();
            Cursor rawQuery = sQLiteDatabase.rawQuery(new StringBuilder(String.valueOf(str).length() + 22).append("SELECT * FROM ").append(str).append(" LIMIT 0").toString(), null);
            try {
                Collections.addAll(hashSet, rawQuery.getColumnNames());
                return hashSet;
            } finally {
                rawQuery.close();
            }
        }

        @WorkerThread
        public SQLiteDatabase getWritableDatabase() {
            if (!zze.this.ajL.zzx(zze.this.zzbtb().zzbrw())) {
                throw new SQLiteException("Database open failed");
            }
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException e) {
                zze.this.ajL.start();
                zze.this.zzbsz().zzbtr().log("Opening the database failed, dropping and recreating it");
                zze.this.getContext().getDatabasePath(zze.this.zzaab()).delete();
                try {
                    SQLiteDatabase writableDatabase = super.getWritableDatabase();
                    zze.this.ajL.clear();
                    return writableDatabase;
                } catch (SQLiteException e2) {
                    zze.this.zzbsz().zzbtr().zzj("Failed to open freshly created database", e2);
                    throw e2;
                }
            }
        }

        @WorkerThread
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            if (VERSION.SDK_INT >= 9) {
                File file = new File(sQLiteDatabase.getPath());
                file.setReadable(false, false);
                file.setWritable(false, false);
                file.setReadable(true, true);
                file.setWritable(true, true);
            }
        }

        @WorkerThread
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (VERSION.SDK_INT < 15) {
                Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            zza(sQLiteDatabase, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", null);
            zza(sQLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", null);
            zza(sQLiteDatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", zze.ajJ);
            zza(sQLiteDatabase, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", null);
            zza(sQLiteDatabase, "raw_events_metadata", "CREATE TABLE IF NOT EXISTS raw_events_metadata ( app_id TEXT NOT NULL, metadata_fingerprint INTEGER NOT NULL, metadata BLOB NOT NULL, PRIMARY KEY (app_id, metadata_fingerprint));", "app_id,metadata_fingerprint,metadata", null);
            zza(sQLiteDatabase, "raw_events", "CREATE TABLE IF NOT EXISTS raw_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, timestamp INTEGER NOT NULL, metadata_fingerprint INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,name,timestamp,metadata_fingerprint,data", null);
            zza(sQLiteDatabase, "event_filters", "CREATE TABLE IF NOT EXISTS event_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, event_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, event_name, audience_id, filter_id));", "app_id,audience_id,filter_id,event_name,data", null);
            zza(sQLiteDatabase, "property_filters", "CREATE TABLE IF NOT EXISTS property_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, property_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, property_name, audience_id, filter_id));", "app_id,audience_id,filter_id,property_name,data", null);
            zza(sQLiteDatabase, "audience_filter_values", "CREATE TABLE IF NOT EXISTS audience_filter_values ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, current_results BLOB, PRIMARY KEY (app_id, audience_id));", "app_id,audience_id,current_results", null);
        }

        @WorkerThread
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    static {
        ajJ.put("app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;");
        ajJ.put("app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;");
        ajJ.put("gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;");
        ajJ.put("dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;");
        ajJ.put("measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;");
        ajJ.put("last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;");
        ajJ.put("day", "ALTER TABLE apps ADD COLUMN day INTEGER;");
        ajJ.put("daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;");
        ajJ.put("daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;");
        ajJ.put("daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;");
        ajJ.put("remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;");
        ajJ.put("config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;");
        ajJ.put("failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;");
        ajJ.put("app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;");
        ajJ.put("firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;");
        ajJ.put("daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;");
    }

    zze(zzx zzx) {
        super(zzx);
    }

    @WorkerThread
    @TargetApi(11)
    static int zza(Cursor cursor, int i) {
        if (VERSION.SDK_INT >= 11) {
            return cursor.getType(i);
        }
        CursorWindow window = ((SQLiteCursor) cursor).getWindow();
        int position = cursor.getPosition();
        if (window.isNull(position, i)) {
            return 0;
        }
        if (window.isLong(position, i)) {
            return 1;
        }
        if (window.isFloat(position, i)) {
            return 2;
        }
        if (window.isString(position, i)) {
            return 3;
        }
        return window.isBlob(position, i) ? 4 : -1;
    }

    @WorkerThread
    private long zza(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = getWritableDatabase().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                j = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } else if (rawQuery != null) {
                rawQuery.close();
            }
            return j;
        } catch (SQLiteException e) {
            zzbsz().zzbtr().zze("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    @WorkerThread
    private void zza(String str, com.google.android.gms.internal.zzun.zza zza2) {
        boolean z = false;
        zzzg();
        zzwu();
        zzab.zzhs(str);
        zzab.zzaa(zza2);
        zzab.zzaa(zza2.anY);
        zzab.zzaa(zza2.anX);
        if (zza2.anW == null) {
            zzbsz().zzbtt().log("Audience with no ID");
            return;
        }
        int intValue = zza2.anW.intValue();
        for (com.google.android.gms.internal.zzun.zzb zzb2 : zza2.anY) {
            if (zzb2.aoa == null) {
                zzbsz().zzbtt().zze("Event filter with no ID. Audience definition ignored. appId, audienceId", str, zza2.anW);
                return;
            }
        }
        for (com.google.android.gms.internal.zzun.zze zze : zza2.anX) {
            if (zze.aoa == null) {
                zzbsz().zzbtt().zze("Property filter with no ID. Audience definition ignored. appId, audienceId", str, zza2.anW);
                return;
            }
        }
        boolean z2 = true;
        com.google.android.gms.internal.zzun.zzb[] zzbArr = zza2.anY;
        int length = zzbArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            } else if (!zza(str, intValue, zzbArr[i])) {
                z2 = false;
                break;
            } else {
                i++;
            }
        }
        if (z2) {
            com.google.android.gms.internal.zzun.zze[] zzeArr = zza2.anX;
            int length2 = zzeArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length2) {
                    break;
                } else if (!zza(str, intValue, zzeArr[i2])) {
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                zzz(str, intValue);
                return;
            }
            return;
        }
        z = z2;
        if (z) {
        }
    }

    @WorkerThread
    private boolean zza(String str, int i, com.google.android.gms.internal.zzun.zzb zzb2) {
        zzzg();
        zzwu();
        zzab.zzhs(str);
        zzab.zzaa(zzb2);
        if (TextUtils.isEmpty(zzb2.aob)) {
            zzbsz().zzbtt().zze("Event filter had no event name. Audience definition ignored. audienceId, filterId", Integer.valueOf(i), String.valueOf(zzb2.aoa));
            return false;
        }
        try {
            byte[] bArr = new byte[zzb2.ao()];
            zzaov zzba = zzaov.zzba(bArr);
            zzb2.zza(zzba);
            zzba.ab();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", zzb2.aoa);
            contentValues.put("event_name", zzb2.aob);
            contentValues.put("data", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("event_filters", null, contentValues, 5) == -1) {
                    zzbsz().zzbtr().log("Failed to insert event filter (got -1)");
                }
                return true;
            } catch (SQLiteException e) {
                zzbsz().zzbtr().zzj("Error storing event filter", e);
                return false;
            }
        } catch (IOException e2) {
            zzbsz().zzbtr().zzj("Configuration loss. Failed to serialize event filter", e2);
            return false;
        }
    }

    @WorkerThread
    private boolean zza(String str, int i, com.google.android.gms.internal.zzun.zze zze) {
        zzzg();
        zzwu();
        zzab.zzhs(str);
        zzab.zzaa(zze);
        if (TextUtils.isEmpty(zze.aoq)) {
            zzbsz().zzbtt().zze("Property filter had no property name. Audience definition ignored. audienceId, filterId", Integer.valueOf(i), String.valueOf(zze.aoa));
            return false;
        }
        try {
            byte[] bArr = new byte[zze.ao()];
            zzaov zzba = zzaov.zzba(bArr);
            zze.zza(zzba);
            zzba.ab();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", zze.aoa);
            contentValues.put("property_name", zze.aoq);
            contentValues.put("data", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                    return true;
                }
                zzbsz().zzbtr().log("Failed to insert property filter (got -1)");
                return false;
            } catch (SQLiteException e) {
                zzbsz().zzbtr().zzj("Error storing property filter", e);
                return false;
            }
        } catch (IOException e2) {
            zzbsz().zzbtr().zzj("Configuration loss. Failed to serialize property filter", e2);
            return false;
        }
    }

    @WorkerThread
    private long zzb(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            zzbsz().zzbtr().zze("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private boolean zzbti() {
        return getContext().getDatabasePath(zzaab()).exists();
    }

    @WorkerThread
    public void beginTransaction() {
        zzzg();
        getWritableDatabase().beginTransaction();
    }

    @WorkerThread
    public void endTransaction() {
        zzzg();
        getWritableDatabase().endTransaction();
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public SQLiteDatabase getWritableDatabase() {
        zzwu();
        try {
            return this.ajK.getWritableDatabase();
        } catch (SQLiteException e) {
            zzbsz().zzbtt().zzj("Error opening database", e);
            throw e;
        }
    }

    @WorkerThread
    public void setTransactionSuccessful() {
        zzzg();
        getWritableDatabase().setTransactionSuccessful();
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x010b  */
    @WorkerThread
    public zza zza(long j, String str, boolean z, boolean z2, boolean z3) {
        Cursor cursor;
        zzab.zzhs(str);
        zzwu();
        zzzg();
        String[] strArr = {str};
        zza zza2 = new zza();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            cursor = writableDatabase.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (!cursor.moveToFirst()) {
                    zzbsz().zzbtt().zzj("Not updating daily counts, app is not known", str);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return zza2;
                }
                if (cursor.getLong(0) == j) {
                    zza2.ajN = cursor.getLong(1);
                    zza2.ajM = cursor.getLong(2);
                    zza2.ajO = cursor.getLong(3);
                    zza2.ajP = cursor.getLong(4);
                }
                zza2.ajN++;
                if (z) {
                    zza2.ajM++;
                }
                if (z2) {
                    zza2.ajO++;
                }
                if (z3) {
                    zza2.ajP++;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("day", Long.valueOf(j));
                contentValues.put("daily_public_events_count", Long.valueOf(zza2.ajM));
                contentValues.put("daily_events_count", Long.valueOf(zza2.ajN));
                contentValues.put("daily_conversions_count", Long.valueOf(zza2.ajO));
                contentValues.put("daily_error_events_count", Long.valueOf(zza2.ajP));
                writableDatabase.update("apps", contentValues, "app_id=?", strArr);
                if (cursor != null) {
                    cursor.close();
                }
                return zza2;
            } catch (SQLiteException e) {
                e = e;
                try {
                    zzbsz().zzbtr().zzj("Error updating daily counts", e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return zza2;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public void zza(ContentValues contentValues, String str, Object obj) {
        zzab.zzhs(str);
        zzab.zzaa(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    @WorkerThread
    public void zza(com.google.android.gms.internal.zzup.zze zze) {
        zzwu();
        zzzg();
        zzab.zzaa(zze);
        zzab.zzhs(zze.zzck);
        zzab.zzaa(zze.aoW);
        zzbtd();
        long currentTimeMillis = zzyw().currentTimeMillis();
        if (zze.aoW.longValue() < currentTimeMillis - zzbtb().zzbsb() || zze.aoW.longValue() > zzbtb().zzbsb() + currentTimeMillis) {
            zzbsz().zzbtt().zze("Storing bundle outside of the max uploading time span. now, timestamp", Long.valueOf(currentTimeMillis), zze.aoW);
        }
        try {
            byte[] bArr = new byte[zze.ao()];
            zzaov zzba = zzaov.zzba(bArr);
            zze.zza(zzba);
            zzba.ab();
            byte[] zzj = zzbsv().zzj(bArr);
            zzbsz().zzbty().zzj("Saving bundle, size", Integer.valueOf(zzj.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zze.zzck);
            contentValues.put("bundle_end_timestamp", zze.aoW);
            contentValues.put("data", zzj);
            try {
                if (getWritableDatabase().insert("queue", null, contentValues) == -1) {
                    zzbsz().zzbtr().log("Failed to insert bundle (got -1)");
                }
            } catch (SQLiteException e) {
                zzbsz().zzbtr().zzj("Error storing bundle", e);
            }
        } catch (IOException e2) {
            zzbsz().zzbtr().zzj("Data loss. Failed to serialize bundle", e2);
        }
    }

    @WorkerThread
    public void zza(zza zza2) {
        zzab.zzaa(zza2);
        zzwu();
        zzzg();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zza2.zzsi());
        contentValues.put("app_instance_id", zza2.zzawj());
        contentValues.put("gmp_app_id", zza2.zzbqo());
        contentValues.put("resettable_device_id_hash", zza2.zzbqp());
        contentValues.put("last_bundle_index", Long.valueOf(zza2.zzbqy()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zza2.zzbqr()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zza2.zzbqs()));
        contentValues.put("app_version", zza2.zzxc());
        contentValues.put("app_store", zza2.zzbqu());
        contentValues.put("gmp_version", Long.valueOf(zza2.zzbqv()));
        contentValues.put("dev_cert_hash", Long.valueOf(zza2.zzbqw()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zza2.zzbqx()));
        contentValues.put("day", Long.valueOf(zza2.zzbrc()));
        contentValues.put("daily_public_events_count", Long.valueOf(zza2.zzbrd()));
        contentValues.put("daily_events_count", Long.valueOf(zza2.zzbre()));
        contentValues.put("daily_conversions_count", Long.valueOf(zza2.zzbrf()));
        contentValues.put("config_fetched_time", Long.valueOf(zza2.zzbqz()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zza2.zzbra()));
        contentValues.put("app_version_int", Long.valueOf(zza2.zzbqt()));
        contentValues.put("firebase_instance_id", zza2.zzbqq());
        contentValues.put("daily_error_events_count", Long.valueOf(zza2.zzbrg()));
        try {
            if (getWritableDatabase().insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzbsz().zzbtr().log("Failed to insert/update app (got -1)");
            }
        } catch (SQLiteException e) {
            zzbsz().zzbtr().zzj("Error storing app", e);
        }
    }

    public void zza(zzh zzh, long j) {
        zzwu();
        zzzg();
        zzab.zzaa(zzh);
        zzab.zzhs(zzh.zzcjj);
        com.google.android.gms.internal.zzup.zzb zzb2 = new com.google.android.gms.internal.zzup.zzb();
        zzb2.aoM = Long.valueOf(zzh.ajX);
        zzb2.aoK = new com.google.android.gms.internal.zzup.zzc[zzh.ajY.size()];
        Iterator it = zzh.ajY.iterator();
        int i = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            com.google.android.gms.internal.zzup.zzc zzc2 = new com.google.android.gms.internal.zzup.zzc();
            int i2 = i + 1;
            zzb2.aoK[i] = zzc2;
            zzc2.name = str;
            zzbsv().zza(zzc2, zzh.ajY.get(str));
            i = i2;
        }
        try {
            byte[] bArr = new byte[zzb2.ao()];
            zzaov zzba = zzaov.zzba(bArr);
            zzb2.zza(zzba);
            zzba.ab();
            zzbsz().zzbty().zze("Saving event, name, data size", zzh.mName, Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzh.zzcjj);
            contentValues.put("name", zzh.mName);
            contentValues.put("timestamp", Long.valueOf(zzh.pz));
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put("data", bArr);
            try {
                if (getWritableDatabase().insert("raw_events", null, contentValues) == -1) {
                    zzbsz().zzbtr().log("Failed to insert raw event (got -1)");
                }
            } catch (SQLiteException e) {
                zzbsz().zzbtr().zzj("Error storing raw event", e);
            }
        } catch (IOException e2) {
            zzbsz().zzbtr().zzj("Data loss. Failed to serialize event params/data", e2);
        }
    }

    @WorkerThread
    public void zza(zzi zzi) {
        zzab.zzaa(zzi);
        zzwu();
        zzzg();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzi.zzcjj);
        contentValues.put("name", zzi.mName);
        contentValues.put("lifetime_count", Long.valueOf(zzi.ajZ));
        contentValues.put("current_bundle_count", Long.valueOf(zzi.aka));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzi.akb));
        try {
            if (getWritableDatabase().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                zzbsz().zzbtr().log("Failed to insert/update event aggregates (got -1)");
            }
        } catch (SQLiteException e) {
            zzbsz().zzbtr().zzj("Error storing event aggregates", e);
        }
    }

    /* access modifiers changed from: 0000 */
    public void zza(String str, int i, zzf zzf) {
        zzzg();
        zzwu();
        zzab.zzhs(str);
        zzab.zzaa(zzf);
        try {
            byte[] bArr = new byte[zzf.ao()];
            zzaov zzba = zzaov.zzba(bArr);
            zzf.zza(zzba);
            zzba.ab();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("current_results", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                    zzbsz().zzbtr().log("Failed to insert filter results (got -1)");
                }
            } catch (SQLiteException e) {
                zzbsz().zzbtr().zzj("Error storing filter results", e);
            }
        } catch (IOException e2) {
            zzbsz().zzbtr().zzj("Configuration loss. Failed to serialize filter results", e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:72:0x017a, code lost:
        r2 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x017a A[ExcHandler: SQLiteException (e android.database.sqlite.SQLiteException), Splitter:B:1:0x000a] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0193  */
    public void zza(String str, long j, zzb zzb2) {
        Cursor cursor;
        String str2;
        Cursor cursor2 = null;
        zzab.zzaa(zzb2);
        zzwu();
        zzzg();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (TextUtils.isEmpty(str)) {
                Cursor rawQuery = writableDatabase.rawQuery("select app_id, metadata_fingerprint from raw_events where app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;", new String[]{String.valueOf(j)});
                if (rawQuery.moveToFirst()) {
                    str = rawQuery.getString(0);
                    String string = rawQuery.getString(1);
                    rawQuery.close();
                    str2 = string;
                    cursor = rawQuery;
                } else if (rawQuery != null) {
                    rawQuery.close();
                    return;
                } else {
                    return;
                }
            } else {
                Cursor rawQuery2 = writableDatabase.rawQuery("select metadata_fingerprint from raw_events where app_id = ? order by rowid limit 1;", new String[]{str});
                if (rawQuery2.moveToFirst()) {
                    String string2 = rawQuery2.getString(0);
                    rawQuery2.close();
                    str2 = string2;
                    cursor = rawQuery2;
                } else if (rawQuery2 != null) {
                    rawQuery2.close();
                    return;
                } else {
                    return;
                }
            }
            try {
                cursor = writableDatabase.query("raw_events_metadata", new String[]{"metadata"}, "app_id=? and metadata_fingerprint=?", new String[]{str, str2}, null, null, "rowid", "2");
                if (!cursor.moveToFirst()) {
                    zzbsz().zzbtr().log("Raw event metadata record is missing");
                    if (cursor != null) {
                        cursor.close();
                        return;
                    }
                    return;
                }
                zzaou zzaz = zzaou.zzaz(cursor.getBlob(0));
                com.google.android.gms.internal.zzup.zze zze = new com.google.android.gms.internal.zzup.zze();
                try {
                    com.google.android.gms.internal.zzup.zze zze2 = (com.google.android.gms.internal.zzup.zze) zze.zzb(zzaz);
                    if (cursor.moveToNext()) {
                        zzbsz().zzbtt().log("Get multiple raw event metadata records, expected one");
                    }
                    cursor.close();
                    zzb2.zzc(zze);
                    Cursor query = writableDatabase.query("raw_events", new String[]{"rowid", "name", "timestamp", "data"}, "app_id=? and metadata_fingerprint=?", new String[]{str, str2}, null, null, "rowid", null);
                    if (!query.moveToFirst()) {
                        zzbsz().zzbtt().log("Raw event data disappeared while in transaction");
                        if (query != null) {
                            query.close();
                            return;
                        }
                        return;
                    }
                    do {
                        long j2 = query.getLong(0);
                        zzaou zzaz2 = zzaou.zzaz(query.getBlob(3));
                        com.google.android.gms.internal.zzup.zzb zzb3 = new com.google.android.gms.internal.zzup.zzb();
                        try {
                            com.google.android.gms.internal.zzup.zzb zzb4 = (com.google.android.gms.internal.zzup.zzb) zzb3.zzb(zzaz2);
                            zzb3.name = query.getString(1);
                            zzb3.aoL = Long.valueOf(query.getLong(2));
                            if (!zzb2.zza(j2, zzb3)) {
                                if (query != null) {
                                    query.close();
                                    return;
                                }
                                return;
                            }
                        } catch (IOException e) {
                            zzbsz().zzbtr().zze("Data loss. Failed to merge raw event", str, e);
                        }
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                } catch (IOException e2) {
                    zzbsz().zzbtr().zze("Data loss. Failed to merge raw event metadata", str, e2);
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            } catch (SQLiteException e3) {
                e = e3;
                cursor2 = cursor;
                try {
                    zzbsz().zzbtr().zzj("Data loss. Error selecting raw event", e);
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursor2;
                    if (cursor != null) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e4) {
        } catch (Throwable th3) {
            th = th3;
            cursor = cursor2;
            if (cursor != null) {
            }
            throw th;
        }
    }

    @WorkerThread
    public boolean zza(zzak zzak) {
        zzab.zzaa(zzak);
        zzwu();
        zzzg();
        if (zzas(zzak.zzcjj, zzak.mName) == null) {
            if (zzal.zzmk(zzak.mName)) {
                if (zzb("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzak.zzcjj}) >= ((long) zzbtb().zzbru())) {
                    return false;
                }
            } else {
                if (zzb("select count(1) from user_attributes where app_id=?", new String[]{zzak.zzcjj}) >= ((long) zzbtb().zzbrv())) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzak.zzcjj);
        contentValues.put("name", zzak.mName);
        contentValues.put("set_timestamp", Long.valueOf(zzak.anU));
        zza(contentValues, Param.VALUE, zzak.zzcnr);
        try {
            if (getWritableDatabase().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                zzbsz().zzbtr().log("Failed to insert/update user property (got -1)");
            }
        } catch (SQLiteException e) {
            zzbsz().zzbtr().zzj("Error storing user property", e);
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    public String zzaab() {
        if (!zzbtb().zzabc()) {
            return zzbtb().zzacc();
        }
        if (zzbtb().zzabd()) {
            return zzbtb().zzacc();
        }
        zzbsz().zzbtu().log("Using secondary database");
        return zzbtb().zzacd();
    }

    public void zzac(List<Long> list) {
        zzab.zzaa(list);
        zzwu();
        zzzg();
        StringBuilder sb = new StringBuilder("rowid in (");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                break;
            }
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(((Long) list.get(i2)).longValue());
            i = i2 + 1;
        }
        sb.append(")");
        int delete = getWritableDatabase().delete("raw_events", sb.toString(), null);
        if (delete != list.size()) {
            zzbsz().zzbtr().zze("Deleted fewer rows from raw events table than expected", Integer.valueOf(delete), Integer.valueOf(list.size()));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x008c  */
    @WorkerThread
    public zzi zzaq(String str, String str2) {
        Cursor cursor;
        Cursor cursor2 = null;
        zzab.zzhs(str);
        zzab.zzhs(str2);
        zzwu();
        zzzg();
        try {
            Cursor query = getWritableDatabase().query("events", new String[]{"lifetime_count", "current_bundle_count", "last_fire_timestamp"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (!query.moveToFirst()) {
                    if (query != null) {
                        query.close();
                    }
                    return null;
                }
                zzi zzi = new zzi(str, str2, query.getLong(0), query.getLong(1), query.getLong(2));
                if (query.moveToNext()) {
                    zzbsz().zzbtr().log("Got multiple records for event aggregates, expected one");
                }
                if (query == null) {
                    return zzi;
                }
                query.close();
                return zzi;
            } catch (SQLiteException e) {
                e = e;
                cursor = query;
            } catch (Throwable th) {
                th = th;
                cursor2 = query;
                if (cursor2 != null) {
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
        try {
            zzbsz().zzbtr().zzd("Error querying events", str, str2, e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            cursor2 = cursor;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public void zzar(String str, String str2) {
        zzab.zzhs(str);
        zzab.zzhs(str2);
        zzwu();
        zzzg();
        try {
            zzbsz().zzbty().zzj("Deleted user attribute rows:", Integer.valueOf(getWritableDatabase().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e) {
            zzbsz().zzbtr().zzd("Error deleting user attribute", str, str2, e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0082  */
    @WorkerThread
    public zzak zzas(String str, String str2) {
        Cursor cursor;
        Cursor cursor2 = null;
        zzab.zzhs(str);
        zzab.zzhs(str2);
        zzwu();
        zzzg();
        try {
            Cursor query = getWritableDatabase().query("user_attributes", new String[]{"set_timestamp", Param.VALUE}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (!query.moveToFirst()) {
                    if (query != null) {
                        query.close();
                    }
                    return null;
                }
                zzak zzak = new zzak(str, str2, query.getLong(0), zzb(query, 1));
                if (query.moveToNext()) {
                    zzbsz().zzbtr().log("Got multiple records for user property, expected one");
                }
                if (query == null) {
                    return zzak;
                }
                query.close();
                return zzak;
            } catch (SQLiteException e) {
                e = e;
                cursor = query;
            } catch (Throwable th) {
                th = th;
                cursor2 = query;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
        try {
            zzbsz().zzbtr().zzd("Error querying user property", str, str2, e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            cursor2 = cursor;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b0  */
    public Map<Integer, List<com.google.android.gms.internal.zzun.zzb>> zzat(String str, String str2) {
        Cursor cursor;
        zzzg();
        zzwu();
        zzab.zzhs(str);
        zzab.zzhs(str2);
        ArrayMap arrayMap = new ArrayMap();
        try {
            cursor = getWritableDatabase().query("event_filters", new String[]{"audience_id", "data"}, "app_id=? AND event_name=?", new String[]{str, str2}, null, null, null);
            try {
                if (!cursor.moveToFirst()) {
                    Map<Integer, List<com.google.android.gms.internal.zzun.zzb>> emptyMap = Collections.emptyMap();
                    if (cursor == null) {
                        return emptyMap;
                    }
                    cursor.close();
                    return emptyMap;
                }
                do {
                    zzaou zzaz = zzaou.zzaz(cursor.getBlob(1));
                    com.google.android.gms.internal.zzun.zzb zzb2 = new com.google.android.gms.internal.zzun.zzb();
                    try {
                        com.google.android.gms.internal.zzun.zzb zzb3 = (com.google.android.gms.internal.zzun.zzb) zzb2.zzb(zzaz);
                        int i = cursor.getInt(0);
                        List list = (List) arrayMap.get(Integer.valueOf(i));
                        if (list == null) {
                            list = new ArrayList();
                            arrayMap.put(Integer.valueOf(i), list);
                        }
                        list.add(zzb2);
                    } catch (IOException e) {
                        zzbsz().zzbtr().zze("Failed to merge filter", str, e);
                    }
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
                return arrayMap;
            } catch (SQLiteException e2) {
                e = e2;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th) {
            th = th;
            cursor = null;
            if (cursor != null) {
            }
            throw th;
        }
        try {
            zzbsz().zzbtr().zzj("Database error querying filters", e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b0  */
    public Map<Integer, List<com.google.android.gms.internal.zzun.zze>> zzau(String str, String str2) {
        Cursor cursor;
        zzzg();
        zzwu();
        zzab.zzhs(str);
        zzab.zzhs(str2);
        ArrayMap arrayMap = new ArrayMap();
        try {
            cursor = getWritableDatabase().query("property_filters", new String[]{"audience_id", "data"}, "app_id=? AND property_name=?", new String[]{str, str2}, null, null, null);
            try {
                if (!cursor.moveToFirst()) {
                    Map<Integer, List<com.google.android.gms.internal.zzun.zze>> emptyMap = Collections.emptyMap();
                    if (cursor == null) {
                        return emptyMap;
                    }
                    cursor.close();
                    return emptyMap;
                }
                do {
                    zzaou zzaz = zzaou.zzaz(cursor.getBlob(1));
                    com.google.android.gms.internal.zzun.zze zze = new com.google.android.gms.internal.zzun.zze();
                    try {
                        com.google.android.gms.internal.zzun.zze zze2 = (com.google.android.gms.internal.zzun.zze) zze.zzb(zzaz);
                        int i = cursor.getInt(0);
                        List list = (List) arrayMap.get(Integer.valueOf(i));
                        if (list == null) {
                            list = new ArrayList();
                            arrayMap.put(Integer.valueOf(i), list);
                        }
                        list.add(zze);
                    } catch (IOException e) {
                        zzbsz().zzbtr().zze("Failed to merge filter", str, e);
                    }
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
                return arrayMap;
            } catch (SQLiteException e2) {
                e = e2;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th) {
            th = th;
            cursor = null;
            if (cursor != null) {
            }
            throw th;
        }
        try {
            zzbsz().zzbtr().zzj("Database error querying filters", e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public long zzb(com.google.android.gms.internal.zzup.zze zze) throws IOException {
        zzwu();
        zzzg();
        zzab.zzaa(zze);
        zzab.zzhs(zze.zzck);
        try {
            byte[] bArr = new byte[zze.ao()];
            zzaov zzba = zzaov.zzba(bArr);
            zze.zza(zzba);
            zzba.ab();
            long zzad = zzbsv().zzad(bArr);
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zze.zzck);
            contentValues.put("metadata_fingerprint", Long.valueOf(zzad));
            contentValues.put("metadata", bArr);
            try {
                getWritableDatabase().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
                return zzad;
            } catch (SQLiteException e) {
                zzbsz().zzbtr().zzj("Error storing raw event metadata", e);
                throw e;
            }
        } catch (IOException e2) {
            zzbsz().zzbtr().zzj("Data loss. Failed to serialize event metadata", e2);
            throw e2;
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public Object zzb(Cursor cursor, int i) {
        int zza2 = zza(cursor, i);
        switch (zza2) {
            case 0:
                zzbsz().zzbtr().log("Loaded invalid null value from database");
                return null;
            case 1:
                return Long.valueOf(cursor.getLong(i));
            case 2:
                return Double.valueOf(cursor.getDouble(i));
            case 3:
                return cursor.getString(i);
            case 4:
                zzbsz().zzbtr().log("Loaded invalid blob type value, ignoring it");
                return null;
            default:
                zzbsz().zzbtr().zzj("Loaded invalid unknown value type, ignoring it", Integer.valueOf(zza2));
                return null;
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public void zzb(String str, com.google.android.gms.internal.zzun.zza[] zzaArr) {
        zzzg();
        zzwu();
        zzab.zzhs(str);
        zzab.zzaa(zzaArr);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            zzlr(str);
            for (com.google.android.gms.internal.zzun.zza zza2 : zzaArr) {
                zza(str, zza2);
            }
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @WorkerThread
    public void zzbg(long j) {
        zzwu();
        zzzg();
        if (getWritableDatabase().delete("queue", "rowid=?", new String[]{String.valueOf(j)}) != 1) {
            zzbsz().zzbtr().log("Deleted fewer rows from queue than expected");
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r2v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0059  */
    /* JADX WARNING: Unknown variable types count: 2 */
    public String zzbh(long j) {
        ? r2;
        Throwable th;
        ? r22;
        String str = 0;
        zzwu();
        zzzg();
        try {
            Cursor rawQuery = getWritableDatabase().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(j)});
            try {
                if (!rawQuery.moveToFirst()) {
                    zzbsz().zzbty().log("No expired configs for apps with pending events");
                    if (rawQuery != 0) {
                        rawQuery.close();
                    }
                } else {
                    str = rawQuery.getString(0);
                    if (rawQuery != 0) {
                        rawQuery.close();
                    }
                }
            } catch (SQLiteException e) {
                e = e;
                r22 = rawQuery;
            }
        } catch (SQLiteException e2) {
            e = e2;
            r22 = str;
        } catch (Throwable th2) {
            r2 = str;
            th = th2;
            if (r2 != 0) {
            }
            throw th;
        }
        return str;
        try {
            zzbsz().zzbtr().zzj("Error selecting expired configs", e);
            if (r22 != 0) {
                r22.close();
            }
            return str;
        } catch (Throwable th3) {
            th = th3;
            r2 = r22;
            if (r2 != 0) {
                r2.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003d  */
    @WorkerThread
    public String zzbtc() {
        Cursor cursor;
        Throwable th;
        String str = null;
        try {
            cursor = getWritableDatabase().rawQuery("select app_id from queue where app_id not in (select app_id from apps where measurement_enabled=0) order by rowid limit 1;", null);
            try {
                if (cursor.moveToFirst()) {
                    str = cursor.getString(0);
                    if (cursor != null) {
                        cursor.close();
                    }
                } else if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                e = e;
                try {
                    zzbsz().zzbtr().zzj("Database error getting next bundle app id", e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
            if (cursor != null) {
            }
            throw th;
        }
        return str;
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public void zzbtd() {
        zzwu();
        zzzg();
        if (zzbti()) {
            long j = zzbta().aly.get();
            long elapsedRealtime = zzyw().elapsedRealtime();
            if (Math.abs(elapsedRealtime - j) > zzbtb().zzbsc()) {
                zzbta().aly.set(elapsedRealtime);
                zzbte();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public void zzbte() {
        zzwu();
        zzzg();
        if (zzbti()) {
            int delete = getWritableDatabase().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzyw().currentTimeMillis()), String.valueOf(zzbtb().zzbsb())});
            if (delete > 0) {
                zzbsz().zzbty().zzj("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
            }
        }
    }

    @WorkerThread
    public long zzbtf() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0);
    }

    @WorkerThread
    public long zzbtg() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0);
    }

    public boolean zzbth() {
        return zzb("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    @WorkerThread
    public void zzd(String str, byte[] bArr) {
        zzab.zzhs(str);
        zzwu();
        zzzg();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        try {
            if (((long) getWritableDatabase().update("apps", contentValues, "app_id = ?", new String[]{str})) == 0) {
                zzbsz().zzbtr().log("Failed to update remote config (got 0)");
            }
        } catch (SQLiteException e) {
            zzbsz().zzbtr().zzj("Error storing remote config", e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x009e  */
    @WorkerThread
    public List<zzak> zzln(String str) {
        Cursor cursor;
        Cursor cursor2 = null;
        zzab.zzhs(str);
        zzwu();
        zzzg();
        ArrayList arrayList = new ArrayList();
        try {
            Cursor query = getWritableDatabase().query("user_attributes", new String[]{"name", "set_timestamp", Param.VALUE}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(zzbtb().zzbrv()));
            try {
                if (!query.moveToFirst()) {
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
                do {
                    String string = query.getString(0);
                    long j = query.getLong(1);
                    Object zzb2 = zzb(query, 2);
                    if (zzb2 == null) {
                        zzbsz().zzbtr().log("Read invalid user property value, ignoring it");
                    } else {
                        arrayList.add(new zzak(str, string, j, zzb2));
                    }
                } while (query.moveToNext());
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (SQLiteException e) {
                e = e;
                cursor = query;
            } catch (Throwable th) {
                th = th;
                cursor2 = query;
                if (cursor2 != null) {
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
        try {
            zzbsz().zzbtr().zze("Error querying user properties", str, e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            cursor2 = cursor;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x01a9  */
    @WorkerThread
    public zza zzlo(String str) {
        Cursor cursor;
        zzab.zzhs(str);
        zzwu();
        zzzg();
        try {
            cursor = getWritableDatabase().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                zza zza2 = new zza(this.aja, str);
                zza2.zzkz(cursor.getString(0));
                zza2.zzla(cursor.getString(1));
                zza2.zzlb(cursor.getString(2));
                zza2.zzay(cursor.getLong(3));
                zza2.zzat(cursor.getLong(4));
                zza2.zzau(cursor.getLong(5));
                zza2.setAppVersion(cursor.getString(6));
                zza2.zzld(cursor.getString(7));
                zza2.zzaw(cursor.getLong(8));
                zza2.zzax(cursor.getLong(9));
                zza2.setMeasurementEnabled((cursor.isNull(10) ? 1 : cursor.getInt(10)) != 0);
                zza2.zzbb(cursor.getLong(11));
                zza2.zzbc(cursor.getLong(12));
                zza2.zzbd(cursor.getLong(13));
                zza2.zzbe(cursor.getLong(14));
                zza2.zzaz(cursor.getLong(15));
                zza2.zzba(cursor.getLong(16));
                zza2.zzav(cursor.isNull(17) ? -2147483648L : (long) cursor.getInt(17));
                zza2.zzlc(cursor.getString(18));
                zza2.zzbf(cursor.getLong(19));
                zza2.zzbqn();
                if (cursor.moveToNext()) {
                    zzbsz().zzbtr().log("Got multiple records for app, expected one");
                }
                if (cursor == null) {
                    return zza2;
                }
                cursor.close();
                return zza2;
            } catch (SQLiteException e) {
                e = e;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th) {
            th = th;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        try {
            zzbsz().zzbtr().zze("Error querying app", str, e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
            }
            throw th;
        }
    }

    public long zzlp(String str) {
        zzab.zzhs(str);
        zzwu();
        zzzg();
        try {
            return (long) getWritableDatabase().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(zzbtb().zzlm(str))});
        } catch (SQLiteException e) {
            zzbsz().zzbtr().zzj("Error deleting over the limit events", e);
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x006c  */
    @WorkerThread
    public byte[] zzlq(String str) {
        Cursor cursor;
        zzab.zzhs(str);
        zzwu();
        zzzg();
        try {
            cursor = getWritableDatabase().query("apps", new String[]{"remote_config"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                byte[] blob = cursor.getBlob(0);
                if (cursor.moveToNext()) {
                    zzbsz().zzbtr().log("Got multiple records for app config, expected one");
                }
                if (cursor == null) {
                    return blob;
                }
                cursor.close();
                return blob;
            } catch (SQLiteException e) {
                e = e;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th) {
            th = th;
            cursor = null;
            if (cursor != null) {
            }
            throw th;
        }
        try {
            zzbsz().zzbtr().zze("Error querying remote config", str, e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public void zzlr(String str) {
        zzzg();
        zzwu();
        zzab.zzhs(str);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.delete("property_filters", "app_id=?", new String[]{str});
        writableDatabase.delete("event_filters", "app_id=?", new String[]{str});
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0098  */
    public Map<Integer, zzf> zzls(String str) {
        Cursor cursor;
        Cursor cursor2;
        zzzg();
        zzwu();
        zzab.zzhs(str);
        try {
            cursor2 = getWritableDatabase().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (!cursor2.moveToFirst()) {
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    return null;
                }
                ArrayMap arrayMap = new ArrayMap();
                do {
                    int i = cursor2.getInt(0);
                    zzaou zzaz = zzaou.zzaz(cursor2.getBlob(1));
                    zzf zzf = new zzf();
                    try {
                        zzf zzf2 = (zzf) zzf.zzb(zzaz);
                        arrayMap.put(Integer.valueOf(i), zzf);
                    } catch (IOException e) {
                        zzbsz().zzbtr().zzd("Failed to merge filter results. appId, audienceId, error", str, Integer.valueOf(i), e);
                    }
                } while (cursor2.moveToNext());
                if (cursor2 != null) {
                    cursor2.close();
                }
                return arrayMap;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = cursor2;
            } catch (Throwable th) {
                th = th;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor2 = null;
            if (cursor2 != null) {
            }
            throw th;
        }
        try {
            zzbsz().zzbtr().zzj("Database error querying filter results", e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            cursor2 = cursor;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public void zzlt(String str) {
        zzzg();
        zzwu();
        zzab.zzhs(str);
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            String[] strArr = {str};
            int delete = writableDatabase.delete("audience_filter_values", "app_id=?", strArr) + writableDatabase.delete("events", "app_id=?", strArr) + 0 + writableDatabase.delete("user_attributes", "app_id=?", strArr) + writableDatabase.delete("apps", "app_id=?", strArr) + writableDatabase.delete("raw_events", "app_id=?", strArr) + writableDatabase.delete("raw_events_metadata", "app_id=?", strArr) + writableDatabase.delete("event_filters", "app_id=?", strArr) + writableDatabase.delete("property_filters", "app_id=?", strArr);
            if (delete > 0) {
                zzbsz().zzbty().zze("Deleted application data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzbsz().zzbtr().zze("Error deleting application data. appId, error", str, e);
        }
    }

    public void zzlu(String str) {
        try {
            getWritableDatabase().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{str, str});
        } catch (SQLiteException e) {
            zzbsz().zzbtr().zzj("Failed to remove unused event metadata", e);
        }
    }

    public long zzlv(String str) {
        zzab.zzhs(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x00de  */
    @WorkerThread
    public List<Pair<com.google.android.gms.internal.zzup.zze, Long>> zzn(String str, int i, int i2) {
        Cursor cursor;
        Cursor cursor2;
        int i3;
        boolean z = true;
        zzwu();
        zzzg();
        zzab.zzbn(i > 0);
        if (i2 <= 0) {
            z = false;
        }
        zzab.zzbn(z);
        zzab.zzhs(str);
        try {
            cursor2 = getWritableDatabase().query("queue", new String[]{"rowid", "data"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
            try {
                if (!cursor2.moveToFirst()) {
                    List<Pair<com.google.android.gms.internal.zzup.zze, Long>> emptyList = Collections.emptyList();
                    if (cursor2 == null) {
                        return emptyList;
                    }
                    cursor2.close();
                    return emptyList;
                }
                ArrayList arrayList = new ArrayList();
                int i4 = 0;
                while (true) {
                    long j = cursor2.getLong(0);
                    try {
                        byte[] zzab = zzbsv().zzab(cursor2.getBlob(1));
                        if (!arrayList.isEmpty() && zzab.length + i4 > i2) {
                            break;
                        }
                        zzaou zzaz = zzaou.zzaz(zzab);
                        com.google.android.gms.internal.zzup.zze zze = new com.google.android.gms.internal.zzup.zze();
                        try {
                            com.google.android.gms.internal.zzup.zze zze2 = (com.google.android.gms.internal.zzup.zze) zze.zzb(zzaz);
                            i3 = zzab.length + i4;
                            arrayList.add(Pair.create(zze, Long.valueOf(j)));
                        } catch (IOException e) {
                            zzbsz().zzbtr().zze("Failed to merge queued bundle", str, e);
                            i3 = i4;
                        }
                        if (!cursor2.moveToNext() || i3 > i2) {
                            break;
                        }
                        i4 = i3;
                    } catch (IOException e2) {
                        zzbsz().zzbtr().zze("Failed to unzip queued bundle", str, e2);
                        i3 = i4;
                    }
                }
                if (cursor2 != null) {
                    cursor2.close();
                }
                return arrayList;
            } catch (SQLiteException e3) {
                e = e3;
                cursor = cursor2;
            } catch (Throwable th) {
                th = th;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor2 = null;
            if (cursor2 != null) {
            }
            throw th;
        }
        try {
            zzbsz().zzbtr().zze("Error querying bundles", str, e);
            List<Pair<com.google.android.gms.internal.zzup.zze, Long>> emptyList2 = Collections.emptyList();
            if (cursor == null) {
                return emptyList2;
            }
            cursor.close();
            return emptyList2;
        } catch (Throwable th3) {
            th = th3;
            cursor2 = cursor;
        }
    }

    /* access modifiers changed from: protected */
    public void zzwv() {
    }

    @WorkerThread
    public void zzy(String str, int i) {
        zzab.zzhs(str);
        zzwu();
        zzzg();
        try {
            getWritableDatabase().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(i)});
        } catch (SQLiteException e) {
            zzbsz().zzbtr().zze("Error pruning currencies", str, e);
        }
    }

    /* access modifiers changed from: 0000 */
    public void zzz(String str, int i) {
        zzzg();
        zzwu();
        zzab.zzhs(str);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(i)});
        writableDatabase.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(i)});
    }
}
