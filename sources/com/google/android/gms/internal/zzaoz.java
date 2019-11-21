package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class zzaoz implements Cloneable {
    private Object aQx;
    private zzaox<?, ?> bih;
    private List<zzape> bii = new ArrayList();

    zzaoz() {
    }

    private byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zzy()];
        zza(zzaov.zzba(bArr));
        return bArr;
    }

    /* renamed from: af */
    public final zzaoz clone() {
        int i = 0;
        zzaoz zzaoz = new zzaoz();
        try {
            zzaoz.bih = this.bih;
            if (this.bii == null) {
                zzaoz.bii = null;
            } else {
                zzaoz.bii.addAll(this.bii);
            }
            if (this.aQx != null) {
                if (this.aQx instanceof zzapc) {
                    zzaoz.aQx = (zzapc) ((zzapc) this.aQx).clone();
                } else if (this.aQx instanceof byte[]) {
                    zzaoz.aQx = ((byte[]) this.aQx).clone();
                } else if (this.aQx instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.aQx;
                    byte[][] bArr2 = new byte[bArr.length][];
                    zzaoz.aQx = bArr2;
                    for (int i2 = 0; i2 < bArr.length; i2++) {
                        bArr2[i2] = (byte[]) bArr[i2].clone();
                    }
                } else if (this.aQx instanceof boolean[]) {
                    zzaoz.aQx = ((boolean[]) this.aQx).clone();
                } else if (this.aQx instanceof int[]) {
                    zzaoz.aQx = ((int[]) this.aQx).clone();
                } else if (this.aQx instanceof long[]) {
                    zzaoz.aQx = ((long[]) this.aQx).clone();
                } else if (this.aQx instanceof float[]) {
                    zzaoz.aQx = ((float[]) this.aQx).clone();
                } else if (this.aQx instanceof double[]) {
                    zzaoz.aQx = ((double[]) this.aQx).clone();
                } else if (this.aQx instanceof zzapc[]) {
                    zzapc[] zzapcArr = (zzapc[]) this.aQx;
                    zzapc[] zzapcArr2 = new zzapc[zzapcArr.length];
                    zzaoz.aQx = zzapcArr2;
                    while (true) {
                        int i3 = i;
                        if (i3 >= zzapcArr.length) {
                            break;
                        }
                        zzapcArr2[i3] = (zzapc) zzapcArr[i3].clone();
                        i = i3 + 1;
                    }
                }
            }
            return zzaoz;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzaoz)) {
            return false;
        }
        zzaoz zzaoz = (zzaoz) obj;
        if (this.aQx == null || zzaoz.aQx == null) {
            if (this.bii != null && zzaoz.bii != null) {
                return this.bii.equals(zzaoz.bii);
            }
            try {
                return Arrays.equals(toByteArray(), zzaoz.toByteArray());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } else if (this.bih == zzaoz.bih) {
            return !this.bih.bau.isArray() ? this.aQx.equals(zzaoz.aQx) : this.aQx instanceof byte[] ? Arrays.equals((byte[]) this.aQx, (byte[]) zzaoz.aQx) : this.aQx instanceof int[] ? Arrays.equals((int[]) this.aQx, (int[]) zzaoz.aQx) : this.aQx instanceof long[] ? Arrays.equals((long[]) this.aQx, (long[]) zzaoz.aQx) : this.aQx instanceof float[] ? Arrays.equals((float[]) this.aQx, (float[]) zzaoz.aQx) : this.aQx instanceof double[] ? Arrays.equals((double[]) this.aQx, (double[]) zzaoz.aQx) : this.aQx instanceof boolean[] ? Arrays.equals((boolean[]) this.aQx, (boolean[]) zzaoz.aQx) : Arrays.deepEquals((Object[]) this.aQx, (Object[]) zzaoz.aQx);
        } else {
            return false;
        }
    }

    public int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: 0000 */
    public void zza(zzaov zzaov) throws IOException {
        if (this.aQx != null) {
            this.bih.zza(this.aQx, zzaov);
            return;
        }
        for (zzape zza : this.bii) {
            zza.zza(zzaov);
        }
    }

    /* access modifiers changed from: 0000 */
    public void zza(zzape zzape) {
        this.bii.add(zzape);
    }

    /* access modifiers changed from: 0000 */
    public <T> T zzb(zzaox<?, T> zzaox) {
        if (this.aQx == null) {
            this.bih = zzaox;
            this.aQx = zzaox.zzav(this.bii);
            this.bii = null;
        } else if (!this.bih.equals(zzaox)) {
            throw new IllegalStateException("Tried to getExtension with a different Extension.");
        }
        return this.aQx;
    }

    /* access modifiers changed from: 0000 */
    public int zzy() {
        int i = 0;
        if (this.aQx != null) {
            return this.bih.zzcr(this.aQx);
        }
        Iterator it = this.bii.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = ((zzape) it.next()).zzy() + i2;
        }
    }
}
