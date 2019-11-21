package com.google.android.gms.internal;

import com.google.firebase.database.DatabaseException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class zzalp {
    private static final Pattern bar = Pattern.compile("[\\[\\]\\.#$]");
    private static final Pattern bas = Pattern.compile("[\\[\\]\\.#\\$\\/\\u0000-\\u001F\\u007F]");

    private static boolean zzap(zzahr zzahr) {
        zzaka zzcrb = zzahr.zzcrb();
        return zzcrb == null || !zzcrb.asString().startsWith(".");
    }

    public static void zzaq(zzahr zzahr) throws DatabaseException {
        if (!zzap(zzahr)) {
            String str = "Invalid write location: ";
            String valueOf = String.valueOf(zzahr.toString());
            throw new DatabaseException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    public static void zzbw(Object obj) {
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (!map.containsKey(".sv")) {
                for (Entry entry : map.entrySet()) {
                    zzsc((String) entry.getKey());
                    zzbw(entry.getValue());
                }
            }
        } else if (obj instanceof List) {
            for (Object zzbw : (List) obj) {
                zzbw(zzbw);
            }
        }
    }

    public static Map<zzahr, zzakm> zzc(zzahr zzahr, Map<String, Object> map) throws DatabaseException {
        TreeMap treeMap = new TreeMap();
        for (Entry entry : map.entrySet()) {
            zzahr zzahr2 = new zzahr((String) entry.getKey());
            Object value = entry.getValue();
            zzaig.zza(zzahr.zzh(zzahr2), value);
            String str = !zzahr2.isEmpty() ? zzahr2.zzcre().asString() : "";
            if (str.equals(".sv") || str.equals(".value")) {
                String valueOf = String.valueOf(zzahr2);
                throw new DatabaseException(new StringBuilder(String.valueOf(valueOf).length() + 40 + String.valueOf(str).length()).append("Path '").append(valueOf).append("' contains disallowed child name: ").append(str).toString());
            } else if (!str.equals(".priority") || zzakq.zzp(zzakn.zzbs(value))) {
                zzbw(value);
                treeMap.put(zzahr2, zzakn.zzbs(value));
            } else {
                String valueOf2 = String.valueOf(zzahr2);
                throw new DatabaseException(new StringBuilder(String.valueOf(valueOf2).length() + 83).append("Path '").append(valueOf2).append("' contains invalid priority (must be a string, double, ServerValue, or null).").toString());
            }
        }
        zzahr zzahr3 = null;
        Iterator it = treeMap.keySet().iterator();
        while (true) {
            zzahr zzahr4 = zzahr3;
            if (!it.hasNext()) {
                return treeMap;
            }
            zzahr3 = (zzahr) it.next();
            zzalo.zzcp(zzahr4 == null || zzahr4.compareTo(zzahr3) < 0);
            if (zzahr4 != null && zzahr4.zzi(zzahr3)) {
                String valueOf3 = String.valueOf(zzahr4);
                String valueOf4 = String.valueOf(zzahr3);
                throw new DatabaseException(new StringBuilder(String.valueOf(valueOf3).length() + 42 + String.valueOf(valueOf4).length()).append("Path '").append(valueOf3).append("' is an ancestor of '").append(valueOf4).append("' in an update.").toString());
            }
        }
    }

    private static boolean zzrw(String str) {
        return !bar.matcher(str).find();
    }

    public static void zzrx(String str) throws DatabaseException {
        if (!zzrw(str)) {
            throw new DatabaseException(new StringBuilder(String.valueOf(str).length() + 101).append("Invalid Firebase Database path: ").append(str).append(". Firebase Database paths must not contain '.', '#', '$', '[', or ']'").toString());
        }
    }

    public static void zzry(String str) throws DatabaseException {
        if (str.startsWith(".info")) {
            zzrx(str.substring(5));
        } else if (str.startsWith("/.info")) {
            zzrx(str.substring(6));
        } else {
            zzrx(str);
        }
    }

    private static boolean zzrz(String str) {
        return str != null && str.length() > 0 && (str.equals(".value") || str.equals(".priority") || (!str.startsWith(".") && !bas.matcher(str).find()));
    }

    private static boolean zzsa(String str) {
        return str.equals(".info") || !bas.matcher(str).find();
    }

    public static void zzsb(String str) throws DatabaseException {
        if (str != null && !zzsa(str)) {
            throw new DatabaseException(new StringBuilder(String.valueOf(str).length() + 68).append("Invalid key: ").append(str).append(". Keys must not contain '/', '.', '#', '$', '[', or ']'").toString());
        }
    }

    public static void zzsc(String str) throws DatabaseException {
        if (!zzrz(str)) {
            throw new DatabaseException(new StringBuilder(String.valueOf(str).length() + 68).append("Invalid key: ").append(str).append(". Keys must not contain '/', '.', '#', '$', '[', or ']'").toString());
        }
    }
}
