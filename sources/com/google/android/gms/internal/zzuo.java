package com.google.android.gms.internal;

import java.io.IOException;

public interface zzuo {

    public static final class zza extends zzapc {
        private static volatile zza[] aow;
        public Boolean aox;
        public Boolean aoy;
        public String name;

        public zza() {
            zzbwk();
        }

        public static zza[] zzbwj() {
            if (aow == null) {
                synchronized (zzapa.bij) {
                    if (aow == null) {
                        aow = new zza[0];
                    }
                }
            }
            return aow;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (this.name == null) {
                if (zza.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zza.name)) {
                return false;
            }
            if (this.aox == null) {
                if (zza.aox != null) {
                    return false;
                }
            } else if (!this.aox.equals(zza.aox)) {
                return false;
            }
            return this.aoy == null ? zza.aoy == null : this.aoy.equals(zza.aoy);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.aox == null ? 0 : this.aox.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (this.aoy != null) {
                i = this.aoy.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzaov zzaov) throws IOException {
            if (this.name != null) {
                zzaov.zzr(1, this.name);
            }
            if (this.aox != null) {
                zzaov.zzj(2, this.aox.booleanValue());
            }
            if (this.aoy != null) {
                zzaov.zzj(3, this.aoy.booleanValue());
            }
            super.zza(zzaov);
        }

        /* renamed from: zzbj */
        public zza zzb(zzaou zzaou) throws IOException {
            while (true) {
                int J = zzaou.J();
                switch (J) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzaou.readString();
                        continue;
                    case 16:
                        this.aox = Boolean.valueOf(zzaou.P());
                        continue;
                    case 24:
                        this.aoy = Boolean.valueOf(zzaou.P());
                        continue;
                    default:
                        if (!zzapf.zzb(zzaou, J)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        public zza zzbwk() {
            this.name = null;
            this.aox = null;
            this.aoy = null;
            this.bik = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            if (this.name != null) {
                zzy += zzaov.zzs(1, this.name);
            }
            if (this.aox != null) {
                zzy += zzaov.zzk(2, this.aox.booleanValue());
            }
            return this.aoy != null ? zzy + zzaov.zzk(3, this.aoy.booleanValue()) : zzy;
        }
    }

    public static final class zzb extends zzapc {
        public String ajz;
        public Integer aoA;
        public zzc[] aoB;
        public zza[] aoC;
        public com.google.android.gms.internal.zzun.zza[] aoD;
        public Long aoz;

        public zzb() {
            zzbwl();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzb = (zzb) obj;
            if (this.aoz == null) {
                if (zzb.aoz != null) {
                    return false;
                }
            } else if (!this.aoz.equals(zzb.aoz)) {
                return false;
            }
            if (this.ajz == null) {
                if (zzb.ajz != null) {
                    return false;
                }
            } else if (!this.ajz.equals(zzb.ajz)) {
                return false;
            }
            if (this.aoA == null) {
                if (zzb.aoA != null) {
                    return false;
                }
            } else if (!this.aoA.equals(zzb.aoA)) {
                return false;
            }
            if (!zzapa.equals((Object[]) this.aoB, (Object[]) zzb.aoB)) {
                return false;
            }
            if (!zzapa.equals((Object[]) this.aoC, (Object[]) zzb.aoC)) {
                return false;
            }
            return zzapa.equals((Object[]) this.aoD, (Object[]) zzb.aoD);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.ajz == null ? 0 : this.ajz.hashCode()) + (((this.aoz == null ? 0 : this.aoz.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (this.aoA != null) {
                i = this.aoA.hashCode();
            }
            return ((((((hashCode + i) * 31) + zzapa.hashCode((Object[]) this.aoB)) * 31) + zzapa.hashCode((Object[]) this.aoC)) * 31) + zzapa.hashCode((Object[]) this.aoD);
        }

        public void zza(zzaov zzaov) throws IOException {
            if (this.aoz != null) {
                zzaov.zzb(1, this.aoz.longValue());
            }
            if (this.ajz != null) {
                zzaov.zzr(2, this.ajz);
            }
            if (this.aoA != null) {
                zzaov.zzae(3, this.aoA.intValue());
            }
            if (this.aoB != null && this.aoB.length > 0) {
                for (zzc zzc : this.aoB) {
                    if (zzc != null) {
                        zzaov.zza(4, (zzapc) zzc);
                    }
                }
            }
            if (this.aoC != null && this.aoC.length > 0) {
                for (zza zza : this.aoC) {
                    if (zza != null) {
                        zzaov.zza(5, (zzapc) zza);
                    }
                }
            }
            if (this.aoD != null && this.aoD.length > 0) {
                for (com.google.android.gms.internal.zzun.zza zza2 : this.aoD) {
                    if (zza2 != null) {
                        zzaov.zza(6, (zzapc) zza2);
                    }
                }
            }
            super.zza(zzaov);
        }

        /* renamed from: zzbk */
        public zzb zzb(zzaou zzaou) throws IOException {
            while (true) {
                int J = zzaou.J();
                switch (J) {
                    case 0:
                        break;
                    case 8:
                        this.aoz = Long.valueOf(zzaou.M());
                        continue;
                    case 18:
                        this.ajz = zzaou.readString();
                        continue;
                    case 24:
                        this.aoA = Integer.valueOf(zzaou.N());
                        continue;
                    case 34:
                        int zzc = zzapf.zzc(zzaou, 34);
                        int length = this.aoB == null ? 0 : this.aoB.length;
                        zzc[] zzcArr = new zzc[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.aoB, 0, zzcArr, 0, length);
                        }
                        while (length < zzcArr.length - 1) {
                            zzcArr[length] = new zzc();
                            zzaou.zza(zzcArr[length]);
                            zzaou.J();
                            length++;
                        }
                        zzcArr[length] = new zzc();
                        zzaou.zza(zzcArr[length]);
                        this.aoB = zzcArr;
                        continue;
                    case 42:
                        int zzc2 = zzapf.zzc(zzaou, 42);
                        int length2 = this.aoC == null ? 0 : this.aoC.length;
                        zza[] zzaArr = new zza[(zzc2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.aoC, 0, zzaArr, 0, length2);
                        }
                        while (length2 < zzaArr.length - 1) {
                            zzaArr[length2] = new zza();
                            zzaou.zza(zzaArr[length2]);
                            zzaou.J();
                            length2++;
                        }
                        zzaArr[length2] = new zza();
                        zzaou.zza(zzaArr[length2]);
                        this.aoC = zzaArr;
                        continue;
                    case 50:
                        int zzc3 = zzapf.zzc(zzaou, 50);
                        int length3 = this.aoD == null ? 0 : this.aoD.length;
                        com.google.android.gms.internal.zzun.zza[] zzaArr2 = new com.google.android.gms.internal.zzun.zza[(zzc3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.aoD, 0, zzaArr2, 0, length3);
                        }
                        while (length3 < zzaArr2.length - 1) {
                            zzaArr2[length3] = new com.google.android.gms.internal.zzun.zza();
                            zzaou.zza(zzaArr2[length3]);
                            zzaou.J();
                            length3++;
                        }
                        zzaArr2[length3] = new com.google.android.gms.internal.zzun.zza();
                        zzaou.zza(zzaArr2[length3]);
                        this.aoD = zzaArr2;
                        continue;
                    default:
                        if (!zzapf.zzb(zzaou, J)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        public zzb zzbwl() {
            this.aoz = null;
            this.ajz = null;
            this.aoA = null;
            this.aoB = zzc.zzbwm();
            this.aoC = zza.zzbwj();
            this.aoD = com.google.android.gms.internal.zzun.zza.zzbvz();
            this.bik = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            if (this.aoz != null) {
                zzy += zzaov.zze(1, this.aoz.longValue());
            }
            if (this.ajz != null) {
                zzy += zzaov.zzs(2, this.ajz);
            }
            if (this.aoA != null) {
                zzy += zzaov.zzag(3, this.aoA.intValue());
            }
            if (this.aoB != null && this.aoB.length > 0) {
                int i = zzy;
                for (zzc zzc : this.aoB) {
                    if (zzc != null) {
                        i += zzaov.zzc(4, (zzapc) zzc);
                    }
                }
                zzy = i;
            }
            if (this.aoC != null && this.aoC.length > 0) {
                int i2 = zzy;
                for (zza zza : this.aoC) {
                    if (zza != null) {
                        i2 += zzaov.zzc(5, (zzapc) zza);
                    }
                }
                zzy = i2;
            }
            if (this.aoD != null && this.aoD.length > 0) {
                for (com.google.android.gms.internal.zzun.zza zza2 : this.aoD) {
                    if (zza2 != null) {
                        zzy += zzaov.zzc(6, (zzapc) zza2);
                    }
                }
            }
            return zzy;
        }
    }

    public static final class zzc extends zzapc {
        private static volatile zzc[] aoE;
        public String value;
        public String zzcb;

        public zzc() {
            zzbwn();
        }

        public static zzc[] zzbwm() {
            if (aoE == null) {
                synchronized (zzapa.bij) {
                    if (aoE == null) {
                        aoE = new zzc[0];
                    }
                }
            }
            return aoE;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc zzc = (zzc) obj;
            if (this.zzcb == null) {
                if (zzc.zzcb != null) {
                    return false;
                }
            } else if (!this.zzcb.equals(zzc.zzcb)) {
                return false;
            }
            return this.value == null ? zzc.value == null : this.value.equals(zzc.value);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzcb == null ? 0 : this.zzcb.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31;
            if (this.value != null) {
                i = this.value.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzaov zzaov) throws IOException {
            if (this.zzcb != null) {
                zzaov.zzr(1, this.zzcb);
            }
            if (this.value != null) {
                zzaov.zzr(2, this.value);
            }
            super.zza(zzaov);
        }

        /* renamed from: zzbl */
        public zzc zzb(zzaou zzaou) throws IOException {
            while (true) {
                int J = zzaou.J();
                switch (J) {
                    case 0:
                        break;
                    case 10:
                        this.zzcb = zzaou.readString();
                        continue;
                    case 18:
                        this.value = zzaou.readString();
                        continue;
                    default:
                        if (!zzapf.zzb(zzaou, J)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        public zzc zzbwn() {
            this.zzcb = null;
            this.value = null;
            this.bik = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            if (this.zzcb != null) {
                zzy += zzaov.zzs(1, this.zzcb);
            }
            return this.value != null ? zzy + zzaov.zzs(2, this.value) : zzy;
        }
    }
}
