package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public final class zzra extends Fragment implements zzqp {
    private static WeakHashMap<FragmentActivity, WeakReference<zzra>> vb = new WeakHashMap<>();
    private Map<String, zzqo> vc = new ArrayMap();
    /* access modifiers changed from: private */
    public Bundle vd;
    /* access modifiers changed from: private */
    public int zzblz = 0;

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        if (r0 != null) goto L_0x0012;
     */
    public static zzra zza(FragmentActivity fragmentActivity) {
        zzra zzra;
        WeakReference weakReference = (WeakReference) vb.get(fragmentActivity);
        if (weakReference != null) {
            zzra = (zzra) weakReference.get();
        }
        try {
            zzra = (zzra) fragmentActivity.getSupportFragmentManager().findFragmentByTag("SupportLifecycleFragmentImpl");
            if (zzra == null || zzra.isRemoving()) {
                zzra = new zzra();
                fragmentActivity.getSupportFragmentManager().beginTransaction().add((Fragment) zzra, "SupportLifecycleFragmentImpl").commitAllowingStateLoss();
            }
            vb.put(fragmentActivity, new WeakReference(zzra));
            return zzra;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e);
        }
    }

    private void zzb(final String str, @NonNull final zzqo zzqo) {
        if (this.zzblz > 0) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    if (zzra.this.zzblz >= 1) {
                        zzqo.onCreate(zzra.this.vd != null ? zzra.this.vd.getBundle(str) : null);
                    }
                    if (zzra.this.zzblz >= 2) {
                        zzqo.onStart();
                    }
                    if (zzra.this.zzblz >= 3) {
                        zzqo.onStop();
                    }
                }
            });
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

    /* renamed from: zzaqr */
    public FragmentActivity zzaqp() {
        return getActivity();
    }
}
