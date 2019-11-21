package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class zzaer {
    public static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
    public static final Uri aLW = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern aLX = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern aLY = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    /* access modifiers changed from: private */
    public static HashMap<String, String> aLZ;
    /* access modifiers changed from: private */
    public static Object aMa;
    /* access modifiers changed from: private */
    public static String[] aMb = new String[0];
    private static Context aMc = null;

    public static long getLong(ContentResolver contentResolver, String str, long j) {
        String string = getString(contentResolver, str);
        if (string == null) {
            return j;
        }
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException e) {
            return j;
        }
    }

    public static String getString(ContentResolver contentResolver, String str) {
        return zza(contentResolver, str, null);
    }

    public static String zza(ContentResolver contentResolver, String str, String str2) {
        synchronized (zzaer.class) {
            zza(contentResolver);
            Object obj = aMa;
            if (aLZ.containsKey(str)) {
                String str3 = (String) aLZ.get(str);
                if (str3 != null) {
                    str2 = str3;
                }
            } else {
                String[] strArr = aMb;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        if (str.startsWith(strArr[i])) {
                            break;
                        }
                        i++;
                    } else {
                        Cursor query = contentResolver.query(CONTENT_URI, null, null, new String[]{str}, null);
                        if (query != null) {
                            try {
                                if (query.moveToFirst()) {
                                    String string = query.getString(1);
                                    synchronized (zzaer.class) {
                                        if (obj == aMa) {
                                            aLZ.put(str, string);
                                        }
                                    }
                                    if (string != null) {
                                        str2 = string;
                                    }
                                    if (query != null) {
                                        query.close();
                                    }
                                }
                            } catch (Throwable th) {
                                if (query != null) {
                                    query.close();
                                }
                                throw th;
                            }
                        }
                        aLZ.put(str, null);
                        if (query != null) {
                            query.close();
                        }
                    }
                }
            }
        }
        return str2;
    }

    public static Map<String, String> zza(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(aLW, null, null, strArr, null);
        TreeMap treeMap = new TreeMap();
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    treeMap.put(query.getString(0), query.getString(1));
                } finally {
                    query.close();
                }
            }
        }
        return treeMap;
    }

    private static void zza(final ContentResolver contentResolver) {
        if (aLZ == null) {
            aLZ = new HashMap<>();
            aMa = new Object();
            new Thread("Gservices") {
                public void run() {
                    Looper.prepare();
                    contentResolver.registerContentObserver(zzaer.CONTENT_URI, true, new ContentObserver(new Handler(Looper.myLooper())) {
                        public void onChange(boolean z) {
                            synchronized (zzaer.class) {
                                zzaer.aLZ.clear();
                                zzaer.aMa = new Object();
                                if (zzaer.aMb.length > 0) {
                                    zzaer.zzb(contentResolver, zzaer.aMb);
                                }
                            }
                        }
                    });
                    Looper.loop();
                }
            }.start();
        }
    }

    public static void zzb(ContentResolver contentResolver, String... strArr) {
        Map zza = zza(contentResolver, strArr);
        synchronized (zzaer.class) {
            zza(contentResolver);
            aMb = strArr;
            for (Entry entry : zza.entrySet()) {
                aLZ.put((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }
}
