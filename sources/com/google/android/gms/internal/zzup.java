package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import java.io.IOException;

public interface zzup {

    public static final class zza extends zzapc {
        private static volatile zza[] aoF;
        public Integer anW;
        public zzf aoG;
        public zzf aoH;
        public Boolean aoI;

        public zza() {
            zzbwp();
        }

        public static zza[] zzbwo() {
            if (aoF == null) {
                synchronized (zzapa.bij) {
                    if (aoF == null) {
                        aoF = new zza[0];
                    }
                }
            }
            return aoF;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (this.anW == null) {
                if (zza.anW != null) {
                    return false;
                }
            } else if (!this.anW.equals(zza.anW)) {
                return false;
            }
            if (this.aoG == null) {
                if (zza.aoG != null) {
                    return false;
                }
            } else if (!this.aoG.equals(zza.aoG)) {
                return false;
            }
            if (this.aoH == null) {
                if (zza.aoH != null) {
                    return false;
                }
            } else if (!this.aoH.equals(zza.aoH)) {
                return false;
            }
            return this.aoI == null ? zza.aoI == null : this.aoI.equals(zza.aoI);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.aoH == null ? 0 : this.aoH.hashCode()) + (((this.aoG == null ? 0 : this.aoG.hashCode()) + (((this.anW == null ? 0 : this.anW.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31;
            if (this.aoI != null) {
                i = this.aoI.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzaov zzaov) throws IOException {
            if (this.anW != null) {
                zzaov.zzae(1, this.anW.intValue());
            }
            if (this.aoG != null) {
                zzaov.zza(2, (zzapc) this.aoG);
            }
            if (this.aoH != null) {
                zzaov.zza(3, (zzapc) this.aoH);
            }
            if (this.aoI != null) {
                zzaov.zzj(4, this.aoI.booleanValue());
            }
            super.zza(zzaov);
        }

        /* renamed from: zzbm */
        public zza zzb(zzaou zzaou) throws IOException {
            while (true) {
                int J = zzaou.J();
                switch (J) {
                    case 0:
                        break;
                    case 8:
                        this.anW = Integer.valueOf(zzaou.N());
                        continue;
                    case 18:
                        if (this.aoG == null) {
                            this.aoG = new zzf();
                        }
                        zzaou.zza(this.aoG);
                        continue;
                    case 26:
                        if (this.aoH == null) {
                            this.aoH = new zzf();
                        }
                        zzaou.zza(this.aoH);
                        continue;
                    case 32:
                        this.aoI = Boolean.valueOf(zzaou.P());
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

        public zza zzbwp() {
            this.anW = null;
            this.aoG = null;
            this.aoH = null;
            this.aoI = null;
            this.bik = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            if (this.anW != null) {
                zzy += zzaov.zzag(1, this.anW.intValue());
            }
            if (this.aoG != null) {
                zzy += zzaov.zzc(2, (zzapc) this.aoG);
            }
            if (this.aoH != null) {
                zzy += zzaov.zzc(3, (zzapc) this.aoH);
            }
            return this.aoI != null ? zzy + zzaov.zzk(4, this.aoI.booleanValue()) : zzy;
        }
    }

    public static final class zzb extends zzapc {
        private static volatile zzb[] aoJ;
        public zzc[] aoK;
        public Long aoL;
        public Long aoM;
        public Integer count;
        public String name;

        public zzb() {
            zzbwr();
        }

        public static zzb[] zzbwq() {
            if (aoJ == null) {
                synchronized (zzapa.bij) {
                    if (aoJ == null) {
                        aoJ = new zzb[0];
                    }
                }
            }
            return aoJ;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzb = (zzb) obj;
            if (!zzapa.equals((Object[]) this.aoK, (Object[]) zzb.aoK)) {
                return false;
            }
            if (this.name == null) {
                if (zzb.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzb.name)) {
                return false;
            }
            if (this.aoL == null) {
                if (zzb.aoL != null) {
                    return false;
                }
            } else if (!this.aoL.equals(zzb.aoL)) {
                return false;
            }
            if (this.aoM == null) {
                if (zzb.aoM != null) {
                    return false;
                }
            } else if (!this.aoM.equals(zzb.aoM)) {
                return false;
            }
            return this.count == null ? zzb.count == null : this.count.equals(zzb.count);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.aoM == null ? 0 : this.aoM.hashCode()) + (((this.aoL == null ? 0 : this.aoL.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + zzapa.hashCode((Object[]) this.aoK)) * 31)) * 31)) * 31)) * 31;
            if (this.count != null) {
                i = this.count.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzaov zzaov) throws IOException {
            if (this.aoK != null && this.aoK.length > 0) {
                for (zzc zzc : this.aoK) {
                    if (zzc != null) {
                        zzaov.zza(1, (zzapc) zzc);
                    }
                }
            }
            if (this.name != null) {
                zzaov.zzr(2, this.name);
            }
            if (this.aoL != null) {
                zzaov.zzb(3, this.aoL.longValue());
            }
            if (this.aoM != null) {
                zzaov.zzb(4, this.aoM.longValue());
            }
            if (this.count != null) {
                zzaov.zzae(5, this.count.intValue());
            }
            super.zza(zzaov);
        }

        /* renamed from: zzbn */
        public zzb zzb(zzaou zzaou) throws IOException {
            while (true) {
                int J = zzaou.J();
                switch (J) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzapf.zzc(zzaou, 10);
                        int length = this.aoK == null ? 0 : this.aoK.length;
                        zzc[] zzcArr = new zzc[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.aoK, 0, zzcArr, 0, length);
                        }
                        while (length < zzcArr.length - 1) {
                            zzcArr[length] = new zzc();
                            zzaou.zza(zzcArr[length]);
                            zzaou.J();
                            length++;
                        }
                        zzcArr[length] = new zzc();
                        zzaou.zza(zzcArr[length]);
                        this.aoK = zzcArr;
                        continue;
                    case 18:
                        this.name = zzaou.readString();
                        continue;
                    case 24:
                        this.aoL = Long.valueOf(zzaou.M());
                        continue;
                    case 32:
                        this.aoM = Long.valueOf(zzaou.M());
                        continue;
                    case 40:
                        this.count = Integer.valueOf(zzaou.N());
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

        public zzb zzbwr() {
            this.aoK = zzc.zzbws();
            this.name = null;
            this.aoL = null;
            this.aoM = null;
            this.count = null;
            this.bik = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            if (this.aoK != null && this.aoK.length > 0) {
                for (zzc zzc : this.aoK) {
                    if (zzc != null) {
                        zzy += zzaov.zzc(1, (zzapc) zzc);
                    }
                }
            }
            if (this.name != null) {
                zzy += zzaov.zzs(2, this.name);
            }
            if (this.aoL != null) {
                zzy += zzaov.zze(3, this.aoL.longValue());
            }
            if (this.aoM != null) {
                zzy += zzaov.zze(4, this.aoM.longValue());
            }
            return this.count != null ? zzy + zzaov.zzag(5, this.count.intValue()) : zzy;
        }
    }

    public static final class zzc extends zzapc {
        private static volatile zzc[] aoN;
        public Float anS;
        public Double anT;
        public Long aoO;
        public String name;
        public String zr;

        public zzc() {
            zzbwt();
        }

        public static zzc[] zzbws() {
            if (aoN == null) {
                synchronized (zzapa.bij) {
                    if (aoN == null) {
                        aoN = new zzc[0];
                    }
                }
            }
            return aoN;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc zzc = (zzc) obj;
            if (this.name == null) {
                if (zzc.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzc.name)) {
                return false;
            }
            if (this.zr == null) {
                if (zzc.zr != null) {
                    return false;
                }
            } else if (!this.zr.equals(zzc.zr)) {
                return false;
            }
            if (this.aoO == null) {
                if (zzc.aoO != null) {
                    return false;
                }
            } else if (!this.aoO.equals(zzc.aoO)) {
                return false;
            }
            if (this.anS == null) {
                if (zzc.anS != null) {
                    return false;
                }
            } else if (!this.anS.equals(zzc.anS)) {
                return false;
            }
            return this.anT == null ? zzc.anT == null : this.anT.equals(zzc.anT);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.anS == null ? 0 : this.anS.hashCode()) + (((this.aoO == null ? 0 : this.aoO.hashCode()) + (((this.zr == null ? 0 : this.zr.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.anT != null) {
                i = this.anT.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzaov zzaov) throws IOException {
            if (this.name != null) {
                zzaov.zzr(1, this.name);
            }
            if (this.zr != null) {
                zzaov.zzr(2, this.zr);
            }
            if (this.aoO != null) {
                zzaov.zzb(3, this.aoO.longValue());
            }
            if (this.anS != null) {
                zzaov.zzc(4, this.anS.floatValue());
            }
            if (this.anT != null) {
                zzaov.zza(5, this.anT.doubleValue());
            }
            super.zza(zzaov);
        }

        /* renamed from: zzbo */
        public zzc zzb(zzaou zzaou) throws IOException {
            while (true) {
                int J = zzaou.J();
                switch (J) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzaou.readString();
                        continue;
                    case 18:
                        this.zr = zzaou.readString();
                        continue;
                    case 24:
                        this.aoO = Long.valueOf(zzaou.M());
                        continue;
                    case 37:
                        this.anS = Float.valueOf(zzaou.readFloat());
                        continue;
                    case 41:
                        this.anT = Double.valueOf(zzaou.readDouble());
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

        public zzc zzbwt() {
            this.name = null;
            this.zr = null;
            this.aoO = null;
            this.anS = null;
            this.anT = null;
            this.bik = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            if (this.name != null) {
                zzy += zzaov.zzs(1, this.name);
            }
            if (this.zr != null) {
                zzy += zzaov.zzs(2, this.zr);
            }
            if (this.aoO != null) {
                zzy += zzaov.zze(3, this.aoO.longValue());
            }
            if (this.anS != null) {
                zzy += zzaov.zzd(4, this.anS.floatValue());
            }
            return this.anT != null ? zzy + zzaov.zzb(5, this.anT.doubleValue()) : zzy;
        }
    }

    public static final class zzd extends zzapc {
        public zze[] aoP;

        public zzd() {
            zzbwu();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            return zzapa.equals((Object[]) this.aoP, (Object[]) ((zzd) obj).aoP);
        }

        public int hashCode() {
            return ((getClass().getName().hashCode() + 527) * 31) + zzapa.hashCode((Object[]) this.aoP);
        }

        public void zza(zzaov zzaov) throws IOException {
            if (this.aoP != null && this.aoP.length > 0) {
                for (zze zze : this.aoP) {
                    if (zze != null) {
                        zzaov.zza(1, (zzapc) zze);
                    }
                }
            }
            super.zza(zzaov);
        }

        /* renamed from: zzbp */
        public zzd zzb(zzaou zzaou) throws IOException {
            while (true) {
                int J = zzaou.J();
                switch (J) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzapf.zzc(zzaou, 10);
                        int length = this.aoP == null ? 0 : this.aoP.length;
                        zze[] zzeArr = new zze[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.aoP, 0, zzeArr, 0, length);
                        }
                        while (length < zzeArr.length - 1) {
                            zzeArr[length] = new zze();
                            zzaou.zza(zzeArr[length]);
                            zzaou.J();
                            length++;
                        }
                        zzeArr[length] = new zze();
                        zzaou.zza(zzeArr[length]);
                        this.aoP = zzeArr;
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

        public zzd zzbwu() {
            this.aoP = zze.zzbwv();
            this.bik = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            if (this.aoP != null && this.aoP.length > 0) {
                for (zze zze : this.aoP) {
                    if (zze != null) {
                        zzy += zzaov.zzc(1, (zzapc) zze);
                    }
                }
            }
            return zzy;
        }
    }

    public static final class zze extends zzapc {
        private static volatile zze[] aoQ;
        public String abU;
        public String ajA;
        public String ajD;
        public String ajH;
        public String ajz;
        public Integer aoR;
        public zzb[] aoS;
        public zzg[] aoT;
        public Long aoU;
        public Long aoV;
        public Long aoW;
        public Long aoX;
        public Long aoY;
        public String aoZ;
        public String apa;
        public String apb;
        public Integer apc;
        public Long apd;
        public Long ape;
        public String apf;
        public Boolean apg;
        public String aph;
        public Long api;
        public Integer apj;
        public Boolean apk;
        public zza[] apl;
        public Integer apm;
        public Integer apn;
        public Integer apo;
        public String app;
        public String zzck;
        public String zzct;

        public zze() {
            zzbww();
        }

        public static zze[] zzbwv() {
            if (aoQ == null) {
                synchronized (zzapa.bij) {
                    if (aoQ == null) {
                        aoQ = new zze[0];
                    }
                }
            }
            return aoQ;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze zze = (zze) obj;
            if (this.aoR == null) {
                if (zze.aoR != null) {
                    return false;
                }
            } else if (!this.aoR.equals(zze.aoR)) {
                return false;
            }
            if (!zzapa.equals((Object[]) this.aoS, (Object[]) zze.aoS)) {
                return false;
            }
            if (!zzapa.equals((Object[]) this.aoT, (Object[]) zze.aoT)) {
                return false;
            }
            if (this.aoU == null) {
                if (zze.aoU != null) {
                    return false;
                }
            } else if (!this.aoU.equals(zze.aoU)) {
                return false;
            }
            if (this.aoV == null) {
                if (zze.aoV != null) {
                    return false;
                }
            } else if (!this.aoV.equals(zze.aoV)) {
                return false;
            }
            if (this.aoW == null) {
                if (zze.aoW != null) {
                    return false;
                }
            } else if (!this.aoW.equals(zze.aoW)) {
                return false;
            }
            if (this.aoX == null) {
                if (zze.aoX != null) {
                    return false;
                }
            } else if (!this.aoX.equals(zze.aoX)) {
                return false;
            }
            if (this.aoY == null) {
                if (zze.aoY != null) {
                    return false;
                }
            } else if (!this.aoY.equals(zze.aoY)) {
                return false;
            }
            if (this.aoZ == null) {
                if (zze.aoZ != null) {
                    return false;
                }
            } else if (!this.aoZ.equals(zze.aoZ)) {
                return false;
            }
            if (this.zzct == null) {
                if (zze.zzct != null) {
                    return false;
                }
            } else if (!this.zzct.equals(zze.zzct)) {
                return false;
            }
            if (this.apa == null) {
                if (zze.apa != null) {
                    return false;
                }
            } else if (!this.apa.equals(zze.apa)) {
                return false;
            }
            if (this.apb == null) {
                if (zze.apb != null) {
                    return false;
                }
            } else if (!this.apb.equals(zze.apb)) {
                return false;
            }
            if (this.apc == null) {
                if (zze.apc != null) {
                    return false;
                }
            } else if (!this.apc.equals(zze.apc)) {
                return false;
            }
            if (this.ajA == null) {
                if (zze.ajA != null) {
                    return false;
                }
            } else if (!this.ajA.equals(zze.ajA)) {
                return false;
            }
            if (this.zzck == null) {
                if (zze.zzck != null) {
                    return false;
                }
            } else if (!this.zzck.equals(zze.zzck)) {
                return false;
            }
            if (this.abU == null) {
                if (zze.abU != null) {
                    return false;
                }
            } else if (!this.abU.equals(zze.abU)) {
                return false;
            }
            if (this.apd == null) {
                if (zze.apd != null) {
                    return false;
                }
            } else if (!this.apd.equals(zze.apd)) {
                return false;
            }
            if (this.ape == null) {
                if (zze.ape != null) {
                    return false;
                }
            } else if (!this.ape.equals(zze.ape)) {
                return false;
            }
            if (this.apf == null) {
                if (zze.apf != null) {
                    return false;
                }
            } else if (!this.apf.equals(zze.apf)) {
                return false;
            }
            if (this.apg == null) {
                if (zze.apg != null) {
                    return false;
                }
            } else if (!this.apg.equals(zze.apg)) {
                return false;
            }
            if (this.aph == null) {
                if (zze.aph != null) {
                    return false;
                }
            } else if (!this.aph.equals(zze.aph)) {
                return false;
            }
            if (this.api == null) {
                if (zze.api != null) {
                    return false;
                }
            } else if (!this.api.equals(zze.api)) {
                return false;
            }
            if (this.apj == null) {
                if (zze.apj != null) {
                    return false;
                }
            } else if (!this.apj.equals(zze.apj)) {
                return false;
            }
            if (this.ajD == null) {
                if (zze.ajD != null) {
                    return false;
                }
            } else if (!this.ajD.equals(zze.ajD)) {
                return false;
            }
            if (this.ajz == null) {
                if (zze.ajz != null) {
                    return false;
                }
            } else if (!this.ajz.equals(zze.ajz)) {
                return false;
            }
            if (this.apk == null) {
                if (zze.apk != null) {
                    return false;
                }
            } else if (!this.apk.equals(zze.apk)) {
                return false;
            }
            if (!zzapa.equals((Object[]) this.apl, (Object[]) zze.apl)) {
                return false;
            }
            if (this.ajH == null) {
                if (zze.ajH != null) {
                    return false;
                }
            } else if (!this.ajH.equals(zze.ajH)) {
                return false;
            }
            if (this.apm == null) {
                if (zze.apm != null) {
                    return false;
                }
            } else if (!this.apm.equals(zze.apm)) {
                return false;
            }
            if (this.apn == null) {
                if (zze.apn != null) {
                    return false;
                }
            } else if (!this.apn.equals(zze.apn)) {
                return false;
            }
            if (this.apo == null) {
                if (zze.apo != null) {
                    return false;
                }
            } else if (!this.apo.equals(zze.apo)) {
                return false;
            }
            return this.app == null ? zze.app == null : this.app.equals(zze.app);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.apo == null ? 0 : this.apo.hashCode()) + (((this.apn == null ? 0 : this.apn.hashCode()) + (((this.apm == null ? 0 : this.apm.hashCode()) + (((this.ajH == null ? 0 : this.ajH.hashCode()) + (((((this.apk == null ? 0 : this.apk.hashCode()) + (((this.ajz == null ? 0 : this.ajz.hashCode()) + (((this.ajD == null ? 0 : this.ajD.hashCode()) + (((this.apj == null ? 0 : this.apj.hashCode()) + (((this.api == null ? 0 : this.api.hashCode()) + (((this.aph == null ? 0 : this.aph.hashCode()) + (((this.apg == null ? 0 : this.apg.hashCode()) + (((this.apf == null ? 0 : this.apf.hashCode()) + (((this.ape == null ? 0 : this.ape.hashCode()) + (((this.apd == null ? 0 : this.apd.hashCode()) + (((this.abU == null ? 0 : this.abU.hashCode()) + (((this.zzck == null ? 0 : this.zzck.hashCode()) + (((this.ajA == null ? 0 : this.ajA.hashCode()) + (((this.apc == null ? 0 : this.apc.hashCode()) + (((this.apb == null ? 0 : this.apb.hashCode()) + (((this.apa == null ? 0 : this.apa.hashCode()) + (((this.zzct == null ? 0 : this.zzct.hashCode()) + (((this.aoZ == null ? 0 : this.aoZ.hashCode()) + (((this.aoY == null ? 0 : this.aoY.hashCode()) + (((this.aoX == null ? 0 : this.aoX.hashCode()) + (((this.aoW == null ? 0 : this.aoW.hashCode()) + (((this.aoV == null ? 0 : this.aoV.hashCode()) + (((this.aoU == null ? 0 : this.aoU.hashCode()) + (((((((this.aoR == null ? 0 : this.aoR.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + zzapa.hashCode((Object[]) this.aoS)) * 31) + zzapa.hashCode((Object[]) this.aoT)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + zzapa.hashCode((Object[]) this.apl)) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.app != null) {
                i = this.app.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzaov zzaov) throws IOException {
            if (this.aoR != null) {
                zzaov.zzae(1, this.aoR.intValue());
            }
            if (this.aoS != null && this.aoS.length > 0) {
                for (zzb zzb : this.aoS) {
                    if (zzb != null) {
                        zzaov.zza(2, (zzapc) zzb);
                    }
                }
            }
            if (this.aoT != null && this.aoT.length > 0) {
                for (zzg zzg : this.aoT) {
                    if (zzg != null) {
                        zzaov.zza(3, (zzapc) zzg);
                    }
                }
            }
            if (this.aoU != null) {
                zzaov.zzb(4, this.aoU.longValue());
            }
            if (this.aoV != null) {
                zzaov.zzb(5, this.aoV.longValue());
            }
            if (this.aoW != null) {
                zzaov.zzb(6, this.aoW.longValue());
            }
            if (this.aoY != null) {
                zzaov.zzb(7, this.aoY.longValue());
            }
            if (this.aoZ != null) {
                zzaov.zzr(8, this.aoZ);
            }
            if (this.zzct != null) {
                zzaov.zzr(9, this.zzct);
            }
            if (this.apa != null) {
                zzaov.zzr(10, this.apa);
            }
            if (this.apb != null) {
                zzaov.zzr(11, this.apb);
            }
            if (this.apc != null) {
                zzaov.zzae(12, this.apc.intValue());
            }
            if (this.ajA != null) {
                zzaov.zzr(13, this.ajA);
            }
            if (this.zzck != null) {
                zzaov.zzr(14, this.zzck);
            }
            if (this.abU != null) {
                zzaov.zzr(16, this.abU);
            }
            if (this.apd != null) {
                zzaov.zzb(17, this.apd.longValue());
            }
            if (this.ape != null) {
                zzaov.zzb(18, this.ape.longValue());
            }
            if (this.apf != null) {
                zzaov.zzr(19, this.apf);
            }
            if (this.apg != null) {
                zzaov.zzj(20, this.apg.booleanValue());
            }
            if (this.aph != null) {
                zzaov.zzr(21, this.aph);
            }
            if (this.api != null) {
                zzaov.zzb(22, this.api.longValue());
            }
            if (this.apj != null) {
                zzaov.zzae(23, this.apj.intValue());
            }
            if (this.ajD != null) {
                zzaov.zzr(24, this.ajD);
            }
            if (this.ajz != null) {
                zzaov.zzr(25, this.ajz);
            }
            if (this.aoX != null) {
                zzaov.zzb(26, this.aoX.longValue());
            }
            if (this.apk != null) {
                zzaov.zzj(28, this.apk.booleanValue());
            }
            if (this.apl != null && this.apl.length > 0) {
                for (zza zza : this.apl) {
                    if (zza != null) {
                        zzaov.zza(29, (zzapc) zza);
                    }
                }
            }
            if (this.ajH != null) {
                zzaov.zzr(30, this.ajH);
            }
            if (this.apm != null) {
                zzaov.zzae(31, this.apm.intValue());
            }
            if (this.apn != null) {
                zzaov.zzae(32, this.apn.intValue());
            }
            if (this.apo != null) {
                zzaov.zzae(33, this.apo.intValue());
            }
            if (this.app != null) {
                zzaov.zzr(34, this.app);
            }
            super.zza(zzaov);
        }

        /* renamed from: zzbq */
        public zze zzb(zzaou zzaou) throws IOException {
            while (true) {
                int J = zzaou.J();
                switch (J) {
                    case 0:
                        break;
                    case 8:
                        this.aoR = Integer.valueOf(zzaou.N());
                        continue;
                    case 18:
                        int zzc = zzapf.zzc(zzaou, 18);
                        int length = this.aoS == null ? 0 : this.aoS.length;
                        zzb[] zzbArr = new zzb[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.aoS, 0, zzbArr, 0, length);
                        }
                        while (length < zzbArr.length - 1) {
                            zzbArr[length] = new zzb();
                            zzaou.zza(zzbArr[length]);
                            zzaou.J();
                            length++;
                        }
                        zzbArr[length] = new zzb();
                        zzaou.zza(zzbArr[length]);
                        this.aoS = zzbArr;
                        continue;
                    case 26:
                        int zzc2 = zzapf.zzc(zzaou, 26);
                        int length2 = this.aoT == null ? 0 : this.aoT.length;
                        zzg[] zzgArr = new zzg[(zzc2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.aoT, 0, zzgArr, 0, length2);
                        }
                        while (length2 < zzgArr.length - 1) {
                            zzgArr[length2] = new zzg();
                            zzaou.zza(zzgArr[length2]);
                            zzaou.J();
                            length2++;
                        }
                        zzgArr[length2] = new zzg();
                        zzaou.zza(zzgArr[length2]);
                        this.aoT = zzgArr;
                        continue;
                    case 32:
                        this.aoU = Long.valueOf(zzaou.M());
                        continue;
                    case 40:
                        this.aoV = Long.valueOf(zzaou.M());
                        continue;
                    case 48:
                        this.aoW = Long.valueOf(zzaou.M());
                        continue;
                    case 56:
                        this.aoY = Long.valueOf(zzaou.M());
                        continue;
                    case 66:
                        this.aoZ = zzaou.readString();
                        continue;
                    case 74:
                        this.zzct = zzaou.readString();
                        continue;
                    case 82:
                        this.apa = zzaou.readString();
                        continue;
                    case 90:
                        this.apb = zzaou.readString();
                        continue;
                    case 96:
                        this.apc = Integer.valueOf(zzaou.N());
                        continue;
                    case 106:
                        this.ajA = zzaou.readString();
                        continue;
                    case 114:
                        this.zzck = zzaou.readString();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                        this.abU = zzaou.readString();
                        continue;
                    case 136:
                        this.apd = Long.valueOf(zzaou.M());
                        continue;
                    case 144:
                        this.ape = Long.valueOf(zzaou.M());
                        continue;
                    case 154:
                        this.apf = zzaou.readString();
                        continue;
                    case 160:
                        this.apg = Boolean.valueOf(zzaou.P());
                        continue;
                    case 170:
                        this.aph = zzaou.readString();
                        continue;
                    case 176:
                        this.api = Long.valueOf(zzaou.M());
                        continue;
                    case 184:
                        this.apj = Integer.valueOf(zzaou.N());
                        continue;
                    case 194:
                        this.ajD = zzaou.readString();
                        continue;
                    case 202:
                        this.ajz = zzaou.readString();
                        continue;
                    case 208:
                        this.aoX = Long.valueOf(zzaou.M());
                        continue;
                    case 224:
                        this.apk = Boolean.valueOf(zzaou.P());
                        continue;
                    case 234:
                        int zzc3 = zzapf.zzc(zzaou, 234);
                        int length3 = this.apl == null ? 0 : this.apl.length;
                        zza[] zzaArr = new zza[(zzc3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.apl, 0, zzaArr, 0, length3);
                        }
                        while (length3 < zzaArr.length - 1) {
                            zzaArr[length3] = new zza();
                            zzaou.zza(zzaArr[length3]);
                            zzaou.J();
                            length3++;
                        }
                        zzaArr[length3] = new zza();
                        zzaou.zza(zzaArr[length3]);
                        this.apl = zzaArr;
                        continue;
                    case 242:
                        this.ajH = zzaou.readString();
                        continue;
                    case 248:
                        this.apm = Integer.valueOf(zzaou.N());
                        continue;
                    case 256:
                        this.apn = Integer.valueOf(zzaou.N());
                        continue;
                    case 264:
                        this.apo = Integer.valueOf(zzaou.N());
                        continue;
                    case 274:
                        this.app = zzaou.readString();
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

        public zze zzbww() {
            this.aoR = null;
            this.aoS = zzb.zzbwq();
            this.aoT = zzg.zzbwy();
            this.aoU = null;
            this.aoV = null;
            this.aoW = null;
            this.aoX = null;
            this.aoY = null;
            this.aoZ = null;
            this.zzct = null;
            this.apa = null;
            this.apb = null;
            this.apc = null;
            this.ajA = null;
            this.zzck = null;
            this.abU = null;
            this.apd = null;
            this.ape = null;
            this.apf = null;
            this.apg = null;
            this.aph = null;
            this.api = null;
            this.apj = null;
            this.ajD = null;
            this.ajz = null;
            this.apk = null;
            this.apl = zza.zzbwo();
            this.ajH = null;
            this.apm = null;
            this.apn = null;
            this.apo = null;
            this.app = null;
            this.bik = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            if (this.aoR != null) {
                zzy += zzaov.zzag(1, this.aoR.intValue());
            }
            if (this.aoS != null && this.aoS.length > 0) {
                int i = zzy;
                for (zzb zzb : this.aoS) {
                    if (zzb != null) {
                        i += zzaov.zzc(2, (zzapc) zzb);
                    }
                }
                zzy = i;
            }
            if (this.aoT != null && this.aoT.length > 0) {
                int i2 = zzy;
                for (zzg zzg : this.aoT) {
                    if (zzg != null) {
                        i2 += zzaov.zzc(3, (zzapc) zzg);
                    }
                }
                zzy = i2;
            }
            if (this.aoU != null) {
                zzy += zzaov.zze(4, this.aoU.longValue());
            }
            if (this.aoV != null) {
                zzy += zzaov.zze(5, this.aoV.longValue());
            }
            if (this.aoW != null) {
                zzy += zzaov.zze(6, this.aoW.longValue());
            }
            if (this.aoY != null) {
                zzy += zzaov.zze(7, this.aoY.longValue());
            }
            if (this.aoZ != null) {
                zzy += zzaov.zzs(8, this.aoZ);
            }
            if (this.zzct != null) {
                zzy += zzaov.zzs(9, this.zzct);
            }
            if (this.apa != null) {
                zzy += zzaov.zzs(10, this.apa);
            }
            if (this.apb != null) {
                zzy += zzaov.zzs(11, this.apb);
            }
            if (this.apc != null) {
                zzy += zzaov.zzag(12, this.apc.intValue());
            }
            if (this.ajA != null) {
                zzy += zzaov.zzs(13, this.ajA);
            }
            if (this.zzck != null) {
                zzy += zzaov.zzs(14, this.zzck);
            }
            if (this.abU != null) {
                zzy += zzaov.zzs(16, this.abU);
            }
            if (this.apd != null) {
                zzy += zzaov.zze(17, this.apd.longValue());
            }
            if (this.ape != null) {
                zzy += zzaov.zze(18, this.ape.longValue());
            }
            if (this.apf != null) {
                zzy += zzaov.zzs(19, this.apf);
            }
            if (this.apg != null) {
                zzy += zzaov.zzk(20, this.apg.booleanValue());
            }
            if (this.aph != null) {
                zzy += zzaov.zzs(21, this.aph);
            }
            if (this.api != null) {
                zzy += zzaov.zze(22, this.api.longValue());
            }
            if (this.apj != null) {
                zzy += zzaov.zzag(23, this.apj.intValue());
            }
            if (this.ajD != null) {
                zzy += zzaov.zzs(24, this.ajD);
            }
            if (this.ajz != null) {
                zzy += zzaov.zzs(25, this.ajz);
            }
            if (this.aoX != null) {
                zzy += zzaov.zze(26, this.aoX.longValue());
            }
            if (this.apk != null) {
                zzy += zzaov.zzk(28, this.apk.booleanValue());
            }
            if (this.apl != null && this.apl.length > 0) {
                for (zza zza : this.apl) {
                    if (zza != null) {
                        zzy += zzaov.zzc(29, (zzapc) zza);
                    }
                }
            }
            if (this.ajH != null) {
                zzy += zzaov.zzs(30, this.ajH);
            }
            if (this.apm != null) {
                zzy += zzaov.zzag(31, this.apm.intValue());
            }
            if (this.apn != null) {
                zzy += zzaov.zzag(32, this.apn.intValue());
            }
            if (this.apo != null) {
                zzy += zzaov.zzag(33, this.apo.intValue());
            }
            return this.app != null ? zzy + zzaov.zzs(34, this.app) : zzy;
        }
    }

    public static final class zzf extends zzapc {
        public long[] apq;
        public long[] apr;

        public zzf() {
            zzbwx();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzf)) {
                return false;
            }
            zzf zzf = (zzf) obj;
            if (!zzapa.equals(this.apq, zzf.apq)) {
                return false;
            }
            return zzapa.equals(this.apr, zzf.apr);
        }

        public int hashCode() {
            return ((((getClass().getName().hashCode() + 527) * 31) + zzapa.hashCode(this.apq)) * 31) + zzapa.hashCode(this.apr);
        }

        public void zza(zzaov zzaov) throws IOException {
            if (this.apq != null && this.apq.length > 0) {
                for (long zza : this.apq) {
                    zzaov.zza(1, zza);
                }
            }
            if (this.apr != null && this.apr.length > 0) {
                for (long zza2 : this.apr) {
                    zzaov.zza(2, zza2);
                }
            }
            super.zza(zzaov);
        }

        /* renamed from: zzbr */
        public zzf zzb(zzaou zzaou) throws IOException {
            while (true) {
                int J = zzaou.J();
                switch (J) {
                    case 0:
                        break;
                    case 8:
                        int zzc = zzapf.zzc(zzaou, 8);
                        int length = this.apq == null ? 0 : this.apq.length;
                        long[] jArr = new long[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.apq, 0, jArr, 0, length);
                        }
                        while (length < jArr.length - 1) {
                            jArr[length] = zzaou.L();
                            zzaou.J();
                            length++;
                        }
                        jArr[length] = zzaou.L();
                        this.apq = jArr;
                        continue;
                    case 10:
                        int zzaei = zzaou.zzaei(zzaou.S());
                        int position = zzaou.getPosition();
                        int i = 0;
                        while (zzaou.X() > 0) {
                            zzaou.L();
                            i++;
                        }
                        zzaou.zzaek(position);
                        int length2 = this.apq == null ? 0 : this.apq.length;
                        long[] jArr2 = new long[(i + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.apq, 0, jArr2, 0, length2);
                        }
                        while (length2 < jArr2.length) {
                            jArr2[length2] = zzaou.L();
                            length2++;
                        }
                        this.apq = jArr2;
                        zzaou.zzaej(zzaei);
                        continue;
                    case 16:
                        int zzc2 = zzapf.zzc(zzaou, 16);
                        int length3 = this.apr == null ? 0 : this.apr.length;
                        long[] jArr3 = new long[(zzc2 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.apr, 0, jArr3, 0, length3);
                        }
                        while (length3 < jArr3.length - 1) {
                            jArr3[length3] = zzaou.L();
                            zzaou.J();
                            length3++;
                        }
                        jArr3[length3] = zzaou.L();
                        this.apr = jArr3;
                        continue;
                    case 18:
                        int zzaei2 = zzaou.zzaei(zzaou.S());
                        int position2 = zzaou.getPosition();
                        int i2 = 0;
                        while (zzaou.X() > 0) {
                            zzaou.L();
                            i2++;
                        }
                        zzaou.zzaek(position2);
                        int length4 = this.apr == null ? 0 : this.apr.length;
                        long[] jArr4 = new long[(i2 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.apr, 0, jArr4, 0, length4);
                        }
                        while (length4 < jArr4.length) {
                            jArr4[length4] = zzaou.L();
                            length4++;
                        }
                        this.apr = jArr4;
                        zzaou.zzaej(zzaei2);
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

        public zzf zzbwx() {
            this.apq = zzapf.bin;
            this.apr = zzapf.bin;
            this.bik = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int i;
            int zzy = super.zzy();
            if (this.apq == null || this.apq.length <= 0) {
                i = zzy;
            } else {
                int i2 = 0;
                for (long zzcv : this.apq) {
                    i2 += zzaov.zzcv(zzcv);
                }
                i = zzy + i2 + (this.apq.length * 1);
            }
            if (this.apr == null || this.apr.length <= 0) {
                return i;
            }
            int i3 = 0;
            for (long zzcv2 : this.apr) {
                i3 += zzaov.zzcv(zzcv2);
            }
            return i + i3 + (this.apr.length * 1);
        }
    }

    public static final class zzg extends zzapc {
        private static volatile zzg[] aps;
        public Float anS;
        public Double anT;
        public Long aoO;
        public Long apt;
        public String name;
        public String zr;

        public zzg() {
            zzbwz();
        }

        public static zzg[] zzbwy() {
            if (aps == null) {
                synchronized (zzapa.bij) {
                    if (aps == null) {
                        aps = new zzg[0];
                    }
                }
            }
            return aps;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzg)) {
                return false;
            }
            zzg zzg = (zzg) obj;
            if (this.apt == null) {
                if (zzg.apt != null) {
                    return false;
                }
            } else if (!this.apt.equals(zzg.apt)) {
                return false;
            }
            if (this.name == null) {
                if (zzg.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzg.name)) {
                return false;
            }
            if (this.zr == null) {
                if (zzg.zr != null) {
                    return false;
                }
            } else if (!this.zr.equals(zzg.zr)) {
                return false;
            }
            if (this.aoO == null) {
                if (zzg.aoO != null) {
                    return false;
                }
            } else if (!this.aoO.equals(zzg.aoO)) {
                return false;
            }
            if (this.anS == null) {
                if (zzg.anS != null) {
                    return false;
                }
            } else if (!this.anS.equals(zzg.anS)) {
                return false;
            }
            return this.anT == null ? zzg.anT == null : this.anT.equals(zzg.anT);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.anS == null ? 0 : this.anS.hashCode()) + (((this.aoO == null ? 0 : this.aoO.hashCode()) + (((this.zr == null ? 0 : this.zr.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + (((this.apt == null ? 0 : this.apt.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.anT != null) {
                i = this.anT.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzaov zzaov) throws IOException {
            if (this.apt != null) {
                zzaov.zzb(1, this.apt.longValue());
            }
            if (this.name != null) {
                zzaov.zzr(2, this.name);
            }
            if (this.zr != null) {
                zzaov.zzr(3, this.zr);
            }
            if (this.aoO != null) {
                zzaov.zzb(4, this.aoO.longValue());
            }
            if (this.anS != null) {
                zzaov.zzc(5, this.anS.floatValue());
            }
            if (this.anT != null) {
                zzaov.zza(6, this.anT.doubleValue());
            }
            super.zza(zzaov);
        }

        /* renamed from: zzbs */
        public zzg zzb(zzaou zzaou) throws IOException {
            while (true) {
                int J = zzaou.J();
                switch (J) {
                    case 0:
                        break;
                    case 8:
                        this.apt = Long.valueOf(zzaou.M());
                        continue;
                    case 18:
                        this.name = zzaou.readString();
                        continue;
                    case 26:
                        this.zr = zzaou.readString();
                        continue;
                    case 32:
                        this.aoO = Long.valueOf(zzaou.M());
                        continue;
                    case 45:
                        this.anS = Float.valueOf(zzaou.readFloat());
                        continue;
                    case 49:
                        this.anT = Double.valueOf(zzaou.readDouble());
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

        public zzg zzbwz() {
            this.apt = null;
            this.name = null;
            this.zr = null;
            this.aoO = null;
            this.anS = null;
            this.anT = null;
            this.bik = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzy() {
            int zzy = super.zzy();
            if (this.apt != null) {
                zzy += zzaov.zze(1, this.apt.longValue());
            }
            if (this.name != null) {
                zzy += zzaov.zzs(2, this.name);
            }
            if (this.zr != null) {
                zzy += zzaov.zzs(3, this.zr);
            }
            if (this.aoO != null) {
                zzy += zzaov.zze(4, this.aoO.longValue());
            }
            if (this.anS != null) {
                zzy += zzaov.zzd(5, this.anS.floatValue());
            }
            return this.anT != null ? zzy + zzaov.zzb(6, this.anT.doubleValue()) : zzy;
        }
    }
}
