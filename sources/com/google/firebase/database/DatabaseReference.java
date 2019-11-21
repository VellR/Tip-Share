package com.google.firebase.database;

import com.google.android.gms.internal.zzahi;
import com.google.android.gms.internal.zzahl;
import com.google.android.gms.internal.zzahr;
import com.google.android.gms.internal.zzaht;
import com.google.android.gms.internal.zzahv;
import com.google.android.gms.internal.zzaig;
import com.google.android.gms.internal.zzaka;
import com.google.android.gms.internal.zzakm;
import com.google.android.gms.internal.zzakn;
import com.google.android.gms.internal.zzakq;
import com.google.android.gms.internal.zzall;
import com.google.android.gms.internal.zzaln;
import com.google.android.gms.internal.zzalo;
import com.google.android.gms.internal.zzalp;
import com.google.android.gms.internal.zzalq;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.Transaction.Handler;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public class DatabaseReference extends Query {
    private static zzahl aPe;

    public interface CompletionListener {
        void onComplete(DatabaseError databaseError, DatabaseReference databaseReference);
    }

    DatabaseReference(zzaht zzaht, zzahr zzahr) {
        super(zzaht, zzahr);
    }

    public static void goOffline() {
        zza(zzcmo());
    }

    public static void goOnline() {
        zzb(zzcmo());
    }

    private Task<Void> zza(final zzakm zzakm, CompletionListener completionListener) {
        zzalp.zzaq(zzcmu());
        final zzall zzb = zzalo.zzb(completionListener);
        this.aPr.zzr(new Runnable() {
            public void run() {
                DatabaseReference.this.aPr.zza(DatabaseReference.this.zzcmu().zza(zzaka.zzcur()), zzakm, (CompletionListener) zzb.zzcwr());
            }
        });
        return (Task) zzb.getFirst();
    }

    private Task<Void> zza(Object obj, zzakm zzakm, CompletionListener completionListener) {
        zzalp.zzaq(zzcmu());
        zzaig.zza(zzcmu(), obj);
        Object zzbx = zzalq.zzbx(obj);
        zzalp.zzbw(zzbx);
        final zzakm zza = zzakn.zza(zzbx, zzakm);
        final zzall zzb = zzalo.zzb(completionListener);
        this.aPr.zzr(new Runnable() {
            public void run() {
                DatabaseReference.this.aPr.zza(DatabaseReference.this.zzcmu(), zza, (CompletionListener) zzb.zzcwr());
            }
        });
        return (Task) zzb.getFirst();
    }

    private Task<Void> zza(final Map<String, Object> map, CompletionListener completionListener) {
        if (map == null) {
            throw new NullPointerException("Can't pass null for argument 'update' in updateChildren()");
        }
        final zzahi zzby = zzahi.zzby(zzalp.zzc(zzcmu(), map));
        final zzall zzb = zzalo.zzb(completionListener);
        this.aPr.zzr(new Runnable() {
            public void run() {
                DatabaseReference.this.aPr.zza(DatabaseReference.this.zzcmu(), zzby, (CompletionListener) zzb.zzcwr(), map);
            }
        });
        return (Task) zzb.getFirst();
    }

    static void zza(zzahl zzahl) {
        zzahv.zzd(zzahl);
    }

    static void zzb(zzahl zzahl) {
        zzahv.zze(zzahl);
    }

    private static synchronized zzahl zzcmo() {
        zzahl zzahl;
        synchronized (DatabaseReference.class) {
            if (aPe == null) {
                aPe = new zzahl();
            }
            zzahl = aPe;
        }
        return zzahl;
    }

    public DatabaseReference child(String str) {
        if (str == null) {
            throw new NullPointerException("Can't pass null for argument 'pathString' in child()");
        }
        if (zzcmu().isEmpty()) {
            zzalp.zzry(str);
        } else {
            zzalp.zzrx(str);
        }
        return new DatabaseReference(this.aPr, zzcmu().zzh(new zzahr(str)));
    }

    public boolean equals(Object obj) {
        return (obj instanceof DatabaseReference) && toString().equals(obj.toString());
    }

    public FirebaseDatabase getDatabase() {
        return this.aPr.getDatabase();
    }

    public String getKey() {
        if (zzcmu().isEmpty()) {
            return null;
        }
        return zzcmu().zzcre().asString();
    }

    public DatabaseReference getParent() {
        zzahr zzcrd = zzcmu().zzcrd();
        if (zzcrd != null) {
            return new DatabaseReference(this.aPr, zzcrd);
        }
        return null;
    }

    public DatabaseReference getRoot() {
        return new DatabaseReference(this.aPr, new zzahr(""));
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public OnDisconnect onDisconnect() {
        zzalp.zzaq(zzcmu());
        return new OnDisconnect(this.aPr, zzcmu());
    }

    public DatabaseReference push() {
        return new DatabaseReference(this.aPr, zzcmu().zza(zzaka.zzrm(zzaln.zzcl(this.aPr.zzcri()))));
    }

    public Task<Void> removeValue() {
        return setValue(null);
    }

    public void removeValue(CompletionListener completionListener) {
        setValue((Object) null, completionListener);
    }

    public void runTransaction(Handler handler) {
        runTransaction(handler, true);
    }

    public void runTransaction(final Handler handler, final boolean z) {
        if (handler == null) {
            throw new NullPointerException("Can't pass null for argument 'handler' in runTransaction()");
        }
        zzalp.zzaq(zzcmu());
        this.aPr.zzr(new Runnable() {
            public void run() {
                DatabaseReference.this.aPr.zza(DatabaseReference.this.zzcmu(), handler, z);
            }
        });
    }

    public Task<Void> setPriority(Object obj) {
        return zza(zzakq.zzbt(obj), (CompletionListener) null);
    }

    public void setPriority(Object obj, CompletionListener completionListener) {
        zza(zzakq.zzbt(obj), completionListener);
    }

    public Task<Void> setValue(Object obj) {
        return zza(obj, zzakq.zzbt(null), null);
    }

    public Task<Void> setValue(Object obj, Object obj2) {
        return zza(obj, zzakq.zzbt(obj2), null);
    }

    public void setValue(Object obj, CompletionListener completionListener) {
        zza(obj, zzakq.zzbt(null), completionListener);
    }

    public void setValue(Object obj, Object obj2, CompletionListener completionListener) {
        zza(obj, zzakq.zzbt(obj2), completionListener);
    }

    public String toString() {
        DatabaseReference parent = getParent();
        if (parent == null) {
            return this.aPr.toString();
        }
        try {
            String valueOf = String.valueOf(parent.toString());
            String valueOf2 = String.valueOf(URLEncoder.encode(getKey(), "UTF-8").replace("+", "%20"));
            return new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length()).append(valueOf).append("/").append(valueOf2).toString();
        } catch (UnsupportedEncodingException e) {
            UnsupportedEncodingException unsupportedEncodingException = e;
            String str = "Failed to URLEncode key: ";
            String valueOf3 = String.valueOf(getKey());
            throw new DatabaseException(valueOf3.length() != 0 ? str.concat(valueOf3) : new String(str), unsupportedEncodingException);
        }
    }

    public Task<Void> updateChildren(Map<String, Object> map) {
        return zza(map, (CompletionListener) null);
    }

    public void updateChildren(Map<String, Object> map, CompletionListener completionListener) {
        zza(map, completionListener);
    }
}
