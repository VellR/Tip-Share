package com.google.android.gms.internal;

import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import java.io.IOException;

public interface zzae {

    public static final class zza extends zzaow<zza> {
        public String zzcs;
        public String zzct;
        public Long zzcu;
        public Long zzcv;
        public Long zzcw;
        public Long zzcx;
        public Long zzcy;
        public Long zzcz;
        public Long zzda;
        public Long zzdb;
        public Long zzdc;
        public Long zzdd;
        public String zzde;
        public Long zzdf;
        public Long zzdg;
        public Long zzdh;
        public Long zzdi;
        public Long zzdj;
        public Long zzdk;
        public Long zzdl;
        public Long zzdm;
        public Long zzdn;
        public String zzdo;
        public String zzdp;
        public Long zzdq;
        public Long zzdr;
        public Long zzds;
        public String zzdt;
        public Long zzdu;
        public Long zzdv;
        public Long zzdw;
        public zzb zzdx;
        public Long zzdy;
        public Long zzdz;
        public Long zzea;
        public Long zzeb;
        public Long zzec;
        public Long zzed;
        public C0024zza[] zzee;
        public Long zzef;
        public String zzeg;
        public Integer zzeh;
        public Boolean zzei;
        public String zzej;
        public Long zzek;
        public zze zzel;

        /* renamed from: com.google.android.gms.internal.zzae$zza$zza reason: collision with other inner class name */
        public static final class C0024zza extends zzaow<C0024zza> {
            private static volatile C0024zza[] zzem;
            public Long zzdf;
            public Long zzdg;

            public C0024zza() {
                this.zzdf = null;
                this.zzdg = null;
                this.bik = -1;
            }

            public static C0024zza[] zzz() {
                if (zzem == null) {
                    synchronized (zzapa.bij) {
                        if (zzem == null) {
                            zzem = new C0024zza[0];
                        }
                    }
                }
                return zzem;
            }

            public void zza(zzaov zzaov) throws IOException {
                if (this.zzdf != null) {
                    zzaov.zzb(1, this.zzdf.longValue());
                }
                if (this.zzdg != null) {
                    zzaov.zzb(2, this.zzdg.longValue());
                }
                super.zza(zzaov);
            }

