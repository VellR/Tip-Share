package com.google.android.gms.internal;

import android.app.Activity;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class zzamc {
    private static final zzamc bdC = new zzamc();
    private final Map<Object, zza> bdD = new HashMap();
    private final Object bdE = new Object();

    private static class zza {
        @NonNull
        private final Object bdF;
        @NonNull
        private final Activity mActivity;
        @NonNull
        private final Runnable zzw;

        public zza(@NonNull Activity activity, @NonNull Runnable runnable, @NonNull Object obj) {
            this.mActivity = activity;
            this.zzw = runnable;
            this.bdF = obj;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            return zza.bdF.equals(this.bdF) && zza.zzw == this.zzw && zza.mActivity == this.mActivity;
        }

        @NonNull
        public Activity getActivity() {
            return this.mActivity;
        }

        public int hashCode() {
            return this.bdF.hashCode();
        }

        @NonNull
        public Runnable zzcjq() {
            return this.zzw;
        }

        @NonNull
        public Object zzcyt() {
            return this.bdF;
        }
    }

    private static class zzb extends zzqo {
        private final List<zza> mListeners = new ArrayList();

        private zzb(zzqp zzqp) {
            super(zzqp);
            this.va.zza("StorageOnStopCallback", (zzqo) this);
        }

        public static zzb zzw(Activity activity) {
            zzqp zzc = zzc(new zzqn(activity));
            zzb zzb = (zzb) zzc.zza("StorageOnStopCallback", zzb.class);
            return zzb == null ? new zzb(zzc) : zzb;
        }

        @MainThread
        public void onStop() {
            ArrayList arrayList;
            synchronized (this.mListeners) {
                arrayList = new ArrayList(this.mListeners);
                this.mListeners.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                zza zza = (zza) it.next();
                if (zza != null) {
                    Log.d("StorageOnStopCallback", "removing subscription from activity.");
                    zza.zzcjq().run();
                    zzamc.zzcys().zzci(zza.zzcyt());
                }
            }
        }

        public void zza(zza zza) {
            synchronized (this.mListeners) {
                this.mListeners.add(zza);
            }
        }

        public void zzb(zza zza) {
            synchronized (this.mListeners) {
                this.mListeners.remove(zza);
            }
        }
    }

    private zzamc() {
    }

    @NonNull
    public static zzamc zzcys() {
        return bdC;
    }

    public void zza(@NonNull Activity activity, @NonNull Object obj, @NonNull Runnable runnable) {
        synchronized (this.bdE) {
            zza zza2 = new zza(activity, runnable, obj);
            zzb.zzw(activity).zza(zza2);
            this.bdD.put(obj, zza2);
        }
    }

    public void zzci(@NonNull Object obj) {
        synchronized (this.bdE) {
            zza zza2 = (zza) this.bdD.get(obj);
            if (zza2 != null) {
                zzb.zzw(zza2.getActivity()).zzb(zza2);
            }
        }
    }
}
