package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.firebase.FirebaseApp;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(14)
public class zzalr implements ActivityLifecycleCallbacks, ComponentCallbacks2 {
    private static final zzalr baU = new zzalr();
    private final AtomicBoolean baV = new AtomicBoolean();
    private boolean zzcwt;

    private zzalr() {
    }

    public static void zza(Application application) {
        application.registerActivityLifecycleCallbacks(baU);
        application.registerComponentCallbacks(baU);
        baU.zzcwt = true;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (this.baV.compareAndSet(true, false)) {
            FirebaseApp.zzck(false);
        }
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        if (this.baV.compareAndSet(true, false)) {
            FirebaseApp.zzck(false);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int i) {
        if (i == 20 && this.baV.compareAndSet(false, true)) {
            FirebaseApp.zzck(true);
        }
    }
}
