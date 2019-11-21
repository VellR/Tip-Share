package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import java.io.IOException;

public interface zzah {

    public static final class zza extends zzaow<zza> {
        public int level;
        public int zzum;
        public int zzun;

        public zza() {
            zzab();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (this.level == zza.level && this.zzum == zza.zzum && this.zzun == zza.zzun) {
                return (this.bib == null || this.bib.isEmpty()) ? zza.bib == null || zza.bib.isEmpty() : this.bib.equals(zza.bib);
            }
            return false;
        }

        public int hashCode() {
            return ((this.bib == null || this.bib.isEmpty()) ? 0 : this.bib.hashCode()) + ((((((((getClass().getName().hashCode() + 527) * 31) + this.level) * 31) + this.zzum) * 31) + this.zzun) * 31);
        }

        public void zza(zzaov zzaov) throws IOException {
            if (this.level != 1) {
                zzaov.zzae(1, this.level);
            }
            if (this.zzum != 0) {
                zzaov.zzae(2, this.zzum);
            }
            if (this.zzun != 0) {
                zzaov.zzae(3, this.zzun);
            }
            super.zza(zzaov);
        }

        public zza zzab() {
            this.level = 1;
            this.zzum = 0;
            this.zzun = 0;
            this.bib = null;
            this.bik = -1;
            return this;
        }