            /* renamed from: zzd */
            public C0024zza zzb(zzaou zzaou) throws IOException {
                while (true) {
                    int J = zzaou.J();
                    switch (J) {
                        case 0:
                            break;
                        case 8:
                            this.zzdf = Long.valueOf(zzaou.M());
                            continue;
                        case 16:
                            this.zzdg = Long.valueOf(zzaou.M());
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
                if (this.zzdf != null) {
                    zzy += zzaov.zze(1, this.zzdf.longValue());
                }
                return this.zzdg != null ? zzy + zzaov.zze(2, this.zzdg.longValue()) : zzy;
            }
        }

        public zza() {
            this.zzct = null;
            this.zzcs = null;
            this.zzcu = null;
            this.zzcv = null;
            this.zzcw = null;
            this.zzcx = null;
            this.zzcy = null;
            this.zzcz = null;
            this.zzda = null;
            this.zzdb = null;
            this.zzdc = null;
            this.zzdd = null;
            this.zzde = null;
            this.zzdf = null;
            this.zzdg = null;
            this.zzdh = null;
            this.zzdi = null;
            this.zzdj = null;
            this.zzdk = null;
            this.zzdl = null;
            this.zzdm = null;
            this.zzdn = null;
            this.zzdo = null;
            this.zzdp = null;
            this.zzdq = null;
            this.zzdr = null;
            this.zzds = null;
            this.zzdt = null;
            this.zzdu = null;
            this.zzdv = null;
            this.zzdw = null;
            this.zzdy = null;
            this.zzdz = null;
            this.zzea = null;
            this.zzeb = null;
            this.zzec = null;
            this.zzed = null;
            this.zzee = C0024zza.zzz();
            this.zzef = null;
            this.zzeg = null;
            this.zzeh = null;
            this.zzei = null;
            this.zzej = null;
            this.zzek = null;
            this.bik = -1;
        }

        public static zza zzc(byte[] bArr) throws zzapb {
            return (zza) zzapc.zza(new zza(), bArr);
        }

        public void zza(zzaov zzaov) throws IOException {
            if (this.zzct != null) {
                zzaov.zzr(1, this.zzct);
            }
            if (this.zzcs != null) {
                zzaov.zzr(2, this.zzcs);
            }
            if (this.zzcu != null) {
                zzaov.zzb(3, this.zzcu.longValue());
            }
            if (this.zzcv != null) {
                zzaov.zzb(4, this.zzcv.longValue());
            }
            if (this.zzcw != null) {
                zzaov.zzb(5, this.zzcw.longValue());
            }
            if (this.zzcx != null) {
                zzaov.zzb(6, this.zzcx.longValue());
            }
            if (this.zzcy != null) {
                zzaov.zzb(7, this.zzcy.longValue());
            }
            if (this.zzcz != null) {
                zzaov.zzb(8, this.zzcz.longValue());
            }
            if (this.zzda != null) {
                zzaov.zzb(9, this.zzda.longValue());
            }
            if (this.zzdb != null) {
                zzaov.zzb(10, this.zzdb.longValue());
            }
            if (this.zzdc != null) {
                zzaov.zzb(11, this.zzdc.longValue());
            }
            if (this.zzdd != null) {
                zzaov.zzb(12, this.zzdd.longValue());
            }
            if (this.zzde != null) {
                zzaov.zzr(13, this.zzde);
            }
            if (this.zzdf != null) {
                zzaov.zzb(14, this.zzdf.longValue());
            }
            if (this.zzdg != null) {
                zzaov.zzb(15, this.zzdg.longValue());
            }
            if (this.zzdh != null) {
                zzaov.zzb(16, this.zzdh.longValue());
            }
            if (this.zzdi != null) {
                zzaov.zzb(17, this.zzdi.longValue());
            }
            if (this.zzdj != null) {
                zzaov.zzb(18, this.zzdj.longValue());
            }
            if (this.zzdk != null) {
                zzaov.zzb(19, this.zzdk.longValue());
            }
            if (this.zzdl != null) {
                zzaov.zzb(20, this.zzdl.longValue());
            }
            if (this.zzef != null) {
                zzaov.zzb(21, this.zzef.longValue());
            }
            if (this.zzdm != null) {
                zzaov.zzb(22, this.zzdm.longValue());
            }
            if (this.zzdn != null) {
                zzaov.zzb(23, this.zzdn.longValue());
            }
            if (this.zzeg != null) {
                zzaov.zzr(24, this.zzeg);
            }
            if (this.zzek != null) {
                zzaov.zzb(25, this.zzek.longValue());
            }
            if (this.zzeh != null) {
                zzaov.zzae(26, this.zzeh.intValue());
            }
            if (this.zzdo != null) {
                zzaov.zzr(27, this.zzdo);
            }
            if (this.zzei != null) {
                zzaov.zzj(28, this.zzei.booleanValue());
            }
            if (this.zzdp != null) {
                zzaov.zzr(29, this.zzdp);
            }
            if (this.zzej != null) {
                zzaov.zzr(30, this.zzej);
            }
            if (this.zzdq != null) {
                zzaov.zzb(31, this.zzdq.longValue());
            }
            if (this.zzdr != null) {
                zzaov.zzb(32, this.zzdr.longValue());
            }
            if (this.zzds != null) {
                zzaov.zzb(33, this.zzds.longValue());
            }
            if (this.zzdt != null) {
                zzaov.zzr(34, this.zzdt);
            }
            if (this.zzdu != null) {
                zzaov.zzb(35, this.zzdu.longValue());
            }
            if (this.zzdv != null) {
                zzaov.zzb(36, this.zzdv.longValue());
            }
            if (this.zzdw != null) {
                zzaov.zzb(37, this.zzdw.longValue());
            }
            if (this.zzdx != null) {
                zzaov.zza(38, (zzapc) this.zzdx);
            }
            if (this.zzdy != null) {
                zzaov.zzb(39, this.zzdy.longValue());
            }
            if (this.zzdz != null) {
                zzaov.zzb(40, this.zzdz.longValue());
            }
            if (this.zzea != null) {
                zzaov.zzb(41, this.zzea.longValue());
            }
            if (this.zzeb != null) {
                zzaov.zzb(42, this.zzeb.longValue());
            }
            if (this.zzee != null && this.zzee.length > 0) {
                for (C0024zza zza : this.zzee) {
                    if (zza != null) {
                        zzaov.zza(43, (zzapc) zza);
                    }
                }
            }
            if (this.zzec != null) {
                zzaov.zzb(44, this.zzec.longValue());
            }
            if (this.zzed != null) {
                zzaov.zzb(45, this.zzed.longValue());
            }
            if (this.zzel != null) {
                zzaov.zza(201, (zzapc) this.zzel);
            }
            super.zza(zzaov);
        }

        /* renamed from: zzc */
        public zza zzb(zzaou zzaou) throws IOException {
            while (true) {
                int J = zzaou.J();
                switch (J) {
                    case 0:
                        break;
                    case 10:
                        this.zzct = zzaou.readString();
                        continue;
                    case 18:
                        this.zzcs = zzaou.readString();
                        continue;
                    case 24:
                        this.zzcu = Long.valueOf(zzaou.M());
                        continue;
                    case 32:
                        this.zzcv = Long.valueOf(zzaou.M());
                        continue;
                    case 40:
                        this.zzcw = Long.valueOf(zzaou.M());
                        continue;
                    case 48:
                        this.zzcx = Long.valueOf(zzaou.M());
                        continue;
                    case 56:
                        this.zzcy = Long.valueOf(zzaou.M());
                        continue;
                    case 64:
                        this.zzcz = Long.valueOf(zzaou.M());
                        continue;
                    case 72:
                        this.zzda = Long.valueOf(zzaou.M());
                        continue;
                    case 80:
                        this.zzdb = Long.valueOf(zzaou.M());
                        continue;
                    case 88:
                        this.zzdc = Long.valueOf(zzaou.M());
                        continue;
                    case 96:
                        this.zzdd = Long.valueOf(zzaou.M());
                        continue;
                    case 106:
                        this.zzde = zzaou.readString();
                        continue;
                    case 112:
                        this.zzdf = Long.valueOf(zzaou.M());
                        continue;
                    case 120:
                        this.zzdg = Long.valueOf(zzaou.M());
                        continue;
                    case 128:
                        this.zzdh = Long.valueOf(zzaou.M());
                        continue;
                    case 136:
                        this.zzdi = Long.valueOf(zzaou.M());
                        continue;
                    case 144:
                        this.zzdj = Long.valueOf(zzaou.M());
                        continue;
                    case 152:
                        this.zzdk = Long.valueOf(zzaou.M());
                        continue;
                    case 160:
                        this.zzdl = Long.valueOf(zzaou.M());
                        continue;
                    case 168:
                        this.zzef = Long.valueOf(zzaou.M());
                        continue;
                    case 176:
                        this.zzdm = Long.valueOf(zzaou.M());
                        continue;
                    case 184:
                        this.zzdn = Long.valueOf(zzaou.M());
                        continue;
                    case 194:
                        this.zzeg = zzaou.readString();
                        continue;
                    case Callback.DEFAULT_DRAG_ANIMATION_DURATION /*200*/:
                        this.zzek = Long.valueOf(zzaou.M());
                        continue;
                    case 208:
                        int N = zzaou.N();
                        switch (N) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                                this.zzeh = Integer.valueOf(N);
                                break;
                            default:
                                continue;
                        }
                    case 218:
                        this.zzdo = zzaou.readString();
                        continue;
                    case 224:
                        this.zzei = Boolean.valueOf(zzaou.P());
                        continue;
                    case 234:
                        this.zzdp = zzaou.readString();
                        continue;
                    case 242:
                        this.zzej = zzaou.readString();
                        continue;
                    case 248:
                        this.zzdq = Long.valueOf(zzaou.M());
                        continue;
                    case 256:
                        this.zzdr = Long.valueOf(zzaou.M());
                        continue;
                    case 264:
                        this.zzds = Long.valueOf(zzaou.M());
                        continue;
                    case 274:
                        this.zzdt = zzaou.readString();
                        continue;
                    case 280:
                        this.zzdu = Long.valueOf(zzaou.M());
                        continue;
                    case 288:
                        this.zzdv = Long.valueOf(zzaou.M());
                        continue;
                    case 296:
                        this.zzdw = Long.valueOf(zzaou.M());
                        continue;
                    case 306:
                        if (this.zzdx == null) {
                            this.zzdx = new zzb();
                        }
                        zzaou.zza(this.zzdx);
                        continue;
                    case 312:
                        this.zzdy = Long.valueOf(zzaou.M());
                        continue;
                    case 320:
                        this.zzdz = Long.valueOf(zzaou.M());
                        continue;
                    case 328:
                        this.zzea = Long.valueOf(zzaou.M());
                        continue;
                    case 336:
                        this.zzeb = Long.valueOf(zzaou.M());
                        continue;
                    case 346:
                        int zzc = zzapf.zzc(zzaou, 346);
                        int length = this.zzee == null ? 0 : this.zzee.length;
                        C0024zza[] zzaArr = new C0024zza[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzee, 0, zzaArr, 0, length);
                        }
                        while (length < zzaArr.length - 1) {
                            zzaArr[length] = new C0024zza();
                            zzaou.zza(zzaArr[length]);
                            zzaou.J();
                            length++;
                        }
                        zzaArr[length] = new C0024zza();
                        zzaou.zza(zzaArr[length]);
                        this.zzee = zzaArr;
                        continue;
                    case 352:
                        this.zzec = Long.valueOf(zzaou.M());
                        continue;
                    case 360:
                        this.zzed = Long.valueOf(zzaou.M());
                        continue;
                    case 1610:
                        if (this.zzel == null) {
                            this.zzel = new zze();
                        }
                        zzaou.zza(this.zzel);
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
            if (this.zzct != null) {
                zzy += zzaov.zzs(1, this.zzct);
            }
            if (this.zzcs != null) {
                zzy += zzaov.zzs(2, this.zzcs);
            }
            if (this.zzcu != null) {
                zzy += zzaov.zze(3, this.zzcu.longValue());
            }
            if (this.zzcv != null) {
                zzy += zzaov.zze(4, this.zzcv.longValue());
            }
            if (this.zzcw != null) {
                zzy += zzaov.zze(5, this.zzcw.longValue());
            }
            if (this.zzcx != null) {
                zzy += zzaov.zze(6, this.zzcx.longValue());
            }
            if (this.zzcy != null) {
                zzy += zzaov.zze(7, this.zzcy.longValue());
            }
            if (this.zzcz != null) {
                zzy += zzaov.zze(8, this.zzcz.longValue());
            }
            if (this.zzda != null) {
                zzy += zzaov.zze(9, this.zzda.longValue());
            }
            if (this.zzdb != null) {
                zzy += zzaov.zze(10, this.zzdb.longValue());
            }
            if (this.zzdc != null) {
                zzy += zzaov.zze(11, this.zzdc.longValue());
            }
            if (this.zzdd != null) {
                zzy += zzaov.zze(12, this.zzdd.longValue());
            }
            if (this.zzde != null) {
                zzy += zzaov.zzs(13, this.zzde);
            }
            if (this.zzdf != null) {
                zzy += zzaov.zze(14, this.zzdf.longValue());
            }
            if (this.zzdg != null) {
                zzy += zzaov.zze(15, this.zzdg.longValue());
            }
            if (this.zzdh != null) {
                zzy += zzaov.zze(16, this.zzdh.longValue());
            }
            if (this.zzdi != null) {
                zzy += zzaov.zze(17, this.zzdi.longValue());
            }
            if (this.zzdj != null) {
                zzy += zzaov.zze(18, this.zzdj.longValue());
            }
            if (this.zzdk != null) {
                zzy += zzaov.zze(19, this.zzdk.longValue());
            }
            if (this.zzdl != null) {
                zzy += zzaov.zze(20, this.zzdl.longValue());
            }
            if (this.zzef != null) {
                zzy += zzaov.zze(21, this.zzef.longValue());
            }
            if (this.zzdm != null) {
                zzy += zzaov.zze(22, this.zzdm.longValue());
            }
            if (this.zzdn != null) {
                zzy += zzaov.zze(23, this.zzdn.longValue());
            }
            if (this.zzeg != null) {
                zzy += zzaov.zzs(24, this.zzeg);
            }
            if (this.zzek != null) {
                zzy += zzaov.zze(25, this.zzek.longValue());
            }
            if (this.zzeh != null) {
                zzy += zzaov.zzag(26, this.zzeh.intValue());
            }
            if (this.zzdo != null) {
                zzy += zzaov.zzs(27, this.zzdo);
            }
            if (this.zzei != null) {
                zzy += zzaov.zzk(28, this.zzei.booleanValue());
            }
            if (this.zzdp != null) {
                zzy += zzaov.zzs(29, this.zzdp);
            }
            if (this.zzej != null) {
                zzy += zzaov.zzs(30, this.zzej);
            }
            if (this.zzdq != null) {
                zzy += zzaov.zze(31, this.zzdq.longValue());
            }
            if (this.zzdr != null) {
                zzy += zzaov.zze(32, this.zzdr.longValue());
            }
            if (this.zzds != null) {
                zzy += zzaov.zze(33, this.zzds.longValue());
            }
            if (this.zzdt != null) {
                zzy += zzaov.zzs(34, this.zzdt);
            }
            if (this.zzdu != null) {
                zzy += zzaov.zze(35, this.zzdu.longValue());
            }
            if (this.zzdv != null) {
                zzy += zzaov.zze(36, this.zzdv.longValue());
            }
            if (this.zzdw != null) {
                zzy += zzaov.zze(37, this.zzdw.longValue());
            }
            if (this.zzdx != null) {
                zzy += zzaov.zzc(38, (zzapc) this.zzdx);
            }
            if (this.zzdy != null) {
                zzy += zzaov.zze(39, this.zzdy.longValue());
            }
            if (this.zzdz != null) {
                zzy += zzaov.zze(40, this.zzdz.longValue());
            }
            if (this.zzea != null) {
                zzy += zzaov.zze(41, this.zzea.longValue());
            }
            if (this.zzeb != null) {
                zzy += zzaov.zze(42, this.zzeb.longValue());
            }
            if (this.zzee != null && this.zzee.length > 0) {
                int i = zzy;
                for (C0024zza zza : this.zzee) {
                    if (zza != null) {
                        i += zzaov.zzc(43, (zzapc) zza);
                    }
                }
                zzy = i;
            }
            if (this.zzec != null) {
                zzy += zzaov.zze(44, this.zzec.longValue());
            }
            if (this.zzed != null) {
                zzy += zzaov.zze(45, this.zzed.longValue());
            }
            return this.zzel != null ? zzy + zzaov.zzc(201, (zzapc) this.zzel) : zzy;
        }
    }

