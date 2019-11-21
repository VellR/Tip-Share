package com.google.android.gms.internal;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public final class zzaof extends zzaop {
    private static final Reader bfJ = new Reader() {
        public void close() throws IOException {
            throw new AssertionError();
        }

        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object bfK = new Object();
    private final List<Object> bfL = new ArrayList();

    public zzaof(zzamy zzamy) {
        super(bfJ);
        this.bfL.add(zzamy);
    }

    private Object i() {
        return this.bfL.get(this.bfL.size() - 1);
    }

    private Object j() {
        return this.bfL.remove(this.bfL.size() - 1);
    }

    private void zza(zzaoq zzaoq) throws IOException {
        if (h() != zzaoq) {
            String valueOf = String.valueOf(zzaoq);
            String valueOf2 = String.valueOf(h());
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 18 + String.valueOf(valueOf2).length()).append("Expected ").append(valueOf).append(" but was ").append(valueOf2).toString());
        }
    }

    public void beginArray() throws IOException {
        zza(zzaoq.BEGIN_ARRAY);
        this.bfL.add(((zzamv) i()).iterator());
    }

    public void beginObject() throws IOException {
        zza(zzaoq.BEGIN_OBJECT);
        this.bfL.add(((zzanb) i()).entrySet().iterator());
    }

    public void close() throws IOException {
        this.bfL.clear();
        this.bfL.add(bfK);
    }

    public void endArray() throws IOException {
        zza(zzaoq.END_ARRAY);
        j();
        j();
    }

    public void endObject() throws IOException {
        zza(zzaoq.END_OBJECT);
        j();
        j();
    }

    public zzaoq h() throws IOException {
        if (this.bfL.isEmpty()) {
            return zzaoq.END_DOCUMENT;
        }
        Object i = i();
        if (i instanceof Iterator) {
            boolean z = this.bfL.get(this.bfL.size() - 2) instanceof zzanb;
            Iterator it = (Iterator) i;
            if (!it.hasNext()) {
                return z ? zzaoq.END_OBJECT : zzaoq.END_ARRAY;
            }
            if (z) {
                return zzaoq.NAME;
            }
            this.bfL.add(it.next());
            return h();
        } else if (i instanceof zzanb) {
            return zzaoq.BEGIN_OBJECT;
        } else {
            if (i instanceof zzamv) {
                return zzaoq.BEGIN_ARRAY;
            }
            if (i instanceof zzane) {
                zzane zzane = (zzane) i;
                if (zzane.zzczw()) {
                    return zzaoq.STRING;
                }
                if (zzane.zzczu()) {
                    return zzaoq.BOOLEAN;
                }
                if (zzane.zzczv()) {
                    return zzaoq.NUMBER;
                }
                throw new AssertionError();
            } else if (i instanceof zzana) {
                return zzaoq.NULL;
            } else {
                if (i == bfK) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    public boolean hasNext() throws IOException {
        zzaoq h = h();
        return (h == zzaoq.END_OBJECT || h == zzaoq.END_ARRAY) ? false : true;
    }

    public void k() throws IOException {
        zza(zzaoq.NAME);
        Entry entry = (Entry) ((Iterator) i()).next();
        this.bfL.add(entry.getValue());
        this.bfL.add(new zzane((String) entry.getKey()));
    }

    public boolean nextBoolean() throws IOException {
        zza(zzaoq.BOOLEAN);
        return ((zzane) j()).zzczl();
    }

    public double nextDouble() throws IOException {
        zzaoq h = h();
        if (h == zzaoq.NUMBER || h == zzaoq.STRING) {
            double zzczi = ((zzane) i()).zzczi();
            if (isLenient() || (!Double.isNaN(zzczi) && !Double.isInfinite(zzczi))) {
                j();
                return zzczi;
            }
            throw new NumberFormatException("JSON forbids NaN and infinities: " + zzczi);
        }
        String valueOf = String.valueOf(zzaoq.NUMBER);
        String valueOf2 = String.valueOf(h);
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 18 + String.valueOf(valueOf2).length()).append("Expected ").append(valueOf).append(" but was ").append(valueOf2).toString());
    }

    public int nextInt() throws IOException {
        zzaoq h = h();
        if (h == zzaoq.NUMBER || h == zzaoq.STRING) {
            int zzczk = ((zzane) i()).zzczk();
            j();
            return zzczk;
        }
        String valueOf = String.valueOf(zzaoq.NUMBER);
        String valueOf2 = String.valueOf(h);
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 18 + String.valueOf(valueOf2).length()).append("Expected ").append(valueOf).append(" but was ").append(valueOf2).toString());
    }

    public long nextLong() throws IOException {
        zzaoq h = h();
        if (h == zzaoq.NUMBER || h == zzaoq.STRING) {
            long zzczj = ((zzane) i()).zzczj();
            j();
            return zzczj;
        }
        String valueOf = String.valueOf(zzaoq.NUMBER);
        String valueOf2 = String.valueOf(h);
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 18 + String.valueOf(valueOf2).length()).append("Expected ").append(valueOf).append(" but was ").append(valueOf2).toString());
    }

    public String nextName() throws IOException {
        zza(zzaoq.NAME);
        Entry entry = (Entry) ((Iterator) i()).next();
        this.bfL.add(entry.getValue());
        return (String) entry.getKey();
    }

    public void nextNull() throws IOException {
        zza(zzaoq.NULL);
        j();
    }

    public String nextString() throws IOException {
        zzaoq h = h();
        if (h == zzaoq.STRING || h == zzaoq.NUMBER) {
            return ((zzane) j()).zzczh();
        }
        String valueOf = String.valueOf(zzaoq.STRING);
        String valueOf2 = String.valueOf(h);
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 18 + String.valueOf(valueOf2).length()).append("Expected ").append(valueOf).append(" but was ").append(valueOf2).toString());
    }

    public void skipValue() throws IOException {
        if (h() == zzaoq.NAME) {
            nextName();
        } else {
            j();
        }
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
