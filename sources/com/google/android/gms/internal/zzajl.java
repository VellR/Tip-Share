package com.google.android.gms.internal;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class zzajl {
    static final /* synthetic */ boolean $assertionsDisabled = (!zzajl.class.desiredAssertionStatus());
    public static final zzajl aXM = new zzajl();
    private zzakg aXI = zzakp.zzcvt();
    private Integer aXN;
    private zza aXO;
    private zzakm aXP = null;
    private zzaka aXQ = null;
    private zzakm aXR = null;
    private zzaka aXS = null;
    private String aXT = null;

    private enum zza {
        LEFT,
        RIGHT
    }

    public static zzajl zzca(Map<String, Object> map) {
        zzajl zzajl = new zzajl();
        zzajl.aXN = (Integer) map.get("l");
        if (map.containsKey("sp")) {
            zzajl.aXP = zzakn.zzbs(map.get("sp"));
            String str = (String) map.get("sn");
            if (str != null) {
                zzajl.aXQ = zzaka.zzrm(str);
            }
        }
        if (map.containsKey("ep")) {
            zzajl.aXR = zzakn.zzbs(map.get("ep"));
            String str2 = (String) map.get("en");
            if (str2 != null) {
                zzajl.aXS = zzaka.zzrm(str2);
            }
        }
        String str3 = (String) map.get("vf");
        if (str3 != null) {
            zzajl.aXO = str3.equals("l") ? zza.LEFT : zza.RIGHT;
        }
        String str4 = (String) map.get("i");
        if (str4 != null) {
            zzajl.aXI = zzakg.zzrn(str4);
        }
        return zzajl;
    }

    private zzajl zzctt() {
        zzajl zzajl = new zzajl();
        zzajl.aXN = this.aXN;
        zzajl.aXP = this.aXP;
        zzajl.aXQ = this.aXQ;
        zzajl.aXR = this.aXR;
        zzajl.aXS = this.aXS;
        zzajl.aXO = this.aXO;
        zzajl.aXI = this.aXI;
        return zzajl;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzajl zzajl = (zzajl) obj;
        if (this.aXN == null ? zzajl.aXN != null : !this.aXN.equals(zzajl.aXN)) {
            return false;
        }
        if (this.aXI == null ? zzajl.aXI != null : !this.aXI.equals(zzajl.aXI)) {
            return false;
        }
        if (this.aXS == null ? zzajl.aXS != null : !this.aXS.equals(zzajl.aXS)) {
            return false;
        }
        if (this.aXR == null ? zzajl.aXR != null : !this.aXR.equals(zzajl.aXR)) {
            return false;
        }
        if (this.aXQ == null ? zzajl.aXQ != null : !this.aXQ.equals(zzajl.aXQ)) {
            return false;
        }
        if (this.aXP == null ? zzajl.aXP != null : !this.aXP.equals(zzajl.aXP)) {
            return false;
        }
        return zzctu() == zzajl.zzctu();
    }

    public int getLimit() {
        if (zzctq()) {
            return this.aXN.intValue();
        }
        throw new IllegalArgumentException("Cannot get limit if limit has not been set");
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.aXS != null ? this.aXS.hashCode() : 0) + (((this.aXR != null ? this.aXR.hashCode() : 0) + (((this.aXQ != null ? this.aXQ.hashCode() : 0) + (((this.aXP != null ? this.aXP.hashCode() : 0) + (((zzctu() ? 1231 : 1237) + ((this.aXN != null ? this.aXN.intValue() : 0) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.aXI != null) {
            i = this.aXI.hashCode();
        }
        return hashCode + i;
    }

    public boolean isDefault() {
        return zzctw() && this.aXI.equals(zzakp.zzcvt());
    }

    public boolean isValid() {
        return !zzctk() || !zzctn() || !zzctq() || zzctr();
    }

    public String toString() {
        return zzctv().toString();
    }

    public zzajl zza(zzakg zzakg) {
        zzajl zzctt = zzctt();
        zzctt.aXI = zzakg;
        return zzctt;
    }

    public zzajl zza(zzakm zzakm, zzaka zzaka) {
        if ($assertionsDisabled || zzakm.zzcuw() || zzakm.isEmpty()) {
            zzajl zzctt = zzctt();
            zzctt.aXP = zzakm;
            zzctt.aXQ = zzaka;
            return zzctt;
        }
        throw new AssertionError();
    }

    public zzajl zzado(int i) {
        zzajl zzctt = zzctt();
        zzctt.aXN = Integer.valueOf(i);
        zzctt.aXO = zza.LEFT;
        return zzctt;
    }

    public zzajl zzadp(int i) {
        zzajl zzctt = zzctt();
        zzctt.aXN = Integer.valueOf(i);
        zzctt.aXO = zza.RIGHT;
        return zzctt;
    }

    public zzajl zzb(zzakm zzakm, zzaka zzaka) {
        if ($assertionsDisabled || zzakm.zzcuw() || zzakm.isEmpty()) {
            zzajl zzctt = zzctt();
            zzctt.aXR = zzakm;
            zzctt.aXS = zzaka;
            return zzctt;
        }
        throw new AssertionError();
    }

    public boolean zzctk() {
        return this.aXP != null;
    }

    public zzakm zzctl() {
        if (zzctk()) {
            return this.aXP;
        }
        throw new IllegalArgumentException("Cannot get index start value if start has not been set");
    }

    public zzaka zzctm() {
        if (zzctk()) {
            return this.aXQ != null ? this.aXQ : zzaka.zzcup();
        }
        throw new IllegalArgumentException("Cannot get index start name if start has not been set");
    }

    public boolean zzctn() {
        return this.aXR != null;
    }

    public zzakm zzcto() {
        if (zzctn()) {
            return this.aXR;
        }
        throw new IllegalArgumentException("Cannot get index end value if start has not been set");
    }

    public zzaka zzctp() {
        if (zzctn()) {
            return this.aXS != null ? this.aXS : zzaka.zzcuq();
        }
        throw new IllegalArgumentException("Cannot get index end name if start has not been set");
    }

    public boolean zzctq() {
        return this.aXN != null;
    }

    public boolean zzctr() {
        return zzctq() && this.aXO != null;
    }

    public zzakg zzcts() {
        return this.aXI;
    }

    public boolean zzctu() {
        return this.aXO != null ? this.aXO == zza.LEFT : zzctk();
    }

    public Map<String, Object> zzctv() {
        HashMap hashMap = new HashMap();
        if (zzctk()) {
            hashMap.put("sp", this.aXP.getValue());
            if (this.aXQ != null) {
                hashMap.put("sn", this.aXQ.asString());
            }
        }
        if (zzctn()) {
            hashMap.put("ep", this.aXR.getValue());
            if (this.aXS != null) {
                hashMap.put("en", this.aXS.asString());
            }
        }
        if (this.aXN != null) {
            hashMap.put("l", this.aXN);
            zza zza2 = this.aXO;
            if (zza2 == null) {
                zza2 = zzctk() ? zza.LEFT : zza.RIGHT;
            }
            switch (zza2) {
                case LEFT:
                    hashMap.put("vf", "l");
                    break;
                case RIGHT:
                    hashMap.put("vf", "r");
                    break;
            }
        }
        if (!this.aXI.equals(zzakp.zzcvt())) {
            hashMap.put("i", this.aXI.zzcvl());
        }
        return hashMap;
    }

    public boolean zzctw() {
        return !zzctk() && !zzctn() && !zzctq();
    }

    public String zzctx() {
        if (this.aXT == null) {
            try {
                this.aXT = zzalf.zzcb(zzctv());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return this.aXT;
    }

    public zzajt zzcty() {
        return zzctw() ? new zzajr(zzcts()) : zzctq() ? new zzajs(this) : new zzaju(this);
    }
}
