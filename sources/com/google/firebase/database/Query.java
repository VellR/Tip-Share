package com.google.firebase.database;

import com.google.android.gms.internal.zzahh;
import com.google.android.gms.internal.zzahm;
import com.google.android.gms.internal.zzahr;
import com.google.android.gms.internal.zzaht;
import com.google.android.gms.internal.zzaih;
import com.google.android.gms.internal.zzaik;
import com.google.android.gms.internal.zzajl;
import com.google.android.gms.internal.zzajm;
import com.google.android.gms.internal.zzajz;
import com.google.android.gms.internal.zzaka;
import com.google.android.gms.internal.zzake;
import com.google.android.gms.internal.zzakf;
import com.google.android.gms.internal.zzaki;
import com.google.android.gms.internal.zzakm;
import com.google.android.gms.internal.zzako;
import com.google.android.gms.internal.zzakp;
import com.google.android.gms.internal.zzakq;
import com.google.android.gms.internal.zzaks;
import com.google.android.gms.internal.zzakt;
import com.google.android.gms.internal.zzalo;
import com.google.android.gms.internal.zzalp;

public class Query {
    static final /* synthetic */ boolean $assertionsDisabled = (!Query.class.desiredAssertionStatus());
    protected final zzajl aPC;
    private final boolean aPD;
    protected final zzaht aPr;
    protected final zzahr aPz;

    Query(zzaht zzaht, zzahr zzahr) {
        this.aPr = zzaht;
        this.aPz = zzahr;
        this.aPC = zzajl.aXM;
        this.aPD = false;
    }

    Query(zzaht zzaht, zzahr zzahr, zzajl zzajl, boolean z) throws DatabaseException {
        this.aPr = zzaht;
        this.aPz = zzahr;
        this.aPC = zzajl;
        this.aPD = z;
        zzalo.zzb(zzajl.isValid(), "Validation of queries failed.");
    }

    private Query zza(zzakm zzakm, String str) {
        zzalp.zzsb(str);
        if (!zzakm.zzcuw() && !zzakm.isEmpty()) {
            throw new IllegalArgumentException("Can only use simple values for startAt()");
        } else if (this.aPC.zzctk()) {
            throw new IllegalArgumentException("Can't call startAt() or equalTo() multiple times");
        } else {
            zzajl zza = this.aPC.zza(zzakm, str != null ? zzaka.zzrm(str) : null);
            zzb(zza);
            zza(zza);
            if ($assertionsDisabled || zza.isValid()) {
                return new Query(this.aPr, this.aPz, zza, this.aPD);
            }
            throw new AssertionError();
        }
    }

    private void zza(final zzahm zzahm) {
        zzaik.zzcsd().zzk(zzahm);
        this.aPr.zzr(new Runnable() {
            public void run() {
                Query.this.aPr.zze(zzahm);
            }
        });
    }

    private void zza(zzajl zzajl) {
        if (zzajl.zzcts().equals(zzaki.zzcvp())) {
            String str = "You must use startAt(String value), endAt(String value) or equalTo(String value) in combination with orderByKey(). Other type of values or using the version with 2 parameters is not supported";
            if (zzajl.zzctk()) {
                zzakm zzctl = zzajl.zzctl();
                if (zzajl.zzctm() != zzaka.zzcup() || !(zzctl instanceof zzaks)) {
                    throw new IllegalArgumentException(str);
                }
            }
            if (zzajl.zzctn()) {
                zzakm zzcto = zzajl.zzcto();
                if (zzajl.zzctp() != zzaka.zzcuq() || !(zzcto instanceof zzaks)) {
                    throw new IllegalArgumentException(str);
                }
            }
        } else if (!zzajl.zzcts().equals(zzakp.zzcvt())) {
        } else {
            if ((zzajl.zzctk() && !zzakq.zzp(zzajl.zzctl())) || (zzajl.zzctn() && !zzakq.zzp(zzajl.zzcto()))) {
                throw new IllegalArgumentException("When using orderByPriority(), values provided to startAt(), endAt(), or equalTo() must be valid priorities.");
            }
        }
    }

