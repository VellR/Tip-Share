package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

@TargetApi(11)
public final class zzqq extends Fragment implements zzqp {
    private static WeakHashMap<Activity, WeakReference<zzqq>> vb = new WeakHashMap<>();
    private Map<String, zzqo> vc = new ArrayMap();
    /* access modifiers changed from: private */
    public Bundle vd;
    /* access modifiers changed from: private */
    public int zzblz = 0;

    private void zzb(final String str, @NonNull final zzqo zzqo) {
        if (this.zzblz > 0) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    if (zzqq.this.zzblz >= 1) {
                        zzqo.onCreate(zzqq.this.vd != null ? zzqq.this.vd.getBundle(str) : null);
                    }
                    if (zzqq.this.zzblz >= 2) {
                        zzqo.onStart();
                    }
                    if (zzqq.this.zzblz >= 3) {
                        zzqo.onStop();
                    }
                }
            });
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        if (r0 != null) goto L_0x0012;
     */
    public static zzqq zzt(Activity activity) {
        zzqq zzqq;
        WeakReference weakReference = (WeakReference) vb.get(activity);
        if (weakReference != null) {
            zzqq = (zzqq) weakReference.get();
        }
        try {
            zzqq = (zzqq) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
            if (zzqq == null || zzqq.isRemoving()) {
                zzqq = new zzqq();
                activity.getFragmentManager().beginTransaction().add(zzqq, "LifecycleFragmentImpl").commitAllowingStateLoss();
            }
            vb.put(activity, new WeakReference(zzqq));
            return zzqq;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e);
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (zzqo dump : this.vc.values()) {
            dump.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (zzqo onActivityResult : this.vc.values()) {
            onActivityResult.onActivityResult(i, i2, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzblz = 1;
        this.vd = bundle;
        for (Entry entry : this.vc.entrySet()) {
            ((zzqo) entry.getValue()).onCreate(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Entry entry : this.vc.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((zzqo) entry.getValue()).onSaveInstanceState(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    public void onStart() {
        super.onStop();
        this.zzblz = 2;
        for (zzqo onStart : this.vc.values()) {
            onStart.onStart();
        }
    }

    public void onStop() {
        super.onStop();
        this.zzblz = 3;
        for (zzqo onStop : this.vc.values()) {
            onStop.onStop();
        }
    }

    public <T extends zzqo> T zza(String str, Class<T> cls) {
        return (zzqo) cls.cast(this.vc.get(str));
    }

    public void zza(String str, @NonNull zzqo zzqo) {
        if (!this.vc.containsKey(str)) {
            this.vc.put(str, zzqo);
            zzb(str, zzqo);
            return;
        }
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 59).append("LifecycleCallback with tag ").append(str).append(" already added to this fragment.").toString());
    }

    public Activity zzaqp() {
        return getActivity();
    }
}
