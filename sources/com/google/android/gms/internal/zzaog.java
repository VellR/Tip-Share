package com.google.android.gms.internal;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class zzaog extends zzaor {
    private static final Writer bfM = new Writer() {
        public void close() throws IOException {
            throw new AssertionError();
        }

        public void flush() throws IOException {
            throw new AssertionError();
        }

        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }
    };
    private static final zzane bfN = new zzane("closed");
    private final List<zzamy> bfL = new ArrayList();
    private String bfO;
    private zzamy bfP = zzana.bes;

    public zzaog() {
        super(bfM);
    }

    private zzamy m() {
        return (zzamy) this.bfL.get(this.bfL.size() - 1);
    }

    private void zzd(zzamy zzamy) {
        if (this.bfO != null) {
            if (!zzamy.zzczp() || E()) {
                ((zzanb) m()).zza(this.bfO, zzamy);
            }
            this.bfO = null;
        } else if (this.bfL.isEmpty()) {
            this.bfP = zzamy;
        } else {
            zzamy m = m();
            if (m instanceof zzamv) {
                ((zzamv) m).zzc(zzamy);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public void close() throws IOException {
        if (!this.bfL.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.bfL.add(bfN);
    }

    public void flush() throws IOException {
    }

    public zzamy l() {
        if (this.bfL.isEmpty()) {
            return this.bfP;
        }
        String valueOf = String.valueOf(this.bfL);
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 34).append("Expected one JSON element but was ").append(valueOf).toString());
    }

    public zzaor n() throws IOException {
        zzamv zzamv = new zzamv();
        zzd(zzamv);
        this.bfL.add(zzamv);
        return this;
    }

    public zzaor o() throws IOException {
        if (this.bfL.isEmpty() || this.bfO != null) {
            throw new IllegalStateException();
        } else if (m() instanceof zzamv) {
            this.bfL.remove(this.bfL.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public zzaor p() throws IOException {
        zzanb zzanb = new zzanb();
        zzd(zzanb);
        this.bfL.add(zzanb);
        return this;
    }

    public zzaor q() throws IOException {
        if (this.bfL.isEmpty() || this.bfO != null) {
            throw new IllegalStateException();
        } else if (m() instanceof zzanb) {
            this.bfL.remove(this.bfL.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public zzaor r() throws IOException {
        zzd(zzana.bes);
        return this;
    }

    public zzaor zza(Number number) throws IOException {
        if (number == null) {
            return r();
        }
        if (!isLenient()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                String valueOf = String.valueOf(number);
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 33).append("JSON forbids NaN and infinities: ").append(valueOf).toString());
            }
        }
        zzd(new zzane(number));
        return this;
    }

    public zzaor zzcp(long j) throws IOException {
        zzd(new zzane((Number) Long.valueOf(j)));
        return this;
    }

    public zzaor zzcz(boolean z) throws IOException {
        zzd(new zzane(Boolean.valueOf(z)));
        return this;
    }

    public zzaor zzta(String str) throws IOException {
        if (this.bfL.isEmpty() || this.bfO != null) {
            throw new IllegalStateException();
        } else if (m() instanceof zzanb) {
            this.bfO = str;
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public zzaor zztb(String str) throws IOException {
        if (str == null) {
            return r();
        }
        zzd(new zzane(str));
        return this;
    }
}
