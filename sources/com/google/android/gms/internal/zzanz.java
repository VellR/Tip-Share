package com.google.android.gms.internal;

import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

public final class zzanz {

    private static final class zza extends Writer {
        private final Appendable bfx;
        private final C0032zza bfy;

        /* renamed from: com.google.android.gms.internal.zzanz$zza$zza reason: collision with other inner class name */
        static class C0032zza implements CharSequence {
            char[] bfz;

            C0032zza() {
            }

            public char charAt(int i) {
                return this.bfz[i];
            }

            public int length() {
                return this.bfz.length;
            }

            public CharSequence subSequence(int i, int i2) {
                return new String(this.bfz, i, i2 - i);
            }
        }

        private zza(Appendable appendable) {
            this.bfy = new C0032zza();
            this.bfx = appendable;
        }

        public void close() {
        }

        public void flush() {
        }

        public void write(int i) throws IOException {
            this.bfx.append((char) i);
        }

        public void write(char[] cArr, int i, int i2) throws IOException {
            this.bfy.bfz = cArr;
            this.bfx.append(this.bfy, i, i + i2);
        }
    }

    public static Writer zza(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new zza(appendable);
    }

    public static void zzb(zzamy zzamy, zzaor zzaor) throws IOException {
        zzaon.bgW.zza(zzaor, zzamy);
    }

    public static zzamy zzh(zzaop zzaop) throws zzanc {
        boolean z = true;
        try {
            zzaop.h();
            z = false;
            return (zzamy) zzaon.bgW.zzb(zzaop);
        } catch (EOFException e) {
            if (z) {
                return zzana.bes;
            }
            throw new zzanh((Throwable) e);
        } catch (zzaos e2) {
            throw new zzanh((Throwable) e2);
        } catch (IOException e3) {
            throw new zzamz((Throwable) e3);
        } catch (NumberFormatException e4) {
            throw new zzanh((Throwable) e4);
        }
    }
}
