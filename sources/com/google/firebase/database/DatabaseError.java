package com.google.firebase.database;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class DatabaseError {
    public static final int DATA_STALE = -1;
    public static final int DISCONNECTED = -4;
    public static final int EXPIRED_TOKEN = -6;
    public static final int INVALID_TOKEN = -7;
    public static final int MAX_RETRIES = -8;
    public static final int NETWORK_ERROR = -24;
    public static final int OPERATION_FAILED = -2;
    public static final int OVERRIDDEN_BY_SET = -9;
    public static final int PERMISSION_DENIED = -3;
    public static final int UNAVAILABLE = -10;
    public static final int UNKNOWN_ERROR = -999;
    public static final int USER_CODE_EXCEPTION = -11;
    public static final int WRITE_CANCELED = -25;
    private static final Map<Integer, String> aPa = new HashMap();
    private static final Map<String, Integer> aPb = new HashMap();
    private final int aPc;
    private final String aPd;
    private final String message;

    static {
        aPa.put(Integer.valueOf(-1), "The transaction needs to be run again with current data");
        aPa.put(Integer.valueOf(-2), "The server indicated that this operation failed");
        aPa.put(Integer.valueOf(-3), "This client does not have permission to perform this operation");
        aPa.put(Integer.valueOf(-4), "The operation had to be aborted due to a network disconnect");
        aPa.put(Integer.valueOf(-6), "The supplied auth token has expired");
        aPa.put(Integer.valueOf(-7), "The supplied auth token was invalid");
        aPa.put(Integer.valueOf(-8), "The transaction had too many retries");
        aPa.put(Integer.valueOf(-9), "The transaction was overridden by a subsequent set");
        aPa.put(Integer.valueOf(-10), "The service is unavailable");
        aPa.put(Integer.valueOf(-11), "User code called from the Firebase Database runloop threw an exception:\n");
        aPa.put(Integer.valueOf(-24), "The operation could not be performed due to a network error");
        aPa.put(Integer.valueOf(-25), "The write was canceled by the user.");
        aPa.put(Integer.valueOf(UNKNOWN_ERROR), "An unknown error occurred");
        aPb.put("datastale", Integer.valueOf(-1));
        aPb.put("failure", Integer.valueOf(-2));
        aPb.put("permission_denied", Integer.valueOf(-3));
        aPb.put("disconnected", Integer.valueOf(-4));
        aPb.put("expired_token", Integer.valueOf(-6));
        aPb.put("invalid_token", Integer.valueOf(-7));
        aPb.put("maxretries", Integer.valueOf(-8));
        aPb.put("overriddenbyset", Integer.valueOf(-9));
        aPb.put("unavailable", Integer.valueOf(-10));
        aPb.put("network_error", Integer.valueOf(-24));
        aPb.put("write_canceled", Integer.valueOf(-25));
    }

    private DatabaseError(int i, String str) {
        this(i, str, null);
    }

    private DatabaseError(int i, String str, String str2) {
        this.aPc = i;
        this.message = str;
        if (str2 == null) {
            str2 = "";
        }
        this.aPd = str2;
    }

    public static DatabaseError fromException(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String valueOf = String.valueOf((String) aPa.get(Integer.valueOf(-11)));
        String valueOf2 = String.valueOf(stringWriter.toString());
        return new DatabaseError(-11, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
    }

    public static DatabaseError zzadi(int i) {
        if (aPa.containsKey(Integer.valueOf(i))) {
            return new DatabaseError(i, (String) aPa.get(Integer.valueOf(i)), null);
        }
        throw new IllegalArgumentException("Invalid Firebase Database error code: " + i);
    }

    public static DatabaseError zzbk(String str, String str2) {
        return zzp(str, str2, null);
    }

    public static DatabaseError zzp(String str, String str2, String str3) {
        Integer num = (Integer) aPb.get(str.toLowerCase());
        Integer num2 = num == null ? Integer.valueOf(UNKNOWN_ERROR) : num;
        return new DatabaseError(num2.intValue(), str2 == null ? (String) aPa.get(num2) : str2, str3);
    }

    public static DatabaseError zzqq(String str) {
        return zzbk(str, null);
    }

    public int getCode() {
        return this.aPc;
    }

    public String getDetails() {
        return this.aPd;
    }

    public String getMessage() {
        return this.message;
    }

    public DatabaseException toException() {
        String str = "Firebase Database error: ";
        String valueOf = String.valueOf(this.message);
        return new DatabaseException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    public String toString() {
        String str = "DatabaseError: ";
        String valueOf = String.valueOf(this.message);
        return valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
    }
}
