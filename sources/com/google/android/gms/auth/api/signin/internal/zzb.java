package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzqy;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class zzb extends AsyncTaskLoader<Void> implements zzqy {
    private Semaphore eb = new Semaphore(0);
    private Set<GoogleApiClient> ec;

    public zzb(Context context, Set<GoogleApiClient> set) {
        super(context);
        this.ec = set;
    }

    /* access modifiers changed from: protected */
    public void onStartLoading() {
        this.eb.drainPermits();
        forceLoad();
    }

    /* renamed from: zzafx */
    public Void loadInBackground() {
        int i;
        int i2 = 0;
        Iterator it = this.ec.iterator();
        while (true) {
            i = i2;
            if (it.hasNext()) {
                i2 = ((GoogleApiClient) it.next()).zza((zzqy) this) ? i + 1 : i;
            } else {
                try {
                    break;
                } catch (InterruptedException e) {
                    Log.i("GACSignInLoader", "Unexpected InterruptedException", e);
                    Thread.currentThread().interrupt();
                }
            }
        }
        this.eb.tryAcquire(i, 5, TimeUnit.SECONDS);
        return null;
    }

    public void zzafy() {
        this.eb.release();
    }
}
