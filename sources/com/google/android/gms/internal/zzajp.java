package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class zzajp {
    static final /* synthetic */ boolean $assertionsDisabled = (!zzajp.class.desiredAssertionStatus());
    private static com.google.android.gms.internal.zzajt.zza aYh = new com.google.android.gms.internal.zzajt.zza() {
        public zzakl zza(zzakg zzakg, zzakl zzakl, boolean z) {
            return null;
        }

        public zzakm zzh(zzaka zzaka) {
            return null;
        }
    };
    private final zzajt aYg;

    public static class zza {
        public final zzajo aXZ;
        public final List<zzajg> aYd;

        public zza(zzajo zzajo, List<zzajg> list) {
            this.aXZ = zzajo;
            this.aYd = list;
        }
    }

    private static class zzb implements com.google.android.gms.internal.zzajt.zza {
        private final zzajo aXZ;
        private final zzaij aYj;
        private final zzakm aYk;

        public zzb(zzaij zzaij, zzajo zzajo, zzakm zzakm) {
            this.aYj = zzaij;
            this.aXZ = zzajo;
            this.aYk = zzakm;
        }

        public zzakl zza(zzakg zzakg, zzakl zzakl, boolean z) {
            return this.aYj.zza(this.aYk != null ? this.aYk : this.aXZ.zzcug(), zzakl, z, zzakg);
        }

        public zzakm zzh(zzaka zzaka) {
            zzaje zzcud = this.aXZ.zzcud();
            if (zzcud.zzf(zzaka)) {
                return zzcud.zzcmq().zzm(zzaka);
            }
            return this.aYj.zza(zzaka, this.aYk != null ? new zzaje(zzakh.zza(this.aYk, zzaki.zzcvp()), true, false) : this.aXZ.zzcuf());
        }
    }

    public zzajp(zzajt zzajt) {
        this.aYg = zzajt;
    }

    private zzajo zza(zzajo zzajo, zzahr zzahr, zzahi zzahi, zzaij zzaij, zzakm zzakm, zzajq zzajq) {
        if ($assertionsDisabled || zzahi.zzcpw() == null) {
            Iterator it = zzahi.iterator();
            zzajo zzajo2 = zzajo;
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                zzahr zzh = zzahr.zzh((zzahr) entry.getKey());
                if (zza(zzajo, zzh.zzcrb())) {
                    zzajo2 = zza(zzajo2, zzh, (zzakm) entry.getValue(), zzaij, zzakm, zzajq);
                }
            }
            Iterator it2 = zzahi.iterator();
            while (it2.hasNext()) {
                Entry entry2 = (Entry) it2.next();
                zzahr zzh2 = zzahr.zzh((zzahr) entry2.getKey());
                if (!zza(zzajo, zzh2.zzcrb())) {
                    zzajo2 = zza(zzajo2, zzh2, (zzakm) entry2.getValue(), zzaij, zzakm, zzajq);
                }
            }
            return zzajo2;
        }
        throw new AssertionError("Can't have a merge that is an overwrite");
    }

    private zzajo zza(zzajo zzajo, zzahr zzahr, zzahi zzahi, zzaij zzaij, zzakm zzakm, boolean z, zzajq zzajq) {
        if (zzajo.zzcuf().zzcmq().isEmpty() && !zzajo.zzcuf().zzcsz()) {
            return zzajo;
        }
        if ($assertionsDisabled || zzahi.zzcpw() == null) {
            if (!zzahr.isEmpty()) {
                zzahi = zzahi.zzcpv().zzb(zzahr, zzahi);
            }
            zzakm zzcmq = zzajo.zzcuf().zzcmq();
            Map zzcpy = zzahi.zzcpy();
            zzajo zzajo2 = zzajo;
            for (Entry entry : zzcpy.entrySet()) {
                zzaka zzaka = (zzaka) entry.getKey();
                if (zzcmq.zzk(zzaka)) {
                    zzajo2 = zza(zzajo2, new zzahr(zzaka), ((zzahi) entry.getValue()).zzb(zzcmq.zzm(zzaka)), zzaij, zzakm, z, zzajq);
                }
            }
            for (Entry entry2 : zzcpy.entrySet()) {
                zzaka zzaka2 = (zzaka) entry2.getKey();
                boolean z2 = !zzajo.zzcuf().zzf(zzaka2) && ((zzahi) entry2.getValue()).zzcpw() == null;
                if (!zzcmq.zzk(zzaka2) && !z2) {
                    zzajo2 = zza(zzajo2, new zzahr(zzaka2), ((zzahi) entry2.getValue()).zzb(zzcmq.zzm(zzaka2)), zzaij, zzakm, z, zzajq);
                }
            }
            return zzajo2;
        }
        throw new AssertionError("Can't have a merge that is an overwrite");
    }

    private zzajo zza(zzajo zzajo, zzahr zzahr, zzaij zzaij, com.google.android.gms.internal.zzajt.zza zza2, zzajq zzajq) {
        zzakm zza3;
        zzakh zzctb;
        zzakm zzc;
        zzaje zzcud = zzajo.zzcud();
        if (zzaij.zzv(zzahr) != null) {
            return zzajo;
        }
        if (!zzahr.isEmpty()) {
            zzaka zzcrb = zzahr.zzcrb();
            if (!zzcrb.zzcut()) {
                zzahr zzcrc = zzahr.zzcrc();
                if (zzcud.zzf(zzcrb)) {
                    zzakm zza4 = zzaij.zza(zzahr, zzcud.zzcmq(), zzajo.zzcuf().zzcmq());
                    zza3 = zza4 != null ? zzcud.zzcmq().zzm(zzcrb).zzl(zzcrc, zza4) : zzcud.zzcmq().zzm(zzcrb);
                } else {
                    zza3 = zzaij.zza(zzcrb, zzajo.zzcuf());
                }
                zzctb = zza3 != null ? this.aYg.zza(zzcud.zzctb(), zzcrb, zza3, zzcrc, zza2, zzajq) : zzcud.zzctb();
            } else if ($assertionsDisabled || zzahr.size() == 1) {
                zzakm zza5 = zzaij.zza(zzahr, zzcud.zzcmq(), zzajo.zzcuf().zzcmq());
                zzctb = zza5 != null ? this.aYg.zza(zzcud.zzctb(), zza5) : zzcud.zzctb();
            } else {
                throw new AssertionError("Can't have a priority with additional path components");
            }
        } else if ($assertionsDisabled || zzajo.zzcuf().zzcsz()) {
            if (zzajo.zzcuf().zzcta()) {
                zzakm zzcug = zzajo.zzcug();
                if (!(zzcug instanceof zzakb)) {
                    zzcug = zzakf.zzcvi();
                }
                zzc = zzaij.zzd(zzcug);
            } else {
                zzc = zzaij.zzc(zzajo.zzcug());
            }
            zzctb = this.aYg.zza(zzajo.zzcud().zzctb(), zzakh.zza(zzc, this.aYg.zzcts()), zzajq);
        } else {
            throw new AssertionError("If change path is empty, we must have complete server data");
        }
        return zzajo.zza(zzctb, zzcud.zzcsz() || zzahr.isEmpty(), this.aYg.zzcuj());
    }

    private zzajo zza(zzajo zzajo, zzahr zzahr, zzaja<Boolean> zzaja, zzaij zzaij, zzakm zzakm, zzajq zzajq) {
        if (zzaij.zzv(zzahr) != null) {
            return zzajo;
        }
        boolean zzcta = zzajo.zzcuf().zzcta();
        zzaje zzcuf = zzajo.zzcuf();
        if (zzaja.getValue() == null) {
            zzahi zzcpv = zzahi.zzcpv();
            Iterator it = zzaja.iterator();
            while (it.hasNext()) {
                zzahr zzahr2 = (zzahr) ((Entry) it.next()).getKey();
                zzahr zzh = zzahr.zzh(zzahr2);
                if (zzcuf.zzam(zzh)) {
                    zzcpv = zzcpv.zze(zzahr2, zzcuf.zzcmq().zzao(zzh));
                }
            }
            return zza(zzajo, zzahr, zzcpv, zzaij, zzakm, zzcta, zzajq);
        } else if ((zzahr.isEmpty() && zzcuf.zzcsz()) || zzcuf.zzam(zzahr)) {
            return zza(zzajo, zzahr, zzcuf.zzcmq().zzao(zzahr), zzaij, zzakm, zzcta, zzajq);
        } else if (!zzahr.isEmpty()) {
            return zzajo;
        } else {
            zzahi zzcpv2 = zzahi.zzcpv();
            for (zzakl zzakl : zzcuf.zzcmq()) {
                zzcpv2 = zzcpv2.zza(zzakl.zzcvs(), zzakl.zzcmq());
            }
            return zza(zzajo, zzahr, zzcpv2, zzaij, zzakm, zzcta, zzajq);
        }
    }

    private zzajo zza(zzajo zzajo, zzahr zzahr, zzakm zzakm, zzaij zzaij, zzakm zzakm2, zzajq zzajq) {
        zzakm zzh;
        zzaje zzcud = zzajo.zzcud();
        zzb zzb2 = new zzb(zzaij, zzajo, zzakm2);
        if (zzahr.isEmpty()) {
            return zzajo.zza(this.aYg.zza(zzajo.zzcud().zzctb(), zzakh.zza(zzakm, this.aYg.zzcts()), zzajq), true, this.aYg.zzcuj());
        }
        zzaka zzcrb = zzahr.zzcrb();
        if (zzcrb.zzcut()) {
            return zzajo.zza(this.aYg.zza(zzajo.zzcud().zzctb(), zzakm), zzcud.zzcsz(), zzcud.zzcta());
        }
        zzahr zzcrc = zzahr.zzcrc();
        zzakm zzm = zzcud.zzcmq().zzm(zzcrb);
        if (zzcrc.isEmpty()) {
            zzh = zzakm;
        } else {
            zzh = zzb2.zzh(zzcrb);
            if (zzh == null) {
                zzh = zzakf.zzcvi();
            } else if (!zzcrc.zzcre().zzcut() || !zzh.zzao(zzcrc.zzcrd()).isEmpty()) {
                zzh = zzh.zzl(zzcrc, zzakm);
            }
        }
        return !zzm.equals(zzh) ? zzajo.zza(this.aYg.zza(zzcud.zzctb(), zzcrb, zzh, zzcrc, zzb2, zzajq), zzcud.zzcsz(), this.aYg.zzcuj()) : zzajo;
    }

    private zzajo zza(zzajo zzajo, zzahr zzahr, zzakm zzakm, zzaij zzaij, zzakm zzakm2, boolean z, zzajq zzajq) {
        zzakh zza2;
        zzaje zzcuf = zzajo.zzcuf();
        zzajt zzcui = z ? this.aYg : this.aYg.zzcui();
        if (zzahr.isEmpty()) {
            zza2 = zzcui.zza(zzcuf.zzctb(), zzakh.zza(zzakm, zzcui.zzcts()), null);
        } else if (!zzcui.zzcuj() || zzcuf.zzcta()) {
            zzaka zzcrb = zzahr.zzcrb();
            if (!zzcuf.zzam(zzahr) && zzahr.size() > 1) {
                return zzajo;
            }
            zzahr zzcrc = zzahr.zzcrc();
            zzakm zzl = zzcuf.zzcmq().zzm(zzcrb).zzl(zzcrc, zzakm);
            zza2 = zzcrb.zzcut() ? zzcui.zza(zzcuf.zzctb(), zzl) : zzcui.zza(zzcuf.zzctb(), zzcrb, zzl, zzcrc, aYh, null);
        } else if ($assertionsDisabled || !zzahr.isEmpty()) {
            zzaka zzcrb2 = zzahr.zzcrb();
            zza2 = zzcui.zza(zzcuf.zzctb(), zzcuf.zzctb().zzh(zzcrb2, zzcuf.zzcmq().zzm(zzcrb2).zzl(zzahr.zzcrc(), zzakm)), null);
        } else {
            throw new AssertionError("An empty path should have been caught in the other branch");
        }
        zzajo zzb2 = zzajo.zzb(zza2, zzcuf.zzcsz() || zzahr.isEmpty(), zzcui.zzcuj());
        return zza(zzb2, zzahr, zzaij, (com.google.android.gms.internal.zzajt.zza) new zzb(zzaij, zzb2, zzakm2), zzajq);
    }

    private void zza(zzajo zzajo, zzajo zzajo2, List<zzajg> list) {
        zzaje zzcud = zzajo2.zzcud();
        if (zzcud.zzcsz()) {
            boolean z = zzcud.zzcmq().zzcuw() || zzcud.zzcmq().isEmpty();
            if (!list.isEmpty() || !zzajo.zzcud().zzcsz() || ((z && !zzcud.zzcmq().equals(zzajo.zzcue())) || !zzcud.zzcmq().zzcux().equals(zzajo.zzcue().zzcux()))) {
                list.add(zzajg.zza(zzcud.zzctb()));
            }
        }
    }

    private static boolean zza(zzajo zzajo, zzaka zzaka) {
        return zzajo.zzcud().zzf(zzaka);
    }

    private zzajo zzb(zzajo zzajo, zzahr zzahr, zzaij zzaij, zzakm zzakm, zzajq zzajq) {
        zzaje zzcuf = zzajo.zzcuf();
        return zza(zzajo.zzb(zzcuf.zzctb(), zzcuf.zzcsz() || zzahr.isEmpty(), zzcuf.zzcta()), zzahr, zzaij, aYh, zzajq);
    }

    public zzajo zza(zzajo zzajo, zzahr zzahr, zzaij zzaij, zzakm zzakm, zzajq zzajq) {
        if (zzaij.zzv(zzahr) != null) {
            return zzajo;
        }
        zzb zzb2 = new zzb(zzaij, zzajo, zzakm);
        zzakh zzctb = zzajo.zzcud().zzctb();
        if (zzahr.isEmpty() || zzahr.zzcrb().zzcut()) {
            zzctb = this.aYg.zza(zzctb, zzakh.zza(zzajo.zzcuf().zzcsz() ? zzaij.zzc(zzajo.zzcug()) : zzaij.zzd(zzajo.zzcuf().zzcmq()), this.aYg.zzcts()), zzajq);
        } else {
            zzaka zzcrb = zzahr.zzcrb();
            zzakm zza2 = zzaij.zza(zzcrb, zzajo.zzcuf());
            if (zza2 == null && zzajo.zzcuf().zzf(zzcrb)) {
                zza2 = zzctb.zzcmq().zzm(zzcrb);
            }
            if (zza2 != null) {
                zzctb = this.aYg.zza(zzctb, zzcrb, zza2, zzahr.zzcrc(), zzb2, zzajq);
            } else if (zza2 == null && zzajo.zzcud().zzcmq().zzk(zzcrb)) {
                zzctb = this.aYg.zza(zzctb, zzcrb, zzakf.zzcvi(), zzahr.zzcrc(), zzb2, zzajq);
            }
            if (zzctb.zzcmq().isEmpty() && zzajo.zzcuf().zzcsz()) {
                zzakm zzc = zzaij.zzc(zzajo.zzcug());
                if (zzc.zzcuw()) {
                    zzctb = this.aYg.zza(zzctb, zzakh.zza(zzc, this.aYg.zzcts()), zzajq);
                }
            }
        }
        return zzajo.zza(zzctb, zzajo.zzcuf().zzcsz() || zzaij.zzv(zzahr.zzcqy()) != null, this.aYg.zzcuj());
    }

    public zza zza(zzajo zzajo, zzaio zzaio, zzaij zzaij, zzakm zzakm) {
        zzajo zzb2;
        zzajq zzajq = new zzajq();
        switch (zzaio.zzcsi()) {
            case Overwrite:
                zzaiq zzaiq = (zzaiq) zzaio;
                if (zzaiq.zzcsh().zzcsj()) {
                    zzb2 = zza(zzajo, zzaiq.zzcmu(), zzaiq.zzcsn(), zzaij, zzakm, zzajq);
                    break;
                } else if ($assertionsDisabled || zzaiq.zzcsh().zzcsk()) {
                    zzb2 = zza(zzajo, zzaiq.zzcmu(), zzaiq.zzcsn(), zzaij, zzakm, zzaiq.zzcsh().zzcsl() || (zzajo.zzcuf().zzcta() && !zzaiq.zzcmu().isEmpty()), zzajq);
                    break;
                } else {
                    throw new AssertionError();
                }
            case Merge:
                zzain zzain = (zzain) zzaio;
                if (zzain.zzcsh().zzcsj()) {
                    zzb2 = zza(zzajo, zzain.zzcmu(), zzain.zzcsg(), zzaij, zzakm, zzajq);
                    break;
                } else if ($assertionsDisabled || zzain.zzcsh().zzcsk()) {
                    zzb2 = zza(zzajo, zzain.zzcmu(), zzain.zzcsg(), zzaij, zzakm, zzain.zzcsh().zzcsl() || zzajo.zzcuf().zzcta(), zzajq);
                    break;
                } else {
                    throw new AssertionError();
                }
                break;
            case AckUserWrite:
                zzail zzail = (zzail) zzaio;
                if (zzail.zzcsf()) {
                    zzb2 = zza(zzajo, zzail.zzcmu(), zzaij, zzakm, zzajq);
                    break;
                } else {
                    zzb2 = zza(zzajo, zzail.zzcmu(), zzail.zzcse(), zzaij, zzakm, zzajq);
                    break;
                }
            case ListenComplete:
                zzb2 = zzb(zzajo, zzaio.zzcmu(), zzaij, zzakm, zzajq);
                break;
            default:
                String valueOf = String.valueOf(zzaio.zzcsi());
                throw new AssertionError(new StringBuilder(String.valueOf(valueOf).length() + 19).append("Unknown operation: ").append(valueOf).toString());
        }
        ArrayList arrayList = new ArrayList(zzajq.zzcuh());
        zza(zzajo, zzb2, arrayList);
        return new zza(zzb2, arrayList);
    }
}
