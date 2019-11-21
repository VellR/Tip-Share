package com.google.android.gms.internal;

import android.util.Base64;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DatabaseReference.CompletionListener;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class zzalo {
    public static int zzac(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static zzall<Task<Void>, CompletionListener> zzb(CompletionListener completionListener) {
        if (completionListener != null) {
            return new zzall<>(null, completionListener);
        }
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        return new zzall<>(taskCompletionSource.getTask(), new CompletionListener() {
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError != null) {
                    TaskCompletionSource.this.setException(databaseError.toException());
                } else {
                    TaskCompletionSource.this.setResult(null);
                }
            }
        });
    }

    public static void zzb(boolean z, String str) {
        if (!z) {
            String str2 = "hardAssert failed: ";
            String valueOf = String.valueOf(str);
            throw new AssertionError(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
    }

    public static void zzcp(boolean z) {
        zzb(z, "");
    }

    public static int zzk(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    public static String zzm(double d) {
        StringBuilder sb = new StringBuilder(16);
        byte[] bArr = new byte[8];
        ByteBuffer.wrap(bArr).putDouble(d);
        for (int i = 0; i < 8; i++) {
            sb.append(String.format("%02x", new Object[]{Byte.valueOf(bArr[i])}));
        }
        return sb.toString();
    }

    public static zzalm zzrs(String str) throws DatabaseException {
        String str2;
        try {
            int indexOf = str.indexOf("//");
            if (indexOf == -1) {
                throw new URISyntaxException(str, "Invalid scheme specified");
            }
            int indexOf2 = str.substring(indexOf + 2).indexOf("/");
            if (indexOf2 != -1) {
                int i = indexOf + 2 + indexOf2;
                String[] split = str.substring(i).split("/");
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < split.length; i2++) {
                    if (!split[i2].equals("")) {
                        sb.append("/");
                        sb.append(URLEncoder.encode(split[i2], "UTF-8"));
                    }
                }
                String valueOf = String.valueOf(str.substring(0, i));
                String valueOf2 = String.valueOf(sb.toString());
                str2 = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
            } else {
                str2 = str;
            }
            URI uri = new URI(str2);
            String replace = uri.getPath().replace("+", " ");
            zzalp.zzry(replace);
            zzahr zzahr = new zzahr(replace);
            String scheme = uri.getScheme();
            zzahu zzahu = new zzahu();
            zzahu.aRd = uri.getHost().toLowerCase();
            int port = uri.getPort();
            if (port != -1) {
                zzahu.aRe = scheme.equals("https");
                String valueOf3 = String.valueOf(zzahu.aRd);
                zzahu.aRd = new StringBuilder(String.valueOf(valueOf3).length() + 12).append(valueOf3).append(":").append(port).toString();
            } else {
                zzahu.aRe = true;
            }
            zzahu.zl = zzahu.aRd.split("\\.")[0].toLowerCase();
            zzahu.aUX = zzahu.aRd;
            zzalm zzalm = new zzalm();
            zzalm.aPz = zzahr;
            zzalm.aPp = zzahu;
            return zzalm;
        } catch (URISyntaxException e) {
            throw new DatabaseException("Invalid Firebase Database url specified", e);
        } catch (UnsupportedEncodingException e2) {
            throw new DatabaseException("Failed to URLEncode the path", e2);
        }
    }

    public static String zzrt(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(str.getBytes("UTF-8"));
            return Base64.encodeToString(instance.digest(), 2);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Missing SHA-1 MessageDigest provider.", e);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("UTF-8 encoding is required for Firebase Database to run!");
        }
    }

    public static String zzru(String str) {
        String str2 = str.indexOf(92) != -1 ? str.replace("\\", "\\\\") : str;
        if (str.indexOf(34) != -1) {
            str2 = str2.replace("\"", "\\\"");
        }
        return new StringBuilder(String.valueOf(str2).length() + 2).append("\"").append(str2).append("\"").toString();
    }

    public static Integer zzrv(String str) {
        boolean z = true;
        int i = 0;
        if (str.length() > 11 || str.length() == 0) {
            return null;
        }
        if (str.charAt(0) != '-') {
            z = false;
        } else if (str.length() == 1) {
            return null;
        } else {
            i = 1;
        }
        long j = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return null;
            }
            j = (j * 10) + ((long) (charAt - '0'));
            i++;
        }
        if (z) {
            if ((-j) < -2147483648L) {
                return null;
            }
            return Integer.valueOf((int) (-j));
        } else if (j > 2147483647L) {
            return null;
        } else {
            return Integer.valueOf((int) j);
        }
    }
}
