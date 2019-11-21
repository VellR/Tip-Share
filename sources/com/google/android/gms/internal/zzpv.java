package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzg;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

final class zzpv implements zzqm {
    private final Context mContext;
    private final zzqd sX;
    /* access modifiers changed from: private */
    public final zzqf sY;
    /* access modifiers changed from: private */
    public final zzqf sZ;
    private final Map<zzc<?>, zzqf> ta;
    private final Set<zzqy> tb = Collections.newSetFromMap(new WeakHashMap());
    private final zze tc;
    private Bundle td;
    /* access modifiers changed from: private */
    public ConnectionResult te = null;
    /* access modifiers changed from: private */
    public ConnectionResult tf = null;
    /* access modifiers changed from: private */
    public boolean tg = false;
    /* access modifiers changed from: private */
    public final Lock th;
    private int ti = 0;
    private final Looper zzahv;

    private class zza implements com.google.android.gms.internal.zzqm.zza {
        private zza() {
        }

        public void zzc(int i, boolean z) {
            zzpv.this.th.lock();
            try {
                if (zzpv.this.tg || zzpv.this.tf == null || !zzpv.this.tf.isSuccess()) {
                    zzpv.this.tg = false;
                    zzpv.this.zzb(i, z);
                    return;
                }
                zzpv.this.tg = true;
                zzpv.this.sZ.onConnectionSuspended(i);
                zzpv.this.th.unlock();
            } finally {
                zzpv.this.th.unlock();
            }
        }

        public void zzd(@NonNull ConnectionResult connectionResult) {
            zzpv.this.th.lock();
            try {
                zzpv.this.te = connectionResult;
                zzpv.this.zzapb();
            } finally {
                zzpv.this.th.unlock();
            }
        }

        public void zzm(@Nullable Bundle bundle) {
            zzpv.this.th.lock();
            try {
                zzpv.this.zzl(bundle);
                zzpv.this.te = ConnectionResult.qR;
                zzpv.this.zzapb();
            } finally {
                zzpv.this.th.unlock();
            }
        }
    }

    private class zzb implements com.google.android.gms.internal.zzqm.zza {
        private zzb() {
        }

        public void zzc(int i, boolean z) {
            zzpv.this.th.lock();
            try {
                if (zzpv.this.tg) {
                    zzpv.this.tg = false;
                    zzpv.this.zzb(i, z);
                    return;
                }
                zzpv.this.tg = true;
                zzpv.this.sY.onConnectionSuspended(i);
                zzpv.this.th.unlock();
            } finally {
                zzpv.this.th.unlock();
            }
        }

        public void zzd(@NonNull ConnectionResult connectionResult) {
            zzpv.this.th.lock();
            try {
                zzpv.this.tf = connectionResult;
                zzpv.this.zzapb();
            } finally {
                zzpv.this.th.unlock();
            }
        }

        public void zzm(@Nullable Bundle bundle) {
            zzpv.this.th.lock();
            try {
                zzpv.this.tf = ConnectionResult.qR;
                zzpv.this.zzapb();
            } finally {
                zzpv.this.th.unlock();
            }
        }
    }

    private zzpv(Context context, zzqd zzqd, Lock lock, Looper looper, com.google.android.gms.common.zzc zzc, Map<zzc<?>, zze> map, Map<zzc<?>, zze> map2, zzg zzg, com.google.android.gms.common.api.Api.zza<? extends zzvx, zzvy> zza2, zze zze, ArrayList<zzpu> arrayList, ArrayList<zzpu> arrayList2, Map<Api<?>, Integer> map3, Map<Api<?>, Integer> map4) {
        this.mContext = context;
        this.sX = zzqd;
        this.th = lock;
        this.zzahv = looper;
        this.tc = zze;
        this.sY = new zzqf(context, this.sX, lock, looper, zzc, map2, null, map4, null, arrayList2, new zza());
        this.sZ = new zzqf(context, this.sX, lock, looper, zzc, map, zzg, map3, zza2, arrayList, new zzb());
        ArrayMap arrayMap = new ArrayMap();
        for (zzc put : map2.keySet()) {
            arrayMap.put(put, this.sY);
        }
        for (zzc put2 : map.keySet()) {
            arrayMap.put(put2, this.sZ);
        }
        this.ta = Collections.unmodifiableMap(arrayMap);
    }

