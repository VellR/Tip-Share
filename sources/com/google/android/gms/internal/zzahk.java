package com.google.android.gms.internal;

import com.google.android.gms.internal.zzajy.zza;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.FirebaseDatabase;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

public class zzahk {
    protected FirebaseApp aPM;
    protected zzajy aQZ;
    protected boolean aRa;
    protected String aRc;
    private boolean aTd = false;
    protected zzaho aTr;
    protected zzahg aTs;
    protected zzahw aTt;
    protected String aTu;
    protected zza aTv = zza.INFO;
    private boolean aTw = false;
    private zzahs aTx;
    protected long cacheSize = 10485760;

    private static zzagu zza(final zzahg zzahg) {
        return new zzagu() {
            public void zza(boolean z, final zzagu.zza zza) {
                zzahg.this.zza(z, new zzahg.zza() {
                    public void onError(String str) {
                        zza.onError(str);
                    }

                    public void zzqy(String str) {
                        zza.zzqy(str);
                    }
                });
            }
        };
    }

    private ScheduledExecutorService zzcoc() {
        zzahw zzcqk = zzcqk();
        if (zzcqk instanceof zzali) {
            return ((zzali) zzcqk).zzcoc();
        }
        throw new RuntimeException("Custom run loops are not supported!");
    }

    private zzahs zzcpz() {
        if (this.aTx == null) {
            if (zzald.zzcwp()) {
                zzcqa();
            } else if (zzahp.isActive()) {
                zzahp zzahp = zzahp.INSTANCE;
                zzahp.initialize();
                this.aTx = zzahp;
            } else {
                this.aTx = zzahq.INSTANCE;
            }
        }
        return this.aTx;
    }

    private synchronized void zzcqa() {
        this.aTx = new zzagf(this.aPM);
    }

    private void zzcqd() {
        zzcqn();
        zzcpz();
        zzcqq();
        zzcqp();
        zzcqo();
        zzcqs();
        zzcqr();
    }

    private void zzcqe() {
        this.aTr.restart();
        this.aTt.restart();
    }

    private void zzcqn() {
        if (this.aQZ == null) {
            this.aQZ = zzcpz().zza(this, this.aTv, null);
        }
    }

    private void zzcqo() {
        if (this.aTt == null) {
            this.aTt = this.aTx.zzb(this);
        }
    }

    private void zzcqp() {
        if (this.aTr == null) {
            this.aTr = zzcpz().zza(this);
        }
    }

    private void zzcqq() {
        if (this.aRc == null) {
            this.aRc = zzrj(zzcpz().zzc(this));
        }
    }

    private void zzcqr() {
        if (this.aTs == null) {
            this.aTs = zzcpz().zza(zzcoc());
        }
    }

    private void zzcqs() {
        if (this.aTu == null) {
            this.aTu = "default";
        }
    }

    private String zzrj(String str) {
        return "Firebase/" + "5" + "/" + FirebaseDatabase.getSdkVersion() + "/" + str;
    }

    /* access modifiers changed from: 0000 */
    public void stop() {
        this.aTw = true;
        this.aTr.shutdown();
        this.aTt.shutdown();
    }

    public zzagz zza(zzagx zzagx, zzagz.zza zza) {
        return zzcpz().zza(this, zzcqh(), zzagx, zza);
    }

    public zzajy zzcoa() {
        return this.aQZ;
    }

    public boolean zzcod() {
        return this.aRa;
    }

    public zza zzcpl() {
        return this.aTv;
    }

    /* access modifiers changed from: 0000 */
    public synchronized void zzcpp() {
        if (!this.aTd) {
            this.aTd = true;
            zzcqd();
        }
    }

    public boolean zzcqb() {
        return this.aTd;
    }

    public void zzcqc() {
        if (this.aTw) {
            zzcqe();
            this.aTw = false;
        }
    }

    /* access modifiers changed from: protected */
    public void zzcqf() {
        if (zzcqb()) {
            throw new DatabaseException("Modifications to DatabaseConfig objects must occur before they are in use");
        }
    }

    public List<String> zzcqg() {
        return null;
    }

    public zzagv zzcqh() {
        return new zzagv(zzcoa(), zza(zzcqm()), zzcoc(), zzcod(), FirebaseDatabase.getSdkVersion(), zzsp());
    }

    public long zzcqi() {
        return this.cacheSize;
    }

    public zzaho zzcqj() {
        return this.aTr;
    }

    public zzahw zzcqk() {
        return this.aTt;
    }

    public String zzcql() {
        return this.aTu;
    }

    public zzahg zzcqm() {
        return this.aTs;
    }

    public zzajx zzrh(String str) {
        return new zzajx(this.aQZ, str);
    }

    /* access modifiers changed from: 0000 */
    public zzaiv zzri(String str) {
        if (!this.aRa) {
            return new zzaiu();
        }
        zzaiv zza = this.aTx.zza(this, str);
        if (zza != null) {
            return zza;
        }
        throw new IllegalArgumentException("You have enabled persistence, but persistence is not supported on this platform.");
    }

    public String zzsp() {
        return this.aRc;
    }
}