    private Query zzb(zzakm zzakm, String str) {
        zzalp.zzsb(str);
        if (zzakm.zzcuw() || zzakm.isEmpty()) {
            zzaka zzaka = str != null ? zzaka.zzrm(str) : null;
            if (this.aPC.zzctn()) {
                throw new IllegalArgumentException("Can't call endAt() or equalTo() multiple times");
            }
            zzajl zzb = this.aPC.zzb(zzakm, zzaka);
            zzb(zzb);
            zza(zzb);
            if ($assertionsDisabled || zzb.isValid()) {
                return new Query(this.aPr, this.aPz, zzb, this.aPD);
            }
            throw new AssertionError();
        }
        throw new IllegalArgumentException("Can only use simple values for endAt()");
    }

    private void zzb(final zzahm zzahm) {
        zzaik.zzcsd().zzi(zzahm);
        this.aPr.zzr(new Runnable() {
            public void run() {
                Query.this.aPr.zzf(zzahm);
            }
        });
    }

    private void zzb(zzajl zzajl) {
        if (zzajl.zzctk() && zzajl.zzctn() && zzajl.zzctq() && !zzajl.zzctr()) {
            throw new IllegalArgumentException("Can't combine startAt(), endAt() and limit(). Use limitToFirst() or limitToLast() instead");
        }
    }

    private void zzcms() {
        if (this.aPC.zzctk()) {
            throw new IllegalArgumentException("Can't call equalTo() and startAt() combined");
        } else if (this.aPC.zzctn()) {
            throw new IllegalArgumentException("Can't call equalTo() and endAt() combined");
        }
    }

    private void zzcmt() {
        if (this.aPD) {
            throw new IllegalArgumentException("You can't combine multiple orderBy calls!");
        }
    }

    public ChildEventListener addChildEventListener(ChildEventListener childEventListener) {
        zzb((zzahm) new zzahh(this.aPr, childEventListener, zzcmv()));
        return childEventListener;
    }

    public void addListenerForSingleValueEvent(final ValueEventListener valueEventListener) {
        zzb((zzahm) new zzaih(this.aPr, new ValueEventListener() {
            public void onCancelled(DatabaseError databaseError) {
                valueEventListener.onCancelled(databaseError);
            }

            public void onDataChange(DataSnapshot dataSnapshot) {
                Query.this.removeEventListener((ValueEventListener) this);
                valueEventListener.onDataChange(dataSnapshot);
            }
        }, zzcmv()));
    }

    public ValueEventListener addValueEventListener(ValueEventListener valueEventListener) {
        zzb((zzahm) new zzaih(this.aPr, valueEventListener, zzcmv()));
        return valueEventListener;
    }

    public Query endAt(double d) {
        return endAt(d, (String) null);
    }

    public Query endAt(double d, String str) {
        return zzb(new zzake(Double.valueOf(d), zzakq.zzcvu()), str);
    }

    public Query endAt(String str) {
        return endAt(str, (String) null);
    }

    public Query endAt(String str, String str2) {
        return zzb(str != null ? new zzaks(str, zzakq.zzcvu()) : zzakf.zzcvi(), str2);
    }

    public Query endAt(boolean z) {
        return endAt(z, (String) null);
    }

    public Query endAt(boolean z, String str) {
        return zzb(new zzajz(Boolean.valueOf(z), zzakq.zzcvu()), str);
    }

    public Query equalTo(double d) {
        zzcms();
        return startAt(d).endAt(d);
    }

    public Query equalTo(double d, String str) {
        zzcms();
        return startAt(d, str).endAt(d, str);
    }

    public Query equalTo(String str) {
        zzcms();
        return startAt(str).endAt(str);
    }

    public Query equalTo(String str, String str2) {
        zzcms();
        return startAt(str, str2).endAt(str, str2);
    }

    public Query equalTo(boolean z) {
        zzcms();
        return startAt(z).endAt(z);
    }

    public Query equalTo(boolean z, String str) {
        zzcms();
        return startAt(z, str).endAt(z, str);
    }

