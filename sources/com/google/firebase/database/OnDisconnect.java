package com.google.firebase.database;

import com.google.android.gms.internal.zzahr;
import com.google.android.gms.internal.zzaht;
import com.google.android.gms.internal.zzaig;
import com.google.android.gms.internal.zzakm;
import com.google.android.gms.internal.zzakn;
import com.google.android.gms.internal.zzakq;
import com.google.android.gms.internal.zzall;
import com.google.android.gms.internal.zzalo;
import com.google.android.gms.internal.zzalp;
import com.google.android.gms.internal.zzalq;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference.CompletionListener;
import java.util.Map;

public class OnDisconnect {
    /* access modifiers changed from: private */
    public zzaht aPr;
    /* access modifiers changed from: private */
    public zzahr aPz;

    OnDisconnect(zzaht zzaht, zzahr zzahr) {
        this.aPr = zzaht;
        this.aPz = zzahr;
    }

    private Task<Void> zza(CompletionListener completionListener) {
        final zzall zzb = zzalo.zzb(completionListener);
        this.aPr.zzr(new Runnable() {
            public void run() {
                OnDisconnect.this.aPr.zza(OnDisconnect.this.aPz, (CompletionListener) zzb.zzcwr());
            }
        });
        return (Task) zzb.getFirst();
    }

    private Task<Void> zza(final Map<String, Object> map, CompletionListener completionListener) {
        final Map zzc = zzalp.zzc(this.aPz, map);
        final zzall zzb = zzalo.zzb(completionListener);
        this.aPr.zzr(new Runnable() {
            public void run() {
                OnDisconnect.this.aPr.zza(OnDisconnect.this.aPz, zzc, (CompletionListener) zzb.zzcwr(), map);
            }
        });
        return (Task) zzb.getFirst();
    }

    private Task<Void> zzb(Object obj, zzakm zzakm, CompletionListener completionListener) {
        zzalp.zzaq(this.aPz);
        zzaig.zza(this.aPz, obj);
        Object zzbx = zzalq.zzbx(obj);
        zzalp.zzbw(zzbx);
        final zzakm zza = zzakn.zza(zzbx, zzakm);
        final zzall zzb = zzalo.zzb(completionListener);
        this.aPr.zzr(new Runnable() {
            public void run() {
                OnDisconnect.this.aPr.zzb(OnDisconnect.this.aPz, zza, (CompletionListener) zzb.zzcwr());
            }
        });
        return (Task) zzb.getFirst();
    }

    public Task<Void> cancel() {
        return zza((CompletionListener) null);
    }

    public void cancel(CompletionListener completionListener) {
        zza(completionListener);
    }

    public Task<Void> removeValue() {
        return setValue(null);
    }

    public void removeValue(CompletionListener completionListener) {
        setValue((Object) null, completionListener);
    }

    public Task<Void> setValue(Object obj) {
        return zzb(obj, zzakq.zzcvu(), null);
    }

    public Task<Void> setValue(Object obj, double d) {
        return zzb(obj, zzakq.zzbt(Double.valueOf(d)), null);
    }

    public Task<Void> setValue(Object obj, String str) {
        return zzb(obj, zzakq.zzbt(str), null);
    }

    public void setValue(Object obj, double d, CompletionListener completionListener) {
        zzb(obj, zzakq.zzbt(Double.valueOf(d)), completionListener);
    }

    public void setValue(Object obj, CompletionListener completionListener) {
        zzb(obj, zzakq.zzcvu(), completionListener);
    }

    public void setValue(Object obj, String str, CompletionListener completionListener) {
        zzb(obj, zzakq.zzbt(str), completionListener);
    }

    public void setValue(Object obj, Map map, CompletionListener completionListener) {
        zzb(obj, zzakq.zzbt(map), completionListener);
    }

    public Task<Void> updateChildren(Map<String, Object> map) {
        return zza(map, null);
    }

    public void updateChildren(Map<String, Object> map, CompletionListener completionListener) {
        zza(map, completionListener);
    }
}
