package com.google.android.gms.internal;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.GetTokenResult;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zzami {
    public static boolean equals(@Nullable Object obj, @Nullable Object obj2) {
        return zzaa.equal(obj, obj2);
    }

    @Nullable
    public static Uri zzc(@NonNull FirebaseApp firebaseApp, @Nullable String str) throws UnsupportedEncodingException {
        String substring;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.toLowerCase().startsWith("gs://")) {
            String str2 = "gs://";
            String valueOf = String.valueOf(zzame.zzso(zzame.zzsq(str.substring(5))));
            return Uri.parse(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
        Uri parse = Uri.parse(str);
        String lowerCase = parse.getScheme().toLowerCase();
        if (equals(lowerCase, "http") || equals(lowerCase, "https")) {
            try {
                int indexOf = parse.getAuthority().toLowerCase().indexOf(zzg(firebaseApp));
                String zzsp = zzame.zzsp(parse.getEncodedPath());
                if (indexOf == 0 && zzsp.startsWith("/")) {
                    int indexOf2 = zzsp.indexOf("/b/", 0);
                    int indexOf3 = zzsp.indexOf("/", indexOf2 + 3);
                    int indexOf4 = zzsp.indexOf("/o/", 0);
                    if (indexOf2 == -1 || indexOf3 == -1) {
                        Log.w("StorageUtil", "Only URLs to firebasestorage.googleapis.com are supported.");
                        throw new IllegalArgumentException("Only URLs to firebasestorage.googleapis.com are supported.");
                    }
                    substring = zzsp.substring(indexOf2 + 3, indexOf3);
                    zzsp = indexOf4 != -1 ? zzsp.substring(indexOf4 + 3) : "";
                } else if (indexOf > 1) {
                    substring = parse.getAuthority().substring(0, indexOf - 1);
                } else {
                    Log.w("StorageUtil", "Only URLs to firebasestorage.googleapis.com are supported.");
                    throw new IllegalArgumentException("Only URLs to firebasestorage.googleapis.com are supported.");
                }
                zzab.zzh(substring, "No bucket specified");
                return new Builder().scheme("gs").authority(substring).encodedPath(zzsp).build();
            } catch (RemoteException e) {
                throw new UnsupportedEncodingException("Could not parse Url because the Storage network layer did not load");
            }
        } else {
            String str3 = "StorageUtil";
            String str4 = "FirebaseStorage is unable to support the scheme:";
            String valueOf2 = String.valueOf(lowerCase);
            Log.w(str3, valueOf2.length() != 0 ? str4.concat(valueOf2) : new String(str4));
            throw new IllegalArgumentException("Uri scheme");
        }
    }

    private static String zzg(FirebaseApp firebaseApp) throws RemoteException {
        return zzaml.zzi(firebaseApp).zzczc();
    }

    @Nullable
    public static String zzh(FirebaseApp firebaseApp) {
        try {
            String token = ((GetTokenResult) Tasks.await(firebaseApp.getToken(false), 30000, TimeUnit.MILLISECONDS)).getToken();
            if (!TextUtils.isEmpty(token)) {
                return token;
            }
            Log.w("StorageUtil", "no auth token for request");
            return null;
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            String valueOf = String.valueOf(e);
            Log.e("StorageUtil", new StringBuilder(String.valueOf(valueOf).length() + 20).append("error getting token ").append(valueOf).toString());
        }
    }

    public static long zzsr(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        String replaceAll = str.replaceAll("Z$", "-0000");
        try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault()).parse(replaceAll).getTime();
        } catch (ParseException e) {
            ParseException parseException = e;
            String str2 = "StorageUtil";
            String str3 = "unable to parse datetime:";
            String valueOf = String.valueOf(replaceAll);
            Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3), parseException);
            return 0;
        }
    }
}
