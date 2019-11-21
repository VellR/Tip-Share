package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.List;

class zzaku {

    static class zza implements zzb {
        private List<byte[]> aZu = new ArrayList();
        private int aZv = 0;

        zza() {
        }

        public boolean zzau(byte[] bArr) {
            this.aZu.add(bArr);
            this.aZv += bArr.length;
            return true;
        }

        public zzala zzcvw() {
            byte[] bArr = new byte[this.aZv];
            int i = 0;
            for (int i2 = 0; i2 < this.aZu.size(); i2++) {
                byte[] bArr2 = (byte[]) this.aZu.get(i2);
                System.arraycopy(bArr2, 0, bArr, i, bArr2.length);
                i += bArr2.length;
            }
            return new zzala(bArr);
        }
    }

    interface zzb {
        boolean zzau(byte[] bArr);

        zzala zzcvw();
    }

    static class zzc implements zzb {
        private static ThreadLocal<CharsetDecoder> aZw = new ThreadLocal<CharsetDecoder>() {
            /* access modifiers changed from: protected */
            /* renamed from: zzcvx */
            public CharsetDecoder initialValue() {
                CharsetDecoder newDecoder = Charset.forName("UTF8").newDecoder();
                newDecoder.onMalformedInput(CodingErrorAction.REPORT);
                newDecoder.onUnmappableCharacter(CodingErrorAction.REPORT);
                return newDecoder;
            }
        };
        private static ThreadLocal<CharsetEncoder> aZx = new ThreadLocal<CharsetEncoder>() {
            /* access modifiers changed from: protected */
            /* renamed from: zzcvy */
            public CharsetEncoder initialValue() {
                CharsetEncoder newEncoder = Charset.forName("UTF8").newEncoder();
                newEncoder.onMalformedInput(CodingErrorAction.REPORT);
                newEncoder.onUnmappableCharacter(CodingErrorAction.REPORT);
                return newEncoder;
            }
        };
        private StringBuilder aZy = new StringBuilder();

        zzc() {
        }

        private String zzav(byte[] bArr) {
            try {
                return ((CharsetDecoder) aZw.get()).decode(ByteBuffer.wrap(bArr)).toString();
            } catch (CharacterCodingException e) {
                return null;
            }
        }

        public boolean zzau(byte[] bArr) {
            String zzav = zzav(bArr);
            if (zzav == null) {
                return false;
            }
            this.aZy.append(zzav);
            return true;
        }

        public zzala zzcvw() {
            return new zzala(this.aZy.toString());
        }
    }

    static zzb zzb(byte b) {
        return b == 2 ? new zza() : new zzc();
    }
}