        /* renamed from: zzj */
        public zza zzb(zzaou zzaou) throws IOException {
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
                                this.level = N;
                                break;
                            default:
                                continue;
                        }
                    case 16:
                        this.zzum = zzaou.N();
                        continue;
                    case 24:
                        this.zzun = zzaou.N();
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
            int zzy = super.zzy();
            if (this.level != 1) {
                zzy += zzaov.zzag(1, this.level);
            }
            if (this.zzum != 0) {
                zzy += zzaov.zzag(2, this.zzum);
            }
            return this.zzun != 0 ? zzy + zzaov.zzag(3, this.zzun) : zzy;
        }
    }

    public static final class zzb extends zzaow<zzb> {
        private static volatile zzb[] zzuo;
        public int name;
        public int[] zzup;
        public int zzuq;
        public boolean zzur;
        public boolean zzus;

        public zzb() {
            zzad();
        }

        public static zzb[] zzac() {
            if (zzuo == null) {
                synchronized (zzapa.bij) {
                    if (zzuo == null) {
                        zzuo = new zzb[0];
                    }
                }
            }
            return zzuo;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzb = (zzb) obj;
            if (zzapa.equals(this.zzup, zzb.zzup) && this.zzuq == zzb.zzuq && this.name == zzb.name && this.zzur == zzb.zzur && this.zzus == zzb.zzus) {
                return (this.bib == null || this.bib.isEmpty()) ? zzb.bib == null || zzb.bib.isEmpty() : this.bib.equals(zzb.bib);
            }
            return false;
        }

        public int hashCode() {
            int i = 1231;
            int hashCode = ((this.zzur ? 1231 : 1237) + ((((((((getClass().getName().hashCode() + 527) * 31) + zzapa.hashCode(this.zzup)) * 31) + this.zzuq) * 31) + this.name) * 31)) * 31;
            if (!this.zzus) {
                i = 1237;
            }
            return ((this.bib == null || this.bib.isEmpty()) ? 0 : this.bib.hashCode()) + ((hashCode + i) * 31);
        }

        public void zza(zzaov zzaov) throws IOException {
            if (this.zzus) {
                zzaov.zzj(1, this.zzus);
            }
            zzaov.zzae(2, this.zzuq);
            if (this.zzup != null && this.zzup.length > 0) {
                for (int zzae : this.zzup) {
                    zzaov.zzae(3, zzae);
                }
            }
            if (this.name != 0) {
                zzaov.zzae(4, this.name);
            }
            if (this.zzur) {
                zzaov.zzj(6, this.zzur);
            }
            super.zza(zzaov);
        }

        public zzb zzad() {
            this.zzup = zzapf.bim;
            this.zzuq = 0;
            this.name = 0;
            this.zzur = false;
            this.zzus = false;
            this.bib = null;
            this.bik = -1;
            return this;
        }

        /* renamed from: zzk */
        public zzb zzb(zzaou zzaou) throws IOException {
            while (true) {
                int J = zzaou.J();
                switch (J) {
                    case 0:
                        break;
                    case 8:
                        this.zzus = zzaou.P();
                        continue;
                    case 16:
                        this.zzuq = zzaou.N();
                        continue;
                    case 24:
                        int zzc = zzapf.zzc(zzaou, 24);
                        int length = this.zzup == null ? 0 : this.zzup.length;
                        int[] iArr = new int[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzup, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = zzaou.N();
                            zzaou.J();
                            length++;
                        }
                        iArr[length] = zzaou.N();
                        this.zzup = iArr;
                        continue;
                    case 26:
                        int zzaei = zzaou.zzaei(zzaou.S());
                        int position = zzaou.getPosition();
                        int i = 0;
                        while (zzaou.X() > 0) {
                            zzaou.N();
                            i++;
                        }
                        zzaou.zzaek(position);
                        int length2 = this.zzup == null ? 0 : this.zzup.length;
                        int[] iArr2 = new int[(i + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzup, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = zzaou.N();
                            length2++;
                        }
                        this.zzup = iArr2;
                        zzaou.zzaej(zzaei);
                        continue;
                    case 32:
                        this.name = zzaou.N();
                        continue;
                    case 48:
                        this.zzur = zzaou.P();
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
            int i;
            int i2 = 0;
            int zzy = super.zzy();
            if (this.zzus) {
                zzy += zzaov.zzk(1, this.zzus);
            }
            int zzag = zzaov.zzag(2, this.zzuq) + zzy;
            if (this.zzup == null || this.zzup.length <= 0) {
                i = zzag;
            } else {
                for (int zzaeo : this.zzup) {
                    i2 += zzaov.zzaeo(zzaeo);
                }
                i = zzag + i2 + (this.zzup.length * 1);
            }
            if (this.name != 0) {
                i += zzaov.zzag(4, this.name);
            }
            return this.zzur ? i + zzaov.zzk(6, this.zzur) : i;
        }
    }

    public static final class zzc extends zzaow<zzc> {
        private static volatile zzc[] zzut;
        public String zzcb;
        public long zzuu;
        public long zzuv;
        public boolean zzuw;
        public long zzux;

        public zzc() {
            zzaf();
        }

        public static zzc[] zzae() {
            if (zzut == null) {
                synchronized (zzapa.bij) {
                    if (zzut == null) {
                        zzut = new zzc[0];
                    }
                }
            }
            return zzut;
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
            if (this.zzuu == zzc.zzuu && this.zzuv == zzc.zzuv && this.zzuw == zzc.zzuw && this.zzux == zzc.zzux) {
                return (this.bib == null || this.bib.isEmpty()) ? zzc.bib == null || zzc.bib.isEmpty() : this.bib.equals(zzc.bib);
            }
            return false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.zzuw ? 1231 : 1237) + (((((((this.zzcb == null ? 0 : this.zzcb.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + ((int) (this.zzuu ^ (this.zzuu >>> 32)))) * 31) + ((int) (this.zzuv ^ (this.zzuv >>> 32)))) * 31)) * 31) + ((int) (this.zzux ^ (this.zzux >>> 32)))) * 31;
            if (this.bib != null && !this.bib.isEmpty()) {
                i = this.bib.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzaov zzaov) throws IOException {
            if (!this.zzcb.equals("")) {
                zzaov.zzr(1, this.zzcb);
            }
            if (this.zzuu != 0) {
                zzaov.zzb(2, this.zzuu);
            }
            if (this.zzuv != 2147483647L) {
                zzaov.zzb(3, this.zzuv);
            }
            if (this.zzuw) {
                zzaov.zzj(4, this.zzuw);
            }
            if (this.zzux != 0) {
                zzaov.zzb(5, this.zzux);
            }
            super.zza(zzaov);
        }

        public zzc zzaf() {
            this.zzcb = "";
            this.zzuu = 0;
            this.zzuv = 2147483647L;
            this.zzuw = false;
            this.zzux = 0;
            this.bib = null;
            this.bik = -1;
            return this;
        }

        /* renamed from: zzl */
        public zzc zzb(zzaou zzaou) throws IOException {
            while (true) {
                int J = zzaou.J();
                switch (J) {
                    case 0:
                        break;
                    case 10:
                        this.zzcb = zzaou.readString();
                        continue;
                    case 16:
                        this.zzuu = zzaou.M();
                        continue;
                    case 24:
                        this.zzuv = zzaou.M();
                        continue;
                    case 32:
                        this.zzuw = zzaou.P();
                        continue;
                    case 40:
                        this.zzux = zzaou.M();
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
            int zzy = super.zzy();
            if (!this.zzcb.equals("")) {
                zzy += zzaov.zzs(1, this.zzcb);
            }
            if (this.zzuu != 0) {
                zzy += zzaov.zze(2, this.zzuu);
            }
            if (this.zzuv != 2147483647L) {
                zzy += zzaov.zze(3, this.zzuv);
            }
            if (this.zzuw) {
                zzy += zzaov.zzk(4, this.zzuw);
            }
            return this.zzux != 0 ? zzy + zzaov.zze(5, this.zzux) : zzy;
        }
    }

    public static final class zzd extends zzaow<zzd> {
        public com.google.android.gms.internal.zzai.zza[] zzuy;
        public com.google.android.gms.internal.zzai.zza[] zzuz;
        public zzc[] zzva;

        public zzd() {
            zzag();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            zzd zzd = (zzd) obj;
            if (!zzapa.equals((Object[]) this.zzuy, (Object[]) zzd.zzuy) || !zzapa.equals((Object[]) this.zzuz, (Object[]) zzd.zzuz) || !zzapa.equals((Object[]) this.zzva, (Object[]) zzd.zzva)) {
                return false;
            }
            return (this.bib == null || this.bib.isEmpty()) ? zzd.bib == null || zzd.bib.isEmpty() : this.bib.equals(zzd.bib);
        }

        public int hashCode() {
            return ((this.bib == null || this.bib.isEmpty()) ? 0 : this.bib.hashCode()) + ((((((((getClass().getName().hashCode() + 527) * 31) + zzapa.hashCode((Object[]) this.zzuy)) * 31) + zzapa.hashCode((Object[]) this.zzuz)) * 31) + zzapa.hashCode((Object[]) this.zzva)) * 31);
        }

        public void zza(zzaov zzaov) throws IOException {
            if (this.zzuy != null && this.zzuy.length > 0) {
                for (com.google.android.gms.internal.zzai.zza zza : this.zzuy) {
                    if (zza != null) {
                        zzaov.zza(1, (zzapc) zza);
                    }
                }
            }
            if (this.zzuz != null && this.zzuz.length > 0) {
                for (com.google.android.gms.internal.zzai.zza zza2 : this.zzuz) {
                    if (zza2 != null) {
                        zzaov.zza(2, (zzapc) zza2);
                    }
                }
            }
            if (this.zzva != null && this.zzva.length > 0) {
                for (zzc zzc : this.zzva) {
                    if (zzc != null) {
                        zzaov.zza(3, (zzapc) zzc);
                    }
                }
            }
            super.zza(zzaov);
        }

        public zzd zzag() {
            this.zzuy = com.google.android.gms.internal.zzai.zza.zzaq();
            this.zzuz = com.google.android.gms.internal.zzai.zza.zzaq();
            this.zzva = zzc.zzae();
            this.bib = null;
            this.bik = -1;
            return this;
        }

        /* renamed from: zzm */
        public zzd zzb(zzaou zzaou) throws IOException {
            while (true) {
                int J = zzaou.J();
                switch (J) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzapf.zzc(zzaou, 10);
                        int length = this.zzuy == null ? 0 : this.zzuy.length;
                        com.google.android.gms.internal.zzai.zza[] zzaArr = new com.google.android.gms.internal.zzai.zza[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzuy, 0, zzaArr, 0, length);
                        }
                        while (length < zzaArr.length - 1) {
                            zzaArr[length] = new com.google.android.gms.internal.zzai.zza();
                            zzaou.zza(zzaArr[length]);
                            zzaou.J();
                            length++;
                        }
                        zzaArr[length] = new com.google.android.gms.internal.zzai.zza();
                        zzaou.zza(zzaArr[length]);
                        this.zzuy = zzaArr;
                        continue;
                    case 18:
                        int zzc2 = zzapf.zzc(zzaou, 18);
                        int length2 = this.zzuz == null ? 0 : this.zzuz.length;
                        com.google.android.gms.internal.zzai.zza[] zzaArr2 = new com.google.android.gms.internal.zzai.zza[(zzc2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzuz, 0, zzaArr2, 0, length2);
                        }
                        while (length2 < zzaArr2.length - 1) {
                            zzaArr2[length2] = new com.google.android.gms.internal.zzai.zza();
                            zzaou.zza(zzaArr2[length2]);
                            zzaou.J();
                            length2++;
                        }
                        zzaArr2[length2] = new com.google.android.gms.internal.zzai.zza();
                        zzaou.zza(zzaArr2[length2]);
                        this.zzuz = zzaArr2;
                        continue;
                    case 26:
                        int zzc3 = zzapf.zzc(zzaou, 26);
                        int length3 = this.zzva == null ? 0 : this.zzva.length;
                        zzc[] zzcArr = new zzc[(zzc3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzva, 0, zzcArr, 0, length3);
                        }
                        while (length3 < zzcArr.length - 1) {
                            zzcArr[length3] = new zzc();
                            zzaou.zza(zzcArr[length3]);
                            zzaou.J();
                            length3++;
                        }
                        zzcArr[length3] = new zzc();
                        zzaou.zza(zzcArr[length3]);
                        this.zzva = zzcArr;
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
            int zzy = super.zzy();
            if (this.zzuy != null && this.zzuy.length > 0) {
                int i = zzy;
                for (com.google.android.gms.internal.zzai.zza zza : this.zzuy) {
                    if (zza != null) {
                        i += zzaov.zzc(1, (zzapc) zza);
                    }
                }
                zzy = i;
            }
            if (this.zzuz != null && this.zzuz.length > 0) {
                int i2 = zzy;
                for (com.google.android.gms.internal.zzai.zza zza2 : this.zzuz) {
                    if (zza2 != null) {
                        i2 += zzaov.zzc(2, (zzapc) zza2);
                    }
                }
                zzy = i2;
            }
            if (this.zzva != null && this.zzva.length > 0) {
                for (zzc zzc : this.zzva) {
                    if (zzc != null) {
                        zzy += zzaov.zzc(3, (zzapc) zzc);
                    }
                }
            }
            return zzy;
        }
    }

    public static final class zze extends zzaow<zze> {
        private static volatile zze[] zzvb;
        public int key;
        public int value;

        public zze() {
            zzai();
        }

        public static zze[] zzah() {
            if (zzvb == null) {
                synchronized (zzapa.bij) {
                    if (zzvb == null) {
                        zzvb = new zze[0];
                    }
                }
            }
            return zzvb;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze zze = (zze) obj;
            if (this.key == zze.key && this.value == zze.value) {
                return (this.bib == null || this.bib.isEmpty()) ? zze.bib == null || zze.bib.isEmpty() : this.bib.equals(zze.bib);
            }
            return false;
        }

        public int hashCode() {
            return ((this.bib == null || this.bib.isEmpty()) ? 0 : this.bib.hashCode()) + ((((((getClass().getName().hashCode() + 527) * 31) + this.key) * 31) + this.value) * 31);
        }

        public void zza(zzaov zzaov) throws IOException {
            zzaov.zzae(1, this.key);
            zzaov.zzae(2, this.value);
            super.zza(zzaov);
        }

        public zze zzai() {
            this.key = 0;
            this.value = 0;
            this.bib = null;
            this.bik = -1;
            return this;
        }

        /* renamed from: zzn */
        public zze zzb(zzaou zzaou) throws IOException {
            while (true) {
                int J = zzaou.J();
                switch (J) {
                    case 0:
                        break;
                    case 8:
                        this.key = zzaou.N();
                        continue;
                    case 16:
                        this.value = zzaou.N();
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
            return super.zzy() + zzaov.zzag(1, this.key) + zzaov.zzag(2, this.value);
        }
    }

    public static final class zzf extends zzaow<zzf> {
        public String version;
        public String[] zzvc;
        public String[] zzvd;
        public com.google.android.gms.internal.zzai.zza[] zzve;
        public zze[] zzvf;
        public zzb[] zzvg;
        public zzb[] zzvh;
        public zzb[] zzvi;
        public zzg[] zzvj;
        public String zzvk;
        public String zzvl;
        public String zzvm;
        public zza zzvn;
        public float zzvo;
        public boolean zzvp;
        public String[] zzvq;
        public int zzvr;

        public zzf() {
            zzaj();
        }

        public static zzf zze(byte[] bArr) throws zzapb {
            return (zzf) zzapc.zza(new zzf(), bArr);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzf)) {
                return false;
            }
            zzf zzf = (zzf) obj;
            if (!zzapa.equals((Object[]) this.zzvc, (Object[]) zzf.zzvc) || !zzapa.equals((Object[]) this.zzvd, (Object[]) zzf.zzvd) || !zzapa.equals((Object[]) this.zzve, (Object[]) zzf.zzve) || !zzapa.equals((Object[]) this.zzvf, (Object[]) zzf.zzvf) || !zzapa.equals((Object[]) this.zzvg, (Object[]) zzf.zzvg) || !zzapa.equals((Object[]) this.zzvh, (Object[]) zzf.zzvh) || !zzapa.equals((Object[]) this.zzvi, (Object[]) zzf.zzvi) || !zzapa.equals((Object[]) this.zzvj, (Object[]) zzf.zzvj)) {
                return false;
            }
            if (this.zzvk == null) {
                if (zzf.zzvk != null) {
                    return false;
                }
            } else if (!this.zzvk.equals(zzf.zzvk)) {
                return false;
            }
            if (this.zzvl == null) {
                if (zzf.zzvl != null) {
                    return false;
                }
            } else if (!this.zzvl.equals(zzf.zzvl)) {
                return false;
            }
            if (this.zzvm == null) {
                if (zzf.zzvm != null) {
                    return false;
                }
            } else if (!this.zzvm.equals(zzf.zzvm)) {
                return false;
            }
            if (this.version == null) {
                if (zzf.version != null) {
                    return false;
                }
            } else if (!this.version.equals(zzf.version)) {
                return false;
            }
            if (this.zzvn == null) {
                if (zzf.zzvn != null) {
                    return false;
                }
            } else if (!this.zzvn.equals(zzf.zzvn)) {
                return false;
            }
            if (Float.floatToIntBits(this.zzvo) == Float.floatToIntBits(zzf.zzvo) && this.zzvp == zzf.zzvp && zzapa.equals((Object[]) this.zzvq, (Object[]) zzf.zzvq) && this.zzvr == zzf.zzvr) {
                return (this.bib == null || this.bib.isEmpty()) ? zzf.bib == null || zzf.bib.isEmpty() : this.bib.equals(zzf.bib);
            }
            return false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((((this.zzvp ? 1231 : 1237) + (((((this.zzvn == null ? 0 : this.zzvn.hashCode()) + (((this.version == null ? 0 : this.version.hashCode()) + (((this.zzvm == null ? 0 : this.zzvm.hashCode()) + (((this.zzvl == null ? 0 : this.zzvl.hashCode()) + (((this.zzvk == null ? 0 : this.zzvk.hashCode()) + ((((((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzapa.hashCode((Object[]) this.zzvc)) * 31) + zzapa.hashCode((Object[]) this.zzvd)) * 31) + zzapa.hashCode((Object[]) this.zzve)) * 31) + zzapa.hashCode((Object[]) this.zzvf)) * 31) + zzapa.hashCode((Object[]) this.zzvg)) * 31) + zzapa.hashCode((Object[]) this.zzvh)) * 31) + zzapa.hashCode((Object[]) this.zzvi)) * 31) + zzapa.hashCode((Object[]) this.zzvj)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + Float.floatToIntBits(this.zzvo)) * 31)) * 31) + zzapa.hashCode((Object[]) this.zzvq)) * 31) + this.zzvr) * 31;
            if (this.bib != null && !this.bib.isEmpty()) {
                i = this.bib.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzaov zzaov) throws IOException {
            if (this.zzvd != null && this.zzvd.length > 0) {
                for (String str : this.zzvd) {
                    if (str != null) {
                        zzaov.zzr(1, str);
                    }
                }
            }
            if (this.zzve != null && this.zzve.length > 0) {
                for (com.google.android.gms.internal.zzai.zza zza : this.zzve) {
                    if (zza != null) {
                        zzaov.zza(2, (zzapc) zza);
                    }
                }
            }
            if (this.zzvf != null && this.zzvf.length > 0) {
                for (zze zze : this.zzvf) {
                    if (zze != null) {
                        zzaov.zza(3, (zzapc) zze);
                    }
                }
            }
            if (this.zzvg != null && this.zzvg.length > 0) {
                for (zzb zzb : this.zzvg) {
                    if (zzb != null) {
                        zzaov.zza(4, (zzapc) zzb);
                    }
                }
            }
            if (this.zzvh != null && this.zzvh.length > 0) {
                for (zzb zzb2 : this.zzvh) {
                    if (zzb2 != null) {
                        zzaov.zza(5, (zzapc) zzb2);
                    }
                }
            }
            if (this.zzvi != null && this.zzvi.length > 0) {
                for (zzb zzb3 : this.zzvi) {
                    if (zzb3 != null) {
                        zzaov.zza(6, (zzapc) zzb3);
                    }
                }
            }
            if (this.zzvj != null && this.zzvj.length > 0) {
                for (zzg zzg : this.zzvj) {
                    if (zzg != null) {
                        zzaov.zza(7, (zzapc) zzg);
                    }
                }
            }
            if (!this.zzvk.equals("")) {
                zzaov.zzr(9, this.zzvk);
            }
            if (!this.zzvl.equals("")) {
                zzaov.zzr(10, this.zzvl);
            }
            if (!this.zzvm.equals("0")) {
                zzaov.zzr(12, this.zzvm);
            }
            if (!this.version.equals("")) {
                zzaov.zzr(13, this.version);
            }
            if (this.zzvn != null) {
                zzaov.zza(14, (zzapc) this.zzvn);
            }
            if (Float.floatToIntBits(this.zzvo) != Float.floatToIntBits(0.0f)) {
                zzaov.zzc(15, this.zzvo);
            }
            if (this.zzvq != null && this.zzvq.length > 0) {
                for (String str2 : this.zzvq) {
                    if (str2 != null) {
                        zzaov.zzr(16, str2);
                    }
                }
            }
            if (this.zzvr != 0) {
                zzaov.zzae(17, this.zzvr);
            }
            if (this.zzvp) {
                zzaov.zzj(18, this.zzvp);
            }
            if (this.zzvc != null && this.zzvc.length > 0) {
                for (String str3 : this.zzvc) {
                    if (str3 != null) {
                        zzaov.zzr(19, str3);
                    }
                }
            }
            super.zza(zzaov);
        }

        public zzf zzaj() {
            this.zzvc = zzapf.bir;
            this.zzvd = zzapf.bir;
            this.zzve = com.google.android.gms.internal.zzai.zza.zzaq();
            this.zzvf = zze.zzah();
            this.zzvg = zzb.zzac();
            this.zzvh = zzb.zzac();
            this.zzvi = zzb.zzac();
            this.zzvj = zzg.zzak();
            this.zzvk = "";
            this.zzvl = "";
            this.zzvm = "0";
            this.version = "";
            this.zzvn = null;
            this.zzvo = 0.0f;
            this.zzvp = false;
            this.zzvq = zzapf.bir;
            this.zzvr = 0;
            this.bib = null;
            this.bik = -1;
            return this;
        }

        /* renamed from: zzo */
        public zzf zzb(zzaou zzaou) throws IOException {
            while (true) {
                int J = zzaou.J();
                switch (J) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzapf.zzc(zzaou, 10);
                        int length = this.zzvd == null ? 0 : this.zzvd.length;
                        String[] strArr = new String[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzvd, 0, strArr, 0, length);
                        }
                        while (length < strArr.length - 1) {
                            strArr[length] = zzaou.readString();
                            zzaou.J();
                            length++;
                        }
                        strArr[length] = zzaou.readString();
                        this.zzvd = strArr;
                        continue;
                    case 18:
                        int zzc2 = zzapf.zzc(zzaou, 18);
                        int length2 = this.zzve == null ? 0 : this.zzve.length;
                        com.google.android.gms.internal.zzai.zza[] zzaArr = new com.google.android.gms.internal.zzai.zza[(zzc2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzve, 0, zzaArr, 0, length2);
                        }
                        while (length2 < zzaArr.length - 1) {
                            zzaArr[length2] = new com.google.android.gms.internal.zzai.zza();
                            zzaou.zza(zzaArr[length2]);
                            zzaou.J();
                            length2++;
                        }
                        zzaArr[length2] = new com.google.android.gms.internal.zzai.zza();
                        zzaou.zza(zzaArr[length2]);
                        this.zzve = zzaArr;
                        continue;
                    case 26:
                        int zzc3 = zzapf.zzc(zzaou, 26);
                        int length3 = this.zzvf == null ? 0 : this.zzvf.length;
                        zze[] zzeArr = new zze[(zzc3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzvf, 0, zzeArr, 0, length3);
                        }
                        while (length3 < zzeArr.length - 1) {
                            zzeArr[length3] = new zze();
                            zzaou.zza(zzeArr[length3]);
                            zzaou.J();
                            length3++;
                        }
                        zzeArr[length3] = new zze();
                        zzaou.zza(zzeArr[length3]);
                        this.zzvf = zzeArr;
                        continue;
                    case 34:
                        int zzc4 = zzapf.zzc(zzaou, 34);
                        int length4 = this.zzvg == null ? 0 : this.zzvg.length;
                        zzb[] zzbArr = new zzb[(zzc4 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.zzvg, 0, zzbArr, 0, length4);
                        }
                        while (length4 < zzbArr.length - 1) {
                            zzbArr[length4] = new zzb();
                            zzaou.zza(zzbArr[length4]);
                            zzaou.J();
                            length4++;
                        }
                        zzbArr[length4] = new zzb();
                        zzaou.zza(zzbArr[length4]);
                        this.zzvg = zzbArr;
                        continue;
                    case 42:
                        int zzc5 = zzapf.zzc(zzaou, 42);
                        int length5 = this.zzvh == null ? 0 : this.zzvh.length;
                        zzb[] zzbArr2 = new zzb[(zzc5 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.zzvh, 0, zzbArr2, 0, length5);
                        }
                        while (length5 < zzbArr2.length - 1) {
                            zzbArr2[length5] = new zzb();
                            zzaou.zza(zzbArr2[length5]);
                            zzaou.J();
                            length5++;
                        }
                        zzbArr2[length5] = new zzb();
                        zzaou.zza(zzbArr2[length5]);
                        this.zzvh = zzbArr2;
                        continue;
                    case 50:
                        int zzc6 = zzapf.zzc(zzaou, 50);
                        int length6 = this.zzvi == null ? 0 : this.zzvi.length;
                        zzb[] zzbArr3 = new zzb[(zzc6 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.zzvi, 0, zzbArr3, 0, length6);
                        }
                        while (length6 < zzbArr3.length - 1) {
                            zzbArr3[length6] = new zzb();
                            zzaou.zza(zzbArr3[length6]);
                            zzaou.J();
                            length6++;
                        }
                        zzbArr3[length6] = new zzb();
                        zzaou.zza(zzbArr3[length6]);
                        this.zzvi = zzbArr3;
                        continue;
                    case 58:
                        int zzc7 = zzapf.zzc(zzaou, 58);
                        int length7 = this.zzvj == null ? 0 : this.zzvj.length;
                        zzg[] zzgArr = new zzg[(zzc7 + length7)];
                        if (length7 != 0) {
                            System.arraycopy(this.zzvj, 0, zzgArr, 0, length7);
                        }
                        while (length7 < zzgArr.length - 1) {
                            zzgArr[length7] = new zzg();
                            zzaou.zza(zzgArr[length7]);
                            zzaou.J();
                            length7++;
                        }
                        zzgArr[length7] = new zzg();
                        zzaou.zza(zzgArr[length7]);
                        this.zzvj = zzgArr;
                        continue;
                    case 74:
                        this.zzvk = zzaou.readString();
                        continue;
                    case 82:
                        this.zzvl = zzaou.readString();
                        continue;
                    case 98:
                        this.zzvm = zzaou.readString();
                        continue;
                    case 106:
                        this.version = zzaou.readString();
                        continue;
                    case 114:
                        if (this.zzvn == null) {
                            this.zzvn = new zza();
                        }
                        zzaou.zza(this.zzvn);
                        continue;
                    case 125:
                        this.zzvo = zzaou.readFloat();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                        int zzc8 = zzapf.zzc(zzaou, TransportMediator.KEYCODE_MEDIA_RECORD);
                        int length8 = this.zzvq == null ? 0 : this.zzvq.length;
                        String[] strArr2 = new String[(zzc8 + length8)];
                        if (length8 != 0) {
                            System.arraycopy(this.zzvq, 0, strArr2, 0, length8);
                        }
                        while (length8 < strArr2.length - 1) {
                            strArr2[length8] = zzaou.readString();
                            zzaou.J();
                            length8++;
                        }
                        strArr2[length8] = zzaou.readString();
                        this.zzvq = strArr2;
                        continue;
                    case 136:
                        this.zzvr = zzaou.N();
                        continue;
                    case 144:
                        this.zzvp = zzaou.P();
                        continue;
                    case 154:
                        int zzc9 = zzapf.zzc(zzaou, 154);
                        int length9 = this.zzvc == null ? 0 : this.zzvc.length;
                        String[] strArr3 = new String[(zzc9 + length9)];
                        if (length9 != 0) {
                            System.arraycopy(this.zzvc, 0, strArr3, 0, length9);
                        }
                        while (length9 < strArr3.length - 1) {
                            strArr3[length9] = zzaou.readString();
                            zzaou.J();
                            length9++;
                        }
                        strArr3[length9] = zzaou.readString();
                        this.zzvc = strArr3;
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
            int i;
            int zzy = super.zzy();
            if (this.zzvd == null || this.zzvd.length <= 0) {
                i = zzy;
            } else {
                int i2 = 0;
                int i3 = 0;
                for (String str : this.zzvd) {
                    if (str != null) {
                        i3++;
                        i2 += zzaov.zztg(str);
                    }
                }
                i = zzy + i2 + (i3 * 1);
            }
            if (this.zzve != null && this.zzve.length > 0) {
                int i4 = i;
                for (com.google.android.gms.internal.zzai.zza zza : this.zzve) {
                    if (zza != null) {
                        i4 += zzaov.zzc(2, (zzapc) zza);
                    }
                }
                i = i4;
            }
            if (this.zzvf != null && this.zzvf.length > 0) {
                int i5 = i;
                for (zze zze : this.zzvf) {
                    if (zze != null) {
                        i5 += zzaov.zzc(3, (zzapc) zze);
                    }
                }
                i = i5;
            }
            if (this.zzvg != null && this.zzvg.length > 0) {
                int i6 = i;
                for (zzb zzb : this.zzvg) {
                    if (zzb != null) {
                        i6 += zzaov.zzc(4, (zzapc) zzb);
                    }
                }
                i = i6;
            }
            if (this.zzvh != null && this.zzvh.length > 0) {
                int i7 = i;
                for (zzb zzb2 : this.zzvh) {
                    if (zzb2 != null) {
                        i7 += zzaov.zzc(5, (zzapc) zzb2);
                    }
                }
                i = i7;
            }
            if (this.zzvi != null && this.zzvi.length > 0) {
                int i8 = i;
                for (zzb zzb3 : this.zzvi) {
                    if (zzb3 != null) {
                        i8 += zzaov.zzc(6, (zzapc) zzb3);
                    }
                }
                i = i8;
            }
            if (this.zzvj != null && this.zzvj.length > 0) {
                int i9 = i;
                for (zzg zzg : this.zzvj) {
                    if (zzg != null) {
                        i9 += zzaov.zzc(7, (zzapc) zzg);
                    }
                }
                i = i9;
            }
            if (!this.zzvk.equals("")) {
                i += zzaov.zzs(9, this.zzvk);
            }
            if (!this.zzvl.equals("")) {
                i += zzaov.zzs(10, this.zzvl);
            }
            if (!this.zzvm.equals("0")) {
                i += zzaov.zzs(12, this.zzvm);
            }
            if (!this.version.equals("")) {
                i += zzaov.zzs(13, this.version);
            }
            if (this.zzvn != null) {
                i += zzaov.zzc(14, (zzapc) this.zzvn);
            }
            if (Float.floatToIntBits(this.zzvo) != Float.floatToIntBits(0.0f)) {
                i += zzaov.zzd(15, this.zzvo);
            }
            if (this.zzvq != null && this.zzvq.length > 0) {
                int i10 = 0;
                int i11 = 0;
                for (String str2 : this.zzvq) {
                    if (str2 != null) {
                        i11++;
                        i10 += zzaov.zztg(str2);
                    }
                }
                i = i + i10 + (i11 * 2);
            }
            if (this.zzvr != 0) {
                i += zzaov.zzag(17, this.zzvr);
            }
            if (this.zzvp) {
                i += zzaov.zzk(18, this.zzvp);
            }
            if (this.zzvc == null || this.zzvc.length <= 0) {
                return i;
            }
            int i12 = 0;
            int i13 = 0;
            for (String str3 : this.zzvc) {
                if (str3 != null) {
                    i13++;
                    i12 += zzaov.zztg(str3);
                }
            }
            return i + i12 + (i13 * 2);
        }
    }

    public static final class zzg extends zzaow<zzg> {
        private static volatile zzg[] zzvs;
        public int[] zzvt;
        public int[] zzvu;
        public int[] zzvv;
        public int[] zzvw;
        public int[] zzvx;
        public int[] zzvy;
        public int[] zzvz;
        public int[] zzwa;
        public int[] zzwb;
        public int[] zzwc;

        public zzg() {
            zzal();
        }

        public static zzg[] zzak() {
            if (zzvs == null) {
                synchronized (zzapa.bij) {
                    if (zzvs == null) {
                        zzvs = new zzg[0];
                    }
                }
            }
            return zzvs;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzg)) {
                return false;
            }
            zzg zzg = (zzg) obj;
            if (!zzapa.equals(this.zzvt, zzg.zzvt) || !zzapa.equals(this.zzvu, zzg.zzvu) || !zzapa.equals(this.zzvv, zzg.zzvv) || !zzapa.equals(this.zzvw, zzg.zzvw) || !zzapa.equals(this.zzvx, zzg.zzvx) || !zzapa.equals(this.zzvy, zzg.zzvy) || !zzapa.equals(this.zzvz, zzg.zzvz) || !zzapa.equals(this.zzwa, zzg.zzwa) || !zzapa.equals(this.zzwb, zzg.zzwb) || !zzapa.equals(this.zzwc, zzg.zzwc)) {
                return false;
            }
            return (this.bib == null || this.bib.isEmpty()) ? zzg.bib == null || zzg.bib.isEmpty() : this.bib.equals(zzg.bib);
        }

        public int hashCode() {
            return ((this.bib == null || this.bib.isEmpty()) ? 0 : this.bib.hashCode()) + ((((((((((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzapa.hashCode(this.zzvt)) * 31) + zzapa.hashCode(this.zzvu)) * 31) + zzapa.hashCode(this.zzvv)) * 31) + zzapa.hashCode(this.zzvw)) * 31) + zzapa.hashCode(this.zzvx)) * 31) + zzapa.hashCode(this.zzvy)) * 31) + zzapa.hashCode(this.zzvz)) * 31) + zzapa.hashCode(this.zzwa)) * 31) + zzapa.hashCode(this.zzwb)) * 31) + zzapa.hashCode(this.zzwc)) * 31);
        }

        public void zza(zzaov zzaov) throws IOException {
            if (this.zzvt != null && this.zzvt.length > 0) {
                for (int zzae : this.zzvt) {
                    zzaov.zzae(1, zzae);
                }
            }
            if (this.zzvu != null && this.zzvu.length > 0) {
                for (int zzae2 : this.zzvu) {
                    zzaov.zzae(2, zzae2);
                }
            }
            if (this.zzvv != null && this.zzvv.length > 0) {
                for (int zzae3 : this.zzvv) {
                    zzaov.zzae(3, zzae3);
                }
            }
            if (this.zzvw != null && this.zzvw.length > 0) {
                for (int zzae4 : this.zzvw) {
                    zzaov.zzae(4, zzae4);
                }
            }
            if (this.zzvx != null && this.zzvx.length > 0) {
                for (int zzae5 : this.zzvx) {
                    zzaov.zzae(5, zzae5);
                }
            }
            if (this.zzvy != null && this.zzvy.length > 0) {
                for (int zzae6 : this.zzvy) {
                    zzaov.zzae(6, zzae6);
                }
            }
            if (this.zzvz != null && this.zzvz.length > 0) {
                for (int zzae7 : this.zzvz) {
                    zzaov.zzae(7, zzae7);
                }
            }
            if (this.zzwa != null && this.zzwa.length > 0) {
                for (int zzae8 : this.zzwa) {
                    zzaov.zzae(8, zzae8);
                }
            }
            if (this.zzwb != null && this.zzwb.length > 0) {
                for (int zzae9 : this.zzwb) {
                    zzaov.zzae(9, zzae9);
                }
            }
            if (this.zzwc != null && this.zzwc.length > 0) {
                for (int zzae10 : this.zzwc) {
                    zzaov.zzae(10, zzae10);
                }
            }
            super.zza(zzaov);
        }

        public zzg zzal() {
            this.zzvt = zzapf.bim;
            this.zzvu = zzapf.bim;
            this.zzvv = zzapf.bim;
            this.zzvw = zzapf.bim;
            this.zzvx = zzapf.bim;
            this.zzvy = zzapf.bim;
            this.zzvz = zzapf.bim;
            this.zzwa = zzapf.bim;
            this.zzwb = zzapf.bim;
            this.zzwc = zzapf.bim;
            this.bib = null;
            this.bik = -1;
            return this;
        }

        /* renamed from: zzp */
        public zzg zzb(zzaou zzaou) throws IOException {
            while (true) {
                int J = zzaou.J();
                switch (J) {
                    case 0:
                        break;
                    case 8:
                        int zzc = zzapf.zzc(zzaou, 8);
                        int length = this.zzvt == null ? 0 : this.zzvt.length;
                        int[] iArr = new int[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzvt, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = zzaou.N();
                            zzaou.J();
                            length++;
                        }
                        iArr[length] = zzaou.N();
                        this.zzvt = iArr;
                        continue;
                    case 10:
                        int zzaei = zzaou.zzaei(zzaou.S());
                        int position = zzaou.getPosition();
                        int i = 0;
                        while (zzaou.X() > 0) {
                            zzaou.N();
                            i++;
                        }
                        zzaou.zzaek(position);
                        int length2 = this.zzvt == null ? 0 : this.zzvt.length;
                        int[] iArr2 = new int[(i + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzvt, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = zzaou.N();
                            length2++;
                        }
                        this.zzvt = iArr2;
                        zzaou.zzaej(zzaei);
                        continue;
                    case 16:
                        int zzc2 = zzapf.zzc(zzaou, 16);
                        int length3 = this.zzvu == null ? 0 : this.zzvu.length;
                        int[] iArr3 = new int[(zzc2 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzvu, 0, iArr3, 0, length3);
                        }
                        while (length3 < iArr3.length - 1) {
                            iArr3[length3] = zzaou.N();
                            zzaou.J();
                            length3++;
                        }
                        iArr3[length3] = zzaou.N();
                        this.zzvu = iArr3;
                        continue;
                    case 18:
                        int zzaei2 = zzaou.zzaei(zzaou.S());
                        int position2 = zzaou.getPosition();
                        int i2 = 0;
                        while (zzaou.X() > 0) {
                            zzaou.N();
                            i2++;
                        }
                        zzaou.zzaek(position2);
                        int length4 = this.zzvu == null ? 0 : this.zzvu.length;
                        int[] iArr4 = new int[(i2 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.zzvu, 0, iArr4, 0, length4);
                        }
                        while (length4 < iArr4.length) {
                            iArr4[length4] = zzaou.N();
                            length4++;
                        }
                        this.zzvu = iArr4;
                        zzaou.zzaej(zzaei2);
                        continue;
                    case 24:
                        int zzc3 = zzapf.zzc(zzaou, 24);
                        int length5 = this.zzvv == null ? 0 : this.zzvv.length;
                        int[] iArr5 = new int[(zzc3 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.zzvv, 0, iArr5, 0, length5);
                        }
                        while (length5 < iArr5.length - 1) {
                            iArr5[length5] = zzaou.N();
                            zzaou.J();
                            length5++;
                        }
                        iArr5[length5] = zzaou.N();
                        this.zzvv = iArr5;
                        continue;
                    case 26:
                        int zzaei3 = zzaou.zzaei(zzaou.S());
                        int position3 = zzaou.getPosition();
                        int i3 = 0;
                        while (zzaou.X() > 0) {
                            zzaou.N();
                            i3++;
                        }
                        zzaou.zzaek(position3);
                        int length6 = this.zzvv == null ? 0 : this.zzvv.length;
                        int[] iArr6 = new int[(i3 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.zzvv, 0, iArr6, 0, length6);
                        }
                        while (length6 < iArr6.length) {
                            iArr6[length6] = zzaou.N();
                            length6++;
                        }
                        this.zzvv = iArr6;
                        zzaou.zzaej(zzaei3);
                        continue;
                    case 32:
                        int zzc4 = zzapf.zzc(zzaou, 32);
                        int length7 = this.zzvw == null ? 0 : this.zzvw.length;
                        int[] iArr7 = new int[(zzc4 + length7)];
                        if (length7 != 0) {
                            System.arraycopy(this.zzvw, 0, iArr7, 0, length7);
                        }
                        while (length7 < iArr7.length - 1) {
                            iArr7[length7] = zzaou.N();
                            zzaou.J();
                            length7++;
                        }
                        iArr7[length7] = zzaou.N();
                        this.zzvw = iArr7;
                        continue;
                    case 34:
                        int zzaei4 = zzaou.zzaei(zzaou.S());
                        int position4 = zzaou.getPosition();
                        int i4 = 0;
                        while (zzaou.X() > 0) {
                            zzaou.N();
                            i4++;
                        }
                        zzaou.zzaek(position4);
                        int length8 = this.zzvw == null ? 0 : this.zzvw.length;
                        int[] iArr8 = new int[(i4 + length8)];
                        if (length8 != 0) {
                            System.arraycopy(this.zzvw, 0, iArr8, 0, length8);
                        }
                        while (length8 < iArr8.length) {
                            iArr8[length8] = zzaou.N();
                            length8++;
                        }
                        this.zzvw = iArr8;
                        zzaou.zzaej(zzaei4);
                        continue;
                    case 40:
                        int zzc5 = zzapf.zzc(zzaou, 40);
                        int length9 = this.zzvx == null ? 0 : this.zzvx.length;
                        int[] iArr9 = new int[(zzc5 + length9)];
                        if (length9 != 0) {
                            System.arraycopy(this.zzvx, 0, iArr9, 0, length9);
                        }
                        while (length9 < iArr9.length - 1) {
                            iArr9[length9] = zzaou.N();
                            zzaou.J();
                            length9++;
                        }
                        iArr9[length9] = zzaou.N();
                        this.zzvx = iArr9;
                        continue;
                    case 42:
                        int zzaei5 = zzaou.zzaei(zzaou.S());
                        int position5 = zzaou.getPosition();
                        int i5 = 0;
                        while (zzaou.X() > 0) {
                            zzaou.N();
                            i5++;
                        }
                        zzaou.zzaek(position5);
                        int length10 = this.zzvx == null ? 0 : this.zzvx.length;
                        int[] iArr10 = new int[(i5 + length10)];
                        if (length10 != 0) {
                            System.arraycopy(this.zzvx, 0, iArr10, 0, length10);
                        }
                        while (length10 < iArr10.length) {
                            iArr10[length10] = zzaou.N();
                            length10++;
                        }
                        this.zzvx = iArr10;
                        zzaou.zzaej(zzaei5);
                        continue;
                    case 48:
                        int zzc6 = zzapf.zzc(zzaou, 48);
                        int length11 = this.zzvy == null ? 0 : this.zzvy.length;
                        int[] iArr11 = new int[(zzc6 + length11)];
                        if (length11 != 0) {
                            System.arraycopy(this.zzvy, 0, iArr11, 0, length11);
                        }
                        while (length11 < iArr11.length - 1) {
                            iArr11[length11] = zzaou.N();
                            zzaou.J();
                            length11++;
                        }
                        iArr11[length11] = zzaou.N();
                        this.zzvy = iArr11;
                        continue;
                    case 50:
                        int zzaei6 = zzaou.zzaei(zzaou.S());
                        int position6 = zzaou.getPosition();
                        int i6 = 0;
                        while (zzaou.X() > 0) {
                            zzaou.N();
                            i6++;
                        }
                        zzaou.zzaek(position6);
                        int length12 = this.zzvy == null ? 0 : this.zzvy.length;
                        int[] iArr12 = new int[(i6 + length12)];
                        if (length12 != 0) {
                            System.arraycopy(this.zzvy, 0, iArr12, 0, length12);
                        }
                        while (length12 < iArr12.length) {
                            iArr12[length12] = zzaou.N();
                            length12++;
                        }
                        this.zzvy = iArr12;
                        zzaou.zzaej(zzaei6);
                        continue;
                    case 56:
                        int zzc7 = zzapf.zzc(zzaou, 56);
                        int length13 = this.zzvz == null ? 0 : this.zzvz.length;
                        int[] iArr13 = new int[(zzc7 + length13)];
                        if (length13 != 0) {
                            System.arraycopy(this.zzvz, 0, iArr13, 0, length13);
                        }
                        while (length13 < iArr13.length - 1) {
                            iArr13[length13] = zzaou.N();
                            zzaou.J();
                            length13++;
                        }
                        iArr13[length13] = zzaou.N();
                        this.zzvz = iArr13;
                        continue;
                    case 58:
                        int zzaei7 = zzaou.zzaei(zzaou.S());
                        int position7 = zzaou.getPosition();
                        int i7 = 0;
                        while (zzaou.X() > 0) {
                            zzaou.N();
                            i7++;
                        }
                        zzaou.zzaek(position7);
                        int length14 = this.zzvz == null ? 0 : this.zzvz.length;
                        int[] iArr14 = new int[(i7 + length14)];
                        if (length14 != 0) {
                            System.arraycopy(this.zzvz, 0, iArr14, 0, length14);
                        }
                        while (length14 < iArr14.length) {
                            iArr14[length14] = zzaou.N();
                            length14++;
                        }
                        this.zzvz = iArr14;
                        zzaou.zzaej(zzaei7);
                        continue;
                    case 64:
                        int zzc8 = zzapf.zzc(zzaou, 64);
                        int length15 = this.zzwa == null ? 0 : this.zzwa.length;
                        int[] iArr15 = new int[(zzc8 + length15)];
                        if (length15 != 0) {
                            System.arraycopy(this.zzwa, 0, iArr15, 0, length15);
                        }
                        while (length15 < iArr15.length - 1) {
                            iArr15[length15] = zzaou.N();
                            zzaou.J();
                            length15++;
                        }
                        iArr15[length15] = zzaou.N();
                        this.zzwa = iArr15;
                        continue;
                    case 66:
                        int zzaei8 = zzaou.zzaei(zzaou.S());
                        int position8 = zzaou.getPosition();
                        int i8 = 0;
                        while (zzaou.X() > 0) {
                            zzaou.N();
                            i8++;
                        }
                        zzaou.zzaek(position8);
                        int length16 = this.zzwa == null ? 0 : this.zzwa.length;
                        int[] iArr16 = new int[(i8 + length16)];
                        if (length16 != 0) {
                            System.arraycopy(this.zzwa, 0, iArr16, 0, length16);
                        }
                        while (length16 < iArr16.length) {
                            iArr16[length16] = zzaou.N();
                            length16++;
                        }
                        this.zzwa = iArr16;
                        zzaou.zzaej(zzaei8);
                        continue;
                    case 72:
                        int zzc9 = zzapf.zzc(zzaou, 72);
                        int length17 = this.zzwb == null ? 0 : this.zzwb.length;
                        int[] iArr17 = new int[(zzc9 + length17)];
                        if (length17 != 0) {
                            System.arraycopy(this.zzwb, 0, iArr17, 0, length17);
                        }
                        while (length17 < iArr17.length - 1) {
                            iArr17[length17] = zzaou.N();
                            zzaou.J();
                            length17++;
                        }
                        iArr17[length17] = zzaou.N();
                        this.zzwb = iArr17;
                        continue;
                    case 74:
                        int zzaei9 = zzaou.zzaei(zzaou.S());
                        int position9 = zzaou.getPosition();
                        int i9 = 0;
                        while (zzaou.X() > 0) {
                            zzaou.N();
                            i9++;
                        }
                        zzaou.zzaek(position9);
                        int length18 = this.zzwb == null ? 0 : this.zzwb.length;
                        int[] iArr18 = new int[(i9 + length18)];
                        if (length18 != 0) {
                            System.arraycopy(this.zzwb, 0, iArr18, 0, length18);
                        }
                        while (length18 < iArr18.length) {
                            iArr18[length18] = zzaou.N();
                            length18++;
                        }
                        this.zzwb = iArr18;
                        zzaou.zzaej(zzaei9);
                        continue;
                    case 80:
                        int zzc10 = zzapf.zzc(zzaou, 80);
                        int length19 = this.zzwc == null ? 0 : this.zzwc.length;
                        int[] iArr19 = new int[(zzc10 + length19)];
                        if (length19 != 0) {
                            System.arraycopy(this.zzwc, 0, iArr19, 0, length19);
                        }
                        while (length19 < iArr19.length - 1) {
                            iArr19[length19] = zzaou.N();
                            zzaou.J();
                            length19++;
                        }
                        iArr19[length19] = zzaou.N();
                        this.zzwc = iArr19;
                        continue;
                    case 82:
                        int zzaei10 = zzaou.zzaei(zzaou.S());
                        int position10 = zzaou.getPosition();
                        int i10 = 0;
                        while (zzaou.X() > 0) {
                            zzaou.N();
                            i10++;
                        }
                        zzaou.zzaek(position10);
                        int length20 = this.zzwc == null ? 0 : this.zzwc.length;
                        int[] iArr20 = new int[(i10 + length20)];
                        if (length20 != 0) {
                            System.arraycopy(this.zzwc, 0, iArr20, 0, length20);
                        }
                        while (length20 < iArr20.length) {
                            iArr20[length20] = zzaou.N();
                            length20++;
                        }
                        this.zzwc = iArr20;
                        zzaou.zzaej(zzaei10);
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
            int i;
            int zzy = super.zzy();
            if (this.zzvt == null || this.zzvt.length <= 0) {
                i = zzy;
            } else {
                int i2 = 0;
                for (int zzaeo : this.zzvt) {
                    i2 += zzaov.zzaeo(zzaeo);
                }
                i = zzy + i2 + (this.zzvt.length * 1);
            }
            if (this.zzvu != null && this.zzvu.length > 0) {
                int i3 = 0;
                for (int zzaeo2 : this.zzvu) {
                    i3 += zzaov.zzaeo(zzaeo2);
                }
                i = i + i3 + (this.zzvu.length * 1);
            }
            if (this.zzvv != null && this.zzvv.length > 0) {
                int i4 = 0;
                for (int zzaeo3 : this.zzvv) {
                    i4 += zzaov.zzaeo(zzaeo3);
                }
                i = i + i4 + (this.zzvv.length * 1);
            }
            if (this.zzvw != null && this.zzvw.length > 0) {
                int i5 = 0;
                for (int zzaeo4 : this.zzvw) {
                    i5 += zzaov.zzaeo(zzaeo4);
                }
                i = i + i5 + (this.zzvw.length * 1);
            }
            if (this.zzvx != null && this.zzvx.length > 0) {
                int i6 = 0;
                for (int zzaeo5 : this.zzvx) {
                    i6 += zzaov.zzaeo(zzaeo5);
                }
                i = i + i6 + (this.zzvx.length * 1);
            }
            if (this.zzvy != null && this.zzvy.length > 0) {
                int i7 = 0;
                for (int zzaeo6 : this.zzvy) {
                    i7 += zzaov.zzaeo(zzaeo6);
                }
                i = i + i7 + (this.zzvy.length * 1);
            }
            if (this.zzvz != null && this.zzvz.length > 0) {
                int i8 = 0;
                for (int zzaeo7 : this.zzvz) {
                    i8 += zzaov.zzaeo(zzaeo7);
                }
                i = i + i8 + (this.zzvz.length * 1);
            }
            if (this.zzwa != null && this.zzwa.length > 0) {
                int i9 = 0;
                for (int zzaeo8 : this.zzwa) {
                    i9 += zzaov.zzaeo(zzaeo8);
                }
                i = i + i9 + (this.zzwa.length * 1);
            }
            if (this.zzwb != null && this.zzwb.length > 0) {
                int i10 = 0;
                for (int zzaeo9 : this.zzwb) {
                    i10 += zzaov.zzaeo(zzaeo9);
                }
                i = i + i10 + (this.zzwb.length * 1);
            }
            if (this.zzwc == null || this.zzwc.length <= 0) {
                return i;
            }
            int i11 = 0;
            for (int zzaeo10 : this.zzwc) {
                i11 += zzaov.zzaeo(zzaeo10);
            }
            return i + i11 + (this.zzwc.length * 1);
        }
    }

    public static final class zzh extends zzaow<zzh> {
        public static final zzaox<com.google.android.gms.internal.zzai.zza, zzh> zzwd = zzaox.zza(11, zzh.class, 810);
        private static final zzh[] zzwe = new zzh[0];
        public int[] zzwf;
        public int[] zzwg;
        public int[] zzwh;
        public int zzwi;
        public int[] zzwj;
        public int zzwk;
        public int zzwl;

        public zzh() {
            zzam();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzh)) {
                return false;
            }
            zzh zzh = (zzh) obj;
            if (!zzapa.equals(this.zzwf, zzh.zzwf) || !zzapa.equals(this.zzwg, zzh.zzwg) || !zzapa.equals(this.zzwh, zzh.zzwh) || this.zzwi != zzh.zzwi || !zzapa.equals(this.zzwj, zzh.zzwj) || this.zzwk != zzh.zzwk || this.zzwl != zzh.zzwl) {
                return false;
            }
            return (this.bib == null || this.bib.isEmpty()) ? zzh.bib == null || zzh.bib.isEmpty() : this.bib.equals(zzh.bib);
        }

        public int hashCode() {
            return ((this.bib == null || this.bib.isEmpty()) ? 0 : this.bib.hashCode()) + ((((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzapa.hashCode(this.zzwf)) * 31) + zzapa.hashCode(this.zzwg)) * 31) + zzapa.hashCode(this.zzwh)) * 31) + this.zzwi) * 31) + zzapa.hashCode(this.zzwj)) * 31) + this.zzwk) * 31) + this.zzwl) * 31);
        }

        public void zza(zzaov zzaov) throws IOException {
            if (this.zzwf != null && this.zzwf.length > 0) {
                for (int zzae : this.zzwf) {
                    zzaov.zzae(1, zzae);
                }
            }
            if (this.zzwg != null && this.zzwg.length > 0) {
                for (int zzae2 : this.zzwg) {
                    zzaov.zzae(2, zzae2);
                }
            }
            if (this.zzwh != null && this.zzwh.length > 0) {
                for (int zzae3 : this.zzwh) {
                    zzaov.zzae(3, zzae3);
                }
            }
            if (this.zzwi != 0) {
                zzaov.zzae(4, this.zzwi);
            }
            if (this.zzwj != null && this.zzwj.length > 0) {
                for (int zzae4 : this.zzwj) {
                    zzaov.zzae(5, zzae4);
                }
            }
            if (this.zzwk != 0) {
                zzaov.zzae(6, this.zzwk);
            }
            if (this.zzwl != 0) {
                zzaov.zzae(7, this.zzwl);
            }
            super.zza(zzaov);
        }

        public zzh zzam() {
            this.zzwf = zzapf.bim;
            this.zzwg = zzapf.bim;
            this.zzwh = zzapf.bim;
            this.zzwi = 0;
            this.zzwj = zzapf.bim;
            this.zzwk = 0;
            this.zzwl = 0;
            this.bib = null;
            this.bik = -1;
            return this;
        }

        /* renamed from: zzq */
        public zzh zzb(zzaou zzaou) throws IOException {
            while (true) {
                int J = zzaou.J();
                switch (J) {
                    case 0:
                        break;
                    case 8:
                        int zzc = zzapf.zzc(zzaou, 8);
                        int length = this.zzwf == null ? 0 : this.zzwf.length;
                        int[] iArr = new int[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzwf, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = zzaou.N();
                            zzaou.J();
                            length++;
                        }
                        iArr[length] = zzaou.N();
                        this.zzwf = iArr;
                        continue;
                    case 10:
                        int zzaei = zzaou.zzaei(zzaou.S());
                        int position = zzaou.getPosition();
                        int i = 0;
                        while (zzaou.X() > 0) {
                            zzaou.N();
                            i++;
                        }
                        zzaou.zzaek(position);
                        int length2 = this.zzwf == null ? 0 : this.zzwf.length;
                        int[] iArr2 = new int[(i + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzwf, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = zzaou.N();
                            length2++;
                        }
                        this.zzwf = iArr2;
                        zzaou.zzaej(zzaei);
                        continue;
                    case 16:
                        int zzc2 = zzapf.zzc(zzaou, 16);
                        int length3 = this.zzwg == null ? 0 : this.zzwg.length;
                        int[] iArr3 = new int[(zzc2 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzwg, 0, iArr3, 0, length3);
                        }
                        while (length3 < iArr3.length - 1) {
                            iArr3[length3] = zzaou.N();
                            zzaou.J();
                            length3++;
                        }
                        iArr3[length3] = zzaou.N();
                        this.zzwg = iArr3;
                        continue;
                    case 18:
                        int zzaei2 = zzaou.zzaei(zzaou.S());
                        int position2 = zzaou.getPosition();
                        int i2 = 0;
                        while (zzaou.X() > 0) {
                            zzaou.N();
                            i2++;
                        }
                        zzaou.zzaek(position2);
                        int length4 = this.zzwg == null ? 0 : this.zzwg.length;
                        int[] iArr4 = new int[(i2 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.zzwg, 0, iArr4, 0, length4);
                        }
                        while (length4 < iArr4.length) {
                            iArr4[length4] = zzaou.N();
                            length4++;
                        }
                        this.zzwg = iArr4;
                        zzaou.zzaej(zzaei2);
                        continue;
                    case 24:
                        int zzc3 = zzapf.zzc(zzaou, 24);
                        int length5 = this.zzwh == null ? 0 : this.zzwh.length;
                        int[] iArr5 = new int[(zzc3 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.zzwh, 0, iArr5, 0, length5);
                        }
                        while (length5 < iArr5.length - 1) {
                            iArr5[length5] = zzaou.N();
                            zzaou.J();
                            length5++;
                        }
                        iArr5[length5] = zzaou.N();
                        this.zzwh = iArr5;
                        continue;
                    case 26:
                        int zzaei3 = zzaou.zzaei(zzaou.S());
                        int position3 = zzaou.getPosition();
                        int i3 = 0;
                        while (zzaou.X() > 0) {
                            zzaou.N();
                            i3++;
                        }
                        zzaou.zzaek(position3);
                        int length6 = this.zzwh == null ? 0 : this.zzwh.length;
                        int[] iArr6 = new int[(i3 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.zzwh, 0, iArr6, 0, length6);
                        }
                        while (length6 < iArr6.length) {
                            iArr6[length6] = zzaou.N();
                            length6++;
                        }
                        this.zzwh = iArr6;
                        zzaou.zzaej(zzaei3);
                        continue;
                    case 32:
                        this.zzwi = zzaou.N();
                        continue;
                    case 40:
                        int zzc4 = zzapf.zzc(zzaou, 40);
                        int length7 = this.zzwj == null ? 0 : this.zzwj.length;
                        int[] iArr7 = new int[(zzc4 + length7)];
                        if (length7 != 0) {
                            System.arraycopy(this.zzwj, 0, iArr7, 0, length7);
                        }
                        while (length7 < iArr7.length - 1) {
                            iArr7[length7] = zzaou.N();
                            zzaou.J();
                            length7++;
                        }
                        iArr7[length7] = zzaou.N();
                        this.zzwj = iArr7;
                        continue;
                    case 42:
                        int zzaei4 = zzaou.zzaei(zzaou.S());
                        int position4 = zzaou.getPosition();
                        int i4 = 0;
                        while (zzaou.X() > 0) {
                            zzaou.N();
                            i4++;
                        }
                        zzaou.zzaek(position4);
                        int length8 = this.zzwj == null ? 0 : this.zzwj.length;
                        int[] iArr8 = new int[(i4 + length8)];
                        if (length8 != 0) {
                            System.arraycopy(this.zzwj, 0, iArr8, 0, length8);
                        }
                        while (length8 < iArr8.length) {
                            iArr8[length8] = zzaou.N();
                            length8++;
                        }
                        this.zzwj = iArr8;
                        zzaou.zzaej(zzaei4);
                        continue;
                    case 48:
                        this.zzwk = zzaou.N();
                        continue;
                    case 56:
                        this.zzwl = zzaou.N();
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
            int i;
            int zzy = super.zzy();
            if (this.zzwf == null || this.zzwf.length <= 0) {
                i = zzy;
            } else {
                int i2 = 0;
                for (int zzaeo : this.zzwf) {
                    i2 += zzaov.zzaeo(zzaeo);
                }
                i = zzy + i2 + (this.zzwf.length * 1);
            }
            if (this.zzwg != null && this.zzwg.length > 0) {
                int i3 = 0;
                for (int zzaeo2 : this.zzwg) {
                    i3 += zzaov.zzaeo(zzaeo2);
                }
                i = i + i3 + (this.zzwg.length * 1);
            }
            if (this.zzwh != null && this.zzwh.length > 0) {
                int i4 = 0;
                for (int zzaeo3 : this.zzwh) {
                    i4 += zzaov.zzaeo(zzaeo3);
                }
                i = i + i4 + (this.zzwh.length * 1);
            }
            if (this.zzwi != 0) {
                i += zzaov.zzag(4, this.zzwi);
            }
            if (this.zzwj != null && this.zzwj.length > 0) {
                int i5 = 0;
                for (int zzaeo4 : this.zzwj) {
                    i5 += zzaov.zzaeo(zzaeo4);
                }
                i = i + i5 + (this.zzwj.length * 1);
            }
            if (this.zzwk != 0) {
                i += zzaov.zzag(6, this.zzwk);
            }
            return this.zzwl != 0 ? i + zzaov.zzag(7, this.zzwl) : i;
        }
    }

    public static final class zzi extends zzaow<zzi> {
        private static volatile zzi[] zzwm;
        public String name;
        public com.google.android.gms.internal.zzai.zza zzwn;
        public zzd zzwo;

        public zzi() {
            zzao();
        }

        public static zzi[] zzan() {
            if (zzwm == null) {
                synchronized (zzapa.bij) {
                    if (zzwm == null) {
                        zzwm = new zzi[0];
                    }
                }
            }
            return zzwm;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzi)) {
                return false;
            }
            zzi zzi = (zzi) obj;
            if (this.name == null) {
                if (zzi.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzi.name)) {
                return false;
            }
            if (this.zzwn == null) {
                if (zzi.zzwn != null) {
                    return false;
                }
            } else if (!this.zzwn.equals(zzi.zzwn)) {
                return false;
            }
            if (this.zzwo == null) {
                if (zzi.zzwo != null) {
                    return false;
                }
            } else if (!this.zzwo.equals(zzi.zzwo)) {
                return false;
            }
            return (this.bib == null || this.bib.isEmpty()) ? zzi.bib == null || zzi.bib.isEmpty() : this.bib.equals(zzi.bib);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzwo == null ? 0 : this.zzwo.hashCode()) + (((this.zzwn == null ? 0 : this.zzwn.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31;
            if (this.bib != null && !this.bib.isEmpty()) {
                i = this.bib.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzaov zzaov) throws IOException {
            if (!this.name.equals("")) {
                zzaov.zzr(1, this.name);
            }
            if (this.zzwn != null) {
                zzaov.zza(2, (zzapc) this.zzwn);
            }
            if (this.zzwo != null) {
                zzaov.zza(3, (zzapc) this.zzwo);
            }
            super.zza(zzaov);
        }

        public zzi zzao() {
            this.name = "";
            this.zzwn = null;
            this.zzwo = null;
            this.bib = null;
            this.bik = -1;
            return this;
        }

        /* renamed from: zzr */
        public zzi zzb(zzaou zzaou) throws IOException {
            while (true) {
                int J = zzaou.J();
                switch (J) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzaou.readString();
                        continue;
                    case 18:
                        if (this.zzwn == null) {
                            this.zzwn = new com.google.android.gms.internal.zzai.zza();
                        }
                        zzaou.zza(this.zzwn);
                        continue;
                    case 26:
                        if (this.zzwo == null) {
                            this.zzwo = new zzd();
                        }
                        zzaou.zza(this.zzwo);
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
            int zzy = super.zzy();
            if (!this.name.equals("")) {
                zzy += zzaov.zzs(1, this.name);
            }
            if (this.zzwn != null) {
                zzy += zzaov.zzc(2, (zzapc) this.zzwn);
            }
            return this.zzwo != null ? zzy + zzaov.zzc(3, (zzapc) this.zzwo) : zzy;
        }
    }

    public static final class zzj extends zzaow<zzj> {
        public zzi[] zzwp;
        public zzf zzwq;
        public String zzwr;

        public zzj() {
            zzap();
        }

        public static zzj zzf(byte[] bArr) throws zzapb {
            return (zzj) zzapc.zza(new zzj(), bArr);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzj)) {
                return false;
            }
            zzj zzj = (zzj) obj;
            if (!zzapa.equals((Object[]) this.zzwp, (Object[]) zzj.zzwp)) {
                return false;
            }
            if (this.zzwq == null) {
                if (zzj.zzwq != null) {
                    return false;
                }
            } else if (!this.zzwq.equals(zzj.zzwq)) {
                return false;
            }
            if (this.zzwr == null) {
                if (zzj.zzwr != null) {
                    return false;
                }
            } else if (!this.zzwr.equals(zzj.zzwr)) {
                return false;
            }
            return (this.bib == null || this.bib.isEmpty()) ? zzj.bib == null || zzj.bib.isEmpty() : this.bib.equals(zzj.bib);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzwr == null ? 0 : this.zzwr.hashCode()) + (((this.zzwq == null ? 0 : this.zzwq.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + zzapa.hashCode((Object[]) this.zzwp)) * 31)) * 31)) * 31;
            if (this.bib != null && !this.bib.isEmpty()) {
                i = this.bib.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzaov zzaov) throws IOException {
            if (this.zzwp != null && this.zzwp.length > 0) {
                for (zzi zzi : this.zzwp) {
                    if (zzi != null) {
                        zzaov.zza(1, (zzapc) zzi);
                    }
                }
            }
            if (this.zzwq != null) {
                zzaov.zza(2, (zzapc) this.zzwq);
            }
            if (!this.zzwr.equals("")) {
                zzaov.zzr(3, this.zzwr);
            }
            super.zza(zzaov);
        }

        public zzj zzap() {
            this.zzwp = zzi.zzan();
            this.zzwq = null;
            this.zzwr = "";
            this.bib = null;
            this.bik = -1;
            return this;
        }

        /* renamed from: zzs */
        public zzj zzb(zzaou zzaou) throws IOException {
            while (true) {
                int J = zzaou.J();
                switch (J) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzapf.zzc(zzaou, 10);
                        int length = this.zzwp == null ? 0 : this.zzwp.length;
                        zzi[] zziArr = new zzi[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzwp, 0, zziArr, 0, length);
                        }
                        while (length < zziArr.length - 1) {
                            zziArr[length] = new zzi();
                            zzaou.zza(zziArr[length]);
                            zzaou.J();
                            length++;
                        }
                        zziArr[length] = new zzi();
                        zzaou.zza(zziArr[length]);
                        this.zzwp = zziArr;
                        continue;
                    case 18:
                        if (this.zzwq == null) {
                            this.zzwq = new zzf();
                        }
                        zzaou.zza(this.zzwq);
                        continue;
                    case 26:
                        this.zzwr = zzaou.readString();
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
            int zzy = super.zzy();
            if (this.zzwp != null && this.zzwp.length > 0) {
                for (zzi zzi : this.zzwp) {
                    if (zzi != null) {
                        zzy += zzaov.zzc(1, (zzapc) zzi);
                    }
                }
            }
            if (this.zzwq != null) {
                zzy += zzaov.zzc(2, (zzapc) this.zzwq);
            }
            return !this.zzwr.equals("") ? zzy + zzaov.zzs(3, this.zzwr) : zzy;
        }
    }
}
