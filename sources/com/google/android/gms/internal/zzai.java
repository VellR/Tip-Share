package com.google.android.gms.internal;

import java.io.IOException;

public interface zzai {

    public static final class zza extends zzaow<zza> {
        private static volatile zza[] zzws;
        public int type;
        public String zzwt;
        public zza[] zzwu;
        public zza[] zzwv;
        public zza[] zzww;
        public String zzwx;
        public String zzwy;
        public long zzwz;
        public boolean zzxa;
        public zza[] zzxb;
        public int[] zzxc;
        public boolean zzxd;

        public zza() {
            zzar();
        }

        public static zza[] zzaq() {
            if (zzws == null) {
                synchronized (zzapa.bij) {
                    if (zzws == null) {
                        zzws = new zza[0];
                    }
                }
            }
            return zzws;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (this.type != zza.type) {
                return false;
            }
            if (this.zzwt == null) {
                if (zza.zzwt != null) {
                    return false;
                }
            } else if (!this.zzwt.equals(zza.zzwt)) {
                return false;
            }
            if (!zzapa.equals((Object[]) this.zzwu, (Object[]) zza.zzwu) || !zzapa.equals((Object[]) this.zzwv, (Object[]) zza.zzwv) || !zzapa.equals((Object[]) this.zzww, (Object[]) zza.zzww)) {
                return false;
            }
            if (this.zzwx == null) {
                if (zza.zzwx != null) {
                    return false;
                }
            } else if (!this.zzwx.equals(zza.zzwx)) {
                return false;
            }
            if (this.zzwy == null) {
                if (zza.zzwy != null) {
                    return false;
                }
            } else if (!this.zzwy.equals(zza.zzwy)) {
                return false;
            }
            if (this.zzwz == zza.zzwz && this.zzxa == zza.zzxa && zzapa.equals((Object[]) this.zzxb, (Object[]) zza.zzxb) && zzapa.equals(this.zzxc, zza.zzxc) && this.zzxd == zza.zzxd) {
                return (this.bib == null || this.bib.isEmpty()) ? zza.bib == null || zza.bib.isEmpty() : this.bib.equals(zza.bib);
            }
            return false;
        }

        public int hashCode() {
            int i = 1231;
            int i2 = 0;
            int hashCode = ((((((this.zzxa ? 1231 : 1237) + (((((this.zzwy == null ? 0 : this.zzwy.hashCode()) + (((this.zzwx == null ? 0 : this.zzwx.hashCode()) + (((((((((this.zzwt == null ? 0 : this.zzwt.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.type) * 31)) * 31) + zzapa.hashCode((Object[]) this.zzwu)) * 31) + zzapa.hashCode((Object[]) this.zzwv)) * 31) + zzapa.hashCode((Object[]) this.zzww)) * 31)) * 31)) * 31) + ((int) (this.zzwz ^ (this.zzwz >>> 32)))) * 31)) * 31) + zzapa.hashCode((Object[]) this.zzxb)) * 31) + zzapa.hashCode(this.zzxc)) * 31;
            if (!this.zzxd) {
                i = 1237;
            }
            int i3 = (hashCode + i) * 31;
            if (this.bib != null && !this.bib.isEmpty()) {
                i2 = this.bib.hashCode();
            }
            return i3 + i2;
        }

        public void zza(zzaov zzaov) throws IOException {
            zzaov.zzae(1, this.type);
            if (!this.zzwt.equals("")) {
                zzaov.zzr(2, this.zzwt);
            }
            if (this.zzwu != null && this.zzwu.length > 0) {
                for (zza zza : this.zzwu) {
                    if (zza != null) {
                        zzaov.zza(3, (zzapc) zza);
                    }
                }
            }
            if (this.zzwv != null && this.zzwv.length > 0) {
                for (zza zza2 : this.zzwv) {
                    if (zza2 != null) {
                        zzaov.zza(4, (zzapc) zza2);
                    }
                }
            }
            if (this.zzww != null && this.zzww.length > 0) {
                for (zza zza3 : this.zzww) {
                    if (zza3 != null) {
                        zzaov.zza(5, (zzapc) zza3);
                    }
                }
            }
            if (!this.zzwx.equals("")) {
                zzaov.zzr(6, this.zzwx);
            }
            if (!this.zzwy.equals("")) {
                zzaov.zzr(7, this.zzwy);
            }
            if (this.zzwz != 0) {
                zzaov.zzb(8, this.zzwz);
            }
            if (this.zzxd) {
                zzaov.zzj(9, this.zzxd);
            }
            if (this.zzxc != null && this.zzxc.length > 0) {
                for (int zzae : this.zzxc) {
                    zzaov.zzae(10, zzae);
                }
            }
            if (this.zzxb != null && this.zzxb.length > 0) {
                for (zza zza4 : this.zzxb) {
                    if (zza4 != null) {
                        zzaov.zza(11, (zzapc) zza4);
                    }
                }
            }
            if (this.zzxa) {
                zzaov.zzj(12, this.zzxa);
            }
            super.zza(zzaov);
        }

