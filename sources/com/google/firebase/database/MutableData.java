package com.google.firebase.database;

import com.google.android.gms.internal.zzahr;
import com.google.android.gms.internal.zzahy;
import com.google.android.gms.internal.zzaig;
import com.google.android.gms.internal.zzaka;
import com.google.android.gms.internal.zzakh;
import com.google.android.gms.internal.zzakl;
import com.google.android.gms.internal.zzakm;
import com.google.android.gms.internal.zzakn;
import com.google.android.gms.internal.zzakq;
import com.google.android.gms.internal.zzalp;
import com.google.android.gms.internal.zzalq;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MutableData {
    /* access modifiers changed from: private */
    public final zzahy aPu;
    /* access modifiers changed from: private */
    public final zzahr aPv;

    private MutableData(zzahy zzahy, zzahr zzahr) {
        this.aPu = zzahy;
        this.aPv = zzahr;
        zzaig.zza(this.aPv, getValue());
    }

    MutableData(zzakm zzakm) {
        this(new zzahy(zzakm), new zzahr(""));
    }

    public MutableData child(String str) {
        zzalp.zzrx(str);
        return new MutableData(this.aPu, this.aPv.zzh(new zzahr(str)));
    }

    public boolean equals(Object obj) {
        return (obj instanceof MutableData) && this.aPu.equals(((MutableData) obj).aPu) && this.aPv.equals(((MutableData) obj).aPv);
    }

    public Iterable<MutableData> getChildren() {
        zzakm zzcmq = zzcmq();
        if (zzcmq.isEmpty() || zzcmq.zzcuw()) {
            return new Iterable<MutableData>() {
                public Iterator<MutableData> iterator() {
                    return new Iterator<MutableData>() {
                        public boolean hasNext() {
                            return false;
                        }

                        public void remove() {
                            throw new UnsupportedOperationException("remove called on immutable collection");
                        }

                        /* renamed from: zzcmr */
                        public MutableData next() {
                            throw new NoSuchElementException();
                        }
                    };
                }
            };
        }
        final Iterator it = zzakh.zzm(zzcmq).iterator();
        return new Iterable<MutableData>() {
            public Iterator<MutableData> iterator() {
                return new Iterator<MutableData>() {
                    public boolean hasNext() {
                        return it.hasNext();
                    }

                    public void remove() {
                        throw new UnsupportedOperationException("remove called on immutable collection");
                    }

                    /* renamed from: zzcmr */
                    public MutableData next() {
                        return new MutableData(MutableData.this.aPu, MutableData.this.aPv.zza(((zzakl) it.next()).zzcvs()));
                    }
                };
            }
        };
    }

    public long getChildrenCount() {
        return (long) zzcmq().getChildCount();
    }

    public String getKey() {
        if (this.aPv.zzcre() != null) {
            return this.aPv.zzcre().asString();
        }
        return null;
    }

    public Object getPriority() {
        return zzcmq().zzcux().getValue();
    }

    public Object getValue() {
        return zzcmq().getValue();
    }

    public <T> T getValue(GenericTypeIndicator<T> genericTypeIndicator) {
        return zzalq.zza(zzcmq().getValue(), genericTypeIndicator);
    }

    public <T> T getValue(Class<T> cls) {
        return zzalq.zza(zzcmq().getValue(), cls);
    }

    public boolean hasChild(String str) {
        return !zzcmq().zzao(new zzahr(str)).isEmpty();
    }

    public boolean hasChildren() {
        zzakm zzcmq = zzcmq();
        return !zzcmq.zzcuw() && !zzcmq.isEmpty();
    }

    public void setPriority(Object obj) {
        this.aPu.zzg(this.aPv, zzcmq().zzf(zzakq.zzbt(obj)));
    }

    public void setValue(Object obj) throws DatabaseException {
        zzaig.zza(this.aPv, obj);
        Object zzbx = zzalq.zzbx(obj);
        zzalp.zzbw(zzbx);
        this.aPu.zzg(this.aPv, zzakn.zzbs(zzbx));
    }

    public String toString() {
        zzaka zzcrb = this.aPv.zzcrb();
        String str = zzcrb != null ? zzcrb.asString() : "<none>";
        String valueOf = String.valueOf(this.aPu.zzcro().getValue(true));
        return new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(valueOf).length()).append("MutableData { key = ").append(str).append(", value = ").append(valueOf).append(" }").toString();
    }

    /* access modifiers changed from: 0000 */
    public zzakm zzcmq() {
        return this.aPu.zzq(this.aPv);
    }
}