    public DatabaseReference getRef() {
        return new DatabaseReference(this.aPr, zzcmu());
    }

    public void keepSynced(final boolean z) {
        if (this.aPz.isEmpty() || !this.aPz.zzcrb().equals(zzaka.zzcus())) {
            this.aPr.zzr(new Runnable() {
                public void run() {
                    Query.this.aPr.zza(Query.this.zzcmv(), z);
                }
            });
            return;
        }
        throw new DatabaseException("Can't call keepSynced() on .info paths.");
    }

    public Query limitToFirst(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Limit must be a positive integer!");
        } else if (!this.aPC.zzctq()) {
            return new Query(this.aPr, this.aPz, this.aPC.zzado(i), this.aPD);
        } else {
            throw new IllegalArgumentException("Can't call limitToLast on query with previously set limit!");
        }
    }

    public Query limitToLast(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Limit must be a positive integer!");
        } else if (!this.aPC.zzctq()) {
            return new Query(this.aPr, this.aPz, this.aPC.zzadp(i), this.aPD);
        } else {
            throw new IllegalArgumentException("Can't call limitToLast on query with previously set limit!");
        }
    }

    public Query orderByChild(String str) {
        if (str == null) {
            throw new NullPointerException("Key can't be null");
        } else if (str.equals("$key") || str.equals(".key")) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 54).append("Can't use '").append(str).append("' as path, please use orderByKey() instead!").toString());
        } else if (str.equals("$priority") || str.equals(".priority")) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 59).append("Can't use '").append(str).append("' as path, please use orderByPriority() instead!").toString());
        } else if (str.equals("$value") || str.equals(".value")) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 56).append("Can't use '").append(str).append("' as path, please use orderByValue() instead!").toString());
        } else {
            zzalp.zzrx(str);
            zzcmt();
            zzahr zzahr = new zzahr(str);
            if (zzahr.size() == 0) {
                throw new IllegalArgumentException("Can't use empty path, use orderByValue() instead!");
            }
            return new Query(this.aPr, this.aPz, this.aPC.zza(new zzako(zzahr)), true);
        }
    }

    public Query orderByKey() {
        zzcmt();
        zzajl zza = this.aPC.zza(zzaki.zzcvp());
        zza(zza);
        return new Query(this.aPr, this.aPz, zza, true);
    }

    public Query orderByPriority() {
        zzcmt();
        zzajl zza = this.aPC.zza(zzakp.zzcvt());
        zza(zza);
        return new Query(this.aPr, this.aPz, zza, true);
    }

    public Query orderByValue() {
        zzcmt();
        return new Query(this.aPr, this.aPz, this.aPC.zza(zzakt.zzcvv()), true);
    }

    public void removeEventListener(ChildEventListener childEventListener) {
        if (childEventListener == null) {
            throw new NullPointerException("listener must not be null");
        }
        zza((zzahm) new zzahh(this.aPr, childEventListener, zzcmv()));
    }

    public void removeEventListener(ValueEventListener valueEventListener) {
        if (valueEventListener == null) {
            throw new NullPointerException("listener must not be null");
        }
        zza((zzahm) new zzaih(this.aPr, valueEventListener, zzcmv()));
    }

    public Query startAt(double d) {
        return startAt(d, (String) null);
    }

    public Query startAt(double d, String str) {
        return zza(new zzake(Double.valueOf(d), zzakq.zzcvu()), str);
    }

    public Query startAt(String str) {
        return startAt(str, (String) null);
    }

    public Query startAt(String str, String str2) {
        return zza(str != null ? new zzaks(str, zzakq.zzcvu()) : zzakf.zzcvi(), str2);
    }

    public Query startAt(boolean z) {
        return startAt(z, (String) null);
    }

    public Query startAt(boolean z, String str) {
        return zza(new zzajz(Boolean.valueOf(z), zzakq.zzcvu()), str);
    }

    public zzahr zzcmu() {
        return this.aPz;
    }

    public zzajm zzcmv() {
        return new zzajm(this.aPz, this.aPC);
    }
}