    public static final class zzb extends zzaow<zzb> {
        public Long zzen;
        public Integer zzeo;
        public Boolean zzep;
        public int[] zzeq;

        public zzb() {
            this.zzen = null;
            this.zzeo = null;
            this.zzep = null;
            this.zzeq = zzapf.bim;
            this.bik = -1;
        }

        public void zza(zzaov zzaov) throws IOException {
            if (this.zzen != null) {
                zzaov.zzb(1, this.zzen.longValue());
            }
            if (this.zzeo != null) {
                zzaov.zzae(2, this.zzeo.intValue());
            }
            if (this.zzep != null) {
                zzaov.zzj(3, this.zzep.booleanValue());
            }
            if (this.zzeq != null && this.zzeq.length > 0) {
                for (int zzae : this.zzeq) {
                    zzaov.zzae(4, zzae);
                }
            }
            super.zza(zzaov);
        }

        /* renamed from: zze */
        public zzb zzb(zzaou zzaou) throws IOException {
            while (true) {
                int J = zzaou.J();
                switch (J) {
                    case 0:
                        break;
                    case 8:
                        this.zzen = Long.valueOf(zzaou.M());
                        continue;
                    case 16:
                        this.zzeo = Integer.valueOf(zzaou.N());
                        continue;
                    case 24:
                        this.zzep = Boolean.valueOf(zzaou.P());
                        continue;
                    case 32:
                        int zzc = zzapf.zzc(zzaou, 32);
                        int length = this.zzeq == null ? 0 : this.zzeq.length;
                        int[] iArr = new int[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzeq, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = zzaou.N();
                            zzaou.J();
                            length++;
                        }
                        iArr[length] = zzaou.N();
                        this.zzeq = iArr;
                        continue;
                    case 34:
                        int zzaei = zzaou.zzaei(zzaou.S());
                        int position = zzaou.getPosition();
                        int i = 0;
                        while (zzaou.X() > 0) {
                            zzaou.N();
                            i++;
                        }
                        zzaou.zzaek(position);
                        int length2 = this.zzeq == null ? 0 : this.zzeq.length;
                        int[] iArr2 = new int[(i + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzeq, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = zzaou.N();
                            length2++;
                        }
                        this.zzeq = iArr2;
                        zzaou.zzaej(zzaei);
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
            if (this.zzen != null) {
                zzy += zzaov.zze(1, this.zzen.longValue());
            }
            if (this.zzeo != null) {
                zzy += zzaov.zzag(2, this.zzeo.intValue());
            }
            if (this.zzep != null) {
                zzy += zzaov.zzk(3, this.zzep.booleanValue());
            }
            if (this.zzeq == null || this.zzeq.length <= 0) {
                return zzy;
            }
            int i = 0;
            for (int zzaeo : this.zzeq) {
                i += zzaov.zzaeo(zzaeo);
            }
            return zzy + i + (this.zzeq.length * 1);
        }
    }

    public static final class zzc extends zzaow<zzc> {
        public byte[] zzer;
        public byte[] zzes;

        public zzc() {
            this.zzer = null;
            this.zzes = null;
            this.bik = -1;
        }

        public void zza(zzaov zzaov) throws IOException {
            if (this.zzer != null) {
                zzaov.zza(1, this.zzer);
            }
            if (this.zzes != null) {
                zzaov.zza(2, this.zzes);
            }
            super.zza(zzaov);
        }

        /* renamed from: zzf */
        public zzc zzb(zzaou zzaou) throws IOException {
            while (true) {
                int J = zzaou.J();
                switch (J) {
                    case 0:
                        break;
                    case 10:
                        this.zzer = zzaou.readBytes();
                        continue;
                    case 18:
                        this.zzes = zzaou.readBytes();
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
            if (this.zzer != null) {
                zzy += zzaov.zzb(1, this.zzer);
            }
            return this.zzes != null ? zzy + zzaov.zzb(2, this.zzes) : zzy;
        }
    }

    public static final class zzd extends zzaow<zzd> {
        public byte[] data;
        public byte[] zzet;
        public byte[] zzeu;
        public byte[] zzev;

        public zzd() {
            this.data = null;
            this.zzet = null;
            this.zzeu = null;
            this.zzev = null;
            this.bik = -1;
        }

        public static zzd zzd(byte[] bArr) throws zzapb {
            return (zzd) zzapc.zza(new zzd(), bArr);
        }

        public void zza(zzaov zzaov) throws IOException {
            if (this.data != null) {
                zzaov.zza(1, this.data);
            }
            if (this.zzet != null) {
                zzaov.zza(2, this.zzet);
            }
            if (this.zzeu != null) {
                zzaov.zza(3, this.zzeu);
            }
            if (this.zzev != null) {
                zzaov.zza(4, this.zzev);
            }
            super.zza(zzaov);
        }

        /* renamed from: zzg */
        public zzd zzb(zzaou zzaou) throws IOException {
            while (true) {
                int J = zzaou.J();
                switch (J) {
                    case 0:
                        break;
                    case 10:
                        this.data = zzaou.readBytes();
                        continue;
                    case 18:
                        this.zzet = zzaou.readBytes();
                        continue;
                    case 26:
                        this.zzeu = zzaou.readBytes();
                        continue;
                    case 34:
                        this.zzev = zzaou.readBytes();
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
            if (this.data != null) {
                zzy += zzaov.zzb(1, this.data);
            }
            if (this.zzet != null) {
                zzy += zzaov.zzb(2, this.zzet);
            }
            if (this.zzeu != null) {
                zzy += zzaov.zzb(3, this.zzeu);
            }
            return this.zzev != null ? zzy + zzaov.zzb(4, this.zzev) : zzy;
        }
    }

    public static final class zze extends zzaow<zze> {
        public Long zzen;
        public String zzew;
        public byte[] zzex;

        public zze() {
            this.zzen = null;
            this.zzew = null;
            this.zzex = null;
            this.bik = -1;
        }

        public void zza(zzaov zzaov) throws IOException {
            if (this.zzen != null) {
                zzaov.zzb(1, this.zzen.longValue());
            }
            if (this.zzew != null) {
                zzaov.zzr(3, this.zzew);
            }
            if (this.zzex != null) {
                zzaov.zza(4, this.zzex);
            }
            super.zza(zzaov);
        }

        /* renamed from: zzh */
        public zze zzb(zzaou zzaou) throws IOException {
            while (true) {
                int J = zzaou.J();
                switch (J) {
                    case 0:
                        break;
                    case 8:
                        this.zzen = Long.valueOf(zzaou.M());
                        continue;
                    case 26:
                        this.zzew = zzaou.readString();
                        continue;
                    case 34:
                        this.zzex = zzaou.readBytes();
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
            if (this.zzen != null) {
                zzy += zzaov.zze(1, this.zzen.longValue());
            }
            if (this.zzew != null) {
                zzy += zzaov.zzs(3, this.zzew);
            }
            return this.zzex != null ? zzy + zzaov.zzb(4, this.zzex) : zzy;
        }
    }

    public static final class zzf extends zzaow<zzf> {
        public byte[] zzet;
        public byte[][] zzey;
        public Integer zzez;
        public Integer zzfa;

        public zzf() {
            this.zzey = zzapf.bis;
            this.zzet = null;
            this.zzez = null;
            this.zzfa = null;
            this.bik = -1;
        }

        public void zza(zzaov zzaov) throws IOException {
            if (this.zzey != null && this.zzey.length > 0) {
                for (byte[] bArr : this.zzey) {
                    if (bArr != null) {
                        zzaov.zza(1, bArr);
                    }
                }
            }
            if (this.zzet != null) {
                zzaov.zza(2, this.zzet);
            }
            if (this.zzez != null) {
                zzaov.zzae(3, this.zzez.intValue());
            }
            if (this.zzfa != null) {
                zzaov.zzae(4, this.zzfa.intValue());
            }
            super.zza(zzaov);
        }

        /* renamed from: zzi */
        public zzf zzb(zzaou zzaou) throws IOException {
            while (true) {
                int J = zzaou.J();
                switch (J) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzapf.zzc(zzaou, 10);
                        int length = this.zzey == null ? 0 : this.zzey.length;
                        byte[][] bArr = new byte[(zzc + length)][];
                        if (length != 0) {
                            System.arraycopy(this.zzey, 0, bArr, 0, length);
                        }
                        while (length < bArr.length - 1) {
                            bArr[length] = zzaou.readBytes();
                            zzaou.J();
                            length++;
                        }
                        bArr[length] = zzaou.readBytes();
                        this.zzey = bArr;
                        continue;
                    case 18:
                        this.zzet = zzaou.readBytes();
                        continue;
                    case 24:
                        int N = zzaou.N();
                        switch (N) {
                            case 0:
                            case 1:
                                this.zzez = Integer.valueOf(N);
                                break;
                            default:
                                continue;
                        }
                    case 32:
                        int N2 = zzaou.N();
                        switch (N2) {
                            case 0:
                            case 1:
                                this.zzfa = Integer.valueOf(N2);
                                break;
                            default:
                                continue;
                        }
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
            if (this.zzey == null || this.zzey.length <= 0) {
                i = zzy;
            } else {
                int i2 = 0;
                int i3 = 0;
                for (byte[] bArr : this.zzey) {
                    if (bArr != null) {
                        i3++;
                        i2 += zzaov.zzbc(bArr);
                    }
                }
                i = zzy + i2 + (i3 * 1);
            }
            if (this.zzet != null) {
                i += zzaov.zzb(2, this.zzet);
            }
            if (this.zzez != null) {
                i += zzaov.zzag(3, this.zzez.intValue());
            }
            return this.zzfa != null ? i + zzaov.zzag(4, this.zzfa.intValue()) : i;
        }
    }
}
