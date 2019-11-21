package com.google.firebase.database;

import com.google.android.gms.internal.zzahr;
import com.google.android.gms.internal.zzakh;
import com.google.android.gms.internal.zzakl;
import com.google.android.gms.internal.zzalp;
import com.google.android.gms.internal.zzalq;
import java.util.Iterator;

public class DataSnapshot {
    private final zzakh aOV;
    /* access modifiers changed from: private */
    public final DatabaseReference aOW;

    DataSnapshot(DatabaseReference databaseReference, zzakh zzakh) {
        this.aOV = zzakh;
        this.aOW = databaseReference;
    }

    public DataSnapshot child(String str) {
        return new DataSnapshot(this.aOW.child(str), zzakh.zzm(this.aOV.zzcmq().zzao(new zzahr(str))));
    }

    public boolean exists() {
        return !this.aOV.zzcmq().isEmpty();
    }

    public Iterable<DataSnapshot> getChildren() {
        final Iterator it = this.aOV.iterator();
        return new Iterable<DataSnapshot>() {
            public Iterator<DataSnapshot> iterator() {
                return new Iterator<DataSnapshot>() {
                    public boolean hasNext() {
                        return it.hasNext();
                    }

                    public void remove() {
                        throw new UnsupportedOperationException("remove called on immutable collection");
                    }

                    /* renamed from: zzcmn */
                    public DataSnapshot next() {
                        zzakl zzakl = (zzakl) it.next();
                        return new DataSnapshot(DataSnapshot.this.aOW.child(zzakl.zzcvs().asString()), zzakh.zzm(zzakl.zzcmq()));
                    }
                };
            }
        };
    }

    public long getChildrenCount() {
        return (long) this.aOV.zzcmq().getChildCount();
    }

    public String getKey() {
        return this.aOW.getKey();
    }

    public Object getPriority() {
        Object value = this.aOV.zzcmq().zzcux().getValue();
        return value instanceof Long ? Double.valueOf((double) ((Long) value).longValue()) : value;
    }

    public DatabaseReference getRef() {
        return this.aOW;
    }

    public Object getValue() {
        return this.aOV.zzcmq().getValue();
    }

    public <T> T getValue(GenericTypeIndicator<T> genericTypeIndicator) {
        return zzalq.zza(this.aOV.zzcmq().getValue(), genericTypeIndicator);
    }

    public <T> T getValue(Class<T> cls) {
        return zzalq.zza(this.aOV.zzcmq().getValue(), cls);
    }

    public Object getValue(boolean z) {
        return this.aOV.zzcmq().getValue(z);
    }

    public boolean hasChild(String str) {
        if (this.aOW.getParent() == null) {
            zzalp.zzry(str);
        } else {
            zzalp.zzrx(str);
        }
        return !this.aOV.zzcmq().zzao(new zzahr(str)).isEmpty();
    }

    public boolean hasChildren() {
        return this.aOV.zzcmq().getChildCount() > 0;
    }

    public String toString() {
        String valueOf = String.valueOf(this.aOW.getKey());
        String valueOf2 = String.valueOf(this.aOV.zzcmq().getValue(true));
        return new StringBuilder(String.valueOf(valueOf).length() + 33 + String.valueOf(valueOf2).length()).append("DataSnapshot { key = ").append(valueOf).append(", value = ").append(valueOf2).append(" }").toString();
    }
}
