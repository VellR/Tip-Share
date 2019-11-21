package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.BinderThread;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.signin.internal.SignInResponse;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public class zzqb implements zzqe {
    /* access modifiers changed from: private */
    public final Context mContext;
    private final com.google.android.gms.common.api.Api.zza<? extends zzvx, zzvy> rY;
    /* access modifiers changed from: private */
    public zzq tA;
    private boolean tB;
    private boolean tC;
    private final zzg tD;
    private final Map<Api<?>, Integer> tE;
    private ArrayList<Future<?>> tF = new ArrayList<>();
    /* access modifiers changed from: private */
    public final Lock th;
    /* access modifiers changed from: private */
    public final zzqf tm;
    /* access modifiers changed from: private */
    public final com.google.android.gms.common.zzc tp;
    private ConnectionResult tq;
    private int tr;
    private int ts = 0;
    private int tt;
    private final Bundle tu = new Bundle();
    private final Set<com.google.android.gms.common.api.Api.zzc> tv = new HashSet();
    /* access modifiers changed from: private */
    public zzvx tw;
    private int tx;
    /* access modifiers changed from: private */
    public boolean ty;
    private boolean tz;

    private static class zza implements com.google.android.gms.common.internal.zzd.zzf {
        private final Api<?> pD;
        /* access modifiers changed from: private */
        public final int sV;
        private final WeakReference<zzqb> tH;

        public zza(zzqb zzqb, Api<?> api, int i) {
            this.tH = new WeakReference<>(zzqb);
            this.pD = api;
            this.sV = i;
        }

        public void zzh(@NonNull ConnectionResult connectionResult) {
            boolean z = false;
            zzqb zzqb = (zzqb) this.tH.get();
            if (zzqb != null) {
                if (Looper.myLooper() == zzqb.tm.sX.getLooper()) {
                    z = true;
                }
                zzab.zza(z, (Object) "onReportServiceBinding must be called on the GoogleApiClient handler thread");
                zzqb.th.lock();
                try {
                    if (zzqb.zzfg(0)) {
                        if (!connectionResult.isSuccess()) {
                            zzqb.zzb(connectionResult, this.pD, this.sV);
                        }
                        if (zzqb.zzapj()) {
                            zzqb.zzapk();
                        }
                        zzqb.th.unlock();
                    }
                } finally {
                    zzqb.th.unlock();
                }
            }
        }
    }

    private class zzb extends zzf {
        private final Map<com.google.android.gms.common.api.Api.zze, zza> tI;

        public zzb(Map<com.google.android.gms.common.api.Api.zze, zza> map) {
            super();
            this.tI = map;
        }

        @WorkerThread
        public void zzapi() {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4 = true;
            int i = 0;
            Iterator it = this.tI.keySet().iterator();
            boolean z5 = true;
            boolean z6 = false;
            while (true) {
                if (!it.hasNext()) {
                    z4 = z6;
                    z = false;
                    break;
                }
                com.google.android.gms.common.api.Api.zze zze = (com.google.android.gms.common.api.Api.zze) it.next();
                if (!zze.zzanr()) {
                    z3 = false;
                    z2 = z6;
                } else if (((zza) this.tI.get(zze)).sV == 0) {
                    z = true;
                    break;
                } else {
                    z3 = z5;
                    z2 = true;
                }
                z6 = z2;
                z5 = z3;
            }
            if (z4) {
                i = zzqb.this.tp.isGooglePlayServicesAvailable(zzqb.this.mContext);
            }
            if (i == 0 || (!z && !z5)) {
                if (zzqb.this.ty) {
                    zzqb.this.tw.connect();
                }
                for (com.google.android.gms.common.api.Api.zze zze2 : this.tI.keySet()) {
                    final com.google.android.gms.common.internal.zzd.zzf zzf = (com.google.android.gms.common.internal.zzd.zzf) this.tI.get(zze2);
                    if (!zze2.zzanr() || i == 0) {
                        zze2.zza(zzf);
                    } else {
                        zzqb.this.tm.zza((zza) new zza(zzqb.this) {
                            public void zzapi() {
                                zzf.zzh(new ConnectionResult(16, null));
                            }
                        });
                    }
                }
                return;
            }
            final ConnectionResult connectionResult = new ConnectionResult(i, null);
            zzqb.this.tm.zza((zza) new zza(zzqb.this) {
                public void zzapi() {
                    zzqb.this.zzg(connectionResult);
                }
            });
        }
    }

    private class zzc extends zzf {
        private final ArrayList<com.google.android.gms.common.api.Api.zze> tM;

        public zzc(ArrayList<com.google.android.gms.common.api.Api.zze> arrayList) {
            super();
            this.tM = arrayList;
        }

        @WorkerThread
        public void zzapi() {
            zzqb.this.tm.sX.tZ = zzqb.this.zzapp();
            Iterator it = this.tM.iterator();
            while (it.hasNext()) {
                ((com.google.android.gms.common.api.Api.zze) it.next()).zza(zzqb.this.tA, zzqb.this.tm.sX.tZ);
            }
        }
    }

    private static class zzd extends com.google.android.gms.signin.internal.zzb {
        private final WeakReference<zzqb> tH;

        zzd(zzqb zzqb) {
            this.tH = new WeakReference<>(zzqb);
        }

        @BinderThread
        public void zzb(final SignInResponse signInResponse) {
            final zzqb zzqb = (zzqb) this.tH.get();
            if (zzqb != null) {
                zzqb.tm.zza((zza) new zza(zzqb) {
                    public void zzapi() {
                        zzqb.zza(signInResponse);
                    }
                });
            }
        }
    }

    private class zze implements ConnectionCallbacks, OnConnectionFailedListener {
        private zze() {
        }

        public void onConnected(Bundle bundle) {
            zzqb.this.tw.zza(new zzd(zzqb.this));
        }

        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            zzqb.this.th.lock();
            try {
                if (zzqb.this.zzf(connectionResult)) {
                    zzqb.this.zzapn();
                    zzqb.this.zzapk();
                } else {
                    zzqb.this.zzg(connectionResult);
                }
            } finally {
                zzqb.this.th.unlock();
            }
        }

        public void onConnectionSuspended(int i) {
        }
    }

    private abstract class zzf implements Runnable {
        private zzf() {
        }

        @WorkerThread
        public void run() {
            zzqb.this.th.lock();
            try {
                if (!Thread.interrupted()) {
                    zzapi();
                    zzqb.this.th.unlock();
                }
            } catch (RuntimeException e) {
                zzqb.this.tm.zza(e);
            } finally {
                zzqb.this.th.unlock();
            }
        }

        /* access modifiers changed from: protected */
        @WorkerThread
        public abstract void zzapi();
    }

    public zzqb(zzqf zzqf, zzg zzg, Map<Api<?>, Integer> map, com.google.android.gms.common.zzc zzc2, com.google.android.gms.common.api.Api.zza<? extends zzvx, zzvy> zza2, Lock lock, Context context) {
        this.tm = zzqf;
        this.tD = zzg;
        this.tE = map;
        this.tp = zzc2;
        this.rY = zza2;
        this.th = lock;
        this.mContext = context;
    }

    /* access modifiers changed from: private */
    public void zza(SignInResponse signInResponse) {
        if (zzfg(0)) {
            ConnectionResult zzatd = signInResponse.zzatd();
            if (zzatd.isSuccess()) {
                ResolveAccountResponse zzbzv = signInResponse.zzbzv();
                ConnectionResult zzatd2 = zzbzv.zzatd();
                if (!zzatd2.isSuccess()) {
                    String valueOf = String.valueOf(zzatd2);
                    Log.wtf("GoogleApiClientConnecting", new StringBuilder(String.valueOf(valueOf).length() + 48).append("Sign-in succeeded with resolve account failure: ").append(valueOf).toString(), new Exception());
                    zzg(zzatd2);
                    return;
                }
                this.tz = true;
                this.tA = zzbzv.zzatc();
                this.tB = zzbzv.zzate();
                this.tC = zzbzv.zzatf();
                zzapk();
            } else if (zzf(zzatd)) {
                zzapn();
                zzapk();
            } else {
                zzg(zzatd);
            }
        }
    }

    private boolean zza(int i, int i2, ConnectionResult connectionResult) {
        if (i2 != 1 || zze(connectionResult)) {
            return this.tq == null || i < this.tr;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public boolean zzapj() {
        this.tt--;
        if (this.tt > 0) {
            return false;
        }
        if (this.tt < 0) {
            Log.i("GoogleApiClientConnecting", this.tm.sX.zzapv());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            zzg(new ConnectionResult(8, null));
            return false;
        } else if (this.tq == null) {
            return true;
        } else {
            this.tm.uq = this.tr;
            zzg(this.tq);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void zzapk() {
        if (this.tt == 0) {
            if (!this.ty || this.tz) {
                zzapl();
            }
        }
    }

    private void zzapl() {
        ArrayList arrayList = new ArrayList();
        this.ts = 1;
        this.tt = this.tm.tY.size();
        for (com.google.android.gms.common.api.Api.zzc zzc2 : this.tm.tY.keySet()) {
            if (!this.tm.un.containsKey(zzc2)) {
                arrayList.add((com.google.android.gms.common.api.Api.zze) this.tm.tY.get(zzc2));
            } else if (zzapj()) {
                zzapm();
            }
        }
        if (!arrayList.isEmpty()) {
            this.tF.add(zzqg.zzapz().submit(new zzc(arrayList)));
        }
    }

    private void zzapm() {
        this.tm.zzapx();
        zzqg.zzapz().execute(new Runnable() {
            public void run() {
                zzqb.this.tp.zzbp(zzqb.this.mContext);
            }
        });
        if (this.tw != null) {
            if (this.tB) {
                this.tw.zza(this.tA, this.tC);
            }
            zzbl(false);
        }
        for (com.google.android.gms.common.api.Api.zzc zzc2 : this.tm.un.keySet()) {
            ((com.google.android.gms.common.api.Api.zze) this.tm.tY.get(zzc2)).disconnect();
        }
        this.tm.ur.zzm(this.tu.isEmpty() ? null : this.tu);
    }

    /* access modifiers changed from: private */
    public void zzapn() {
        this.ty = false;
        this.tm.sX.tZ = Collections.emptySet();
        for (com.google.android.gms.common.api.Api.zzc zzc2 : this.tv) {
            if (!this.tm.un.containsKey(zzc2)) {
                this.tm.un.put(zzc2, new ConnectionResult(17, null));
            }
        }
    }

    private void zzapo() {
        Iterator it = this.tF.iterator();
        while (it.hasNext()) {
            ((Future) it.next()).cancel(true);
        }
        this.tF.clear();
    }

    /* access modifiers changed from: private */
    public Set<Scope> zzapp() {
        if (this.tD == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(this.tD.zzasf());
        Map zzash = this.tD.zzash();
        for (Api api : zzash.keySet()) {
            if (!this.tm.un.containsKey(api.zzanp())) {
                hashSet.addAll(((com.google.android.gms.common.internal.zzg.zza) zzash.get(api)).dY);
            }
        }
        return hashSet;
    }

    /* access modifiers changed from: private */
    public void zzb(ConnectionResult connectionResult, Api<?> api, int i) {
        if (i != 2) {
            int priority = api.zzanm().getPriority();
            if (zza(priority, i, connectionResult)) {
                this.tq = connectionResult;
                this.tr = priority;
            }
        }
        this.tm.un.put(api.zzanp(), connectionResult);
    }

    private void zzbl(boolean z) {
        if (this.tw != null) {
            if (this.tw.isConnected() && z) {
                this.tw.zzbzk();
            }
            this.tw.disconnect();
            this.tA = null;
        }
    }

    private boolean zze(ConnectionResult connectionResult) {
        return connectionResult.hasResolution() || this.tp.zzfa(connectionResult.getErrorCode()) != null;
    }

    /* access modifiers changed from: private */
    public boolean zzf(ConnectionResult connectionResult) {
        if (this.tx != 2) {
            return this.tx == 1 && !connectionResult.hasResolution();
        }
        return true;
    }

    /* access modifiers changed from: private */
    public boolean zzfg(int i) {
        if (this.ts == i) {
            return true;
        }
        Log.i("GoogleApiClientConnecting", this.tm.sX.zzapv());
        String valueOf = String.valueOf(this);
        Log.i("GoogleApiClientConnecting", new StringBuilder(String.valueOf(valueOf).length() + 23).append("Unexpected callback in ").append(valueOf).toString());
        Log.i("GoogleApiClientConnecting", "mRemainingConnections=" + this.tt);
        String valueOf2 = String.valueOf(zzfh(this.ts));
        String valueOf3 = String.valueOf(zzfh(i));
        Log.wtf("GoogleApiClientConnecting", new StringBuilder(String.valueOf(valueOf2).length() + 70 + String.valueOf(valueOf3).length()).append("GoogleApiClient connecting is in step ").append(valueOf2).append(" but received callback for step ").append(valueOf3).toString(), new Exception());
        zzg(new ConnectionResult(8, null));
        return false;
    }

    private String zzfh(int i) {
        switch (i) {
            case 0:
                return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
            case 1:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    /* access modifiers changed from: private */
    public void zzg(ConnectionResult connectionResult) {
        zzapo();
        zzbl(!connectionResult.hasResolution());
        this.tm.zzi(connectionResult);
        this.tm.ur.zzd(connectionResult);
    }

    public void begin() {
        this.tm.un.clear();
        this.ty = false;
        this.tq = null;
        this.ts = 0;
        this.tx = 2;
        this.tz = false;
        this.tB = false;
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (Api api : this.tE.keySet()) {
            com.google.android.gms.common.api.Api.zze zze2 = (com.google.android.gms.common.api.Api.zze) this.tm.tY.get(api.zzanp());
            int intValue = ((Integer) this.tE.get(api)).intValue();
            boolean z2 = (api.zzanm().getPriority() == 1) | z;
            if (zze2.zzafk()) {
                this.ty = true;
                if (intValue < this.tx) {
                    this.tx = intValue;
                }
                if (intValue != 0) {
                    this.tv.add(api.zzanp());
                }
            }
            hashMap.put(zze2, new zza(this, api, intValue));
            z = z2;
        }
        if (z) {
            this.ty = false;
        }
        if (this.ty) {
            this.tD.zzc(Integer.valueOf(this.tm.sX.getSessionId()));
            zze zze3 = new zze();
            this.tw = (zzvx) this.rY.zza(this.mContext, this.tm.sX.getLooper(), this.tD, this.tD.zzasl(), zze3, zze3);
        }
        this.tt = this.tm.tY.size();
        this.tF.add(zzqg.zzapz().submit(new zzb(hashMap)));
    }

    public void connect() {
    }

    public boolean disconnect() {
        zzapo();
        zzbl(true);
        this.tm.zzi(null);
        return true;
    }

    public void onConnected(Bundle bundle) {
        if (zzfg(1)) {
            if (bundle != null) {
                this.tu.putAll(bundle);
            }
            if (zzapj()) {
                zzapm();
            }
        }
    }

    public void onConnectionSuspended(int i) {
        zzg(new ConnectionResult(8, null));
    }

    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
        if (zzfg(1)) {
            zzb(connectionResult, api, i);
            if (zzapj()) {
                zzapm();
            }
        }
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, R extends Result, T extends com.google.android.gms.internal.zzpr.zza<R, A>> T zzc(T t) {
        this.tm.sX.tS.add(t);
        return t;
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, T extends com.google.android.gms.internal.zzpr.zza<? extends Result, A>> T zzd(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