    public static zzpv zza(Context context, zzqd zzqd, Lock lock, Looper looper, com.google.android.gms.common.zzc zzc, Map<zzc<?>, zze> map, zzg zzg, Map<Api<?>, Integer> map2, com.google.android.gms.common.api.Api.zza<? extends zzvx, zzvy> zza2, ArrayList<zzpu> arrayList) {
        zze zze = null;
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        for (Entry entry : map.entrySet()) {
            zze zze2 = (zze) entry.getValue();
            if (zze2.zzafz()) {
                zze = zze2;
            }
            if (zze2.zzafk()) {
                arrayMap.put((zzc) entry.getKey(), zze2);
            } else {
                arrayMap2.put((zzc) entry.getKey(), zze2);
            }
        }
        zzab.zza(!arrayMap.isEmpty(), (Object) "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        ArrayMap arrayMap3 = new ArrayMap();
        ArrayMap arrayMap4 = new ArrayMap();
        for (Api api : map2.keySet()) {
            zzc zzanp = api.zzanp();
            if (arrayMap.containsKey(zzanp)) {
                arrayMap3.put(api, (Integer) map2.get(api));
            } else if (arrayMap2.containsKey(zzanp)) {
                arrayMap4.put(api, (Integer) map2.get(api));
            } else {
                throw new IllegalStateException("Each API in the apiTypeMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            zzpu zzpu = (zzpu) it.next();
            if (arrayMap3.containsKey(zzpu.pD)) {
                arrayList2.add(zzpu);
            } else if (arrayMap4.containsKey(zzpu.pD)) {
                arrayList3.add(zzpu);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the apiTypeMap");
            }
        }
        return new zzpv(context, zzqd, lock, looper, zzc, arrayMap, arrayMap2, zzg, zza2, zze, arrayList2, arrayList3, arrayMap3, arrayMap4);
    }

    private void zzapa() {
        this.tf = null;
        this.te = null;
        this.sY.connect();
        this.sZ.connect();
    }

    /* access modifiers changed from: private */
    public void zzapb() {
        if (zzc(this.te)) {
            if (zzc(this.tf) || zzape()) {
                zzapc();
            } else if (this.tf == null) {
            } else {
                if (this.ti == 1) {
                    zzapd();
                    return;
                }
                zzb(this.tf);
                this.sY.disconnect();
            }
        } else if (this.te != null && zzc(this.tf)) {
            this.sZ.disconnect();
            zzb(this.te);
        } else if (this.te != null && this.tf != null) {
            ConnectionResult connectionResult = this.te;
            if (this.sZ.uq < this.sY.uq) {
                connectionResult = this.tf;
            }
            zzb(connectionResult);
        }
    }

    private void zzapc() {
        switch (this.ti) {
            case 1:
                break;
            case 2:
                this.sX.zzm(this.td);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                break;
        }
        zzapd();
        this.ti = 0;
    }

    private void zzapd() {
        for (zzqy zzafy : this.tb) {
            zzafy.zzafy();
        }
        this.tb.clear();
    }

    private boolean zzape() {
        return this.tf != null && this.tf.getErrorCode() == 4;
    }

    @Nullable
    private PendingIntent zzapf() {
        if (this.tc == null) {
            return null;
        }
        return PendingIntent.getActivity(this.mContext, this.sX.getSessionId(), this.tc.zzaga(), 134217728);
    }

    /* access modifiers changed from: private */
    public void zzb(int i, boolean z) {
        this.sX.zzc(i, z);
        this.tf = null;
        this.te = null;
    }

    private void zzb(ConnectionResult connectionResult) {
        switch (this.ti) {
            case 1:
                break;
            case 2:
                this.sX.zzd(connectionResult);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        zzapd();
        this.ti = 0;
    }

    private static boolean zzc(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.isSuccess();
    }

    private boolean zze(com.google.android.gms.internal.zzpr.zza<? extends Result, ? extends com.google.android.gms.common.api.Api.zzb> zza2) {
        zzc zzanp = zza2.zzanp();
        zzab.zzb(this.ta.containsKey(zzanp), (Object) "GoogleApiClient is not configured to use the API required for this call.");
        return ((zzqf) this.ta.get(zzanp)).equals(this.sZ);
    }

    /* access modifiers changed from: private */
    public void zzl(Bundle bundle) {
        if (this.td == null) {
            this.td = bundle;
        } else if (bundle != null) {
            this.td.putAll(bundle);
        }
    }

    public ConnectionResult blockingConnect() {
        throw new UnsupportedOperationException();
    }

    public ConnectionResult blockingConnect(long j, @NonNull TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public void connect() {
        this.ti = 2;
        this.tg = false;
        zzapa();
    }

    public void disconnect() {
        this.tf = null;
        this.te = null;
        this.ti = 0;
        this.sY.disconnect();
        this.sZ.disconnect();
        zzapd();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("authClient").println(":");
        this.sZ.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append(str).append("anonClient").println(":");
        this.sY.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    @Nullable
    public ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        return ((zzqf) this.ta.get(api.zzanp())).equals(this.sZ) ? zzape() ? new ConnectionResult(4, zzapf()) : this.sZ.getConnectionResult(api) : this.sY.getConnectionResult(api);
    }

    public boolean isConnected() {
        boolean z = true;
        this.th.lock();
        try {
            if (!this.sY.isConnected() || (!zzaoz() && !zzape() && this.ti != 1)) {
                z = false;
            }
            return z;
        } finally {
            this.th.unlock();
        }
    }

    public boolean isConnecting() {
        this.th.lock();
        try {
            return this.ti == 2;
        } finally {
            this.th.unlock();
        }
    }

    public boolean zza(zzqy zzqy) {
        this.th.lock();
        try {
            if ((isConnecting() || isConnected()) && !zzaoz()) {
                this.tb.add(zzqy);
                if (this.ti == 0) {
                    this.ti = 1;
                }
                this.tf = null;
                this.sZ.connect();
                return true;
            }
            this.th.unlock();
            return false;
        } finally {
            this.th.unlock();
        }
    }

    public void zzaoc() {
        this.th.lock();
        try {
            boolean isConnecting = isConnecting();
            this.sZ.disconnect();
            this.tf = new ConnectionResult(4);
            if (isConnecting) {
                new Handler(this.zzahv).post(new Runnable() {
                    public void run() {
                        zzpv.this.th.lock();
                        try {
                            zzpv.this.zzapb();
                        } finally {
                            zzpv.this.th.unlock();
                        }
                    }
                });
            } else {
                zzapd();
            }
        } finally {
            this.th.unlock();
        }
    }

    public void zzaoy() {
        this.sY.zzaoy();
        this.sZ.zzaoy();
    }

    public boolean zzaoz() {
        return this.sZ.isConnected();
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, R extends Result, T extends com.google.android.gms.internal.zzpr.zza<R, A>> T zzc(@NonNull T t) {
        if (!zze((com.google.android.gms.internal.zzpr.zza<? extends Result, ? extends com.google.android.gms.common.api.Api.zzb>) t)) {
            return this.sY.zzc(t);
        }
        if (!zzape()) {
            return this.sZ.zzc(t);
        }
        t.zzz(new Status(4, null, zzapf()));
        return t;
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, T extends com.google.android.gms.internal.zzpr.zza<? extends Result, A>> T zzd(@NonNull T t) {
        if (!zze((com.google.android.gms.internal.zzpr.zza<? extends Result, ? extends com.google.android.gms.common.api.Api.zzb>) t)) {
            return this.sY.zzd(t);
        }
        if (!zzape()) {
            return this.sZ.zzd(t);
        }
        t.zzz(new Status(4, null, zzapf()));
        return t;
    }
}