        public zza zzar() {
            this.type = 1;
            this.zzwt = "";
            this.zzwu = zzaq();
            this.zzwv = zzaq();
            this.zzww = zzaq();
            this.zzwx = "";
            this.zzwy = "";
            this.zzwz = 0;
            this.zzxa = false;
            this.zzxb = zzaq();
            this.zzxc = zzapf.bim;
            this.zzxd = false;
            this.bib = null;
            this.bik = -1;
            return this;
        }

        /* renamed from: zzt */
        public zza zzb(zzaou zzaou) throws IOException {
            int i;
            while (true) {
                int J = zzaou.J();
                switch (J) {
                    case 0:
                        break;
                    case 8:
                        int N = zzaou.N();
                        switch (N) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                                this.type = N;
                                break;
                            default:
                                continue;
                        }
                    case 18:
                        this.zzwt = zzaou.readString();
                        continue;
                    case 26:
                        int zzc = zzapf.zzc(zzaou, 26);
                        int length = this.zzwu == null ? 0 : this.zzwu.length;
                        zza[] zzaArr = new zza[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzwu, 0, zzaArr, 0, length);
                        }
                        while (length < zzaArr.length - 1) {
                            zzaArr[length] = new zza();
                            zzaou.zza(zzaArr[length]);
                            zzaou.J();
                            length++;
                        }
                        zzaArr[length] = new zza();
                        zzaou.zza(zzaArr[length]);
                        this.zzwu = zzaArr;
                        continue;
                    case 34:
                        int zzc2 = zzapf.zzc(zzaou, 34);
                        int length2 = this.zzwv == null ? 0 : this.zzwv.length;
                        zza[] zzaArr2 = new zza[(zzc2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzwv, 0, zzaArr2, 0, length2);
                        }
                        while (length2 < zzaArr2.length - 1) {
                            zzaArr2[length2] = new zza();
                            zzaou.zza(zzaArr2[length2]);
                            zzaou.J();
                            length2++;
                        }
                        zzaArr2[length2] = new zza();
                        zzaou.zza(zzaArr2[length2]);
                        this.zzwv = zzaArr2;
                        continue;
                    case 42:
                        int zzc3 = zzapf.zzc(zzaou, 42);
                        int length3 = this.zzww == null ? 0 : this.zzww.length;
                        zza[] zzaArr3 = new zza[(zzc3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzww, 0, zzaArr3, 0, length3);
                        }
                        while (length3 < zzaArr3.length - 1) {
                            zzaArr3[length3] = new zza();
                            zzaou.zza(zzaArr3[length3]);
                            zzaou.J();
                            length3++;
                        }
                        zzaArr3[length3] = new zza();
                        zzaou.zza(zzaArr3[length3]);
                        this.zzww = zzaArr3;
                        continue;
                    case 50:
                        this.zzwx = zzaou.readString();
                        continue;
                    case 58:
                        this.zzwy = zzaou.readString();
                        continue;
                    case 64:
                        this.zzwz = zzaou.M();
                        continue;
                    case 72:
                        this.zzxd = zzaou.P();
                        continue;
                    case 80:
                        int zzc4 = zzapf.zzc(zzaou, 80);
                        int[] iArr = new int[zzc4];
                        int i2 = 0;
                        int i3 = 0;
                        while (i2 < zzc4) {
                            if (i2 != 0) {
                                zzaou.J();
                            }
                            int N2 = zzaou.N();
                            switch (N2) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                    i = i3 + 1;
                                    iArr[i3] = N2;
                                    break;
                                default:
                                    i = i3;
                                    break;
                            }
                            i2++;
                            i3 = i;
                        }
                        if (i3 != 0) {
                            int length4 = this.zzxc == null ? 0 : this.zzxc.length;
                            if (length4 != 0 || i3 != zzc4) {
                                int[] iArr2 = new int[(length4 + i3)];
                                if (length4 != 0) {
                                    System.arraycopy(this.zzxc, 0, iArr2, 0, length4);
                                }
                                System.arraycopy(iArr, 0, iArr2, length4, i3);
                                this.zzxc = iArr2;
                                break;
                            } else {
                                this.zzxc = iArr;
                                break;
                            }
                        } else {
                            continue;
                        }
                    case 82:
                        int zzaei = zzaou.zzaei(zzaou.S());
                        int position = zzaou.getPosition();
                        int i4 = 0;
                        while (zzaou.X() > 0) {
                            switch (zzaou.N()) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                    i4++;
                                    break;
                            }
                        }
                        if (i4 != 0) {
                            zzaou.zzaek(position);
                            int length5 = this.zzxc == null ? 0 : this.zzxc.length;
                            int[] iArr3 = new int[(i4 + length5)];
                            if (length5 != 0) {
                                System.arraycopy(this.zzxc, 0, iArr3, 0, length5);
                            }
                            while (zzaou.X() > 0) {
                                int N3 = zzaou.N();
                                switch (N3) {
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                    case 9:
                                    case 10:
                                    case 11:
                                    case 12:
                                    case 13:
                                    case 14:
                                    case 15:
                                    case 16:
                                    case 17:
                                        int i5 = length5 + 1;
                                        iArr3[length5] = N3;
                                        length5 = i5;
                                        break;
                                }
                            }
                            this.zzxc = iArr3;
                        }
                        zzaou.zzaej(zzaei);
                        continue;
                    case 90:
                        int zzc5 = zzapf.zzc(zzaou, 90);
                        int length6 = this.zzxb == null ? 0 : this.zzxb.length;
                        zza[] zzaArr4 = new zza[(zzc5 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.zzxb, 0, zzaArr4, 0, length6);
                        }
                        while (length6 < zzaArr4.length - 1) {
                            zzaArr4[length6] = new zza();
                            zzaou.zza(zzaArr4[length6]);
                            zzaou.J();
                            length6++;
                        }
                        zzaArr4[length6] = new zza();
                        zzaou.zza(zzaArr4[length6]);
                        this.zzxb = zzaArr4;
                        continue;
                    case 96:
                        this.zzxa = zzaou.P();
                        continue;
                    default:
                        if (!super.zza(zzaou, J)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy() + zzaov.zzag(1, this.type);
            if (!this.zzwt.equals("")) {
                zzy += zzaov.zzs(2, this.zzwt);
            }
            if (this.zzwu != null && this.zzwu.length > 0) {
                int i = zzy;
                for (zza zza : this.zzwu) {
                    if (zza != null) {
                        i += zzaov.zzc(3, (zzapc) zza);
                    }
                }
                zzy = i;
            }
            if (this.zzwv != null && this.zzwv.length > 0) {
                int i2 = zzy;
                for (zza zza2 : this.zzwv) {
                    if (zza2 != null) {
                        i2 += zzaov.zzc(4, (zzapc) zza2);
                    }
                }
                zzy = i2;
            }
            if (this.zzww != null && this.zzww.length > 0) {
                int i3 = zzy;
                for (zza zza3 : this.zzww) {
                    if (zza3 != null) {
                        i3 += zzaov.zzc(5, (zzapc) zza3);
                    }
                }
                zzy = i3;
            }
            if (!this.zzwx.equals("")) {
                zzy += zzaov.zzs(6, this.zzwx);
            }
            if (!this.zzwy.equals("")) {
                zzy += zzaov.zzs(7, this.zzwy);
            }
            if (this.zzwz != 0) {
                zzy += zzaov.zze(8, this.zzwz);
            }
            if (this.zzxd) {
                zzy += zzaov.zzk(9, this.zzxd);
            }
            if (this.zzxc != null && this.zzxc.length > 0) {
                int i4 = 0;
                for (int zzaeo : this.zzxc) {
                    i4 += zzaov.zzaeo(zzaeo);
                }
                zzy = zzy + i4 + (this.zzxc.length * 1);
            }
            if (this.zzxb != null && this.zzxb.length > 0) {
                for (zza zza4 : this.zzxb) {
                    if (zza4 != null) {
                        zzy += zzaov.zzc(11, (zzapc) zza4);
                    }
                }
            }
            return this.zzxa ? zzy + zzaov.zzk(12, this.zzxa) : zzy;
        }
    }
}
